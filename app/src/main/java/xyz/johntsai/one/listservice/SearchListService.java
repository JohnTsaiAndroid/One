package xyz.johntsai.one.listservice;

import java.util.ArrayList;
import java.util.List;

import xyz.johntsai.one.entity.Author;
import xyz.johntsai.one.entity.BaseDataEntity;
import xyz.johntsai.one.entity.Hp;
import xyz.johntsai.one.entity.Movie;
import xyz.johntsai.one.entity.Music;
import xyz.johntsai.one.entity.Read;
import xyz.johntsai.one.itemviews.AuthorListItemView;
import xyz.johntsai.one.itemviews.HpListItemView;
import xyz.johntsai.one.itemviews.MovieListItemView;
import xyz.johntsai.one.itemviews.MusicListItemView;
import xyz.johntsai.one.itemviews.ReadListItemView;
import xyz.johntsai.one.listhelper.ItemEntityCreator;
import xyz.johntsai.one.listhelper.ModelFactory;
import xyz.johntsai.one.listhelper.SimpleItemEntity;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/8/12.
 */
public class SearchListService {

    private SearchListService(){

    }

    public static ModelFactory getFactory(){
        return new ModelFactory.Builder()
                .addModel(HpListItemView.class)
                .addModel(ReadListItemView.class)
                .addModel(MusicListItemView.class)
                .addModel(MovieListItemView.class)
                .addModel(AuthorListItemView.class)
                .build();
    }

    public static List<SimpleItemEntity> getHpList(BaseDataEntity<List<Hp>> entity){
        List<SimpleItemEntity> list = new ArrayList<>();
        for(Hp data:entity.getData()){
            ItemEntityCreator.create(data).setModelView(HpListItemView.class).attach(list);
        }
        return list;
    }

    public static List<SimpleItemEntity> getReadList(BaseDataEntity<List<Read>> entity){
        List<SimpleItemEntity> list = new ArrayList<>();
        for(Read readData:entity.getData()){
            ItemEntityCreator.create(readData).setModelView(ReadListItemView.class).attach(list);
        }
        return list;
    }

    public static List<SimpleItemEntity> getMusicList(BaseDataEntity<List<Music>> entity){
        List<SimpleItemEntity> list = new ArrayList<>();
        for(Music music:entity.getData()){
            ItemEntityCreator.create(music).setModelView(MusicListItemView.class).attach(list);
        }
        return list;
    }

    public static List<SimpleItemEntity> getMovieList(BaseDataEntity<List<Movie>> entity){
        List<SimpleItemEntity> list = new ArrayList<>();
        for(Movie movie:entity.getData()){
           ItemEntityCreator.create(movie).setModelView(MovieListItemView.class).attach(list);
        }
        return list;
    }

    public static List<SimpleItemEntity> getAuthorList(BaseDataEntity<List<Author>> entity){
        List<SimpleItemEntity> list = new ArrayList<>();
        for(Author author:entity.getData()){
            ItemEntityCreator.create(author).setModelView(AuthorListItemView.class)
                    .attach(list);
        }
        return list;
    }
}
