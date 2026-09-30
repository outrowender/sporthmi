/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.storagecache;

import de.audi.atip.storagecache.CacheEventListener;

public interface CacheHandler {
    public Object getState(String var1, String var2);

    public void addListener(CacheEventListener var1);

    public void removeListener(CacheEventListener var1);
}

