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
import android.view.Window;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class FullscreenActivity extends Activity {
	private RollingStone instance;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fullscreen);
        
        instance = RollingStone.getInstance();
        instance.setString("Activity 1 was here");
    }
    
    public void changeActivity(View view){
    	Toast.makeText(this, "Hello!", Toast.LENGTH_SHORT).show();
    	Intent intent = new Intent(this, SecondFullscreenActivity.class);
    	startActivity(intent);
    	overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }
    
    public void goLeft(View view){
    	Toast.makeText(this, instance.getString(), Toast.LENGTH_SHORT).show();
    }
    
    public void goRight(View view){
    	Intent intent = new Intent(this, SecondFullscreenActivity.class);
    	startActivity(intent);
    	overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }
}