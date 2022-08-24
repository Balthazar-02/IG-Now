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

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {
    public  static final String TAG = "LoginActivity";
    private EditText Username;
    private EditText Password;
    private Button btnLogin;
    TextView createnewAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (ParseUser.getCurrentUser() != null) {
            goMainActivity();
        }

        Username = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);
        btnLogin = findViewById(R.id.btnLogin);
        createnewAccount = findViewById(R.id.createNA);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        createnewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick login button");
                String username = Username.getText().toString();
                String password = Password.getText().toString();
                loginUser(username,password);
            }
        });
    }

    private void loginUser(String username, String password) {
        Log.i(TAG, "Attempting to login user" + username);
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    // TODO : better error handling
                    Log.e(TAG, "Issue with the login",e);
                    Toast.makeText(LoginActivity.this, "issue with the username or the password", Toast.LENGTH_SHORT).show();
                    return;
                }
                // TODO: navigate to the main activity if the user as signed in properly
                goMainActivity();
                Toast.makeText(LoginActivity.this, "Success !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goMainActivity() {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}