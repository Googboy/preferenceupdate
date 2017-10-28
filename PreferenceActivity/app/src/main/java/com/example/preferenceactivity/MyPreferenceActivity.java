package com.example.preferenceactivity;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.widget.Toast;

/**
 * Created by 潘硕 on 2017/10/28.
 */

public class MyPreferenceActivity extends PreferenceActivity {

    PreferenceManager manager;
    CheckBoxPreference checkBoxPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.mypreference);

        manager = getPreferenceManager();
        checkBoxPreference = (CheckBoxPreference) manager.findPreference("checkbox");
        Toast.makeText(getApplicationContext(),"当前的状态为:"+checkBoxPreference.isChecked(),Toast.LENGTH_SHORT).show();
    }
}
