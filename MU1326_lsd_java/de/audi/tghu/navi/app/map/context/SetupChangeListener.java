/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

public interface SetupChangeListener {
    public void onChangedSetup(int var1, int var2);

    public void onChangedMapRepresentation(int var1, int var2);

    public void onChangedAdditionalInfos(int var1);

    public void onChangedAutoZoom(int var1);

    public void onChangedIntersectionZoom(int var1, boolean var2);

    public void onChangedDayNightView(int var1);

    public void onChangedMapType(int var1, int var2);

    public void onChangedOrientation(int var1);

    public void onChangedPanorama(boolean var1);

    public void setRangeMapDefaultZoomLevel();
}

