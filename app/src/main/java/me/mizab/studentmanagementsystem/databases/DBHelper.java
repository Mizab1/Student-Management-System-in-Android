package me.mizab.studentmanagementsystem.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import me.mizab.studentmanagementsystem.model.StudInfo;

public class DBHelper extends SQLiteOpenHelper {
    public static final String TAG = "DBHelper";
    // DB- Info
    public static final String TABLE_NAME = "stud_table";
    public static final String DB_NAME = "stud_db";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_ROLL_NO = "rollNo";
    public static final String COL_AGE = "age";
    public static final String COL_GENDER = "gender";
    public static final String COL_ENROLLMENT = "enrollment";
    public static final String COL_EMAIL = "email";
    public static final String COL_BRANCH = "branch";
    public static final String COL_YEAR = "year";
    public static final String COL_PHONE = "phone";
    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " TEXT, "
                + COL_AGE + " VARCHAR, "
                + COL_ROLL_NO + " VARCHAR, "
                + COL_GENDER + " VARCHAR,"
                + COL_ENROLLMENT + " VARCHAR,"
                + COL_EMAIL + " VARCHAR, "
                + COL_BRANCH + " TEXT, "
                + COL_YEAR + " VARCHAR, "
                + COL_PHONE + " VARCHAR" +
                ")";
        Log.d(TAG, "createDB: Creating " + DB_NAME);
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addInfo(StudInfo studInfo){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, studInfo.getName());
        contentValues.put(COL_ROLL_NO, studInfo.getRollNo());
        contentValues.put(COL_AGE, studInfo.getAge());
        contentValues.put(COL_GENDER, studInfo.getGender());
        contentValues.put(COL_EMAIL, studInfo.getEmail());
        contentValues.put(COL_BRANCH, studInfo.getBranch());
        contentValues.put(COL_YEAR, studInfo.getYear());
        contentValues.put(COL_PHONE, studInfo.getPhone());
        contentValues.put(COL_ENROLLMENT, studInfo.getEnrollNo());
        db.insert(TABLE_NAME, null, contentValues);

        Log.d(TAG, "addData: Adding to " + TABLE_NAME);
    }

    public void updateInfo(StudInfo studInfo, String id){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, studInfo.getName());
        contentValues.put(COL_ROLL_NO, studInfo.getRollNo());
        contentValues.put(COL_AGE, studInfo.getAge());
        contentValues.put(COL_GENDER, studInfo.getGender());
        contentValues.put(COL_EMAIL, studInfo.getEmail());
        contentValues.put(COL_BRANCH, studInfo.getBranch());
        contentValues.put(COL_YEAR, studInfo.getYear());
        contentValues.put(COL_PHONE, studInfo.getPhone());
        contentValues.put(COL_ENROLLMENT, studInfo.getEnrollNo());
        db.update(TABLE_NAME, contentValues, "id=?", new String[]{id});

        Log.d(TAG, "addData: Adding to " + TABLE_NAME);
    }

    public void deleteInfo(String id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, "id=?", new String[]{id});
    }

    public List<StudInfo> getAllInfo(){
        List<StudInfo> studInfos = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                StudInfo studInfo = new StudInfo();
                studInfo.setId(cursor.getInt(0));
                studInfo.setName(cursor.getString(1));
                studInfo.setAge(cursor.getString(2));
                studInfo.setRollNo(cursor.getString(3));
                studInfo.setGender(cursor.getString(4));
                studInfo.setEnrollNo(cursor.getString(5));
                studInfo.setEmail(cursor.getString(6));
                studInfo.setBranch(cursor.getString(7));
                studInfo.setYear(cursor.getString(8));
                studInfo.setPhone(cursor.getString(9));
                studInfos.add(studInfo);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return studInfos;
    }

    public ArrayList<StudInfo> getInfoById(String id){
        ArrayList<StudInfo> studInfos = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] args = new String[1];
        args[0] = id;
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
        Cursor cursor = db.rawQuery(query, args);
        if(cursor.moveToFirst()){
            do{
                StudInfo studInfo = new StudInfo();
                studInfo.setId(cursor.getInt(0));
                studInfo.setName(cursor.getString(1));
                studInfo.setAge(cursor.getString(2));
                studInfo.setRollNo(cursor.getString(3));
                studInfo.setGender(cursor.getString(4));
                studInfo.setEnrollNo(cursor.getString(5));
                studInfo.setEmail(cursor.getString(6));
                studInfo.setBranch(cursor.getString(7));
                studInfo.setYear(cursor.getString(8));
                studInfo.setPhone(cursor.getString(9));
                studInfos.add(studInfo);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return studInfos;
    }
}
