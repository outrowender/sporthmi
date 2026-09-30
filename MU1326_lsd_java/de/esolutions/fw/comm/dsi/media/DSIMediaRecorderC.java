/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIMediaRecorderC {
    public void setActiveMedia(long var1, long var3) throws MethodException;

    public void setSelection(int var1) throws MethodException;

    public void startImport(boolean var1) throws MethodException;

    public void abortImport() throws MethodException;

    public void startDelete() throws MethodException;

    public void abortDelete() throws MethodException;

    public void setTargetMedia(long var1, long var3) throws MethodException;

    public void setEncodingQuality(int var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

