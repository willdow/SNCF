package com.example.will.sncf;

import java.util.HashMap;

/**
 * Created by will on 12/02/2018.
 */

public class Candidat
{
    private String nom, prenom, age, frequence, profession;
    private HashMap<String, Integer> lesReponses ;

    public Candidat (String nom, String prenom, String age, String frequence, String profession)
    {
        this.nom = nom;
        this.prenom= prenom;
        this.age = age;
        this.frequence = frequence ;
        this.profession = profession ;
        this.lesReponses = new HashMap<String, Integer>();
    }
    public void ajouterReponse (String question, int score)
    {
        this.lesReponses.put (question, score);
    }
    public float getMoyenne ()
    {
        float moyenne =0;
        for (Integer score : this.lesReponses.values())
        {
            moyenne += score;
        }
        moyenne /= this.lesReponses.size();
        return moyenne;
    }
    public int getSmiley ()
    {
        if (this.getMoyenne()<10) return 1;
        else if (this.getMoyenne()<14) return 2;
        else return 3;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFrequence() {
        return frequence;
    }

    public void setFrequence(String frequence) {
        this.frequence = frequence;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public HashMap<String, Integer> getLesReponses() {
        return lesReponses;
    }

    public void setLesReponses(HashMap<String, Integer> lesReponses) {
        this.lesReponses = lesReponses;
    }
}
