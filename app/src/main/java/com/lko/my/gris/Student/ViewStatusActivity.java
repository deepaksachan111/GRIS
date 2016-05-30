package com.lko.my.gris.Student;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.lko.my.gris.Faculty.SendActionActivity;
import com.lko.my.gris.R;
import com.lko.my.gris.database.AddPostReguestData;
import com.lko.my.gris.database.DatabaseHandler;

import java.util.ArrayList;
import java.util.List;

public class ViewStatusActivity extends Activity {
    private DatabaseHandler db;
    private ListView listView;
    private String s_id, date, text, auto_id;
    ArrayList<AddPostReguestData> datalists = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_status);



            db = new DatabaseHandler(this);
            s_id = getIntent().getStringExtra("IDS");
            listView = (ListView) findViewById(R.id.listview_view_status);
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header =(ViewGroup)inflater.inflate(R.layout.view_status_header,listView,false);
        listView.addHeaderView(header);


        

            List<AddPostReguestData> getlist = db.getAllPostRequestData();

            if (getlist.size() > 0) {

                for (AddPostReguestData postReguestData : getlist) {

                    //auto_id = postReguestData.getAuto_id();
                    date = postReguestData.getDate();
                    text = postReguestData.getFiletext();
                   // String dept = postReguestData.getDepartment();
                    String status = postReguestData.getStatus();
                    String answer = postReguestData.getAnswer();

                    datalists.add(new AddPostReguestData(date, text, status,answer,""));
                }
            }

            UsersAdapter22 custumAdapter = new UsersAdapter22(this, datalists);
            listView.setAdapter(custumAdapter);


        }


         class UsersAdapter22 extends ArrayAdapter<AddPostReguestData> {

            ArrayList<AddPostReguestData> addPostReguestDataslist;

            public UsersAdapter22(Context context, ArrayList<AddPostReguestData> users) {
                super(context, 0, users);
                this.addPostReguestDataslist = users;
            }

            @Override
            public View getView( int position, View convertView, ViewGroup parent) {
                // Get the data item for this position

                // Check if an existing view is being reused, otherwise inflate the view
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_status_adapter, parent, false);
                }
                // Lookup view for data population
                // TextView dt =(TextView)convertView.findViewById(R.id.adapter_date);
                TextView date = (TextView) convertView.findViewById(R.id.adapter_view_status_date);
                TextView detail = (TextView) convertView.findViewById(R.id.adapter_view_status_detail);
                TextView sts = (TextView) convertView.findViewById(R.id.adapter_view_status_staus);
                TextView ans = (TextView) convertView.findViewById(R.id.adapter_view_status_answer);


                AddPostReguestData addPostReguest = (AddPostReguestData) addPostReguestDataslist.get(position);

                //  dt.setText(addPostReguest.getDate());
                String answer = addPostReguest.getAnswer();

               // Log.v(".......................................", addPostReguest.getAnswer());
                date.setText(addPostReguest.getDate());
                detail.setText(addPostReguest.getFiletext());
                sts.setText(addPostReguest.getStatus());



                if(answer == null){
                    ans.setText("Not Assgined");
                }else {

                    ans.setText(answer);
                }

                // Return the completed view to render on screen

/*
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int positionss = listView.getPositionForView(v);
                        AddPostReguestData ddd = (addPostReguestDataslist).get(positionss);


                        String txt = ddd.getFiletext();
                        String dt = ddd.getDate();


                        positionss++;

                        Intent intent = new Intent(getApplicationContext(), SendActionActivity.class);

                        intent.putExtra("SID", String.valueOf(positionss));
                        intent.putExtra("DT", dt);
                        intent.putExtra("TXT", txt);

                        startActivity(intent);

                    }
                });*/

                return convertView;
            }
        }

    }

