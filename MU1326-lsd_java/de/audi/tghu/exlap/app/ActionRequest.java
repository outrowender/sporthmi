/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.app;

class ActionRequest {
    private final long time;
    private final int requestId;
    private final int actionId;

    ActionRequest(long l, int n, int n2) {
        this.time = l;
        this.requestId = n;
        this.actionId = n2;
    }

    public long getTime() {
        return this.time;
    }

    public int getRequestId() {
        return this.requestId;
    }

    public int getActionId() {
        return this.actionId;
    }
}

