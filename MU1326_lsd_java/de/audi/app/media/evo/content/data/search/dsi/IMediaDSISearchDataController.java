/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search.dsi;

import de.audi.app.media.dsi.IDSIController;
import de.audi.app.media.evo.content.data.search.dsi.IMediaSearchDataProviderListener;
import org.dsi.ifc.search.DataSet;

public interface IMediaDSISearchDataController
extends IDSIController {
    public void setMediaSearchDataProviderListener(IMediaSearchDataProviderListener var1);

    public void registerProviderSource(int var1);

    public void sourceDataAvailabilityChanged(int var1, boolean var2);

    public void invalidateAllData(int var1);

    public void storeDataSets(int var1, DataSet[] var2, int var3);

    public void deleteDataSet(int var1, long var2);
}

