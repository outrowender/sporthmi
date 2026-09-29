/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.impl;

import de.audi.tghu.navi.app.map.command.MapCommand;
import de.audi.tghu.navi.app.map.impl.PinHandler;
import de.audi.tghu.navi.app.map.utils.MapPin;

class PinHandler$1
extends MapCommand {
    private final /* synthetic */ MapPin[] val$pins;
    private final /* synthetic */ PinHandler this$0;

    PinHandler$1(PinHandler pinHandler, String string, MapPin[] mapPinArray) {
        this.this$0 = pinHandler;
        this.val$pins = mapPinArray;
        super(string);
    }

    @Override
    public void execute() {
        try {
            PinHandler.access$000(this.this$0).log(-2137614336, "PinHandler#setPins() - update pin List");
            this.this$0.pinList.clear();
            for (int i2 = 0; i2 < this.val$pins.length; ++i2) {
                if (this.this$0.pinList.contains(this.val$pins[i2])) continue;
                this.this$0.pinList.add(this.val$pins[i2]);
            }
        }
        catch (Exception exception) {
            PinHandler.access$000(this.this$0).log(-1601830656, "PinHandler#setPins() - %1", (Throwable)exception);
        }
        this.getCommandList().commandFinished();
    }
}

