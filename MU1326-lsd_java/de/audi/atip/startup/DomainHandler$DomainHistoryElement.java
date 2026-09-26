/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.DomainHandler;
import de.esolutions.fw.util.commons.Buffer;

class DomainHandler$DomainHistoryElement {
    static final int ACTION_REQUESTED;
    static final int ACTION_RESPONDED;
    static final int ACTION_UPDATED;
    private long timestamp;
    private int action;
    private int status;
    private final /* synthetic */ DomainHandler this$0;

    DomainHandler$DomainHistoryElement(DomainHandler domainHandler, int n, int n2) {
        this.this$0 = domainHandler;
        this.timestamp = DomainHandler.access$000(domainHandler).getMonotonicTime();
        this.action = n;
        this.status = n2;
    }

    public String toString() {
        return new Buffer(50).append(this.timestamp).append(DomainHandler.access$100()[this.action]).append("(0x").append(Integer.toHexString(this.status)).append(')').toString();
    }
}

