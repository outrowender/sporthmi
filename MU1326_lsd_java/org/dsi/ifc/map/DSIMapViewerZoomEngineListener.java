/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIListener;

public interface DSIMapViewerZoomEngineListener
extends DSIListener {
    public void updateAutoZoomEnabled(boolean var1, int var2);

    public void updateManoeuvreZoomEnabled(boolean var1, int var2);

    public void updateRecommendedZoom(float var1, int var2);

    public void updateZoomEngineState(int var1, int var2);
}

