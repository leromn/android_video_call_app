package com.example.myapplication.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.BkWorker;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import java.util.ArrayList;


public class listDptr extends RecyclerView.Adapter<listDptr.ViewHolder>{
    private ArrayList<ChannelInfo> listdata;
    Context ctx;
    BkWorker bkWorker;

    // RecyclerView recyclerView;
    public listDptr(ArrayList<ChannelInfo> listdata, Context ctx) {
        this.ctx=ctx;
        this.listdata = listdata;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.container, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ChannelInfo myListData = listdata.get(position);
        holder.nameView.setText(myListData.channelname);



        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Joinning channel: "+myListData.channelname,Toast.LENGTH_LONG).show();
                String token=myListData.token;
                Intent myIntent = new Intent(ctx, MainActivity.class);
                myIntent.putExtra("channelName",myListData.channelname);
                myIntent.putExtra("token",myListData.token);
                ctx.startActivity(myIntent);

            }
        });
    }
    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameView;
        public ConstraintLayout layout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.nameView = (TextView) itemView.findViewById(R.id.callerId);
            layout =  itemView.findViewById(R.id.containerLout);
        }
    }
}
