package com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.ui.mvp.presenters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.BuildConfig;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.R;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.adapters.ComicRecyclerViewAdapter;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.api.MarvelService;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.api.RetrofitClient;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.api.model.MarvelComic;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.ui.activities.Henson;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.ui.mvp.views.MainFragmentView;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.util.ApiUtils;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.util.Constants;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainFragmentPresenterImpl implements MainFragmentPresenter {

    private MainFragmentView mView;
    private Observable<MarvelComic> mComicObservable;
    private Context mContext;

    public MainFragmentPresenterImpl(MainFragmentView view, Context context) {
        mView = view;
        mContext = context;
    }

    @Override
    public void loadComicList() {
        mView.showProgressDialog();
        MarvelService service = RetrofitClient.getInstance();
        mComicObservable = service.getLimitedComicsRx(
                ApiUtils.getUnixTimeStamp(),
                BuildConfig.MARVEL_API_PUBLIC_KEY,
                ApiUtils.generateMarvelHash(BuildConfig.MARVEL_API_PUBLIC_KEY,
                        BuildConfig.MARVEL_API_PRIVATE_KEY),
                Constants.API_QUERY_FORMAT,
                Constants.API_QUERY_ORDER_BY,
                Constants.API_RESULT_LIMIT);

        mComicObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MarvelComic>() {
                    @Override
                    public void onCompleted() {
                        mView.hideProgressDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.hideProgressDialog();
                        mView.showConnectionError();
                    }

                    @Override
                    public void onNext(MarvelComic marvelComic) {
                        mView.showComicList(marvelComic);
                    }
                });
    }

    @Override
    public void setRecyclerViewAdapter(RecyclerView recyclerView, MarvelComic marvelComic) {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(mContext);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        ComicRecyclerViewAdapter adapter =
                new ComicRecyclerViewAdapter(marvelComic, mContext,mView);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void moveToComicDetailActivity(MarvelComic marvelComic, int position, Activity activity) {
        String description;
        if (marvelComic.getData().getResults().get(position).getDescription() == null)
            description = mContext.getResources()
                    .getString(R.string.error_description);
        else
            description = marvelComic.getData()
                    .getResults().get(position).getDescription();

        Intent intent = Henson
                .with(activity)
                .gotoComicDetailActivity()
                .detailComicDescription(description)
                .detailComicTitle(marvelComic.getData().getResults().get(position).getTitle())
                .detailPictureExtension(marvelComic.getData().getResults().get(position)
                        .getImages().get(0).getExtension())
                .detailPictureUrl(marvelComic.getData().getResults().get(position).getImages()
                        .get(0).getPath())
                .build();

        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.enter, R.anim.exit);
    }

}
