/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiRightDrawerHmiListener;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;

class AbstractPoiRightDrawerHmiListener$4
extends NavCommand {
    private final /* synthetic */ AbstractPoiRightDrawerHmiListener this$0;

    AbstractPoiRightDrawerHmiListener$4(AbstractPoiRightDrawerHmiListener abstractPoiRightDrawerHmiListener) {
        this.this$0 = abstractPoiRightDrawerHmiListener;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1 - show in map location = %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(this.dsiResponseContainer.getSelectedLocation()));
        this.this$0.mapInterface.destOptShowInMap(this.dsiResponseContainer.getSelectedLocation());
        this.getCommandList().commandFinished();
    }
}

