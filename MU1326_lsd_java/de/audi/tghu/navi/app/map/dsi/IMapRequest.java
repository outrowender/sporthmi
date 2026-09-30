/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.tghu.navi.app.map.dsi.IDSIMVControl;
import de.audi.tghu.navi.app.map.dsi.MVRequestControl;
import de.audi.tghu.navi.app.map.dsi.MVRequestGoogleCtrl;
import de.audi.tghu.navi.app.map.dsi.MVRequestManeuverView;
import de.audi.tghu.navi.app.map.dsi.MVRequestZoomEngine;

public interface IMapRequest
extends IDSIMVControl {
    public boolean areAllBoundDSIReady();

    public MVRequestControl getMVRequestControlActive();

    public MVRequestControl getMVRequestStd();

    public MVRequestGoogleCtrl getMVRequestGoogleCtrl();

    public MVRequestManeuverView getMVRequestManeuverView();

    public MVRequestZoomEngine getMVRequestZoomEngine();

    public void clearIsActiveFlags();

    public void setLayerVisibility(int[] var1);
}

