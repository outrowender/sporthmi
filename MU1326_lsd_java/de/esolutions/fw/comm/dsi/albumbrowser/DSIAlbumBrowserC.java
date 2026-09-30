/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.albumbrowser;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIAlbumBrowserC {
    public void initializeBrowser(long var1, long var3, int var5) throws MethodException;

    public void deinitializeBrowser() throws MethodException;

    public void startSingle() throws MethodException;

    public void startPreview() throws MethodException;

    public void startActive() throws MethodException;

    public void stop() throws MethodException;

    public void setScrollMode(int var1) throws MethodException;

    public void scrollTicks(long var1) throws MethodException;

    public void selectAlbum(long var1) throws MethodException;

    public void moveFocus(long var1, int var3) throws MethodException;

    public void albumIdxForFID(long var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

