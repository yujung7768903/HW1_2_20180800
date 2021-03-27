package com.example.hw1_2_20180800;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText urlEditText;
    Button showStringButton;
    Button openpageButton;
    ImageView radioSelectImage;
    RadioGroup qrRadioGroup;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urlEditText = (EditText) findViewById(R.id.url_edit_text);
        showStringButton = (Button) findViewById(R.id.showstring_button);
        openpageButton = (Button) findViewById(R.id.openpage_button);
        radioSelectImage = (ImageView) findViewById(R.id.radioimg_image_view);
        qrRadioGroup = (RadioGroup) findViewById(R.id.qr_radio_group);

        showStringButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String showString = urlEditText.getText().toString();
                Toast.makeText(MainActivity.this, showString, Toast.LENGTH_SHORT).show();
            }
        });

        openpageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String openUrl = urlEditText.getText().toString();
                Intent nintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+openUrl));
                startActivity(nintent);
            }
        });

        qrRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.q_radio_button) {
                    radioSelectImage.setImageResource(R.drawable.q);
                }
                else {
                    radioSelectImage.setImageResource(R.drawable.r);
                }
            }
        });
    }
}