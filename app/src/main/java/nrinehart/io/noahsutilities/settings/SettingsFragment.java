package nrinehart.io.noahsutilities.settings;


import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;

import nrinehart.io.noahsutilities.R;

public class SettingsFragment extends PreferenceFragment{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        ListPreference listPreference = (ListPreference)findPreference("pref_unit");
        listPreference.setValueIndex(0);
    }

}
