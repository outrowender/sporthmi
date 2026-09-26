/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.listener.PoiResultScreenWithSpellerHmiListener;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiResultScreenWithSpellerHmiListener$1
extends NavCommand {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ PoiResultScreenWithSpellerHmiListener this$0;

    PoiResultScreenWithSpellerHmiListener$1(PoiResultScreenWithSpellerHmiListener poiResultScreenWithSpellerHmiListener, String string, int n) {
        this.this$0 = poiResultScreenWithSpellerHmiListener;
        this.val$model = n;
        super(string);
    }

    @Override
    public void execute() {
        PoiResultScreenWithSpellerHmiListener.access$000(this.this$0, this.val$model);
        this.getCommandList().commandFinished();
    }
}

