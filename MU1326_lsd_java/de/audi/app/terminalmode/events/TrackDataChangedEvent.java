/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.events;

import de.esolutions.fw.util.commons.Buffer;

public class TrackDataChangedEvent {
    private final String title;
    private final int duration;
    private final String album;
    private final String artist;
    private final String genre;
    private final String composer;

    public TrackDataChangedEvent(String string, int n, String string2, String string3, String string4, String string5) {
        this.title = string;
        this.duration = n;
        this.album = string2;
        this.artist = string3;
        this.genre = string4;
        this.composer = string5;
    }

    public String getTitle() {
        return this.title;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getAlbum() {
        return this.album;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getComposer() {
        return this.composer;
    }

    public String toString() {
        return new Buffer(100).append("TrackDataChangedEvent [").append(this.title).append(", ").append(this.artist).append(", ").append(this.album).append(", ").append(this.genre).append(", ").append(this.composer).append(", ").append(this.duration).append("]").toString();
    }

    public static class Builder {
        private String title = "";
        private int duration = 0;
        private String album = "";
        private String artist = "";
        private String genre = "";
        private String composer = "";

        public TrackDataChangedEvent build() {
            return new TrackDataChangedEvent(this.title, this.duration, this.album, this.artist, this.genre, this.composer);
        }

        public Builder setAlbum(String string) {
            this.album = string;
            return this;
        }

        public Builder setArtist(String string) {
            this.artist = string;
            return this;
        }

        public Builder setComposer(String string) {
            this.composer = string;
            return this;
        }

        public Builder setDuration(int n) {
            this.duration = n;
            return this;
        }

        public Builder setGenre(String string) {
            this.genre = string;
            return this;
        }

        public Builder setTitle(String string) {
            this.title = string;
            return this;
        }
    }
}

