package com.vodnal.mitra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.Preference.OnPreferenceChangeListener;
import androidx.preference.PreferenceManager;

import com.vodnal.mitra.R;
import com.vodnal.mitra.MainActivity;

public class SettingActivity extends AppCompatActivity {
    //private SettingViewModel settingViewModel;
   // private static SharedPrefManager userManager = SharedPrefManager.getInstance(get);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.setting_activity);
        // Button buttonSettings = findViewById(R.id.to);
        SettingFragment settingFragment = new SettingFragment();
        //Error: set adapter on null obj
       getSupportFragmentManager().beginTransaction().replace(R.id.setting_view,settingFragment).commit();

       /* buttonSettings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                Intent goToSettings = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(goToSettings);
            }
        });*/

    }
    private static OnPreferenceChangeListener listener = new OnPreferenceChangeListener() {



        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
            String stringValue = newValue.toString();
            if (preference instanceof EditTextPreference){
                //EditTextPreference editTextPreference = (EditTextPreference) preference;
                preference.setSummary(stringValue);
               // userManager.getUser().setEmail(stringValue);

            }
            return false;
        }
    };
}
