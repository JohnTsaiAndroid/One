package xyz.johntsai.one.itemviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.johntsai.one.R;
import xyz.johntsai.one.entity.HpDetailListEntity;
import xyz.johntsai.one.listhelper.BaseItemModel;
import xyz.johntsai.one.utils.ImageLoad;
import xyz.johntsai.one.utils.ToastUtils;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/8/12.
 */
public class HpListItemView extends BaseItemModel<HpDetailListEntity.DataEntity> {

    @BindView(R.id.ivHp)
    ImageView imageView;

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @BindView(R.id.tvContent)
    TextView tvContent;

    public HpListItemView(Context context) {
        this(context,null);
    }

    public HpListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void bindView() {
        inflate(getContext(), R.layout.view_item_hp_list,this);
        ButterKnife.bind(this);

        ImageLoad.load(getContext(),imageView,model.getContent().getHp_img_url());
        tvTitle.setText(model.getContent().getHp_title());
        tvContent.setText(model.getContent().getHp_content());

    }

    @OnClick(R.id.container)
    void clickContainer(){
        ToastUtils.showShort(getContext(),""+model.getContent().getHpcontent_id());
    }
}
