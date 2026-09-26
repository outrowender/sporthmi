/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.listener.PoiParkingNearDestinationScreenHmiListener;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiParkingNearDestinationScreenHmiListener$1
extends NavCommand {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ PoiParkingNearDestinationScreenHmiListener this$0;

    PoiParkingNearDestinationScreenHmiListener$1(PoiParkingNearDestinationScreenHmiListener poiParkingNearDestinationScreenHmiListener, String string, int n) {
        this.this$0 = poiParkingNearDestinationScreenHmiListener;
        this.val$model = n;
        super(string);
    }

    @Override
    public void execute() {
        PoiParkingNearDestinationScreenHmiListener.access$000(this.this$0, this.val$model);
        this.getCommandList().commandFinished();
    }
}

