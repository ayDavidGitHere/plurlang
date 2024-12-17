package com.aydavid.plurlang;

import android.os.*;
import android.view.*;

//import android.support.v7.app.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Fragment homeFragment, translistFragment, quizesFragment, profileFragment;
    private Fragment activeFragment;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Geological-Regular.ttf"); // font from assets: "assets/fonts/Geological-Regular.ttf
        
        
        homeFragment = new HomeFragment();
        translistFragment = new TranslistFragment();
        quizesFragment = new QuizesFragment();
        profileFragment = new ProfileFragment();

        activeFragment = homeFragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, homeFragment, "home")
                .add(R.id.fragment_container, translistFragment, "translist")
                .add(R.id.fragment_container, quizesFragment, "quizes")
                .add(R.id.fragment_container, profileFragment, "profile")
                .hide(translistFragment)
                .hide(quizesFragment)
                .hide(profileFragment)
                .commit();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                switchFragment(homeFragment);
                return true;
            case R.id.navigation_translist:
                switchFragment(translistFragment);
                return true;
            case R.id.navigation_quizes:
                switchFragment(quizesFragment);
                return true;
            case R.id.navigation_profile:
                switchFragment(profileFragment);
                return true;
            default:
                return false;
        }
    }

    private void switchFragment(Fragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(activeFragment);
        if (!targetFragment.isAdded()) {
            transaction.add(R.id.fragment_container, targetFragment);
        }
        transaction.show(targetFragment);
        transaction.commit();
        activeFragment = targetFragment;
    }
}