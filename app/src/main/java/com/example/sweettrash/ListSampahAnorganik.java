package com.example.sweettrash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
// ini buat informasi sampah
public class ListSampahAnorganik extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter sampahAdapter;
    RecyclerView.LayoutManager layoutManager;

    String[] namaSampah = {"Botol Bening","Botol Berwarna", "kaleng Minuman", "galon", "Karung Besar","Karung Kecil"};
    String[] kategoriSampah = {"Plastik"," Plastik", "Plastik", "Plastik", "Plastik", "Plastik"};
    String[] hargaSampah = {"Rp.2000/kg","Rp.2000/kg", "Rp.8000/kg", "Rp.2000/kg",
            "Rp.2000/kg","Rp.2000/kg"};
    int[] gambarSampah = {R.drawable.botol_bening, R.drawable.botol_berwarna, R.drawable.kaleng, R.drawable.galon,R.drawable.karung_besar, R.drawable.karung_kecil};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sampah_anorganik);

        recyclerView = findViewById(R.id.recyclerview_sampah);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        sampahAdapter = new SampahAdapter(this, namaSampah, kategoriSampah, hargaSampah, gambarSampah);
        recyclerView.setAdapter(sampahAdapter);
    }
}