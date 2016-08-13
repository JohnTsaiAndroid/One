package xyz.johntsai.one.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/8/12.
 */
public class ToastUtils {
    private ToastUtils(){

    }

    public static void showLong(Context context,String text){
        Toast.makeText(context,text,Toast.LENGTH_LONG).show();
    }

    public static void showShort(Context context,String text){
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }
}
