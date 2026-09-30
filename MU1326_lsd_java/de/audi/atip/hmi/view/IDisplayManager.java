/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.view.IDisplayListener;
import org.osgi.framework.BundleContext;

public interface IDisplayManager {
    public static final int INDEX_DISPLAYABLE_HMI = 0;
    public static final int INDEX_DISPLAYABLE_REAR_VIEW_CAM = 1;
    public static final int INDEX_DISPLAYABLE_BROWSER = 2;
    public static final int INDEX_DISPLAYABLE_MAPVIEWER = 3;
    public static final int INDEX_DISPLAYABLE_MAP_ROUTE_GUIDANCE = 4;
    public static final int INDEX_DISPLAYABLE_MAP_INTERSECTION_VIEW = 5;
    public static final int INDEX_DISPLAYABLE_MAP_JUNCTION_VIEW = 7;
    public static final int INDEX_DISPLAYABLE_DVD_VIDEO = 8;
    public static final int INDEX_DISPLAYABLE_TV_TUNER = 9;
    public static final int INDEX_DISPLAYABLE_AMI = 10;
    public static final int INDEX_DISPLAYABLE_OPS = 11;
    public static final int INDEX_DISPLAYABLE_MAP_INTERSECTION_VIEW_3D = 12;
    public static final int INDEX_DISPLAYABLE_MAP_LANDMARK_VIEW = 13;
    public static final int INDEX_DISPLAYABLE_EXTERNAL_DVD_VIDEO = 14;
    public static final int INDEX_DISPLAYABLE_HMI2 = 15;
    public static final int INDEX_DISPLAYABLE_3D = 16;
    public static final int INDEX_DISPLAYABLE_MAP_IN_MAP = 17;
    public static final int INDEX_DISPLAYABLE_GOOGLE_EARTH = 18;
    public static final int MAX_DISPLAYABLES = 19;
    public static final int[] displayableMapping = new int[19];
    public static final int FRAME_DROP_EVERY_FRAME = 1;
    public static final int FRAME_DROP_EVERY_OTHER_FRAME = 2;
    public static final int FRAME_DROP_EVERY_THIRD_FRAME = 3;
    public static final int FRAME_DROP_EVERY_FOURTH_FRAME = 4;

    public void switchContext(int var1, int var2, IDisplayListener var3);

    public int getCurrentContextID(int var1);

    public void setOpacity(int var1, int var2, int var3);

    public void fadeToOpacity(int var1, int var2, int var3, int var4);

    public int[] getDisplayables(int var1);

    public void setPosition(int var1, int var2, int var3, int var4);

    public void setCropping(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10);

    public void setDisplayBrightness(int var1, int var2);

    public void lockDisplay(int var1);

    public void lockDisplayAndWait(int var1);

    public void unlockDisplay(int var1);

    public void unlockDisplayAndWait(int var1);

    public void takeScreenshot(int var1, String var2);

    public void stop(BundleContext var1);

    public void start(BundleContext var1);

    public int getOpacity(int var1, int var2);

    public int[] getPosition(int var1, int var2);

    public void setDisplayType(int var1, int var2);

    public void setUpdateRate(int var1, int var2);

    public int[] getExtends(int var1);
}

