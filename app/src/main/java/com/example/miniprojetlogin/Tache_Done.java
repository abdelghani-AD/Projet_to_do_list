package com.example.miniprojetlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

public class Tache_Done extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tache_done);

        Toolbar toolbar = findViewById(R.id.toolbar_tach);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.tach_rec);

        List<Tache> taches = PersonalActivity.tache_sup;

        AdapterWork adapterWork = new AdapterWork(taches);

        recyclerView.setAdapter(adapterWork);
    }
}