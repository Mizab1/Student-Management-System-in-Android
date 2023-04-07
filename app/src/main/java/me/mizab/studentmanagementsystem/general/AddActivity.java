package me.mizab.studentmanagementsystem.general;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import me.mizab.studentmanagementsystem.MainActivity;
import me.mizab.studentmanagementsystem.R;
import me.mizab.studentmanagementsystem.databases.DBHelper;
import me.mizab.studentmanagementsystem.model.StudInfo;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        // Details
        EditText nameEditText = (EditText) findViewById(R.id.add_name);
        EditText rollNoEditText = (EditText) findViewById(R.id.add_roll_no);
        EditText enrollNoEditText = (EditText) findViewById(R.id.add_enroll_no);
        EditText ageEditText = (EditText) findViewById(R.id.add_age);
        EditText emailEditText = (EditText) findViewById(R.id.add_email);
        EditText branchEditText = (EditText) findViewById(R.id.add_branch);
        EditText yearEditText = (EditText) findViewById(R.id.add_year);
        EditText phoneEditText = (EditText) findViewById(R.id.add_phone);

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
                    mDBHelper.addInfo(new StudInfo(
                            nameEditText.getText().toString(),
                            ageEditText.getText().toString(),
                            rollNoEditText.getText().toString(),
                            enrollNoEditText.getText().toString(),
                            emailEditText.getText().toString(),
                            branchEditText.getText().toString(),
                            yearEditText.getText().toString(),
                            phoneEditText.getText().toString()
                    ));


                    Toast.makeText(AddActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(AddActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}