package com.example.aplikasipenyewaaanparmusik;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FormSewa extends AppCompatActivity implements View.OnClickListener {

    private EditText fromDateEtxt;
    private EditText toDateEtxt;
    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;
    private SimpleDateFormat dateFormatter;
    private RadioGroup opsi;
    private RadioGroup cara;
    Button kirim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_sewa);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        findViewsById();

        setDateTimeField();

        kirim = (Button) findViewById(R.id.kirim);
        kirim.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "Sewa Berhasil Terkirim", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(FormSewa.this, FormSewa.class));
            }
        });

    }
    private void findViewsById() {
        fromDateEtxt = (EditText) findViewById(R.id.fromdate);
        fromDateEtxt.setInputType(InputType.TYPE_NULL);
        fromDateEtxt.requestFocus();

        toDateEtxt = (EditText) findViewById(R.id.todate);
        toDateEtxt.setInputType(InputType.TYPE_NULL);

        opsi = findViewById(R.id.soal1);
        opsi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id){
                    case R.id.option1:
                        Toast.makeText(getApplication(), "acara pernikahan", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.option2:
                        Toast.makeText(getApplication(), "acara markaroan", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.option3:
                        Toast.makeText(getApplication(), "acara ulang tahun", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.option4:
                        Toast.makeText(getApplication(), "acara kematian", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        cara = findViewById(R.id.soal2);
        cara.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id){
                    case R.id.cara1:
                        Toast.makeText(getApplication(), "cash on delivery", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.cara2:
                        Toast.makeText(getApplication(), "transfer bank", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.cara3:
                        Toast.makeText(getApplication(), "rekening bersama", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }

    private void setDateTimeField() {
        fromDateEtxt.setOnClickListener(this);
        toDateEtxt.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                fromDateEtxt.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        toDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                toDateEtxt.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }
    @Override
    public void onClick(View view) {
        if(view == fromDateEtxt) {
            fromDatePickerDialog.show();
        } else if(view == toDateEtxt) {
            toDatePickerDialog.show();
        }
    }

}