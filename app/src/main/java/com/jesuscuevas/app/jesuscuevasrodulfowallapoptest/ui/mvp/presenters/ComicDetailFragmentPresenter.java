package com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.ui.mvp.presenters;

import android.content.Context;
import android.widget.ImageView;

public interface ComicDetailFragmentPresenter {
    void getComicTittle();
    void getComicDescription();
    void loadComicImage(Context context, ImageView resource);
}
