/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.search.DataSet;
import org.dsi.ifc.search.RawDataSet;

public interface DSISearchDataProviderC {
    public void registerProviderSource(int var1) throws MethodException;

    public void sourceDataAvailabilityChanged(int var1, boolean var2) throws MethodException;

    public void invalidateAllData(int var1) throws MethodException;

    public void storeDataSets(int var1, DataSet[] var2, int var3) throws MethodException;

    public void storeRawDataSets(int var1, RawDataSet[] var2, int var3) throws MethodException;

    public void deleteDataSet(int var1, long var2) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

