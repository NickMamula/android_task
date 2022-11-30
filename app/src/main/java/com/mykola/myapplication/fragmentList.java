package com.mykola.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.snackbar.Snackbar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;


public class fragmentList extends Fragment {

    static Collection<Task> tasks = new ArrayList<>();
    RelativeLayout relativeLayout;

    static {
        tasks.add(new Task("Покупки,Покупки,Покупки,Покупки,Покупки,Покупки,", "до новогоднего стола", "Thu Dec 13 2017"));
        tasks.add(new Task("Услуги", "зайти к пaрикхмахеру ", "Thu Dec 13 2017"));
        tasks.add(new Task("Перезвонить", "ремонт авто, химчистка салон", "Thu Dec 13 2017"));
    }


    private RecyclerView recyclerView;
    private RecycleAdapter recycleAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_item, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Horizontal Orientation
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView


        //recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));//менеджер отвечает за форму отображения элементов LinerLayout значит в виде списка
        recycleAdapter = new RecycleAdapter();
        recyclerView.setAdapter(recycleAdapter);
        recycleAdapter.setItems(tasks);



/*
        Toast.makeText(getContext(), "Reload", Toast.LENGTH_SHORT).show();
*/
        view.findViewById(R.id.addFab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Текущее время
                Date currentDate = new Date();
// Форматирование времени как "день.месяц.год"
                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
                String dateText = dateFormat.format(currentDate);
// Форматирование времени как "часы:минуты:секунды"
                DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
                String timeText = timeFormat.format(currentDate);
                tasks.add(new Task("Новая заметка", "Описание", timeText));
                //Toast.makeText(getContext(), "Reload", Toast.LENGTH_SHORT).show();
                Reload();
            }

            private void Reload() {
                getActivity().getSupportFragmentManager().beginTransaction().replace(fragmentList.this.getId(), new fragmentList()).commit();

            }
        });

        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Snackbar.make(getActivity().findViewById(android.R.id.content),
                        "Заметка удалена", Snackbar.LENGTH_LONG).show();
                tasks.remove(viewHolder.getPosition());
                recycleAdapter.notifyDataSetChanged();
            }


        };

        return view;
    }


}


