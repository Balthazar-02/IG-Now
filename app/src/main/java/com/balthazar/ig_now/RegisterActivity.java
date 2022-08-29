package com.balthazar.ig_now;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterActivity extends AppCompatActivity {

    public static final String TAG = "RegisterActivity";
    private EditText rgUsername;
    private EditText rgPassword;
    private EditText confirmPassword;
    private Button btnRegister;
    TextView haveAccount;

    String username;
    String password;
    String email;

    ParseUser user = new ParseUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        rgUsername = findViewById(R.id.rgUsername);
        rgPassword = findViewById(R.id.rgPassword);
        confirmPassword = findViewById(R.id.email);
        btnRegister = findViewById(R.id.btnRegister);
        haveAccount = findViewById(R.id.haveAccount);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        haveAccount.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));

    }
});
btnRegister.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Log.i(TAG, "onClick register button");
         username = rgUsername.getText().toString();
         password = rgPassword.getText().toString();
         email = confirmPassword.getText().toString();

        registerUser(username,password,email);
    }
});
    }

    public void registerUser(String username, String password, String email) {
        if( username.isEmpty()){
            Toast.makeText(RegisterActivity.this, " the username is required !!", Toast.LENGTH_SHORT).show();
            return;
        } else if(password.isEmpty()){
            Toast.makeText(RegisterActivity.this, "the password is required !!", Toast.LENGTH_SHORT).show();

        }else {
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);

            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if (e != null) {
                        Log.e(TAG, "Issue with SignUp", e);
                        Toast.makeText(RegisterActivity.this, " whe have an issue with SignUp, check again !!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    goLoginActivity();
                }
            });
        }


    }

    private void goLoginActivity() {
        Intent i = new Intent(this,     LoginActivity.class);
        startActivity(i);
        finish();
    }
    }
