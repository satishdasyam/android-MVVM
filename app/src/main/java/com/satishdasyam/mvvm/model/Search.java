package com.satishdasyam.mvvm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Search {

    @SerializedName("results")
    private Results results;

    public Results getResults() {
        return results;
    }

    public static class Results {
        @SerializedName("artistmatches")
        ArtistMatches artistMatches;

        public ArtistMatches getArtistsMatches() {
            return artistMatches;
        }
    }

    public static class ArtistMatches {
        @SerializedName("artist")
        List<Artist> artistList;

        public List<Artist> getArtistList() {
            return artistList;
        }
    }

    public static class Artist {

        @SerializedName("name")
        String name;

        @SerializedName("streamable")
        boolean isStreaming;
        @SerializedName("image")

        List<Image> imageList;

        public String getName() {
            return name;
        }

        public boolean isStreaming() {
            return isStreaming;
        }

        public String getImage() {
            return this.imageList.get(3).getUrl();
        }

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
