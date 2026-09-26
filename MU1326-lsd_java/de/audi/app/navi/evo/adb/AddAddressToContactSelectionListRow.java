/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.adb;

import de.audi.atip.hmi.model.list.EvoListRow;

public class AddAddressToContactSelectionListRow
extends EvoListRow {
    private static final int ADDRESS_EXISTS_COLUMN;
    private static final int ADDRESS_TYPE_COLUMN;
    private static final int ADDRESS_INFO_COLUMN;
    private static final int ADDRESS_EXISTS;
    private static final int ADDRESS_DOESNT_EXIST;
    private static final int PRIVATE_ADDRESS;
    private static final int BUSINESS_ADDRESS;

    public AddAddressToContactSelectionListRow(long l, boolean bl, String string, int n) {
        super(l, 3);
        this.setInteger(0, bl ? 1 : 0);
        this.setInteger(1, this.getAddressTypeForRow(n));
        this.setText(2, string);
    }

    protected AddAddressToContactSelectionListRow(AddAddressToContactSelectionListRow addAddressToContactSelectionListRow) {
        super(addAddressToContactSelectionListRow);
    }

    @Override
    public EvoListRow copy() {
        return new AddAddressToContactSelectionListRow(this);
    }

    public boolean isAddressPresent() {
        return this.getInteger(0) == 1;
    }

    public int getCommonlyKnownAddressType() {
        if (this.getInteger(1) == 1) {
            return 0;
        }
        return 1;
    }

    private int getAddressTypeForRow(int n) {
        if (n == 0) {
            return 1;
        }
        return 0;
    }
}

