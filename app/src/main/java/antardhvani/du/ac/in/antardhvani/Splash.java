package antardhvani.du.ac.in.antardhvani;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class Splash extends ActionBarActivity {
    public static ImageView du_logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        // Animations of splash screen.
        du_logo = (ImageView) findViewById(R.id.du_logo);

        fadein();
        // Calling MainActivity after Splash ends.
/*        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
        finish();*/
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
        fade.startNow();
    }

    private void shrinkAndTranslate()
    {
        Animation shrinkNtranslate = AnimationUtils.loadAnimation(this, R.anim.shrink);
        shrinkNtranslate.setRepeatCount(0);
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
        shrinkNtranslate.startNow();
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
