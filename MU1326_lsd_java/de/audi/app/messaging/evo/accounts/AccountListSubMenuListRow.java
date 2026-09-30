/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.accounts;

import de.audi.atip.hmi.model.list.EvoListRow;

final class AccountListSubMenuListRow
extends EvoListRow {
    static final int TYPE_INBOX = 0;
    static final int TYPE_SENT = 1;
    static final int TYPE_ROOT = 2;
    private static final int COLUMN_COUNT = 1;
    private static final int CELL_IDX_TYPE = 0;
    private final int type;

    AccountListSubMenuListRow(int n) {
        super(n, 1);
        this.type = n;
        this.setInteger(0, n);
    }

    int getType() {
        return this.type;
    }

    public EvoListRow copy() {
        return new AccountListSubMenuListRow(this.type);
    }
}

