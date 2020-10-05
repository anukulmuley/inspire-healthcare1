package com.example.try1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loginAs extends AppCompatActivity {
    private Button moveToAdmin, moveToStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_as);
        getSupportActionBar().hide();

        moveToAdmin = findViewById(R.id.log_admin);
        moveToAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToAdminPage();
            }
        });

        moveToStudents=findViewById(R.id.log_student);
        moveToStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToStudentPage();
            }
        });
    }
    private void moveToAdminPage(){
        Intent intent=new Intent(loginAs.this,doctorSignIn.class);
        startActivity(intent);
    }

        private void moveToStudentPage(){
        Intent intent=new Intent(loginAs.this,studentSignIn.class);
        startActivity(intent);
    }
}