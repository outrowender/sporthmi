/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import de.audi.app.messaging.core.accounts.IAccountListObserver;
import org.dsi.ifc.messaging.MessagingAccount;

public class IAccountListObserver$EmptyImplementation
implements IAccountListObserver {
    @Override
    public void indicateSelectionPending(int n, int n2, boolean bl) {
    }

    @Override
    public void indicateItemSelected(MessagingAccount messagingAccount) {
    }

    @Override
    public void indicateItemSelectedWhilyBusy(MessagingAccount messagingAccount) {
    }
}

