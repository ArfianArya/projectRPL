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
        Model model = mList.get(position);
        holder.unameView.setText(model.getUname());
        holder.nomorHPView.setText(model.getNomorHP());
        holder.almtView.setText(model.getAlmt());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView unameView, nomorHPView, almtView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            unameView = itemView.findViewById(R.id.usernameText);
            nomorHPView = itemView.findViewById(R.id.nomorHPText);
            almtView = itemView.findViewById(R.id.alamatText);

        }
    }
}
