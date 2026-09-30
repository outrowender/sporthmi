/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.komoview;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.komoview.RouteInfoElement;

public interface DSIKOMOViewC {
    public void enableKomoView(boolean var1) throws MethodException;

    public void notifyVisibility(boolean var1) throws MethodException;

    public void setRouteInfoElement(RouteInfoElement var1) throws MethodException;

    public void setRouteInfo(RouteInfoElement[] var1) throws MethodException;

    public void setKomoViewStyle(int var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

