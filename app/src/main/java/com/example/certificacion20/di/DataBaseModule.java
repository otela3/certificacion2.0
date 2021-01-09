package com.example.certificacion20.di;

import android.app.Application;

import androidx.room.Room;

import com.example.certificacion20.db.NovaDB;
import com.example.certificacion20.db.NovaDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class DataBaseModule {

    @Provides
    @Singleton
    public static NovaDB provideNovaDB(Application application) {
        return Room.databaseBuilder(application, NovaDB.class, "Nova Database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }
    @Provides
    @Singleton
    public static NovaDao provideMansionDao(NovaDB novaDB) {
        return novaDB.novaDao();
    }
}
