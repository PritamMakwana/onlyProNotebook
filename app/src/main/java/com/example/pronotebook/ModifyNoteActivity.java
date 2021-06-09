package com.example.pronotebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ModifyNoteActivity extends AppCompatActivity  {
    private EditText titleText1;
    private EditText descText1;

    private long _id;
    private  DBManager dbManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Modity Record");
        setContentView(R.layout.activity_modify_note);

        FloatingActionButton plusnote=findViewById(R.id.addbtn2);


        dbManager=new DBManager(this);
        dbManager.open();

        titleText1=findViewById(R.id.addtitle2);
        descText1=findViewById(R.id.addnote2);

        Intent intent=getIntent();
     //   String id=intent.getStringExtra("_id");
        String name=intent.getStringExtra("title");
        String desc=intent.getStringExtra("desc");


     //   id=Long.parseLong(id);

        titleText1.setText(name);
        descText1.setText(desc);



        plusnote.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String title=titleText1.getText().toString();
                String desc=descText1.getText().toString();
                dbManager.update(title,desc);
                //           this.returnHome();
                //            public void returnHome(){

                Intent home_intent=new Intent(getApplicationContext(),MainActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home_intent);
                //             }


            }
        });

    }





}