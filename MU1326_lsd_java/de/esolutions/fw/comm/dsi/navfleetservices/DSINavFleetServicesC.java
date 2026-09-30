/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navfleetservices;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSINavFleetServicesC {
    public void setVZOTrackerState(int var1) throws MethodException;

    public void setVZODownloadState(int var1) throws MethodException;

    public void setLGITrackerState(int var1) throws MethodException;

    public void setLGIDownloadState(int var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

