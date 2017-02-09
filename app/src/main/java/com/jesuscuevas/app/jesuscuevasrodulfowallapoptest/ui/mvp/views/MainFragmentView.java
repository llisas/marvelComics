package com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.ui.mvp.views;


import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.api.model.MarvelComic;

public interface MainFragmentView {
    void showProgressDialog();
    void hideProgressDialog();
    void showConnectionError();
    void showComicList(MarvelComic marvelComic);
    void onItemClick(MarvelComic marvelComic, int position);
}
