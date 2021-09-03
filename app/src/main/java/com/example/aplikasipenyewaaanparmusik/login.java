package com.example.aplikasipenyewaaanparmusik;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    DatabaseHelper db;
    private EditText email, pass;
    private Button masuk;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        db = new DatabaseHelper(this);
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
        masuk = (Button) findViewById(R.id.login);

        masuk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String Email = email.getText().toString();
                String Pass = pass.getText().toString();
                Boolean Chkemailpass = db.emailpassword(Email, Pass);
                if(Chkemailpass==true)
                    Toast.makeText(getApplicationContext(), "Email dan password salah", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Login berhasil", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(login.this, Detail.class));
            }
        });
    }
    public void openFb(View v){
        Uri uri = Uri.parse("https://m.facebook.com/login/?locale=id_ID");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(i);
    }
}