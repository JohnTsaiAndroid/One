package xyz.johntsai.one.ui;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.schedulers.Schedulers;
import xyz.johntsai.one.R;
import xyz.johntsai.one.api.ApiFactory;
import xyz.johntsai.one.api.OneService;
import xyz.johntsai.one.entity.BaseDataEntity;
import xyz.johntsai.one.entity.Hp;
import xyz.johntsai.one.entity.Music;
import xyz.johntsai.one.entity.Read;
import xyz.johntsai.one.listhelper.SimpleModelAdapter;
import xyz.johntsai.one.listservice.SearchListService;
import xyz.johntsai.one.views.TitleBar;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/8/11.
 * 搜索Activity
 */
public class SearchActivity extends BaseActivity {

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

    private SparseArray<BaseDataEntity> mDataArray;

    @Override
    protected void initTitleBar(final TitleBar titleBar) {
        super.initTitleBar(titleBar);
        titleBar.setTitleMode(TitleBar.Mode.SEARCH);
        titleBar.setOnTitleClickListener(new TitleBar.OnTitleBarClickCompat() {
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
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    search(titleBar.getEditTextString());
                    return true;
                }
                return false;
            }
        });
    }

    private void search(CharSequence editTextString) {
        if (TextUtils.isEmpty(editTextString.toString().trim()))
            return;

        String searchStr = editTextString.toString();
        if (mSearchImage.getVisibility() != View.GONE)
            mSearchImage.setVisibility(View.GONE);
        if (mSearchResultLayout.getVisibility() != View.VISIBLE)
            mSearchResultLayout.setVisibility(View.VISIBLE);

        mLoadImage.setVisibility(View.VISIBLE);
        final AnimationDrawable animationDrawable = (AnimationDrawable) mLoadImage.getBackground();
        animationDrawable.start();

        OneService oneService = ApiFactory.create(OneService.class);

        Observable<BaseDataEntity<List<Hp>>> hpObservable
                = oneService.searchHp(searchStr);

        Observable<BaseDataEntity<List<Read>>> readObservable
                = oneService.searchReading(searchStr);

        Observable<BaseDataEntity<List<Music>>> musicObservable
                = oneService.searchMusic(searchStr);

        Observable.zip(hpObservable, readObservable,musicObservable, new Func3<BaseDataEntity<List<Hp>>, BaseDataEntity<List<Read>>,BaseDataEntity<List<Music>> ,SparseArray<BaseDataEntity>>() {
            @Override
            public SparseArray<BaseDataEntity> call(BaseDataEntity<List<Hp>> listBaseDataEntity, BaseDataEntity<List<Read>> listBaseDataEntity2,BaseDataEntity<List<Music>> listBaseDataEntity3) {
                SparseArray<BaseDataEntity> array = new SparseArray<>(5);
                array.put(0,listBaseDataEntity);
                array.put(1,listBaseDataEntity2);
                array.put(2,listBaseDataEntity3);
                return array;
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SparseArray<BaseDataEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(SparseArray<BaseDataEntity> baseDataEntitySparseArray) {
                mDataArray = baseDataEntitySparseArray;
                addList();
            }
        });
    }

    private void addList() {
        if (mAdapter.getList() != null) {
            mAdapter.clearList();
        }

        if(mDataArray==null)return;

        BaseDataEntity baseDataEntity = mDataArray.get(mCurrentIndex);

        switch (mCurrentIndex) {
            case 0:
                if (baseDataEntity != null)
                    mAdapter.addList(SearchListService.getHpList(baseDataEntity));
                break;
            case 1:
                if (baseDataEntity != null) {
                    mAdapter.addList(SearchListService.getReadList(baseDataEntity));
                }
                break;
            case 2:
                if(baseDataEntity!=null){
                    mAdapter.addList(SearchListService.getMusicList(baseDataEntity));
                }
                break;
            default:
                break;
        }
        mLoadImage.setVisibility(View.GONE);
        mAdapter.notifyDataSetChanged();
        if(mListView.getFirstVisiblePosition()!=0){
            mListView.setSelection(0);
        }
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

    private class TextClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            setSelectText(v);
        }
    }

    private void setSelectText(View v) {
        switch (mCurrentIndex) {
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
        switch (v.getId()) {
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
        addList();
    }
}
