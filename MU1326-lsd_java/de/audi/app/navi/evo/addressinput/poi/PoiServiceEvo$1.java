/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiServiceEvo;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class PoiServiceEvo$1
extends NavCommand {
    private final /* synthetic */ NavLocation val$destination;
    private final /* synthetic */ PoiServiceEvo this$0;

    PoiServiceEvo$1(PoiServiceEvo poiServiceEvo, String string, NavLocation navLocation) {
        this.this$0 = poiServiceEvo;
        this.val$destination = navLocation;
        super(string);
    }

    @Override
    public void execute() {
        this.dsiResponseContainer.setSelectedLocation(this.val$destination);
        this.getCommandList().commandFinished();
    }
}

