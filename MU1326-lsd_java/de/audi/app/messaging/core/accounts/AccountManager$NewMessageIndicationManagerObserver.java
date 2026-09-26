/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import de.audi.app.messaging.core.accounts.AccountManager;
import de.audi.app.messaging.core.accounts.AccountManager$1;
import de.audi.app.messaging.core.indication.INewMessageIndicationManagerObserver;

class AccountManager$NewMessageIndicationManagerObserver
implements INewMessageIndicationManagerObserver {
    private final /* synthetic */ AccountManager this$0;

    private AccountManager$NewMessageIndicationManagerObserver(AccountManager accountManager) {
        this.this$0 = accountManager;
    }

    @Override
    public void indicateIndicationStateChanged(int n) {
        AccountManager.access$200(this.this$0).log(-2137614336, "[AccountManager#indicateIndicationStateChanged] stateAspect = %1", (long)n);
        if (n == 0) {
            AccountManager.access$300(this.this$0).refresh();
            AccountManager.access$400(this.this$0).refresh();
            AccountManager.access$500(this.this$0).refresh();
        }
    }

    /* synthetic */ AccountManager$NewMessageIndicationManagerObserver(AccountManager accountManager, AccountManager$1 accountManager$1) {
        this(accountManager);
    }
}

