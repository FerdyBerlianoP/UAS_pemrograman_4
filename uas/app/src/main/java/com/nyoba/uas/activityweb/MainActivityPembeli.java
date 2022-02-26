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
import com.nyoba.uas.adapter.PembeliAdapter;
import com.nyoba.uas.model.Pembeli;
import com.nyoba.uas.model.GetPembeli;
import com.nyoba.uas.rest.ApiClient;
import com.nyoba.uas.rest.ApiInterfacePembeli;

import java.util.List;

public class MainActivityPembeli extends AppCompatActivity {

    ApiInterfacePembeli mApiInterfacePembeli;
    private RecyclerView mRecyclerViewPembeli;
    private RecyclerView.Adapter mAdapterPembeli;
    private RecyclerView.LayoutManager mLayoutManagerPembeli;
    public static MainActivityPembeli ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pembeli);
        Button btIns;
        btIns = (Button) findViewById(R.id.btInsPembeli);
        btIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivityPembeli.this,
                        InsertActivityPembeli.class));
            }
        });
        mRecyclerViewPembeli = (RecyclerView) findViewById(R.id.recyclerViewPembeli);
        mLayoutManagerPembeli = new LinearLayoutManager(this);
        mRecyclerViewPembeli.setLayoutManager(mLayoutManagerPembeli);
        mApiInterfacePembeli = ApiClient.getClient().create(ApiInterfacePembeli.class);
        ma=this;
        refresh();
    }
    public void refresh() {
        Call<GetPembeli> pembeliCall = mApiInterfacePembeli.getPembeli();
        pembeliCall.enqueue(new Callback<GetPembeli>() {
            @Override
            public void onResponse(Call<GetPembeli> call,
                                   Response<GetPembeli>
                                           response) {
                List<Pembeli> PembeliList =
                        response.body().getListDataPembeli();
                Log.d("Retrofit Get", "Jumlah data Pembeli: " +
                        String.valueOf(PembeliList.size()));
                mAdapterPembeli = new PembeliAdapter(PembeliList);
                mRecyclerViewPembeli.setAdapter(mAdapterPembeli);
            }
            @Override
            public void onFailure(Call<GetPembeli> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}