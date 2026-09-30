/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.Folder;

public interface IFolderNavigatorObserver {
    public void updateCurrentFolder(Folder var1);

    public void indicateFolderChange(boolean var1);

    public void indicateFolderChangeFailed(int var1);

    public static class EmptyImplementation
    implements IFolderNavigatorObserver {
        public void updateCurrentFolder(Folder folder) {
        }

        public void indicateFolderChange(boolean bl) {
        }

        public void indicateFolderChangeFailed(int n) {
        }
    }
}

