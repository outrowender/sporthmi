/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi;

import de.audi.atip.interapp.NaviService$POISDSListEntry;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.SDSListEntry;
import org.dsi.ifc.global.NavLocation;

public interface IPoiSDSHandler {
    default public void startDestinationInput(NaviServiceListener naviServiceListener) {
    }

    default public byte fillPOIPickList(SDSListEntry[] sDSListEntryArray) {
    }

    default public SDSListEntry getPOIPickListEntryDetails(int n) {
    }

    default public NaviService$POISDSListEntry getResultListEntryDetails(int n, int n2) {
    }

    default public SDSListEntry getPoiTopPoiListEntryDetails(int n) {
    }

    default public NaviService$POISDSListEntry getPOIEntryDetails(int n, byte by) {
    }

    default public void selectPOI(int n, NaviServiceListener naviServiceListener) {
    }

    default public void selectPOIbyListIndex(int n, NaviServiceListener naviServiceListener) {
    }

    default public void selectTopPOI(int n, NaviServiceListener naviServiceListener) {
    }

    default public byte setPOISearchArea(byte by) {
    }

    default public void triggerPOIReturn(NaviServiceListener naviServiceListener) {
    }

    default public void selectNaturalPoi(int n, NaviServiceListener naviServiceListener) {
    }

    default public void startPoiSearchByName(NaviServiceListener naviServiceListener) {
    }

    default public NavLocation getPoiSearchAreaLocation() {
    }
}

