package com.satishdasyam.mvvm.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class ArtistEntity {
    @PrimaryKey
    @ColumnInfo(name = "u_id")
    private int artistId;
    String name;
    @ColumnInfo(name = "is_streaming")
    boolean isStreaming;
    String image;

    public String getName() {
        return name;
    }

    public boolean isStreaming() {
        return isStreaming;
    }

    public String getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreaming(boolean streaming) {
        isStreaming = streaming;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }
}
