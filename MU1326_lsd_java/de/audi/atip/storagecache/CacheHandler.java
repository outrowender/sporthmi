/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.storagecache;

import de.audi.atip.storagecache.CacheEventListener;

public interface CacheHandler {
    default public Object getState(String string, String string2) {
    }

    default public void addListener(CacheEventListener cacheEventListener) {
    }

    default public void removeListener(CacheEventListener cacheEventListener) {
    }
}

