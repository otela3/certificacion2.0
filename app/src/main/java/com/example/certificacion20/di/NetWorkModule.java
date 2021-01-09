package com.example.certificacion20.di;

import com.example.certificacion20.network.NovaApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ApplicationComponent.class)
public class NetWorkModule {

    @Provides
    @Singleton
    public static NovaApiService privideNovaApiService(){
        return new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/Himuravidal/FakeAPIdata/products/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(NovaApiService.class);
    }
}
