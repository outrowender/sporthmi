/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.map.Rect;

public interface DSIMapViewerGoogleCtrlC {
    public void requestClearCache() throws MethodException;

    public void setLanguage(String var1) throws MethodException;

    public void setLayerVisibility(int[] var1) throws MethodException;

    public void setConnectionInformation(int var1) throws MethodException;

    public void loadKml(String[] var1) throws MethodException;

    public void setCopyrightPosition(Rect var1, int var2, int var3) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

