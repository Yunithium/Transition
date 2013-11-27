package com.example.transition;

import com.example.transition.util.SystemUiHider;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.support.v4.app.NavUtils;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class SecondFullscreenActivity extends Activity {
	private ViewFlipper viewFlipper;
	private ImageView imageView;
	private int currentImage;
	private int currentImageView;
	private int[] images;
	private int[] imageViews;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second_fullscreen);
		
		// Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
        
        currentImage = 0;
        currentImageView = 0;
        
        images = new int[3];
        images[0] = R.drawable.srv;
        images[1] = R.drawable.black_sabbath;
        images[2] = R.drawable.muse;
        
        //Only two ImageView objects are used.
        imageViews = new int[2];
        imageViews[0] = R.id.image_view_1;
        imageViews[1] = R.id.image_view_2;
        
        viewFlipper = (ViewFlipper) findViewById(R.id.flipper_of_views);
        
        imageView = (ImageView) findViewById(imageViews[currentImageView]);
        imageView.setImageResource(images[currentImage]);
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void goLeft(View view){
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_in));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_out));
        
        //Choose the previous image in the queue as the next image to show ("goLeft")
        //Change the ImageView to the other one (there are only two)
        currentImage = (currentImage-1+images.length)%images.length;
        currentImageView = (currentImageView+1)%imageViews.length;
        
        //Get the ImageView
        //Set a picture to the ImageView
        imageView = (ImageView) findViewById(imageViews[currentImageView]);
        imageView.setImageResource(images[currentImage]);
        
        viewFlipper.showPrevious();
    	//finish();
		//overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }
    
    public void goRight(View view){
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_in));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_out));
        
        currentImage = (currentImage+1)%images.length;
        currentImageView = (currentImageView+1)%imageViews.length;
        
        imageView = (ImageView) findViewById(imageViews[currentImageView]);
        imageView.setImageResource(images[currentImage]);
        
    	viewFlipper.showNext();
    }
    
    //Notes for future:
    // If loading images become a problem, create three ImageViews so that there's always a
    // next and a previous.
    //
    // Example: If the user just went left then discard your "right" image and load a new
    // "left" image as your "left" image just became your "center" image.
    //
    // This way the loading is done immediately after each shift and not when a shift is to
    // be done.
}
