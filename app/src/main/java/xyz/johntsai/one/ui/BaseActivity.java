package xyz.johntsai.one.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import xyz.johntsai.one.views.TitleBar;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/7/27.
 */
public class BaseActivity extends AppCompatActivity {

    protected TitleBar mTitleBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            mTitleBar = new TitleBar(this);
            actionBar.setElevation(0f);
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setDisplayShowCustomEnabled(true);
            ActionBar.LayoutParams layout = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, android.app.ActionBar.LayoutParams.MATCH_PARENT);
            actionBar.setCustomView(mTitleBar,layout);
            initTitleBar(mTitleBar);
        }
    }

    protected void initTitleBar(TitleBar titleBar){

    }
}
