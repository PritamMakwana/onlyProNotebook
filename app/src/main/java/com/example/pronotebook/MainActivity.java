package com.example.pronotebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.TimeAnimator;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DBManager dbManager;
    private MyAdapter adapter;
    private Cursor cursor;


  RecyclerView recyclerView;
  ArrayList<note>  list;
    private static final String TAG ="MainActivity" ;


    final String[] from= new String[] {
            DatabaseHelper.ID,DatabaseHelper.SUBJECT,DatabaseHelper.DESC
    };

    final  int [] to =new int[]{/*R.id.id,*/R.id.hading,R.id.decription};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbManager =new DBManager(this);
        dbManager.open();
        Cursor cursor= dbManager.fetch();



        recyclerView=findViewById(R.id.recyclerView);

        ArrayList<note> list=new ArrayList<>();
        list.add(new note("name","othe infomatioin "));

      //  MyAdapter adapter=new MyAdapter(list,this);
         adapter= new MyAdapter(list,this,cursor,from,to,0);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();



        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   TextView idTextView=v.findViewById(R.id.id);
                TextView titleTextView=v.findViewById(R.id.hading);
                TextView desctextView=v.findViewById(R.id.decription);


              //  String id =idTextView.getText().toString();
                String title=titleTextView.getText().toString();
                String desc=desctextView.getText().toString();

                Intent intent=new Intent(getApplicationContext(),ModifyNoteActivity.class);

               // intent.putExtra("id",id);
                intent.putExtra("title",title);
                intent.putExtra("desc",desc);

                startActivity(intent);


            }
        });

        FloatingActionButton plus=findViewById(R.id.btnplus);

//        plus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG,"plus buttton is work");
//                Toast.makeText(getApplicationContext(),"ADD note",Toast.LENGTH_SHORT).show();
//
//                Intent intent=new Intent(MainActivity.this,Add_note.class);
//
//                startActivity(intent);
//            }
//        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.id.btnplus,menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.btnplus){
            Intent add_menu= new Intent(this,Add_note.class);
            startActivity(add_menu);
        }

        return super.onOptionsItemSelected(item);
    }
}


