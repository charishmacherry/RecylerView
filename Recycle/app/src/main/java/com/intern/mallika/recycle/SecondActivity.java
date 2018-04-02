package com.intern.mallika.recycle;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private String image[];
    private String mainimage[]={"https://firebasestorage.googleapis.com/v0/b/imagedata-9f797.appspot.com/o/Untitled-1.jpg?alt=media&token=a97690eb-7dcf-4efa-bee5-84e62109be56",
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
            "https://firebasestorage.googleapis.com/v0/b/imagedata-9f797.appspot.com/o/pic19.JPG?alt=media&token=1a0f5f46-adad-4fad-8900-8fbb69560cec",
            "https://firebasestorage.googleapis.com/v0/b/imagedata-9f797.appspot.com/o/pic19.JPG?alt=media&token=1a0f5f46-adad-4fad-8900-8fbb69560cec"};

    String[] title,god,maintitle,maingod;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    ArrayList<Contact> contacts=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView1);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        maintitle=getResources().getStringArray(R.array.title);
        maingod=getResources().getStringArray(R.array.god);
        image=getIntent().getExtras().getStringArray("image");
        title=getIntent().getExtras().getStringArray("title");
        god=getIntent().getExtras().getStringArray("god");
        int i=0;
        for(String TITLE:title)
        {
            Contact contact=new Contact(image[i],TITLE,god[i]);
            contacts.add(contact);
            i++;
        }
        adapter=new ContactAdapter1(contacts,SecondActivity.this);
        recyclerView.setAdapter(adapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        if(id==android.R.id.home)
            this.finish();
        return super.onOptionsItemSelected(item);
    }

   public void navigationMaps(View v,int position)
   {

   }
}
