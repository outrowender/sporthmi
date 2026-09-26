/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.list;

import de.audi.atip.hmi.model.list.BaseListModelListener;

public interface TiledListModelListener
extends BaseListModelListener {
    default public void requestItems(int n, int n2, int n3, int n4, int n5) {
    }

    default public void unrequestItems(int n, int n2, int n3, int n4) {
    }
}

