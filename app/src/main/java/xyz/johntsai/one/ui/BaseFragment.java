package xyz.johntsai.one.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.johntsai.one.R;
import xyz.johntsai.one.views.TitleBar;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/8/8.
 */
public class BaseFragment extends Fragment {

    private TitleBar mTitleBar;

    private View mCacheView;//缓存Fragment的View

    private ViewGroup mViewContainer;

    private boolean mHasLoaded;//是否加载

    private boolean mShouldRefresh;//是否需要刷新

    private int mChildRes;

    private CacheViewReceiver mReceiver = new CacheViewReceiver();

    protected Context mContext;

    public static final String ACTION_DATA_NEED_REFRESH = "xyz.johntsai.one.broadcast.dataneedrefresh";

    public static final String ACTION_CLEAR_CACHE_VIEW = "xyz.johntsai.one.broadcast.cacheview";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        //注册广播
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_CLEAR_CACHE_VIEW);
        intentFilter.addAction(ACTION_DATA_NEED_REFRESH);
        LocalBroadcastManager.getInstance(mContext).registerReceiver(mReceiver,intentFilter);
        mCacheView = null;
        mHasLoaded = false;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mCacheView == null){
            View view = inflater.inflate(R.layout.fragment_base,container,false);
            mTitleBar = (TitleBar) view.findViewById(R.id.titleBar);
            mViewContainer = (ViewGroup) view.findViewById(R.id.container);
            View childView = LayoutInflater.from(mContext).inflate(mChildRes,mViewContainer,false);
            mViewContainer.addView(childView);
            mCacheView = view;
            initTitleBar(mTitleBar);
        }
        //防止多次加载
        ViewGroup parent = (ViewGroup) mCacheView.getParent();
        if(parent!=null){
            parent.removeView(mCacheView);
        }
        mShouldRefresh = true;
        return mCacheView;
    }

    protected void initTitleBar(TitleBar titleBar) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mShouldRefresh = false;
        mHasLoaded = false;
        LocalBroadcastManager.getInstance(mContext).unregisterReceiver(mReceiver);
    }

    protected void setContentView(int resId){
        mChildRes = resId;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(mCacheView!=null){
            mHasLoaded = true;
        }
    }

    private class CacheViewReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(action.equals(ACTION_CLEAR_CACHE_VIEW)){
                mCacheView = null;
                reload();
            }else if(action.equals(ACTION_DATA_NEED_REFRESH)){
                refreshData();
            }
        }
    }

    protected void refreshData() {

    }

    public void reload() {
        mHasLoaded = false;
    }

    public void clearCacheView(){
        mCacheView = null;
    }

    public boolean hasLoaded(){
        return mHasLoaded;
    }
}
