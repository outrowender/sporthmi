/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdis.version;

import de.esolutions.fw.comm.asi.sdis.version.SDISVersionReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface SDISVersionS {
    public void setNotification(SDISVersionReply var1) throws MethodException;

    public void setNotification(long var1, SDISVersionReply var3) throws MethodException;

    public void setNotification(long[] var1, SDISVersionReply var2) throws MethodException;

    public void clearNotification(SDISVersionReply var1) throws MethodException;

    public void clearNotification(long var1, SDISVersionReply var3) throws MethodException;

    public void clearNotification(long[] var1, SDISVersionReply var2) throws MethodException;
}

