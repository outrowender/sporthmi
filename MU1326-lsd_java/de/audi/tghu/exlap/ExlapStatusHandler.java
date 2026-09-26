/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap;

public interface ExlapStatusHandler {
    public static final int EXLAP_DISABLED;
    public static final int EXLAP_ENABLED;

    default public void setExlapStatus(boolean bl) {
    }

    default public boolean getExlapStatus() {
    }
}

