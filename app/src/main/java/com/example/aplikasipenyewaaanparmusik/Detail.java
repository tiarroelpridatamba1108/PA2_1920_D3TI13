package com.example.aplikasipenyewaaanparmusik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Detail extends AppCompatActivity {
    private Button btnDetail1;
    private Button btnDetail2;
    private Button btnDetail3;
    private Button btnDetail4;
    private Button btnDetail5;
    private Button btnDetail6;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        btnDetail1 = (Button) findViewById(R.id.detail1);
        btnDetail2 = (Button) findViewById(R.id.detail2);
        btnDetail3 = (Button) findViewById(R.id.detail3);
        btnDetail4 = (Button) findViewById(R.id.detail4);
        btnDetail5 = (Button) findViewById(R.id.detail5);
        btnDetail6 = (Button) findViewById(R.id.detail6);

        btnDetail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Detail.this, detail_musik1.class));
            }
        });
        btnDetail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Detail.this, detail_musik2.class));
            }
        });
        btnDetail3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Detail.this, detail_musik1.class));
            }
        });
        btnDetail4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Detail.this, detail_musik2.class));
            }
        });
        btnDetail5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Detail.this, detail_musik1.class));
            }
        });
        btnDetail6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Detail.this, detail_musik2.class));
            }
        });
    }
}