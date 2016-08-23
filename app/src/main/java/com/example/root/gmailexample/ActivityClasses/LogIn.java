package com.example.root.gmailexample.ActivityClasses;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.root.gmailexample.FragmentsClass.FirstFragment;
import com.example.root.gmailexample.FragmentsClass.SecondFragment;
import com.example.root.gmailexample.FragmentsClass.ThirdFragment;
import com.example.root.gmailexample.ListAdapter.CustomListAdapter;
import com.example.root.gmailexample.POJO.ItemObject;
import com.example.root.gmailexample.R;

import java.util.ArrayList;


/**
 * Created by root on 20/8/16.
 */
public class LogIn extends AppCompatActivity{

    Toolbar toolbar;
    NavigationView nvDrawer;
    DrawerLayout mDrawer;
    ActionBarDrawerToggle drawerToggle;
    ListView listView;
    ArrayList<ItemObject> listData;
    CustomListAdapter adapter;
    private ArrayList<ItemObject> data;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        drawerToggle.setDrawerIndicatorEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
        toolbar.setNavigationIcon(R.mipmap.menu_icon);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        setupDrawerToggle();
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        setupDrawerContent(nvDrawer);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawer.openDrawer(Gravity.LEFT);
            }
        });

        listView = (ListView) findViewById(R.id.listView1);
        listData = getData();
        if (listData != null) {
            adapter = new CustomListAdapter(this, listData);
            listView.setAdapter(adapter);


            mDrawer.addDrawerListener(drawerToggle);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(LogIn.this, "Hello", Toast.LENGTH_SHORT).show();
//            }
//        });


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                }
            });

        }
    }

    private ActionBarDrawerToggle setupDrawerToggle() {

        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);

    }





    @Override

    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);

        // Pass any configuration change to the drawer toggles

        drawerToggle.onConfigurationChanged(newConfig);

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

                        switch(menuItem.getItemId()) {

                            case R.id.nav_first_fragment:

                                Log.i("See here ","first");
                                fragmentClass = FirstFragment.class;

                                break;

                            case R.id.nav_second_fragment:

                                Log.i("See here ","second");
                                fragmentClass = SecondFragment.class;

                                break;

                            case R.id.nav_third_fragment:

                                Log.i("See here ","third");
                                fragmentClass = ThirdFragment.class;

                                break;

                            default:
                                Log.i("See here ","default");
                                fragmentClass=FirstFragment.class;
                                mDrawer.closeDrawer(Gravity.LEFT);



                        }



                        try {

                            fragment = (android.support.v4.app.Fragment) fragmentClass.newInstance();

                        } catch (Exception e) {

                            e.printStackTrace();

                        }



                        // Insert the fragment by replacing any existing fragment

                        FragmentManager fragmentManager = getSupportFragmentManager();

                        try
                        {fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();}
                        catch(Exception e)
                        {
                            Log.v("Exception Ashish","see here",e);
                        }




                        // Highlight the selected item has been done by NavigationView

                        menuItem.setChecked(true);

                        // Set action bar title

                        setTitle(menuItem.getTitle());

                        // Close the navigation drawer

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

                mDrawer.openDrawer(GravityCompat.START);

                return true;

        }

        return super.onOptionsItemSelected(item);

        // The action bar home/up action should open or close the drawer.




    }

    public ArrayList<ItemObject> getData() {
        ArrayList<ItemObject> list = new ArrayList<>();

        ItemObject movies1 = new ItemObject();
        movies1.setTitle("Kingsman: The Secret Service ");
        movies1.setImageIcon(R.drawable.gmail_logo);
        list.add(movies1);

        ItemObject movies2 = new ItemObject();
        movies2.setTitle("Birdman: Or (The Unexpected Virtue of Ignorance)");
        movies2.setImageIcon(R.drawable.gmail_logo);
        list.add(movies2);

        ItemObject movies3 = new ItemObject();
        movies3.setTitle("American Sniper");
        movies3.setImageIcon(R.drawable.gmail_logo);
        list.add(movies3);

        ItemObject movies4 = new ItemObject();
        movies4.setTitle("Whiplash");
        movies4.setImageIcon(R.drawable.gmail_logo);
        list.add(movies4);

        ItemObject movies5 = new ItemObject();
        movies5.setTitle("Big Hero");
        movies5.setImageIcon(R.drawable.gmail_logo);
        list.add(movies5);

        ItemObject movies6 = new ItemObject();
        movies6.setTitle("The Imitation Game");
        movies6.setImageIcon(R.drawable.gmail_logo);
        list.add(movies6);

        ItemObject movies7 = new ItemObject();
        movies7.setTitle("John Wick");
        movies7.setImageIcon(R.drawable.gmail_logo);
        list.add(movies7);

        return list;

    }


    // `onPostCreate` called when activity start-up is complete after `onStart()`

    // NOTE! Make sure to override the method with only a single `Bundle` argument

//    @Override
//
//    protected void onPostCreate(Bundle savedInstanceState) {
//
//        super.onPostCreate(savedInstanceState);
//        drawerToggle.syncState();
//
//    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
}
