package com.nyoba.uas.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nyoba.uas.R;
import com.nyoba.uas.activityweb.EditActivityPembeli;
import com.nyoba.uas.model.Pembeli;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class PembeliAdapter extends
        RecyclerView.Adapter<PembeliAdapter.MyViewHolderPembeli>{
    List<Pembeli> mPembeliList;
    public PembeliAdapter(List <Pembeli> PembeliList) {
        mPembeliList = PembeliList;
    }
    @Override
    public MyViewHolderPembeli onCreateViewHolder (ViewGroup parent, int
            viewType){
        View mViewPembeli = LayoutInflater.from(parent.getContext()).inflate(R.layout.pembeli_list,parent, false);
        MyViewHolderPembeli mViewHolderPembeli = new MyViewHolderPembeli(mViewPembeli);
        return mViewHolderPembeli;
    }
    @Override
    public void onBindViewHolder (MyViewHolderPembeli holder,final int
            position){
        holder.mTextViewIdPembeli.setText("id_pembeli = " + mPembeliList.get(position).getId());
        holder.mTextViewPembeli.setText("nama = " + mPembeliList.get(position).getNama());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntentPembeli = new Intent(view.getContext(), EditActivityPembeli.class);
                mIntentPembeli.putExtra("id_pembeli", mPembeliList.get(position).getId());
                mIntentPembeli.putExtra("nama", mPembeliList.get(position).getNama());
                view.getContext().startActivity(mIntentPembeli); }
        });
    }
    @Override
    public int getItemCount () {
        return mPembeliList.size();
    }
    public class MyViewHolderPembeli extends RecyclerView.ViewHolder {
        public TextView mTextViewIdPembeli, mTextViewPembeli;
        public MyViewHolderPembeli(View itemView) {
            super(itemView);
            mTextViewIdPembeli = (TextView) itemView.findViewById(R.id.tvIdPembeli);
            mTextViewPembeli = (TextView)
                    itemView.findViewById(R.id.tvPembeli);
            }
    }
}