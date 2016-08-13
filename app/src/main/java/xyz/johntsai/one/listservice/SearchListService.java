package xyz.johntsai.one.listservice;

import java.util.ArrayList;
import java.util.List;

import xyz.johntsai.one.entity.HpDetailListEntity;
import xyz.johntsai.one.itemviews.HpListItemView;
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
        return new ModelFactory.Builder().addModel(HpListItemView.class).build();
    }

    public static List<SimpleItemEntity> getHpList(HpDetailListEntity entity){
        List<SimpleItemEntity> list = new ArrayList<>();
        for(HpDetailListEntity.DataEntity dataEntity:entity.getData()){
            ItemEntityCreator.create(dataEntity).setModelView(HpListItemView.class).attach(list);
        }
        return list;
    }
}
