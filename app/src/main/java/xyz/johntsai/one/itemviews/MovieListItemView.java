package xyz.johntsai.one.itemviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.johntsai.one.R;
import xyz.johntsai.one.entity.Movie;
import xyz.johntsai.one.listhelper.BaseItemModel;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/8/19.
 * 电影
 */
public class MovieListItemView extends BaseItemModel<Movie> {

    @BindView(R.id.tvMovie)
    TextView tvMovie;

    public MovieListItemView(Context context) {
        this(context,null);
    }

    public MovieListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(getContext(), R.layout.view_item_movie,this);
        ButterKnife.bind(this);
    }

    @Override
    public void bindView() {
        tvMovie.setText(model.getContent().getTitle());
    }
}
