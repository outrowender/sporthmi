/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import de.audi.app.messaging.core.accounts.AccountManager;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;

final class AccountManager$DiagPlugIn
implements IDiagPlugIn {
    private final /* synthetic */ AccountManager this$0;

    AccountManager$DiagPlugIn(AccountManager accountManager) {
        this.this$0 = accountManager;
    }

    public Object getDialogAccountList() {
        return AccountManager.access$300(this.this$0);
    }

    public Object getSmsAccountList() {
        return AccountManager.access$400(this.this$0);
    }

    public Object getEmailAccountList() {
        return AccountManager.access$500(this.this$0);
    }

    public Object getAccountManager() {
        return this.this$0;
    }
}

