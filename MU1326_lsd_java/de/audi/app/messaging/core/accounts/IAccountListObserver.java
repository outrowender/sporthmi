/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import org.dsi.ifc.messaging.MessagingAccount;

public interface IAccountListObserver {
    default public void indicateSelectionPending(int n, int n2, boolean bl) {
    }

    default public void indicateItemSelected(MessagingAccount messagingAccount) {
    }

    default public void indicateItemSelectedWhilyBusy(MessagingAccount messagingAccount) {
    }
}

