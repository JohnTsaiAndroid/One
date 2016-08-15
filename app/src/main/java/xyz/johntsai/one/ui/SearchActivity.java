package xyz.johntsai.one.ui;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import xyz.johntsai.one.R;
import xyz.johntsai.one.api.ApiFactory;
import xyz.johntsai.one.api.OneService;
import xyz.johntsai.one.entity.HpDetailListEntity;
import xyz.johntsai.one.listhelper.SimpleModelAdapter;
import xyz.johntsai.one.listservice.SearchListService;
import xyz.johntsai.one.views.TitleBar;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/8/11.
 * 搜索Activity
 */
public class SearchActivity extends BaseActivity{

    private static final String TAG = SearchActivity.class.getSimpleName();

    @BindView(R.id.searchImage)
    ImageView mSearchImage;

    @BindView(R.id.searchResultLayout)
    RelativeLayout mSearchResultLayout;

    @BindView(R.id.tvHp)
    TextView mTextHp;
    @BindView(R.id.tvRead)
    TextView mTextRead;
    @BindView(R.id.tvMusic)
    TextView mTextMusic;
    @BindView(R.id.tvMovie)
    TextView mTextMovie;
    @BindView(R.id.tvAuthor)
    TextView mTextAuthor;

    @BindView((R.id.searchListView))
    ListView mListView;

    @BindView(R.id.loadImage)
    ImageView mLoadImage;

    private int mCurrentIndex = 0;

    private SimpleModelAdapter mAdapter;

    @Override
    protected void initTitleBar(final TitleBar titleBar) {
        super.initTitleBar(titleBar);
        titleBar.setTitleMode(TitleBar.Mode.SEARCH);
        titleBar.setOnTitleClickListener(new TitleBar.OnTitleBarClickCompat(){
            @Override
            public void onLeftButtonClick(View view) {
                super.onLeftButtonClick(view);
                finish();
            }

            @Override
            public void onRightButtonClick(View view) {
                super.onRightButtonClick(view);
                search(titleBar.getEditTextString());
            }
        });
        titleBar.getSearchEdittext().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_GO||event.getKeyCode()==KeyEvent.KEYCODE_ENTER){
                    search(titleBar.getEditTextString());
                    return true;
                }
                return false;
            }
        });
    }

    private void search(CharSequence editTextString) {
        if(TextUtils.isEmpty(editTextString.toString().trim()))
            return;
        mLoadImage.setVisibility(View.VISIBLE);
        final AnimationDrawable animationDrawable = (AnimationDrawable) mLoadImage.getBackground();
        animationDrawable.start();
        Log.d(TAG,editTextString.toString());
        if(mSearchImage.getVisibility()!=View.GONE)
           mSearchImage.setVisibility(View.GONE);
        if(mSearchResultLayout.getVisibility()!=View.VISIBLE)
           mSearchResultLayout.setVisibility(View.VISIBLE);
        if(mAdapter.getList()!=null) {
            mAdapter.clearList();
        }
        OneService oneService = ApiFactory.create(OneService.class);

        oneService.searchHp(editTextString.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HpDetailListEntity>() {
                    @Override
                    public void onCompleted() {
                        mLoadImage.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(HpDetailListEntity hpDetailListEntity){
                        mAdapter.addList(SearchListService.getHpList(hpDetailListEntity));
                        mAdapter.notifyDataSetChanged();
                        if(mListView.getFirstVisiblePosition()!=0){
                            mListView.setSelection(0);
                        }
                    }
                });


    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ButterKnife.bind(this);

        mTextHp.setOnClickListener(new TextClickListener());
        mTextRead.setOnClickListener(new TextClickListener());
        mTextAuthor.setOnClickListener(new TextClickListener());
        mTextMovie.setOnClickListener(new TextClickListener());
        mTextMusic.setOnClickListener(new TextClickListener());
        mTextHp.setSelected(true);

        mAdapter = new SimpleModelAdapter(this, SearchListService.getFactory());
        mListView.setAdapter(mAdapter);

        mLoadImage.setBackgroundResource(R.drawable.loading_anim);
    }

    private class TextClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            setSelectText(v);
        }
    }

    private void setSelectText(View v) {
        switch (mCurrentIndex){
            case 0:
                mTextHp.setSelected(false);
                break;
            case 1:
                mTextRead.setSelected(false);
                break;
            case 2:
                mTextMusic.setSelected(false);
                break;
            case 3:
                mTextMovie.setSelected(false);
                break;
            case 4:
                mTextAuthor.setSelected(false);
        }
        switch (v.getId()){
            case R.id.tvHp:
                mCurrentIndex = 0;
                break;
            case R.id.tvRead:
                mCurrentIndex = 1;
                break;
            case R.id.tvMusic:
                mCurrentIndex = 2;
                break;
            case R.id.tvMovie:
                mCurrentIndex = 3;
                break;
            case R.id.tvAuthor:
                mCurrentIndex = 4;
                break;
        }
        v.setSelected(true);
    }
}
