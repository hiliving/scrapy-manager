package com.scrapyd.client.app;

import android.app.Application;
import android.content.Context;

/**
 * @author huangyong
 * createTime 2019-07-22
 */
public class App extends Application {

    private static Context context;


    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
