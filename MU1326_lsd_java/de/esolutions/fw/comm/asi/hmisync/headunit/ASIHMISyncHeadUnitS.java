/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit;

import de.esolutions.fw.comm.asi.hmisync.headunit.ASIHMISyncHeadUnitReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncHeadUnitS {
    public void setNotification(ASIHMISyncHeadUnitReply var1) throws MethodException;

    public void setNotification(long var1, ASIHMISyncHeadUnitReply var3) throws MethodException;

    public void setNotification(long[] var1, ASIHMISyncHeadUnitReply var2) throws MethodException;

    public void clearNotification(ASIHMISyncHeadUnitReply var1) throws MethodException;

    public void clearNotification(long var1, ASIHMISyncHeadUnitReply var3) throws MethodException;

    public void clearNotification(long[] var1, ASIHMISyncHeadUnitReply var2) throws MethodException;
}

