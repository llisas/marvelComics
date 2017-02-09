package com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.api;

import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.api.model.MarvelComic;
import rx.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface MarvelService {

    //Rx
    @GET("comics?")
    Observable<MarvelComic> getLimitedComicsRx(
            @Query("ts") String timestamp,
            @Query("apikey") String apyKey,
            @Query("hash") String hash,
            @Query("format") String format,
            @Query("orderBy") String orderBy,
            @Query("limit") int queryLimit);

    //no Rx
    @GET("comics?")
    Call<MarvelComic> getLimitedComicsNoRx(
            @Query("ts") String timestamp,
            @Query("apikey") String apyKey,
            @Query("hash") String hash,
            @Query("format") String format,
            @Query("orderBy") String orderBy,
            @Query("limit") int queryLimit);


}
