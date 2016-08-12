package xyz.johntsai.one.api;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/8/11.
 */
public enum OneServiceFactory {
    INSTANCE;
    public OneService get(){
        return ApiFactory.create(OneService.class);
    }
}
