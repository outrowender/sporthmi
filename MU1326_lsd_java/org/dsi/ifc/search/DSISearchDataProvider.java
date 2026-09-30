/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.search;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.search.DataSet;
import org.dsi.ifc.search.RawDataSet;

public interface DSISearchDataProvider
extends DSIBase {
    public static final String VERSION = "2.11.25";
    public static final int RP_REGISTERPROVIDERSOURCERESULT = 2000;
    public static final int RP_INVALIDATEALLDATARESULT = 2001;
    public static final int RP_STOREDATASETSRESULT = 2002;
    public static final int RP_DELETEDATASETRESULT = 2003;
    public static final int IN_ACTIVATEPROVIDERSOURCE = 3001;
    public static final int IN_PROVIDEDATA = 3002;
    public static final int RT_REGISTERPROVIDERSOURCE = 1001;
    public static final int RT_INVALIDATEALLDATA = 1002;
    public static final int RT_STOREDATASETS = 1003;
    public static final int RT_DELETEDATASET = 1004;
    public static final int RT_SOURCEDATAAVAILABILITYCHANGED = 1005;
    public static final int RT_STORERAWDATASETS = 1006;

    public void registerProviderSource(int var1);

    public void sourceDataAvailabilityChanged(int var1, boolean var2);

    public void invalidateAllData(int var1);

    public void storeDataSets(int var1, DataSet[] var2, int var3);

    public void storeRawDataSets(int var1, RawDataSet[] var2, int var3);

    public void deleteDataSet(int var1, long var2);
}

