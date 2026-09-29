/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search.dsi;

import de.audi.app.media.dsi.IDSIController;
import de.audi.app.media.evo.content.data.search.dsi.IMediaSearchDataProviderListener;
import org.dsi.ifc.search.DataSet;

public interface IMediaDSISearchDataController
extends IDSIController {
    default public void setMediaSearchDataProviderListener(IMediaSearchDataProviderListener iMediaSearchDataProviderListener) {
    }

    default public void registerProviderSource(int n) {
    }

    default public void sourceDataAvailabilityChanged(int n, boolean bl) {
    }

    default public void invalidateAllData(int n) {
    }

    default public void storeDataSets(int n, DataSet[] dataSetArray, int n2) {
    }

    default public void deleteDataSet(int n, long l) {
    }
}

