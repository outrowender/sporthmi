/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import de.audi.app.messaging.core.accounts.AccountList;
import de.audi.app.messaging.core.accounts.AccountList$1;
import de.audi.app.messaging.core.setup.ISetupManagerObserver;

class AccountList$SetupManagerObserver
implements ISetupManagerObserver {
    private final /* synthetic */ AccountList this$0;

    private AccountList$SetupManagerObserver(AccountList accountList) {
        this.this$0 = accountList;
    }

    @Override
    public void indicateConfigurationChanged() {
        AccountList.access$2000(this.this$0).log(-2137614336, "[AccountList(%1)#indicateConfigurationChanged]", (Object)AccountList.access$700(this.this$0));
        this.this$0.refresh();
    }

    /* synthetic */ AccountList$SetupManagerObserver(AccountList accountList, AccountList$1 accountList$1) {
        this(accountList);
    }
}

