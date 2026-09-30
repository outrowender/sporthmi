/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIAdbVCardExchangeC {
    public void importVCard(ResourceLocator[] var1, int var2) throws MethodException;

    public void exportVCard(int var1, String var2, long[] var3, int var4) throws MethodException;

    public void exportSpellerVCard(int var1, int var2, String var3, long[] var4, int var5) throws MethodException;

    public void createVCard(int var1, long[] var2, int var3) throws MethodException;

    public void parseVCard(String var1) throws MethodException;

    public void requestAbort(int var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

