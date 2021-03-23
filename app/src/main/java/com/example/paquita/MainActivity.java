package com.example.paquita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     Button login,registro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.b1);
        registro=findViewById(R.id.b2);
        //botones a la escucha determinan siguiente actividad mediante el objeto Intent
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,R.string.bi,Toast.LENGTH_SHORT).show();
                Intent i =new Intent(MainActivity.this,Logis.class);
                startActivity(i);
            }
        });
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,R.string.bi,Toast.LENGTH_SHORT).show();
                Intent i =new Intent(MainActivity.this,Regis.class);
                startActivity(i);
            }
        });
    }
}
