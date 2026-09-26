/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.persistence;

import de.audi.app.media.persistence.MediaPersistenceKey;

public class PersistenceKeyString
extends MediaPersistenceKey {
    private final String defaultValue;

    public PersistenceKeyString(int n, String string) {
        super(n);
        this.defaultValue = string;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }
}

