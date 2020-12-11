package com.example.sweettrash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class LayananJemput extends AppCompatActivity {
    private EditText txtuname, txtnomorhp, txtalmt;
    private Button pesan;
    private Button back;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Pesanan");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layanan_jemput);


        txtuname = findViewById(R.id.editUsername);
        txtnomorhp = findViewById(R.id.editNomorHp);
        txtalmt = findViewById(R.id.editAlamat);
        pesan = findViewById(R.id.btnPesan);

        pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtuname.getText().toString();
                String nomorHp = txtnomorhp.getText().toString();
                String alamat = txtalmt.getText().toString();

                HashMap<String, String> userMap = new HashMap<>();

                userMap.put("username", name);
                userMap.put("nomorHp", nomorHp);
                userMap.put("alamat", alamat);

                root.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(LayananJemput.this, "Pesanan Berhasil Dilakukan", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });
       back = findViewById(R.id.btnBack);
       back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(getApplicationContext(), MainActivity.class));
           }
       });
    }
}
