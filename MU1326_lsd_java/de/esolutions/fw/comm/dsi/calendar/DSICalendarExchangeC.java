/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.ResourceLocator;

public interface DSICalendarExchangeC {
    public void parseICal(String var1) throws MethodException;

    public void parseICalDirectory(String var1) throws MethodException;

    public void exportICal(int var1, int var2, long[] var3, int var4) throws MethodException;

    public void importICal(ResourceLocator[] var1) throws MethodException;

    public void abortExport() throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

