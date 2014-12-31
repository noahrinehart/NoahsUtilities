package nrinehart.io.noahsutilities.objects;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;

/**
 * Created by nrinehart on 12/30/2014.
 */
public class Track {

    public String name;
    public String artist;
    public String album;
    public String num;
    public String year;
    public String genre;
    public String comment;
    public String composer;
    public String aartist;
    public Bitmap art;

    public Track(Uri uri, Context context){
        if (uri != null){
            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(context.getApplicationContext(), uri);
            this.name = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
            this.artist = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
            this.album = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
            this.num = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_CD_TRACK_NUMBER);
            this.year = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_YEAR);
            this.genre = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE);

        }
    }


    public Bitmap getArt() {
        return art;
    }

    public void setArt(Bitmap art) {
        this.art = art;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getAartist() {
        return aartist;
    }

    public void setAartist(String aartist) {
        this.aartist = aartist;
    }




}
