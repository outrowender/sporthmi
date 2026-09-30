/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.folderbrowsing.Folder;
import de.audi.app.messaging.core.folderbrowsing.IFolderNavigatorObserver;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.log.LogChannel;
import java.util.Iterator;

final class FolderNavigatorObserverProxy
implements IFolderNavigatorObserver {
    private final LogChannel log;
    private final CopyOnWriteArrayList observers = new CopyOnWriteArrayList();
    private volatile Folder currentFolder = Folder.FOLDER_NONE;

    public FolderNavigatorObserverProxy(LogChannel logChannel) {
        this.log = logChannel;
    }

    void addObserver(IFolderNavigatorObserver iFolderNavigatorObserver) {
        this.log.log(10000000, "[FolderNavigatorObserverProxy#addObserver] observer = %1", (Object)iFolderNavigatorObserver);
        this.observers.add(iFolderNavigatorObserver);
        try {
            iFolderNavigatorObserver.updateCurrentFolder(this.currentFolder);
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[FolderNavigatorObserverProxy#addObserver]");
        }
    }

    void removeObserver(IFolderNavigatorObserver iFolderNavigatorObserver) {
        this.log.log(10000000, "[FolderNavigatorObserverProxy#removeObserver] observer = %1", (Object)iFolderNavigatorObserver);
        this.observers.remove(iFolderNavigatorObserver);
    }

    public void updateCurrentFolder(Folder folder) {
        this.log.log(10000000, "[FolderNavigatorObserverProxy#updateCurrentFolder] currentFolder = %1", (Object)folder);
        if (!this.currentFolder.equals(folder)) {
            this.currentFolder = folder;
            Iterator iterator = this.observers.iterator();
            while (iterator.hasNext()) {
                try {
                    ((IFolderNavigatorObserver)iterator.next()).updateCurrentFolder(folder);
                }
                catch (Exception exception) {
                    Logs.logException(this.log, exception, "[FolderNavigatorObserverProxy#updateCurrentFolder]");
                }
            }
        }
    }

    public void indicateFolderChange(boolean bl) {
        this.log.log(10000000, "[FolderNavigatorObserverProxy#indicateFolderChange] inProgress = %1", bl);
        Iterator iterator = this.observers.iterator();
        while (iterator.hasNext()) {
            try {
                ((IFolderNavigatorObserver)iterator.next()).indicateFolderChange(bl);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[FolderNavigatorObserverProxy#indicateFolderChange]");
            }
        }
    }

    public void indicateFolderChangeFailed(int n) {
        this.log.log(10000000, "[FolderNavigatorObserverProxy#indicateFolderChangeFailed] hmiFolderType = %1", (long)n);
        Iterator iterator = this.observers.iterator();
        while (iterator.hasNext()) {
            try {
                ((IFolderNavigatorObserver)iterator.next()).indicateFolderChangeFailed(n);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[FolderNavigatorObserverProxy#indicateFolderChangeFailed]");
            }
        }
    }
}

