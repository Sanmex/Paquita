package com.example.paquita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Final extends AppCompatActivity {
      Button start,stop;
     TextView tv,tv2,tv3,tv4,tv5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        recibirdatos();
        BroadcastReceiver receiver=new Broadcast();
        IntentFilter intentFilter=new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        this.registerReceiver(receiver,intentFilter);
        start=(Button)findViewById(R.id.play);
        stop=(Button)findViewById(R.id.stop);
        //botones a la escucha para poner en marcha o detener el evento de audio
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(v);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(v);
            }
        });


    }
    public void startService(View view){
        Intent intent=new Intent(this,Servicio.class);
        startService(intent);
    }
    public void stopService(View view){
        Intent intent=new Intent(this,Servicio.class);
        stopService(intent);
    }
//metodo para recibir los datos con put.extra del usuario autentificado recibidos del anterior Activity

    private void recibirdatos() {
        Bundle extras=getIntent().getExtras();
        String d1=extras.getString("datos");
        String d2=extras.getString("datos2");
        String d3=extras.getString("datos3");
        String d4=extras.getString("datos4");
        String d5=extras.getString("datos5");

        tv=(TextView)findViewById(R.id.tv);
        tv.setText(d1);
        tv2=(TextView)findViewById(R.id.tv2);
        tv2.setText(d2);
        tv3=(TextView)findViewById(R.id.tv3);
        tv3.setText(d3);
        tv4=(TextView)findViewById(R.id.tv4);
        tv4.setText(d4);
        tv5=(TextView)findViewById(R.id.tv5);
        tv5.setText(d5);

    }

}
