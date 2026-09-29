/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu.list;

import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.VisibleMenuListItem;

public class ListLayoutCalculationData {
    final int rowIndex;
    VisibleMenuListItem item;
    final boolean itemWasRealized;
    private Object rowData;
    private boolean rowDataLoaded;
    private final ListController list;

    public ListLayoutCalculationData(ListController listController, int n) {
        this.list = listController;
        this.rowIndex = n;
        this.item = null;
        this.itemWasRealized = false;
        this.rowDataLoaded = false;
    }

    public ListLayoutCalculationData(ListController listController, VisibleMenuListItem visibleMenuListItem) {
        this.list = listController;
        this.rowIndex = visibleMenuListItem.index.widgetPart;
        this.item = visibleMenuListItem;
        this.itemWasRealized = visibleMenuListItem.isRealized();
        this.rowDataLoaded = false;
    }

    public Object getRowData() {
        if (!this.rowDataLoaded) {
            this.rowData = this.list.getModelRow(this.rowIndex);
            this.rowDataLoaded = true;
        }
        return this.rowData;
    }
}

