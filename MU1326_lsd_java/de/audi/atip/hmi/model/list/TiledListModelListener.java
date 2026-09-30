/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.list;

import de.audi.atip.hmi.model.list.BaseListModelListener;

public interface TiledListModelListener
extends BaseListModelListener {
    public void requestItems(int var1, int var2, int var3, int var4, int var5);

    public void unrequestItems(int var1, int var2, int var3, int var4);
}

