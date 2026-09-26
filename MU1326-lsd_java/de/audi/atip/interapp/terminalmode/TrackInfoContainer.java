/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.terminalmode;

public class TrackInfoContainer {
    private String title;
    private String artist;
    private String album;
    private int length;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String string) {
        this.title = string;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String string) {
        this.artist = string;
    }

    public String getAlbum() {
        return this.album;
    }

    public void setAlbum(String string) {
        this.album = string;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int n) {
        this.length = n;
    }
}

