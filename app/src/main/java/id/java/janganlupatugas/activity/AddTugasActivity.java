package id.java.janganlupatugas.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import id.java.janganlupatugas.MainActivity;
import id.java.janganlupatugas.R;
import id.java.janganlupatugas.Tugas;

public class AddTugasActivity extends AppCompatActivity {
    private EditText namaTugas;
    private EditText catatan;
    private EditText deadline;
    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tugas);
        namaTugas = findViewById(R.id.input_tugas);
        catatan = findViewById(R.id.input_catatan);
        deadline = findViewById(R.id.input_deadline);
        final Button button = findViewById(R.id.submit);

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };
        deadline.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(AddTugasActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        button.setOnClickListener(view ->{
            Intent replyIntent = new Intent(this,MainActivity.class);
            if(TextUtils.isEmpty(namaTugas.getText())){
                setResult(RESULT_CANCELED, replyIntent);
            }else{
                String nama_tugas = namaTugas.getText().toString();
                String desk = catatan.getText().toString();
                String Deadline = deadline.getText().toString();
                Tugas tugas = new Tugas(nama_tugas,desk,Deadline);
                replyIntent.putExtra("tugas",nama_tugas);
                replyIntent.putExtra("catatan",desk);
                replyIntent.putExtra("deadline",Deadline);
                setResult(RESULT_OK,replyIntent);
            }
            finish();
        });

    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        deadline.setText(sdf.format(myCalendar.getTime()));
    }


}