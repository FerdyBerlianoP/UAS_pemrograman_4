package com.nyoba.uas.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nyoba.uas.R;
import com.nyoba.uas.helper.DBHandler;

public class HomeScreenActivity extends AppCompatActivity {
    private Button button_tambahdata;
    private Button button_lihatdata;
    private Button button_hapusdata;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        dbHandler = new DBHandler(HomeScreenActivity.this);
        initComponents();
    }

    private void initComponents(){
        button_tambahdata = (Button) findViewById(R.id.button_tambahdata);
        button_lihatdata = (Button) findViewById(R.id.button_lihatdata);
        button_hapusdata = (Button) findViewById(R.id.button_hapusdata);

        button_tambahdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreenActivity.this, TambahActivity.class));
            }
        });

        button_lihatdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreenActivity.this, LihatActivity.class));
            }
        });

        button_hapusdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.hapusSemuaDataJurusan();
                Toast.makeText(HomeScreenActivity.this, "Berhasil Menghapus Data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}