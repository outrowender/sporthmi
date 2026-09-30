/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.climate;

import de.esolutions.fw.comm.asi.hmisync.car.climate.ASIHMISyncCarClimateReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncCarClimateS {
    public void setAirconAC(boolean var1, ASIHMISyncCarClimateReply var2) throws MethodException;

    public void setNotification(ASIHMISyncCarClimateReply var1) throws MethodException;

    public void setNotification(long var1, ASIHMISyncCarClimateReply var3) throws MethodException;

    public void setNotification(long[] var1, ASIHMISyncCarClimateReply var2) throws MethodException;

    public void clearNotification(ASIHMISyncCarClimateReply var1) throws MethodException;

    public void clearNotification(long var1, ASIHMISyncCarClimateReply var3) throws MethodException;

    public void clearNotification(long[] var1, ASIHMISyncCarClimateReply var2) throws MethodException;
}

