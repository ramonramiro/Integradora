package com.principal.subnetting.easy;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.principal.subnetting.easy.messages.ReceiveMessage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdapterMessage extends RecyclerView.Adapter<HolderMessage>{
    private List<ReceiveMessage> listMessage = new ArrayList<>();
    private Context c;

    public AdapterMessage(Context c) {
        this.c = c;
    }

    public void addMessage(ReceiveMessage m){
        listMessage.add(m);
        notifyItemInserted(listMessage.size());
    }

    @Override
    public HolderMessage onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.card_view_message, parent, false);
        return new HolderMessage(v);
    }

    @Override
    public void onBindViewHolder(HolderMessage holder, int position) {
        holder.getTvName().setText(listMessage.get(position).getName());
        holder.getTvMessage().setText(listMessage.get(position).getMessage());
        if(listMessage.get(position).getTypeMessage().equals("2")){
            holder.getPictureProfile().setVisibility(View.VISIBLE);
            holder.getTvMessage().setVisibility(View.VISIBLE);
            Glide.with(c).load(listMessage.get(position).getUrlPhoto()).into(holder.getPictureProfile());
        }else if(listMessage.get(position).getTypeMessage().equals("1")){
            holder.getPictureProfile().setVisibility(View.GONE);
            holder.getTvMessage().setVisibility(View.VISIBLE);
        }
        if(listMessage.get(position).getProfilePicture().isEmpty()){
            holder.getPictureProfile().setImageResource(R.mipmap.ic_launcher);
        }else{
            Glide.with(c).load(listMessage.get(position).getProfilePicture()).into(holder.getPictureProfile());
        }
        Long codeHour = listMessage.get(position).getHour();
        Date d = new Date(codeHour);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");//a pm o am
        holder.getHour().setText(sdf.format(d));

    }

    @Override
    public int getItemCount() {
        return listMessage.size();
    }
}
