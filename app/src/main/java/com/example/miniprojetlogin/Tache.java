package com.example.miniprojetlogin;

import android.widget.CheckBox;

import java.util.Date;

public class Tache {
    private String Titre;
     private  final String pr = "Priority";
    private String Priorite;
    private String date;
    private boolean check;




    public Tache(String titre,String priorite ,String date,boolean check ) {
        this.Titre = titre;
        Priorite = priorite;
        this.date = date;
        this.check = check;

    }
    public boolean isCheck() {
        return check;
    }

    public String getPr() {
        return pr;
    }

    public String getDate() {
        return date;
    }

    public String getPriorite() {
        return Priorite;
    }
    public String getTitre() {return Titre;}

}
