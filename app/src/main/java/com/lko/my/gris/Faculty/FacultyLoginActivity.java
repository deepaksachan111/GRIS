package com.lko.my.gris.Faculty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lko.my.gris.R;
import com.lko.my.gris.database.AddFaculty;
import com.lko.my.gris.database.DatabaseHandler;

import java.util.List;

public class FacultyLoginActivity extends Activity {
    DatabaseHandler db;
   private EditText edtemail,edtpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_login);

         db = new DatabaseHandler(this);

        Button btn_signin =(Button)findViewById(R.id.btn_facultylogin);
        Button btn_newfaculty =(Button)findViewById(R.id.btn_new_faculty);

        edtemail =(EditText)findViewById(R.id.edt_email_faculty_login);
        edtpassword =(EditText)findViewById(R.id.edt_password_faculty_login);

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emails= edtemail.getText().toString();
                String passwords= edtpassword.getText().toString();
                String dataid ="", dataemail="",datapassword ="",dataname ="",datadepartment,datamobile;

                List<AddFaculty> data=  db.getAllAddFacultyData();
                int  i = data.size();

                if(data.size() >0){
                    for (AddFaculty datas : data){
                        dataid = datas.getFacultyid();
                        dataemail = datas.getEmail();
                        datapassword = datas.getPassword();
                        dataname = datas.getName();
                        datadepartment = datas.getDepartment();
                        datamobile = datas.getMobile();
                        //getsearchList.add(new AddBusData(busno,source, desitnatin,arrival,depature,fare));
                    }
                }

                if(emails.equals(dataemail)&& passwords.equals(datapassword)){
                    Intent intent = new Intent(getApplicationContext(),FacultyDetailActivity.class);
                    Bundle bundle = new Bundle();

                      bundle.putString("ID",dataid);
                    intent.putExtras(bundle);
                    startActivity(intent);

                    Toast.makeText(getApplicationContext(), "Welcome " + dataname, 1000).show();
                }else{
                    Toast.makeText(getApplicationContext(),"invalid user name or password ",1000).show();
                }
            }
        });






        btn_newfaculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NewFaculityActivity.class));
            }
        });
    }


}
