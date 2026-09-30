/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.instance;

import de.esolutions.fw.comm.asi.hmisync.instance.ASIHMISyncInstanceReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncInstanceS {
    public void requestInstanceId(String var1, String var2, ASIHMISyncInstanceReply var3) throws MethodException;

    public void setNotification(ASIHMISyncInstanceReply var1) throws MethodException;

    public void setNotification(long var1, ASIHMISyncInstanceReply var3) throws MethodException;

    public void setNotification(long[] var1, ASIHMISyncInstanceReply var2) throws MethodException;

    public void clearNotification(ASIHMISyncInstanceReply var1) throws MethodException;

    public void clearNotification(long var1, ASIHMISyncInstanceReply var3) throws MethodException;

    public void clearNotification(long[] var1, ASIHMISyncInstanceReply var2) throws MethodException;
}

