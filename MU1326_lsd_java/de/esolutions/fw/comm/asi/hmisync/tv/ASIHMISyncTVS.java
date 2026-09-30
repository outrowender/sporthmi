/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv;

import de.esolutions.fw.comm.asi.hmisync.tv.ASIHMISyncTVReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncTVS {
    public void setActiveStation(long var1, ASIHMISyncTVReply var3) throws MethodException;

    public void logonToTV(ASIHMISyncTVReply var1) throws MethodException;

    public void logoffFromTV(ASIHMISyncTVReply var1) throws MethodException;

    public void sendPressedPanelKey(byte var1, ASIHMISyncTVReply var2) throws MethodException;

    public void searchChannel(byte var1, ASIHMISyncTVReply var2) throws MethodException;

    public void setTerminalMode(byte var1, ASIHMISyncTVReply var2) throws MethodException;

    public void setNotification(ASIHMISyncTVReply var1) throws MethodException;

    public void setNotification(long var1, ASIHMISyncTVReply var3) throws MethodException;

    public void setNotification(long[] var1, ASIHMISyncTVReply var2) throws MethodException;

    public void clearNotification(ASIHMISyncTVReply var1) throws MethodException;

    public void clearNotification(long var1, ASIHMISyncTVReply var3) throws MethodException;

    public void clearNotification(long[] var1, ASIHMISyncTVReply var2) throws MethodException;
}

