package ca.thedjkm.it.smartlock;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
// Kamaljit Mahal N01377647 Section B
// Dillon Permaul N01372657 Section B
// Janpreet Singh N01361405 Section B
// Meet Gajjar N01391319 Section B


public class Preference extends PreferenceActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting_screen);
        Load_setting(); //error

    }

    private void Load_setting(){

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

        boolean chk_night = sp.getBoolean("NIGHT",false);
        if(chk_night){
            getListView().setBackgroundColor(Color.parseColor("#222222"));
        } else {
            getListView().setBackgroundColor(Color.parseColor("#ffffff"));
        }


        CheckBoxPreference chk_night_instant = (CheckBoxPreference)findPreference("NIGHT");
        chk_night_instant.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(android.preference.Preference setting_screen, Object obj) {

                boolean yes = (boolean)obj;

                if (yes){
                    getListView().setBackgroundColor(Color.parseColor("#222222"));
                }else{
                    getListView().setBackgroundColor(Color.parseColor("#ffffff"));
                }

                return true;
            }
        });


        };
// 15:00 mins




    @Override
    protected void onResume() {
        Load_setting();
        super.onResume();
    }
}
