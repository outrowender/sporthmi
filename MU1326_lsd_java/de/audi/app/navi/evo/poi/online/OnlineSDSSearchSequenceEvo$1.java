/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.poi.online;

import de.audi.app.navi.evo.poi.online.OnlineSDSSearchSequenceEvo;
import de.audi.tghu.navi.app.command.NavCommand;

class OnlineSDSSearchSequenceEvo$1
extends NavCommand {
    private final /* synthetic */ int val$row;
    private final /* synthetic */ OnlineSDSSearchSequenceEvo this$0;

    OnlineSDSSearchSequenceEvo$1(OnlineSDSSearchSequenceEvo onlineSDSSearchSequenceEvo, String string, int n) {
        this.this$0 = onlineSDSSearchSequenceEvo;
        this.val$row = n;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.setSelectedLocation(this.val$row);
        this.getCommandList().commandFinished();
    }
}

