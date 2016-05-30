package com.lko.my.gris.Faculty;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lko.my.gris.R;
import com.lko.my.gris.database.AddFaculty;
import com.lko.my.gris.database.DatabaseHandler;

public class NewFaculityActivity extends Activity {
private EditText edtfaculty_id,email,name,password,department,mobileno;
    private DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_faculity);
        db = new DatabaseHandler(this);


        edtfaculty_id =(EditText)findViewById(R.id.edt_facultyid);
        email =(EditText)findViewById(R.id.edt_facultyemail);
        name =(EditText)findViewById(R.id.edt_facultyname);
        password =(EditText)findViewById(R.id.edt_facultypassword);
        department =(EditText)findViewById(R.id.edt_faculty_department);
        mobileno =(EditText)findViewById(R.id.edt_facultymobileno);

        Button btn_save = (Button)findViewById(R.id.btn_save_newfaculity);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ids, emails,passwords,names,departments,mobiles;
                ids = edtfaculty_id.getText().toString().trim();
                emails=email.getText().toString().trim();
                passwords = password.getText().toString().trim();
                names = name.getText().toString().trim();
                departments = department.toString().trim();
                mobiles = mobileno.getText().toString().trim();

                if(ids.length()<1){
                    Toast.makeText(getApplicationContext(),"enter facultyID",1000).show();
                }else if (emails.length()<5){
                    Toast.makeText(getApplicationContext(),"enter valid email",1000).show();
                }

                else if(passwords.length()<4){
                    Toast.makeText(getApplicationContext(),"enter valid password",1000).show();
                }
                else if(names.length()<3){
                    Toast.makeText(getApplicationContext(),"enter valid Name",1000).show();
                }

                else if(departments.length()<2){
                    Toast.makeText(getApplicationContext(),"enter valid Department",1000).show();
                }
                else if(mobiles.length()<10){
                    Toast.makeText(getApplicationContext(),"enter valid mobileno",1000).show();
                }else {

                db.addNewFaculty(new AddFaculty(ids,emails,passwords,names,departments,mobiles));

                    Toast.makeText(getApplicationContext(),"Save Records Sucessfully",1000).show();

                }
            }
        });

    }



}
