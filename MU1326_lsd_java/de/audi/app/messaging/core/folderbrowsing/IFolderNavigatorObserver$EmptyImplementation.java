/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.Folder;
import de.audi.app.messaging.core.folderbrowsing.IFolderNavigatorObserver;

public class IFolderNavigatorObserver$EmptyImplementation
implements IFolderNavigatorObserver {
    @Override
    public void updateCurrentFolder(Folder folder) {
    }

    @Override
    public void indicateFolderChange(boolean bl) {
    }

    @Override
    public void indicateFolderChangeFailed(int n) {
    }
}

