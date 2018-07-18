package com.satishdasyam.mvvm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Search {

    @SerializedName("results")
    Results results;

    public Results getResults() {
        return results;
    }

    public static class Results {
        public ArtistMatches getArtistsMatches() {
            return artistMatches;
        }

        @SerializedName("artistmatches")
        ArtistMatches artistMatches;
    }

    public static class ArtistMatches {
        public List<Artist> getArtistList() {
            return artistList;
        }

        @SerializedName("artist")
        List<Artist> artistList;
    }

    public static class Artist {

        @SerializedName("name")
        String name;

        @SerializedName("streamable")
        boolean isStreaming;

        public String getName() {
            return name;
        }

        public boolean isStreaming() {
            return isStreaming;
        }

        public List<Image> getImageList() {
            return imageList;
        }

        @SerializedName("image")

        List<Image> imageList;

        /*@Expose(serialize = false, deserialize = false)
        String xyz;*/
    }

    public static class Image {

        @SerializedName("#text")
        String url;

        public String getUrl() {
            return url;
        }
    }
}
