package com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.ui.mvp.presenters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.ui.mvp.views.ComicDetailFragmentView;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.util.AppUtils;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.util.Constants;
import com.squareup.picasso.Picasso;

public class ComicDetailFragmentPresenterImp implements ComicDetailFragmentPresenter {

    private ComicDetailFragmentView mView;
    private Fragment mFragment;

    public ComicDetailFragmentPresenterImp(ComicDetailFragmentView view, Fragment fragment) {
        mFragment = fragment;
        mView = view;
    }

    @Override
    public void getComicTittle() {
        String tittle = mFragment.getArguments().getString(Constants.EXTRAS_TITTLE);
        mView.showComicTitle(AppUtils.fromHtmlToString(tittle));
    }

    @Override
    public void getComicDescription() {
        String description = mFragment.getArguments().getString(Constants.EXTRAS_DESCRIPTION);
        mView.showComicDescription(AppUtils.fromHtmlToString(description));
    }

    @Override
    public void loadComicImage(Context context, ImageView resource) {
        String url = mFragment.getArguments().getString(Constants.EXTRAS_URL);
        String extension = mFragment.getArguments().getString(Constants.EXTRAS_EXTENSION);
        String completeURL = url + "." + extension;
        Picasso.with(context)
                .load(completeURL)
                .fit()
                .centerCrop()
                .into(resource);
    }
}
