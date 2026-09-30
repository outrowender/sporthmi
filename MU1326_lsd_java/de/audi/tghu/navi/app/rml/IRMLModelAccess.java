/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;

public interface IRMLModelAccess {
    public static final int SCROLL_DIRECTION_UP = 0;
    public static final int SCROLL_DIRECTION_DOWN = 1;
    public static final int SCROLL_DIRECTION_NO_DIRECTION = 2;

    public void onUpdateList(long var1, CombinedRouteListElement[] var3, int var4, long var5, Route var7);

    public void onStart();

    public void updateInfoForNextDestination(RgInfoForNextDestination var1);

    public void onUpdateListLength(long var1);

    public void onStop();

    public void onDetailsSelected();

    public void onCountryInfoSelected();

    public void onTrafficInfoSelected();

    public void onNoDetailsSelected();

    public void onElementFocused(NavRectangle var1, CombinedRouteListElement var2);

    public void onPoiFocused(NavLocation var1, CombinedRouteListElement var2);
}

