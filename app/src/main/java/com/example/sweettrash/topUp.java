package com.example.sweettrash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
public class topUp extends AppCompatActivity {

    private DatabaseReference reference;
    private RecyclerView recyclerView;
    private ArrayList<ModelJual> list;
    private MyAdapterJual adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        list = new ArrayList<ModelJual>();


        reference = FirebaseDatabase.getInstance().getReference().child("Jual");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot1: snapshot.getChildren()){
                    ModelJual mList = dataSnapshot1.getValue(ModelJual.class);
                    list.add(mList);
                }
                adapter = new MyAdapterJual(topUp.this,list);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(topUp.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}