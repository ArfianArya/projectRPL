package com.example.sweettrash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
// ini buat informasi sampah
public class ListSampah extends AppCompatActivity {

   RecyclerView recyclerView;
   RecyclerView.Adapter sampahAdapter;
   RecyclerView.LayoutManager layoutManager;

   String[] namaSampah = {"Kertas","kardus"};
   String[] kategoriSampah = {"Plastik","Plastik"};
   String[] hargaSampah = {"Rp.1000/kg","Rp.2000/kg"};
   int[] gambarSampah = {R.drawable.kertas, R.drawable.kardus};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sampah);

        recyclerView = findViewById(R.id.recyclerview_sampah);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        sampahAdapter = new SampahAdapter(this, namaSampah, kategoriSampah, hargaSampah, gambarSampah);
        recyclerView.setAdapter(sampahAdapter);
    }
}