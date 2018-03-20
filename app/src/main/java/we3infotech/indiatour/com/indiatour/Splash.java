package we3infotech.indiatour.com.indiatour;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {
    private static final String TAG = null;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
       /* ActionBar actionBar = getSupportActionBar();
        actionBar.hide();*/

        context = this;
        initFlip();
    }
    private void initFlip() {

        ImageView imageView = (ImageView) findViewById(R.id.logo);
        /*Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blick);
        imageView.startAnimation(animation);*/
        FlipAnimation.create().with(imageView)
                .setDuration(3600)
                .setRepeatCount(FlipAnimation.INFINITE)
                .start();

    }
    public void onStart() {
        super.onStart();

        new Thread(new Runnable() {
            public void run() {
                try {

                    Thread.sleep(5000);
                    Intent ii=new Intent(getBaseContext(),MainActivity.class);
                    ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(ii);


                }
                catch (Throwable t) {
                }
            }
        }).start();
    }
/*
        Thread splash = new Thread() {
            public void run() {
                try {

                    //set sleep time

                    sleep(3 * 1000);
                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                } catch (Exception e) {

                }
            }
        };
        splash.start();

    }*/
}
