package me.mizab.studentmanagementsystem;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import me.mizab.studentmanagementsystem.general.AddActivity;
import me.mizab.studentmanagementsystem.general.Browse;
import me.mizab.studentmanagementsystem.general.DeleteActivityList;
import me.mizab.studentmanagementsystem.general.UpdateActivityList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        this.deleteDatabase("stud_db");
//        DBHelper mDBHelper = new DBHelper(getApplicationContext());
//        mDBHelper.addInfo(new StudInfo("Mizab", "19", "6", "2001160168", "mizab@gmail.com", "CO", "2020", "9876543210"));


        // General: Browse
        Button browseBtn = findViewById(R.id.browseBtn);
        browseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Browse.class);
                startActivity(i);
            }
        });

        // General: Add
        Button addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddActivity.class);
                startActivity(i);
            }
        });

        // General: Update
        Button updateBtn = findViewById(R.id.updateBtn);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, UpdateActivityList.class);
                startActivity(i);
            }
        });

        // General: Delete
        Button deleteBtn = findViewById(R.id.deleteBtn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DeleteActivityList.class);
                startActivity(i);
            }
        });
    }
}