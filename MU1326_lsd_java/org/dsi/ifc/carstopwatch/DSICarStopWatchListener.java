/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carstopwatch;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carstopwatch.StopWatchTime;
import org.dsi.ifc.carstopwatch.StopWatchViewOptions;

public interface DSICarStopWatchListener
extends DSIListener {
    public void updateStopWatchViewOptions(StopWatchViewOptions var1, int var2);

    public void updateStopWatchState(int var1, int var2);

    public void updateStopWatchCurrentLapNumber(int var1, int var2);

    public void updateStopWatchTotalTime(StopWatchTime var1, int var2);

    public void updateStopWatchLastSplitTime(int var1, StopWatchTime var2, int var3);

    public void updateStopWatchCurrentLapTime(StopWatchTime var1, int var2);

    public void updateStopWatchLastLapTime(StopWatchTime var1, int var2);
}

