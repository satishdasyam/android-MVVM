package com.satishdasyam.mvvm.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ArtistDAO {

    @Query("SELECT * FROM artistentity LIMIT 20")
    List<ArtistEntity> getArtists();

    @Query("SELECT * FROM artistentity WHERE name LIKE :name  "
            + " LIMIT 20")
    List<ArtistEntity> getArtistsBySearch(String name);

    @Insert
    void insertAll(List<ArtistEntity> artistList);

    @Delete
    void delete(ArtistEntity user);
}
