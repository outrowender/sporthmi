/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.NaviOnlineService$RrdData;
import de.audi.atip.interapp.NavigationUtilities;
import de.audi.atip.util.Util;
import de.audi.remotehmi.ui.mib2.grid.GeoPosition;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IGridAction;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.tghu.online.app.remotehmi.RrdCalculationHandler;
import java.util.ArrayList;

class RrdCalculationHandler$1
implements IGridAction {
    private final /* synthetic */ IGridList val$mainGridList;
    private final /* synthetic */ ArrayList val$rrdEntries;
    private final /* synthetic */ Integer val$listStart;
    private final /* synthetic */ GeoPosition val$rrdReferencePointGeoLocation;
    private final /* synthetic */ Integer val$referenceLatitude;
    private final /* synthetic */ Integer val$referenceLongitude;
    private final /* synthetic */ RrdCalculationHandler this$0;

    RrdCalculationHandler$1(RrdCalculationHandler rrdCalculationHandler, IGridList iGridList, ArrayList arrayList, Integer n, GeoPosition geoPosition, Integer n2, Integer n3) {
        this.this$0 = rrdCalculationHandler;
        this.val$mainGridList = iGridList;
        this.val$rrdEntries = arrayList;
        this.val$listStart = n;
        this.val$rrdReferencePointGeoLocation = geoPosition;
        this.val$referenceLatitude = n2;
        this.val$referenceLongitude = n3;
    }

    @Override
    public boolean modify(IGrid iGrid) {
        GeoPosition geoPosition = iGrid.getGeoPosition();
        if (geoPosition == null) {
            return false;
        }
        if (!iGrid.hasRRDItems()) {
            return false;
        }
        NaviOnlineService$RrdData naviOnlineService$RrdData = new NaviOnlineService$RrdData();
        naviOnlineService$RrdData.setIdRangeStart(this.val$mainGridList.getIdRangeStart());
        this.val$rrdEntries.add(naviOnlineService$RrdData);
        naviOnlineService$RrdData.setModelAndContainer(this.val$mainGridList, iGrid);
        String string = iGrid.getId();
        naviOnlineService$RrdData.setId(string);
        Integer n = Util.createInteger(NavigationUtilities.degreeToWgs84(geoPosition.getLatitude()));
        Integer n2 = Util.createInteger(NavigationUtilities.degreeToWgs84(geoPosition.getLongitude()));
        naviOnlineService$RrdData.setLatitude(n);
        naviOnlineService$RrdData.setLongitude(n2);
        this.this$0.logChannel.log(-2137614336, "RrdCalculationHandler#triggerRrdCalculation: point (%1;%2) set for gridId='%3', list start=%4", (Object)n, (Object)n2, (Object)string, (Object)this.val$listStart);
        if (this.val$rrdReferencePointGeoLocation != null) {
            naviOnlineService$RrdData.setRrdReferenceLatitude(this.val$referenceLatitude);
            naviOnlineService$RrdData.setRrdReferenceLongitude(this.val$referenceLongitude);
        }
        return true;
    }
}

