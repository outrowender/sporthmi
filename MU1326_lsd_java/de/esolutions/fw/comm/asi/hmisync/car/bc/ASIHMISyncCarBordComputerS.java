/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.bc;

import de.esolutions.fw.comm.asi.hmisync.car.bc.ASIHMISyncCarBordComputerReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncCarBordComputerS {
    public void setNotification(ASIHMISyncCarBordComputerReply var1) throws MethodException;

    public void setNotification(long var1, ASIHMISyncCarBordComputerReply var3) throws MethodException;

    public void setNotification(long[] var1, ASIHMISyncCarBordComputerReply var2) throws MethodException;

    public void clearNotification(ASIHMISyncCarBordComputerReply var1) throws MethodException;

    public void clearNotification(long var1, ASIHMISyncCarBordComputerReply var3) throws MethodException;

    public void clearNotification(long[] var1, ASIHMISyncCarBordComputerReply var2) throws MethodException;
}

