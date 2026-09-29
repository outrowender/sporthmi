/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.folderbrowsing;

import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.evo.folderbrowsing.FolderBrowsingService;
import de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingService$MessageType;
import de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingService$ResultCode;
import org.dsi.ifc.messaging.MessagingAccount;

class FolderBrowsingService$4
implements Runnable {
    private final /* synthetic */ IFolderBrowsingService$MessageType val$messageType;
    private final /* synthetic */ FolderBrowsingService this$0;

    FolderBrowsingService$4(FolderBrowsingService folderBrowsingService, IFolderBrowsingService$MessageType iFolderBrowsingService$MessageType) {
        this.this$0 = folderBrowsingService;
        this.val$messageType = iFolderBrowsingService$MessageType;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        IFolderBrowsingService$ResultCode iFolderBrowsingService$ResultCode = IFolderBrowsingService$ResultCode.ERROR_GENERAL;
        try {
            FolderBrowsingService.access$1100(this.this$0).log(1078071040, "[FolderBrowsingService#requestEnterAccount] messageType = %1", (Object)this.val$messageType);
            MessagingAccount messagingAccount = null;
            MessagingAccount[] messagingAccountArray = FolderBrowsingService.access$1200(this.this$0).getAccountManager().getAccounts();
            if (messagingAccountArray != null) {
                for (int i2 = 0; i2 < messagingAccountArray.length; ++i2) {
                    IFolderBrowsingService$MessageType iFolderBrowsingService$MessageType;
                    MessagingAccount messagingAccount2 = messagingAccountArray[i2];
                    IFolderBrowsingService$MessageType iFolderBrowsingService$MessageType2 = iFolderBrowsingService$MessageType = messagingAccount2.isSupportsEMail() ? IFolderBrowsingService$MessageType.EMAIL : IFolderBrowsingService$MessageType.SMS;
                    if (!iFolderBrowsingService$MessageType.equals(this.val$messageType)) continue;
                    messagingAccount = messagingAccount2;
                    break;
                }
            }
            if (messagingAccount == null) {
                FolderBrowsingService.access$1300(this.this$0).log(10000, "[FolderBrowsingService#requestEnterAccount] Illegal state: No account of the requested type available.");
                iFolderBrowsingService$ResultCode = IFolderBrowsingService$ResultCode.ERROR_ILLEGAL_STATE;
            } else {
                FolderBrowsingService.access$1400(this.this$0).getAccountManager().selectAccount(messagingAccount.getAccountID());
                FolderBrowsingService.access$1500(this.this$0).getFolderNavigator().changeFolderDirect(-1, false);
                iFolderBrowsingService$ResultCode = IFolderBrowsingService$ResultCode.OK;
            }
        }
        catch (Exception exception) {
            Logs.logException(FolderBrowsingService.access$1600(this.this$0), exception, "[FolderBrowsingService#requestEnterAccount]");
            iFolderBrowsingService$ResultCode = IFolderBrowsingService$ResultCode.ERROR_GENERAL;
        }
        finally {
            FolderBrowsingService.access$1700(this.this$0, iFolderBrowsingService$ResultCode);
        }
    }
}

