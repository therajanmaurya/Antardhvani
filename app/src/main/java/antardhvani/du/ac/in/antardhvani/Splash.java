package antardhvani.du.ac.in.antardhvani;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class Splash extends ActionBarActivity {
    public static ImageView du_logo, haathi;
    public  TextView antar, university;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        // Animations of splash screen.
        du_logo = (ImageView) findViewById(R.id.du_logo);
        haathi = (ImageView) findViewById(R.id.haathi);
        antar = (TextView) findViewById(R.id.antardhwani);
        university = (TextView) findViewById(R.id.du_name);




        fadein();

    }

    private void fadein()
    {
        Animation fade = AnimationUtils.loadAnimation(this, R.anim.fadein);
        fade.setRepeatCount(0);
        fade.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                du_logo.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                shrinkAndTranslate();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                ;
            }
        });
        du_logo.startAnimation(fade);
    }

    private void shrinkAndTranslate()
    {
        Animation shrinkNtranslate = AnimationUtils.loadAnimation(this, R.anim.shrink);
        shrinkNtranslate.setRepeatCount(0);
        shrinkNtranslate.setFillAfter(true);
        shrinkNtranslate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                fadeText();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        du_logo.startAnimation(shrinkNtranslate);
    }

    private void fadeText()
    {
        Animation fadetext1 = AnimationUtils.loadAnimation(this, R.anim.fadein);
        fadetext1.setRepeatCount(0);
        fadetext1.setFillAfter(true);
        fadetext1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                antar.setVisibility(View.VISIBLE);
                university.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                logo();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        antar.startAnimation(fadetext1);
        university.startAnimation(fadetext1);
    }

    private void logo()
    {
        final RelativeLayout splash = (RelativeLayout)findViewById(R.id.splashScreen);

        Animation fade = AnimationUtils.loadAnimation(this, R.anim.grow);
        fade.setRepeatCount(0);
        fade.setFillAfter(true);
        fade.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                haathi.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                end();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        haathi.startAnimation(fade);
        ObjectAnimator.ofObject(splash, "backgroundColor", new ArgbEvaluator(), 0xff222222, 0xffdd6a0f)
                .setDuration(1000).start();

    }

    private void end()
    {
        // Calling MainActivity after Splash ends.0xFFFF72070xFFFF7207
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
