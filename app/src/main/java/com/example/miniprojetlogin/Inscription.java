package com.example.miniprojetlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Inscription extends AppCompatActivity {
    private EditText editName , editPrenom , editPhone , editMail , editPassword ;
    private CheckBox checkBox;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        editName = findViewById(R.id.editName);
        editPrenom = findViewById(R.id.editPrenom);
        editPhone = findViewById(R.id.editPhone);
        editMail = findViewById(R.id.editMail);
        editPassword = findViewById(R.id.editPassword);
        checkBox = findViewById(R.id.checkbox);

        submit = findViewById(R.id.inscrire);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                valideChamps();
            }
        });

    }
    private void valideChamps(){
        String name = editName.getText().toString().trim();
        String prenom = editPrenom.getText().toString().trim();
        String  phone = editPhone.getText().toString().trim();
        String mail = editMail.getText().toString().trim();
        String  password = editPassword.getText().toString().trim();

        if (name.isEmpty() || prenom.isEmpty() || phone.isEmpty() || mail.isEmpty() || password.isEmpty() || !checkBox.isChecked()){
            Toast.makeText(this,"Champs invalide ",Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this,ActivityBytton.class);
            startActivity(intent);
        }
    }
}