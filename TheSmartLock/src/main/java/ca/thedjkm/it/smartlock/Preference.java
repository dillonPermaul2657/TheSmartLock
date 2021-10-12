package ca.thedjkm.it.smartlock;

import android.os.Bundle;
import android.preference.PreferenceActivity;
// Kamaljit Mahal N01377647 Section B
// Dillon Permaul N01372657 Section B
// Janpreet Singh N01361405 Section B
// Meet Gajjar N01391319 Section B


public class Preference extends PreferenceActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting_screen);
    }
}
