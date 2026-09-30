/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.SatelliteMapsMediator;
import org.dsi.ifc.global.NavRectangle;

public interface ISatelliteMapsManager {
    public void changeMapStyle(int var1);

    public void setCopyrightPosition(NavRectangle var1, int var2, int var3);

    public boolean isSatelliteMapSupported();

    public boolean isSatelliteMapActive();

    public void setMediator(SatelliteMapsMediator var1);

    public void setSatelliteMapIconsAccordingToSetup();

    public int getActiveRendererID();

    public AbstractMap getMap();
}

