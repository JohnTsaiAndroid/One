package xyz.johntsai.one.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;
import java.util.Set;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/7/27.
 * SharedPrefs Utils
 */
public class SharedPrefsUtils {
    private SharedPrefsUtils() {

    }

    private static final String DEFAULT_PREFS = "ONE_DEFAULT_PREFS";

    private static SharedPreferences getSharedPrefs(Context context, String prefName) {
        return context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
    }

    public static void put(Context context, String prefName, String key, Object value) {
        SharedPreferences sharedPrefs = getSharedPrefs(context, prefName);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        }else if(value instanceof Long){
            editor.putLong(key, (Long) value);
        }else if(value instanceof Set){
            if(((Set) value).add(""))
               editor.putStringSet(key, (Set<String>) value);
            else
                throw new IllegalArgumentException("Unsupported generics type of Set");
        }else{
            throw new IllegalArgumentException("Unsupported type of value:"+value.getClass().getSimpleName());
        }
        editor.apply();
    }

    public static Object get(Context context,String prefName,String key){
        SharedPreferences sharedPreferences = getSharedPrefs(context,prefName);
        Map<String, ?> all = sharedPreferences.getAll();
        if(all.containsKey(key)){
            return all.get(key);
        }else{
            return null;
        }
    }

    public static void put(Context context,String key,Object value){
        put(context,DEFAULT_PREFS,key,value);
    }

    public static Object get(Context context,String key){
        return get(context,DEFAULT_PREFS,key);
    }

    public static void clear(Context context,String prefName){
        SharedPreferences sharedPrefs = getSharedPrefs(context, prefName);
        sharedPrefs.edit().clear().apply();
    }

    public static void clear(Context context){
        clear(context,DEFAULT_PREFS);
    }
}
