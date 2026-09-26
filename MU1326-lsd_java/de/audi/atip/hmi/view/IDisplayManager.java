/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.view.IDisplayListener;
import org.osgi.framework.BundleContext;

public interface IDisplayManager {
    public static final int INDEX_DISPLAYABLE_HMI;
    public static final int INDEX_DISPLAYABLE_REAR_VIEW_CAM;
    public static final int INDEX_DISPLAYABLE_BROWSER;
    public static final int INDEX_DISPLAYABLE_MAPVIEWER;
    public static final int INDEX_DISPLAYABLE_MAP_ROUTE_GUIDANCE;
    public static final int INDEX_DISPLAYABLE_MAP_INTERSECTION_VIEW;
    public static final int INDEX_DISPLAYABLE_MAP_JUNCTION_VIEW;
    public static final int INDEX_DISPLAYABLE_DVD_VIDEO;
    public static final int INDEX_DISPLAYABLE_TV_TUNER;
    public static final int INDEX_DISPLAYABLE_AMI;
    public static final int INDEX_DISPLAYABLE_OPS;
    public static final int INDEX_DISPLAYABLE_MAP_INTERSECTION_VIEW_3D;
    public static final int INDEX_DISPLAYABLE_MAP_LANDMARK_VIEW;
    public static final int INDEX_DISPLAYABLE_EXTERNAL_DVD_VIDEO;
    public static final int INDEX_DISPLAYABLE_HMI2;
    public static final int INDEX_DISPLAYABLE_3D;
    public static final int INDEX_DISPLAYABLE_MAP_IN_MAP;
    public static final int INDEX_DISPLAYABLE_GOOGLE_EARTH;
    public static final int MAX_DISPLAYABLES;
    public static final int[] displayableMapping;
    public static final int FRAME_DROP_EVERY_FRAME;
    public static final int FRAME_DROP_EVERY_OTHER_FRAME;
    public static final int FRAME_DROP_EVERY_THIRD_FRAME;
    public static final int FRAME_DROP_EVERY_FOURTH_FRAME;

    default public void switchContext(int n, int n2, IDisplayListener iDisplayListener) {
    }

    default public int getCurrentContextID(int n) {
    }

    default public void setOpacity(int n, int n2, int n3) {
    }

    default public void fadeToOpacity(int n, int n2, int n3, int n4) {
    }

    default public int[] getDisplayables(int n) {
    }

    default public void setPosition(int n, int n2, int n3, int n4) {
    }

    default public void setCropping(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
    }

    default public void setDisplayBrightness(int n, int n2) {
    }

    default public void lockDisplay(int n) {
    }

    default public void lockDisplayAndWait(int n) {
    }

    default public void unlockDisplay(int n) {
    }

    default public void unlockDisplayAndWait(int n) {
    }

    default public void takeScreenshot(int n, String string) {
    }

    default public void stop(BundleContext bundleContext) {
    }

    default public void start(BundleContext bundleContext) {
    }

    default public int getOpacity(int n, int n2) {
    }

    default public int[] getPosition(int n, int n2) {
    }

    default public void setDisplayType(int n, int n2) {
    }

    default public void setUpdateRate(int n, int n2) {
    }

    default public int[] getExtends(int n) {
    }

    static {
        displayableMapping = new int[19];
    }
}

