package com.vodnal.mitra;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import com.vodnal.mitra.R;
public class SettingFragment extends PreferenceFragmentCompat{
    protected EditTextPreference mEmail;
    protected EditTextPreference mPassword;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

        setPreferencesFromResource(R.xml.preferences, rootKey);
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
//        mEmail = getPreferenceManager().findPreference("email_preference");
//        mPassword = getPreferenceManager().findPreference("password_preference");
//
//        return inflater.inflate(R.layout.setting_activity, container, false);
//    }


}
