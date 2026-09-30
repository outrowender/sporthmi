/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

import org.dsi.ifc.base.DSIListener;

public interface DSINavAsiaMapControlListener
extends DSIListener {
    public void updateMapStatus(int var1, int var2);

    public void updateViewType(int var1, int var2);

    public void updateDataRate(int var1, int var2);

    public void updateZoomLevel(float var1, int var2);

    public void updateRecommendedZoom(float var1, int var2);
}

