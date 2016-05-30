package com.lko.my.gris.Faculty;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lko.my.gris.R;
import com.lko.my.gris.database.DatabaseHandler;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SendActionActivity extends Activity{

    private DatabaseHandler db;
    private  String stu_id, autoid ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_action);
         db = new DatabaseHandler(this);



        SharedPreferences mPrefs = getSharedPreferences("MY",0);
        stu_id  = mPrefs.getString("STUDENTID", "");

         autoid = getIntent().getStringExtra("SID");
        String txt = getIntent().getStringExtra("TXT");
        String adte = getIntent().getStringExtra("DT");
        TextView date =(TextView)findViewById(R.id.action_send_Date);
        TextView textView1 =(TextView)findViewById(R.id.action_send_studen_id);
        TextView textView2 =(TextView)findViewById(R.id.action_send_text);
        Button button =(Button)findViewById(R.id.btn_action_update);
        final EditText editText =(EditText)findViewById(R.id.edt_action_updatetext);
         Button sendtphod =(Button)findViewById(R.id.btn_action_sendtohod);




        textView1.setText(stu_id);
        textView2.setText(txt);
        date.setText(adte);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        final String dates = dateFormat.format(c.getTime());


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String gettext = editText.getText().toString();
                db.updatedetails(autoid,dates, gettext, "Replied");

                Toast.makeText(getApplicationContext(),"Send",1000).show();
            }
        });

        sendtphod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String gettext = editText.getText().toString();
                db.updatedetails(autoid,dates, gettext, "Send To H.O.D");
                Toast.makeText(getApplicationContext(),"Send to H.O.D",1000).show();
            }
        });


    }


}
