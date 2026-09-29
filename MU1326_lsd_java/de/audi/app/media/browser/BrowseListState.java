/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.browser;

import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.dsi.media.MediaListEntry;

public class BrowseListState {
    private volatile MediaListEntry[] currentFolderpath = IBrowseListContext.EMPTY_BROWSE_FOLDER;
    private volatile int currentListSize = -1;
    private volatile int currentBrowseMode = -1;
    private volatile boolean metadataAvailable;
    private volatile boolean filesystemAvailable;
    private volatile boolean coverartsAvailable;

    protected MediaListEntry[] getCurrentBrowseFolder() {
        return this.currentFolderpath;
    }

    protected void setCurrentBrowseFolder(MediaListEntry[] mediaListEntryArray) {
        this.currentFolderpath = mediaListEntryArray;
    }

    protected int getCurrentListSize() {
        return this.currentListSize;
    }

    protected void setCurrentListSize(int n) {
        this.currentListSize = n;
    }

    protected int getCurrentBrowseMode() {
        return this.currentBrowseMode;
    }

    protected void setCurrentBrowseMode(int n) {
        this.currentBrowseMode = n;
    }

    public boolean isMetadataAvailable() {
        return this.metadataAvailable;
    }

    public void setMetadataAvailable(boolean bl) {
        this.metadataAvailable = bl;
    }

    public boolean isFilesystemAvailable() {
        return this.filesystemAvailable;
    }

    public boolean isCoverartsAvailable() {
        return this.coverartsAvailable;
    }

    public void setCoverartsAvailable(boolean bl) {
        this.coverartsAvailable = bl;
    }

    public void setFilesystemAvailable(boolean bl) {
        this.filesystemAvailable = bl;
    }
}

