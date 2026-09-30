/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.esolutions.fw.util.commons.Buffer;

public class ListRequest {
    private static final int INVALID = -1;
    private int requestId;
    private int startIndex;

    public ListRequest(int n, int n2) {
        this.requestId = n;
        this.startIndex = n2;
    }

    public ListRequest() {
        this.requestId = -1;
        this.startIndex = -1;
    }

    public int getRequestId() {
        return this.requestId;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public boolean isValid() {
        return -1 != this.requestId || -1 != this.startIndex;
    }

    public String toString() {
        Buffer buffer = new Buffer(40);
        buffer.append("[reqId='");
        buffer.append(this.requestId == -1 ? "invalid" : Integer.toString(this.requestId));
        buffer.append("', startIdx='");
        buffer.append(this.startIndex == -1 ? "invalid" : Integer.toString(this.startIndex));
        buffer.append("']");
        return buffer.toString();
    }
}

