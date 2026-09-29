/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.impl;

import de.audi.tghu.navi.app.map.command.MapCommand;
import de.audi.tghu.navi.app.map.impl.PinHandler;

class PinHandler$2
extends MapCommand {
    private final /* synthetic */ PinHandler this$0;

    PinHandler$2(PinHandler pinHandler, String string) {
        this.this$0 = pinHandler;
        super(string);
    }

    @Override
    public void execute() {
        try {
            PinHandler.access$000(this.this$0).log(-2137614336, "PinHandler#cleanAllPins() - update pin list");
            this.this$0.pinList.clear();
        }
        catch (Exception exception) {
            PinHandler.access$000(this.this$0).log(-1601830656, "PinHandler#cleanAllPins() - %1", (Throwable)exception);
        }
        this.getCommandList().commandFinished();
    }
}

