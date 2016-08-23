package com.example.root.gmailexample.ActivityClasses;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.root.gmailexample.FragmentsClass.FirstFragment;
import com.example.root.gmailexample.FragmentsClass.ListWithinFragment;
import com.example.root.gmailexample.FragmentsClass.SecondFragment;
import com.example.root.gmailexample.FragmentsClass.ThirdFragment;
import com.example.root.gmailexample.R;


/**
 * Created by root on 20/8/16.
 */
public class HomeScreen extends AppCompatActivity {

    Toolbar toolbar;
    ActionBar actionBar;
    NavigationView nvDrawer;
    DrawerLayout mDrawer;
    ActionBarDrawerToggle drawerToggle;
    FrameLayout frameLayout;
    FragmentManager fragmentManager;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeViews();

        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setTitle(getClass().getSimpleName());

        // when the user clicks the navigation button
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawer.openDrawer(Gravity.LEFT);
            }
        });

        drawerToggle = setupDrawerToggle();
        mDrawer.addDrawerListener(drawerToggle);
        setupDrawerContent(nvDrawer);
        drawerToggle.setDrawerIndicatorEnabled(true);


        FragmentManager fm = getSupportFragmentManager();
        fragment = fm.findFragmentByTag("myFragmentTag");
        if (fragment == null) {
            FragmentTransaction ft = fm.beginTransaction();
            fragment =new ListWithinFragment();
            ft.add(R.id.flContent,fragment,"myFragmentTag");
            ft.addToBackStack(null);
            ft.commit();
        }

    }




    private void initializeViews() {
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        frameLayout = (FrameLayout) findViewById(R.id.flContent);
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        fragmentManager = getSupportFragmentManager();

    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        return drawerToggle;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles        drawerToggle.onConfigurationChanged(newConfig);
    }

    private void setupDrawerContent(NavigationView nvDrawer) {
        nvDrawer.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }

                    private void selectDrawerItem(MenuItem menuItem) {
                        Fragment fragment = null;

                        Class fragmentClass;

                        switch (menuItem.getItemId()) {

                            case R.id.nav_first_fragment:

                                actionBar.setHomeButtonEnabled(true);
                                fragmentClass = FirstFragment.class;
                                actionBar.setTitle(fragmentClass.getSimpleName());
                                break;

                            case R.id.nav_second_fragment:

                                actionBar.setHomeButtonEnabled(true);
                                fragmentClass = SecondFragment.class;
                                actionBar.setTitle(fragmentClass.getSimpleName());
                                break;

                            case R.id.nav_third_fragment:

                                actionBar.setHomeButtonEnabled(true);
                                fragmentClass = ThirdFragment.class;
                                actionBar.setTitle(fragmentClass.getSimpleName());
                                break;

                            case R.id.list:
                                actionBar.setHomeButtonEnabled(false);
                                fragmentClass = ListWithinFragment.class;
                                actionBar.setTitle(fragmentClass.getSimpleName());
                                break;

                            default:

                                actionBar.setHomeButtonEnabled(false);
                                fragmentClass = ListWithinFragment.class;
                                actionBar.setTitle(fragmentClass.getSimpleName());
                                mDrawer.closeDrawer(Gravity.LEFT);

                        }

                        try {
                            fragment = (Fragment) fragmentClass.newInstance();
                        } catch (Exception e) {
                        }


                        try {
                            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).addToBackStack(null).commit();
                        } catch (Exception e) {
                        }

                        menuItem.setChecked(true);
                        setTitle(menuItem.getTitle());
                        mDrawer.closeDrawers();
                    }
                });
    }


    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;

        }
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);


    }

    // `onPostCreate` called when activity start-up is complete after `onStart()`

    // NOTE! Make sure to override the method with only a single `Bundle` argument

    @Override

    protected void onPostCreate(Bundle savedInstanceState) {

        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
