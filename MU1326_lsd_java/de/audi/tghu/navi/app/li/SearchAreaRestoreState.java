/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.li;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.addressinput.poi.IShowHideResetSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchAreaSequence;
import de.audi.tghu.navi.app.li.IAdditionalStateInfo;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

public class SearchAreaRestoreState
implements IAdditionalStateInfo {
    private int previousSearchArea;
    private final PoiSearchArea searchArea;
    private final LogChannel logChannel;
    private NavLocation previousSearchLocation;
    private final PoiSearchAreaSequence searchAreaSequence;
    private final IShowHideResetSearchArea poiManager;

    public SearchAreaRestoreState(PoiSearchArea poiSearchArea, PoiSearchAreaSequence poiSearchAreaSequence, LogChannel logChannel, IShowHideResetSearchArea iShowHideResetSearchArea) {
        this.searchArea = poiSearchArea;
        this.searchAreaSequence = poiSearchAreaSequence;
        this.logChannel = logChannel;
        this.poiManager = iShowHideResetSearchArea;
    }

    @Override
    public void gatherInfo() {
        NavLocation navLocation = this.searchArea.getLocation();
        int n = this.searchArea.getSearchContext();
        this.logChannel.log(-2137614336, "SearchAreaRestoreState#gatherInfo - storing current search area; value=%1, location = %2", (Object)new StringBuffer().append(n).append("").toString(), (Object)LocationFormatter.formatLocationShort(navLocation));
        this.previousSearchArea = n;
        this.previousSearchLocation = navLocation;
    }

    @Override
    public void restoreBefore() {
    }

    @Override
    public void restoreAfter() {
        this.logChannel.log(-2137614336, "SearchAreaRestoreState#restoreAfter - restoring search area: value=%1, location = %2", (Object)new StringBuffer().append(this.previousSearchArea).append("").toString(), (Object)LocationFormatter.formatLocationShort(this.previousSearchLocation));
        this.searchAreaSequence.updateSearchArea(this.previousSearchArea, this.previousSearchLocation);
        this.poiManager.showSearchArea();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("searchContext = ").append(this.previousSearchArea);
        stringBuffer.append(" ; ");
        stringBuffer.append("searchLocation = ").append(LocationFormatter.formatLocationShort(this.previousSearchLocation));
        return stringBuffer.toString();
    }
}

