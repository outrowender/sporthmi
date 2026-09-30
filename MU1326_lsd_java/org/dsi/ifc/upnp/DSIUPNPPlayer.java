/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.upnp;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.upnp.ListEntry;

public interface DSIUPNPPlayer
extends DSIBase {
    public static final String VERSION = "2.11.2";
    public static final int ATTR_DETAILINFO = 1;
    public static final int ATTR_DEVICELIST = 2;
    public static final int ATTR_PLAYBACKMODE = 3;
    public static final int ATTR_PLAYBACKMODELIST = 4;
    public static final int ATTR_PLAYBACKSTATE = 5;
    public static final int ATTR_PLAYPOSITION = 6;
    public static final int ATTR_VOLUME = 7;
    public static final int RT_PAUSE = 1000;
    public static final int RT_RESUME = 1001;
    public static final int RT_SETENTRY = 1002;
    public static final int RT_SETPLAYBACKMODE = 1003;
    public static final int RT_SKIP = 1004;
    public static final int RT_SEEK = 1005;
    public static final int RT_SETVOLUME = 1006;
    public static final int RT_INCREASEVOLUME = 1007;
    public static final int RT_DECREASEVOLUME = 1008;
    public static final int DEVICETYPE_UNKNOWN = 0;
    public static final int DEVICETYPE_MIB_APP = 1;
    public static final int PLAYMODEFLAG_REPEAT = 1;
    public static final int PLAYMODEFLAG_SHUFFLE = 2;
    public static final int PLAYBACKSCOPE_FILE = 1;
    public static final int PLAYBACKSCOPE_DEVICE = 2;
    public static final int PLAYBACKSCOPE_MEDIUM = 3;
    public static final int PLAYBACKSCOPE_SELECTION = 6;
    public static final int PLAYBACKSTATE_INVALID = 0;
    public static final int PLAYBACKSTATE_PLAYING = 1;
    public static final int PLAYBACKSTATE_PAUSED = 2;
    public static final int PLAYBACKSTATE_SEEKING = 3;
    public static final int PLAYBACKSTATE_STOPPED_WITH_ERROR = 4;
    public static final int DIRECTION_FW = 0;
    public static final int DIRECTION_BW = 1;
    public static final int SKIP_NEXT_ENTRY = 0;
    public static final int SKIP_PREV_ENTRY = 1;
    public static final int SKIP_BEGIN_ENTRY = 2;
    public static final int PLAYBACKRATE_2X = 1;
    public static final int PLAYBACKRATE_4X = 2;
    public static final int PLAYBACKRATE_8X = 4;
    public static final int PLAYBACKRATE_16X = 6;
    public static final int PLAYBACKRATE_32X = 7;
    public static final int PLAYBACKRATE_1BY2X = 8;
    public static final int PLAYBACKRATE_1BY4X = 9;
    public static final int PLAYBACKRATE_1BY8X = 11;
    public static final int PLAYBACKRATE_1BY16X = 13;
    public static final int PLAYBACKRATE_1BY32X = 14;
    public static final int PLAYBACKRATE_64X = 15;

    public void setPlaybackMode(String var1, int var2);

    public void setEntry(String[] var1, String var2, ListEntry[] var3, int var4);

    public void resume(String var1);

    public void pause(String var1);

    public void skip(String var1, int var2, int var3);

    public void seek(String var1, int var2, int var3);

    public void increaseVolume(String var1);

    public void decreaseVolume(String var1);

    public void setVolume(String var1, int var2);
}

