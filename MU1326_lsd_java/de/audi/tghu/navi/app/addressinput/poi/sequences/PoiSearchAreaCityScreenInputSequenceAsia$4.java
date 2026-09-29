/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiSearchAreaCityScreenInputSequenceAsia;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class PoiSearchAreaCityScreenInputSequenceAsia$4
extends NavCommand {
    private final /* synthetic */ PoiSearchAreaCityScreenInputSequenceAsia this$0;

    PoiSearchAreaCityScreenInputSequenceAsia$4(PoiSearchAreaCityScreenInputSequenceAsia poiSearchAreaCityScreenInputSequenceAsia) {
        this.this$0 = poiSearchAreaCityScreenInputSequenceAsia;
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

