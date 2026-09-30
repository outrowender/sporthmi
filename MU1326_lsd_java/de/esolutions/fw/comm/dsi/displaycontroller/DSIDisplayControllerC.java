/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.displaycontroller;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIDisplayControllerC {
    public void switchDisplayPower(int var1, int var2, int var3) throws MethodException;

    public void setDisplayBrightness(int var1, int var2) throws MethodException;

    public void getDisplayBrightness(int var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

