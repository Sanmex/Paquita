package com.example.paquita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Logis extends AppCompatActivity {
    EditText usulog,passlog;
    Button entrar;
    daoClass dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logis);
        usulog=findViewById(R.id.editlo1);
        passlog=findViewById(R.id.editlo2);
        entrar=findViewById(R.id.buttolog);
        dao=new daoClass(this);
        entrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
              String u=usulog.getText().toString();
              String p=passlog.getText().toString();
              if(u.equals("")&&p.equals("")){
                  Toast.makeText(Logis.this,R.string.camp, Toast.LENGTH_SHORT).show();
              }else if(dao.login(u,p)==1){
                  Usuario ux=dao.getUsuario(u,p);
                  Toast.makeText(Logis.this,R.string.us, Toast.LENGTH_SHORT).show();
                  Intent i=new Intent(Logis.this,Final.class);
                  i.putExtra("datos",ux.getNombre());
                  i.putExtra("datos2",ux.getApellidos());
                  i.putExtra("datos3",ux.getUsuario());
                  i.putExtra("datos4",ux.getPassword());
                  i.putExtra("datos5",ux.getEmail());
                  startActivity(i);
                  finish();
              }else{
                  Toast.makeText(Logis.this,R.string.uscon, Toast.LENGTH_SHORT).show();
                  usulog.setText("");
                  passlog.setText("");
              }
            }
        });
    }
}
