/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search.dsi;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.search.DSISearchDataProvider;
import org.dsi.ifc.search.DataSet;
import org.dsi.ifc.search.RawDataSet;

public class NullDSISearchDataProvider
implements DSISearchDataProvider {
    public void setNotification(int[] nArray, DSIListener dSIListener) {
    }

    public void setNotification(int n, DSIListener dSIListener) {
    }

    public void setNotification(DSIListener dSIListener) {
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
    }

    public void clearNotification(int n, DSIListener dSIListener) {
    }

    public void clearNotification(DSIListener dSIListener) {
    }

    public void registerProviderSource(int n) {
    }

    public void sourceDataAvailabilityChanged(int n, boolean bl) {
    }

    public void invalidateAllData(int n) {
    }

    public void storeDataSets(int n, DataSet[] dataSetArray, int n2) {
    }

    public void deleteDataSet(int n, long l) {
    }

    public void storeRawDataSets(int n, RawDataSet[] rawDataSetArray, int n2) {
    }
}

