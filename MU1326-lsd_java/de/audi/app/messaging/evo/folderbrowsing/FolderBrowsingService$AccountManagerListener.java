/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.folderbrowsing;

import de.audi.app.messaging.core.accounts.IAccountManagerListener$DefaultAccountManagerListener;
import de.audi.app.messaging.evo.folderbrowsing.FolderBrowsingService;
import de.audi.app.messaging.evo.folderbrowsing.FolderBrowsingService$1;

final class FolderBrowsingService$AccountManagerListener
extends IAccountManagerListener$DefaultAccountManagerListener {
    private final /* synthetic */ FolderBrowsingService this$0;

    private FolderBrowsingService$AccountManagerListener(FolderBrowsingService folderBrowsingService) {
        this.this$0 = folderBrowsingService;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateAvailableAccounts(int n, int n2, int n3, int n4) {
        FolderBrowsingService.access$1800(this.this$0).log(-2137614336, "[FolderBrowsingService#updateAvailableAccounts]");
        FolderBrowsingService folderBrowsingService = this.this$0;
        synchronized (folderBrowsingService) {
            FolderBrowsingService.access$302(this.this$0, n);
            FolderBrowsingService.access$402(this.this$0, n2);
        }
        FolderBrowsingService.access$200(this.this$0);
    }

    /* synthetic */ FolderBrowsingService$AccountManagerListener(FolderBrowsingService folderBrowsingService, FolderBrowsingService$1 folderBrowsingService$1) {
        this(folderBrowsingService);
    }
}

