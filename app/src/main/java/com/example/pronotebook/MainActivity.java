package com.example.pronotebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  RecyclerView recyclerView;
  ArrayList<note>  list;
    private static final String TAG ="MainActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);

        ArrayList<note> list=new ArrayList<>();
        list.add(new note("name","othe infomatioin "));

        MyAdapter adapter=new MyAdapter(list,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);




        FloatingActionButton plus=findViewById(R.id.btnplus);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"plus buttton is work");
                Toast.makeText(getApplicationContext(),"ADD note",Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(MainActivity.this,Add_note.class);

                startActivity(intent);
            }
        });

    }
}