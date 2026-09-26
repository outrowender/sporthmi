/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.tghu.navi.app.navlocationextractor.NavLocationsCache$1;
import de.audi.tghu.navi.app.search.TryMatchLocationDataHmiWrapper;
import java.util.Iterator;
import java.util.Map;
import org.dsi.ifc.navigation.TryMatchLocationData;
import org.dsi.ifc.navigation.TryMatchLocationResultData;

public class NavLocationsCache {
    public static final int MAX_ENTRIES;
    Map cache = new NavLocationsCache$1(this, 33, 16447, true);

    public synchronized TryMatchLocationResultData[] getCachedData(TryMatchLocationData tryMatchLocationData) {
        Iterator iterator = this.cache.keySet().iterator();
        TryMatchLocationDataHmiWrapper tryMatchLocationDataHmiWrapper = new TryMatchLocationDataHmiWrapper(tryMatchLocationData);
        while (iterator.hasNext()) {
            Object object = iterator.next();
            TryMatchLocationDataHmiWrapper tryMatchLocationDataHmiWrapper2 = (TryMatchLocationDataHmiWrapper)object;
            if (!tryMatchLocationDataHmiWrapper.equals(tryMatchLocationDataHmiWrapper2)) continue;
            return (TryMatchLocationResultData[])this.cache.get(object);
        }
        return new TryMatchLocationResultData[0];
    }

    public synchronized void saveResponse(TryMatchLocationResultData[] tryMatchLocationResultDataArray, TryMatchLocationData tryMatchLocationData) {
        this.cache.put(new TryMatchLocationDataHmiWrapper(tryMatchLocationData), tryMatchLocationResultDataArray);
    }
}

