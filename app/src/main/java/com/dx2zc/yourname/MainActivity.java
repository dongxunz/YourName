package com.dx2zc.yourname;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import info.hellovass.snowingview.widgets.SnowingView;

public class MainActivity extends AppCompatActivity {

    private SnowingView snowingView;
    private MediaPlayer music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        snowingView = (SnowingView) findViewById(R.id.snowing_view);
        //开始下雪
        snowingView.startFall();

        //播放音乐
        music = new MediaPlayer();
        music = MediaPlayer.create(this,R.raw.qianqianshishi);
        try {
            if (music != null){
                music.stop();
            }
            music.prepare();
            music.start();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1,1,0,"关于");
        menu.add(1,2,1,"退出");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case 0:
                //TODO
                break;
            case 1:
                finish();break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //停止下雪
        snowingView.stopFall();
        //退出时关闭音乐
        try {
            if (music != null){
                music.stop();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
