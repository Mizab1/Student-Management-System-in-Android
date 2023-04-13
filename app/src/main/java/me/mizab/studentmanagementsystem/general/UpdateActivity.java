package me.mizab.studentmanagementsystem.general;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import me.mizab.studentmanagementsystem.MainActivity;
import me.mizab.studentmanagementsystem.R;
import me.mizab.studentmanagementsystem.databases.DBHelper;
import me.mizab.studentmanagementsystem.model.StudInfo;

public class UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent intent = getIntent();
        String Rid = intent.getStringExtra("Rid");

        DBHelper mDBHelper = new DBHelper(getApplicationContext());
        ArrayList<StudInfo> ListOfInfo = mDBHelper.getInfoById(Rid);

        // Details
        RadioGroup genderBtn = findViewById(R.id.add_gender);
        RadioGroup yearBtn = findViewById(R.id.add_year);
        EditText nameEditText = findViewById(R.id.add_name);
        EditText rollNoEditText = findViewById(R.id.add_roll_no);
        EditText enrollNoEditText = findViewById(R.id.add_enroll_no);
        EditText ageEditText = findViewById(R.id.add_age);
        EditText emailEditText = findViewById(R.id.add_email);
        EditText branchEditText = findViewById(R.id.add_branch);
        EditText phoneEditText = findViewById(R.id.add_phone);

        for(StudInfo studInfo : ListOfInfo){
            nameEditText.setText(studInfo.getName());
            ageEditText.setText(studInfo.getAge());
            rollNoEditText.setText(studInfo.getRollNo());
            enrollNoEditText.setText(studInfo.getEnrollNo());
            emailEditText.setText(studInfo.getEmail());
            branchEditText.setText(studInfo.getBranch());
            phoneEditText.setText(studInfo.getPhone());
            yearBtn.clearCheck();
            yearBtn.check(studInfo.getYearIndex());
            genderBtn.clearCheck();
            genderBtn.check(studInfo.getGenderIndex());
        }
        Button submitBtn = findViewById(R.id.add_submit_btn);
        submitBtn.setOnClickListener(view -> {
            if(genderBtn.getCheckedRadioButtonId() == 0){
                submitBtn.setError("Gender is Required");
                return;
            }
            if(yearBtn.getCheckedRadioButtonId() == 0){
                submitBtn.setError("Year is Required");
                return;
            }
            if(TextUtils.isEmpty(nameEditText.getText())) {
                nameEditText.setError("Name is required");
                return;
            }
            if(TextUtils.isEmpty(rollNoEditText.getText())) {
                rollNoEditText.setError("Roll No. is required");
                return;
            }
            if(TextUtils.isEmpty(enrollNoEditText.getText())) {
                enrollNoEditText.setError("Enrollment No. is required");
                return;
            }
            if(TextUtils.isEmpty(ageEditText.getText())) {
                ageEditText.setError("Age is required");
                return;
            }
            if(TextUtils.isEmpty(emailEditText.getText())) {
                emailEditText.setError("Email is required");
                return;
            }
            if(TextUtils.isEmpty(branchEditText.getText())) {
                branchEditText.setError("Branch is required");
                return;
            }
            if(TextUtils.isEmpty(phoneEditText.getText())) {
                phoneEditText.setError("Phone is required");
                return;
            }
            System.out.println(genderBtn.getCheckedRadioButtonId());
            System.out.println(findViewById(genderBtn.getCheckedRadioButtonId()));
            DBHelper mDBHelper1 = new DBHelper(getApplicationContext());
            mDBHelper1.updateInfo(new StudInfo(
                    (String) ((RadioButton)findViewById(genderBtn.getCheckedRadioButtonId())).getText(),
                    nameEditText.getText().toString(),
                    ageEditText.getText().toString(),
                    rollNoEditText.getText().toString(),
                    enrollNoEditText.getText().toString(),
                    emailEditText.getText().toString(),
                    branchEditText.getText().toString(),
                    (String) ((RadioButton)findViewById(yearBtn.getCheckedRadioButtonId())).getText(),
                    phoneEditText.getText().toString()
            ), Rid);
            Toast.makeText(UpdateActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(UpdateActivity.this, MainActivity.class);
            startActivity(i);
        });
    }
}