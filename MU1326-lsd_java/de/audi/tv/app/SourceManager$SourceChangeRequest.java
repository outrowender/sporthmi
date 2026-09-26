/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.esolutions.fw.util.commons.Buffer;

public class SourceManager$SourceChangeRequest {
    public final int source;
    public final boolean isUserCall;

    public SourceManager$SourceChangeRequest(int n, boolean bl) {
        this.source = n;
        this.isUserCall = bl;
    }

    public int hashCode() {
        int n = 31 + (this.isUserCall ? 1231 : 1237);
        n = 31 * n + this.source;
        return n;
    }

    public boolean equals(Object object) {
        if (object instanceof SourceManager$SourceChangeRequest) {
            SourceManager$SourceChangeRequest sourceManager$SourceChangeRequest = (SourceManager$SourceChangeRequest)object;
            return this.source == sourceManager$SourceChangeRequest.source && this.isUserCall == sourceManager$SourceChangeRequest.isUserCall;
        }
        return false;
    }

    public String toString() {
        return new Buffer(50).append("SourceChangeRequest: source ").append(this.source).append(", isUserCall ").append(this.isUserCall).toString();
    }
}

