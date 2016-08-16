package xyz.johntsai.one.api;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import xyz.johntsai.one.entity.BaseDataEntity;
import xyz.johntsai.one.entity.BaseEntity;
import xyz.johntsai.one.entity.Hp;
import xyz.johntsai.one.entity.Music;
import xyz.johntsai.one.entity.Read;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/7/13.
 * API
 */
public interface OneService {

    @GET("api/hp/idlist/0")
    Observable<BaseDataEntity<List<String>>> hpIdList();

    @GET("api/hp/detail/{id}")
    Observable<BaseDataEntity<Hp>> getHpDetail(@Path("id") String hpId);

    @GET("api/search/music/{content}")
    Observable<BaseDataEntity<List<Music>>> searchMusic(@Path("content")String content);

    @GET("api/search/hp/{content}")
    Observable<BaseDataEntity<List<Hp>>> searchHp(@Path("content")String content);

    @GET("api/search/reading/{content}")
    Observable<BaseDataEntity<List<Read>>> searchReading(@Path("content")String content);

    @GET("api/search/author/{content}")
    Observable<BaseEntity> searchAuthor(@Path("content")String content);

    @GET("api/search/movie/{content}")
    Observable<BaseEntity> searchMovie(@Path("content")String content);

}
