/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.indication;

import de.audi.app.messaging.core.dsi.messaging.DsiMessagingEmptyListener;
import de.audi.app.messaging.core.indication.NewMessageIndicationManager;
import de.audi.app.messaging.core.indication.NewMessageIndicationManager$1;
import de.audi.atip.util.Util;
import java.util.TreeSet;
import org.dsi.ifc.messaging.MessagingAccount;
import org.dsi.ifc.messaging.StatusInformation;

class NewMessageIndicationManager$MyDsiMessagingListener
extends DsiMessagingEmptyListener {
    private final /* synthetic */ NewMessageIndicationManager this$0;

    private NewMessageIndicationManager$MyDsiMessagingListener(NewMessageIndicationManager newMessageIndicationManager) {
        this.this$0 = newMessageIndicationManager;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateMessagingAccounts(MessagingAccount[] messagingAccountArray, int n) {
        Object object = NewMessageIndicationManager.access$500(this.this$0).getMessagingHmiLock();
        synchronized (object) {
            int n2;
            int n3;
            int n4;
            NewMessageIndicationManager.access$600(this.this$0).log(-2137614336, "[NewMessageIndicationManager#updateMessagingAccounts]");
            boolean bl = false;
            boolean bl2 = false;
            int n5 = -1;
            TreeSet treeSet = new TreeSet();
            for (n4 = 0; n4 < messagingAccountArray.length; ++n4) {
                MessagingAccount messagingAccount = messagingAccountArray[n4];
                n3 = messagingAccount.getMemoryStatus();
                n2 = messagingAccount.getAccountType();
                int n6 = messagingAccount.getAccountID();
                if (!bl && n3 != 0) {
                    bl = true;
                }
                if (!bl2 && (n2 == 1 && n3 != 0 || n2 == 4 && n3 != 0 || n2 == 3 && (n3 == 2 || n3 == 1))) {
                    bl2 = true;
                    n5 = messagingAccount.getAccountID();
                }
                if (bl && bl2) break;
                treeSet.add(Util.createInteger(n6));
            }
            n4 = bl != NewMessageIndicationManager.access$700(this.this$0) ? 1 : 0;
            boolean bl3 = bl2 != NewMessageIndicationManager.access$800(this.this$0);
            NewMessageIndicationManager.access$702(this.this$0, bl);
            NewMessageIndicationManager.access$802(this.this$0, bl2);
            NewMessageIndicationManager.access$902(this.this$0, n5);
            NewMessageIndicationManager.access$1000(this.this$0).retainAll(treeSet);
            NewMessageIndicationManager.access$1100(this.this$0).retainAll(treeSet);
            NewMessageIndicationManager.access$1200(this.this$0).retainAll(treeSet);
            n3 = NewMessageIndicationManager.access$1300(this.this$0).keySet().retainAll(treeSet) ? 1 : 0;
            NewMessageIndicationManager.access$1400(this.this$0).log(-2137614336, "[NewMessageIndicationManager#updateMessagingAccounts] this = %1", (Object)this.this$0);
            if (n4 != 0) {
                NewMessageIndicationManager.access$1500(this.this$0, 1);
            }
            if (bl3) {
                n2 = this.this$0.isSimMemoryDepleted() ? 1 : 0;
                NewMessageIndicationManager.access$1600(this.this$0).getHmiServiceApp().getChoiceModel(1536368896).setValue(n2);
                NewMessageIndicationManager.access$1500(this.this$0, 2);
            }
            if (n3 != 0) {
                NewMessageIndicationManager.access$1500(this.this$0, 0);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void indicateNewMessage(boolean bl, String string, int n, int n2) {
        Object object = NewMessageIndicationManager.access$1700(this.this$0).getMessagingHmiLock();
        synchronized (object) {
            NewMessageIndicationManager.access$1800(this.this$0).log(-2137614336, "[NewMessageIndicationManager#indicateNewMessage]");
            if (bl) {
                if (NewMessageIndicationManager.access$1900(this.this$0) && !NewMessageIndicationManager.access$2100(this.this$0, NewMessageIndicationManager.access$2000(this.this$0).getAccountManager().getAccount(n))) {
                    NewMessageIndicationManager.access$2200(this.this$0).log(1078071040, "[NewMessageIndicationManager#indicateNewMessage] show primary only and message ist not primary");
                } else {
                    NewMessageIndicationManager.access$2300(this.this$0, n, string);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void indicateMessageStatus(StatusInformation statusInformation) {
        Object object = NewMessageIndicationManager.access$2400(this.this$0).getMessagingHmiLock();
        synchronized (object) {
            NewMessageIndicationManager.access$2500(this.this$0).log(-2137614336, "[NewMessageIndicationManager#indicateMessageStatus]");
            if (statusInformation.getStatus() == 3 || statusInformation.getStatus() == 1) {
                NewMessageIndicationManager.access$2600(this.this$0, statusInformation.getMessageId());
            }
        }
    }

    /* synthetic */ NewMessageIndicationManager$MyDsiMessagingListener(NewMessageIndicationManager newMessageIndicationManager, NewMessageIndicationManager$1 newMessageIndicationManager$1) {
        this(newMessageIndicationManager);
    }
}

