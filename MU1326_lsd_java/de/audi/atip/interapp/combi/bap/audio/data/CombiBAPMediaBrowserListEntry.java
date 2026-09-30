/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio.data;

import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.esolutions.fw.util.commons.Buffer;

public final class CombiBAPMediaBrowserListEntry
implements CombiBAPArrayElement {
    private int entryID;
    private int fileType;
    private int fileState;
    public static final int FILE_STATE_OK = 0;
    public static final int FILE_STATE_EMPTY_FOLDER = 1;
    public static final int FILE_STATE_DRM_PROTECTED = 2;
    public static final int FILE_STATE_CORRUPTED_FILE_FOLDER = 4;
    public static final int FILE_STATE_DEAD_LINK = 8;
    public static final int FILE_STATE_IMPORT_RUNNING = 16;
    public static final int FILE_STATE_IMPORT_PENDING = 32;
    public static final int FILE_STATE_IMPORT_NOT_PLAYABLE = 64;
    private String fileName;

    public CombiBAPMediaBrowserListEntry(int n, String string) {
        this(n, 0, string, 0);
    }

    public CombiBAPMediaBrowserListEntry(int n, int n2, String string) {
        this(n, n2, string, 0);
    }

    public CombiBAPMediaBrowserListEntry(int n, int n2, String string, int n3) {
        this.entryID = n;
        this.fileType = n2;
        this.fileName = string;
        this.fileState = n3;
    }

    public int getEntryID() {
        return this.entryID;
    }

    public int getPosID() {
        return this.entryID;
    }

    public int getFileType() {
        return this.fileType;
    }

    public int getFileState() {
        return this.fileState;
    }

    public boolean hasFileState(int n) {
        return (this.fileState & n) == n;
    }

    public void setFileState(int n) {
        this.fileState = n;
    }

    public void addFileStateAttribute(int n) {
        this.fileState |= n;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("CombiBAPMediaBrowserListEntry {entryID=");
        buffer.append(this.entryID);
        buffer.append(" (0x");
        buffer.append(Integer.toHexString(this.entryID));
        buffer.append("), fileName=");
        buffer.append(this.fileName);
        buffer.append(", fileType=");
        buffer.append(this.fileType);
        buffer.append(", fileState=");
        buffer.append(this.fileState);
        buffer.append("}");
        return buffer.toString();
    }

    public boolean hasSameContent(CombiBAPArrayElement combiBAPArrayElement) {
        if (combiBAPArrayElement == this) {
            return true;
        }
        if (combiBAPArrayElement instanceof CombiBAPMediaBrowserListEntry) {
            CombiBAPMediaBrowserListEntry combiBAPMediaBrowserListEntry = (CombiBAPMediaBrowserListEntry)combiBAPArrayElement;
            return this.entryID == combiBAPMediaBrowserListEntry.entryID && this.fileType == combiBAPMediaBrowserListEntry.fileType && this.fileState == combiBAPMediaBrowserListEntry.fileState && this.fileName.equals(combiBAPMediaBrowserListEntry.fileName);
        }
        return false;
    }

    public int getDiffRecordAddress(CombiBAPArrayElement combiBAPArrayElement) {
        int n = 0;
        if (combiBAPArrayElement == this) {
            n = -1;
        } else if (combiBAPArrayElement instanceof CombiBAPMediaBrowserListEntry) {
            CombiBAPMediaBrowserListEntry combiBAPMediaBrowserListEntry = (CombiBAPMediaBrowserListEntry)combiBAPArrayElement;
            n = CombiBAPMediaBrowserListEntry.getRecordAddress(this.entryID != combiBAPMediaBrowserListEntry.entryID, this.fileType != combiBAPMediaBrowserListEntry.fileType, this.fileState != combiBAPMediaBrowserListEntry.fileState, !this.fileName.equals(combiBAPMediaBrowserListEntry.fileName));
        }
        return n;
    }

    public static int getRecordAddress(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        int n = 0;
        if (bl) {
            ++n;
        }
        if (bl2) {
            ++n;
        }
        if (bl3) {
            ++n;
        }
        if (bl4) {
            ++n;
        }
        int n2 = n == 0 ? -1 : (n == 1 && bl ? 15 : (n == 1 && bl4 ? 2 : (n <= 2 && !bl && !bl4 ? 1 : 0)));
        return n2;
    }
}

