package com.lko.my.gris;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lko.my.gris.Student.StudentLoginActivity;
import com.lko.my.gris.Faculty.FacultyLoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button student_login,faculty_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface font = Typeface.createFromAsset(getAssets(), "Chunkfive.otf");
        TextView tv =(TextView) findViewById(R.id.tv_hederfirst);
        tv.setTypeface(font);

        student_login =(Button)findViewById(R.id.btn_studentlogin_next);
        faculty_login =(Button)findViewById(R.id.btn_facultylogin_next);
        student_login.setOnClickListener(this);
        faculty_login.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if(v == student_login){
            startActivity(new Intent(getApplicationContext(),StudentLoginActivity.class));
        }
        if(v == faculty_login){
            startActivity(new Intent(getApplicationContext(),FacultyLoginActivity.class));
        }

    }
}
