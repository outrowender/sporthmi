/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiScreenInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class AbstractPoiScreenInputSequence$1
extends NavCommand {
    private final /* synthetic */ NavLocation[] val$poiNavLocations;
    private final /* synthetic */ int val$j;
    private final /* synthetic */ AbstractPoiScreenInputSequence this$0;

    AbstractPoiScreenInputSequence$1(AbstractPoiScreenInputSequence abstractPoiScreenInputSequence, String string, NavLocation[] navLocationArray, int n) {
        this.this$0 = abstractPoiScreenInputSequence;
        this.val$poiNavLocations = navLocationArray;
        this.val$j = n;
        super(string);
    }

    @Override
    public void execute() {
        this.val$poiNavLocations[this.val$j] = this.dsiResponseContainer.getSelectedLocation();
        this.getCommandList().commandFinished();
    }
}

