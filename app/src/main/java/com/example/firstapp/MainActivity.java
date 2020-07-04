package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    EditText name,email,mobile;
    CheckBox english,tamil;
    RadioGroup radioGroup;
    RadioButton radio;
    String validateEmail;

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.backButton);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById((R.id.email));
        mobile = (EditText) findViewById(R.id.moblie);
        english = (CheckBox)findViewById(R.id.english);
        tamil =(CheckBox) findViewById(R.id.tamil);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);

        validateEmail = email.getText().toString();

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(isValidEmail(validateEmail)){
                    String temp = "entered valid address";
                    email.setText(temp);
                }

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String checkValue="Languages selected : ";

                if(english.isChecked()){
                    checkValue = checkValue + "English ";
                }
                if(tamil.isChecked()){
                    if(english.isChecked()){
                        checkValue = checkValue + " , ";
                    }
                    checkValue = checkValue + "Tamil" ;
                }


                int selectId = radioGroup.getCheckedRadioButtonId();
                radio = (RadioButton)findViewById(selectId);


                 String nameValue = name.getText().toString();
                 String emailValue = email.getText().toString();
                 String mobileValue = mobile.getText().toString();
                 String radiotxt = radio.getText().toString();

                Intent sencondActivity = new Intent(MainActivity.this, SecondActivty.class);

                Bundle bundle = new Bundle();

                bundle.putString("name",nameValue);
                bundle.putString("email",emailValue);
                bundle.putString("mobile",mobileValue);
                bundle.putString("check",checkValue);
                bundle.putString("radio",radiotxt);

                sencondActivity.putExtras(bundle);

                name.getText().clear();
                email.getText().clear();
                mobile.getText().clear();
                english.setChecked(false);
                tamil.setChecked(false);
                radioGroup.clearCheck();

                startActivity(sencondActivity);



            }
        });




    }
}