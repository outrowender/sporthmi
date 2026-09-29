/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.dsi.media.MediaListEntry;
import de.esolutions.fw.util.commons.Buffer;

public class PlayingTrack {
    public static final long INVALID_ENTRYID;
    public static final MediaListEntry[] EMPTY_PLAYBACK_FOLDER;
    private final long entryID;
    private final MediaListEntry[] playbackFolder;

    public PlayingTrack(long l, MediaListEntry[] mediaListEntryArray) {
        if (mediaListEntryArray == null) {
            throw new IllegalArgumentException("playback folder cannot be null");
        }
        this.entryID = l;
        this.playbackFolder = mediaListEntryArray;
    }

    public PlayingTrack() {
        this.entryID = -1L;
        this.playbackFolder = EMPTY_PLAYBACK_FOLDER;
    }

    public long getEntryID() {
        return this.entryID;
    }

    public MediaListEntry[] getPlaybackFolder() {
        return this.playbackFolder;
    }

    public boolean isPlaylistTrack() {
        try {
            return this.playbackFolder[this.playbackFolder.length - 1].isPlaylist();
        }
        catch (Exception exception) {
            return false;
        }
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[PlayingTrack: entryID='").append(this.entryID).append("',playlist='").append(this.isPlaylistTrack()).append("']");
        return buffer.toString();
    }

    static {
        EMPTY_PLAYBACK_FOLDER = new MediaListEntry[0];
    }
}

