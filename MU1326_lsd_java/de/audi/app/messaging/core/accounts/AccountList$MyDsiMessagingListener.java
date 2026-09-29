/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import de.audi.app.messaging.core.accounts.AccountList;
import de.audi.app.messaging.core.accounts.AccountList$1;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingEmptyListener;
import org.dsi.ifc.messaging.MessagingAccount;

class AccountList$MyDsiMessagingListener
extends DsiMessagingEmptyListener {
    private final /* synthetic */ AccountList this$0;

    private AccountList$MyDsiMessagingListener(AccountList accountList) {
        this.this$0 = accountList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateMessagingAccounts(MessagingAccount[] messagingAccountArray, int n) {
        Object object = AccountList.access$1700(this.this$0).getMessagingHmiLock();
        synchronized (object) {
            AccountList.access$1800(this.this$0).log(-2137614336, "[AccountList(%1)#updateMessagingAccounts] accounts.length = %2", (Object)AccountList.access$700(this.this$0), (long)messagingAccountArray.length);
            AccountList.access$1902(this.this$0, messagingAccountArray);
            this.this$0.refresh();
        }
    }

    /* synthetic */ AccountList$MyDsiMessagingListener(AccountList accountList, AccountList$1 accountList$1) {
        this(accountList);
    }
}

