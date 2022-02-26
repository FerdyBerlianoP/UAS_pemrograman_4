package com.nyoba.uas.activityweb;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nyoba.uas.R;
import com.nyoba.uas.model.PostPutDelPesan;
import com.nyoba.uas.rest.ApiClient;
import com.nyoba.uas.rest.ApiInterfacePesan;

public class EditActivityPesan extends AppCompatActivity {
    EditText edtId, edtPembeli, edtMakanan, edtMinuman;
    Button btUpdate, btDelete, btBack;
    ApiInterfacePesan mApiInterfacePesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pesan);
        edtId = (EditText) findViewById(R.id.edtId);
        edtPembeli = (EditText) findViewById(R.id.edtPesan);
        edtMakanan = (EditText) findViewById(R.id.edtMakanan2);
        edtMinuman = (EditText) findViewById(R.id.edtMinuman2);

        Intent mIntent = getIntent();
        edtId.setText(mIntent.getStringExtra("Id"));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtPembeli.setText(mIntent.getStringExtra("Pembeli"));
        edtMakanan.setText(mIntent.getStringExtra("Makanan"));
        edtMinuman.setText(mIntent.getStringExtra("Minuman"));
        mApiInterfacePesan = ApiClient.getClient().create(ApiInterfacePesan.class);

        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btUpdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Call<PostPutDelPesan> updatePesanCall = mApiInterfacePesan.putPesan(
                        edtId.getText().toString(),
                        edtPembeli.getText().toString(),
                        edtMakanan.getText().toString(),
                        edtMinuman.getText().toString());
                updatePesanCall.enqueue(new Callback<PostPutDelPesan>(){
                    @Override
                    public void onResponse(Call<PostPutDelPesan> call, Response<PostPutDelPesan> response) {
                        MainActivityPesan.ma.refresh();
                        finish();
                    }
                    @Override
                    public void onFailure(Call<PostPutDelPesan> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),
                                "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btDelete = (Button) findViewById(R.id.btDelete2);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtId.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelPesan> deletePesan = mApiInterfacePesan.deletePesan(edtId.getText().toString());
                    deletePesan.enqueue(new Callback<PostPutDelPesan>() {
                        @Override
                        public void onResponse(Call<PostPutDelPesan>call, Response<PostPutDelPesan> response) {
                            MainActivityPesan.ma.refresh();
                            finish();
                        }
                        @Override
                        public void onFailure(Call<PostPutDelPesan> call, Throwable t) {
                            Toast.makeText(getApplicationContext(),"Error", Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(), "Error",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        btBack = (Button) findViewById(R.id.btBackGo);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPesan.ma.refresh();
                finish();
            }
        });
    }
}