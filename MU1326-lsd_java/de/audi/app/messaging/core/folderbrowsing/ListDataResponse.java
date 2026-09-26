/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.ListDataRequest;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.messaging.ListEntry;

final class ListDataResponse {
    private final ListDataRequest listDataRequest;
    private final int requestId;
    private final int result;
    private final ListEntry[] listEntries;
    private final int accountId;
    private final int folderId;
    private final int offset;

    public ListDataResponse(ListDataRequest listDataRequest, int n, int n2, ListEntry[] listEntryArray, int n3, int n4, int n5) {
        this.listDataRequest = listDataRequest;
        this.requestId = n;
        this.result = n2;
        this.listEntries = listEntryArray;
        this.accountId = n3;
        this.folderId = n4;
        this.offset = n5;
    }

    public ListDataRequest getListDataRequest() {
        return this.listDataRequest;
    }

    public int getRequestId() {
        return this.requestId;
    }

    public int getResult() {
        return this.result;
    }

    public ListEntry[] getListEntries() {
        return this.listEntries;
    }

    public int getAccountId() {
        return this.accountId;
    }

    public int getFolderId() {
        return this.folderId;
    }

    public int getOffset() {
        return this.offset;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("ListDataResponse {listDataRequest = ");
        buffer.append(this.getListDataRequest());
        buffer.append(", requestId = ");
        buffer.append(this.getRequestId());
        buffer.append(", result = ");
        buffer.append(this.getResult());
        buffer.append(", listEntries.length = ");
        buffer.append(this.getListEntries() != null ? String.valueOf(this.getListEntries().length) : String.valueOf(this.getListEntries()));
        buffer.append(", accountId = ");
        buffer.append(this.getAccountId());
        buffer.append(", folderId = ");
        buffer.append(this.getFolderId());
        buffer.append(", offset = ");
        buffer.append(this.getOffset());
        buffer.append('}');
        return buffer.toString();
    }
}

