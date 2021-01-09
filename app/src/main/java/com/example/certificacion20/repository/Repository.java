package com.example.certificacion20.repository;

import androidx.lifecycle.LiveData;

import com.example.certificacion20.db.NovaDao;
import com.example.certificacion20.model.Nova;
import com.example.certificacion20.model.NovaResponse;
import com.example.certificacion20.network.NovaApiService;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

import javax.inject.Inject;

public class Repository {

    private NovaDao novaDao;
    private NovaApiService novaApiService;

    @Inject
    public Repository(NovaDao novaDao, NovaApiService novaApiService){
        this.novaDao = novaDao;
        this.novaApiService = novaApiService;
    }
    public Observable<NovaResponse> getNova(){
        return novaApiService.getNova();
    }
    public void insertNova(Nova nova){
        novaDao.insertNova(nova);
    }
    public LiveData<List<Nova>> getNovaOffline(){
        return novaDao.getNovaOffline();
    }

}
