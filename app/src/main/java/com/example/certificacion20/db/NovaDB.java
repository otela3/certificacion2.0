package com.example.certificacion20.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.certificacion20.model.Nova;

@Database(entities = {Nova.class},version = 2,exportSchema = false)
public abstract class NovaDB extends RoomDatabase {
    public abstract NovaDao novaDao();
}
