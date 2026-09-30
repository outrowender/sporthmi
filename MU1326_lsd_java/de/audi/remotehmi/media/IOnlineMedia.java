/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.media;

import java.util.HashMap;

public interface IOnlineMedia {
    public static final int TYPE_INIT = 2000300;
    public static final int TYPE_FASTFORWARD = 2000301;
    public static final int TYPE_FASTREVERSE = 2000302;
    public static final int TYPE_CLOSE = 2000303;
    public static final int TYPE_PLAY = 2000304;
    public static final int TYPE_PLAYPOS = 2000305;
    public static final int TYPE_PAUSE = 2000306;
    public static final int TYPE_RESUME = 2000307;
    public static final int TYPE_SKIP = 2000308;
    public static final int TYPE_SEEK = 2000309;
    public static final int TYPE_REPEAT = 2000310;
    public static final int TYPE_SHUFFLE = 2000311;
    public static final int TYPE_UPDATE_KOMBI = 2000312;
    public static final int TYPE_PLAYLIST_INDEX = 2000313;
    public static final int TYPE_UPDATE_COVER_URL = 2000314;
    public static final int TYPE_SHOW_DEFAULT_COVER_IN_FPK = 2000315;
    public static final HashMap typeDescription = new HashMap(){
        private static final long serialVersionUID = -6207715950422398903L;
        {
            this.put(new Integer(2000300), "type_Init");
            this.put(new Integer(2000301), "type_FastForward");
            this.put(new Integer(2000302), "type_FastReverse");
            this.put(new Integer(2000303), "type_Close");
            this.put(new Integer(2000304), "type_Play");
            this.put(new Integer(2000305), "type_PlayPos");
            this.put(new Integer(2000306), "type_Pause");
            this.put(new Integer(2000307), "type_Resume");
            this.put(new Integer(2000309), "type_Seek");
            this.put(new Integer(2000310), "type_Repeat");
            this.put(new Integer(2000311), "type_Shuffle");
            this.put(new Integer(2000312), "type_UpdateKombi");
            this.put(new Integer(2000313), "type_PlayListIndex");
            this.put(new Integer(2000314), "type_updateCoverUrl");
        }
    };
    public static final String ATTR_CNC_URL = "cncURL";
    public static final String ATTR_SKIPSTEP = "skipSteps";
    public static final String ATTR_ID = "id";
    public static final String ATTR_POSITION = "timePos";
    public static final String ATTR_STREAMURL = "streamUrl";
    public static final String ATTR_SESSIONID = "sessionId";
    public static final String ATTR_TYPE = "type";
    public static final String ATTR_CURRSECONDS = "currentSeconds";
    public static final String ATTR_TOTALSECONDS = "totalSeconds";
    public static final String ATTR_PERCENT = "percent";
    public static final String ATTR_ERROR = "errorMessage";
    public static final String ATTR_SERVICEID = "serviceId";
    public static final String ATTR_ENABLED = "enabled";
    public static final String ATTR_TRACK = "track";
    public static final String ATTR_ARTIST = "artist";
    public static final String ATTR_ALBUM = "album";
    public static final String ATTR_TRACKID = "trackId";
    public static final String ATTR_INDEX = "index";
    public static final String ATTR_CHECKSUM = "checksum";
    public static final String ATTR_COVER = "decoratorUrl";
    public static final String ORIGINAL_PREFIX = "original_";
    public static final String ATTR_ORIGINAL_COVER = "original_decoratorUrl";
    public static final String PROP_ONLINE_MEDIA_CURRENT_CONTEXT = "onlineMediaCurrentContext";

    public void openSession(String var1, String var2, String var3);

    public void skip(int var1);

    public void pause();

    public void resume();

    public void seek2Time(int var1);

    public void repeat(boolean var1);

    public void shuffle(boolean var1);

    public void setPlayListIndex(int var1);

    public int getTimeTotal();

    public int getTimeCurrent();

    public String getPlayerState();

    public String getBufferStatus();

    public int getBufferLevel();

    public boolean isRepeatEnabled();

    public boolean isShuffleEnabled();

    public boolean isSkipEnabled();

    public boolean isSeekEnabled();

    public String getSessionState(String var1);

    public String getSessionId();

    public String getLastError();

    public void setClusterContent(long var1, String var3, String var4, String var5, String var6, String var7);

    public void setClusterContent(int var1, String var2, String var3, String var4, String var5, String var6, String var7);

    public boolean isForward();

    public int getSkipCount();

    public void fastForward();

    public void play(String var1, int var2);

    public void fastRewind();

    public void setPlayPosition(int var1);

    public void close();
}

