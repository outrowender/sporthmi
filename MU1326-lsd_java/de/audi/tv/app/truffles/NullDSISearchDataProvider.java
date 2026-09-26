/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.truffles;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.search.DSISearchDataProvider;
import org.dsi.ifc.search.DataSet;
import org.dsi.ifc.search.RawDataSet;

public class NullDSISearchDataProvider
extends NullService
implements DSISearchDataProvider {
    public NullDSISearchDataProvider(LogChannel logChannel) {
        super(logChannel, "DSISearchDataProvider");
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void registerProviderSource(int n) {
        this.log();
    }

    @Override
    public void sourceDataAvailabilityChanged(int n, boolean bl) {
        this.log();
    }

    @Override
    public void invalidateAllData(int n) {
        this.log();
    }

    @Override
    public void storeDataSets(int n, DataSet[] dataSetArray, int n2) {
        this.log();
    }

    @Override
    public void deleteDataSet(int n, long l) {
        this.log();
    }

    @Override
    public void storeRawDataSets(int n, RawDataSet[] rawDataSetArray, int n2) {
        this.log();
    }
}

