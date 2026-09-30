/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import org.dsi.ifc.messaging.MessagingAccount;

public interface IAccountListObserver {
    public void indicateSelectionPending(int var1, int var2, boolean var3);

    public void indicateItemSelected(MessagingAccount var1);

    public void indicateItemSelectedWhilyBusy(MessagingAccount var1);

    public static class EmptyImplementation
    implements IAccountListObserver {
        public void indicateSelectionPending(int n, int n2, boolean bl) {
        }

        public void indicateItemSelected(MessagingAccount messagingAccount) {
        }

        public void indicateItemSelectedWhilyBusy(MessagingAccount messagingAccount) {
        }
    }
}

