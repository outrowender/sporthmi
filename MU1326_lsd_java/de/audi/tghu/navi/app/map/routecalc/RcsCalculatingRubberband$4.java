/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingRubberband;

class RcsCalculatingRubberband$4
extends NavCommand {
    private final /* synthetic */ RcsCalculatingRubberband this$0;

    RcsCalculatingRubberband$4(RcsCalculatingRubberband rcsCalculatingRubberband, String string) {
        this.this$0 = rcsCalculatingRubberband;
        super(string);
    }

    @Override
    public void execute() {
        if (!this.this$0.getStateMachine().isCalculatingRubberband()) {
            this.this$0.getLogger().log(-1601830656, "RcsCalculatingRubberband#finishPrepareRubberbandAndStart#NotifyRubberbandPrepared() - not in rubberband state anymore!");
            this.getCommandList().commandFinished();
            return;
        }
        this.this$0.getLogger().log(1078071040, "RcsCalculatingRubberband#finishPrepareRubberbandAndStart#NotifyRubberbandPrepared() ");
        this.this$0.setRbbState(2);
        this.this$0.getStateMachine().naviMap.onEvent(204);
        this.getCommandList().commandFinished();
    }
}

