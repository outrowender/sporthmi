/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiSDSHandlerEvo;
import de.audi.app.navi.evo.addressinput.poi.models.GuiModelAccessDetailsLocationPoi;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class PoiSDSHandlerEvo$1
extends NavCommand {
    private final /* synthetic */ PoiSDSHandlerEvo this$0;

    PoiSDSHandlerEvo$1(PoiSDSHandlerEvo poiSDSHandlerEvo, String string) {
        this.this$0 = poiSDSHandlerEvo;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        GuiModelAccessDetailsLocationPoi guiModelAccessDetailsLocationPoi = new GuiModelAccessDetailsLocationPoi(this.env, PoiSDSHandlerEvo.access$000(this.this$0), PoiSDSHandlerEvo.access$100(this.this$0));
        guiModelAccessDetailsLocationPoi.onUpdateLocation(navLocation);
        PoiSDSHandlerEvo.access$200(this.this$0).enterDetailsScreen(navLocation);
        this.getCommandList().commandFinished();
    }
}

