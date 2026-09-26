/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.EntryList;
import de.audi.app.messaging.core.folderbrowsing.EntryList$1;
import de.audi.app.messaging.core.folderbrowsing.Folder;
import de.audi.app.messaging.core.folderbrowsing.IFolderNavigatorObserver$EmptyImplementation;

final class EntryList$FolderNavigatorObserver
extends IFolderNavigatorObserver$EmptyImplementation {
    private final /* synthetic */ EntryList this$0;

    private EntryList$FolderNavigatorObserver(EntryList entryList) {
        this.this$0 = entryList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void indicateFolderChange(boolean bl) {
        Object object = EntryList.access$3100(this.this$0).getMessagingHmiLock();
        synchronized (object) {
            EntryList.access$3200(this.this$0).log(-2137614336, "[EntryList#indicateFolderChange] inProgress = %1", bl);
            this.this$0.isFolderChangeInProgress = true;
            if (bl) {
                EntryList.access$1000(this.this$0, 0);
                this.this$0.setAwaitFolderChange(false);
            } else if (!EntryList.access$3300(this.this$0).isValid()) {
                EntryList.access$1000(this.this$0, 3);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateCurrentFolder(Folder folder) {
        Object object = EntryList.access$3400(this.this$0).getMessagingHmiLock();
        synchronized (object) {
            EntryList.access$3500(this.this$0).log(-2137614336, "[EntryList#updateCurrentFolder] currentFolder = %1", (Object)folder);
            EntryList.access$3302(this.this$0, folder);
            boolean bl = folder.isValid();
            this.this$0.setIgnoreUpdates(!bl);
            if (!bl) {
                EntryList.access$3600(this.this$0);
            }
        }
    }

    /* synthetic */ EntryList$FolderNavigatorObserver(EntryList entryList, EntryList$1 entryList$1) {
        this(entryList);
    }
}

