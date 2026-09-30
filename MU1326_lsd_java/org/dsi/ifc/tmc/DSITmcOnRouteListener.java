/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tmc;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.SpeedAndFlowSegment;
import org.dsi.ifc.tmc.TmcMessage;

public interface DSITmcOnRouteListener
extends DSIListener {
    public void updateTmcMessagesAhead(TmcMessage[] var1, int var2);

    public void updateUrgentMessages(TmcMessage[] var1, int var2);

    public void tmcMessage(TmcMessage var1);

    public void updateTmcMessagesAheadCalculationHorizon(long var1, int var3);

    public void setTmcWarningModeResult(int var1);

    public void updateCurrentlyBlockedTMCMessages(long[] var1, int var2);

    public void blockTMCMessagesResult(long[] var1, long[] var2);

    public void unblockTMCMessagesResult(long[] var1, long[] var2);

    public void unblockAllTMCMessagesResult(int var1);

    public void updateNaviCoreAvailableToChangeTMCBlockings(int var1, int var2);

    public void indicateTrafficEventNoticeMap(TmcMessage var1, NavRectangle var2, int var3);

    public void updateSpeedAndFlowAhead(SpeedAndFlowSegment[] var1, int var2);
}

