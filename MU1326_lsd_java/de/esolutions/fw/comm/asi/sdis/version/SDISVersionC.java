/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdis.version;

import de.esolutions.fw.comm.core.method.MethodException;

public interface SDISVersionC {
    public void setNotification() throws MethodException;

    public void setNotification(long var1) throws MethodException;

    public void setNotification(long[] var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void clearNotification(long var1) throws MethodException;

    public void clearNotification(long[] var1) throws MethodException;
}

