/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carstopwatch;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carstopwatch.StopWatchTime;

public interface DSICarStopWatch
extends DSIBase {
    public static final String VERSION = "2.11.3";
    public static final int ATTR_STOPWATCHVIEWOPTIONS = 1;
    public static final int ATTR_STOPWATCHSTATE = 2;
    public static final int ATTR_STOPWATCHCURRENTLAPNUMBER = 3;
    public static final int ATTR_STOPWATCHTOTALTIME = 4;
    public static final int ATTR_STOPWATCHLASTSPLITTIME = 5;
    public static final int ATTR_STOPWATCHCURRENTLAPTIME = 6;
    public static final int ATTR_STOPWATCHLASTLAPTIME = 7;
    public static final int RT_SETSTOPWATCHFASTESTLAPTIME = 1000;
    public static final int RT_SETSTOPWATCHLAPRATING = 1001;
    public static final int RT_SETSTOPWATCHLAPPROGRESS = 1002;
    public static final int RT_SETSTOPWATCHLAPGPSTRIGGER = 1003;
    public static final int RT_SETSTOPWATCHCONTROL = 1004;
    public static final int RT_SETSTOPWATCHSLOWESTLAPTIME = 1005;
    public static final int STOPWATCHLAPRATING_NOT_ACTIVE = 0;
    public static final int STOPWATCHLAPRATING_SLOWER = 1;
    public static final int STOPWATCHLAPRATING_SAME_PACE = 2;
    public static final int STOPWATCHLAPRATING_FASTER = 3;
    public static final int STOPWATCHLAPRATING_INIT = 14;
    public static final int STOPWATCHLAPRATING_NOT_SUPPORTED = 15;
    public static final int STOPWATCHCOMMAND_INIT = 0;
    public static final int STOPWATCHCOMMAND_START = 1;
    public static final int STOPWATCHCOMMAND_START_MOVING_VEHICLE = 2;
    public static final int STOPWATCHCOMMAND_STOP = 3;
    public static final int STOPWATCHCOMMAND_CONTINUE = 4;
    public static final int STOPWATCHCOMMAND_RESET = 5;
    public static final int STOPWATCHCOMMAND_SPLITTIME = 6;
    public static final int STOPWATCHCOMMAND_LAPTIME = 7;
    public static final int STOPWATCHSTATE_INIT = 0;
    public static final int STOPWATCHSTATE_RUNNING = 1;
    public static final int STOPWATCHSTATE_NOT_RUNNING = 2;
    public static final int STOPWATCHSTATE_NOT_RUNNING_RESET = 3;
    public static final int STOPWATCHSTATE_NOT_RUNNING_NO_RESET = 4;

    public void setStopWatchFastestLapTime(StopWatchTime var1);

    public void setStopWatchLapRating(int var1);

    public void setStopWatchLapProgress(float var1);

    public void setStopWatchLapGPSTrigger();

    public void setStopWatchControl(int var1);

    public void setStopWatchSlowestLapTime(StopWatchTime var1);
}

