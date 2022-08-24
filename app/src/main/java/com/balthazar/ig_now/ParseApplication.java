package com.balthazar.ig_now;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    // Initializes Parse SDK as soon as the application is created

    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("hejhDjINswsDMWnedlYxw5gObRBCwykMcHFQrjYr")
                .clientKey("uNg1O72gC3lGSLEoyafdid1644pBBoK9N4YpiXww")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
