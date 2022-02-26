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
import com.nyoba.uas.model.PostPutDelMakanan;
import com.nyoba.uas.rest.ApiClient;
import com.nyoba.uas.rest.ApiInterface;

public class EditActivityMakanan extends AppCompatActivity {
    EditText edtId, edtMakanan, edtHarga;
    Button btUpdate, btDelete, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_makanan);
        edtId = (EditText) findViewById(R.id.edtId);
        edtMakanan = (EditText) findViewById(R.id.edtMakanan);
        edtHarga = (EditText) findViewById(R.id.edtHarga);

        Intent mIntent = getIntent();
        edtId.setText(mIntent.getStringExtra("id_Makanan"));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtMakanan.setText(mIntent.getStringExtra("nama_Makanan"));
        edtHarga.setText(mIntent.getStringExtra("harga_Makanan"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btUpdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Call<PostPutDelMakanan> updateMakananCall = mApiInterface.putMakanan(
                        edtId.getText().toString(),
                        edtMakanan.getText().toString(),
                        edtHarga.getText().toString());
                updateMakananCall.enqueue(new Callback<PostPutDelMakanan>(){
                    @Override
                    public void onResponse(Call<PostPutDelMakanan> call, Response<PostPutDelMakanan> response) {
                        MainActivityMakanan.ma.refresh();
                        finish();
                    }
                    @Override
                    public void onFailure(Call<PostPutDelMakanan> call, Throwable t) {
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
                    Call<PostPutDelMakanan> deleteMakanan = mApiInterface.deleteMakanan(edtId.getText().toString());
                    deleteMakanan.enqueue(new Callback<PostPutDelMakanan>() {
                        @Override
                        public void onResponse(Call<PostPutDelMakanan>call, Response<PostPutDelMakanan> response) {
                            MainActivityMakanan.ma.refresh();
                            finish();
                        }
                        @Override
                        public void onFailure(Call<PostPutDelMakanan> call, Throwable t) {
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
                MainActivityMakanan.ma.refresh();
                finish();
            }
        });
    }
}