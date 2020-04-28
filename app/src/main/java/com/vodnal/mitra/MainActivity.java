package com.vodnal.mitra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.vodnal.mitra.R;
import com.vodnal.mitra.SettingActivity;

public class MainActivity extends AppCompatActivity {
    SharedPrefManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        manager = SharedPrefManager.getInstance(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Button settingButton = findViewById(R.id.toSetting);
        settingButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    System.out.println("Button Clicked");
                    Intent confirmSettingChanges = new Intent(getApplicationContext(), SettingActivity.class);
                    startActivity(confirmSettingChanges);
            }
        });
    }
}
