package com.in.daggersample;

import android.app.Application;
import android.location.LocationManager;

import com.in.daggersample.activities.MainActivity;
import com.in.daggersample.modules.ApplicationModule;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Abhishek on 11/6/2015.
 */
public class BaseApplication extends Application {

    @Singleton
    @Component(modules = {ApplicationModule.class})
    public interface ApplicationComponent {
        void inject(BaseApplication application);
        void inject(MainActivity activity);
    }

    @Inject
    LocationManager locationManager;

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerBaseApplication_ApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        getComponent().inject(this);
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
