/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiSearchAreaCityScreenInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class PoiSearchAreaCityScreenInputSequence$3
extends NavCommand {
    private final /* synthetic */ PoiSearchAreaCityScreenInputSequence this$0;

    PoiSearchAreaCityScreenInputSequence$3(PoiSearchAreaCityScreenInputSequence poiSearchAreaCityScreenInputSequence) {
        this.this$0 = poiSearchAreaCityScreenInputSequence;
    }

    @Override
    public void execute() {
        Object object = this.getCommandList().get("NavLocation from History");
        if (object == null || !(object instanceof NavLocation)) {
            this.getCommandList().commandAborted("unexpected Object");
        } else {
            this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand((NavLocation)object));
        }
    }
}

