package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.todo.Activity.InsertNotesActivity;
import com.example.todo.Adapter.NotesAdapter;
import com.example.todo.viewModel.NotesViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton newNotesBtn;
    NotesViewModel notesViewModel;
    RecyclerView notesRecycler;
    NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newNotesBtn=findViewById(R.id.newNotesBtn);
        notesRecycler=findViewById(R.id.notesRecycler);

       newNotesBtn.setOnClickListener(v -> {
           Intent intent = new Intent(this, InsertNotesActivity.class);
           startActivity(intent);
       });

       notesViewModel.getAllNotes.observe(this,notes -> {
           notesRecycler.setLayoutManager(new GridLayoutManager(this,2));
           adapter=new NotesAdapter(MainActivity.this,notes);
           notesRecycler.setAdapter(adapter);
       });
    }
}