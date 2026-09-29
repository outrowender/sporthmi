/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routeinfo;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.tghu.navi.app.map.routeinfo.MixedListItem;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler$TravelData;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHelper;
import de.audi.tghu.navi.app.map.utils.MixedListRow;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.navigation.AdditionalTurnListIcon;
import org.dsi.ifc.navigation.TurnListElement;

public class MixedListItemTurn
extends MixedListItem {
    private TurnListElement mTurnElement;

    public MixedListItemTurn(TurnListElement turnListElement, RouteInfoHandler$TravelData routeInfoHandler$TravelData, MixedListRow mixedListRow, long l, long l2, RouteInfoHelper routeInfoHelper) {
        this.helper = routeInfoHelper;
        this.mTurnElement = turnListElement;
        this.mMixedListRow = mixedListRow;
        this.mMixedListRow.updateValuesForTurns(this.mTurnElement);
        this.mFormat = routeInfoHelper.getDefaultFormat(turnListElement, routeInfoHelper.env);
        this.init(turnListElement, routeInfoHandler$TravelData, l, l2);
    }

    @Override
    public boolean isRealTurnElement() {
        if (null == this.mTurnElement.getManeuver() || this.mTurnElement.getManeuver().length == 0) {
            return false;
        }
        return this.helper.isRealTurnElement(this.mTurnElement.getManeuver()[0]);
    }

    @Override
    public boolean updateDistanceToCar(long l) {
        int n;
        super.updateDistanceToCar(l);
        String string = this.helper.formatDistString(this.getDistanceToCar());
        int n2 = n = this.mFormat == 8 ? 26 : 19;
        if (!string.equals(this.mMixedListRow.getText(n))) {
            this.mMixedListRow.setText(n, string);
            return true;
        }
        return false;
    }

    @Override
    public boolean isBorderCrossingSpeedInfoAvailable() {
        if (this.mMixedListRow == null) {
            return false;
        }
        HMIResourceLocator hMIResourceLocator = ((IconCell)this.mMixedListRow.getCell(30)).getResourceLocator();
        HMIResourceLocator hMIResourceLocator2 = ((IconCell)this.mMixedListRow.getCell(30)).getResourceLocator();
        if (hMIResourceLocator != null && hMIResourceLocator2 != null) {
            int n = hMIResourceLocator.getResourceID();
            String string = hMIResourceLocator.getResourceURI();
            int n2 = hMIResourceLocator2.getResourceID();
            String string2 = hMIResourceLocator2.getResourceURI();
            return !(n == -1 && string == HMIResourceLocator.UNDEFINED_URI || n2 == -1 && string2 == HMIResourceLocator.UNDEFINED_URI);
        }
        return false;
    }

    @Override
    public Object getEvent() {
        return this.mTurnElement;
    }

    public int getType() {
        return this.mTurnElement.getType();
    }

    public AdditionalTurnListIcon[] getAdditionalIcons() {
        return this.mTurnElement.additionalIcons;
    }

    @Override
    public boolean isAsia() {
        switch (this.mTurnElement.getType()) {
            case 5: {
                return true;
            }
        }
        return null != this.mTurnElement.additionalIcons && this.mTurnElement.additionalIcons.length > 0 && 4 == this.mTurnElement.additionalIcons[0].type;
    }

    @Override
    public int getDestinationIndex() {
        return this.mTurnElement.destinationIndex;
    }

    public String toString() {
        Buffer buffer = new Buffer("[TURN] ").append(this.mMixedListRow.getShortDescription()).append(" (UID: ").append(this.getUID()).append(", destIndex: ").append(this.getDestinationIndex()).append(", distCarToEvent: ").append(this.getDistanceToCar()).append("m, distEventToFinalDest: ").append(this.mDistToFinalDest).append("m)");
        return buffer.toString();
    }
}

