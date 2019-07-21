package com.example.realm3_card;

import android.app.Application;

import io.realm.Realm;

public class RealmApplication extends Application {
        @Override
        public void onCreate() {
            super.onCreate();
            Realm.init(getApplicationContext());


        }
}

