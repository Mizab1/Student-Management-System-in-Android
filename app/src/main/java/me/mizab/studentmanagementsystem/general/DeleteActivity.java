package me.mizab.studentmanagementsystem.general;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import me.mizab.studentmanagementsystem.MainActivity;
import me.mizab.studentmanagementsystem.databases.DBHelper;
import me.mizab.studentmanagementsystem.model.StudInfo;

public class DeleteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String Rid = intent.getStringExtra("Rid");
        System.out.println(Rid);

        DBHelper mDBHelper = new DBHelper(getApplicationContext());
        mDBHelper.deleteInfo(Rid);

        Toast.makeText(DeleteActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(DeleteActivity.this, MainActivity.class);
        startActivity(i);

    }
}
