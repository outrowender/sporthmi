/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.maptmc;

import de.audi.atip.interapp.maptmc.MapTmcMessage;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public interface MapTmcService {
    default public void mapEntered() {
    }

    default public void mapLeft() {
    }

    default public void showTmcMessage(MapTmcMessage mapTmcMessage) {
    }

    default public void showInMap(long[] lArray, NavRectangle navRectangle, TmcListElement tmcListElement) {
    }

    default public void showInMap(TmcMessage tmcMessage, NavRectangle navRectangle) {
    }

    default public void enableAutomaticRouteDiversion(boolean bl) {
    }

    default public void updateMapTooltipInformation(TmcMessage tmcMessage) {
    }

    default public boolean isInMapApplicationContext() {
    }

    default public boolean isTabMapNavActive() {
    }

    default public boolean isTabRouteActive() {
    }
}

