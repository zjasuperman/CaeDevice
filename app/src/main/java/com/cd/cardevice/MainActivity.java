package com.cd.cardevice;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * @Author: ZhuangJie
 * @Date: 2019/3/20 13:47
 * @Desc:
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvPlay;
    private static final int PLAY_STATE = 1;
    private static final int PAUSE_STATE = 0;
    private int music_state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideStatusBar();
        hideBottomUIMenu();
        mIvPlay = findViewById(R.id.iv_play);
        mIvPlay.setOnClickListener(this);

        mIvPlay.getDrawable().setLevel(music_state == PLAY_STATE ? PLAY_STATE : PAUSE_STATE);

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
        switch (music_state){
            case PLAY_STATE:
                music_state = PAUSE_STATE;
                break;
            case PAUSE_STATE:
                music_state = PLAY_STATE;
                break;
        }
        mIvPlay.getDrawable().setLevel(music_state);
    }
}
