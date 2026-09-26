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
    default public boolean areAllBoundDSIReady() {
    }

    default public MVRequestControl getMVRequestControlActive() {
    }

    default public MVRequestControl getMVRequestStd() {
    }

    default public MVRequestGoogleCtrl getMVRequestGoogleCtrl() {
    }

    default public MVRequestManeuverView getMVRequestManeuverView() {
    }

    default public MVRequestZoomEngine getMVRequestZoomEngine() {
    }

    default public void clearIsActiveFlags() {
    }

    default public void setLayerVisibility(int[] nArray) {
    }
}

