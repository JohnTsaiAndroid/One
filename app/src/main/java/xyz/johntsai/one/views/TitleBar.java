package xyz.johntsai.one.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import xyz.johntsai.one.R;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/7/27.
 * 标题栏
 */
public class TitleBar extends RelativeLayout{

    private Context mContext;

    LinearLayout mLeftBtn;
    LinearLayout mRightBtn;
    EditText mSearchEditText;
    TextView mTitleText;
    RelativeLayout mTitleBarLayout;
    ImageView mTitleImage;
    ImageView mLeftImage,mRightImage;


    private Mode mTitleMode = Mode.NORMAL;

    public enum Mode{
        NORMAL,SEARCH,MAIN
    }

    public TitleBar(Context context){
        this(context,null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;

        mTitleBarLayout = (RelativeLayout) inflate(context, R.layout.layout_titlebar,this);
        mLeftBtn = (LinearLayout) mTitleBarLayout.findViewById(R.id.layoutLeft);
        mRightBtn = (LinearLayout) mTitleBarLayout.findViewById(R.id.layoutRight);
        mSearchEditText = (EditText) mTitleBarLayout.findViewById(R.id.editSearch);
        mTitleText = (TextView) mTitleBarLayout.findViewById(R.id.tvTitle);
        mTitleImage = (ImageView) mTitleBarLayout.findViewById(R.id.ivTitle);
        mLeftImage = (ImageView) mTitleBarLayout.findViewById(R.id.imageLeft);
        mRightImage = (ImageView) mTitleBarLayout.findViewById(R.id.imageRight);

        mTitleBarLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnTitleClickListener!=null){
                    mOnTitleClickListener.onTitleBarClick(v);
                }
            }
        });

        mLeftBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnTitleClickListener!=null){
                    mOnTitleClickListener.onLeftButtonClick(v);
                }
            }
        });

        mRightBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnTitleClickListener!=null){
                    mOnTitleClickListener.onRightButtonClick(v);
                }
            }
        });

        if(mTextWatcher!=null)
           mSearchEditText.addTextChangedListener(mTextWatcher);
    }

    private TextWatcher mTextWatcher;

    public void setEditTextWatcher(TextWatcher textWatcher){
        mTextWatcher = textWatcher;
    }

    public void setLeftBtnDrawable(Drawable drawable){
        mLeftImage.setImageDrawable(drawable);
    }

    public void setLeftBtnDrawable(int resId){
        setLeftBtnDrawable(ContextCompat.getDrawable(mContext,resId));
    }

    public void setRightBtnDrawable(int resId){
        setRightBtnDrawable(ContextCompat.getDrawable(mContext,resId));
    }

    public void setTitleImageDrawable(Drawable drawable){
        mTitleImage.setImageDrawable(drawable);
    }

    public void setTitleImageDrawable(int resId){
        setTitleImageDrawable(ContextCompat.getDrawable(mContext,resId));
    }

    public void setTitleText(String text){
        mTitleText.setVisibility(VISIBLE);
        mTitleText.setText(text);
    }

    public void setTitleText(int stringRes){
        setTitleText(mContext.getString(stringRes));
    }

    public void setRightBtnDrawable(Drawable drawable){
        mRightImage.setImageDrawable(drawable);
    }

    public void setTitleBarBackground(int resId){
        mTitleBarLayout.setBackgroundResource(resId);
    }

    public void setTitleBarBackgroundColor(int color){
        mTitleBarLayout.setBackgroundColor(color);
    }

    public CharSequence getEditTextString(){
        return mSearchEditText.getText().toString();
    }

    public EditText getSearchEdittext(){
        return mSearchEditText;
    }

    public Mode getTitleMode(){
        return mTitleMode;
    }

    public void setTitleMode(Mode mode){
        mTitleMode = mode;
        mLeftBtn.setVisibility(VISIBLE);
        mRightBtn.setVisibility(VISIBLE);
        if(mode==Mode.NORMAL){
            mTitleBarLayout.setBackgroundColor(Color.WHITE);
            mTitleText.setVisibility(VISIBLE);
            mSearchEditText.setVisibility(GONE);
            mTitleImage.setVisibility(GONE);
        }else if(mode==Mode.SEARCH){
            mTitleText.setVisibility(GONE);
            mSearchEditText.setVisibility(VISIBLE);
            mTitleImage.setVisibility(GONE);
            mLeftImage.setImageResource(R.drawable.com_bt_return);
            mRightImage.setImageResource(R.drawable.search);
            mTitleBarLayout.setBackgroundColor(Color.parseColor("#fff3f3f3"));
        }else if(mode==Mode.MAIN){
            mTitleBarLayout.setBackgroundColor(Color.WHITE);
            mTitleText.setVisibility(GONE);
            mSearchEditText.setVisibility(GONE);
            mTitleImage.setVisibility(VISIBLE);
        }
    }


    public interface OnTitleBarClickListener{
        void onLeftButtonClick(View view);

        void onRightButtonClick(View view);

        void onTitleBarClick(View view);
    }

    private OnTitleBarClickListener mOnTitleClickListener;

    public void setOnTitleClickListener(OnTitleBarClickListener listener){
        mOnTitleClickListener = listener;
    }

    public void setOnTitleClickListener(OnTitleBarClickCompat onTitleBarClickCompat){
        mOnTitleClickListener = onTitleBarClickCompat;
    }

    public static class OnTitleBarClickCompat implements OnTitleBarClickListener{

        @Override
        public void onLeftButtonClick(View view) {

        }

        @Override
        public void onRightButtonClick(View view) {

        }

        @Override
        public void onTitleBarClick(View view) {

        }
    }

}
