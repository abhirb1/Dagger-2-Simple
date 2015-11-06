package com.in.daggersample.modules;

/**
 * Created by Abhishek on 11/6/2015.
 */

import android.content.Context;
import android.location.LocationManager;

import com.in.daggersample.BaseApplication;
import com.in.daggersample.ForApplication;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private BaseApplication application;

    public ApplicationModule(BaseApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    @ForApplication
    BaseApplication provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    LocationManager provideLocationManager() {
        return (LocationManager) application.getSystemService(Context.LOCATION_SERVICE);
    }
}