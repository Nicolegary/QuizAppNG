package com.patterson.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;   
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declare variables
    Button answer1;
    Button answer2;
    int score;
    Button finishedBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize our variable & our IU elements
        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        finishedBTN = (Button) findViewById(R.id.finishedBTN);
        score = 0;

        // set button onClickListener
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "You got it wrong";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "You got it right";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                score = score + 1;

            }
        });

        finishedBTN.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  String packageContext;
                  Intent myIntent = new Intent(MainActivity.this, ScoreActivity.class);
                  myIntent.putExtra( "score", score);
                  startActivity(myIntent);
              }
        });




    }
}


