/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.media;

import de.audi.remotehmi.media.IOnlineMedia$1;
import java.util.HashMap;

public interface IOnlineMedia {
    public static final int TYPE_INIT;
    public static final int TYPE_FASTFORWARD;
    public static final int TYPE_FASTREVERSE;
    public static final int TYPE_CLOSE;
    public static final int TYPE_PLAY;
    public static final int TYPE_PLAYPOS;
    public static final int TYPE_PAUSE;
    public static final int TYPE_RESUME;
    public static final int TYPE_SKIP;
    public static final int TYPE_SEEK;
    public static final int TYPE_REPEAT;
    public static final int TYPE_SHUFFLE;
    public static final int TYPE_UPDATE_KOMBI;
    public static final int TYPE_PLAYLIST_INDEX;
    public static final int TYPE_UPDATE_COVER_URL;
    public static final int TYPE_SHOW_DEFAULT_COVER_IN_FPK;
    public static final HashMap typeDescription;
    public static final String ATTR_CNC_URL;
    public static final String ATTR_SKIPSTEP;
    public static final String ATTR_ID;
    public static final String ATTR_POSITION;
    public static final String ATTR_STREAMURL;
    public static final String ATTR_SESSIONID;
    public static final String ATTR_TYPE;
    public static final String ATTR_CURRSECONDS;
    public static final String ATTR_TOTALSECONDS;
    public static final String ATTR_PERCENT;
    public static final String ATTR_ERROR;
    public static final String ATTR_SERVICEID;
    public static final String ATTR_ENABLED;
    public static final String ATTR_TRACK;
    public static final String ATTR_ARTIST;
    public static final String ATTR_ALBUM;
    public static final String ATTR_TRACKID;
    public static final String ATTR_INDEX;
    public static final String ATTR_CHECKSUM;
    public static final String ATTR_COVER;
    public static final String ORIGINAL_PREFIX;
    public static final String ATTR_ORIGINAL_COVER;
    public static final String PROP_ONLINE_MEDIA_CURRENT_CONTEXT;

    default public void openSession(String string, String string2, String string3) {
    }

    default public void skip(int n) {
    }

    default public void pause() {
    }

    default public void resume() {
    }

    default public void seek2Time(int n) {
    }

    default public void repeat(boolean bl) {
    }

    default public void shuffle(boolean bl) {
    }

    default public void setPlayListIndex(int n) {
    }

    default public int getTimeTotal() {
    }

    default public int getTimeCurrent() {
    }

    default public String getPlayerState() {
    }

    default public String getBufferStatus() {
    }

    default public int getBufferLevel() {
    }

    default public boolean isRepeatEnabled() {
    }

    default public boolean isShuffleEnabled() {
    }

    default public boolean isSkipEnabled() {
    }

    default public boolean isSeekEnabled() {
    }

    default public String getSessionState(String string) {
    }

    default public String getSessionId() {
    }

    default public String getLastError() {
    }

    default public void setClusterContent(long l, String string, String string2, String string3, String string4, String string5) {
    }

    default public void setClusterContent(int n, String string, String string2, String string3, String string4, String string5, String string6) {
    }

    default public boolean isForward() {
    }

    default public int getSkipCount() {
    }

    default public void fastForward() {
    }

    default public void play(String string, int n) {
    }

    default public void fastRewind() {
    }

    default public void setPlayPosition(int n) {
    }

    default public void close() {
    }

    static {
        typeDescription = new IOnlineMedia$1();
    }
}

