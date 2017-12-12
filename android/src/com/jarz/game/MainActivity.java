package com.jarz.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        Button startGame = (Button)findViewById(R.id.button2);
        Button viewScores = (Button)findViewById(R.id.button3);
        Button exitGame = (Button) findViewById(R.id.button4);

        // handle set start click
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AndroidLauncher.class);
                MainActivity.this.startActivity(intent);
            }
        });

        // handle exit click
        exitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

}
