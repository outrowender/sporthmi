/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.details;

import de.audi.app.navi.evo.addressinput.poi.details.MapPoiStackHMIListener;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

class MapPoiStackHMIListener$1
extends NavCommand {
    private final /* synthetic */ MapPoiStackHMIListener this$0;

    MapPoiStackHMIListener$1(MapPoiStackHMIListener mapPoiStackHMIListener, String string) {
        this.this$0 = mapPoiStackHMIListener;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getSelectedLocation();
        this.logger.log(-2137614336, "selectedLocation=%1", (Object)LocationFormatter.formatLocationShort(navLocation));
        MapPoiStackHMIListener.access$000(this.this$0).setPreviewPOIsOnboard(new NavLocation[]{navLocation}, 1, null, null);
        this.getCommandList().commandFinished();
    }
}

