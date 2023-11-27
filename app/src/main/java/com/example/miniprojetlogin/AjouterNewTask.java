package com.example.miniprojetlogin;

import java.util.ArrayList;
import java.util.Date;

public class AjouterNewTask {
    private  String desc;
    private Date dateDebut;
    private  Date datFin;

    ArrayList<Tache> newTask = new ArrayList<>();
    public AjouterNewTask(String desc , Date dateDebut , Date  datFin){
        this.desc = desc;
        this.dateDebut = dateDebut;
        this.datFin = datFin;
    }

    public String getDesc() {
        return desc;
    }
    public Date getDateDebut() {
        return dateDebut;
    }
    public Date getDatFin() {
        return datFin;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    public void setDatFin(Date datFin) {
        this.datFin = datFin;
    }

    public void ajouterTask(){
        newTask.add(new Tache(desc,"","From "+dateDebut+" to "+datFin , true));
    }
}
