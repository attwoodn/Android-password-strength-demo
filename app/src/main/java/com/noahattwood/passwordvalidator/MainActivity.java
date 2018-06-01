package com.noahattwood.passwordvalidator;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Validator passwordValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        passwordValidator = new Validator();
    }

    public void validatePassword(View view){
        EditText passwordTextField = findViewById(R.id.passwordTextField);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        TextView passwordStrengthTextField = findViewById(R.id.strengthTextField);

        String password = passwordTextField.getText().toString();
        Validator.PasswordStrength passwordStrength = passwordValidator.validate(password);

        passwordStrengthTextField.setText(passwordStrength.toString());

        progressBar.setProgress(passwordStrength.getStrengthPercentage());


    }
}
