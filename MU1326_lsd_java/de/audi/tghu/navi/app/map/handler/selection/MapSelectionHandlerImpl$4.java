/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.selection;

import de.audi.tghu.navi.app.PicNavNaviInterfaceImpl;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionInfo;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerImpl;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerImpl$NavResolveCall;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

class MapSelectionHandlerImpl$4
extends MapSelectionHandlerImpl$NavResolveCall {
    private final /* synthetic */ MapItemSelectionInfo val$sv;
    private final /* synthetic */ MapSelectionHandlerImpl this$0;

    MapSelectionHandlerImpl$4(MapSelectionHandlerImpl mapSelectionHandlerImpl, String string, NavLocation navLocation, MapItemSelectionInfo mapItemSelectionInfo) {
        this.this$0 = mapSelectionHandlerImpl;
        this.val$sv = mapItemSelectionInfo;
        super(mapSelectionHandlerImpl, string, navLocation);
    }

    @Override
    public void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
        this.logger.log(-2137614336, "ResolvePicNavLocationCall#liGetLocationDescriptionTransformResult() - resolvedLocation: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
        PicNavNaviInterfaceImpl.createPicNavLocationStatic(navLocation, this.val$sv.getPicNavLocator());
        this.val$sv.navLocationPicNavTransformed = navLocation;
        String string = this.this$0.env.getTooltipFormatter().formatPicNavLocation(navLocation);
        if (Util.isEmpty(string)) {
            this.this$0.getLogger().log(-1601830656, "MapSelectionHandlerImpl#updatePicNavLocation() - failed to retrieve tooltip string, showing only the picture!");
            string = "";
        }
        this.val$sv.textDescriptionSingleLine = string;
        this.val$sv.setResolved(true);
        this.this$0.fireShowToolTip(this.val$sv);
        this.callFinished();
    }
}

