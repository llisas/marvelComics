package com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.ui.mvp.presenters;


import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.api.model.MarvelComic;
import rx.Observable;
import rx.Observer;

public interface MainFragmentPresenter {

    void loadComicList();
    void setRecyclerViewAdapter(RecyclerView recyclerView, MarvelComic marvelComic);
    void moveToComicDetailActivity(MarvelComic marvelComic, int position, Activity activity);

}
