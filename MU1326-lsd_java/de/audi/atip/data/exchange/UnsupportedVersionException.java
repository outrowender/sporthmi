/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.data.exchange;

public class UnsupportedVersionException
extends Exception {
    private static final long serialVersionUID;
    private final int expectedVersion;
    private final int currentVersion;

    public UnsupportedVersionException(int n, int n2) {
        super(new StringBuffer().append("Expected version ").append(n).append(", but was ").append(n2).toString());
        this.expectedVersion = n;
        this.currentVersion = n2;
    }

    public int getExpectedVersion() {
        return this.expectedVersion;
    }

    public int getCurrentVersion() {
        return this.currentVersion;
    }
}

