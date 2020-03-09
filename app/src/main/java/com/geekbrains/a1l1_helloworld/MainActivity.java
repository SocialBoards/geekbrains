package com.geekbrains.a1l1_helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Switch beginnerSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setColorOfTextView();
        setOnSwitchChanged();
    }

    private void initViews() {
        textView = findViewById(R.id.helloTextView);

        int orientation = getResources().getConfiguration().orientation;
        if (orientation != Configuration.ORIENTATION_LANDSCAPE) {
            beginnerSwitch = findViewById(R.id.switch1);
        }

    }

    private void setColorOfTextView() {
        //String appName = getString(R.string.app_name);
        textView.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
    }

    private void setOnSwitchChanged() {
        int orientation = getResources().getConfiguration().orientation;
        if (orientation != Configuration.ORIENTATION_LANDSCAPE) {
            beginnerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    String text;
                    if(isChecked) {
                        text = getString(R.string.im_beginner);
                    } else {
                        text = getString(R.string.im_experienced);
                    }

                    textView.setText(text);
                }
            });
        }
    }
}
