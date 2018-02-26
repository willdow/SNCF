package com.example.will.sncf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Page2 extends AppCompatActivity implements View.OnClickListener{

    private TextView tvAccueil;
    private String nom, prenom;
    private Button btSuivant;
    private RadioGroup rgProprete, rgPonctualite;
    private String rer ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        this.rer =this.getIntent().getStringExtra("rer");
        this.tvAccueil = (TextView) findViewById(R.id.idAccueil);

        //recuperation des donnees de la page precedante
        this.nom = this.getIntent().getStringExtra("nom");
        this.prenom = this.getIntent().getStringExtra("prenom");
        this.tvAccueil.setText("Bienvenue Mr/Mme " + this.nom+ " "+ this.prenom + "     "+  "Enquete de satisfaction sur le " + rer);

        this.btSuivant = (Button) findViewById(R.id.idSuivant2);
        this.rgProprete = (RadioGroup) findViewById(R.id.idProprete);
        this.rgPonctualite = (RadioGroup) findViewById(R.id.idPonctualite);

        this.btSuivant.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idSuivant2)
        {
            int scoreP = 0, scorePC = 0;
            //recuperation des scores
            int id1 = this.rgProprete.getCheckedRadioButtonId();
            switch (id1)
            {
                case R.id.idRBp1 : scoreP = 6 ; break;
                case R.id.idRBp2 : scoreP = 12 ; break;
                case R.id.idRBp3 : scoreP = 16 ; break;
            }
            int id2 = this.rgPonctualite.getCheckedRadioButtonId();
            switch (id2)
            //ou    switch (this.rgPonctualite.getCheckedRadioButtonId())
            {
                case R.id.idRBp1 : scorePC = 6 ; break;
                case R.id.idRBp2 : scorePC = 12 ; break;
                case R.id.idRBp3 : scorePC = 16 ; break;
            }

            //ajout dans la HashMap du candidat courant

            SNCF.ajouterUneReponse(this.nom,"Propreté", scoreP,this.rer);
            SNCF.ajouterUneReponse(this.nom,"Ponctualité", scorePC,this.rer);

            float m = SNCF.getMoyenneUnCandidat(this.nom,this.rer);
            Toast.makeText(this,"Moyenne : " +m, Toast.LENGTH_SHORT).show();

            //passer à la page suivante 3
            Intent unIntent = new Intent(this, Page3.class);

            //passage de paramètres
            unIntent.putExtra("nom",this.nom);
            unIntent.putExtra("prenom",this.prenom);
            unIntent.putExtra("rer",this.rer);

            //on démarre l'activité
            this.startActivity(unIntent);
        }
    }
}
