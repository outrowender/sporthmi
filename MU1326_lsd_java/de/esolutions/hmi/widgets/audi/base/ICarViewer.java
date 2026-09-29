/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

public interface ICarViewer {
    public static final int MODE_CAR_MENU;
    public static final int MODE_DRIVE_SELECT;
    public static final int MODE_UGDO;
    public static final int MODE_AMBIENT_LIGHT;
    public static final int MODE_AMBIENT_LIGHT_OPTION_SCREEN;
    public static final int NUM_MODES;
    public static final int BIG_STAGE;
    public static final int SMALL_STAGE;

    default public void setCarMenuIndex(int n) {
    }

    default public void setMode(int n) {
    }

    default public void setVisible(boolean bl) {
    }

    default public void setIgnoreScreenChangeTransformation(boolean bl) {
    }
}

