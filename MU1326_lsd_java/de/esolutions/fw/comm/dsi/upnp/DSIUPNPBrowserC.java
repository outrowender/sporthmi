/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.upnp;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.upnp.ListEntry;

public interface DSIUPNPBrowserC {
    public void changeFolder(ListEntry[] var1) throws MethodException;

    public void requestList(String var1, int var2, int var3, int var4) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

