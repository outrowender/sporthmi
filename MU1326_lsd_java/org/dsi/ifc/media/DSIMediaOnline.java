/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIBase;

public interface DSIMediaOnline
extends DSIBase {
    public static final String VERSION = "2.11.52";
    public static final int ATTR_BUFFERSTATE = 1;
    public static final int ATTR_BUFFERFILLINFO = 2;
    public static final int ATTR_AUDIOSETTINGS = 3;
    public static final int BUFFERSTATE_UNKNOWN = 0;
    public static final int BUFFERSTATE_UNDERRUN = 1;
    public static final int BUFFERSTATE_FILLED = 2;
    public static final int AUDIOTYPE_UNKNOWN = 0;
    public static final int AUDIOTYPE_SURROUNDSOUND = 1;
    public static final int AUDIOTYPE_3DSOUND = 2;
    public static final int AUDIOTYPE_VOLUMEOFFSET = 4;
}

