/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service;

import de.esolutions.fw.comm.asi.hmisync.car.service.ASIHMISyncCarServiceReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncCarServiceS {
    public void setNotification(ASIHMISyncCarServiceReply var1) throws MethodException;

    public void setNotification(long var1, ASIHMISyncCarServiceReply var3) throws MethodException;

    public void setNotification(long[] var1, ASIHMISyncCarServiceReply var2) throws MethodException;

    public void clearNotification(ASIHMISyncCarServiceReply var1) throws MethodException;

    public void clearNotification(long var1, ASIHMISyncCarServiceReply var3) throws MethodException;

    public void clearNotification(long[] var1, ASIHMISyncCarServiceReply var2) throws MethodException;
}

