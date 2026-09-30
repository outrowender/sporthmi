/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tmc;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.SpeedAndFlowSegment;
import org.dsi.ifc.tmc.TmcMessage;

public interface DSITmcOnRouteReply {
    public static final String IPL_COMM_UUID = "74c79aa7-6bd4-5d66-bfac-0d53682158d8";
    public static final String IPL_COMM_INTERFACE_KEY = "5312e8a6-d68e-5264-81aa-0d1a74b1e2c9";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.36";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.36";

    public void updateTmcMessagesAhead(TmcMessage[] var1, int var2) throws MethodException;

    public void updateUrgentMessages(TmcMessage[] var1, int var2) throws MethodException;

    public void tmcMessage(TmcMessage var1) throws MethodException;

    public void updateTmcMessagesAheadCalculationHorizon(long var1, int var3) throws MethodException;

    public void setTmcWarningModeResult(int var1) throws MethodException;

    public void updateCurrentlyBlockedTMCMessages(long[] var1, int var2) throws MethodException;

    public void blockTMCMessagesResult(long[] var1, long[] var2) throws MethodException;

    public void unblockTMCMessagesResult(long[] var1, long[] var2) throws MethodException;

    public void unblockAllTMCMessagesResult(int var1) throws MethodException;

    public void updateNaviCoreAvailableToChangeTMCBlockings(int var1, int var2) throws MethodException;

    public void indicateTrafficEventNoticeMap(TmcMessage var1, NavRectangle var2, int var3) throws MethodException;

    public void updateSpeedAndFlowAhead(SpeedAndFlowSegment[] var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

