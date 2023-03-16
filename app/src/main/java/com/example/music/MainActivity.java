package com.example.music;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3;
    MediaPlayer mp;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3=findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv = findViewById(R.id.imageView);
                iv.setVisibility(View.VISIBLE);

                if(mp==null)
                {
                    mp= MediaPlayer.create(getApplicationContext(),R.raw.yoo);
                }
                mp.start();
                Toast.makeText(MainActivity.this, "Music Playing", Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv.setVisibility(View.INVISIBLE);

                if(mp!=null)
                {
                    mp.pause();
                    Toast.makeText(MainActivity.this, "Music Paused", Toast.LENGTH_SHORT).show();

                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp!=null)
                {
                    mp.release();
                    Toast.makeText(MainActivity.this, "Song deleted", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    }
