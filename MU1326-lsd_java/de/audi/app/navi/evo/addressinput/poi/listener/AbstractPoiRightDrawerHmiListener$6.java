/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiRightDrawerHmiListener;
import de.audi.tghu.navi.app.command.NavCommand;

class AbstractPoiRightDrawerHmiListener$6
extends NavCommand {
    private final /* synthetic */ AbstractPoiRightDrawerHmiListener this$0;

    AbstractPoiRightDrawerHmiListener$6(AbstractPoiRightDrawerHmiListener abstractPoiRightDrawerHmiListener) {
        this.this$0 = abstractPoiRightDrawerHmiListener;
    }

    @Override
    public void execute() {
        this.this$0.naviFavoriteHandler.addToFavorites(this.dsiResponseContainer.getSelectedLocation());
        this.getCommandList().commandFinished();
    }
}

