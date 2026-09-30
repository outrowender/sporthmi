/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.keypanel;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIKeyPanelC {
    public void setIllumination(int var1, int var2, int var3) throws MethodException;

    public void setHapticFeedback(int var1, int var2, int var3) throws MethodException;

    public void setTMDisplayState(boolean var1) throws MethodException;

    public void setRecognizerLanguage(int var1, String var2) throws MethodException;

    public void setRecognizerLanguage2(int var1, String var2, int var3) throws MethodException;

    public void setRecognizerMode(int var1, int var2) throws MethodException;

    public void clearRecognizer(int var1) throws MethodException;

    public void setGenericSetting(int var1, int var2, int var3) throws MethodException;

    public void resetDevice(int var1) throws MethodException;

    public void requestGenericSetting(int var1, int var2) throws MethodException;

    public void requestLastKey(int var1) throws MethodException;

    public void getVersionInfo(int var1, int var2) throws MethodException;

    public void setTouchSensitiveArea(int var1, int var2, int var3, int var4, int var5) throws MethodException;

    public void getProperty(int var1, int var2, int var3) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

