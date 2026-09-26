/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

public interface SetupChangeListener {
    default public void onChangedSetup(int n, int n2) {
    }

    default public void onChangedMapRepresentation(int n, int n2) {
    }

    default public void onChangedAdditionalInfos(int n) {
    }

    default public void onChangedAutoZoom(int n) {
    }

    default public void onChangedIntersectionZoom(int n, boolean bl) {
    }

    default public void onChangedDayNightView(int n) {
    }

    default public void onChangedMapType(int n, int n2) {
    }

    default public void onChangedOrientation(int n) {
    }

    default public void onChangedPanorama(boolean bl) {
    }

    default public void setRangeMapDefaultZoomLevel() {
    }
}

