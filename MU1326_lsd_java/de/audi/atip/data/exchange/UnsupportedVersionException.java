/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.data.exchange;

public class UnsupportedVersionException
extends Exception {
    private static final long serialVersionUID = 6636691222883919016L;
    private final int expectedVersion;
    private final int currentVersion;

    public UnsupportedVersionException(int n, int n2) {
        super("Expected version " + n + ", but was " + n2);
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

