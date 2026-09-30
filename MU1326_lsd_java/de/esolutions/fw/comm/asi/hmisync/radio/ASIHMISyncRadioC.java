/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio;

import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncRadioC {
    public void selectStation(long var1) throws MethodException;

    public void selectBand(int var1) throws MethodException;

    public void seekStation(int var1) throws MethodException;

    public void enableStationDetails(boolean var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void setNotification(long var1) throws MethodException;

    public void setNotification(long[] var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void clearNotification(long var1) throws MethodException;

    public void clearNotification(long[] var1) throws MethodException;
}

