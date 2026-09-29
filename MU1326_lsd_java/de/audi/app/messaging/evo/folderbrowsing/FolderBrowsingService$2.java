/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.folderbrowsing;

import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.evo.folderbrowsing.FolderBrowsingService;

class FolderBrowsingService$2
implements Runnable {
    private final /* synthetic */ FolderBrowsingService this$0;

    FolderBrowsingService$2(FolderBrowsingService folderBrowsingService) {
        this.this$0 = folderBrowsingService;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        try {
            int n;
            int n2;
            Object object = this.this$0;
            synchronized (object) {
                n2 = FolderBrowsingService.access$300(this.this$0);
                n = FolderBrowsingService.access$400(this.this$0);
            }
            FolderBrowsingService.access$500(this.this$0).log(1078071040, "[FolderBrowsingService#emitUpdateAvailableAccounts] numSmsAccounts = %1, numEmailAccounts = %2", (long)n2, (long)n);
            object = FolderBrowsingService.access$100(this.this$0);
            if (object == null) {
                FolderBrowsingService.access$600(this.this$0).log(-2137614336, "[FolderBrowsingService#emitUpdateAvailableAccounts] Client listener unavailable.");
            } else {
                object.updateAccounts(n2, n);
            }
        }
        catch (Exception exception) {
            Logs.logException(FolderBrowsingService.access$700(this.this$0), exception, "[FolderBrowsingService#emitUpdateAvailableAccounts]");
        }
    }
}

