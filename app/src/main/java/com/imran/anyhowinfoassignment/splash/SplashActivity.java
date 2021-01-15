package com.imran.anyhowinfoassignment.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.imran.anyhowinfoassignment.MainActivity;
import com.imran.anyhowinfoassignment.R;
import com.imran.anyhowinfoassignment.SharedPrefManager;
import com.imran.anyhowinfoassignment.model.User;
import com.imran.anyhowinfoassignment.login.SignupActivity;

public class SplashActivity extends AppCompatActivity {
    ImageView iv;
    private User currentuser;
    SharedPrefManager sharedPrefManager;
    Boolean login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sharedPrefManager=new SharedPrefManager(this);
        login=sharedPrefManager.isLoginIn();

        iv=findViewById(R.id.splashiv);
        animation();
    }

    private void animation()
    {
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.slideup);
        iv.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation)
            {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {

                if (login ==true) {
                    gotohomepage();
                } else {
                    startActivity(new Intent(SplashActivity.this, SignupActivity.class));
                    finish();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });
    }

    private void gotohomepage()
    {
        Intent intent=new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}