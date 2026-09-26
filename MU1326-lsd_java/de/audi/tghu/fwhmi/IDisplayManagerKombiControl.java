/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.hmi.view.IDisplayManager;
import org.dsi.ifc.global.ResourceLocator;

public interface IDisplayManagerKombiControl
extends IDisplayManager {
    public static final int DISPLAYABLE_NONE;
    public static final int DISPLAYABLE_KDK;
    public static final int DISPLAYABLE_OPACITY_NONE;
    public static final int DISPLAYABLE_OPACITY_FULL;
    public static final int DISPLAYABLE_KDK_BACKGROUND_SMALL_STAGE;
    public static final int DISPLAYABLE_KDK_BACKGROUND_LARGE_STAGE;
    public static final String IMAGE_PATH_KDK_BACKGROUND_LARGE_STAGE;
    public static final String IMAGE_PATH_KDK_BACKGROUND_SMALL_STAGE;
    public static final String IMAGE_DIRECTORY_PATH;
    public static final String IMAGE_DIRECTORY_PATH_A3;
    public static final String IMAGE_FILENAME_SUFFIX;

    default public void setupKDKBackground(int n) {
    }

    default public void setKDKVisible(int n, int n2) {
    }

    default public int getVisibleKDK(int n) {
    }

    default public boolean isKDKVisible(int n) {
    }

    default public void setKDKOpacity(int n, int n2) {
    }

    default public void createImageDisplayable(ResourceLocator resourceLocator, int n) {
    }

    default public void updateImageDisplayable(ResourceLocator resourceLocator, int n) {
    }
}

