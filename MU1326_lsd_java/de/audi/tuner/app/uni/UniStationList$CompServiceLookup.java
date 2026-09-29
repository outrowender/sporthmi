/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.tuner.app.uni.UniStationList;
import java.util.List;

public class UniStationList$CompServiceLookup {
    private final /* synthetic */ UniStationList this$0;

    protected UniStationList$CompServiceLookup(UniStationList uniStationList) {
        this.this$0 = uniStationList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getServiceName(int n) {
        List list = UniStationList.access$600(this.this$0);
        synchronized (list) {
            for (int i2 = 0; i2 < UniStationList.access$1100(this.this$0).length; ++i2) {
                if (UniStationList.access$1100((UniStationList)this.this$0)[i2].piSId != n || UniStationList.access$1100((UniStationList)this.this$0)[i2].sCIDI != 0) continue;
                return UniStationList.access$1100(this.this$0)[i2].getName(true);
            }
        }
        UniStationList.access$1700((UniStationList)this.this$0).uniList.log(10000, "[UniStationList.getServiceName] service missing pi: %1", (long)n);
        return "";
    }
}

