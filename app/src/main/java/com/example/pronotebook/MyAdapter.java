package com.example.pronotebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.ViewHolder>{
   private List<note> list;
   private Context context;

    public MyAdapter(List<note>list,Context context) {

        this.list=list;
        this.context=context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View ItemView =layoutInflater.inflate(R.layout.itam_list,parent,false);
        ViewHolder viewHolder=new ViewHolder(ItemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final note note1=list.get(position);
        holder.hading.setText(list.get(position).getHading());
        holder.decription.setText(list.get(position).getDecrip());
        holder.itam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"this itam is ",Toast.LENGTH_SHORT);
            }
        });


    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView hading,decription;
        public ConstraintLayout itam;
        public ViewHolder(View itemView) {
            super(itemView);
            hading=itemView.findViewById(R.id.hading);
            decription=itemView.findViewById(R.id.decription);
            itam=itemView.findViewById(R.id.itamlist);
        }
    }
}
