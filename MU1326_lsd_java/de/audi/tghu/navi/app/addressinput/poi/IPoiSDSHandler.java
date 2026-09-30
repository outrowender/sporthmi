/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi;

import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.SDSListEntry;
import org.dsi.ifc.global.NavLocation;

public interface IPoiSDSHandler {
    public void startDestinationInput(NaviServiceListener var1);

    public byte fillPOIPickList(SDSListEntry[] var1);

    public SDSListEntry getPOIPickListEntryDetails(int var1);

    public NaviService.POISDSListEntry getResultListEntryDetails(int var1, int var2);

    public SDSListEntry getPoiTopPoiListEntryDetails(int var1);

    public NaviService.POISDSListEntry getPOIEntryDetails(int var1, byte var2);

    public void selectPOI(int var1, NaviServiceListener var2);

    public void selectPOIbyListIndex(int var1, NaviServiceListener var2);

    public void selectTopPOI(int var1, NaviServiceListener var2);

    public byte setPOISearchArea(byte var1);

    public void triggerPOIReturn(NaviServiceListener var1);

    public void selectNaturalPoi(int var1, NaviServiceListener var2);

    public void startPoiSearchByName(NaviServiceListener var1);

    public NavLocation getPoiSearchAreaLocation();
}

