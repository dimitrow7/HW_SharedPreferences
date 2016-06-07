package net.northwestvision.storagedemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static net.northwestvision.storagedemo.R.layout.activity_login;

public class LoginActivity extends AppCompatActivity {
    TextView txtHello;
    EditText userField;
    EditText passwField;
    Button loginBtn;
    Button signupBtn;
    SharedPreferences sp;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_login);
        txtHello = (TextView) findViewById(R.id.txt_login);
        userField = (EditText) findViewById(R.id.user_field);
        passwField = (EditText) findViewById(R.id.pass_field);
        loginBtn = (Button) findViewById(R.id.login_btn);
        signupBtn = (Button) findViewById(R.id.signup_btn);
        sp = this.getPreferences(MODE_PRIVATE);
        sp.edit().putString("username", "user").apply();
        sp.edit().putString("password","123456").apply();

        pref = getSharedPreferences("MyPrefs", LoginActivity.MODE_PRIVATE);

        SharedPreferences.Editor edit = pref.edit();
        edit.putString("username", "a").apply();
        edit.putString("password", "123").apply();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (userField.getText().toString().equals(String.valueOf(pref.getString("username", "There is no active user")))
                    && passwField.getText().toString().equals(String.valueOf(pref.getString("password", "There is no active user")))) {
                Intent intent = new Intent(LoginActivity.this, HelloActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(LoginActivity.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
            }
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent2);
            }
        });
    }
}
