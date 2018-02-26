package com.example.will.sncf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class Page4 extends AppCompatActivity  implements View.OnClickListener{

    private String nom, prenom;
    private Button btRetour;
    private ListView lvListe;
    private String rer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);

        this.rer =this.getIntent().getStringExtra("rer");

        this.nom = this.getIntent().getStringExtra("nom");
        this.prenom = this.getIntent().getStringExtra("prenom");

        this.btRetour = (Button) findViewById(R.id.idRetour);
        this.lvListe = (ListView) findViewById(R.id.idListe);

        this.btRetour.setOnClickListener(this);

        //remplir la liste :
        ArrayList<String> laListeC = SNCF.listerCandidats(this.rer);
        ArrayList<Integer> laListeI = SNCF.listerSmiley(this.rer);


        int tabI[] = new int [laListeI.size()];
        int i = 0;
        for (Integer element : laListeI)
        {
            tabI[i++] = element;
        }
        i = 0;
        String tabC [] = new String[laListeC.size()];
        for (String element : laListeC)
        {
            tabC[i++] = element ;
        }

        AdapterListe unAdapter = new AdapterListe(this, tabC,tabI);
        this.lvListe.setAdapter(unAdapter);



    }

    @Override
    public void onClick(View v) {
        if (R.id.idRetour == v.getId())
        {
            Intent unIntent = new Intent(this, MainActivity.class);

            this.startActivity(unIntent);
        }

    }
}
