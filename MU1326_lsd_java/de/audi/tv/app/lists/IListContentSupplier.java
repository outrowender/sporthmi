/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.tv.app.lists.AbstractTVStationRow;

public interface IListContentSupplier {
    default public SelectedItem getSelected() {
    }

    default public AbstractTVStationRow getRowByIndex(int n) {
    }

    default public int getIndexForUniqueID(long l) {
    }

    default public BaseListModelApp getTmpList() {
    }
}

