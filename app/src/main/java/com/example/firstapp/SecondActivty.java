package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class SecondActivty extends AppCompatActivity {

    TextView name,email,mobile,lang,radio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activty);

        Bundle bundle = getIntent().getExtras();

        name = (TextView)findViewById(R.id.nameSpace);
        email = (TextView)findViewById(R.id.emailSpace);
        mobile = (TextView)findViewById(R.id.mobileSpace);
        lang = (TextView)findViewById(R.id.languages);
        radio = (TextView)findViewById(R.id.gender);

        assert bundle != null;
        String nameValue  = bundle.getString("name");
        String emailValue = bundle.getString("email");
        String mobileValue = bundle.getString("mobile");
        String check = bundle.getString("check");
        String radiotxt = bundle.getString("radio");

        String temp = "Gender : " + radiotxt ;

        name.setText(nameValue);
        email.setText(emailValue);
        mobile.setText(mobileValue);
        lang.setText(check);
        radio.setText(temp);



    }


}
