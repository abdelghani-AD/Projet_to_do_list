package com.example.miniprojetlogin;

import android.content.Intent;
import android.graphics.Color;
import android.media.session.PlaybackState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterWork extends RecyclerView.Adapter<AdapterWork.WorkHolder> {

    static List<Tache> TacheDone = new ArrayList<>();

    List<Tache> ListWork;

    public AdapterWork(List<Tache> listWork) {
        this.ListWork = listWork;
    }

    public static class WorkHolder extends RecyclerView.ViewHolder{

        TextView text1,text2,text3,text4;
        CheckBox checkBox;
        Button button;
        public WorkHolder(View view){
            super(view);
            text1 = view.findViewById(R.id.text1);
            text2 = view.findViewById(R.id.text2);
            text3 = view.findViewById(R.id.text3);
            text4 = view.findViewById(R.id.text4);
            checkBox = view.findViewById(R.id.check);
            button = view.findViewById(R.id.btn);
        }
    }
    @NonNull
    @Override
    public WorkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new WorkHolder(view);
    }
    AdapterWork con = this;

    @Override
    public void onBindViewHolder(@NonNull WorkHolder holder, int position) {

        Tache list = ListWork.get(position);
        holder.text1.setText(list.getTitre());
        holder.text2.setText(list.getPr());
        holder.text3.setText(list.getPriorite());
        holder.text4.setText(list.getDate());
        holder.checkBox.setChecked(list.isCheck());
        holder.button.setOnClickListener((View)->{
                ListWork.remove(list);
                TacheDone.add(list);
                con.notifyDataSetChanged();


        });
        String priority = ListWork.get(position).getPriorite();
        if (priority == "Important"){
            holder.text3.setTextColor(Color.RED);
        }else if (priority == "Moyen"){
            holder.text3.setTextColor(Color.BLUE);
        }else {
            holder.text3.setTextColor(Color.GREEN);
        }
    }
    @Override
    public int getItemCount() {
        return ListWork.size();
    }
}
