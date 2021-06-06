package com.example.pronotebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class Add_note extends MainActivity {
    EditText addnote,addtitle;
    MyAdapter myAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        addnote=findViewById(R.id.addnote2);
        addtitle=findViewById(R.id.addtitle2);

        FloatingActionButton addnotebtn=findViewById(R.id.addbtn2);

        addnotebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                insertMethod(String.valueOf(addtitle.getText()));
//                insertMethod(String.valueOf(addnote.getText()));


                list.add(new note(addtitle.getText().toString(),addnote.getText().toString()));
                myAdapter.notifyItemInserted(list.size());

                Toast.makeText(getApplicationContext(),"add note button ",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(Add_note.this,MainActivity.class);
                startActivity(intent);

            }
        });


    }



//    private void insertMethod(String note){
//         Gson gson=new Gson();
//           try{
//               JSONObject jsonObject=new JSONObject();
//               jsonObject.put("note",note);
//               note note1=gson.fromJson(String.valueOf(jsonObject),note.class);
//                list.add(note1);
//                myAdapter.notifyDataSetChanged();
//
//           } catch (JSONException e) {
//               e.printStackTrace();
//           }

  //  }
}