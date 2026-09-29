/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.evo.connectivity.trusted;

import de.audi.atip.hmi.model.list.EvoListRow;

class TrustedDeviceListRow
extends EvoListRow {
    private static final int DISCONNECTED;
    private static final int CONNECTED;
    private static final int MAX_COLUMN;
    private static final int COLUMN_ID;
    private static final int COLUMN_NAME;
    private static final int COLUMN_ADDRESS;
    private static final int COLUMN_CONNECTED;

    TrustedDeviceListRow(int n, String string, String string2, boolean bl) {
        super(n, 4);
        this.setInteger(0, n);
        this.setText(1, string);
        this.setText(2, string2);
        this.setInteger(3, bl ? 1 : 0);
    }

    String getAddress() {
        return this.getText(2);
    }

    @Override
    public EvoListRow copy() {
        return new TrustedDeviceListRow(this.getInteger(0), this.getText(1), this.getText(2), this.getInteger(3) == 1);
    }
}

