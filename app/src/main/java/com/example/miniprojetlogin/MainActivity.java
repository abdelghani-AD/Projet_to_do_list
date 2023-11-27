package com.example.miniprojetlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editUser;
    EditText editPassword;
    Button signUp;
    private Toast myToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUser = findViewById(R.id.editUser);
        editPassword = findViewById(R.id.editPassword);
        signUp = findViewById(R.id.noveauCompte);

        /*resultat = findViewById(R.id.resultat);
        resultatList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,resultatList);
        resultat.setAdapter(adapter);*/

        Button submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valideChamps();
            }
        });

//transfert à l'Activity de l'inscription
        signUp.setOnClickListener((View)->{
            Intent i = new Intent(this,Inscription.class);
            startActivity(i);
        });
    }

//fonction valider la forme
    private void valideChamps(){
        String user = editUser.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        if (user.isEmpty() || password.isEmpty()){
            myToast = Toast.makeText(this, "Les Champs invalide ", Toast.LENGTH_SHORT);
            myToast.show();
        }
        else {
            /*String resultatFinal = "User: " + user + "  de Password : " + password;
            resultatList.add(resultatFinal);
            adapter.notifyDataSetChanged();
            editUser.getText().clear();
            editPassword.getText().clear();*/
            Intent intent = new Intent(this,ActivityBytton.class);
            startActivity(intent);
        }
    }
}