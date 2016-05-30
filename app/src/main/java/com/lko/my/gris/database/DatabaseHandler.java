package com.lko.my.gris.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lko.my.gris.Utility;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by intex on 4/14/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 6;

    // Database Name
    private static final String DATABASE_NAME = "My";


    private static final String TABLE_ADDFACULTY = "add_faculty";
    private static final String TABLE_ADDSTUDENT = "add_student";
    private static final String TABLE_ADD_POST_DATA = "add_postdata";
    private static final String TABLE_PICTURE = "add_picture";

    // Contacts Table Columns names



    // Contacts Table Columns names for add faculty
    private static final String KEY_FACULTYID = "faculityid";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_NAME = "facultyname";
    private static final String KEY_DEPARTMENT = "department";
    private static final String KEY_MOBILENO = "mobile";


    // Contacts Table Columns names for add student
    private static final String KEY_STUDENTID = "studentid";
    private static final String KEY_STUDENT_EMAIL = "studentemail";
    private static final String KEY_STUDENT_PASSWORD = "studentpassword";
    private static final String KEY_STUDENT_NAME = "studentname";
    private static final String KEY_STUDENT_COURSE = "studentcourse";
    private static final String KEY_STUDENT_MOBILENO = "studentmobile";

    // Contacts Table Columns names for add post data student
    private static final String KEY_INCRI_ID = "incri_id";
    private static final String KEY_DATE = "date";
    private static final String KEY_STU_ID = "s_id";
    private static final String KEY_STU_POST_DEPARTMENT= "s_department";
    private static final String KEY_STU_TEXTFILE = "s_file";
    private static final String KEY_STU_STATUS = "s_status";
    private static final String KEY_STU_ANS = "s_ans";

