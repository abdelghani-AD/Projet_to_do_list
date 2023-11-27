package com.example.miniprojetlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PersonalActivity extends AppCompatActivity {
    static List<Tache> tache_sup = new ArrayList<>();
    Button button;
    static List<Tache> listPer = new ArrayList<>();
    RecyclerView recyclerView;
    AdapterWork adapterWork;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        recyclerView = findViewById(R.id.per_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Toolbar toolbar = findViewById(R.id.per_bar);
        setSupportActionBar(toolbar);


     /*   listPer.add(new Tache("PC","Important","From 20/11/2022 to 22/12/2022",true));
        listPer.add(new Tache("Managment","Moyen","From 20/11/2022 to 22/12/2022",false));
        listPer.add(new Tache("Eco","Important","From 20/11/2022 to 22/12/2022",false));
        listPer.add(new Tache("Math","Faible","From 20/11/2022 to 22/12/2022",true));*/


        adapterWork = new AdapterWork(listPer);
        recyclerView.setAdapter(adapterWork);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.icon_add){
            Intent intent = new Intent(PersonalActivity.this,New_task.class);
            startActivity(intent);
            return true;
        }
        if ( itemId == R.id.icon_menu){
            Intent intent = new Intent(PersonalActivity.this,ActivityBytton.class);
            startActivity(intent);
            return true;
        }
        if ( itemId == R.id.icn_back) {
            Intent intent = new Intent(PersonalActivity.this, ActivityBytton.class);
            startActivity(intent);
            return true;
        }
        if (itemId == R.id.icon_delete){
            for (int i=0;i<listPer.size();i++){
                if (listPer.get(i).isCheck()){
                    tache_sup.add(listPer.get(i));
                    listPer.remove(i);
                }
            }
            adapterWork = new AdapterWork(listPer);
            recyclerView.setAdapter(adapterWork);
            Intent intent = new Intent(PersonalActivity.this,Tache_Done.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}