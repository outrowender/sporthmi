/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.adb;

import de.audi.atip.hmi.model.list.EvoListRow;

public class AddAddressToContactSelectionListRow
extends EvoListRow {
    private static final int ADDRESS_EXISTS_COLUMN = 0;
    private static final int ADDRESS_TYPE_COLUMN = 1;
    private static final int ADDRESS_INFO_COLUMN = 2;
    private static final int ADDRESS_EXISTS = 1;
    private static final int ADDRESS_DOESNT_EXIST = 0;
    private static final int PRIVATE_ADDRESS = 0;
    private static final int BUSINESS_ADDRESS = 1;

    public AddAddressToContactSelectionListRow(long l, boolean bl, String string, int n) {
        super(l, 3);
        this.setInteger(0, bl ? 1 : 0);
        this.setInteger(1, this.getAddressTypeForRow(n));
        this.setText(2, string);
    }

    protected AddAddressToContactSelectionListRow(AddAddressToContactSelectionListRow addAddressToContactSelectionListRow) {
        super(addAddressToContactSelectionListRow);
    }

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

