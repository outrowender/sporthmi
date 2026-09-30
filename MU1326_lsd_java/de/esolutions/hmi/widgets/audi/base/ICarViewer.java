/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

public interface ICarViewer {
    public static final int MODE_CAR_MENU = 0;
    public static final int MODE_DRIVE_SELECT = 1;
    public static final int MODE_UGDO = 2;
    public static final int MODE_AMBIENT_LIGHT = 3;
    public static final int MODE_AMBIENT_LIGHT_OPTION_SCREEN = 4;
    public static final int NUM_MODES = 5;
    public static final int BIG_STAGE = 0;
    public static final int SMALL_STAGE = 1;

    public void setCarMenuIndex(int var1);

    public void setMode(int var1);

    public void setVisible(boolean var1);

    public void setIgnoreScreenChangeTransformation(boolean var1);
}

