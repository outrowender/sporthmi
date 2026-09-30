/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routeinfo;

import de.audi.tghu.navi.app.map.routeinfo.MixedListItem;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHelper;
import de.audi.tghu.navi.app.map.utils.MixedListRow;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.tmc.TmcMessage;

public class MixedListItemTMC
extends MixedListItem {
    private TmcMessage mTmcMessage;
    private int[] iconIDs = new int[0];

    public MixedListItemTMC(TmcMessage tmcMessage, RouteInfoHandler.TravelData travelData, MixedListRow mixedListRow, long l, long l2, RouteInfoHelper routeInfoHelper) {
        this.helper = routeInfoHelper;
        this.mTmcMessage = tmcMessage;
        this.mMixedListRow = mixedListRow;
        this.iconIDs = this.mMixedListRow.updateValuesForTMC(tmcMessage, -1);
        this.mFormat = routeInfoHelper.getDefaultFormat(tmcMessage);
        this.init(tmcMessage, travelData, l, l2);
    }

    public int[] getIconIDs() {
        return this.iconIDs;
    }

    public boolean updateDistanceToCar(long l) {
        super.updateDistanceToCar(l);
        String string = this.helper.formatDistString(this.getDistanceToCar());
        if (!string.equals(this.mMixedListRow.getText(4))) {
            this.mMixedListRow.setText(4, string);
            return true;
        }
        return false;
    }

    public Object getEvent() {
        return this.mTmcMessage;
    }

    public int getDestinationIndex() {
        return this.mTmcMessage.destinationIndex;
    }

    public String toString() {
        Buffer buffer = new Buffer("[TMC] ").append(this.mMixedListRow.getShortDescription()).append(" (UID: ").append(this.getUID()).append(", destIndex: ").append(this.getDestinationIndex()).append(", distCarToEvent: ").append(this.getDistanceToCar()).append("m, distEventToFinalDest: ").append(this.mDistToFinalDest).append("m)");
        return buffer.toString();
    }
}

