/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.mastercontrol;

import de.esolutions.fw.comm.asi.hmisync.mastercontrol.ASIHMISyncMasterControlReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncMasterControlS {
    public void setNotification(ASIHMISyncMasterControlReply var1) throws MethodException;

    public void setNotification(long var1, ASIHMISyncMasterControlReply var3) throws MethodException;

    public void setNotification(long[] var1, ASIHMISyncMasterControlReply var2) throws MethodException;

    public void clearNotification(ASIHMISyncMasterControlReply var1) throws MethodException;

    public void clearNotification(long var1, ASIHMISyncMasterControlReply var3) throws MethodException;

    public void clearNotification(long[] var1, ASIHMISyncMasterControlReply var2) throws MethodException;
}

