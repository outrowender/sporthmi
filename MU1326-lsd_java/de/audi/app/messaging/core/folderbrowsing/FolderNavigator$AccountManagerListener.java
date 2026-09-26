/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.accounts.IAccountManagerListener$DefaultAccountManagerListener;
import de.audi.app.messaging.core.folderbrowsing.FolderNavigator;
import de.audi.app.messaging.core.folderbrowsing.FolderNavigator$1;

final class FolderNavigator$AccountManagerListener
extends IAccountManagerListener$DefaultAccountManagerListener {
    private final /* synthetic */ FolderNavigator this$0;

    private FolderNavigator$AccountManagerListener(FolderNavigator folderNavigator) {
        this.this$0 = folderNavigator;
    }

    @Override
    public void selectedAccountChanged() {
        FolderNavigator.access$400(this.this$0).log(-2137614336, "[FolderNavigator#selectedAccountChanged]");
        FolderNavigator.access$500(this.this$0);
    }

    /* synthetic */ FolderNavigator$AccountManagerListener(FolderNavigator folderNavigator, FolderNavigator$1 folderNavigator$1) {
        this(folderNavigator);
    }
}

