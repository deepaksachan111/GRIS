package com.lko.my.gris.Student;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lko.my.gris.R;
import com.lko.my.gris.database.AddFaculty;
import com.lko.my.gris.database.AddStudent;
import com.lko.my.gris.database.DatabaseHandler;

public class NewStudentActivity extends Activity {
    private EditText edtstudent_id,email,name,password,course,mobileno;
    private DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);

        db = new DatabaseHandler(this);


        edtstudent_id =(EditText)findViewById(R.id.edt_stu_id);
        email =(EditText)findViewById(R.id.edt_stu_email);
        password =(EditText)findViewById(R.id.edt_stu_password);
        name =(EditText)findViewById(R.id.edt_stu_name);
        course =(EditText)findViewById(R.id.edt_stu_course);
        mobileno =(EditText)findViewById(R.id.edt_stu_mobile);

        Button btn_save = (Button)findViewById(R.id.btn_newstudent_save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ids, emails, passwords, names, departments, mobiles;
                ids = edtstudent_id.getText().toString().trim();
                emails = email.getText().toString().trim();
                passwords = password.getText().toString().trim();
                names = name.getText().toString().trim();
                departments = course.getText().toString().trim();
                mobiles = mobileno.getText().toString().trim();

                if (ids.length() < 1) {
                    Toast.makeText(getApplicationContext(), "enter facultyID", 1000).show();
                } else if (emails.length() < 5) {
                    Toast.makeText(getApplicationContext(), "enter valid email", 1000).show();
                } else if (passwords.length() < 4) {
                    Toast.makeText(getApplicationContext(), "enter valid password", 1000).show();
                } else if (names.length() < 3) {
                    Toast.makeText(getApplicationContext(), "enter valid Name", 1000).show();
                } else if (departments.length() < 2) {
                    Toast.makeText(getApplicationContext(), "enter valid Department", 1000).show();
                } else if (mobiles.length() < 10) {
                    Toast.makeText(getApplicationContext(), "enter valid mobileno", 1000).show();
                } else {

                    db.addNewStudent(new AddStudent(ids, emails, passwords, names, departments, mobiles));

                    Toast.makeText(getApplicationContext(), "Save Records Sucessfully", 1000).show();

                }
            }
        });
    }




}
