/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.generic;

import de.esolutions.fw.comm.asi.hmisync.generic.ASIHMISyncGenericReply;
import de.esolutions.fw.comm.asi.hmisync.generic.GenericPacket;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncGenericS {
    public void sendDataToUnit(GenericPacket var1, ASIHMISyncGenericReply var2) throws MethodException;

    public void setNotification(ASIHMISyncGenericReply var1) throws MethodException;

    public void setNotification(long var1, ASIHMISyncGenericReply var3) throws MethodException;

    public void setNotification(long[] var1, ASIHMISyncGenericReply var2) throws MethodException;

    public void clearNotification(ASIHMISyncGenericReply var1) throws MethodException;

    public void clearNotification(long var1, ASIHMISyncGenericReply var3) throws MethodException;

    public void clearNotification(long[] var1, ASIHMISyncGenericReply var2) throws MethodException;
}

