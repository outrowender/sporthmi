/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.preset.Preset;

public interface IPresetPopupData {
    public static final int MAIN_LABEL = 0;
    public static final int MAIN_ICON = 1;
    public static final int SUB_LABEL = 2;
    public static final int SUB_ICON = 3;
    public static final int CONTAINER_LAYOUT_A = 0;
    public static final int CONTAINER_LAYOUT_B = 1;
    public static final int CONTAINER_LAYOUT_C = 2;
    public static final int CONTAINER_LAYOUT_D = 3;
    public static final int CONTAINER_LAYOUT_E = 4;
    public static final int CONTAINER_LAYOUT_F = 5;
    public static final int CONTAINER_LAYOUT_G = 6;
    public static final int CONTAINER_LAYOUT_NO_ENTRY_STORED = 7;
    public static final int CONTAINER_LAYOUT_NOT_STORABLE = 8;
    public static final int CONTAINER_LAYOUT_NOT_STORABLE_MAIN_ENTRY = 9;
    public static final int CONTAINER_LAYOUT_NO_APP_REGISTERED = 10;

    public int getLayoutType();

    public int getCursorColor();

    public int getRowID();

    public Preset getPreset();

    public void setResult(int var1);

    public int getResult();

    public void setPreset(Preset var1);

    public void setBitmapIDs(int[] var1);

    public void setTextIDs(int[] var1);

    public void setLayoutType(int var1);
}

