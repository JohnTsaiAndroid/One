package xyz.johntsai.one.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.johntsai.one.utils.Constant;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/7/19.
 * TODO
 */
public class ApiFactory {

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder().baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

    public static <S> S create(Class<S> serviceClazz){
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClazz);
    }

}
