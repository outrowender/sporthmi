/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.Folder;
import de.audi.app.messaging.core.folderbrowsing.IFolderNavigatorObserver$EmptyImplementation;
import de.audi.app.messaging.evo.folderbrowsing.FolderPathDisplay;
import de.audi.app.messaging.evo.folderbrowsing.FolderPathDisplay$1;

final class FolderPathDisplay$FolderNavigatorObserver
extends IFolderNavigatorObserver$EmptyImplementation {
    private final /* synthetic */ FolderPathDisplay this$0;

    private FolderPathDisplay$FolderNavigatorObserver(FolderPathDisplay folderPathDisplay) {
        this.this$0 = folderPathDisplay;
    }

    @Override
    public void updateCurrentFolder(Folder folder) {
        FolderPathDisplay.access$200(this.this$0).log(-2137614336, "[FolderPathDisplay#updateCurrentFolder]");
        FolderPathDisplay.access$300(this.this$0);
    }

    /* synthetic */ FolderPathDisplay$FolderNavigatorObserver(FolderPathDisplay folderPathDisplay, FolderPathDisplay$1 folderPathDisplay$1) {
        this(folderPathDisplay);
    }
}

