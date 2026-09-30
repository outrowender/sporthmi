/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routeinfo;

import de.audi.atip.hmi.model.TextListCell;
import de.audi.tghu.navi.app.map.routeinfo.MixedListItem;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHelper;
import de.audi.tghu.navi.app.map.utils.MixedListRow;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.navigation.NavPoiInfo;

public class MixedListItemPOI
extends MixedListItem {
    private NavPoiInfo mNavPoiInfo;
    private int[] iconIDs = new int[0];

    public MixedListItemPOI(NavPoiInfo navPoiInfo, RouteInfoHandler.TravelData travelData, MixedListRow mixedListRow, long l, long l2, RouteInfoHelper routeInfoHelper) {
        this.helper = routeInfoHelper;
        this.mNavPoiInfo = navPoiInfo;
        this.mMixedListRow = mixedListRow;
        this.iconIDs = this.mMixedListRow.updateValuesForPOI(this.mNavPoiInfo);
        this.mFormat = routeInfoHelper.getDefaultFormat(navPoiInfo);
        this.init(navPoiInfo, travelData, l, l2);
    }

    public int[] getIconIDs() {
        return this.iconIDs;
    }

    public boolean updateDistanceToCar(long l) {
        super.updateDistanceToCar(l);
        String string = this.helper.formatDistString(this.getDistanceToCar());
        if (!string.equals(this.mMixedListRow.getText(12))) {
            this.mMixedListRow.setText(12, string);
            return true;
        }
        return false;
    }

    public boolean updateRttToCar(long l) {
        super.updateRttToCar(l);
        String string = this.mMixedListRow.getText(13);
        String string2 = ((TextListCell)this.mMixedListRow.getCell(52)).getText();
        if (!string2.equals(string)) {
            this.mMixedListRow.setText(13, string2);
            return true;
        }
        return false;
    }

    public Object getEvent() {
        return this.mNavPoiInfo;
    }

    public int getDestinationIndex() {
        return this.mNavPoiInfo.destinationIndex;
    }

    public String toString() {
        Buffer buffer = new Buffer("[POI] ").append(this.mMixedListRow.getShortDescription()).append(" (UID: ").append(this.getUID()).append(", destIndex: ").append(this.getDestinationIndex()).append(", distCarToEvent: ").append(this.getDistanceToCar()).append("m, distEventToFinalDest: ").append(this.mDistToFinalDest).append("m, rttCarToEvent: ").append(this.getRttToCCP()).append("s, rttEventToFinalDest: ").append(this.mRttToFinalDest).append("s)");
        return buffer.toString();
    }
}

