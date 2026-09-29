/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.memory;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.memory.TourHandlerHmiListener;

class TourHandlerHmiListener$1
extends NavCommand {
    private final /* synthetic */ TourHandlerHmiListener this$0;

    TourHandlerHmiListener$1(TourHandlerHmiListener tourHandlerHmiListener, String string) {
        this.this$0 = tourHandlerHmiListener;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.wantedToDeactivate = false;
        this.getCommandList().commandFinished();
    }
}

