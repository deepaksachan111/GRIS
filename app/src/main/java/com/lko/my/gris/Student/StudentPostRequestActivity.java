package com.lko.my.gris.Student;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lko.my.gris.R;
import com.lko.my.gris.database.AddPostReguestData;
import com.lko.my.gris.database.DatabaseHandler;

import java.io.File;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class StudentPostRequestActivity extends Activity {

    private EditText edt_student_fileuplaod ,edt_department;
    private DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_post_request);
            db = new DatabaseHandler(this);

        Button save = (Button) findViewById(R.id.btn_post_request_save);
        //  Button upload = (Button) findViewById(R.id.upload);
        edt_student_fileuplaod = (EditText) findViewById(R.id.edt_student_edittext);
        edt_department =(EditText)findViewById(R.id.edt_student_post_department);


           save.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   String s_id = getIntent().getStringExtra("IDS");




                   String depart = edt_department.getText().toString();
                   String edttext= edt_student_fileuplaod.getText().toString();
                   String status = "Send to faculty";

                   Calendar c = Calendar.getInstance();
                  // System.out.println("Current time => " + c.getTime());

                   SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                   String formattedDate = df.format(c.getTime());

                   String da = formattedDate;

                   String ans = "";


                    db.addStudent_Post_request(new AddPostReguestData(da,s_id,depart,edttext,status,ans));
                   Toast.makeText(getApplicationContext(),"Save Records Successfully",Toast.LENGTH_LONG).show();








               }
           });
    }
}
