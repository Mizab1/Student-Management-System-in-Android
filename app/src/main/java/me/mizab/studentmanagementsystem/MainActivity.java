package me.mizab.studentmanagementsystem;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import me.mizab.studentmanagementsystem.databases.DBHelper;
import me.mizab.studentmanagementsystem.general.AddActivity;
import me.mizab.studentmanagementsystem.general.Browse;
import me.mizab.studentmanagementsystem.general.DeleteActivityList;
import me.mizab.studentmanagementsystem.general.UpdateActivityList;
import me.mizab.studentmanagementsystem.model.StudInfo;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        this.deleteDatabase("stud_db");
//        DBHelper mDBHelper = new DBHelper(getApplicationContext());
//        mDBHelper.addInfo(new StudInfo("Male", "Mizab Ansari", "19", "6", "2001160168", "mizab@gmail.com", "CO", "TY", "9876543210"));
//        mDBHelper.addInfo(new StudInfo("Male", "Rizwan Khan", "18", "63", "2001160168", "rizwan@gmail.com", "CO", "TY", "9876543210"));
//        mDBHelper.addInfo(new StudInfo("Female", "Somya Cholle", "18", "59", "2001160069", "somya@gmail.com", "CO", "TY", "9873333210"));
//        mDBHelper.addInfo(new StudInfo("Female", "Mayuri Gaikwad", "17", "5", "2001169069", "mayuri@gmail.com", "CO", "TY", "1122334455"));
//        mDBHelper.addInfo(new StudInfo("Male", "Raj Singh", "18", "55", "2001160168", "raj@gmail.com", "CO", "TY", "9876543210"));
//        mDBHelper.addInfo(new StudInfo("Male", "Advaitya Jadhav", "20", "1", "1901160097", "advaitya@gmail.com", "CO", "TY", "9911223344"));

        // General: Browse
        Button browseBtn = findViewById(R.id.browseBtn);
        browseBtn.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, Browse.class)));

        // General: Add
        Button addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, AddActivity.class)));

        // General: Update
        Button updateBtn = findViewById(R.id.updateBtn);
        updateBtn.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, UpdateActivityList.class)));

        // General: Delete
        Button deleteBtn = findViewById(R.id.deleteBtn);
        deleteBtn.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, DeleteActivityList.class)));
    }
}