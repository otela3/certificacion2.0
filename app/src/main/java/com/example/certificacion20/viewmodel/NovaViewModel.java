package com.example.certificacion20.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.certificacion20.model.Nova;
import com.example.certificacion20.model.NovaResponse;
import com.example.certificacion20.repository.Repository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NovaViewModel extends ViewModel {
    private static final String TAG = "NovaViewModel";

    private Repository repository;
    private MutableLiveData<ArrayList<Nova>> novaList = new MutableLiveData<>();
    private LiveData<List<Nova>> novaListOfline = null;

    public NovaViewModel(Repository repository) {
        this.repository = repository;
    }

    public MutableLiveData<ArrayList<Nova>> getNovaList(){
        return novaList;
    }

    public void getNova(){
        repository.getNova()
                .subscribeOn(Schedulers.io())
                .map(new Function<NovaResponse, ArrayList<Nova>>() {
                    @Override
                    public ArrayList<Nova> apply(NovaResponse novaResponse) throws Throwable{
                        ArrayList<Nova> list = novaResponse.getResult();
                        for (Nova nova : list){
                            String url = nova.getImage();

                        }
                        return list;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> novaList.setValue(result),
                        error -> Log.e(TAG, "getNova: "+ error.getMessage() ));
    }

    public void insertNova(Nova nova){
        repository.insertNova(nova);
    }

    public LiveData<List<Nova>> getNovaOffline(){
        return novaListOfline;
    }

    public void getNovaOfline(){
        novaListOfline = repository.getNovaOffline();
    }
}
