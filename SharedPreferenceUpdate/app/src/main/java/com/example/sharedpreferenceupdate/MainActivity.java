package com.example.sharedpreferenceupdate;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    static final String KEY = "MyValue";
    private EditText et;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getPreferences(Activity.MODE_PRIVATE);
        editor = preferences.edit();

        et = findViewById(R.id.editText);
        findViewById(R.id.readBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String in = preferences.getString(KEY,"当前数值不存在");
                Toast.makeText(getApplicationContext(),in,Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.writeBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString(KEY,et.getText().toString());
                if (editor.commit()==true){
                    Toast.makeText(getApplicationContext(),"写入成功",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
