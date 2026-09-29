/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.folderbrowsing;

import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.evo.folderbrowsing.FolderBrowsingService;
import de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingService$ResultCode;
import de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingServiceListener;

class FolderBrowsingService$3
implements Runnable {
    private final /* synthetic */ IFolderBrowsingService$ResultCode val$resultCode;
    private final /* synthetic */ FolderBrowsingService this$0;

    FolderBrowsingService$3(FolderBrowsingService folderBrowsingService, IFolderBrowsingService$ResultCode iFolderBrowsingService$ResultCode) {
        this.this$0 = folderBrowsingService;
        this.val$resultCode = iFolderBrowsingService$ResultCode;
    }

    @Override
    public void run() {
        try {
            FolderBrowsingService.access$800(this.this$0).log(1078071040, "[FolderBrowsingService#emitResponseEnterAccount] resultCode = %1", (Object)this.val$resultCode);
            IFolderBrowsingServiceListener iFolderBrowsingServiceListener = FolderBrowsingService.access$100(this.this$0);
            if (iFolderBrowsingServiceListener == null) {
                FolderBrowsingService.access$900(this.this$0).log(10000, "[FolderBrowsingService#emitResponseEnterAccount] Client listener unavailable.");
            } else {
                iFolderBrowsingServiceListener.responseEnterAccount(this.val$resultCode);
            }
        }
        catch (Exception exception) {
            Logs.logException(FolderBrowsingService.access$1000(this.this$0), exception, "[FolderBrowsingService#emitResponseBeginDialog]");
        }
    }
}

