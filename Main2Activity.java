package com.example.nandhu.sqldata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    EditText editText;
    DatabaseHandler db;
    Button submit,view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText= (EditText) findViewById(R.id.name1);
        submit= (Button) findViewById(R.id.submit1);
        view= (Button) findViewById(R.id.view);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=new DatabaseHandler(Main2Activity.this);
                db.insertnamedata(editText.getText().toString());
                editText.setText("");

            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,MainActivity.class));
            }
        });
    }
}
