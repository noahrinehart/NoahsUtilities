package nrinehart.io.noahsutilities.settings;

import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import nrinehart.io.noahsutilities.R;


public class SettingsActivity extends ActionBarActivity {

    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_settings);
        toolbar = (Toolbar) findViewById(R.id.settings_toolbar);
        setSupportActionBar(toolbar);
        getFragmentManager().beginTransaction().replace(R.id.settings_content_frame, new SettingsFragment()).commit();
    }

}