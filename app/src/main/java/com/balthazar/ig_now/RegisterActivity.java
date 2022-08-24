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

public class RegisterActivity extends AppCompatActivity {

    public static final String TAG = "RegisterActivity";
    private EditText rgUsername;
    private EditText rgPassword;
    private EditText confirmPassword;
    private Button btnRegister;
    TextView haveAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        rgUsername = findViewById(R.id.rgUsername);
        rgPassword = findViewById(R.id.rgPassword);
        confirmPassword = findViewById(R.id.confirmPassword);
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
        String username = rgUsername.getText().toString();
        String password = rgPassword.getText().toString();
        String confirmpassword = confirmPassword.getText().toString();
        registerUser(username,password,confirmpassword);
    }
});
    }

    private void registerUser(String username, String password, String confirmpassword) {
        Log.i(TAG, "Attempting to register user" + username);
    }
}