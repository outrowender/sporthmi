/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

public final class RetryConfig {
    private final int retryCount;
    private final int retryTimeoutMs;

    public RetryConfig(int n, int n2) {
        this.retryCount = n;
        this.retryTimeoutMs = n2;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public int getRetryTimeoutMs() {
        return this.retryTimeoutMs;
    }
}

