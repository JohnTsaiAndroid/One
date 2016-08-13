package xyz.johntsai.one.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.johntsai.one.R;
import xyz.johntsai.one.utils.ToastUtils;

public class MainActivity extends AppCompatActivity {

    View tabMain,tabRead,tabMusic,tabMovie;

    @BindView(android.R.id.tabhost)
    FragmentTabHost mTabHost;

    public static final String STRING_TAG_MAIN = "main";
    public static final String STRING_TAG_MUSIC = "music";
    public static final String STRING_TAG_MOVIE = "movie";
    public static final String STRING_TAG_READ= "read";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        tabMain = View.inflate(this,R.layout.tab_main,null);
        tabRead = View.inflate(this,R.layout.tab_read,null);
        tabMusic = View.inflate(this,R.layout.tab_music,null);
        tabMovie = View.inflate(this,R.layout.tab_movie,null);

        mTabHost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);
        mTabHost.addTab(mTabHost.newTabSpec(STRING_TAG_MAIN).setIndicator(tabMain),TabMainFragment.class,null);
        mTabHost.addTab(mTabHost.newTabSpec(STRING_TAG_READ).setIndicator(tabRead),TabReadFragment.class,null);
        mTabHost.addTab(mTabHost.newTabSpec(STRING_TAG_MUSIC).setIndicator(tabMusic),TabMusicFragment.class,null);
        mTabHost.addTab(mTabHost.newTabSpec(STRING_TAG_MOVIE).setIndicator(tabMovie),TabMovieFragment.class,null);

        tabMain.setOnClickListener(onClickListener);
        tabMovie.setOnClickListener(onClickListener);
        tabMusic.setOnClickListener(onClickListener);
        tabRead.setOnClickListener(onClickListener);

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
               if(v.equals(tabMain)){
                   setTitleBar(v);
                   tabClick(v,STRING_TAG_MAIN);
               }else if(v.equals(tabRead)){
                   setTitleBar(v);
                   tabClick(v,STRING_TAG_READ);
               } else if(v.equals(tabMovie)){
                   setTitleBar(v);
                   tabClick(v,STRING_TAG_MOVIE);
               }else if(v.equals(tabMusic)){
                   setTitleBar(v);
                   tabClick(v,STRING_TAG_MUSIC);
               }
        }
    };

    private void tabClick(View v, String string) {
        if(mTabHost.getCurrentTabTag().equals(string)){
            //TODO
        }else{
            if(!isFinishing())
                mTabHost.setCurrentTabByTag(string);
        }
    }

    private void setTitleBar(View v) {

    }

    private long beforeTime = 0L;

    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis()-beforeTime<1000L) {
            super.onBackPressed();
        }else{
            beforeTime = System.currentTimeMillis();
            ToastUtils.showLong(this,"再按一次退出一个");
        }
    }
}
