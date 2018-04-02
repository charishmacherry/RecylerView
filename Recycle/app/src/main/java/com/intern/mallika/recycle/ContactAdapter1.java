package com.intern.mallika.recycle;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Mallika on 1/27/2018.
 */

public class ContactAdapter1 extends RecyclerView.Adapter<ContactAdapter1.ContactViewHolder1>{

    ArrayList<Contact> adapter_list=new ArrayList<>();
    SecondActivity secondActivity;
    Context ctx;

    public ContactAdapter1 (ArrayList<Contact> adapter_list,Context ctx) {
        this.adapter_list=adapter_list;
        this.ctx=ctx;
        secondActivity=(SecondActivity)ctx;
    }

    @Override
    public ContactViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout,parent,false);
       ContactViewHolder1 contactViewHolder=new ContactViewHolder1(view,secondActivity);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder1 holder, int position) {
        holder.name.setText(adapter_list.get(position).getName());
        holder.god.setText(adapter_list.get(position).getGod());
       // holder.img.setImageResource(adapter_list.get(position).getImage());
        Picasso.with(ctx).load(adapter_list.get(position).getImage()).resize(100,100).into(holder.img);
        holder.checkBox.setVisibility(View.GONE);
        holder.history.setVisibility(View.GONE);
        holder.navigation.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return adapter_list.size();
    }

    public static class ContactViewHolder1 extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView name,god,history,navigation;
        SecondActivity secondActivity;
        CardView cardView;
        CheckBox checkBox;

        public ContactViewHolder1(View itemView, final SecondActivity secondActivity) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.img_id);
            name=(TextView)itemView.findViewById(R.id.name);
            god=(TextView)itemView.findViewById(R.id.god);
            checkBox=(CheckBox)itemView.findViewById(R.id.check_list_item);
            this.secondActivity=secondActivity;
            cardView=(CardView)itemView.findViewById(R.id.cardView);
            history=(TextView)itemView.findViewById(R.id.history);
            navigation=(TextView)itemView.findViewById(R.id.navigation);
            navigation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    secondActivity.navigationMaps(v,getAdapterPosition());
                }
            });
        }
    }
}
