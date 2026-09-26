/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.accounts.AccountList;
import de.audi.app.messaging.core.dictation.MessagingDictationService;
import de.audi.app.messaging.core.folderbrowsing.FolderNavigator;
import de.audi.app.messaging.core.util.Logs;
import org.dsi.ifc.messaging.MessagingAccount;

class MessagingDictationService$12
implements Runnable {
    private final /* synthetic */ MessagingDictationService this$0;

    MessagingDictationService$12(MessagingDictationService messagingDictationService) {
        this.this$0 = messagingDictationService;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        int n = 0;
        try {
            MessagingDictationService.access$4400(this.this$0).log(1078071040, "[MessagingDictationService#requestEndDialog]");
            if (!MessagingDictationService.access$100(this.this$0)) {
                MessagingDictationService.access$4500(this.this$0).log(10000, "[MessagingDictationService#requestEndDialog] Illegal state: There is no dialog in progress.");
                n = 3;
            } else {
                AccountList accountList = MessagingDictationService.access$4600(this.this$0).getAccountManager().getDialogAccountList();
                accountList.removeAccountFilter(MessagingDictationService.access$4700(this.this$0));
                MessagingAccount messagingAccount = MessagingDictationService.access$4800(this.this$0).getAccountManager().getSelectedAccount();
                FolderNavigator folderNavigator = MessagingDictationService.access$4900(this.this$0).getFolderNavigator();
                if (messagingAccount != null && !folderNavigator.getCurrentFolder().isValid()) {
                    folderNavigator.changeFolderDirect(-8, false);
                }
            }
        }
        catch (Exception exception) {
            Logs.logException(MessagingDictationService.access$5000(this.this$0), exception, "[MessagingDictationService#requestEndDialog]");
            n = 1;
        }
        finally {
            MessagingDictationService.access$102(this.this$0, false);
            MessagingDictationService.access$2900(this.this$0, this.this$0.getCompositionState());
            MessagingDictationService.access$5100(this.this$0, n);
        }
    }
}

