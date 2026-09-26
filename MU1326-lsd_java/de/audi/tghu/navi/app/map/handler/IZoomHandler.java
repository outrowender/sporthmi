/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.map.Rect;

public interface IZoomHandler {
    public static final float ZOOMLEVEL_30M;
    public static final float ZOOMLEVEL_100M;
    public static final float ZOOMLEVEL_200M;
    public static final float ZOOMLEVEL_400M;
    public static final float ZOOMLEVEL_1KM;
    public static final float ZOOMLEVEL_2KM;
    public static final float ZOOMLEVEL_3KM;
    public static final float ZOOMLEVEL_4KM;
    public static final float ZOOMLEVEL_6KM;
    public static final float ZOOMLEVEL_10KM;
    public static final float ZOOMLEVEL_15KM;
    public static final float ZOOMLEVEL_30KM;
    public static final float ZOOMLEVEL_100KM;
    public static final float ZOOMLEVEL_2500KM;
    public static final float PREVIEWMAP_DEFAULT_ZOOMLEVEL;
    public static final float PREVIEWMAP_CITY_ZOOMLEVEL;
    public static final float PREVIEWMAP_TMC_ZOOMLEVEL;
    public static final float PREVIEWMAP_TMC_NAR_ZOOMLEVEL;
    public static final float RANGE_MAP_DEFAULT_ZOOMLEVEL;

    default public float getRecommendedZoom() {
    }

    default public float[] getZoomList() {
    }

    default public int getZoomListIndex(float f2) {
    }

    default public float getZoom() {
    }

    default public boolean isMaxZoomLevel(int n) {
    }

    default public void incrementGesture(int n) {
    }

    default public void startPinchZoom() {
    }

    default public void stopPinchZoom() {
    }

    default public void incrementWithDelay(int n) {
    }

    default public void setZoom(int n) {
    }

    default public void setZoomLevel(float f2) {
    }

    default public void setZoomArea(Rect rect) {
    }

    default public void setZoomAreaWithGridMask(Rect rect, Rect rect2) {
    }

    default public void startOverviewMapSwitchBackTimer(boolean bl) {
    }

    default public void stopOverviewMapSwitchBackTimer() {
    }

    default public void setUserRequestedZoomIndex(int n) {
    }

    default public void autoZoomEnable(boolean bl) {
    }

    default public void manoeuvreZoomEnable(boolean bl) {
    }

    default public void sdsIncrement(int n) {
    }

    default public boolean matchZoomLevelToZoomListIndex(float f2, int n) {
    }

    default public float getZoomLevel(int n) {
    }

    default public void doubleClick() {
    }

    default public void pinchZoom(float f2) {
    }

    default public long getSetZoomLevelTime() {
    }

    default public long getUpdateZoomListIndexTime() {
    }

    default public void pinchZoom(float f2, int n, int n2) {
    }

    default public float getCurrentlyRequestedZoomLevel() {
    }

    static {
        PREVIEWMAP_DEFAULT_ZOOMLEVEL = Util.getPreviewMapDefaultZoomLevel();
    }
}

