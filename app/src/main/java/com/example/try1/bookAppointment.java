package com.example.try1;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class bookAppointment extends AppCompatActivity {

    Button dateButton, timeButton;
    TextView dateTextView, timeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        dateButton = findViewById(R.id.dateButton1);
        timeButton = findViewById(R.id.timeButton1);
        dateTextView = findViewById(R.id.dateTextView1);
        timeTextView = findViewById(R.id.timeTextView1);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleDateButton();
            }
        });
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleTimeButton();
            }
        });
    }

    private void handleTimeButton() {
        Calendar calendar = Calendar.getInstance();
        int HOUR = calendar.get(Calendar.HOUR);
        int MINUTE = calendar.get(Calendar.MINUTE);

        boolean is24HourFormat = DateFormat.is24HourFormat(this);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
//             String timeString = "hour:"+ hour + "minute:"+ minute;
//             timeTextView.setText(timeString);

                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.HOUR,hour);
                calendar1.set(Calendar.MINUTE,minute);

                CharSequence charSequence = DateFormat.format("hh:mm a",calendar1);
                timeTextView.setText(charSequence);


            }
        }, HOUR , MINUTE,false);

        timePickerDialog.show();
    }

    private void handleDateButton() {
        final Calendar calendar = Calendar.getInstance();
        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DATE = calendar.get(Calendar.DATE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                String dateString = year + "" + month+ ""+date;
                dateTextView.setText(dateString);

                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.YEAR,year);
                calendar1.set(Calendar.MONTH,month);
                calendar1.set(Calendar.DATE,date);

                CharSequence dateCharSequence = DateFormat.format("EEEE dd MMM yyyy",calendar1);
                dateTextView.setText(dateCharSequence);


            }
        },YEAR,MONTH,DATE);
        datePickerDialog.show();
    }


}