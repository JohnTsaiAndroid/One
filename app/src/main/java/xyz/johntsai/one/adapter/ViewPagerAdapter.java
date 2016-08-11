package xyz.johntsai.one.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.johntsai.one.R;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/8/9.
 */
public class ViewPagerAdapter extends PagerAdapter{

    private Context mContext;

    public ViewPagerAdapter(Context context){
        mContext = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.view_hd_detail, container, false);
        container.addView(inflate);
        return inflate;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
      container.removeView((View) object);
    }
}
