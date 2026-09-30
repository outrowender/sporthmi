/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.upnp;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.upnp.ListEntry;

public interface DSIUPNPPlayerC {
    public void setPlaybackMode(String var1, int var2) throws MethodException;

    public void setEntry(String[] var1, String var2, ListEntry[] var3, int var4) throws MethodException;

    public void resume(String var1) throws MethodException;

    public void pause(String var1) throws MethodException;

    public void skip(String var1, int var2, int var3) throws MethodException;

    public void seek(String var1, int var2, int var3) throws MethodException;

    public void increaseVolume(String var1) throws MethodException;

    public void decreaseVolume(String var1) throws MethodException;

    public void setVolume(String var1, int var2) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

