/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.memory;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.RmMakeRoutePersistentCommand;
import de.audi.tghu.navi.app.memory.TourHandlerHmiListener;

public final class TourHandlerHmiListener$SetLoadedTour
extends NavCommand {
    private final /* synthetic */ TourHandlerHmiListener this$0;

    public TourHandlerHmiListener$SetLoadedTour(TourHandlerHmiListener tourHandlerHmiListener) {
        this.this$0 = tourHandlerHmiListener;
    }

    @Override
    public void execute() {
        this.this$0.logChannel.log(-2137614336, "TourHandler.SetLoadedTour#execute()");
        this.getCommandList().commandFinishedWithPostCommand(new RmMakeRoutePersistentCommand(this.this$0.tourHandler.getLoadedTour()));
    }
}

