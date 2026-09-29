/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.folderbrowsing;

import de.audi.app.messaging.core.setup.ISetupManagerObserver;
import de.audi.app.messaging.evo.folderbrowsing.FolderPathDisplay;
import de.audi.app.messaging.evo.folderbrowsing.FolderPathDisplay$1;

final class FolderPathDisplay$SetupManagerObserver
implements ISetupManagerObserver {
    private final /* synthetic */ FolderPathDisplay this$0;

    private FolderPathDisplay$SetupManagerObserver(FolderPathDisplay folderPathDisplay) {
        this.this$0 = folderPathDisplay;
    }

    @Override
    public void indicateConfigurationChanged() {
        FolderPathDisplay.access$400(this.this$0).log(-2137614336, "[FolderPathDisplay#indicateConfigurationChanged]");
        FolderPathDisplay.access$300(this.this$0);
    }

    /* synthetic */ FolderPathDisplay$SetupManagerObserver(FolderPathDisplay folderPathDisplay, FolderPathDisplay$1 folderPathDisplay$1) {
        this(folderPathDisplay);
    }
}

