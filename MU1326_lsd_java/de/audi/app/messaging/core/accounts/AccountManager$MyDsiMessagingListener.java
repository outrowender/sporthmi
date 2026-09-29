/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import de.audi.app.messaging.core.accounts.AccountManager;
import de.audi.app.messaging.core.accounts.AccountManager$1;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingEmptyListener;
import de.audi.atip.util.Util;
import org.dsi.ifc.messaging.MessagingAccount;

class AccountManager$MyDsiMessagingListener
extends DsiMessagingEmptyListener {
    private final /* synthetic */ AccountManager this$0;

    private AccountManager$MyDsiMessagingListener(AccountManager accountManager) {
        this.this$0 = accountManager;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateMessagingAccounts(MessagingAccount[] messagingAccountArray, int n) {
        Object object = AccountManager.access$600(this.this$0).getMessagingHmiLock();
        synchronized (object) {
            MessagingAccount messagingAccount;
            AccountManager.access$700(this.this$0).log(-2137614336, "[AccountManager#updateMessagingAccounts] accounts.length = %1", (long)messagingAccountArray.length);
            AccountManager.access$802(this.this$0, messagingAccountArray);
            AccountManager.access$900(this.this$0).clear();
            for (int i2 = 0; i2 < messagingAccountArray.length; ++i2) {
                MessagingAccount messagingAccount2 = messagingAccountArray[i2];
                AccountManager.access$900(this.this$0).put(Util.createInteger(messagingAccount2.getAccountID()), messagingAccount2);
            }
            if (AccountManager.access$1000(this.this$0) != null && (messagingAccount = this.this$0.getAccount(AccountManager.access$1000(this.this$0).getAccountID())) != null) {
                AccountManager.access$1002(this.this$0, messagingAccount);
            }
            AccountManager.access$1100(this.this$0);
            AccountManager.access$1200(this.this$0);
            AccountManager.access$1300(this.this$0);
        }
    }

    /* synthetic */ AccountManager$MyDsiMessagingListener(AccountManager accountManager, AccountManager$1 accountManager$1) {
        this(accountManager);
    }
}

