package com.example.todo.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.todo.R;
import com.example.todo.databinding.ActivityInsertNotesBinding;
import com.example.todo.databinding.ActivityUpdateNotesBinding;

public class UpdateNotesActivity extends AppCompatActivity {
    ActivityUpdateNotesBinding binding;
    String Priority="1";
    String stitle,ssubtitle,snotes ,spriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityUpdateNotesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        stitle=getIntent().getStringExtra("id");
        ssubtitle=getIntent().getStringExtra("title");
        snotes=getIntent().getStringExtra("subtitle");
        spriority=getIntent().getStringExtra("priority");


        binding.greenPriority.setOnClickListener(v -> {
            binding.greenPriority.setImageResource(R.drawable.ic_baseline_done_24);
            binding.yellowPriority.setImageResource(0);
            binding.redPriority.setImageResource(0);
            Priority="1";
        });

        binding.yellowPriority.setOnClickListener(v -> {
            binding.yellowPriority.setImageResource(R.drawable.ic_baseline_done_24);
            binding.greenPriority.setImageResource(0);
            binding.redPriority.setImageResource(0);
            Priority="2";
        });

        binding.redPriority.setOnClickListener(v -> {
            binding.redPriority.setImageResource(R.drawable.ic_baseline_done_24);
            binding.yellowPriority.setImageResource(0);
            binding.greenPriority.setImageResource(0);
            Priority="3";
        });


    }
}