package com.example.aplikasipenyewaaanparmusik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class detail_musik2 extends AppCompatActivity {

    private Button btnSewa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_musik2);

        btnSewa = (Button) findViewById(R.id.sewa);
        btnSewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(detail_musik2.this, FormSewa.class));
            }
        });
    }

    public void satu(View view) {
        Intent i = new Intent(detail_musik2.this, login.class);
        startActivity(i);
    }

    public void dua(View view) {
        Intent i = new Intent(detail_musik2.this, login.class);
        startActivity(i);
    }

    public void tiga(View view) {
        Intent i = new Intent(detail_musik2.this, login.class);
        startActivity(i);
    }

    public void empat(View view) {
        Intent i = new Intent(detail_musik2.this, login.class);
        startActivity(i);
    }
}