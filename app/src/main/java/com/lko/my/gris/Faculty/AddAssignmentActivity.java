package com.lko.my.gris.Faculty;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.lko.my.gris.R;
import com.lko.my.gris.Utils;
import com.lko.my.gris.database.DatabaseHandler;
import com.lko.my.gris.database.Picture;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class AddAssignmentActivity extends Activity {
    private static final String TAG = "AddAssignmentActivity";
    EditText editText1, date,course;
    String dates, courses,pict;
    private Button save_btn;
    private ImageView imageView;
    private DatabaseHandler dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assignment);
        dbHelper = new DatabaseHandler(this);

        editText1 =(EditText)findViewById(R.id.edt_select_image);
        course =(EditText)findViewById(R.id.edt_course_add_assignment);
        date =(EditText)findViewById(R.id.edt_date_add_assignment);
        imageView =(ImageView)findViewById(R.id.selected_pix);
        save_btn =(Button)findViewById(R.id.btn_save_addassignment);



        editText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImageChooser();
            }
        });


        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courses =course.getText().toString();
                dates = date.getText().toString();

              if(courses.equals("")|| dates.equals("")){

                  Toast.makeText(getApplicationContext(),"please enter all fields",Toast.LENGTH_LONG).show();
              }else{

                   DatabaseHandler dbHelper = new DatabaseHandler(getApplicationContext());
          dbHelper.addPicture(new Picture(courses, dates, pict));
                  Toast.makeText(getApplicationContext(),"save records",Toast.LENGTH_LONG).show();

              }
            }
        });
    }
    void openImageChooser() {
     /*   Intent intent = new Intent();
        intent.setType("image*//*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
*/
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
// Start the Intent
        startActivityForResult(galleryIntent, 1);
    }




    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && null != data) {

            Uri selectedImage = data.getData();

            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            pict = cursor.getString(columnIndex);

            editText1.setText(pict);

           /* DatabaseHandler dbHelper = new DatabaseHandler(getApplicationContext());
          dbHelper.addPicture(new Picture("one", "two", picturePath));*/



          /*  myAdapterDispayUser.add(message);
            myAdapterDispayUser.notifyDataSetChanged();
            listView.smoothScrollToPosition(myAdapterDispayUser.getCount()-1);*/

            cursor.close();


        }

    }






























































  /*  public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {

                Uri selectedImageUri = data.getData();

                if (null != selectedImageUri) {
                    String path = getPathFromURI(selectedImageUri);
                    imageView.setImageURI(selectedImageUri);
                      editText1.setText(path);
                    Log.v(TAG,path);

                    String s =path;
                    // Saving to Database...
                *//*    if (saveImageInDB(selectedImageUri)) {
                      //  showMessage("Image Saved in Database...");
                       // imgView.setImageURI(selectedImageUri);


                    }

                    // Reading from Database after 3 seconds just to show the message
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (loadImageFromDB()) {
                             //   showMessage("Image Loaded from Database...");
                            }
                        }
                    }, 3000);*//*
                }

            }
        }
    }

    public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }*/


}



