/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.preset.Preset;

public interface IPresetPopupData {
    public static final int MAIN_LABEL;
    public static final int MAIN_ICON;
    public static final int SUB_LABEL;
    public static final int SUB_ICON;
    public static final int CONTAINER_LAYOUT_A;
    public static final int CONTAINER_LAYOUT_B;
    public static final int CONTAINER_LAYOUT_C;
    public static final int CONTAINER_LAYOUT_D;
    public static final int CONTAINER_LAYOUT_E;
    public static final int CONTAINER_LAYOUT_F;
    public static final int CONTAINER_LAYOUT_G;
    public static final int CONTAINER_LAYOUT_NO_ENTRY_STORED;
    public static final int CONTAINER_LAYOUT_NOT_STORABLE;
    public static final int CONTAINER_LAYOUT_NOT_STORABLE_MAIN_ENTRY;
    public static final int CONTAINER_LAYOUT_NO_APP_REGISTERED;

    default public int getLayoutType() {
    }

    default public int getCursorColor() {
    }

    default public int getRowID() {
    }

    default public Preset getPreset() {
    }

    default public void setResult(int n) {
    }

    default public int getResult() {
    }

    default public void setPreset(Preset preset) {
    }

    default public void setBitmapIDs(int[] nArray) {
    }

    default public void setTextIDs(int[] nArray) {
    }

    default public void setLayoutType(int n) {
    }
}

