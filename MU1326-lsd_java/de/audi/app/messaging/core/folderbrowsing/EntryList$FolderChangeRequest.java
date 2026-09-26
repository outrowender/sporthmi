/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.esolutions.fw.util.commons.Buffer;

public final class EntryList$FolderChangeRequest {
    private final int accountId;
    private final int folderId;

    public EntryList$FolderChangeRequest(int n, int n2) {
        this.accountId = n;
        this.folderId = n2;
    }

    public int getAccountId() {
        return this.accountId;
    }

    public int getFolderId() {
        return this.folderId;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("FolderChangeRequest {");
        buffer.append("accountId = ").append(this.getAccountId());
        buffer.append(", folderId = ").append(this.getFolderId());
        buffer.append('}');
        return buffer.toString();
    }
}

