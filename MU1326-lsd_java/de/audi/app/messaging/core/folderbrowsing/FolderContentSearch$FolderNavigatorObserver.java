/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.Folder;
import de.audi.app.messaging.core.folderbrowsing.FolderContentSearch;
import de.audi.app.messaging.core.folderbrowsing.FolderContentSearch$1;
import de.audi.app.messaging.core.folderbrowsing.IFolderNavigatorObserver$EmptyImplementation;

final class FolderContentSearch$FolderNavigatorObserver
extends IFolderNavigatorObserver$EmptyImplementation {
    private final /* synthetic */ FolderContentSearch this$0;

    private FolderContentSearch$FolderNavigatorObserver(FolderContentSearch folderContentSearch) {
        this.this$0 = folderContentSearch;
    }

    @Override
    public void updateCurrentFolder(Folder folder) {
        this.this$0.log.log(-2137614336, "[FolderContentSearch#updateCurrentFolder] currentFolder = %1", (Object)folder);
        int n = folder.getLevel() > 0 ? 1 : 0;
        FolderContentSearch.access$200(this.this$0).getHmiServiceApp().getChoiceModel(-191749888).setValue(n);
        this.this$0.clear();
    }

    /* synthetic */ FolderContentSearch$FolderNavigatorObserver(FolderContentSearch folderContentSearch, FolderContentSearch$1 folderContentSearch$1) {
        this(folderContentSearch);
    }
}

