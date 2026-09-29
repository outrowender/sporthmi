/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import de.audi.app.messaging.core.accounts.AbstractAccountListRow;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.TextListCell;

final class AccountTooltipRow
extends ListRow {
    static final int COLUMN_COUNT;
    static final int RECORDSET_COUNT;
    static final int RECORDSET_FIRST_ROW;
    static final int RECORDSET_SECOND_ROW;
    private static final int CELL_ID_ICON;
    private static final int CELL_ID_ACCOUNT_DESC;
    private static final int CELL_ID_ACCOUNT_NO;
    private static final int CELL_ID_ACCOUNT_NAME;
    private static final int CELL_ID_RECORDSET;

    AccountTooltipRow(AbstractAccountListRow abstractAccountListRow, int n) {
        ListCell[] listCellArray = new ListCell[5];
        if (n == 0) {
            listCellArray[0] = IntegerListCell.create(abstractAccountListRow.getIconId());
            listCellArray[2] = IntegerListCell.create(abstractAccountListRow.getAccountDescId());
            listCellArray[1] = TextListCell.create(abstractAccountListRow.getAccountNo());
        } else {
            listCellArray[3] = TextListCell.create(abstractAccountListRow.getMessagingAccount().getAccountName());
        }
        listCellArray[4] = IntegerListCell.create(n);
        this.setCells(listCellArray);
    }

    private int getRecordset() {
        return ((IntegerListCell)this.getCell(4)).getValue();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        try {
            int n = ((AccountTooltipRow)object).getRecordset();
            int n2 = this.getRecordset();
            bl = n == n2;
        }
        catch (Exception exception) {
            bl = false;
        }
        return bl;
    }

    @Override
    public int hashCode() {
        return this.getRecordset();
    }
}

