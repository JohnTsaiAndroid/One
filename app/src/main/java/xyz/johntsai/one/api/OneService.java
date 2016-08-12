package xyz.johntsai.one.api;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import xyz.johntsai.one.entity.BaseEntity;
import xyz.johntsai.one.entity.HpDetailEntity;
import xyz.johntsai.one.entity.HpDetailListEntity;
import xyz.johntsai.one.entity.HpIdListEntity;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/7/13.
 * API
 */
public interface OneService {

    @GET("api/hp/idlist/0")
    Observable<HpIdListEntity> hpIdList();

    @GET("api/hp/detail/{id}")
    Observable<HpDetailEntity> getHpDetail(@Path("id") String hpId);

    @GET("api/search/music/{content}")
    Observable<BaseEntity> searchMusic(@Path("content")String content);

    @GET("api/search/hp/{content}")
    Observable<HpDetailListEntity> searchHp(@Path("content")String content);

    @GET("api/search/reading/{content}")
    Observable<BaseEntity> searchReading(@Path("content")String content);

    @GET("api/search/author/{content}")
    Observable<BaseEntity> searchAuthor(@Path("content")String content);

    @GET("api/search/movie/{content}")
    Observable<BaseEntity> searchMovie(@Path("content")String content);

}
