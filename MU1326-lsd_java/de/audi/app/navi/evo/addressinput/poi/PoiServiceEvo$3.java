/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiServiceEvo;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiServiceEvo$3
extends NavCommand {
    private final /* synthetic */ PoiServiceEvo this$0;

    PoiServiceEvo$3(PoiServiceEvo poiServiceEvo, String string) {
        this.this$0 = poiServiceEvo;
        super(string);
    }

    @Override
    public void execute() {
        this.dsiResponseContainer.setSelectedLocation(PoiServiceEvo.access$000(this.this$0).getVehicleLocation());
        this.getCommandList().commandFinished();
    }
}

