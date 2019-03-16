package com.kars.second.habitbuilder;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.kars.second.habitbuilder.Login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        final FirebaseUser mUser = mAuth.getCurrentUser();
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(mUser == null) {
                    Intent mIntent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(mIntent);
                }else{
                    Intent m2Intent = new Intent(MainActivity.this,MainViewHabit.class);
                    startActivity(m2Intent);
                }
                finish();
            }
        },2000);
    }

}
