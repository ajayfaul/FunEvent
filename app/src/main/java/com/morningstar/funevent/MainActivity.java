package com.morningstar.funevent;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.morningstar.funevent.view.ExploreMapFragment;
import com.morningstar.funevent.view.HomeFragment;
import com.morningstar.funevent.view.ProfileFragment;
import com.morningstar.funevent.view.StarredEventFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.navigation_view);
        navView.setOnNavigationItemSelectedListener(this);

        loadFragment(new HomeFragment());
    }

    void loadFragment(Fragment fragment) {
        FragmentTransaction fragmen = getSupportFragmentManager().beginTransaction();
        fragmen.replace(R.id.frame_container, fragment);
        fragmen.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.navigation_home:
                loadFragment(new HomeFragment());
                return true;
            case R.id.navigation_explore:
                loadFragment(new ExploreMapFragment());
                return true;
            case R.id.navigation_starred_event:
                loadFragment(new StarredEventFragment());
                return true;
            case R.id.navigation_profile:
                loadFragment(new ProfileFragment());
                return true;
        }
        return false;
    }
}
