/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.extracteditems;

import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.messaging.ExtractedItem;

final class ExtractedItemListRow
extends EvoListRow {
    private static final int COLUMN_COUNT;
    private static final int CELL_IDX_ITEM_VALUE;
    private final ExtractedItem extractedItem;

    ExtractedItemListRow(ExtractedItem extractedItem, long l) {
        super(l, 1);
        this.extractedItem = extractedItem;
        this.setText(0, extractedItem.getValue());
    }

    public String getItemValue() {
        return this.extractedItem.getValue();
    }

    @Override
    public EvoListRow copy() {
        return new ExtractedItemListRow(this.extractedItem, this.getUniqueID());
    }
}

