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
import com.nyoba.uas.model.PostPutDelPesan;
import com.nyoba.uas.rest.ApiClient;
import com.nyoba.uas.rest.ApiInterfacePesan;

public class InsertActivityPesan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_pesan);
        EditText edtPesan, edtMakanan2, edtMinuman2;
        Button btInsert, btBack;
        ApiInterfacePesan mApiInterfacePesan;
        edtPesan = (EditText) findViewById(R.id.edtPesan);
        edtMakanan2 = (EditText) findViewById(R.id.edtMakanan2);
        edtMinuman2 = (EditText) findViewById(R.id.edtMinuman2);
        mApiInterfacePesan = ApiClient.getClient().create(ApiInterfacePesan.class);
        btInsert = (Button) findViewById(R.id.btInsertingPesan);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelPesan> postPesanCall =
                        mApiInterfacePesan.postPesan(edtPesan.getText().toString(),
                                edtMakanan2.getText().toString(),edtMinuman2.getText().toString());
                postPesanCall.enqueue(new Callback<PostPutDelPesan>()
                {
                    @Override
                    public void onResponse(Call<PostPutDelPesan> call,
                                           Response<PostPutDelPesan> response) {
                        MainActivityPesan.ma.refresh();
                        finish();
                    }
                    @Override
                    public void onFailure(Call<PostPutDelPesan> call,
                                          Throwable t) {
                        Toast.makeText(getApplicationContext(),
                                "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btBack = (Button) findViewById(R.id.btBackGoPesan);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPesan.ma.refresh();
                finish();
            }
        });
    }
}
