/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIBrowserBoardbookC {
    public void startBoardbook(int var1, String var2) throws MethodException;

    public void setLanguage(String var1) throws MethodException;

    public void openPage(int var1) throws MethodException;

    public void search(String var1, int var2) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

