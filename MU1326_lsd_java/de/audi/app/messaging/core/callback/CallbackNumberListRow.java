/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.callback;

import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.TextListCell;
import org.dsi.ifc.organizer.PhoneData;

final class CallbackNumberListRow
extends ListRow {
    public static final int COLUMN_COUNT;
    private static final int CELL_ID_ICON;
    private static final int CELL_ID_NUMBER;

    CallbackNumberListRow(PhoneData phoneData) {
        ListCell[] listCellArray = new ListCell[]{IntegerListCell.create(ADBModelUtils.getIconTypeForPhoneNumber(phoneData.getNumberType())), TextListCell.create(phoneData.getNumber())};
        this.setCells(listCellArray);
    }

    private int getIconId() {
        return ((IntegerListCell)this.getCell(0)).getValue();
    }

    String getNumber() {
        return ((TextListCell)this.getCell(1)).getText();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        try {
            int n = ((CallbackNumberListRow)object).getIconId();
            String string = ((CallbackNumberListRow)object).getNumber();
            bl = n == this.getIconId() && string.equals(this.getNumber());
        }
        catch (Exception exception) {
            bl = false;
        }
        return bl;
    }

    @Override
    public int hashCode() {
        return this.getNumber().hashCode();
    }
}

