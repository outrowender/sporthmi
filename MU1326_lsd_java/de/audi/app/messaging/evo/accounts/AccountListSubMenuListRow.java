/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.accounts;

import de.audi.atip.hmi.model.list.EvoListRow;

final class AccountListSubMenuListRow
extends EvoListRow {
    static final int TYPE_INBOX;
    static final int TYPE_SENT;
    static final int TYPE_ROOT;
    private static final int COLUMN_COUNT;
    private static final int CELL_IDX_TYPE;
    private final int type;

    AccountListSubMenuListRow(int n) {
        super(n, 1);
        this.type = n;
        this.setInteger(0, n);
    }

    int getType() {
        return this.type;
    }

    @Override
    public EvoListRow copy() {
        return new AccountListSubMenuListRow(this.type);
    }
}

