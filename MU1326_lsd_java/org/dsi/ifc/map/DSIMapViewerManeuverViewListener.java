/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIListener;

public interface DSIMapViewerManeuverViewListener
extends DSIListener {
    public void updateManoeuvreViewActive(int var1, int var2);

    public void updateManoeuvreViewsAvailable(short[] var1, int var2);

    public void updateBapExitViewId(int var1, int var2);
}

