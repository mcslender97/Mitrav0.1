package com.vodnal.mitra;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.Preference.OnPreferenceChangeListener;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

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
    private static void  setSummaryValue(Preference preference){
        preference.setOnPreferenceChangeListener(listener);
        listener.onPreferenceChange(preference,PreferenceManager.getDefaultSharedPreferences(preference.getContext()).getString(preference.getKey(),""));
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
            else if (preference instanceof ListPreference){
                ListPreference listPreference = (ListPreference) preference;
                int index = listPreference.findIndexOfValue(stringValue);
                preference.setSummary(index > 0 ? listPreference.getEntries()[index]:null);
            }
            return false;
        }
    };

    public static class SettingFragment extends PreferenceFragmentCompat {


        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            //super.onCreate(savedInstanceState);
            setPreferencesFromResource(R.xml.preferences,rootKey);

        }

    //    @Override
    //    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
    //        mEmail = getPreferenceManager().findPreference("email_preference");
    //        mPassword = getPreferenceManager().findPreference("password_preference");
    //
    //        return inflater.inflate(R.layout.setting_activity, container, false);
    //    }


    }
}
