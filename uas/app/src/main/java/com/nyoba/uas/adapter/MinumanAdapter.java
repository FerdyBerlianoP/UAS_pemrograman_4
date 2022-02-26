package com.nyoba.uas.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nyoba.uas.R;
import com.nyoba.uas.activityweb.EditActivityMinuman;
import com.nyoba.uas.model.Minuman;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class MinumanAdapter extends
        RecyclerView.Adapter<MinumanAdapter.MyViewHolderMinuman>{
    List<Minuman> mMinumanList;
    public MinumanAdapter(List <Minuman> MinumanList) {
        mMinumanList = MinumanList;
    }
    @Override
    public MyViewHolderMinuman onCreateViewHolder (ViewGroup parent, int
            viewType){
        View mViewMinuman = LayoutInflater.from(parent.getContext()).inflate(R.layout.minuman_list,parent, false);
        MyViewHolderMinuman mViewHolderMinuman = new MyViewHolderMinuman(mViewMinuman);
        return mViewHolderMinuman;
    }
    @Override
    public void onBindViewHolder (MyViewHolderMinuman holder,final int
            position){
        holder.mTextViewIdMinuman.setText("id_minuman = " + mMinumanList.get(position).getId());
        holder.mTextViewMinuman.setText("minuman = " + mMinumanList.get(position).getMinuman());
        holder.mTextViewHarga.setText("harga = " + mMinumanList.get(position).getHarga());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntentMinuman = new Intent(view.getContext(), EditActivityMinuman.class);
                mIntentMinuman.putExtra("id_minuman", mMinumanList.get(position).getId());
                mIntentMinuman.putExtra("nama_minuman", mMinumanList.get(position).getMinuman());
                mIntentMinuman.putExtra("harga_minuman", mMinumanList.get(position).getHarga());
                view.getContext().startActivity(mIntentMinuman); }
        });
    }
    @Override
    public int getItemCount () {
        return mMinumanList.size();
    }
    public class MyViewHolderMinuman extends RecyclerView.ViewHolder {
        public TextView mTextViewIdMinuman, mTextViewMinuman, mTextViewHarga;
        public MyViewHolderMinuman(View itemView) {
            super(itemView);
            mTextViewIdMinuman = (TextView) itemView.findViewById(R.id.tvIdMinuman);
            mTextViewMinuman = (TextView)
                    itemView.findViewById(R.id.tvMinuman);
            mTextViewHarga = (TextView)
                    itemView.findViewById(R.id.tvHarga);
        }
    }
}