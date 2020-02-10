package com.example.music;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/*Implement 4 objects:
TODO: work with file system to store game and composed files. MIDI format?
swype rhythm game: generate points that you have to swipe across to the beat of a given piece. Some pre-programmed, others you can build with the composition tool.
TODO:
composition tool: input something (string of characters representing pitches and time and volume?) and use it to generate a piece of music. Potentially create a better UI for this.
TODO:
Visualizer: Play a piece of music and show all the pitches and amplitudes using the Drawview.
Something that converts singing into a manipulable data file?

 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button playButton = this.findViewById(R.id.button);
        playButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, PlayerActivity.class));
            }
        });
    }


}
