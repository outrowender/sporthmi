/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.zeroemission;

import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmissionReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncCarZeroEmissionS {
    public void setNotification(ASIHMISyncCarZeroEmissionReply var1) throws MethodException;

    public void setNotification(long var1, ASIHMISyncCarZeroEmissionReply var3) throws MethodException;

    public void setNotification(long[] var1, ASIHMISyncCarZeroEmissionReply var2) throws MethodException;

    public void clearNotification(ASIHMISyncCarZeroEmissionReply var1) throws MethodException;

    public void clearNotification(long var1, ASIHMISyncCarZeroEmissionReply var3) throws MethodException;

    public void clearNotification(long[] var1, ASIHMISyncCarZeroEmissionReply var2) throws MethodException;
}

