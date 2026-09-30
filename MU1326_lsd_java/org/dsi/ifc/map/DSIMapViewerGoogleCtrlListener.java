/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.map.LayerProperty;
import org.dsi.ifc.map.Rect;

public interface DSIMapViewerGoogleCtrlListener
extends DSIListener {
    public void updateAvailableLayers(LayerProperty[] var1, int var2);

    public void updateVisibleLayers(int[] var1, int var2);

    public void updateAvailableLanguages(String[] var1, int var2);

    public void updateCurrentLanguage(String var1, int var2);

    public void updateGoogleDataStatus(int var1, int var2);

    public void updateCopyrightPosition(Rect var1, int var2, int var3, int var4);
}

