/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.memory;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.memory.TourHandlerHmiListener;

public final class TourHandlerHmiListener$StartGuidance
extends NavCommand {
    private final /* synthetic */ TourHandlerHmiListener this$0;

    public TourHandlerHmiListener$StartGuidance(TourHandlerHmiListener tourHandlerHmiListener) {
        this.this$0 = tourHandlerHmiListener;
    }

    @Override
    public void execute() {
        this.this$0.logChannel.log(-2137614336, "TourHandler.StartGuidance#execute()");
        this.getCommandList().commandFinishedWithPostSequence(this.navigation.getRouteManager().getStartGuidanceSequence());
    }
}

