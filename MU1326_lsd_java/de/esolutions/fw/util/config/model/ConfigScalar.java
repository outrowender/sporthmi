/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.model;

import de.esolutions.fw.util.config.ConfigValue;

public abstract class ConfigScalar
extends ConfigValue {
    public boolean isArray() {
        return false;
    }

    public boolean isDictionary() {
        return false;
    }

    public boolean isNull() {
        return false;
    }

    public boolean isScalar() {
        return true;
    }
}

