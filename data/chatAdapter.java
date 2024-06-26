package com.example.softteam.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.softteam.MemoryData;
import com.example.softteam.R;

import java.util.List;

public class chatAdapter extends RecyclerView.Adapter<chatAdapter.MyViewHolder> {

    private List<chatUser> chatLists;
    private final String userMobile;

    public chatAdapter(List<chatUser> chatLists, Context context) {
        this.chatLists = chatLists;
        this.userMobile = MemoryData.getMobile(context);
    }

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public chatAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_adapter, null));
    }

    @Override
    public void onBindViewHolder(@NonNull chatAdapter.MyViewHolder holder, int position) {

        chatUser list2 = chatLists.get(position);

        if (list2.getMobile().equals(userMobile)) {
            holder.myLayout.setVisibility(View.VISIBLE);
            holder.oppoLayout.setVisibility(View.GONE);

            holder.myMessage.setText(list2.getMessage());
            holder.myTime.setText(list2.getDate() + " " + list2.getTime());
        } else {
            holder.myLayout.setVisibility(View.GONE);
            holder.oppoLayout.setVisibility(View.VISIBLE);

            holder.oppoMessage.setText(list2.getMessage());
            holder.oppoTime.setText(list2.getDate() + " " + list2.getTime());
        }
    }

    @Override
    public int getItemCount() {
        return chatLists.size();
    }

    public void updateChatList(List<chatUser> chatLists) {
        this.chatLists = chatLists;
        notifyDataSetChanged();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private final LinearLayout oppoLayout;
        private final LinearLayout myLayout;
        private final TextView oppoMessage;
        private final TextView myMessage;
        private final TextView oppoTime;
        private final TextView myTime;

        @SuppressLint("CutPasteId")
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            oppoLayout = itemView.findViewById(R.id.openlayout);
            myLayout = itemView.findViewById(R.id.mylayout);
            oppoMessage = itemView.findViewById(R.id.oppomsgtm);
            myMessage = itemView.findViewById(R.id.mymsg);
            oppoTime = itemView.findViewById(R.id.oppomsgtm);
            myTime = itemView.findViewById(R.id.mymsgtm);
        }
    }
}
