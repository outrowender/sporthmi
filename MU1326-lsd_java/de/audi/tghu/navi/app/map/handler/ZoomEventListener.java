/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

public interface ZoomEventListener {
    default public void updateZoomList(float[] fArray, float[] fArray2) {
    }

    default public void updateZoomListIndex(int n) {
    }

    default public void updateSoftZoomEnabled(boolean bl) {
    }

    default public void updateAutoZoomEnabled(boolean bl) {
    }

    default public void updateManoeuvreZoomEnabled(boolean bl) {
    }

    default public void updateZoomEngineState(int n) {
    }

    default public void updateRecommendedZoom(float f2) {
    }

    default public void updateZoomLevel(float f2) {
    }
}

