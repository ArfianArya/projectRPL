package com.example.sweettrash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListJemputSampah extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<ModelDaftarPenjemputan> list;
    MyAdapter adapter;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jemput_sampah);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        list = new ArrayList<ModelDaftarPenjemputan>();


        reference = FirebaseDatabase.getInstance().getReference().child("Pesanan");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot1: snapshot.getChildren()){
                    ModelDaftarPenjemputan mList = dataSnapshot1.getValue(ModelDaftarPenjemputan.class);
                    list.add(mList);
                }
                adapter = new MyAdapter(ListJemputSampah.this,list);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ListJemputSampah.this, "Belum ada pesanan yang masuk", Toast.LENGTH_SHORT).show();
            }
        });
    }
}