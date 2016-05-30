package com.lko.my.gris.Student;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lko.my.gris.MainActivity;
import com.lko.my.gris.R;
import com.lko.my.gris.database.AddStudent;
import com.lko.my.gris.database.DatabaseHandler;

import java.util.ArrayList;
import java.util.List;

public class StudentDetailActivity extends Activity {

    DatabaseHandler databaseHandler ;

    private TextView txtid,txtname,txtbranch;

   private  String id ,name ,corse;

 private RelativeLayout relative_student_postrequest, stu_viewstatus_realtive, relative_downloadattachment,student_ext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);



        databaseHandler = new DatabaseHandler(this);

        List<AddStudent> studata = databaseHandler.getAllAddStudentData();

        for(AddStudent addStudent : studata){

            id = addStudent.getStudentid();
           corse = addStudent.getStudentcourse();
          name = addStudent.getStudentname();
        }

        Bundle bundle = getIntent().getExtras();
        final String ids = bundle.getString("ID");
       txtbranch = (TextView)findViewById(R.id.branch_studetail);
        txtid = (TextView)findViewById(R.id.student_id_studetail);
        txtname = (TextView)findViewById(R.id.student_name_studetail);

        relative_student_postrequest =(RelativeLayout)findViewById(R.id.relative_student_postrequest);
        stu_viewstatus_realtive =(RelativeLayout)findViewById(R.id.stu_viewstatus_realtive);
        relative_downloadattachment =(RelativeLayout)findViewById(R.id.relative_downloadattachment);
        student_ext =(RelativeLayout)findViewById(R.id.student_ext);

        txtid.setText(id);
        txtname.setText(name);
        txtbranch.setText(corse);

        relative_student_postrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),StudentPostRequestActivity.class);
                i.putExtra("IDS",ids);
                startActivity(i);
            }
        });

        stu_viewstatus_realtive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),ViewStatusActivity.class);

                startActivity(i);
            }
        });


        relative_downloadattachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =new Intent(getApplicationContext(),DownloadStudentAttachment.class);

                startActivity(i);;
            }
        });

        student_ext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
    }


}
