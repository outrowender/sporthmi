/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.media.AudioRoute;

public interface DSIMediaRouterC {
    public void registerClient(int var1, String var2, String var3) throws MethodException;

    public void unregisterClient(int var1) throws MethodException;

    public void startStreaming(int var1) throws MethodException;

    public void stopStreaming(int var1) throws MethodException;

    public void requestConfiguration(int var1, int var2, int var3, int var4) throws MethodException;

    public void setAudioRoutes(AudioRoute[] var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

