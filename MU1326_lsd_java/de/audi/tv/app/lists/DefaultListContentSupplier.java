/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.IListContentSupplier;

public class DefaultListContentSupplier
implements IListContentSupplier {
    public SelectedItem getSelected() {
        return null;
    }

    public AbstractTVStationRow getRowByIndex(int n) {
        return null;
    }

    public int getIndexForUniqueID(long l) {
        return -1;
    }

    public BaseListModelApp getTmpList() {
        return null;
    }
}

