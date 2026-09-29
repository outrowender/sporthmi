/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import java.util.ArrayList;

public class MediaFlags {
    public static final MediaFlags EMPTY_FLAGS = new MediaFlags();
    private final boolean importRunning;
    private final boolean metaDataSyncComplete;
    private final boolean readOnly;
    private final boolean filesystemSyncComplete;
    private final boolean syncComplete;
    private final boolean extMetaDataSyncComplete;
    private final boolean coverSyncComplete;
    private final boolean readyForCoverflow;
    private final boolean lastPlaySelectionValid;
    private final boolean databaseFull;

    private MediaFlags() {
        this.syncComplete = false;
        this.filesystemSyncComplete = false;
        this.metaDataSyncComplete = false;
        this.extMetaDataSyncComplete = false;
        this.coverSyncComplete = false;
        this.importRunning = false;
        this.readOnly = false;
        this.readyForCoverflow = false;
        this.lastPlaySelectionValid = false;
        this.databaseFull = false;
    }

    public MediaFlags(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10) {
        this.syncComplete = bl;
        this.filesystemSyncComplete = bl2;
        this.metaDataSyncComplete = bl3;
        this.extMetaDataSyncComplete = bl4;
        this.coverSyncComplete = bl5;
        this.importRunning = bl6;
        this.readOnly = bl7;
        this.readyForCoverflow = bl8;
        this.lastPlaySelectionValid = bl9;
        this.databaseFull = bl10;
    }

    public boolean isReadOnly() {
        return this.readOnly;
    }

    public boolean isSyncComplete() {
        return this.syncComplete;
    }

    public boolean isFilesystemSyncComplete() {
        return this.filesystemSyncComplete;
    }

    public boolean isMetaDataSyncComplete() {
        return this.metaDataSyncComplete;
    }

    public boolean isExtMetaDataSyncComplete() {
        return this.extMetaDataSyncComplete;
    }

    public boolean isCoverSyncComplete() {
        return this.coverSyncComplete;
    }

    public boolean isReadyForCoverflow() {
        return this.readyForCoverflow;
    }

    public boolean isImportRunning() {
        return this.importRunning;
    }

    public boolean isLastPlaySelectionValid() {
        return this.lastPlaySelectionValid;
    }

    public boolean isDatabaseFull() {
        return this.databaseFull;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.extMetaDataSyncComplete ? 1231 : 1237);
        n = 31 * n + (this.filesystemSyncComplete ? 1231 : 1237);
        n = 31 * n + (this.importRunning ? 1231 : 1237);
        n = 31 * n + (this.metaDataSyncComplete ? 1231 : 1237);
        n = 31 * n + (this.coverSyncComplete ? 1231 : 1237);
        n = 31 * n + (this.readOnly ? 1231 : 1237);
        n = 31 * n + (this.readyForCoverflow ? 1231 : 1237);
        n = 31 * n + (this.syncComplete ? 1231 : 1237);
        n = 31 * n + (this.lastPlaySelectionValid ? 1231 : 1237);
        n = 31 * n + (this.databaseFull ? 1231 : 1237);
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        MediaFlags mediaFlags = (MediaFlags)object;
        if (this.filesystemSyncComplete != mediaFlags.filesystemSyncComplete) {
            return false;
        }
        if (this.extMetaDataSyncComplete != mediaFlags.extMetaDataSyncComplete) {
            return false;
        }
        if (this.syncComplete != mediaFlags.syncComplete) {
            return false;
        }
        if (this.metaDataSyncComplete != mediaFlags.metaDataSyncComplete) {
            return false;
        }
        if (this.importRunning != mediaFlags.importRunning) {
            return false;
        }
        if (this.readOnly != mediaFlags.readOnly) {
            return false;
        }
        if (this.lastPlaySelectionValid != mediaFlags.lastPlaySelectionValid) {
            return false;
        }
        if (this.readyForCoverflow != mediaFlags.readyForCoverflow) {
            return false;
        }
        if (this.coverSyncComplete != mediaFlags.coverSyncComplete) {
            return false;
        }
        return this.databaseFull == mediaFlags.databaseFull;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(3);
        if (this.filesystemSyncComplete) {
            arrayList.add("SYNC_FS");
        }
        if (this.metaDataSyncComplete) {
            arrayList.add("SYNC_MD");
        }
        if (this.extMetaDataSyncComplete) {
            arrayList.add("SYNC_MD_EXT");
        }
        if (this.syncComplete) {
            arrayList.add("SYNC_COMPLETE");
        }
        if (this.coverSyncComplete) {
            arrayList.add("COVER_SYNC_COMPLETE");
        }
        if (this.importRunning) {
            arrayList.add("IMPORT_RUNNING");
        }
        if (this.readyForCoverflow) {
            arrayList.add("COVERFLOW");
        }
        if (this.readOnly) {
            arrayList.add("READYONLY");
        }
        if (this.lastPlaySelectionValid) {
            arrayList.add("LAST_PLAY_SELECTION");
        }
        if (this.databaseFull) {
            arrayList.add("DATABASE_FULL");
        }
        return ((Object)arrayList).toString();
    }
}

