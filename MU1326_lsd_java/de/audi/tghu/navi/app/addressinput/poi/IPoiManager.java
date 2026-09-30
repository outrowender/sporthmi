/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.IUpdatePoiSubstringSearchStatus;
import org.dsi.ifc.global.NavLocation;

public interface IPoiManager
extends IUpdatePoiSubstringSearchStatus {
    public static final int SEARCH_AREA_HIDDEN = 0;
    public static final int SEARCH_AREA_VISIBLE = 1;
    public static final String SEARCH_AREA_RESTORABLE = "SEARCH_AREA_RESTORABLE";
    public static final int NAV_POI_CLASS_COUNT_CHOICE = 400641;
    public static final int NAV_DEST_POI_BRANDS_COUNT_CHOICE = 400292;

    public void executePoiSelectionEvent(CommandList var1, int var2);

    public CommandList handlePoiSelectionEvent(CommandList var1, int var2);

    public void destPOIHKReturn(int var1, int var2);

    public void cancelAlongRouteSearch(boolean var1);

    public void updateRgActive(boolean var1);

    public void startPoiMainScreen(boolean var1, boolean var2);

    public void allowRestartOfRRDCalculation();

    public void exitRRD();

    public void setRouteGuidanceStartedByUser(boolean var1);

    public void showPoiDetailScreen(NavLocation var1);

    public void resetPoiSearchArea();
}

