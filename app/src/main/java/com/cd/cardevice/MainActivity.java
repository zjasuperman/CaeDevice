package com.cd.cardevice;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
/**
 * @Author: ZhuangJie
 * @Date: 2019/3/20 13:47
 * @Desc:
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean isPlay;
    private ImageView mIvPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideStatusBar();
        hideBottomUIMenu();
        mIvPlay = findViewById(R.id.iv_play);
        mIvPlay.setOnClickListener(this);


    }

    public void hideStatusBar(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


    protected void hideBottomUIMenu() {
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_play:
                if (!isPlay){
                    //播放
                    mIvPlay.setImageDrawable(ContextCompat.getDrawable(MainActivity.this,R.mipmap.more_click));
                }else {
                    //暂停
                    mIvPlay.setImageDrawable(ContextCompat.getDrawable(MainActivity.this,R.mipmap.pause));
                }
                isPlay = !isPlay;

                break;
        }
    }
}
