/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIAdbListC {
    public void startSpeller(int var1, int var2, int var3) throws MethodException;

    public void stopSpeller(int var1) throws MethodException;

    public void addSpellerChars(int var1, String var2) throws MethodException;

    public void addSpellerStroke(int var1, String var2) throws MethodException;

    public void removeSpellerChar(int var1) throws MethodException;

    public void validateSpellerChars(int var1, String var2) throws MethodException;

    public void getViewWindow(long var1, int var3, int var4, int var5) throws MethodException;

    public void getSpellerViewWindow(int var1, long var2, int var4, int var5, int var6) throws MethodException;

    public void getValidHanziCharsWindow(int var1, int var2, int var3) throws MethodException;

    public void setListStyle(int var1, int var2, int var3) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

