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

public class JualSampahActivity extends AppCompatActivity {
    private EditText txtNamaSampah, txtKategoriSampah, txtBeratSampah, txtJenisTopUp;
    private Button jual;
    private Button back;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Jual");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jual_sampah);

        txtNamaSampah = findViewById(R.id.editNamaSampah);
        txtKategoriSampah = findViewById(R.id.editKategoriSampah);
        txtBeratSampah = findViewById(R.id.editberatSampah);
        txtJenisTopUp = findViewById(R.id.editJenisTopUp);
        jual = findViewById(R.id.btnJual);

        jual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkField(txtNamaSampah);
                checkField(txtKategoriSampah);
                checkField(txtBeratSampah);
                checkField(txtJenisTopUp);
                String namaSampah = txtNamaSampah.getText().toString();
                String kategoriSampah = txtKategoriSampah.getText().toString();
                String beratSampah =  txtBeratSampah.getText().toString();
                String jenisTopUp =  txtJenisTopUp.getText().toString();

//                int finalBeratSampah = Integer.parseInt(beratSampah);

                HashMap<String, String> userMap = new HashMap<>();

                userMap.put("namaSampah", namaSampah);
                userMap.put("kategoriSampah", kategoriSampah);
                userMap.put("beratSampah", beratSampah);
                userMap.put("jenisTopUp", jenisTopUp);

                if (namaSampah.isEmpty() && kategoriSampah.isEmpty() && beratSampah.isEmpty() && jenisTopUp.isEmpty()){
                    Toast.makeText(JualSampahActivity.this, "Penjualan Gagal dilakukan", Toast.LENGTH_SHORT).show();
                }else{
                    root.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(JualSampahActivity.this, "Data berhasil tersimpan", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

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

    public boolean checkField(EditText textField){
        boolean valid;
        if(textField.getText().toString().isEmpty()){
            textField.setError("Form Belum Terisi");
            valid = false;
        }else {
            valid = true;
        }

        return valid;
    }
}