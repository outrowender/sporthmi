/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.searcharea;

import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchAreaSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class PoiSearchAreaSequence$4
extends NavCommand {
    private final /* synthetic */ PoiSearchAreaSequence this$0;

    PoiSearchAreaSequence$4(PoiSearchAreaSequence poiSearchAreaSequence) {
        this.this$0 = poiSearchAreaSequence;
    }

    @Override
    public void execute() {
        Object object = this.getCommandList().get("NavLocation from History");
        if (object instanceof NavLocation) {
            this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand((NavLocation)object));
        } else {
            this.getCommandList().commandAborted("unexpected Object");
        }
    }
}

