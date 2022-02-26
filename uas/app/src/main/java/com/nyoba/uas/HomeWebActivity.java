package com.nyoba.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nyoba.uas.activityweb.MainActivityMakanan;
import com.nyoba.uas.activityweb.MainActivityMinuman;
import com.nyoba.uas.activityweb.MainActivityPembeli;
import com.nyoba.uas.activityweb.MainActivityPesan;

public class HomeWebActivity extends AppCompatActivity {
    Button makanan,minuman,pembeli,pesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_web);

        makanan = (Button) findViewById(R.id.keMakanan);
        makanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeWebActivity.this, MainActivityMakanan.class));
            }
        });
        minuman = (Button) findViewById(R.id.keMinuman);
        minuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeWebActivity.this, MainActivityMinuman.class));
            }
        });
        pembeli = (Button) findViewById(R.id.kePembeli);
        pembeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeWebActivity.this, MainActivityPembeli.class));
            }
        });
        pesan = (Button) findViewById(R.id.kePesanan);
        pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeWebActivity.this, MainActivityPesan.class));
            }
        });
    }
}