package me.mizab.studentmanagementsystem.general;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
        System.out.println(Rid);

        DBHelper mDBHelper = new DBHelper(getApplicationContext());
        ArrayList<StudInfo> ListOfInfo = mDBHelper.getInfoById(Rid);

        // Details
        EditText nameEditText = (EditText) findViewById(R.id.add_name);
        EditText rollNoEditText = (EditText) findViewById(R.id.add_roll_no);
        EditText enrollNoEditText = (EditText) findViewById(R.id.add_enroll_no);
        EditText ageEditText = (EditText) findViewById(R.id.add_age);
        EditText emailEditText = (EditText) findViewById(R.id.add_email);
        EditText branchEditText = (EditText) findViewById(R.id.add_branch);
        EditText yearEditText = (EditText) findViewById(R.id.add_year);
        EditText phoneEditText = (EditText) findViewById(R.id.add_phone);

        for(StudInfo studInfo : ListOfInfo){
            nameEditText.setText(studInfo.getName());
            ageEditText.setText(studInfo.getAge());
            rollNoEditText.setText(studInfo.getRollNo());
            enrollNoEditText.setText(studInfo.getEnrollNo());
            emailEditText.setText(studInfo.getEmail());
            branchEditText.setText(studInfo.getBranch());
            yearEditText.setText(studInfo.getYear());
            phoneEditText.setText(studInfo.getPhone());
        }
        Button submitBtn = findViewById(R.id.add_submit_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(nameEditText.getText())){
                    nameEditText.setError("Name is required");
                }else if (TextUtils.isEmpty(rollNoEditText.getText())) {
                    rollNoEditText.setError("Roll No. is required");
                } else if (TextUtils.isEmpty(enrollNoEditText.getText())) {
                    enrollNoEditText.setError("Enrollment No. is required");
                } else if (TextUtils.isEmpty(ageEditText.getText())) {
                    ageEditText.setError("Age is required");
                } else if (TextUtils.isEmpty(emailEditText.getText())) {
                    emailEditText.setError("Email is required");
                } else if (TextUtils.isEmpty(branchEditText.getText())) {
                    branchEditText.setError("Branch is required");
                } else if (TextUtils.isEmpty(yearEditText.getText())) {
                    yearEditText.setError("Year is required");
                } else if (TextUtils.isEmpty(phoneEditText.getText())) {
                    phoneEditText.setError("Phone no. is required");
                } else{
                    DBHelper mDBHelper = new DBHelper(getApplicationContext());
                    mDBHelper.updateInfo(new StudInfo(
                            nameEditText.getText().toString(),
                            ageEditText.getText().toString(),
                            rollNoEditText.getText().toString(),
                            enrollNoEditText.getText().toString(),
                            emailEditText.getText().toString(),
                            branchEditText.getText().toString(),
                            yearEditText.getText().toString(),
                            phoneEditText.getText().toString()
                    ), Rid);


                    Toast.makeText(UpdateActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(UpdateActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}