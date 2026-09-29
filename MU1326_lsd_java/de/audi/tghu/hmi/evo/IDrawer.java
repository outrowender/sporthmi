/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

public interface IDrawer {
    public static final int DRAWER_STATE_OPENED;
    public static final int DRAWER_STATE_CLOSED;
    public static final int DRAWER_STATE_HIDDEN;
    public static final int DRAWER_STATE_FORCED_OPENED;
    public static final int DRAWER_STATE_FORCED_CLOSED;
    public static final int SIZE_DRAWER_STATE;
    public static final int DRAWER_STATE_CLOSED_DISABLED;
    public static final int DRAWER_STATE_IGNORE;
    public static final String[] DRAWER_STATE_TO_STRING;

    default public void setDisplayDrawerState(int n, boolean bl, boolean bl2) {
    }

    default public int getDisplayDrawerState() {
    }

    static {
        DRAWER_STATE_TO_STRING = new String[]{"DRAWER_STATE_OPENED", "DRAWER_STATE_CLOSED", "DRAWER_STATE_HIDDEN", "DRAWER_STATE_FORCED_OPENED", "SIZE_DRAWER_STATE", "DRAWER_STATE_FORCED_CLOSED", "DRAWER_STATE_CLOSED_DISABLED", "DRAWER_STATE_IGNORE"};
    }
}

