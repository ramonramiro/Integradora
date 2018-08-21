package com.principal.subnetting.easy;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class HolderMessage extends RecyclerView.ViewHolder{
    private TextView tvName;
    private TextView tvMessage;
    private TextView tvHour;
    private CircleImageView pictureProfile;
    private ImageView sendMessage;


    public HolderMessage(View itemView) {
        super(itemView);

        tvName = itemView.findViewById(R.id.tv_message_name);
        tvMessage = itemView.findViewById(R.id.tv_message);
        tvHour =  itemView.findViewById(R.id.tv_message_time);
        pictureProfile =  itemView.findViewById(R.id.picture_profile_picture);
        sendMessage = itemView.findViewById(R.id.image_message_photo);
    }

    public TextView getTvName() {
        return tvName;
    }

    public void setTvName(TextView tvName) {
        this.tvName = tvName;
    }

    public TextView getTvMessage() {
        return tvMessage;
    }

    public void setTvMessage(TextView tvMessage) {
        this.tvMessage = tvMessage;
    }

    public TextView getHour() {
        return tvHour;
    }

    public void setHour(TextView hour) {
        this.tvHour = hour;
    }

    public CircleImageView getPictureProfile() {
        return pictureProfile;
    }

    public void setPictureProfile(CircleImageView pictureProfile) {
        this.pictureProfile = pictureProfile;
    }

    public ImageView getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(ImageView sendMessage) {
        this.sendMessage = sendMessage;
    }
}


