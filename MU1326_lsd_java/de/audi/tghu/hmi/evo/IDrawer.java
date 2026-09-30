/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

public interface IDrawer {
    public static final int DRAWER_STATE_OPENED = 0;
    public static final int DRAWER_STATE_CLOSED = 1;
    public static final int DRAWER_STATE_HIDDEN = 2;
    public static final int DRAWER_STATE_FORCED_OPENED = 3;
    public static final int DRAWER_STATE_FORCED_CLOSED = 4;
    public static final int SIZE_DRAWER_STATE = 5;
    public static final int DRAWER_STATE_CLOSED_DISABLED = 6;
    public static final int DRAWER_STATE_IGNORE = 7;
    public static final String[] DRAWER_STATE_TO_STRING = new String[]{"DRAWER_STATE_OPENED", "DRAWER_STATE_CLOSED", "DRAWER_STATE_HIDDEN", "DRAWER_STATE_FORCED_OPENED", "SIZE_DRAWER_STATE", "DRAWER_STATE_FORCED_CLOSED", "DRAWER_STATE_CLOSED_DISABLED", "DRAWER_STATE_IGNORE"};

    public void setDisplayDrawerState(int var1, boolean var2, boolean var3);

    public int getDisplayDrawerState();
}

