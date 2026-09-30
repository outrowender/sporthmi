/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carstopwatch;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.carstopwatch.StopWatchTime;

public interface DSICarStopWatchC {
    public void setStopWatchFastestLapTime(StopWatchTime var1) throws MethodException;

    public void setStopWatchLapRating(int var1) throws MethodException;

    public void setStopWatchLapProgress(float var1) throws MethodException;

    public void setStopWatchLapGPSTrigger() throws MethodException;

    public void setStopWatchControl(int var1) throws MethodException;

    public void setStopWatchSlowestLapTime(StopWatchTime var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

