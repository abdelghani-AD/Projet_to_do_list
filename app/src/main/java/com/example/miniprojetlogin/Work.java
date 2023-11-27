package com.example.miniprojetlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class Work extends AppCompatActivity {
    static  List<Tache> listWork = new ArrayList<>();
    RecyclerView recyclerView;
    AdapterWork adapterWork;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
         recyclerView = findViewById(R.id.work_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Toolbar toolbar = findViewById(R.id.toolbar_work);
        setSupportActionBar(toolbar);

     /*   listWork.add(new Tache("PC","Important","From 20/11/2022 to 22/12/2022",true));
        listWork.add(new Tache("Managment","Moyen","From 20/11/2022 to 22/12/2022",false));
        listWork.add(new Tache("Eco","Important","From 20/11/2022 to 22/12/2022",false));
        listWork.add(new Tache("Math","Faible","From 20/11/2022 to 22/12/2022",true));*/
        adapterWork = new AdapterWork(listWork);
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
            Intent intent = new Intent(Work.this,New_task.class);
            startActivity(intent);
            return true;
        }
        if ( itemId == R.id.icon_menu){
            Intent intent = new Intent(Work.this,ActivityBytton.class);
            startActivity(intent);
            return true;
        }
        if ( itemId == R.id.icn_back) {
            Intent intent = new Intent(Work.this, ActivityBytton.class);
            startActivity(intent);
            return true;
        }
      if (itemId == R.id.icon_delete){
           for (int i=0;i<listWork.size();i++){
               if (listWork.get(i).isCheck()){
                   listWork.remove(i);
               }
           }
          adapterWork = new AdapterWork(listWork);
           recyclerView.setAdapter(adapterWork);
           Toast.makeText(this,"Delete selected",Toast.LENGTH_LONG).show();
           return true;
        }
        return super.onOptionsItemSelected(item);
    }

}