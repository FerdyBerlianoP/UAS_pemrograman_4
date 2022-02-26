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
import com.nyoba.uas.model.PostPutDelMinuman;
import com.nyoba.uas.rest.ApiClient;
import com.nyoba.uas.rest.ApiInterfaceMinuman;

public class EditActivityMinuman extends AppCompatActivity {
    EditText edtId, edtMinuman, edtHarga;
    Button btUpdate, btDelete, btBack;
    ApiInterfaceMinuman mApiInterfaceMinuman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_minuman);
        edtId = (EditText) findViewById(R.id.edtId);
        edtMinuman = (EditText) findViewById(R.id.edtMinuman);
        edtHarga = (EditText) findViewById(R.id.edtHargam);

        Intent mIntent = getIntent();
        edtId.setText(mIntent.getStringExtra("Id"));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtMinuman.setText(mIntent.getStringExtra("Minuman"));
        edtHarga.setText(mIntent.getStringExtra("Harga"));
        mApiInterfaceMinuman = ApiClient.getClient().create(ApiInterfaceMinuman.class);

        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btUpdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Call<PostPutDelMinuman> updateMinumanCall = mApiInterfaceMinuman.putMinuman(
                        edtId.getText().toString(),
                        edtMinuman.getText().toString(),
                        edtHarga.getText().toString());
                updateMinumanCall.enqueue(new Callback<PostPutDelMinuman>(){
                    @Override
                    public void onResponse(Call<PostPutDelMinuman> call, Response<PostPutDelMinuman> response) {
                        MainActivityMinuman.ma.refresh();
                        finish();
                    }
                    @Override
                    public void onFailure(Call<PostPutDelMinuman> call, Throwable t) {
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
                    Call<PostPutDelMinuman> deleteMinuman = mApiInterfaceMinuman.deleteMinuman(edtId.getText().toString());
                    deleteMinuman.enqueue(new Callback<PostPutDelMinuman>() {
                        @Override
                        public void onResponse(Call<PostPutDelMinuman>call, Response<PostPutDelMinuman> response) {
                            MainActivityMinuman.ma.refresh();
                            finish();
                        }
                        @Override
                        public void onFailure(Call<PostPutDelMinuman> call, Throwable t) {
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
                MainActivityMinuman.ma.refresh();
                finish();
            }
        });
    }
}