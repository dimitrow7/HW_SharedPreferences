package net.northwestvision.storagedemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    TextView txtSignup;
    EditText newUserField;
    EditText newPassField;
    EditText rePassField;
    Button createBtn;
    Button cancelBtn;
    SharedPreferences pref;
    SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        txtSignup = (TextView) findViewById(R.id.txt_signup);
        newUserField = (EditText) findViewById(R.id.new_user_field);
        newPassField = (EditText) findViewById(R.id.new_pass_field);
        rePassField = (EditText) findViewById(R.id.re_pass_field);
        createBtn = (Button) findViewById(R.id.crete_btn);
        cancelBtn = (Button) findViewById(R.id.cancel_btn);
        pref = getSharedPreferences("MyPrefs", this.MODE_PRIVATE);
        edit = pref.edit();

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newPassField.getText().toString().equals(rePassField.getText().toString())) {
                    edit.putString("username", newUserField.getText().toString()).apply();
                    edit.putString("password", newPassField.getText().toString()).apply();
                    Toast.makeText(SignUpActivity.this, "The user " + newUserField.getText().toString() + " is created", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignUpActivity.this, "Password not match", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
