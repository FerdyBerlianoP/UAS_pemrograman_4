package com.nyoba.uas.activityweb;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nyoba.uas.R;
import com.nyoba.uas.model.PostPutDelPembeli;
import com.nyoba.uas.rest.ApiClient;
import com.nyoba.uas.rest.ApiInterfacePembeli;

public class InsertActivityPembeli extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_pembeli);
        EditText edtPembeli, edtHarga;
        Button btInsert, btBack;
        ApiInterfacePembeli mApiInterfacePembeli;
        edtPembeli = (EditText) findViewById(R.id.edtPembeli);
        edtHarga = (EditText) findViewById(R.id.edtHarga);
        mApiInterfacePembeli = ApiClient.getClient().create(ApiInterfacePembeli.class);
        btInsert = (Button) findViewById(R.id.btInsertingPembeli);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelPembeli> postPembeliCall =
                        mApiInterfacePembeli.postPembeli(edtPembeli.getText().toString());
                postPembeliCall.enqueue(new Callback<PostPutDelPembeli>()
                {
                    @Override
                    public void onResponse(Call<PostPutDelPembeli> call,
                                           Response<PostPutDelPembeli> response) {
                        MainActivityPembeli.ma.refresh();
                        finish();
                    }
                    @Override
                    public void onFailure(Call<PostPutDelPembeli> call,
                                          Throwable t) {
                        Toast.makeText(getApplicationContext(),
                                "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btBack = (Button) findViewById(R.id.btBackGoPembeli);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPembeli.ma.refresh();
                finish();
            }
        });
    }
}
