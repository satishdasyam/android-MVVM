package com.satishdasyam.mvvm.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {ArtistEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ArtistDAO artistDao();
}
