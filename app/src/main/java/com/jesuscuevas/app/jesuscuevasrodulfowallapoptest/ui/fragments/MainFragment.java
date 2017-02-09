package com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.ui.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.R;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.api.model.MarvelComic;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.base.BaseFragment;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.ui.mvp.presenters.MainFragmentPresenter;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.ui.mvp.presenters.MainFragmentPresenterImpl;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.ui.mvp.views.MainFragmentView;
import butterknife.BindView;

public class MainFragment extends BaseFragment implements MainFragmentView{

    private MainFragmentPresenter mPresenter;

    @BindView(R.id.fragment_main_progress_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.fragment_main_recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.fragment_main_error_connection)
    View mErrorConnectionView;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void getPresenter() {
        mPresenter = new MainFragmentPresenterImpl(this, getContext());
    }

    @Override
    protected void init() {
        mPresenter.loadComicList();
    }

    @Override
    public void showProgressDialog() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressDialog() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showConnectionError() {
        mErrorConnectionView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showComicList(MarvelComic marvelComic) {
        mPresenter.setRecyclerViewAdapter(mRecyclerView, marvelComic);
    }

    @Override
    public void onItemClick(MarvelComic marvelComic, int position) {
        mPresenter.moveToComicDetailActivity(marvelComic, position, getActivity());
    }

    @Override
    protected void getExtras() {
    }
}
