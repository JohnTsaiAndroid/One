package xyz.johntsai.one.api;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import xyz.johntsai.one.entity.HpDetailEntity;
import xyz.johntsai.one.entity.HpIdListEntity;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/7/13.
 */
public interface OneService {

    @GET("api/hp/idlist/0")
    Observable<HpIdListEntity> hpIdList();

    @GET("api/hp/detail/{id}")
    Observable<HpDetailEntity> getHpDetail(@Path("id") String hpId);

}
