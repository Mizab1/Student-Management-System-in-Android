package me.mizab.studentmanagementsystem.general;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.mizab.studentmanagementsystem.R;
import me.mizab.studentmanagementsystem.adapter.RecyclerViewAdapter;
import me.mizab.studentmanagementsystem.databases.DBHelper;
import me.mizab.studentmanagementsystem.model.StudInfo;

public class DeleteActivityList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        ((TextView) findViewById(R.id.sub_title)).setText(R.string.delete_title);

        DBHelper mDBHelper = new DBHelper(getApplicationContext());

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<StudInfo> allInfo = mDBHelper.getAllInfo();
        ArrayList<StudInfo> studInfoArrayList = new ArrayList<>(allInfo);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(DeleteActivityList.this, studInfoArrayList, "delete");
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}