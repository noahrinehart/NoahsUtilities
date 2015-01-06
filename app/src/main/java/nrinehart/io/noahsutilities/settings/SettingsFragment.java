package nrinehart.io.noahsutilities.settings;


import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import nrinehart.io.noahsutilities.R;

public class SettingsFragment extends PreferenceFragment{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        ListPreference listPreference = (ListPreference)findPreference("pref_unit");
        listPreference.setValueIndex(0);

        final CheckBoxPreference checkBoxPreference = (CheckBoxPreference)findPreference("pref_uselocation");
        final EditTextPreference editTextPreference = (EditTextPreference)findPreference("pref_zipcode");
        checkBoxPreference.setChecked(true);
        if (checkBoxPreference.isChecked()){
            editTextPreference.setEnabled(false);
        }
        checkBoxPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {

                if (checkBoxPreference.isChecked()){
                    editTextPreference.setEnabled(false);
                }else if(!checkBoxPreference.isChecked()){
                    editTextPreference.setEnabled(true);
                }
                return false;
            }
        });
    }

}
