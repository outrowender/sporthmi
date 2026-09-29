/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiInputScreensSDSHandler;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiInputScreensSDSHandler$3
extends NavCommand {
    private final /* synthetic */ NaviServiceListener val$naviServiceListener;
    private final /* synthetic */ PoiInputScreensSDSHandler this$0;

    PoiInputScreensSDSHandler$3(PoiInputScreensSDSHandler poiInputScreensSDSHandler, NaviServiceListener naviServiceListener) {
        this.this$0 = poiInputScreensSDSHandler;
        this.val$naviServiceListener = naviServiceListener;
    }

    @Override
    public void execute() {
        this.val$naviServiceListener.responseStartPoiSearchByName((byte)1);
        this.getCommandList().commandFinished();
    }
}

