/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car;

import de.esolutions.fw.comm.asi.hmisync.car.ASIHMISyncCarGenericReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncCarGenericS {
    public void setNotification(ASIHMISyncCarGenericReply var1) throws MethodException;

    public void setNotification(long var1, ASIHMISyncCarGenericReply var3) throws MethodException;

    public void setNotification(long[] var1, ASIHMISyncCarGenericReply var2) throws MethodException;

    public void clearNotification(ASIHMISyncCarGenericReply var1) throws MethodException;

    public void clearNotification(long var1, ASIHMISyncCarGenericReply var3) throws MethodException;

    public void clearNotification(long[] var1, ASIHMISyncCarGenericReply var2) throws MethodException;
}

