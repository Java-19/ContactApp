package com.sheygam.java_19_contactapp.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sheygam.java_19_contactapp.R;
import com.sheygam.java_19_contactapp.presentation.login.view.LoginFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root,new LoginFragment())
                .commit();

    }
}
