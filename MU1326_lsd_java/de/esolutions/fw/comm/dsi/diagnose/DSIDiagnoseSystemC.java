/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.diagnose;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIDiagnoseSystemC {
    public void acknowledgeRoutine(int var1, int var2, int var3, int var4) throws MethodException;

    public void resultRoutine(int var1, int var2, int var3, int var4, int var5) throws MethodException;

    public void acknowledgeActuatorTest(int var1, int var2, int var3, int var4, int[] var5, int var6) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

