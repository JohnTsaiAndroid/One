package xyz.johntsai.one.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import xyz.johntsai.one.R;
import xyz.johntsai.one.adapter.ViewPagerAdapter;
import xyz.johntsai.one.api.ApiFactory;
import xyz.johntsai.one.api.OneService;
import xyz.johntsai.one.entity.HpDetailEntity;
import xyz.johntsai.one.entity.HpIdListEntity;
import xyz.johntsai.one.views.TitleBar;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/8/9.
 */
public class TabMainFragment extends BaseFragment {

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    public static final String TAG = TabMainFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setContentView(R.layout.fragment_tab_main);
        View view =  super.onCreateView(inflater,container,savedInstanceState);
        mViewPager.setAdapter(new ViewPagerAdapter(getActivity()));
        return view;
    }

    @Override
    protected void initTitleBar(TitleBar titleBar) {
        super.initTitleBar(titleBar);
        titleBar.setTitleMode(TitleBar.Mode.MAIN);
    }
}
