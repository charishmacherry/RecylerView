package com.intern.mallika.recycle;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Mallika on 1/23/2018.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>  {
    ArrayList<Contact> adapter_list=new ArrayList<>();
    MainActivity mainActivity;
    Context ctx;

    public ContactAdapter (ArrayList<Contact> adapter_list,Context ctx) {
        this.adapter_list=adapter_list;
        this.ctx=ctx;
        mainActivity=(MainActivity)ctx;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout,parent,false);
        ContactViewHolder contactViewHolder=new ContactViewHolder(view,mainActivity);
        return contactViewHolder;
    }



    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        holder.name.setText(adapter_list.get(position).getName());
        holder.god.setText(adapter_list.get(position).getGod());
        //holder.img.setImageResource(adapter_list.get(position).getImage());
        Picasso.with(ctx).load(adapter_list.get(position).getImage()).resize(100,100).into(holder.img);
        if(!mainActivity.is_in_action_mode)
        {
            holder.checkBox.setVisibility(View.GONE);
        }
        else
        {
            holder.checkBox.setVisibility(View.VISIBLE);
            holder.checkBox.setChecked(false);
        }
        holder.history.setVisibility(View.VISIBLE);
        holder.navigation.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return adapter_list.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        ImageView img;
        TextView name,god,history,navigation;
        CheckBox checkBox;
        MainActivity mainActivity;
        CardView cardView;
        Button b;

        public ContactViewHolder(View itemView, final MainActivity mainActivity) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.img_id);
            name=(TextView)itemView.findViewById(R.id.name);
            god=(TextView)itemView.findViewById(R.id.god);
            checkBox=(CheckBox)itemView.findViewById(R.id.check_list_item);
            this.mainActivity=mainActivity;
            cardView=(CardView)itemView.findViewById(R.id.cardView);
            cardView.setOnLongClickListener(mainActivity);
            checkBox.setOnClickListener(this);
            history=(TextView)itemView.findViewById(R.id.history);
            navigation=(TextView)itemView.findViewById(R.id.navigation);
            history.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(mainActivity, "Hello history", Toast.LENGTH_SHORT).show();
                    mainActivity.historyPage(v,getAdapterPosition());
                }
            });
        }

        @Override
        public void onClick(View v) {
           mainActivity.prepareSelection(v,getAdapterPosition());
           /* int position=getAdapterPosition();
            if(((CheckBox)v).isChecked())
            {
                checkBox.setChecked(true);
                mainActivity.list.add(position);
                mainActivity.selection_list.add(mainActivity.contacts.get(position));
                mainActivity.counter=mainActivity.counter+1;
            }
            else if(!((CheckBox)v).isChecked())
            {
                checkBox.setChecked(false);
                mainActivity.list.remove(position);
                mainActivity.selection_list.remove(mainActivity.contacts.get(position));
                mainActivity.counter=mainActivity.counter-1;
            }*/
        }

    }
}
