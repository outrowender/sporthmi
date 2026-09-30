/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.tv.app.lists.AbstractTVStationRow;

public interface IListContentSupplier {
    public SelectedItem getSelected();

    public AbstractTVStationRow getRowByIndex(int var1);

    public int getIndexForUniqueID(long var1);

    public BaseListModelApp getTmpList();
}

