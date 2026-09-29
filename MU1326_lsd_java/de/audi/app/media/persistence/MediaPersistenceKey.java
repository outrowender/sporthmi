/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.persistence;

public class MediaPersistenceKey {
    public static final int NO_DIRECT_ACCESS;
    private final boolean directAccess;
    private final int directAccessKey;

    public MediaPersistenceKey(int n) {
        this.directAccess = -1 != n;
        this.directAccessKey = n;
    }

    public MediaPersistenceKey() {
        this(-1);
    }

    protected boolean isDirectAccess() {
        return this.directAccess;
    }

    protected int getDirectAccessKey() {
        return this.directAccessKey;
    }
}

