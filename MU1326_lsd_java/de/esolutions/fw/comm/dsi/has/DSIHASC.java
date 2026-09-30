/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.has;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.has.HASDataContainer;

public interface DSIHASC {
    public void hmiReady() throws MethodException;

    public void actionResult(int var1, int var2, HASDataContainer[] var3, int var4) throws MethodException;

    public void propertyUpdate(int var1, HASDataContainer[] var2, int var3) throws MethodException;

    public void subscribeResult(int var1, int var2) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

