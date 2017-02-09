package com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.ui.fragments;

import android.widget.ImageView;
import android.widget.TextView;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.R;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.base.BaseFragment;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.ui.mvp.presenters.ComicDetailFragmentPresenter;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.ui.mvp.presenters.ComicDetailFragmentPresenterImp;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.ui.mvp.views.ComicDetailFragmentView;
import butterknife.BindView;

public class ComicDetailFragment extends BaseFragment implements ComicDetailFragmentView {

    private ComicDetailFragmentPresenter mPresenter;

    @BindView(R.id.fragment_comic_detail_image)
    ImageView mDetailImage;
    @BindView(R.id.fragment_comic_detail_tittle)
    TextView mDetailTittle;
    @BindView(R.id.fragment_comic_detail_description)
    TextView mDetailDescription;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_comic_detail;
    }

    @Override
    protected void getExtras() {
        mPresenter.getComicTittle();
        mPresenter.getComicDescription();
        mPresenter.loadComicImage(getContext(),mDetailImage);
    }

    @Override
    protected void getPresenter() {
        mPresenter = new ComicDetailFragmentPresenterImp(this,ComicDetailFragment.this);
    }

    @Override
    protected void init() {

    }

    @Override
    public void showComicTitle(String tittle) {
        mDetailTittle.setText(tittle);
    }

    @Override
    public void showComicDescription(String description) {
        mDetailDescription.setText(description);
    }

}