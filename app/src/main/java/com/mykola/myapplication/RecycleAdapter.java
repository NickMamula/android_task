package com.mykola.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<Task> tasksList = new ArrayList<>();

    @Override
    public int getItemViewType(final int position) {
        return R.layout.list_item;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.bind(tasksList.get(position));
    }

    @Override
    public int getItemCount() {
        return tasksList.size();
    }

    public void  setItems(Collection<Task> tweets) {
        tasksList.addAll(tweets);
        notifyDataSetChanged();
    }


}