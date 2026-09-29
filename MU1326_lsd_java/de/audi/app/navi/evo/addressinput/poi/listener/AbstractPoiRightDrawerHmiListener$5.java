/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiRightDrawerHmiListener;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class AbstractPoiRightDrawerHmiListener$5
extends NavCommand {
    private final /* synthetic */ NavLocation val$navLocation;
    private final /* synthetic */ AbstractPoiRightDrawerHmiListener this$0;

    AbstractPoiRightDrawerHmiListener$5(AbstractPoiRightDrawerHmiListener abstractPoiRightDrawerHmiListener, String string, NavLocation navLocation) {
        this.this$0 = abstractPoiRightDrawerHmiListener;
        this.val$navLocation = navLocation;
        super(string);
    }

    @Override
    public void execute() {
        this.dsiResponseContainer.setSelectedLocation(this.val$navLocation);
        this.getCommandList().commandFinished();
    }
}

