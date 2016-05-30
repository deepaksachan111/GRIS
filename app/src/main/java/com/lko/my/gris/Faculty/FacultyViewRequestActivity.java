package com.lko.my.gris.Faculty;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.lko.my.gris.R;
import com.lko.my.gris.database.AddPostReguestData;
import com.lko.my.gris.database.DatabaseHandler;
import com.lko.my.gris.database.Picture;

import java.util.ArrayList;
import java.util.List;

public class FacultyViewRequestActivity extends Activity {

    private DatabaseHandler db ;
  private  ListView listView;
    private  String s_id,     date,text, auto_id;
    ArrayList<AddPostReguestData> datalist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_view_request);
        db = new DatabaseHandler(this);
        s_id  = getIntent().getStringExtra("IDS");
       listView =(ListView)findViewById(R.id.listview);
        LayoutInflater  inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup)inflater.inflate(R.layout.faculity_viewrequest_header,listView,false);
        listView.addHeaderView(header);






        List<AddPostReguestData> getlist = db.getAllPostRequestData();

        if(getlist.size()> 0){

            for(AddPostReguestData postReguestData : getlist){

                     auto_id=postReguestData.getAuto_id();
                     date = postReguestData.getDate();
                     text = postReguestData.getFiletext();
                     String dept = postReguestData.getDepartment();
                  String status  = postReguestData.getStatus();

                datalist.add(new AddPostReguestData(date,dept,text,status));
            }
        }

        UsersAdapter custumAdapter = new UsersAdapter(this,datalist);
        listView.setAdapter(custumAdapter);


    }





    public class UsersAdapter extends ArrayAdapter<AddPostReguestData> {

        ArrayList<AddPostReguestData>  addPostReguestDataslist;

        public UsersAdapter(Context context, ArrayList<AddPostReguestData> users) {
            super(context, 0, users);
            this.addPostReguestDataslist = users;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // Get the data item for this position

            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_request_adapter, parent, false);
            }
            // Lookup view for data population
           // TextView dt =(TextView)convertView.findViewById(R.id.adapter_date);
            TextView dep =(TextView)convertView.findViewById(R.id.adapter_department);
            TextView txt =(TextView)convertView.findViewById(R.id.adapter_text);
            TextView sts =(TextView)convertView.findViewById(R.id.adapter_staus);
            Button button =(Button)convertView.findViewById(R.id.btn_sendAction);


           AddPostReguestData addPostReguest  = (AddPostReguestData) addPostReguestDataslist.get(position);

          //  dt.setText(addPostReguest.getDate());
            dep.setText(addPostReguest.getDepartment());
            txt.setText(addPostReguest.getFiletext());
            sts.setText(addPostReguest.getStatus());
            // Return the completed view to render on screen


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int positionss = listView.getPositionForView(v);
                    positionss--;
                    AddPostReguestData ddd = (addPostReguestDataslist).get(positionss);

                    String aid = ddd.getAuto_id();
                    String txt = ddd.getFiletext();
                    String dt = ddd .getDate();
                    String sts = ddd .getStatus();

                          int pos = positionss++;

                      int p = pos +1;



                        Intent intent = new Intent(getApplicationContext(), SendActionActivity.class);

                        intent.putExtra("SID", String.valueOf(p));
                        intent.putExtra("DT", dt);
                        intent.putExtra("TXT", txt);
                       intent.putExtra("STS", sts);

                        startActivity(intent);

                }
            });

            return convertView;
        }
    }
}
