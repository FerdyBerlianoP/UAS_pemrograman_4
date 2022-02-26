package com.nyoba.uas.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nyoba.uas.R;
import com.nyoba.uas.activityweb.EditActivityPesan;
import com.nyoba.uas.model.Pesan;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class PesanAdapter extends
        RecyclerView.Adapter<PesanAdapter.MyViewHolderPesan>{
    List<Pesan> mPesanList;
    public PesanAdapter(List <Pesan> PesanList) {
        mPesanList = PesanList;
    }
    @Override
    public MyViewHolderPesan onCreateViewHolder (ViewGroup parent, int
            viewType){
        View mViewPesan = LayoutInflater.from(parent.getContext()).inflate(R.layout.pesan_list,parent, false);
        MyViewHolderPesan mViewHolderPesan = new MyViewHolderPesan(mViewPesan);
        return mViewHolderPesan;
    }
    @Override
    public void onBindViewHolder (MyViewHolderPesan holder,final int
            position){
        holder.mTextViewIdPesan.setText("id_pesan = " + mPesanList.get(position).getId());
        holder.mTextViewPesan.setText("pembeli = " + mPesanList.get(position).getPembeli());
        holder.mTextViewMakanan.setText("makanan = " + mPesanList.get(position).getMakanan());
        holder.mTextViewMinuman.setText("minuman = " + mPesanList.get(position).getMinuman());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntentPesan = new Intent(view.getContext(), EditActivityPesan.class);
                mIntentPesan.putExtra("id_pesan", mPesanList.get(position).getId());
                mIntentPesan.putExtra("pembeli", mPesanList.get(position).getPembeli());
                mIntentPesan.putExtra("pakanan", mPesanList.get(position).getMakanan());
                mIntentPesan.putExtra("minuman", mPesanList.get(position).getMinuman());
                view.getContext().startActivity(mIntentPesan); }
        });
    }
    @Override
    public int getItemCount () {
        return mPesanList.size();
    }
    public class MyViewHolderPesan extends RecyclerView.ViewHolder {
        public TextView mTextViewIdPesan, mTextViewPesan, mTextViewMakanan, mTextViewMinuman;
        public MyViewHolderPesan(View itemView) {
            super(itemView);
            mTextViewIdPesan = (TextView) itemView.findViewById(R.id.tvIdPesan);
            mTextViewPesan = (TextView) itemView.findViewById(R.id.tvPesan);
            mTextViewMakanan = (TextView) itemView.findViewById(R.id.tvMakanan);
            mTextViewMinuman = (TextView) itemView.findViewById(R.id.tvMinuman);
        }
    }
}