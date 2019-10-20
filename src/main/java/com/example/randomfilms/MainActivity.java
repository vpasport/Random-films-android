package com.example.randomfilms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] myfilms;
    TextView filmTitle;
    boolean[] watching;
    int filmid = 0;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filmTitle = findViewById(R.id.filmT);
        myfilms = getResources().getStringArray(R.array.films);
        watching = new boolean[myfilms.length];
        for (int i = 0; i < myfilms.length; i++){
            watching[i] = false;
        }
    }
    public void onClick(View v) {
        if (v.getId() == R.id.gen){
            if (count == myfilms.length){
                filmTitle.setText("No films");
                Toast.makeText( this, "Movies are over", Toast.LENGTH_LONG ).show();
            }
            else {
                filmid = (int)(Math.random() * myfilms.length);
                while (watching[filmid]){
                    filmid = (int)(Math.random() * myfilms.length);
                }
                filmTitle.setText(myfilms[filmid]);
                watching[filmid] = true;
                count++;
            }
        }
        if (v.getId() == R.id.restart){
            for (int i = 0; i < myfilms.length; i++){
                watching[i] = false;
            }
            count = 0;
            filmTitle.setText("Press Generate to choose a film");
        }
    }
}
