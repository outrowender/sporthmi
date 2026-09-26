/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import de.audi.app.messaging.core.accounts.AbstractAccountListRow;
import de.audi.app.messaging.core.accounts.AccountList;
import de.audi.app.messaging.core.accounts.AccountList$1;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.messaging.MessagingAccount;

class AccountList$MyListListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ AccountList this$0;

    private AccountList$MyListListener(AccountList accountList) {
        this.this$0 = accountList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        Object object = AccountList.access$500(this.this$0).getMessagingHmiLock();
        synchronized (object) {
            MessagingAccount messagingAccount = ((AbstractAccountListRow)evoListRow).getMessagingAccount();
            if (AccountList.access$600(this.this$0).isInfo()) {
                AccountList.access$900(this.this$0).log(1078071040, "[AccountList(%1)#itemSelected] row = %2, messagingAccount = %3 isFolderContentListBusy = %4", (Object)String.valueOf(AccountList.access$700(this.this$0)), (Object)String.valueOf(evoListRow), (Object)String.valueOf(messagingAccount), (Object)String.valueOf(AccountList.access$800(this.this$0)));
            }
            if (!AccountList.access$800(this.this$0)) {
                this.this$0.selectAccount(n2);
                AccountList.access$1000(this.this$0).getHmiServiceApp().getModelApp(n).fireEvent(n4);
            } else if (messagingAccount != null) {
                AccountList.access$1100(this.this$0, n2, false);
                AccountList.access$1200(this.this$0, messagingAccount);
            } else {
                AccountList.access$1300(this.this$0).log(10000, "[AccountList(%1)#itemSelected] No list row at row = %2", (Object)AccountList.access$700(this.this$0), (long)n2);
            }
        }
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.itemSelected(evoListRow, n, n2, n3, n4);
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        AccountList.access$1400(this.this$0).log(1078071040, "[AccountList(%1)#itemFocused] index = %2", (Object)AccountList.access$700(this.this$0), (long)n2);
        AccountList.access$1600(this.this$0, AccountList.access$1500(this.this$0, n2));
    }

    /* synthetic */ AccountList$MyListListener(AccountList accountList, AccountList$1 accountList$1) {
        this(accountList);
    }
}

