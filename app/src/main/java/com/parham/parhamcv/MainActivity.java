package com.parham.parhamcv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private Button callButton;
    private Button emailButton;
    private TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch themeSwitch = findViewById(R.id.switch_theme);
        TextView themeTextView = findViewById(R.id.theme_textView);

        themeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                themeTextView.setText("Dark Mode");
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                themeTextView.setText("Light Mode");
            }
        });

        callButton = findViewById(R.id.call_button);
        emailButton = findViewById(R.id.email_button);
        textView3 = findViewById(R.id.textView3);

        textView3.setText(readJson());

        callButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1234567890"));
            startActivity(intent);
        });

        emailButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:example@example.com"));
            startActivity(intent);
        });

        Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show();
    }

    private String readJson() {
        StringBuilder returnString = new StringBuilder();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open("aboutme.txt")));

            String mLine;
            while ((mLine = reader.readLine()) != null) {
                returnString.append(mLine);
            }
        } catch (IOException e) {
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
        }
        return returnString.toString();
    }
}
