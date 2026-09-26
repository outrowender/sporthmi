/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.selection;

import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionInfo;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerImpl;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerImpl$NavResolveCall;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

class MapSelectionHandlerImpl$2
extends MapSelectionHandlerImpl$NavResolveCall {
    private final /* synthetic */ MapItemSelectionInfo val$sv;
    private final /* synthetic */ MapSelectionHandlerImpl this$0;

    MapSelectionHandlerImpl$2(MapSelectionHandlerImpl mapSelectionHandlerImpl, String string, NavLocation navLocation, MapItemSelectionInfo mapItemSelectionInfo) {
        this.this$0 = mapSelectionHandlerImpl;
        this.val$sv = mapItemSelectionInfo;
        super(mapSelectionHandlerImpl, string, navLocation);
    }

    @Override
    public void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
        if (!Util.isEmpty(this.val$sv.posInfo.infoTxt)) {
            Util.setOnlinePOINameOnLocation(navLocation, this.val$sv.posInfo.infoTxt);
        }
        this.this$0.getLogger().log(-2137614336, "ResolveXTRepresentationCall#liGetLocationDescriptionTransformResult() - resolvedLocation: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
        this.val$sv.navLocationXtResolved = navLocation;
        this.val$sv.Url = this.val$sv.posInfo.getUrl();
        Util.setURLOnLocation(navLocation, this.val$sv.Url);
        String string = LocationFormatter.formatPOIName(navLocation);
        this.val$sv.textDescriptionSingleLine = !Util.isEmpty(string) ? this.this$0.env.getTooltipFormatter().formatPOI(navLocation) : this.this$0.env.getTooltipFormatter().formatLocation(navLocation);
        if (Util.isEmpty(this.val$sv.textDescriptionSingleLine)) {
            this.this$0.getLogger().log(-1601830656, "DefaultTooltipFormatter#formatXT() - failed to retrieve tooltip string!");
            this.val$sv.textDescriptionSingleLine = this.this$0.env.getTooltipFormatter().formatFallback(navLocation);
        }
        this.val$sv.setResolved(true);
        this.this$0.fireShowToolTip(this.val$sv);
        this.callFinished();
    }
}

