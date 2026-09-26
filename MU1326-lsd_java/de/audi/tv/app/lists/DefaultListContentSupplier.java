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
    @Override
    public SelectedItem getSelected() {
        return null;
    }

    @Override
    public AbstractTVStationRow getRowByIndex(int n) {
        return null;
    }

    @Override
    public int getIndexForUniqueID(long l) {
        return -1;
    }

    @Override
    public BaseListModelApp getTmpList() {
        return null;
    }
}

