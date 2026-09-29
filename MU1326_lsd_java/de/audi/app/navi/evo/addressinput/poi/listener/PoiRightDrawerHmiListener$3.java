/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.listener.PoiRightDrawerHmiListener;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiRightDrawerHmiListener$3
extends NavCommand {
    private final /* synthetic */ PoiRightDrawerHmiListener this$0;

    PoiRightDrawerHmiListener$3(PoiRightDrawerHmiListener poiRightDrawerHmiListener, String string) {
        this.this$0 = poiRightDrawerHmiListener;
        super(string);
    }

    @Override
    public void execute() {
        PoiRightDrawerHmiListener.access$000(this.this$0).enterDetailsScreen(this.dsiResponseContainer.getSelectedLocation());
        this.getCommandList().commandFinished();
    }
}

