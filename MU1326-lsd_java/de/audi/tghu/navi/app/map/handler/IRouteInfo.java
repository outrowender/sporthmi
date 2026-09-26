/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.tmc.TmcMessage;

public interface IRouteInfo {
    public static final int MIXEDLIST_COUNTRYINFO_HORIZON;
    public static final int DIST_SHOW_THRESHOLD;

    default public void forceRouteInfo(boolean bl) {
    }

    default public void show() {
    }

    default public void hide() {
    }

    default public boolean isMixedListVisible() {
    }

    default public void setMixedListVisible(boolean bl) {
    }

    default public void updateRgActive(boolean bl) {
    }

    default public void updateRgTurnList(TurnListElement[] turnListElementArray) {
    }

    default public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray) {
    }

    default public void enableRouteInfoComplete(boolean bl) {
    }

    default public void updateRgPoiInfo(NavPoiInfo[] navPoiInfoArray) {
    }

    default public void updateTmcMessagesAhead(TmcMessage[] tmcMessageArray) {
    }

    default public void setLanguage(String string) {
    }

    default public void refreshDestinationFlag() {
    }

    default public void refreshDistAndRtt() {
    }

    default public void setTravelParameters(boolean bl, boolean bl2, long l, long l2, int n, int n2, long l3, long l4, int n3, int n4, int n5) {
    }

    default public Object getItemByUID(long l) {
    }
}

