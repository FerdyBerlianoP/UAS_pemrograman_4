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
import com.nyoba.uas.adapter.MinumanAdapter;
import com.nyoba.uas.model.Minuman;
import com.nyoba.uas.model.GetMinuman;
import com.nyoba.uas.rest.ApiClient;
import com.nyoba.uas.rest.ApiInterfaceMinuman;

import java.util.List;

public class MainActivityMinuman extends AppCompatActivity {

    ApiInterfaceMinuman mApiInterfaceMinuman;
    private RecyclerView mRecyclerViewMinuman;
    private RecyclerView.Adapter mAdapterMinuman;
    private RecyclerView.LayoutManager mLayoutManagerMinuman;
    public static MainActivityMinuman ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_minuman);
        Button btIns;
        btIns = (Button) findViewById(R.id.btInsMinuman);
        btIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivityMinuman.this,
                        InsertActivityMinuman.class));
            }
        });
        mRecyclerViewMinuman = (RecyclerView) findViewById(R.id.recyclerViewMinuman);
        mLayoutManagerMinuman = new LinearLayoutManager(this);
        mRecyclerViewMinuman.setLayoutManager(mLayoutManagerMinuman);
        mApiInterfaceMinuman = ApiClient.getClient().create(ApiInterfaceMinuman.class);
        ma=this;
        refresh();
    }
    public void refresh() {
        Call<GetMinuman> minumanCall = mApiInterfaceMinuman.getMinuman();
        minumanCall.enqueue(new Callback<GetMinuman>() {
            @Override
            public void onResponse(Call<GetMinuman> call,
                                   Response<GetMinuman>
                                           response) {
                List<Minuman> MinumanList =
                        response.body().getListDataMinuman();
                Log.d("Retrofit Get", "Jumlah data Minuman: " +
                        String.valueOf(MinumanList.size()));
                mAdapterMinuman = new MinumanAdapter(MinumanList);
                mRecyclerViewMinuman.setAdapter(mAdapterMinuman);
            }
            @Override
            public void onFailure(Call<GetMinuman> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}