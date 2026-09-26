/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiSearchAreaCityScreenInputSequenceAsia;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class PoiSearchAreaCityScreenInputSequenceAsia$1
extends NavCommand {
    private final /* synthetic */ PoiSearchAreaCityScreenInputSequenceAsia this$0;

    PoiSearchAreaCityScreenInputSequenceAsia$1(PoiSearchAreaCityScreenInputSequenceAsia poiSearchAreaCityScreenInputSequenceAsia, String string) {
        this.this$0 = poiSearchAreaCityScreenInputSequenceAsia;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand((NavLocation)this.getCommandList().get("STRIPPED_LOCATION")));
    }
}

