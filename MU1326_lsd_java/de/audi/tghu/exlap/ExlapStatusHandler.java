/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap;

public interface ExlapStatusHandler {
    public static final int EXLAP_DISABLED = 0;
    public static final int EXLAP_ENABLED = 1;

    public void setExlapStatus(boolean var1);

    public boolean getExlapStatus();
}

