package com.nyoba.uas.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nyoba.uas.R;
import com.nyoba.uas.activityweb.EditActivityMakanan;
import com.nyoba.uas.model.Makanan;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class MakananAdapter extends
        RecyclerView.Adapter<MakananAdapter.MyViewHolderMakanan>{
    List<Makanan> mMakananList;
    public MakananAdapter(List <Makanan> MakananList) {
        mMakananList = MakananList;
    }
    @Override
    public MyViewHolderMakanan onCreateViewHolder (ViewGroup parent, int
            viewType){
        View mViewMakanan = LayoutInflater.from(parent.getContext()).inflate(R.layout.makanan_list,parent, false);
        MyViewHolderMakanan mViewHolderMakanan = new MyViewHolderMakanan(mViewMakanan);
        return mViewHolderMakanan;
    }
    @Override
    public void onBindViewHolder (MyViewHolderMakanan holder,final int
            position){
        holder.mTextViewIdMakanan.setText("id_makanan = " + mMakananList.get(position).getId());
        holder.mTextViewMakanan.setText("nama_makanan = " + mMakananList.get(position).getMakanan());
        holder.mTextViewHarga.setText("harga_makanan = " + mMakananList.get(position).getHarga());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntentMakanan = new Intent(view.getContext(), EditActivityMakanan.class);
                mIntentMakanan.putExtra("id_makanan", mMakananList.get(position).getId());
                mIntentMakanan.putExtra("nama_makanan", mMakananList.get(position).getMakanan());
                mIntentMakanan.putExtra("harga_makanan", mMakananList.get(position).getHarga());
                view.getContext().startActivity(mIntentMakanan); }
        });
    }
    @Override
    public int getItemCount () {
        return mMakananList.size();
    }
    public class MyViewHolderMakanan extends RecyclerView.ViewHolder {
        public TextView mTextViewIdMakanan, mTextViewMakanan, mTextViewHarga;
        public MyViewHolderMakanan(View itemView) {
            super(itemView);
            mTextViewIdMakanan = (TextView) itemView.findViewById(R.id.tvIdMakanan);
            mTextViewMakanan = (TextView)
                    itemView.findViewById(R.id.tvMakanan);
            mTextViewHarga = (TextView)
                    itemView.findViewById(R.id.tvHarga);
        }
    }
}