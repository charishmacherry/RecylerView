package com.intern.mallika.recycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity  {

    Spinner spinner;
    String[] name;
    int id1;
   // Button sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        //sp=(Button)findViewById(R.id.sp);
        spinner=(Spinner)findViewById(R.id.start_point);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                id1=(int)id;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"Select the starting point",Toast.LENGTH_SHORT).show();

            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.title, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        /*sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StartActivity.this,SecondActivity.class);
                startActivity(i);
            }
        });*/
    }

    public void recycleActivity(View view)
    {
        //Toast.makeText(getApplicationContext(),Integer.toString(id1),Toast.LENGTH_SHORT).show();
        Intent i=new Intent(StartActivity.this,MainActivity.class);
        i.putExtra("id",Integer.toString(id1));
        startActivity(i);
    }
}
