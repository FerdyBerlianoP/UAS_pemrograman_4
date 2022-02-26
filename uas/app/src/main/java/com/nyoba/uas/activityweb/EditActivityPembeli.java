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
import com.nyoba.uas.model.PostPutDelPembeli;
import com.nyoba.uas.rest.ApiClient;
import com.nyoba.uas.rest.ApiInterfacePembeli;

public class EditActivityPembeli extends AppCompatActivity {
    EditText edtId, edtNama;
    Button btUpdate, btDelete, btBack;
    ApiInterfacePembeli mApiInterfacePembeli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pembeli);
        edtId = (EditText) findViewById(R.id.edtId);
        edtNama = (EditText) findViewById(R.id.edtPembeli);

        Intent mIntent = getIntent();
        edtId.setText(mIntent.getStringExtra("Id"));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtNama.setText(mIntent.getStringExtra("Nama"));
        mApiInterfacePembeli = ApiClient.getClient().create(ApiInterfacePembeli.class);

        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btUpdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Call<PostPutDelPembeli> updatePembeliCall = mApiInterfacePembeli.putPembeli(
                        edtId.getText().toString(),
                        edtNama.getText().toString());
                updatePembeliCall.enqueue(new Callback<PostPutDelPembeli>(){
                    @Override
                    public void onResponse(Call<PostPutDelPembeli> call, Response<PostPutDelPembeli> response) {
                        MainActivityPembeli.ma.refresh();
                        finish();
                    }
                    @Override
                    public void onFailure(Call<PostPutDelPembeli> call, Throwable t) {
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
                    Call<PostPutDelPembeli> deletePembeli = mApiInterfacePembeli.deletePembeli(edtId.getText().toString());
                    deletePembeli.enqueue(new Callback<PostPutDelPembeli>() {
                        @Override
                        public void onResponse(Call<PostPutDelPembeli>call, Response<PostPutDelPembeli> response) {
                            MainActivityPembeli.ma.refresh();
                            finish();
                        }
                        @Override
                        public void onFailure(Call<PostPutDelPembeli> call, Throwable t) {
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
                MainActivityPembeli.ma.refresh();
                finish();
            }
        });
    }
}