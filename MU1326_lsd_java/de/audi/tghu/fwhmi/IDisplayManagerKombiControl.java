/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.hmi.view.IDisplayManager;
import org.dsi.ifc.global.ResourceLocator;

public interface IDisplayManagerKombiControl
extends IDisplayManager {
    public static final int DISPLAYABLE_NONE = -1;
    public static final int DISPLAYABLE_KDK = 20;
    public static final int DISPLAYABLE_OPACITY_NONE = 0;
    public static final int DISPLAYABLE_OPACITY_FULL = 100;
    public static final int DISPLAYABLE_KDK_BACKGROUND_SMALL_STAGE = 101;
    public static final int DISPLAYABLE_KDK_BACKGROUND_LARGE_STAGE = 102;
    public static final String IMAGE_PATH_KDK_BACKGROUND_LARGE_STAGE = "/mnt/app/eso/hmi/lsd/images/HMISystemEvoHigh/987.png";
    public static final String IMAGE_PATH_KDK_BACKGROUND_SMALL_STAGE = "/mnt/app/eso/hmi/lsd/images/HMISystemEvoHigh/987.png";
    public static final String IMAGE_DIRECTORY_PATH = "/mnt/app/eso/hmi/lsd/images/HMISystemEvoHigh/";
    public static final String IMAGE_DIRECTORY_PATH_A3 = "/mnt/app/eso/hmi/lsd/images/HMISystemEvoHighScale/";
    public static final String IMAGE_FILENAME_SUFFIX = ".png";

    public void setupKDKBackground(int var1);

    public void setKDKVisible(int var1, int var2);

    public int getVisibleKDK(int var1);

    public boolean isKDKVisible(int var1);

    public void setKDKOpacity(int var1, int var2);

    public void createImageDisplayable(ResourceLocator var1, int var2);

    public void updateImageDisplayable(ResourceLocator var1, int var2);
}

