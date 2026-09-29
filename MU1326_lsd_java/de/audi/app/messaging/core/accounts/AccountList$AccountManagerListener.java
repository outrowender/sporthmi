/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import de.audi.app.messaging.core.accounts.AccountList;
import de.audi.app.messaging.core.accounts.AccountList$1;
import de.audi.app.messaging.core.accounts.IAccountManagerListener$DefaultAccountManagerListener;
import org.dsi.ifc.messaging.MessagingAccount;

final class AccountList$AccountManagerListener
extends IAccountManagerListener$DefaultAccountManagerListener {
    private final /* synthetic */ AccountList this$0;

    private AccountList$AccountManagerListener(AccountList accountList) {
        this.this$0 = accountList;
    }

    @Override
    public void selectedAccountChanged() {
        AccountList.access$2200(this.this$0).log(-2137614336, "[AccountList(%1)#selectedAccountChanged]", (Object)AccountList.access$700(this.this$0));
        MessagingAccount messagingAccount = AccountList.access$2300(this.this$0).getAccountManager().getSelectedAccount();
        int n = this.this$0.getRowIndexByAccount(messagingAccount);
        if (n != -1) {
            AccountList.access$1100(this.this$0, n, true);
        }
    }

    /* synthetic */ AccountList$AccountManagerListener(AccountList accountList, AccountList$1 accountList$1) {
        this(accountList);
    }
}

