package com.example.sweettrash;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class SampahAdapter extends RecyclerView.Adapter<SampahAdapter.ViewHolder> {
    Context context;
    String[] namaSampah, kategoriSampah, hargaSampah;
    int[] gambarSampah;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView rowNama;
        TextView rowKategori;
        TextView rowHarga;
        ImageView rowGambar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowNama = itemView.findViewById(R.id.tv_nama);
            rowKategori = itemView.findViewById(R.id.tv_kategori);
            rowHarga = itemView.findViewById(R.id.tv_harga);
            rowGambar = itemView.findViewById(R.id.iv_sampah);
        }
    }

    public SampahAdapter(Context context, String[] namaSampah, String[] kategoriSampah, String[] hargaSampah, int[] gambarSampah){
        this.context = context;
        this.namaSampah = namaSampah;
        this.kategoriSampah = kategoriSampah;
        this.hargaSampah = hargaSampah;
        this.gambarSampah = gambarSampah;
    }

    @NonNull
    @Override
    public SampahAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_sampah,parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SampahAdapter.ViewHolder holder, int position) {
        holder.rowNama.setText(namaSampah[position]);
        holder.rowKategori.setText(kategoriSampah[position]);
        holder.rowHarga.setText(hargaSampah[position]);
        holder.rowGambar.setImageResource(gambarSampah[position]);
    }

    @Override
    public int getItemCount() {
        return namaSampah.length;
    }
}
