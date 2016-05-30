package com.lko.my.gris.Student;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lko.my.gris.R;
import com.lko.my.gris.database.DatabaseHandler;
import com.lko.my.gris.database.Picture;

import java.util.ArrayList;
import java.util.HashMap;

public class DownloadStudentAttachment extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_student_attachment);
        LayoutInflater inflater = getLayoutInflater();

        ListView listView = (ListView) findViewById(R.id.listview_downlaod_attachment);
        ViewGroup header = (ViewGroup)inflater.inflate(R.layout.downloadheader, listView, false);
        listView.addHeaderView(header, null, false);


        DatabaseHandler dbHelper = new DatabaseHandler(this);

        ArrayList<Picture> messageArrayList = dbHelper.getAllPicture();

        ArrayList<Picture> addlist =  new ArrayList<>();
        for(Picture c : messageArrayList){
            String couse = c.getCourse();
            String date = c.getDate();
            String imd = c.getBmp();

            addlist.add(new Picture(couse,date,imd));
        }




        MyAdapterDispayUser  myAdapterDispayUser = new MyAdapterDispayUser(this,R.layout.adapter_download_attachment,addlist);

        //MyAdapterDispayUser myAdapterDispayUser = new MyAdapterDispayUser(this,R.layout.sms_row,Message.getMessages());

        listView.setAdapter(myAdapterDispayUser);
       // listView.smoothScrollToPosition(myAdapterDispayUser.getCount()-1);
        listView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
    }


    public class MyAdapterDispayUser extends ArrayAdapter<Picture> {
        private ArrayList<Picture> messageArrayAdapter;
        private Context context;

        // MediaPlayer mediaPlayer;
        private HashMap<Integer, AsyncTask> integerAsyncTaskHashMap = new HashMap<Integer, AsyncTask>();

        public MyAdapterDispayUser(Context context, int resource, ArrayList<Picture> messageArrayAdapter) {
            super(context, resource, messageArrayAdapter);
            this.context = context;
            this.messageArrayAdapter = messageArrayAdapter;

        }

         class ViewHolder {
            public TextView course;
            public TextView date;
             public Button downlad;
            public ImageView imageView;
            public int position;


        }

        @Override
        public View getView(final int position, View convertview, ViewGroup parent) {

            if (convertview == null) {
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View rowView = layoutInflater.inflate(R.layout.adapter_download_attachment, parent, false);
                TextView tv_course = (TextView) rowView.findViewById(R.id.ada_couse);

                final Picture message = messageArrayAdapter.get(position);
                tv_course.setText(message.getCourse());

                TextView tv_date = (TextView) rowView.findViewById(R.id.ada_date);
                tv_date.setText(message.getDate());

                ImageView imageView = (ImageView) rowView.findViewById(R.id.ada_iv_picture);

                Button  btn_download =(Button)rowView.findViewById(R.id.btn_ada_download);
        /*Bitmap bmp = BitmapFactory.decodeFile(message.getImage());
        imageView.setImageBitmap(bmp);*/


                // videoView.setVideoURI(Uri.parse(message.getVideo()));
                final ViewHolder viewHolder = new ViewHolder();
                viewHolder.course = tv_course;
                viewHolder.date = tv_date;
                viewHolder.imageView = imageView;
                viewHolder.downlad = btn_download;



               viewHolder.downlad.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MyDisplayAsynctask myDisplayAsynctask = new MyDisplayAsynctask(viewHolder);
                        myDisplayAsynctask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, message.getBmp());
                        integerAsyncTaskHashMap.put(position, myDisplayAsynctask);
                        rowView.setTag(viewHolder);
                    }
                });


                return rowView;
            }
             ViewHolder viewHolder = (ViewHolder) convertview.getTag();
            return convertview;
            /*else {




                final Picture message = messageArrayAdapter.get(position);
                final ViewHolder viewHolder = (ViewHolder) convertview.getTag();
                AsyncTask asyncTask = integerAsyncTaskHashMap.remove(viewHolder.position);
                if (asyncTask != null) {
                    asyncTask.cancel(true);
                }
                viewHolder.downlad.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MyDisplayAsynctask myDisplayAsynctask = new MyDisplayAsynctask(viewHolder);
                        myDisplayAsynctask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, message.getBmp());
                        integerAsyncTaskHashMap.put(position, myDisplayAsynctask);
                        viewHolder.course.setText(message.getDate());
                    }
                });

                return convertview;
            }*/
        }

        private class MyDisplayAsynctask extends AsyncTask<String, Void, Bitmap> {
            private int pos;
            private ViewHolder viewHolder;

            public MyDisplayAsynctask(ViewHolder viewHolder) {
                this.viewHolder = viewHolder;
                this.pos = viewHolder.position;
            }

            @Override
            protected void onPreExecute() {
                viewHolder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.loading));

            }

            @Override
            protected Bitmap doInBackground(String... params) {
                try {
                    return BitmapFactory.decodeFile(params[0]);
                } catch (Exception e) {
                    Log.v("", "", e);
                    return null;

                }

            }

            @Override
            protected void onPostExecute(Bitmap result) {
                super.onPostExecute(result);
                if (viewHolder.position == pos && result != null) {
                    viewHolder.imageView.setVisibility(View.VISIBLE);
                    viewHolder.imageView.setImageBitmap(result);
                }
            }
        }

    }
}
