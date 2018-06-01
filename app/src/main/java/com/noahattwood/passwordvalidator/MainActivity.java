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

        // Display the password strength's string representation
        passwordStrengthTextField.setText(passwordStrength.toString());

        progressBar.setProgress(passwordStrength.getStrengthPercentage());

        // Change color of the progress bar based on the strength of the password.
        // This line of code was influenced by the following answer on stack overflow: https://stackoverflow.com/a/15809803
        progressBar.getProgressDrawable().setColorFilter(passwordStrength.colour, PorterDuff.Mode.MULTIPLY);
    }
}
