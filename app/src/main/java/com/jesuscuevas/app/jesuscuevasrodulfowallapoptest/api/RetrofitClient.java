package com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.api;

import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.util.Constants;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static MarvelService ourInstance;

    private RetrofitClient() {
    }

    public static synchronized MarvelService getInstance() {

        if (ourInstance == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor).build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(client)
                    .build();
            ourInstance = retrofit.create(MarvelService.class);
            return ourInstance;
        } else
            return ourInstance;
    }
}