package com.example.sweettrash;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Model> mList;
    Context context;

    public MyAdapter(Context context, ArrayList<Model> mList){
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.username.setText(mList.get(position).getUsername());
        holder.nomorHp.setText(mList.get(position).getNomorHp());
        holder.alamat.setText(mList.get(position).getAlamat());
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView username, nomorHp, alamat;
        public MyViewHolder(View itemView){
            super(itemView);
            username = (TextView) itemView.findViewById(R.id.usernameText);
            nomorHp = (TextView)itemView.findViewById(R.id.nomorHPText);
            alamat = (TextView) itemView.findViewById(R.id.alamatText);
        }
    }

}
