/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.Folder;

public interface IFolderNavigatorObserver {
    default public void updateCurrentFolder(Folder folder) {
    }

    default public void indicateFolderChange(boolean bl) {
    }

    default public void indicateFolderChangeFailed(int n) {
    }
}

