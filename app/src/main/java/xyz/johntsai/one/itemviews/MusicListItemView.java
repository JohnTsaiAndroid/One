package xyz.johntsai.one.itemviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.johntsai.one.R;
import xyz.johntsai.one.entity.Music;
import xyz.johntsai.one.listhelper.BaseItemModel;
import xyz.johntsai.one.utils.ImageLoad;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/8/15.
 */
public class MusicListItemView extends BaseItemModel<Music> {

    @BindView(R.id.ivCover)
    ImageView mImageCover;

    @BindView(R.id.tvTitle)
    TextView mTextTitle;

    @BindView(R.id.tvAuthor)
    TextView mTextAuthor;

    public MusicListItemView(Context context) {
        this(context,null);
    }

    public MusicListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.view_item_music_list,this);
        ButterKnife.bind(this);
    }

    @Override
    public void bindView() {
        Music music = model.getContent();
        if(music==null)return;
        ImageLoad.load(getContext(),mImageCover,music.getCover());
        mTextTitle.setText(music.getTitle());
        mTextAuthor.setText(music.getAuthor().getUser_name());
    }
}
