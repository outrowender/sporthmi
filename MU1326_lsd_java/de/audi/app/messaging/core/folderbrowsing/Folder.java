/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.Folders;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.messaging.FolderEntry;

public final class Folder {
    public static final int HMI_FOLDERTYPE_NONE = 0;
    public static final int HMI_FOLDERTYPE_ROOT = 1;
    public static final int HMI_FOLDERTYPE_DELETED = 2;
    public static final int HMI_FOLDERTYPE_DRAFT = 3;
    public static final int HMI_FOLDERTYPE_INBOX = 4;
    public static final int HMI_FOLDERTYPE_OUTBOX = 5;
    public static final int HMI_FOLDERTYPE_SENT = 6;
    public static final int HMI_FOLDERTYPE_USER = 7;
    public static final int FOLDER_LEVEL_NONE = -1;
    public static final Folder FOLDER_NONE = new Folder(false, null, -1, 0, -1);
    private final boolean isValid;
    private final FolderEntry folderEntry;
    private final int level;
    private final int hmiFolderType;
    private final int requestFolderId;

    private Folder(boolean bl, FolderEntry folderEntry, int n, int n2, int n3) {
        this.isValid = bl;
        this.folderEntry = folderEntry;
        this.level = n;
        this.hmiFolderType = n2;
        this.requestFolderId = n3;
    }

    public Folder(FolderEntry folderEntry, int n, int n2, int n3) {
        this(true, folderEntry, n, n2, n3);
    }

    public boolean isValid() {
        return this.isValid;
    }

    public FolderEntry getFolderEntry() {
        return this.folderEntry;
    }

    public int getLevel() {
        return this.level;
    }

    public int getHmiFolderType() {
        return this.hmiFolderType;
    }

    public int getRequestFolderId() {
        return this.requestFolderId;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("Folder {isValid = ");
        buffer.append(this.isValid);
        buffer.append(", folderEntry = ");
        buffer.append(this.folderEntry);
        buffer.append(", level = ");
        buffer.append(this.level);
        buffer.append(", hmiFolderType = ");
        buffer.append(this.hmiFolderType);
        buffer.append(", requestFolderId = ");
        buffer.append(this.requestFolderId);
        buffer.append('}');
        return buffer.toString();
    }

    public boolean equals(Object object) {
        boolean bl = false;
        try {
            Folder folder = (Folder)object;
            bl = !this.isValid() && !folder.isValid() ? true : this.isValid() == folder.isValid() && Folders.equals(this.getFolderEntry(), folder.getFolderEntry()) && this.getHmiFolderType() == folder.getHmiFolderType() && this.getLevel() == folder.getLevel() && this.getRequestFolderId() == folder.getRequestFolderId();
        }
        catch (Exception exception) {
            bl = false;
        }
        return bl;
    }

    public int hashCode() {
        int n = 0;
        if (this.isValid()) {
            return this.getFolderEntry().getFolderID();
        }
        return n;
    }
}

