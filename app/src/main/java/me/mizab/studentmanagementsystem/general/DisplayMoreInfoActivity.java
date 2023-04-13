package me.mizab.studentmanagementsystem.general;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
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

        TextView gender = findViewById(R.id.more_info_gender);
        TextView name = findViewById(R.id.more_info_name);
        TextView rollNo = findViewById(R.id.more_info_roll_no);
        TextView enrollment = findViewById(R.id.more_info_enrollment);
        TextView age = findViewById(R.id.more_info_age);
        TextView email = findViewById(R.id.more_info_email);
        TextView branch = findViewById(R.id.more_info_branch);
        TextView year = findViewById(R.id.more_info_year);
        TextView phone = findViewById(R.id.more_info_phone);
        ImageView profile = findViewById(R.id.profile);

        for(StudInfo studInfo: ListOfInfo){
            gender.setText(studInfo.getGender());
            name.setText(studInfo.getName());
            rollNo.setText(studInfo.getRollNo());
            enrollment.setText(studInfo.getEnrollNo());
            age.setText(studInfo.getAge());
            email.setText(studInfo.getEmail());
            branch.setText(studInfo.getBranch());
            year.setText(studInfo.getYear());
            phone.setText(studInfo.getPhone());

            String genderText = gender.getText().toString();
            int drawableID = genderText.equals("Male") ? R.drawable.male :
                    genderText.equals("Female") ? R.drawable.female : R.drawable.other;

            profile.setImageDrawable(AppCompatResources.getDrawable(this, drawableID));
        }

    }
}