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
import com.nyoba.uas.model.PostPutDelMakanan;
import com.nyoba.uas.rest.ApiClient;
import com.nyoba.uas.rest.ApiInterface;

public class InsertActivityMakanan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_makanan);
        EditText edtMakanan, edtHarga;
        Button btInsert, btBack;
        ApiInterface mApiInterface;
        edtMakanan = (EditText) findViewById(R.id.edtMakanan);
        edtHarga = (EditText) findViewById(R.id.edtHarga);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btInsert = (Button) findViewById(R.id.btInsertingMakanan);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelMakanan> postMakananCall =
                        mApiInterface.postMakanan(edtMakanan.getText().toString(),
                                edtHarga.getText().toString());
                postMakananCall.enqueue(new Callback<PostPutDelMakanan>()
                {
                    @Override
                    public void onResponse(Call<PostPutDelMakanan> call,
                                           Response<PostPutDelMakanan> response) {
                        MainActivityMakanan.ma.refresh();
                        finish();
                    }
                    @Override
                    public void onFailure(Call<PostPutDelMakanan> call,
                                          Throwable t) {
                        Toast.makeText(getApplicationContext(),
                                "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btBack = (Button) findViewById(R.id.btBackGoMakanan);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityMakanan.ma.refresh();
                finish();
            }
        });
    }
}
