/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.list;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.TiledListModelListener;

public interface TiledListModelApp
extends BaseListModelApp {
    default public void setListener(TiledListModelListener tiledListModelListener) {
    }
}

