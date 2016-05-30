package com.lko.my.gris.Student;

import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lko.my.gris.R;
import com.lko.my.gris.database.AddStudent;
import com.lko.my.gris.database.DatabaseHandler;

import java.util.List;

/**
 * A login screen that offers login via email/password.
 */
public class StudentLoginActivity extends Activity  {
  DatabaseHandler db;

    private EditText email, password;

    private String dataemail;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        db = new DatabaseHandler(this);
        Button btn_newstudent =(Button)findViewById(R.id.btn_new_student);
        Button btn_signin =(Button)findViewById(R.id.btn_studentlogin);

        email =(EditText)findViewById(R.id.edt_stu_email_login);
        password =(EditText)findViewById(R.id.edt_stu_password_login);

        btn_newstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NewStudentActivity.class));
            }
        });







        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String emails= email.getText().toString();
                   String passwords= password.getText().toString();
                String dataid="" ,datapassword ="",dataname ="",datacourse,datamobile;

                List<AddStudent> data=  db.getAllAddStudentData();
                int  i = data.size();

                if(data.size() >0){
                    for (AddStudent datas : data){
                        dataid = datas.getStudentid();
                        dataemail = datas.getStudentemail();
                        datapassword = datas.getStudentpassword();
                        dataname = datas.getStudentname();
                        datacourse = datas.getStudentcourse();
                        datamobile = datas.getStudentmobile();
                        //getsearchList.add(new AddBusData(busno,source, desitnatin,arrival,depature,fare));
                    }
                }

            /*    sharedPreferences = getSharedPreferences("MY", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("STUDENTID",dataid);
                editor.commit();
*/

                if(emails.equals(dataemail)&& passwords.equals(datapassword)){

                    Intent intent = new Intent(getApplicationContext(),StudentDetailActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("ID",dataid);
                    intent.putExtras(bundle);

                    startActivity(intent);



                    Toast.makeText(getApplicationContext(),"Welcome "+ dataname,1000).show();
                }else{
                    Toast.makeText(getApplicationContext(),"invalid user name or password ",1000).show();
                }
            }
        });



    }


}

