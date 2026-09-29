/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.listener.PoiResultScreenWithMatchSpellerHmiListener;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiResultScreenWithMatchSpellerHmiListener$1
extends NavCommand {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ PoiResultScreenWithMatchSpellerHmiListener this$0;

    PoiResultScreenWithMatchSpellerHmiListener$1(PoiResultScreenWithMatchSpellerHmiListener poiResultScreenWithMatchSpellerHmiListener, String string, int n) {
        this.this$0 = poiResultScreenWithMatchSpellerHmiListener;
        this.val$model = n;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.displayPoisInPreviewMap(this.val$model);
        this.getCommandList().commandFinished();
    }
}

