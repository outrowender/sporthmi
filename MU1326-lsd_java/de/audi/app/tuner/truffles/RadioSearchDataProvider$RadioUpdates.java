/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import de.audi.app.tuner.truffles.RadioSearchDataProvider;
import de.audi.app.tuner.truffles.RadioSearchDataProvider$1;
import de.audi.app.tuner.truffles.SearchUtil;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.sds.DefaultUpdateListener;
import de.esolutions.fw.util.commons.SimpleIntIntMap;

class RadioSearchDataProvider$RadioUpdates
extends DefaultUpdateListener
implements IUpdateListener {
    private final /* synthetic */ RadioSearchDataProvider this$0;

    private RadioSearchDataProvider$RadioUpdates(RadioSearchDataProvider radioSearchDataProvider) {
        this.this$0 = radioSearchDataProvider;
    }

    @Override
    public void updatedBandList(int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            RadioSearchDataProvider.access$200(this.this$0).registerProviderSource(SearchUtil.getSourceByBand(nArray[i2]));
        }
    }

    @Override
    public void updatedMemoryList() {
        RadioSearchDataProvider.access$300((RadioSearchDataProvider)this.this$0).truffles.log(-2137614336, "[RadioSearchDataProvider.updatedMemoryList] invalidate data for favorites]");
        this.invalidate(20017);
    }

    @Override
    public void updatedStationList(int n) {
        RadioSearchDataProvider.access$300((RadioSearchDataProvider)this.this$0).truffles.log(-2137614336, "[RadioSearchDataProvider.updatedStationList] invalidate data for band %1]", (long)n);
        this.invalidate(SearchUtil.getSourceByBand(n));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void invalidate(int n) {
        SimpleIntIntMap simpleIntIntMap = RadioSearchDataProvider.access$400(this.this$0);
        synchronized (simpleIntIntMap) {
            if (RadioSearchDataProvider.access$500(this.this$0)) {
                RadioSearchDataProvider.access$400(this.this$0).add(n, n);
            } else {
                RadioSearchDataProvider.access$600(this.this$0, n);
            }
        }
    }

    /* synthetic */ RadioSearchDataProvider$RadioUpdates(RadioSearchDataProvider radioSearchDataProvider, RadioSearchDataProvider$1 radioSearchDataProvider$1) {
        this(radioSearchDataProvider);
    }
}

