package com.example.paquita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Regis extends AppCompatActivity {
      EditText nomed,aped,used,passed,emailed;
      Button registrao;
      daoClass dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);
        nomed=findViewById(R.id.edit1);
        aped=findViewById(R.id.edit2);
        used=findViewById(R.id.edit3);
        passed=findViewById(R.id.edit4);
        emailed=findViewById(R.id.edit5);
        registrao=findViewById(R.id.registrado);
        dao=new daoClass(this);
        registrao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario u=new Usuario();
                //recupera los campos llenados por el usuario y los establece como atributos del usuario
                u.setNombre(nomed.getText().toString());
                u.setApellidos(aped.getText().toString());
                u.setUsuario(used.getText().toString());
                u.setPassword(passed.getText().toString());
                u.setEmail(emailed.getText().toString());
                if(!u.isNull()){
                    Toast.makeText(Regis.this,R.string.camp, Toast.LENGTH_SHORT).show();
                }else if(dao.agregarUsuario(u)){
                    //si el nuevo usuario se registro correctamente en la base de datos se pasa ala siguiente Activity
                    Toast.makeText(Regis.this,R.string.uni, Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(Regis.this,Logis.class);
                    startActivity(intent);
                    finish();
                }else{
                    //mensaje que salta cuando hay un error o el usuario ya esta registrado ,limpia los campos.
                    Toast.makeText(Regis.this,R.string.YA, Toast.LENGTH_SHORT).show();
                    nomed.setText("");
                    aped.setText("");
                    used.setText("");
                    passed.setText("");
                    emailed.setText("");

                }
            }
        });
    }
}
