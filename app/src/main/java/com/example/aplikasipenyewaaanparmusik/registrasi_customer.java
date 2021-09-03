package com.example.aplikasipenyewaaanparmusik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class registrasi_customer extends AppCompatActivity {
    DatabaseHelper db;
    EditText naleng, email, pass1, pass2, notel, alamat;
    Button btnRegistrasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_registrasi);
        db = new DatabaseHelper(this);
        naleng = (EditText) findViewById(R.id.NaLeng);
        email = (EditText) findViewById(R.id.email);
        pass1 = (EditText) findViewById(R.id.pass);
        pass2 = (EditText) findViewById(R.id.pass1);
        notel = (EditText) findViewById(R.id.noTel);
        alamat = (EditText) findViewById(R.id.alamat);
        btnRegistrasi = (Button) findViewById(R.id.register1);
        btnRegistrasi.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String s1 = naleng.getText().toString();
                String s2 = email.getText().toString();
                String s3 = pass1.getText().toString();
                String s4 = pass2.getText().toString();
                String s5 = notel.getText().toString();
                String s6 = alamat.getText().toString();

                if(s1.equals("")|| s2.equals("")|| s3.equals("")||
                       s4.equals("")||s5.equals("")||s6.equals("")){
                   Toast.makeText(getApplicationContext(), "Field kosong", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(s3.equals(s4)){
                       Boolean chkemail = db.chkemail(s2);
                       if(chkemail==true){
                            Boolean insert = db.insert(s1, s2, s3, s4, s5, s6);
                            if (insert==true){
                                Toast.makeText(getApplicationContext(),"Registrasi Berhasil", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(registrasi_customer.this, login.class));
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Email sudah ada", Toast.LENGTH_SHORT).show();
                        }
                    }
                    Toast.makeText(getApplicationContext(),"Registrasi Berhasil", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(registrasi_customer.this, login.class));
              }
            }
        });
    }
}