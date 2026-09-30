/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.driving;

import de.esolutions.fw.comm.asi.hmisync.car.driving.ASIHMISyncCarDrivingReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncCarDrivingS {
    public void setNotification(ASIHMISyncCarDrivingReply var1) throws MethodException;

    public void setNotification(long var1, ASIHMISyncCarDrivingReply var3) throws MethodException;

    public void setNotification(long[] var1, ASIHMISyncCarDrivingReply var2) throws MethodException;

    public void clearNotification(ASIHMISyncCarDrivingReply var1) throws MethodException;

    public void clearNotification(long var1, ASIHMISyncCarDrivingReply var3) throws MethodException;

    public void clearNotification(long[] var1, ASIHMISyncCarDrivingReply var2) throws MethodException;
}

