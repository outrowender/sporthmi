/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.selection;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.call.NavSimpleCall;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionInfo;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerImpl;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.TryMatchLocationData;
import org.dsi.ifc.navigation.TryMatchLocationResultData;

class MapSelectionHandlerImpl$3
extends NavSimpleCall {
    private final /* synthetic */ MapItemSelectionInfo val$sv;
    private final /* synthetic */ MapSelectionHandlerImpl this$0;

    MapSelectionHandlerImpl$3(MapSelectionHandlerImpl mapSelectionHandlerImpl, LogChannel logChannel, String string, MapItemSelectionInfo mapItemSelectionInfo) {
        this.this$0 = mapSelectionHandlerImpl;
        this.val$sv = mapItemSelectionInfo;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        TryMatchLocationData tryMatchLocationData = new TryMatchLocationData();
        tryMatchLocationData.latitude = this.val$sv.posInfo.tLocation.latitude;
        tryMatchLocationData.longitude = this.val$sv.posInfo.tLocation.longitude;
        tryMatchLocationData.poiName = this.val$sv.posInfo.infoTxt;
        tryMatchLocationData.poiCategory = (int)this.val$sv.posInfo.objectId;
        this.this$0.getLogger().log(-2137614336, "%1#execute() - calling liTryMatchLocation( %2 ) ", (Object)this.getName(), (Object)tryMatchLocationData);
        this.logger.log(-2137614336, "%1#execute() - calling liTryMatchLocation( %2 ) ", (Object)this.getName(), (Object)tryMatchLocationData);
        this.this$0.naviMap.getNaviInterface().getDSINavigationManager().getDSINavigation(0).liTryMatchLocation(tryMatchLocationData);
    }

    @Override
    public void liTryMatchLocationResult(TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
        if (tryMatchLocationResultDataArray != null && tryMatchLocationResultDataArray.length > 0) {
            NavLocation navLocation = tryMatchLocationResultDataArray[0].getLocation();
            if (navLocation != null && (navLocation.longitude != 0 || navLocation.latitude != 0)) {
                String string;
                this.val$sv.navLocationPoiOnboardGoogle = navLocation;
                this.val$sv.navLocationAdditionalInfo = navLocation;
                if (this.this$0.getLogger().isDebug2()) {
                    for (int i2 = 0; i2 < tryMatchLocationResultDataArray.length; ++i2) {
                        this.this$0.getLogger().log(14808325, "MapSelectionHandlerImpl#postLiTryMatchLocationResult() - [%2/%3] = %1", (Object)tryMatchLocationResultDataArray[i2], (long)i2, (long)tryMatchLocationResultDataArray.length);
                    }
                }
                if (!Util.isEmpty(string = LocationFormatter.formatPOIName(this.val$sv.navLocationPoiOnboardGoogle))) {
                    this.val$sv.textDescriptionSingleLine = this.this$0.env.getTooltipFormatter().formatPOI(this.val$sv.navLocationPoiOnboardGoogle);
                } else {
                    this.this$0.getLogger().log(1078071040, "MapSelectionHandlerImpl#postLiTryMatchLocationResult() - POI name not available - use default format");
                    this.val$sv.textDescriptionSingleLine = this.this$0.env.getTooltipFormatter().formatLocation(this.val$sv.navLocationPoiOnboardGoogle);
                }
                if (Util.isEmpty(this.val$sv.textDescriptionSingleLine)) {
                    this.this$0.getLogger().log(-1601830656, "MapSelectionHandlerImpl#postLiTryMatchLocationResult() - failed to retrieve tooltip string - try to use geocoordinates!");
                    this.val$sv.textDescriptionSingleLine = this.this$0.env.getTooltipFormatter().formatFallback(this.val$sv.navLocationPoiOnboardGoogle);
                }
                if (!Util.isEmpty(this.val$sv.textDescriptionSingleLine)) {
                    this.val$sv.setResolved(true);
                    this.this$0.fireShowToolTip(this.val$sv);
                } else {
                    this.this$0.getLogger().log(-1601830656, "MapSelectionHandlerImpl#postLiTryMatchLocationResult() - failed to retrieve tooltip string - cannot show tooltip!");
                    this.val$sv.setResolved(false);
                }
            } else {
                this.this$0.getLogger().log(10000, "MapSelectionHandlerImpl#postLiTryMatchLocationResult() - no valid result %1", (Object)LocationFormatter.formatLocationShort(navLocation));
                this.val$sv.setResolved(false);
            }
        } else {
            this.this$0.getLogger().log(-2137614336, "MapSelectionHandlerImpl#postLiTryMatchLocationResult() - no result");
            this.val$sv.setResolved(false);
        }
        this.callFinished();
    }
}

