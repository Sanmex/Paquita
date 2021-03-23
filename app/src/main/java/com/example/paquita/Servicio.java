package com.example.paquita;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Servicio extends Service {

    private MediaPlayer player;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,R.string.can,Toast.LENGTH_SHORT).show();
        //inicia el servicio de audio
        if(player!=null&&player.isPlaying()){
            player.stop();
        }
        player=MediaPlayer.create(this,R.raw.challo);
        player.setLooping(true);
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        //detiene los servicios de audio
        Toast.makeText(this,R.string.vu,Toast.LENGTH_SHORT).show();
        if(player!=null){
            player.release();
        }
        super.onDestroy();
    }
}
