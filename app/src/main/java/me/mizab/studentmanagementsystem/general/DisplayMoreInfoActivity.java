package me.mizab.studentmanagementsystem.general;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.mizab.studentmanagementsystem.R;
import me.mizab.studentmanagementsystem.databases.DBHelper;
import me.mizab.studentmanagementsystem.model.StudInfo;

public class DisplayMoreInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_more_info);

        Intent intent = getIntent();
        String Rid = intent.getStringExtra("Rid");

        DBHelper mDBHelper = new DBHelper(getApplicationContext());
        ArrayList<StudInfo> ListOfInfo = mDBHelper.getInfoById(Rid);

        TextView name = (TextView) findViewById(R.id.more_info_name);
        TextView rollNo = (TextView) findViewById(R.id.more_info_roll_no);
        TextView enrollment = (TextView) findViewById(R.id.more_info_enrollment);
        TextView age = (TextView) findViewById(R.id.more_info_age);
        TextView email = (TextView) findViewById(R.id.more_info_email);
        TextView branch = (TextView) findViewById(R.id.more_info_branch);
        TextView year = (TextView) findViewById(R.id.more_info_year);
        TextView phone = (TextView) findViewById(R.id.more_info_phone);

        for(StudInfo studInfo: ListOfInfo){
            name.setText(studInfo.getName());
            rollNo.setText(studInfo.getRollNo());
            enrollment.setText(studInfo.getEnrollNo());
            age.setText(studInfo.getAge());
            email.setText(studInfo.getEmail());
            branch.setText(studInfo.getBranch());
            year.setText(studInfo.getYear());
            phone.setText(studInfo.getPhone());
        }

    }
}