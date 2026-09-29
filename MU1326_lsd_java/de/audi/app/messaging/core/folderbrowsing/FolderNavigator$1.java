/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.ChangeFolderCommand$ResultHandler;
import de.audi.app.messaging.core.folderbrowsing.FolderNavigator;
import org.dsi.ifc.messaging.FolderEntry;

class FolderNavigator$1
implements ChangeFolderCommand$ResultHandler {
    private final /* synthetic */ FolderNavigator this$0;

    FolderNavigator$1(FolderNavigator folderNavigator) {
        this.this$0 = folderNavigator;
    }

    @Override
    public void handleResult(boolean bl, int n, FolderEntry folderEntry, int n2, int n3, int n4) {
        FolderNavigator.access$000(this.this$0, bl, n, folderEntry, n2, n3, n4);
    }
}

