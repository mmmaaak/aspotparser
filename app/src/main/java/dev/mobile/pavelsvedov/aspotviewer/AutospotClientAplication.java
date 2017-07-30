package dev.mobile.pavelsvedov.aspotviewer;

import android.app.Application;

import dev.mobile.pavelsvedov.aspotviewer.services.AutospotService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class AutospotClientAplication extends Application {

    private static AutospotService aspotService;

    @Override
    public void onCreate() {
        super.onCreate();

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

        aspotService = retrofit.create(AutospotService.class);
    }

    public static AutospotService getAutospotService() {
        return aspotService;
    }
}
