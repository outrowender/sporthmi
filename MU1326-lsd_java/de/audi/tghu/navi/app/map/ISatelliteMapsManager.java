/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.SatelliteMapsMediator;
import org.dsi.ifc.global.NavRectangle;

public interface ISatelliteMapsManager {
    default public void changeMapStyle(int n) {
    }

    default public void setCopyrightPosition(NavRectangle navRectangle, int n, int n2) {
    }

    default public boolean isSatelliteMapSupported() {
    }

    default public boolean isSatelliteMapActive() {
    }

    default public void setMediator(SatelliteMapsMediator satelliteMapsMediator) {
    }

    default public void setSatelliteMapIconsAccordingToSetup() {
    }

    default public int getActiveRendererID() {
    }

    default public AbstractMap getMap() {
    }
}

