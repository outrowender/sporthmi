/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.tghu.navi.app.navlocationextractor.NavLocationsCache;
import java.util.LinkedHashMap;
import java.util.Map$Entry;

class NavLocationsCache$1
extends LinkedHashMap {
    private final /* synthetic */ NavLocationsCache this$0;

    NavLocationsCache$1(NavLocationsCache navLocationsCache, int n, float f2, boolean bl) {
        this.this$0 = navLocationsCache;
        super(n, f2, bl);
    }

    @Override
    public boolean removeEldestEntry(Map$Entry map$Entry) {
        return this.size() > 32;
    }
}

