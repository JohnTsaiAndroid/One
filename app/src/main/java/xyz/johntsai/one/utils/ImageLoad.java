package xyz.johntsai.one.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/8/11.
 */
public class ImageLoad {

    private ImageLoad(){

    }

    public static void load(Context context, ImageView view,String url){
        Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.RESULT).into(view);
    }


}
