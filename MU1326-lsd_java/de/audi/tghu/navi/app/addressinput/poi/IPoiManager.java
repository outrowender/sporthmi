/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.IUpdatePoiSubstringSearchStatus;
import org.dsi.ifc.global.NavLocation;

public interface IPoiManager
extends IUpdatePoiSubstringSearchStatus {
    public static final int SEARCH_AREA_HIDDEN;
    public static final int SEARCH_AREA_VISIBLE;
    public static final String SEARCH_AREA_RESTORABLE;
    public static final int NAV_POI_CLASS_COUNT_CHOICE;
    public static final int NAV_DEST_POI_BRANDS_COUNT_CHOICE;

    default public void executePoiSelectionEvent(CommandList commandList, int n) {
    }

    default public CommandList handlePoiSelectionEvent(CommandList commandList, int n) {
    }

    default public void destPOIHKReturn(int n, int n2) {
    }

    default public void cancelAlongRouteSearch(boolean bl) {
    }

    default public void updateRgActive(boolean bl) {
    }

    default public void startPoiMainScreen(boolean bl, boolean bl2) {
    }

    default public void allowRestartOfRRDCalculation() {
    }

    default public void exitRRD() {
    }

    default public void setRouteGuidanceStartedByUser(boolean bl) {
    }

    default public void showPoiDetailScreen(NavLocation navLocation) {
    }

    default public void resetPoiSearchArea() {
    }
}

