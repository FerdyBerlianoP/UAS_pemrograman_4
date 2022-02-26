package com.nyoba.uas.activityweb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.nyoba.uas.R;
import com.nyoba.uas.adapter.MakananAdapter;
import com.nyoba.uas.model.Makanan;
import com.nyoba.uas.model.GetMakanan;
import com.nyoba.uas.rest.ApiClient;
import com.nyoba.uas.rest.ApiInterface;

import java.util.List;

public class MainActivityMakanan extends AppCompatActivity {

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerViewMakanan;
    private RecyclerView.Adapter mAdapterMakanan;
    private RecyclerView.LayoutManager mLayoutManagerMakanan;
    public static MainActivityMakanan ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_makanan);
        Button btIns;
        btIns = (Button) findViewById(R.id.btInsMakanan);
        btIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivityMakanan.this,
                        InsertActivityMakanan.class));
            }
        });
        mRecyclerViewMakanan = (RecyclerView) findViewById(R.id.recyclerViewMakanan);
        mLayoutManagerMakanan = new LinearLayoutManager(this);
        mRecyclerViewMakanan.setLayoutManager(mLayoutManagerMakanan);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;
        refresh();
    }
    public void refresh() {
        Call<GetMakanan> makananCall = mApiInterface.getMakanan();
        makananCall.enqueue(new Callback<GetMakanan>() {
            @Override
            public void onResponse(Call<GetMakanan> call,
                                   Response<GetMakanan>
                                           response) {
                List<Makanan> MakananList =
                        response.body().getListDataMakanan();
                Log.d("Retrofit Get", "Jumlah data Makanan: " +
                        String.valueOf(MakananList.size()));
                mAdapterMakanan = new MakananAdapter(MakananList);
                mRecyclerViewMakanan.setAdapter(mAdapterMakanan);
            }
            @Override
            public void onFailure(Call<GetMakanan> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}