package com.example.twoactivities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView
        .OnNavigationItemSelectedListener {

    BottomNavigationView mBottomNavigationView;
    public static final int DISPLAY_SHOW_TITLE = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(mToolbar);

        mBottomNavigationView
                = findViewById(R.id.bottom_nav);

        mBottomNavigationView
                .setOnNavigationItemSelectedListener(this);
        mBottomNavigationView.setSelectedItemId(R.id.home);

    }
    HomeFragment homeFragment = new HomeFragment();
    ReportFragment reportFragment = new ReportFragment();
    @Override
    public boolean
    onNavigationItemSelected(@NonNull MenuItem item)
    {

        int itemId = item.getItemId();
        if (itemId == R.id.home) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_main, homeFragment)
                    .commit();
            return true;
        } else if (itemId == R.id.report) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_main, reportFragment)
                    .commit();
            return true;
        }
        return false;
    }

}