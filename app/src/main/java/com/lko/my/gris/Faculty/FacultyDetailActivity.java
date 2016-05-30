package com.lko.my.gris.Faculty;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.lko.my.gris.MainActivity;
import com.lko.my.gris.R;
import com.lko.my.gris.Student.StudentPostRequestActivity;

public class FacultyDetailActivity extends Activity {

    private RelativeLayout relative_view_reports, relative_addassignment,realative_faculityexit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_faculty_detail);
        relative_view_reports = (RelativeLayout)findViewById(R.id.relative_view_reports);
        relative_addassignment = (RelativeLayout)findViewById(R.id.relative_addassignment);
        realative_faculityexit = (RelativeLayout)findViewById(R.id.realative_faculityexit);

        Bundle bundle = getIntent().getExtras();
        final String id = bundle.getString("ID");

        relative_view_reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),FacultyViewRequestActivity.class);
                i.putExtra("IDS",id);
                startActivity(i);
            }
        });

        relative_addassignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),AddAssignmentActivity.class);
                startActivity(i);
            }
        });

        realative_faculityexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
    }


}
