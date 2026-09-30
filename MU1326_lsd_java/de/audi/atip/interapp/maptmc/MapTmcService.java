/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.maptmc;

import de.audi.atip.interapp.maptmc.MapTmcMessage;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public interface MapTmcService {
    public void mapEntered();

    public void mapLeft();

    public void showTmcMessage(MapTmcMessage var1);

    public void showInMap(long[] var1, NavRectangle var2, TmcListElement var3);

    public void showInMap(TmcMessage var1, NavRectangle var2);

    public void enableAutomaticRouteDiversion(boolean var1);

    public void updateMapTooltipInformation(TmcMessage var1);

    public boolean isInMapApplicationContext();

    public boolean isTabMapNavActive();

    public boolean isTabRouteActive();
}

