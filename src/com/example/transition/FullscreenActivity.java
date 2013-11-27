package com.example.transition;

import com.example.transition.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class FullscreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);
    }
    
    public void changeActivity(View view){
    	Toast.makeText(this, "Hello!", Toast.LENGTH_SHORT).show();
    	Intent intent = new Intent(this, SecondFullscreenActivity.class);
    	startActivity(intent);
    	overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }
    
    public void goLeft(View view){
    	Toast.makeText(this, "Can't go back", Toast.LENGTH_SHORT).show();
    }
    
    public void goRight(View view){
    	Intent intent = new Intent(this, SecondFullscreenActivity.class);
    	startActivity(intent);
    	overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }
}