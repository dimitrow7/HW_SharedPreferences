package net.northwestvision.storagedemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    TextView txtHello;
    Button btnClick;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = this.getPreferences(MODE_PRIVATE);
        sp.edit().putInt("number", 14).apply();

        txtHello = (TextView) findViewById(R.id.txt_hello);
        btnClick = (Button) findViewById(R.id.btn_click);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            //pisane vyv vremenna SharedPrem pamet
            public void onClick(View v) {
                txtHello.setText(String.valueOf(sp.getInt("number", -1)));
                sp.edit().remove("number").apply();

                //pisane vyv fail (internal storage)
                try {
                    FileOutputStream fos = openFileOutput("MyFile", Context.MODE_PRIVATE);
                    fos.write(sp.getInt("number", -1));
                    fos.close();
                }  catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    }
