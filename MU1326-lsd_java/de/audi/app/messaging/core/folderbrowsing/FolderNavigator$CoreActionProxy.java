/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.FolderNavigator;
import de.audi.app.messaging.core.folderbrowsing.FolderNavigator$1;
import de.audi.app.messaging.core.guide.DefaultCoreActionProxy;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;

final class FolderNavigator$CoreActionProxy
extends DefaultCoreActionProxy
implements IActionProxySubscriber {
    private final /* synthetic */ FolderNavigator this$0;

    private FolderNavigator$CoreActionProxy(FolderNavigator folderNavigator) {
        this.this$0 = folderNavigator;
    }

    @Override
    public void parentFolderSelected(int n) {
        FolderNavigator.access$300(this.this$0).log(-2137614336, "[FolderNavigator#parentFolderSelected]");
        this.this$0.changeFolderUp();
    }

    /* synthetic */ FolderNavigator$CoreActionProxy(FolderNavigator folderNavigator, FolderNavigator$1 folderNavigator$1) {
        this(folderNavigator);
    }
}

