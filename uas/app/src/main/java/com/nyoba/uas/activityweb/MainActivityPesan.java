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
import com.nyoba.uas.adapter.PesanAdapter;
import com.nyoba.uas.model.Pesan;
import com.nyoba.uas.model.GetPesan;
import com.nyoba.uas.rest.ApiClient;
import com.nyoba.uas.rest.ApiInterfacePesan;

import java.util.List;

public class MainActivityPesan extends AppCompatActivity {

    ApiInterfacePesan mApiInterfacePesan;
    private RecyclerView mRecyclerViewPesan;
    private RecyclerView.Adapter mAdapterPesan;
    private RecyclerView.LayoutManager mLayoutManagerPesan;
    public static MainActivityPesan ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pesan);
        Button btIns;
        btIns = (Button) findViewById(R.id.btInsPesan);
        btIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivityPesan.this,
                        InsertActivityPesan.class));
            }
        });
        mRecyclerViewPesan = (RecyclerView) findViewById(R.id.recyclerViewPesan);
        mLayoutManagerPesan = new LinearLayoutManager(this);
        mRecyclerViewPesan.setLayoutManager(mLayoutManagerPesan);
        mApiInterfacePesan = ApiClient.getClient().create(ApiInterfacePesan.class);
        ma=this;
        refresh();
    }
    public void refresh() {
        Call<GetPesan> pesanCall = mApiInterfacePesan.getPesan();
        pesanCall.enqueue(new Callback<GetPesan>() {
            @Override
            public void onResponse(Call<GetPesan> call,
                                   Response<GetPesan>
                                           response) {
                List<Pesan> PesanList =
                        response.body().getListDataPesan();
                Log.d("Retrofit Get", "Jumlah data Pesan: " +
                        String.valueOf(PesanList.size()));
                mAdapterPesan = new PesanAdapter(PesanList);
                mRecyclerViewPesan.setAdapter(mAdapterPesan);
            }
            @Override
            public void onFailure(Call<GetPesan> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}