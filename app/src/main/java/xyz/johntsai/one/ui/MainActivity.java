package xyz.johntsai.one.ui;

import android.graphics.Color;
import android.os.Bundle;

import xyz.johntsai.one.R;
import xyz.johntsai.one.views.TitleBar;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initTitleBar(TitleBar titleBar) {
        super.initTitleBar(titleBar);
        titleBar.setTitleText("ONE");
        titleBar.setTitleBarBackgroundColor(Color.WHITE);
    }
}
