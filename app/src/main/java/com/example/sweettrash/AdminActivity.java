package com.example.sweettrash;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class AdminActivity extends AppCompatActivity {
    private Button listJmpt, jual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        listJmpt = findViewById(R.id.btnListJemputSampah);
        listJmpt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminActivity.this, ListJemputSampah.class));
            }
        });

        jual = findViewById(R.id.btnTopUp);
        jual.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminActivity.this, topUp.class));
            }
        });

    }
    //    public void listJemputSampah(View view){
//        startActivity(new Intent(getApplicationContext(), ListJemputSampah.class));
//        finish();
//        }



    public void logoutAdmin(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }


}