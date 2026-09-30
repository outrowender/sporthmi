/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSICallStacksC {
    public void deleteAll(int var1) throws MethodException;

    public void deleteEntry(int var1, int var2) throws MethodException;

    public void resetMissedCallIndicator() throws MethodException;

    public void revertCallstacks(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

