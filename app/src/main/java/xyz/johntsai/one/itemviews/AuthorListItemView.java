package xyz.johntsai.one.itemviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.johntsai.one.R;
import xyz.johntsai.one.entity.Author;
import xyz.johntsai.one.listhelper.BaseItemModel;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/8/19.
 *
 */
public class AuthorListItemView extends BaseItemModel<Author> {

    @BindView(R.id.ivAuthor)
    ImageView ivAuthor;

    @BindView(R.id.tvAuthor)
    TextView tvAuthor;

    public AuthorListItemView(Context context) {
        this(context,null);
    }

    public AuthorListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(getContext(), R.layout.view_item_author,this);
        ButterKnife.bind(this);
    }

    @Override
    public void bindView() {
        tvAuthor.setText(model.getContent().getUser_name());
    }
}