// Table coloum name for save picture
    private static final String PICTURE_INCRI_ID = "incri_pic_id";
    private static final String PICTURE_COURSE = "pic_course";
    private static final String PICTURE_DATE = "pic_date";
    private static final String PICTURE_PHOTO = "pic_photo";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {



        String CREATE_TABLE_ADDFUCLTY = "CREATE TABLE " + TABLE_ADDFACULTY + "(" + KEY_FACULTYID + " TEXT PRIMARY KEY,"
                + KEY_EMAIL + " TEXT," + KEY_PASSWORD + " TEXT,"
                + KEY_NAME + " TEXT," + KEY_DEPARTMENT + " TEXT," +    KEY_MOBILENO + " TEXT"  +  ")";


        String CREATE_TABLE_ADDSTUDENT = "CREATE TABLE " + TABLE_ADDSTUDENT + "(" + KEY_STUDENTID + " TEXT PRIMARY KEY,"
                + KEY_STUDENT_EMAIL + " TEXT," + KEY_STUDENT_PASSWORD + " TEXT,"
                + KEY_STUDENT_NAME + " TEXT," + KEY_STUDENT_COURSE + " TEXT," +    KEY_STUDENT_MOBILENO + " TEXT"  +  ")";

        String  CREATE_TABLE_ADD_POST_DATA = "CREATE TABLE " + TABLE_ADD_POST_DATA + "(" + KEY_INCRI_ID + " integer primary key autoincrement,"
                + KEY_DATE + " TEXT," + KEY_STU_ID + " TEXT,"
                + KEY_STU_POST_DEPARTMENT + " TEXT," + KEY_STU_TEXTFILE + " TEXT," + KEY_STU_STATUS + " TEXT,"  +    KEY_STU_ANS + " TEXT"  +  ")";


         String CREATE_EMPLOYEES_TABLE = "create table "
                + TABLE_PICTURE + " (" + PICTURE_INCRI_ID
                + " integer primary key autoincrement," + PICTURE_COURSE
                + " text," + PICTURE_DATE + " text,"
                + PICTURE_PHOTO + " text" +  ");";


        db.execSQL(CREATE_TABLE_ADDFUCLTY);
        db.execSQL(CREATE_TABLE_ADDSTUDENT);
        db.execSQL(CREATE_TABLE_ADD_POST_DATA);
        db.execSQL(CREATE_EMPLOYEES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADDFACULTY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADDSTUDENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADD_POST_DATA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PICTURE);
        // Create tables again
        onCreate(db);
    }




    // code to add the new addBus
    public void addNewFaculty(AddFaculty addFaculty) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FACULTYID, addFaculty.getFacultyid());
        values.put(KEY_EMAIL, addFaculty.getEmail());
        values.put(KEY_PASSWORD, addFaculty.getPassword());
        values.put(KEY_NAME, addFaculty.getName());
        values.put(KEY_DEPARTMENT, addFaculty.getDepartment());
        values.put(KEY_MOBILENO, addFaculty.getMobile());



        // Inserting Row
        db.insert(TABLE_ADDFACULTY, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }



    public void addNewStudent(AddStudent addstudent) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_STUDENTID, addstudent.getStudentid());
        values.put(KEY_STUDENT_EMAIL, addstudent.getStudentemail());
        values.put(KEY_STUDENT_PASSWORD, addstudent.getStudentpassword());
        values.put(KEY_STUDENT_NAME, addstudent.getStudentname());
        values.put(KEY_STUDENT_COURSE, addstudent.getStudentcourse());
        values.put(KEY_STUDENT_MOBILENO, addstudent.getStudentmobile());



        // Inserting Row
        db.insert(TABLE_ADDSTUDENT, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }


    public void addStudent_Post_request(AddPostReguestData addpostdaat) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_DATE, addpostdaat.getDate());
        values.put(KEY_STU_ID, addpostdaat.getStudent_id());
        values.put(KEY_STU_POST_DEPARTMENT, addpostdaat.getDepartment());
        values.put(KEY_STU_TEXTFILE, addpostdaat.getFiletext());
        values.put(KEY_STU_STATUS, addpostdaat.getStatus());
        values.put(KEY_STU_ANS, addpostdaat.getAnswer());




        // Inserting Row
        db.insert(TABLE_ADD_POST_DATA, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }





    // code to get the single AddBus

    public void deleteSingleRow(String value)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_ADDFACULTY + " WHERE " + KEY_EMAIL + "='" + value + "'");
        db.close();
    }


    public List<String> showData(String u,String p)
    {
        SQLiteDatabase db =this.getReadableDatabase();

        List<String> list = new ArrayList<String>();

        String str="No Data Found";
        String query = "SELECT * FROM "+ TABLE_ADDFACULTY +" WHERE source=? and destination=?";
        Cursor cursor = db.rawQuery(query, new String[]{u, p});

        int c = cursor.getCount();

        if(c > 0)
        {
            while(cursor.moveToNext())
            {
                str = ""+cursor.getString(0)+":"+cursor.getString(1)+":"+cursor.getString(2)+"";
                list.add(str);
            }
        }
        return list;
    }

   public   List<AddFaculty> getAddFaculty(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
       List<AddFaculty> buslistList = new ArrayList<AddFaculty>();

       Cursor cursor = db.query(TABLE_ADDFACULTY, new String[]{KEY_FACULTYID, KEY_EMAIL, KEY_PASSWORD, KEY_NAME,
               KEY_DEPARTMENT, KEY_MOBILENO}, KEY_PASSWORD + "=?", new String[]{name}, null, null, null);

           if (cursor.moveToFirst()) {
               do {
                   AddFaculty addFaculty = new AddFaculty();
                   addFaculty.setFacultyid(cursor.getString(0));
                   addFaculty.setEmail(cursor.getString(1));
                   addFaculty.setPassword(cursor.getString(2));
                   addFaculty.setName(cursor.getString(3));
                   addFaculty.setDepartment(cursor.getString(4));
                   addFaculty.setMobile(cursor.getString(5));
                   buslistList.add(addFaculty);
           // return contact

               } while (cursor.moveToNext());
           }
           return buslistList;


    }




    public List<AddFaculty> getAllAddFacultyData() {
        List<AddFaculty> buslistList = new ArrayList<AddFaculty>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ADDFACULTY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                AddFaculty addFaculty = new AddFaculty();
                //contact.setID(Integer.parseInt(cursor.getString(0)));
                addFaculty.setFacultyid(cursor.getString(0));
                addFaculty.setEmail(cursor.getString(1));
                addFaculty.setPassword(cursor.getString(2));
                addFaculty.setName(cursor.getString(3));
                addFaculty.setDepartment(cursor.getString(4));
                addFaculty.setMobile(cursor.getString(5));

                // Adding contact to list
                buslistList.add(addFaculty);
            } while (cursor.moveToNext());
        }
        // return contact list
        return buslistList;
    }


    public List<AddStudent> getAllAddStudentData() {
        List<AddStudent> buslistList = new ArrayList<AddStudent>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ADDSTUDENT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                AddStudent addstudent = new AddStudent();
                //contact.setID(Integer.parseInt(cursor.getString(0)));
                addstudent.setStudentid(cursor.getString(0));
                addstudent.setStudentemail(cursor.getString(1));
                addstudent.setStudentpassword(cursor.getString(2));
                addstudent.setStudentname(cursor.getString(3));
                addstudent.setStudentcourse(cursor.getString(4));
                addstudent.setStudentmobile(cursor.getString(5));

                // Adding contact to list
                buslistList.add(addstudent);
            } while (cursor.moveToNext());
        }
        // return contact list
        return buslistList;
    }

    public List<AddPostReguestData> getAllPostRequestData() {
        List<AddPostReguestData> List = new ArrayList<AddPostReguestData>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ADD_POST_DATA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                AddPostReguestData data = new AddPostReguestData();
                //contact.setID(Integer.parseInt(cursor.getString(0)));
                data.setAuto_id(cursor.getString(0));
                data.setDate(cursor.getString(1));
                data.setStudent_id(cursor.getString(2));
                data.setDepartment(cursor.getString(3));
                data.setFiletext(cursor.getString(4));
                data.setStatus(cursor.getString(5));
                data.setAnswer(cursor.getString(6));
                // Adding contact to list
                List.add(data);
            } while (cursor.moveToNext());
        }
        // return contact list
        return List;
    }



    // Getting AddBusData Count
    public int getAddBusCount() {
        String countQuery = "SELECT  * FROM " + TABLE_ADDFACULTY;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }



    public boolean updatedetails(String rowId,String date,String text, String status)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues args = new ContentValues();

        args.put(KEY_DATE, date);
        args.put(KEY_STU_ANS, text);
        args.put(KEY_STU_STATUS, status);
        int i =  db.update(TABLE_ADD_POST_DATA, args, KEY_INCRI_ID + "=" + rowId, null);
        return i > 0;
    }

/*
    public boolean insertcontacts(String name, String status, String from, String image) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("status", status);
        contentValues.put("`from`", from);
        contentValues.put("image", image);
        db.insert("contacts", null, contentValues);
        return true;
    }*/

/*
    public void insertAllContacts() {
        for (Picture contact : Contact.getContacts()) {
            insertcontacts(contact.getName(), contact.getStatus(), contact.getFrom(), contact.getImage());
        }
    }
*/

    public void addPicture(Picture picture) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PICTURE_COURSE, picture.getCourse());
        values.put(PICTURE_DATE, picture.getDate());
        values.put(PICTURE_PHOTO, picture.getBmp());


        // Inserting Row
        db.insert(TABLE_PICTURE, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public ArrayList<Picture> getAllPicture() {
        ArrayList<Picture> contactArrayList = new ArrayList();
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_PICTURE, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            contactArrayList.add(new Picture(
                    cursor.getString(cursor.getColumnIndex(PICTURE_COURSE)),
                    cursor.getString(cursor.getColumnIndex(PICTURE_DATE)),
                    cursor.getString(cursor.getColumnIndex(PICTURE_PHOTO))
            ));


            cursor.moveToNext();
        }
        return contactArrayList;
    }

}
