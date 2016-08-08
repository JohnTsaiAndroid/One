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
import android.widget.RelativeLayout;
import android.widget.TextView;

import xyz.johntsai.one.R;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/7/27.
 * 标题栏
 */
public class TitleBar extends RelativeLayout{

    private Context mContext;

    ImageView mLeftBtn;
    ImageView mRightBtn;
    EditText mSearchEditText;
    TextView mTitleText;
    RelativeLayout mTitleBarLayout;

    private Mode mTitleMode = Mode.NORMAL;

    public enum Mode{
        NORMAL,SEARCH
    }

    public TitleBar(Context context){
        this(context,null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;

        mTitleBarLayout = (RelativeLayout) inflate(context, R.layout.layout_titlebar,this);
        mLeftBtn = (ImageView) mTitleBarLayout.findViewById(R.id.btnLeft);
        mRightBtn = (ImageView) mTitleBarLayout.findViewById(R.id.btnRight);
        mSearchEditText = (EditText) mTitleBarLayout.findViewById(R.id.editSearch);
        mTitleText = (TextView) mTitleBarLayout.findViewById(R.id.tvTitle);

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

        mSearchEditText.addTextChangedListener(mTextWatcher);
    }

    private TextWatcher mTextWatcher;

    public void setEditTextWatcher(TextWatcher textWatcher){
        mTextWatcher = textWatcher;
    }

    public void setLeftBtnDrawable(Drawable drawable){
        mLeftBtn.setImageDrawable(drawable);
    }

    public void setLeftBtnDrawable(int resId){
        setLeftBtnDrawable(ContextCompat.getDrawable(mContext,resId));
    }

    public void setRightBtnDrawable(int resId){
        setRightBtnDrawable(ContextCompat.getDrawable(mContext,resId));
    }

    public void setTitleText(String text){
        mTitleText.setVisibility(VISIBLE);
        mTitleText.setText(text);
    }

    public void setTitleText(int stringRes){
        setTitleText(mContext.getString(stringRes));
    }

    public void setRightBtnDrawable(Drawable drawable){
        mRightBtn.setImageDrawable(drawable);
    }

    public void setTitleBarBackground(int resId){
        mTitleBarLayout.setBackgroundResource(resId);
    }

    public void setTitleBarBackgroundColor(int color){
        mTitleBarLayout.setBackgroundColor(color);
    }


    public void setTitleMode(Mode mode){
        mTitleMode = mode;
        mLeftBtn.setVisibility(VISIBLE);
        mRightBtn.setVisibility(VISIBLE);
        if(mode==Mode.NORMAL){
            mTitleBarLayout.setBackgroundColor(Color.WHITE);
            mTitleText.setVisibility(VISIBLE);
            mSearchEditText.setVisibility(GONE);
        }else{
            mTitleBarLayout.setBackgroundColor(Color.GRAY);
            mTitleText.setVisibility(GONE);
            mSearchEditText.setVisibility(VISIBLE);
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
