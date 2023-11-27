package com.example.miniprojetlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Date;

public class New_task extends AppCompatActivity {
    EditText desc , date_debut,date_fin;
    Spinner list_categorie , list_prioprity;
    Button submit_done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        desc = findViewById(R.id.description);
        date_debut = findViewById(R.id.date_debut);
        date_fin = findViewById(R.id.date_fin);
        list_categorie = findViewById(R.id.list_categorie);
        list_prioprity = findViewById(R.id.list_prioprity);
        submit_done = findViewById(R.id.submit_done);

        ArrayList<String> categorie = new ArrayList<>();
        categorie.add("Home");
        categorie.add("Work");
        categorie.add("Personal");
        ArrayAdapter<String > adapterCategorie = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,categorie);
        list_categorie.setAdapter(adapterCategorie);
        ArrayList<String> priority = new ArrayList<>();
        priority.add("Important");
        priority.add("Moyen");
        priority.add("Faible");
        ArrayAdapter<String > adapterPriority = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,priority);
        list_prioprity.setAdapter(adapterPriority);

        submit_done.setOnClickListener((View)->{
            ajoutItem();
            Intent intent = new Intent(this,ActivityBytton.class);
            startActivity(intent);
        });
    }
    public void ajoutItem() {
        String descrption = desc.getText().toString();
        String dateDebut =  date_debut.getText().toString();
        String dateFin =  date_fin.getText().toString();
        String categories = list_categorie.getSelectedItem().toString();
        String pro = list_prioprity.getSelectedItem().toString();
        if (categories == "Home") {
            Home.listHome.add(new Tache(descrption, pro, "From " + dateDebut + " to" + dateFin, true));
        } else if (categories == "Work") {
            Work.listWork.add(new Tache(descrption, pro, "From " + dateDebut + " to" + dateFin, true));
        } else if (categories =="Personal"){
           PersonalActivity.listPer.add(new Tache(descrption, pro, "From " + dateDebut + " to" + dateFin, true));
        }

    }
}