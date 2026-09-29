/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.events;

import de.audi.app.terminalmode.events.TrackDataChangedEvent;

public class TrackDataChangedEvent$Builder {
    private String title = "";
    private int duration = 0;
    private String album = "";
    private String artist = "";
    private String genre = "";
    private String composer = "";

    public TrackDataChangedEvent build() {
        return new TrackDataChangedEvent(this.title, this.duration, this.album, this.artist, this.genre, this.composer);
    }

    public TrackDataChangedEvent$Builder setAlbum(String string) {
        this.album = string;
        return this;
    }

    public TrackDataChangedEvent$Builder setArtist(String string) {
        this.artist = string;
        return this;
    }

    public TrackDataChangedEvent$Builder setComposer(String string) {
        this.composer = string;
        return this;
    }

    public TrackDataChangedEvent$Builder setDuration(int n) {
        this.duration = n;
        return this;
    }

    public TrackDataChangedEvent$Builder setGenre(String string) {
        this.genre = string;
        return this;
    }

    public TrackDataChangedEvent$Builder setTitle(String string) {
        this.title = string;
        return this;
    }
}

