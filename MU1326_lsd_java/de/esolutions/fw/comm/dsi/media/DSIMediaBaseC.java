/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIMediaBaseC {
    public void setPreferredLanguage(String var1) throws MethodException;

    public void setParentalML(int var1) throws MethodException;

    public void ejectMedium(long var1, long var3) throws MethodException;

    public void requestResetFactorySettings(int var1) throws MethodException;

    public void launchApp(long var1, long var3, String var5) throws MethodException;

    public void profileChange(int var1) throws MethodException;

    public void profileCopy(int var1, int var2) throws MethodException;

    public void profileReset(int var1) throws MethodException;

    public void profileResetAll() throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

