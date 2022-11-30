package com.mykola.myapplication;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class RecyclerViewHolder extends RecyclerView.ViewHolder {


    private TextView taskNameTextView;
    private TextView taskTextTextView;
    private TextView taskCreateDateTextView;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        taskNameTextView = itemView.findViewById(R.id.text_name_task);
        taskTextTextView = itemView.findViewById(R.id.text_of_task);
        taskCreateDateTextView = itemView.findViewById(R.id.date_created_task);
    }


    public void bind(Task tweet) {
        taskNameTextView.setText(tweet.getTaskName());
        taskTextTextView.setText(tweet.getTextTask());
        taskCreateDateTextView.setText(tweet.getCreateDate());
    }

}