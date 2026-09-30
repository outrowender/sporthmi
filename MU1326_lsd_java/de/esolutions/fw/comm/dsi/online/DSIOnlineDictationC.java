/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIOnlineDictationC {
    public void stopDictation() throws MethodException;

    public void setFallbackLanguage(String var1) throws MethodException;

    public void setLanguage(String var1) throws MethodException;

    public void activateDictation() throws MethodException;

    public void startDictation(String var1, String var2, String var3, String var4) throws MethodException;

    public void finishDictation() throws MethodException;

    public void rawVoiceDataAvailable(String var1, int var2) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

