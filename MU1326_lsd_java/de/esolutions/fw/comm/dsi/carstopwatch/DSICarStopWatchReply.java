/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carstopwatch;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.carstopwatch.StopWatchTime;
import org.dsi.ifc.carstopwatch.StopWatchViewOptions;

public interface DSICarStopWatchReply {
    public static final String IPL_COMM_UUID = "f4b74ed2-d785-568f-a5bb-7fbdc376e935";
    public static final String IPL_COMM_INTERFACE_KEY = "e4ecd900-215e-5ff5-8922-d8a027e6819b";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.3";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.3";

    public void updateStopWatchViewOptions(StopWatchViewOptions var1, int var2) throws MethodException;

    public void updateStopWatchState(int var1, int var2) throws MethodException;

    public void updateStopWatchCurrentLapNumber(int var1, int var2) throws MethodException;

    public void updateStopWatchTotalTime(StopWatchTime var1, int var2) throws MethodException;

    public void updateStopWatchLastSplitTime(int var1, StopWatchTime var2, int var3) throws MethodException;

    public void updateStopWatchCurrentLapTime(StopWatchTime var1, int var2) throws MethodException;

    public void updateStopWatchLastLapTime(StopWatchTime var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

