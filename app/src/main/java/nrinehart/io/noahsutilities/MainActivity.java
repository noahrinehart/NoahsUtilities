package nrinehart.io.noahsutilities;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import nrinehart.io.noahsutilities.fragments.MapFragment;
import nrinehart.io.noahsutilities.fragments.MoneyFragment;
import nrinehart.io.noahsutilities.fragments.TagFragment;
import nrinehart.io.noahsutilities.fragments.TaskFragment;
import nrinehart.io.noahsutilities.fragments.WeatherFragment;
import nrinehart.io.noahsutilities.settings.SettingsActivity;


public class MainActivity extends ActionBarActivity {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
    private String[] navigationDrawerItems;

    private Handler handler = new Handler();

    private static int OPTIONS_TYPE = 0;
    private static final String bundleKey = "ARG_BUNDLE_KEY";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setTitleTextColor(getResources().getColor(R.color.color_background));

        navigationDrawerItems = getResources().getStringArray(R.array.navigation_drawer_items);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listView = (ListView) findViewById(R.id.left_drawer);

        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        listView.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, navigationDrawerItems));
        listView.setOnItemClickListener(new DrawerItemClickListener());

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);


        if (savedInstanceState == null){
            selectItem(0);
        }

    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            selectItem(position);
        }
    }

    private void selectItem(int position){

        FragmentManager fragmentManager = getSupportFragmentManager();
        String pos = Integer.toString(position);
        Log.v(TAG, pos);

        if (position == 0){
            OPTIONS_TYPE = 0;
            fragmentManager.beginTransaction().replace(R.id.content_frame, new WeatherFragment()).commit();
            Log.v(TAG, "launched weather fragment");

        }else if (position == 1){
            OPTIONS_TYPE = 1;
            fragmentManager.beginTransaction().replace(R.id.content_frame, new MapFragment()).commit();
            Log.v(TAG, "launched map fragment");

        }else if (position == 2){
            OPTIONS_TYPE = 2;
            fragmentManager.beginTransaction().replace(R.id.content_frame, new TaskFragment()).commit();
            Log.v(TAG, "launched task fragment");

        }else if (position ==3){
            OPTIONS_TYPE = 3;
            fragmentManager.beginTransaction().replace(R.id.content_frame, new TagFragment()).commit();
            Log.v(TAG, "launched tag fragment");

        }else if (position == 4){
            OPTIONS_TYPE = 4;
            fragmentManager.beginTransaction().replace(R.id.content_frame, new MoneyFragment()).commit();
            Log.v(TAG, "launched money fragment");
        }

        invalidateOptionsMenu();
        //listView.setItemChecked(position, true);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                drawerLayout.closeDrawers();
            }
        }, 150);

    }

    @Override
    public void setTitle(CharSequence title){
        getSupportActionBar().setTitle(title);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.clear();

        if (OPTIONS_TYPE == 0){
            getMenuInflater().inflate(R.menu.menu_weather, menu);
        }
        else if (OPTIONS_TYPE == 2){
            getMenuInflater().inflate(R.menu.menu_task, menu);
        }
        else{
            getMenuInflater().inflate(R.menu.menu_task, menu);
        }


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
            return true;
        }
        else if (id == R.id.action_add_task){
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
