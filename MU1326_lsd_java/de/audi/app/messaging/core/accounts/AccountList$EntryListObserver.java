/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import de.audi.app.messaging.core.accounts.AccountList;
import de.audi.app.messaging.core.accounts.AccountList$1;
import de.audi.app.messaging.core.folderbrowsing.IEntryListObserver$EmptyImplementation;

final class AccountList$EntryListObserver
extends IEntryListObserver$EmptyImplementation {
    private final /* synthetic */ AccountList this$0;

    private AccountList$EntryListObserver(AccountList accountList) {
        this.this$0 = accountList;
    }

    @Override
    public void indicateOperationState(int n) {
        AccountList.access$2100(this.this$0).log(-2137614336, "[AccountList(%1)#indicateOperationState]", (Object)AccountList.access$700(this.this$0));
        AccountList.access$802(this.this$0, n == 0);
    }

    /* synthetic */ AccountList$EntryListObserver(AccountList accountList, AccountList$1 accountList$1) {
        this(accountList);
    }
}

