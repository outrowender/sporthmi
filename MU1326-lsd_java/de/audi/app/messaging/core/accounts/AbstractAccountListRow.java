/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.messaging.MessagingAccount;

public abstract class AbstractAccountListRow
extends EvoListRow {
    public static final int ACCOUNT_NO_NONE;

    public AbstractAccountListRow(long l, int n) {
        super(l, n);
    }

    public abstract int getIconId() {
    }

    public abstract int getAccountDescId() {
    }

    public abstract String getAccountNo() {
    }

    public abstract MessagingAccount getMessagingAccount() {
    }

    public abstract int getUnreadCount() {
    }

    public abstract int getNewMessageCount() {
    }

    public abstract boolean supportsSend() {
    }

    @Override
    public abstract boolean equals(Object object) {
    }

    @Override
    public abstract int hashCode() {
    }
}

