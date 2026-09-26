/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener.asia;

import de.audi.app.navi.evo.addressinput.poi.listener.asia.PoiResultScreenWithMatchSpellerListenerAsia;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiResultScreenWithMatchSpellerListenerAsia$1
extends NavCommand {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ PoiResultScreenWithMatchSpellerListenerAsia this$0;

    PoiResultScreenWithMatchSpellerListenerAsia$1(PoiResultScreenWithMatchSpellerListenerAsia poiResultScreenWithMatchSpellerListenerAsia, String string, int n) {
        this.this$0 = poiResultScreenWithMatchSpellerListenerAsia;
        this.val$model = n;
        super(string);
    }

    @Override
    public void execute() {
        PoiResultScreenWithMatchSpellerListenerAsia.access$000(this.this$0, this.val$model);
        this.getCommandList().commandFinished();
    }
}

