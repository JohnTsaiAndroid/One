package xyz.johntsai.one;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import xyz.johntsai.one.api.ApiFactory;
import xyz.johntsai.one.api.OneService;
import xyz.johntsai.one.entity.HpDetailEntity;
import xyz.johntsai.one.entity.HpIdListEntity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWeekImageArticle();
    }

    private void getWeekImageArticle() {
        final OneService oneService = ApiFactory.createRetrofitApi(OneService.class);
        oneService.hpIdList()
                .flatMap(new Func1<HpIdListEntity, Observable<String>>() {
            @Override
            public Observable<String> call(HpIdListEntity hpIdListEntity) {return Observable.from(hpIdListEntity.getData());}
        })
                .flatMap(new Func1<String, Observable<HpDetailEntity>>() {
            @Override
            public Observable<HpDetailEntity> call(String id) {return oneService.getHpDetail(id);}
        })
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                       Log.d("cj","doOnSubscribe"+Thread.currentThread().getName());
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HpDetailEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
               System.out.println(e.getMessage());
            }

            @Override
            public void onNext(HpDetailEntity hpDetailEntity) {
                  Log.d("cj","onNext"+hpDetailEntity.toString());
                  Log.d("cj","onNext"+Thread.currentThread().getName());
            }
        });

    }
}
