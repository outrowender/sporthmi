/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio;

import de.esolutions.fw.comm.asi.hmisync.radio.ASIHMISyncRadioReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncRadioS {
    public void selectStation(long var1, ASIHMISyncRadioReply var3) throws MethodException;

    public void selectBand(int var1, ASIHMISyncRadioReply var2) throws MethodException;

    public void seekStation(int var1, ASIHMISyncRadioReply var2) throws MethodException;

    public void enableStationDetails(boolean var1, ASIHMISyncRadioReply var2) throws MethodException;

    public void setNotification(ASIHMISyncRadioReply var1) throws MethodException;

    public void setNotification(long var1, ASIHMISyncRadioReply var3) throws MethodException;

    public void setNotification(long[] var1, ASIHMISyncRadioReply var2) throws MethodException;

    public void clearNotification(ASIHMISyncRadioReply var1) throws MethodException;

    public void clearNotification(long var1, ASIHMISyncRadioReply var3) throws MethodException;

    public void clearNotification(long[] var1, ASIHMISyncRadioReply var2) throws MethodException;
}

