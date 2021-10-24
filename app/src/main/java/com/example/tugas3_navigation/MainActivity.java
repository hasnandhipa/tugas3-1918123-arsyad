package com.example.tugas3_navigation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Memanggil Action Bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Memanggil drawer_layout dari activity_main.xml
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView =
                findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //Hamburger Icon
        ActionBarDrawerToggle toggle = new
                ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //Default Navigation ke menu Photo
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PhotoFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_photo);}
    }
    //drawer menu fragment handler
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem
                                                    item) {
        switch (item.getItemId()){
            case R.id.nav_photo:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PhotoFragment()).commit();
                break;
            case R.id.nav_portrait:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PortraitFragment()).commit();
                break;
            case R.id.nav_landscape:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LandscapeFragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //on back press behavior
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}
