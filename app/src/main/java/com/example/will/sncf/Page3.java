package com.example.will.sncf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Page3 extends AppCompatActivity implements View.OnClickListener{

    private TextView tvAccueil2;
    private String nom, prenom;
    private Button btSuivant;
    private RadioGroup rgClimatisation, rgConfort;
    private String rer ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        this.rer =this.getIntent().getStringExtra("rer");
        this.tvAccueil2 = (TextView) findViewById(R.id.idAccueil2);

        //recuperation des donnees de la page precedante
        this.nom = this.getIntent().getStringExtra("nom");
        this.prenom = this.getIntent().getStringExtra("prenom");
        this.tvAccueil2.setText("Bienvenue Mr/Mme " + this.nom+ " "+ this.prenom + "     "+  "Enquete de satisfaction sur le " + rer);

        this.btSuivant = (Button) findViewById(R.id.idSuivant3);
        this.rgClimatisation = (RadioGroup) findViewById(R.id.idClimatisation);
        this.rgConfort = (RadioGroup) findViewById(R.id.idConfort);

        this.btSuivant.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idSuivant3)
        {
            int scoreC = 0, scoreCF = 0;
            //recuperation des scores
            int id1 = this.rgClimatisation.getCheckedRadioButtonId();
            switch (id1)
            {
                case R.id.idRBc1 : scoreC = 6 ; break;
                case R.id.idRBc2 : scoreC = 12 ; break;
                case R.id.idRBc3 : scoreC = 16 ; break;
            }
            int id2 = this.rgConfort.getCheckedRadioButtonId();
            switch (id2)
            {
                case R.id.idRBcf1 : scoreCF = 6 ; break;
                case R.id.idRBcf2 : scoreCF = 12 ; break;
                case R.id.idRBcf3 : scoreCF = 16 ; break;
            }

            //ajout dans la HashMap du candidat courant
            SNCF.ajouterUneReponse(this.nom,"Climatisation", scoreC,this.rer);
            SNCF.ajouterUneReponse(this.nom,"Confort", scoreCF, this.rer);

            float m = SNCF.getMoyenneUnCandidat(this.nom,this.rer);
            Toast.makeText(this,"Moyenne : " +m, Toast.LENGTH_SHORT).show();

            //passer à la page suivante
            Intent unIntent = new Intent(this, Page4.class);

            //passage de paramètres
            unIntent.putExtra("nom",this.nom);
            unIntent.putExtra("prenom",this.prenom);
            unIntent.putExtra("rer",this.rer);

            //on démarre l'activité
            this.startActivity(unIntent);
        }
    }
}

