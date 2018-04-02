package com.intern.mallika.recycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;
public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    boolean is_in_action_mode=false;
    RecyclerView recyclerView;
    DatabaseReference mDataBase;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    private String image[]={"https://firebasestorage.googleapis.com/v0/b/imagedata-9f797.appspot.com/o/Untitled-1.jpg?alt=media&token=a97690eb-7dcf-4efa-bee5-84e62109be56",
    "https://firebasestorage.googleapis.com/v0/b/imagedata-9f797.appspot.com/o/Untitled-2.jpg?alt=media&token=063395c9-1caf-4457-8aae-b80c90e6a9cc",
    "https://firebasestorage.googleapis.com/v0/b/imagedata-9f797.appspot.com/o/untitled3.jpg?alt=media&token=2bd06bbe-18c7-4261-8875-0ff358f0baa5",
    "https://firebasestorage.googleapis.com/v0/b/imagedata-9f797.appspot.com/o/pic4.JPG?alt=media&token=5340164c-a372-476e-bd4a-89861482e591",
    "https://firebasestorage.googleapis.com/v0/b/imagedata-9f797.appspot.com/o/pic5.JPG?alt=media&token=58c49bd1-2a90-4515-9761-2fbd134e1938",
    "https://firebasestorage.googleapis.com/v0/b/imagedata-9f797.appspot.com/o/pic6.JPG?alt=media&token=61b3e037-f832-4a26-9bbd-0f2da814aa9f",
    "https://firebasestorage.googleapis.com/v0/b/imagedata-9f797.appspot.com/o/pic7.JPG?alt=media&token=b94e2067-b034-43e1-af2f-aa0917cb3be9",
    "https://firebasestorage.googleapis.com/v0/b/imagedata-9f797.appspot.com/o/pic8.JPG?alt=media&token=161b323a-ad75-4544-8047-e5ecce939cc0",
    "https://firebasestorage.googleapis.com/v0/b/imagedata-9f797.appspot.com/o/pic9.jpg?alt=media&token=42b56605-bac2-416c-98e6-d19406b3f940",
    "https://firebasestorage.googleapis.com/v0/b/imagedata-9f797.appspot.com/o/pic10.JPG?alt=media&token=0f31355e-e4f5-4028-bd22-2724259afb3f",
    "https://firebasestorage.googleapis.com/v0/b/imagedata-9f797.appspot.com/o/pic11.JPG?alt=media&token=b9018afb-25b3-4f0d-9581-c8159a9c5ee9",
    "https://firebasestorage.googleapis.com/v0/b/imagedata-9f797.appspot.com/o/pic12.JPG?alt=media&token=5e921ed9-dce9-41f7-9750-7a93c7d1cfc3",
    "https://firebasestorage.googleapis.com/v0/b/imagedata-9f797.appspot.com/o/pic12.JPG?alt=media&token=5e921ed9-dce9-41f7-9750-7a93c7d1cfc3",
    "https://firebasestorage.googleapis.com/v0/b/imagedata-9f797.appspot.com/o/pic14.JPG?alt=media&token=3f8551a8-dbfb-4e47-a156-3b5f9e649dc0",
    "https://firebasestorage.googleapis.com/v0/b/imagedata-9f797.appspot.com/o/pic15.JPG?alt=media&token=f53e4e82-f8ea-421c-8e86-618da75dd3b7",
    "https://firebasestorage.googleapis.com/v0/b/imagedata-9f797.appspot.com/o/pic16.JPG?alt=media&token=6fdb6867-53fa-4c57-8715-ece23bdf4664",
    "https://firebasestorage.googleapis.com/v0/b/imagedata-9f797.appspot.com/o/pic17.JPG?alt=media&token=c4d7338e-0353-4b34-a54d-46de78e3b20d",
    "https://firebasestorage.googleapis.com/v0/b/imagedata-9f797.appspot.com/o/pic17.JPG?alt=media&token=c4d7338e-0353-4b34-a54d-46de78e3b20d",
    "https://firebasestorage.googleapis.com/v0/b/imagedata-9f797.appspot.com/o/pic19.JPG?alt=media&token=1a0f5f46-adad-4fad-8900-8fbb69560cec",};
    ArrayList<Contact> contacts=new ArrayList<>();
    ArrayList<Contact> selection_list=new ArrayList<>();
    ArrayList<Integer> list=new ArrayList<>();
    int counter=0,id;
    Button submitButton;
    String[] title,god,title2,god2;
    String image2[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        title=getResources().getStringArray(R.array.title);
        god=getResources().getStringArray(R.array.god);
        submitButton=(Button)findViewById(R.id.submit);
        submitButton.setVisibility(View.GONE);
        int i=0;
        for(String TITLE:title)
        {
            Contact contact=new Contact(image[i],TITLE,god[i]);
            contacts.add(contact);
            i++;
        }
        adapter=new ContactAdapter(contacts,MainActivity.this);
        recyclerView.setAdapter(adapter);
        //fetching the id value.
        String id1=getIntent().getStringExtra("id");
        id=Integer.parseInt(id1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //Toast.makeText(getApplicationContext(),"Hi "+id,Toast.LENGTH_SHORT).show();
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        if(id==android.R.id.home)
            this.finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onLongClick(View v) {
        is_in_action_mode=true;
        submitButton.setVisibility(View.VISIBLE);
        adapter.notifyDataSetChanged();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return true;
    }

    public void prepareSelection(View view,int position)
    {
        if(((CheckBox)view).isChecked())
        {
            list.add(position);
            //selection_list.add(contacts.get(position));
            counter=counter+1;
        }
        else
        {
            list.remove(position);
            //selection_list.remove(contacts.get(position));
            counter=counter-1;
        }
    }


    public void submitData(View view)
    {
        int[] initial=new int[counter+1];//this is the array in which we place the arraylist
        initial[0]=id;
        int j=1,m=0;
        if(counter==0)
            Toast.makeText(this,"Please select a place",Toast.LENGTH_LONG).show();
        else
        {
            for(int i=0;i<counter;i++) {
                if (id == list.get(i)) {
                    m = 1;
                }
                else {
                    initial[j] = list.get(i);
                    j++;
                }
            }
            if(m==0)
            {
                counter=counter+1;
            }

            ShortestPath shortestPath=new ShortestPath();
            int[] result=  shortestPath.path(initial,counter);
            image2=new String[counter];
            title2=new String[counter];
            god2=new String[counter];
            for(int i=0;i<counter;i++)
            {
                image2[i]=image[initial[result[i]]];
                title2[i]=title[initial[result[i]]];
                god2[i]=god[initial[result[i]]];
                //Toast.makeText(getApplicationContext(),"your path"+title2[i],Toast.LENGTH_SHORT).show();
            }

            Intent i=new Intent(MainActivity.this,SecondActivity.class);
            i.putExtra("title",title2);
            i.putExtra("god",god2);
            i.putExtra("image",image2);
            startActivity(i);
            finish();

        }

    }
    public void historyPage(View view,int position)
    {
        String place=title[position];
       // Toast.makeText(getApplicationContext(),place,Toast.LENGTH_LONG).show();
        if(place.equals("Tirumala"))
        {
           Intent i=new Intent(MainActivity.this,Tirumala.class);
           startActivity(i);
        }
    }
}
