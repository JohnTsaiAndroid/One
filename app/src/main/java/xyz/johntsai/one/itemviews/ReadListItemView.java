package xyz.johntsai.one.itemviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.johntsai.one.R;
import xyz.johntsai.one.entity.Read;
import xyz.johntsai.one.listhelper.BaseItemModel;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/8/15.
 */
public class ReadListItemView extends BaseItemModel<Read> {

    @BindView(R.id.ivType)
    ImageView mImageType;

    @BindView(R.id.tvContent)
    TextView mTextContent;

    public ReadListItemView(Context context) {
        this(context,null);
    }

    public ReadListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.view_item_read_list,this);
    }

    @Override
    public void bindView() {
        ButterKnife.bind(this);

        Read content = model.getContent();
        if(content==null)
            return;
        String type = content.getType();
        switch (type){
            case "essay":
                mImageType.setImageResource(R.drawable.essay_image);
                break;
            case "question":
                mImageType.setImageResource(R.drawable.question_image);
                break;
            case "serialcontent":
                mImageType.setImageResource(R.drawable.serial_image);
                break;
            default:
                break;
        }

        mTextContent.setText(content.getTitle());
    }
}
