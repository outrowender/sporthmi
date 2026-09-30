/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.predictivenavigation;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.NavLocation;

public interface DSIPredictiveNavigationC {
    public void setOperationMode(int var1) throws MethodException;

    public void setMaxPredictions(int var1) throws MethodException;

    public void clearCache() throws MethodException;

    public void clearCacheByDestination(NavLocation var1, int var2) throws MethodException;

    public void clearCacheByAge(long var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

