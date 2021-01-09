package com.example.certificacion20.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.certificacion20.model.Nova;

import java.util.List;
@Dao
public interface NovaDao {
    @Insert
void insertNova(Nova nova);

    @Query("SELECT * FROM nova_list")
    LiveData<List<Nova>> getNovaOffline();
}
