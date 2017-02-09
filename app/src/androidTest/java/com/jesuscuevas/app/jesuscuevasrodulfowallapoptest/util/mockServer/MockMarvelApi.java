package com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.util.mockServer;

import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.api.MarvelService;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.api.model.Data;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.api.model.MarvelComic;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.api.model.Result;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.api.model.Thumbnail;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Query;
import retrofit2.mock.BehaviorDelegate;
import rx.Observable;

public class MockMarvelApi implements MarvelService{
    private static final String TAG = MockMarvelApi.class.getSimpleName();
    private final BehaviorDelegate<MarvelService> delegate;

    public MockMarvelApi(BehaviorDelegate<MarvelService> delegate) {
        this.delegate = delegate;
    }

    @Override
    public Observable<MarvelComic> getLimitedComicsRx(@Query("ts") String timestamp, @Query("apikey") String apyKey, @Query("hash") String hash, @Query("format") String format, @Query("orderBy") String orderBy, @Query("limit") int queryLimit) {

        Thumbnail th1 = new Thumbnail();
        th1.setExtension("");
        th1.setPath("");

        Result re1 = new Result();
        re1.setDescription("description1");
        re1.setTitle("tittle1");
        re1.setThumbnail(th1);
        Result re2 = new Result();
        re2.setDescription("description2");
        re2.setTitle("tittle2");
        re2.setThumbnail(th1);

        Result re3 = new Result();
        re3.setDescription("description3");
        re3.setTitle("tittle3");
        re3.setThumbnail(th1);

        List<Result> results = new ArrayList<>();
        results.add(re1);
        results.add(re2);
        results.add(re3);

        Data data = new Data();
        data.setResults(results);
        MarvelComic marvelComic = new MarvelComic();
        marvelComic.setData(data);
        return delegate.returningResponse(marvelComic).getLimitedComicsRx("","","","","",10);

    }

    @Override
    public Call<MarvelComic> getLimitedComicsNoRx(@Query("ts") String timestamp, @Query("apikey") String apyKey, @Query("hash") String hash, @Query("format") String format, @Query("orderBy") String orderBy, @Query("limit") int queryLimit) {
        return null;
    }
}
