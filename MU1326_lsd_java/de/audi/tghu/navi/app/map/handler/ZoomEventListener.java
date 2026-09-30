/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

public interface ZoomEventListener {
    public void updateZoomList(float[] var1, float[] var2);

    public void updateZoomListIndex(int var1);

    public void updateSoftZoomEnabled(boolean var1);

    public void updateAutoZoomEnabled(boolean var1);

    public void updateManoeuvreZoomEnabled(boolean var1);

    public void updateZoomEngineState(int var1);

    public void updateRecommendedZoom(float var1);

    public void updateZoomLevel(float var1);
}

