/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIMapViewerManeuverViewC {
    public void hideManoeuvreView() throws MethodException;

    public void selectManoeuvreView(int var1, boolean var2) throws MethodException;

    public void setDistanceString(String var1) throws MethodException;

    public void disableManeuverViewGeneration(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

