/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.listener.PoiRightDrawerHmiListener;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class PoiRightDrawerHmiListener$1
extends NavCommand {
    private final /* synthetic */ NavLocation val$navLocation;
    private final /* synthetic */ PoiRightDrawerHmiListener this$0;

    PoiRightDrawerHmiListener$1(PoiRightDrawerHmiListener poiRightDrawerHmiListener, String string, NavLocation navLocation) {
        this.this$0 = poiRightDrawerHmiListener;
        this.val$navLocation = navLocation;
        super(string);
    }

    @Override
    public void execute() {
        this.dsiResponseContainer.setSelectedLocation(this.val$navLocation);
        this.getCommandList().commandFinished();
    }
}

