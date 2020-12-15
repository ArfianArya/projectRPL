package com.example.sweettrash;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterJual extends RecyclerView.Adapter<MyAdapterJual.MyViewHolder> {

    ArrayList<ModelJual> mList;
    Context context;

    public MyAdapterJual(Context context, ArrayList<ModelJual> mList){
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_jual, parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.namaSampah.setText(mList.get(position).getNamaSampah());
        holder.kategoriSampah.setText(mList.get(position).getkategoriSampah());
        holder.beratSampah.setText(mList.get(position).getberatSampah());
        holder.jenisTopUp.setText(mList.get(position).getjenisTopUp());
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView namaSampah, kategoriSampah, beratSampah, jenisTopUp;
        public MyViewHolder(View itemView){
            super(itemView);
            namaSampah = (TextView) itemView.findViewById(R.id.namaSampahText);
            kategoriSampah = (TextView)itemView.findViewById(R.id.kategoriSampahText);
            beratSampah = (TextView) itemView.findViewById(R.id.beratSampahText);
            jenisTopUp = (TextView) itemView.findViewById(R.id.jenisTopUpText);
        }
    }

}
