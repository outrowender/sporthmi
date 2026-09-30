/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.base.DSIBase;

public interface DSITIMTuner
extends DSIBase {
    public static final String VERSION = "2.11.36";
    public static final int ATTR_TIMMESSAGELIST = 1;
    public static final int ATTR_TIMSTATUS = 3;
    public static final int ATTR_TIMMEMOUSAGE = 4;
    public static final int ATTR_TIMAVAILABLE = 5;
    public static final int TIMSTATUS_UNDEFINED = 0;
    public static final int TIMSTATUS_STOP = 1;
    public static final int TIMSTATUS_PLAY = 2;
    public static final int TIMSTATUS_PAUSE = 3;
    public static final int TIMSTATUS_FAST_FORWARD = 4;
    public static final int TIMSTATUS_FAST_BACKWARD = 5;
    public static final int TIMSTATUS_RECORD = 6;
    public static final int TIMPLAYBACKMODE_UNDEFINED = 0;
    public static final int TIMPLAYBACKMODE_STOP = 1;
    public static final int TIMPLAYBACKMODE_PLAY = 2;
    public static final int TIMPLAYBACKMODE_PAUSE = 3;
    public static final int TIMPLAYBACKMODE_FAST_FORWARD = 4;
    public static final int TIMPLAYBACKMODE_FAST_BACKWARD = 5;
    public static final int TIMPLAYBACKMETHODSTATUS_UNDEFINED = 0;
    public static final int TIMPLAYBACKMETHODSTATUS_RUNNING = 1;
    public static final int TIMPLAYBACKMETHODSTATUS_DONE = 2;
    public static final int TIMPLAYBACKMETHODSTATUS_INVALID = 3;
    public static final int TIMPLAYBACKMETHODSTATUS_TIM_NOT_AVAILABLE = 4;
    public static final int TIMRESETTYPE_UNDEFINED = 0;
    public static final int TIMRESETTYPE_TO_DEFAULT = 1;
    public static final int TIMRESETTYPE_ANONYMIZE = 2;
    public static final int TIMAVAILABLE_UNDEFINED = 0;
    public static final int TIMAVAILABLE_NO = 1;
    public static final int TIMAVAILABLE_DEVICE_ONLY = 2;
    public static final int TIMAVAILABLE_YES = 3;
    public static final int RT_PLAYBACK = 1000;
    public static final int RT_RESET = 1002;
    public static final int RT_JUMPPLAYBACK = 1003;
    public static final int RP_PLAYBACK = 2000;

    public void playback(int var1, int var2);

    public void reset(int var1);

    public void jumpPlayback(int var1);
}

