/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.memory;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.memory.TourHandler;

class TourHandler$1
extends NavCommand {
    private final /* synthetic */ int val$tourIndex;
    private final /* synthetic */ int val$memoryID;
    private final /* synthetic */ long val$tourID;
    private final /* synthetic */ TourHandler this$0;

    TourHandler$1(TourHandler tourHandler, int n, int n2, long l) {
        this.this$0 = tourHandler;
        this.val$tourIndex = n;
        this.val$memoryID = n2;
        this.val$tourID = l;
    }

    @Override
    public void execute() {
        this.this$0.showTour(this.val$tourIndex, this.val$memoryID, this.val$tourID, TourHandler.access$000(this.this$0));
        this.getCommandList().commandFinished();
    }
}

