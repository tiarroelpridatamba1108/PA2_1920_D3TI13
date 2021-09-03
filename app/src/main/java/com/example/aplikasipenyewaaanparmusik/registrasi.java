package com.example.aplikasipenyewaaanparmusik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class registrasi extends AppCompatActivity {
    private Button btnparmusik;
    private Button btncustomer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrasi);

        btnparmusik = (Button) findViewById(R.id.parmusik);
        btncustomer = (Button) findViewById(R.id.customer);

        btnparmusik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(registrasi.this, registrasi_parmusik.class));
            }
        });
        btncustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(registrasi.this, registrasi_customer.class));
            }
        });
    }
    public void login1(View v) {
        Intent i = new Intent(registrasi.this, login.class);
        startActivity(i);
    }
}
