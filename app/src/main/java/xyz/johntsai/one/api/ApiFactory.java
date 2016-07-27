package xyz.johntsai.one.api;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.johntsai.one.utils.Constant;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/7/19.
 */
public class ApiFactory {

    private static Retrofit retrofit;

    public static <T> T createRetrofitApi(Class<T> clazz){
        if(retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL)
                    .client(new OkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return retrofit.create(clazz);
    }
}
