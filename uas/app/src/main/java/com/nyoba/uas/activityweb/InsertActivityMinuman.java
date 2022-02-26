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
import com.nyoba.uas.model.PostPutDelMinuman;
import com.nyoba.uas.rest.ApiClient;
import com.nyoba.uas.rest.ApiInterfaceMinuman;

public class InsertActivityMinuman extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_minuman);
        EditText edtMinuman, edtHarga;
        Button btInsert, btBack;
        ApiInterfaceMinuman mApiInterfaceMinuman;
        edtMinuman = (EditText) findViewById(R.id.edtMinuman);
        edtHarga = (EditText) findViewById(R.id.edtHarga);
        mApiInterfaceMinuman = ApiClient.getClient().create(ApiInterfaceMinuman.class);
        btInsert = (Button) findViewById(R.id.btInsertingMinuman);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelMinuman> postMinumanCall =
                        mApiInterfaceMinuman.postMinuman(edtMinuman.getText().toString(),
                                edtHarga.getText().toString());
                postMinumanCall.enqueue(new Callback<PostPutDelMinuman>()
                {
                    @Override
                    public void onResponse(Call<PostPutDelMinuman> call,
                                           Response<PostPutDelMinuman> response) {
                        MainActivityMinuman.ma.refresh();
                        finish();
                    }
                    @Override
                    public void onFailure(Call<PostPutDelMinuman> call,
                                          Throwable t) {
                        Toast.makeText(getApplicationContext(),
                                "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btBack = (Button) findViewById(R.id.btBackGoMinuman);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityMinuman.ma.refresh();
                finish();
            }
        });
    }
}
