/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.command.via.RgStartRubberBandCommand;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingRubberband;

class RcsCalculatingRubberband$5
extends RgStartRubberBandCommand {
    private final /* synthetic */ RcsCalculatingRubberband this$0;

    RcsCalculatingRubberband$5(RcsCalculatingRubberband rcsCalculatingRubberband, int n) {
        this.this$0 = rcsCalculatingRubberband;
        super(n);
    }

    @Override
    public void execute() {
        if (!this.this$0.getStateMachine().isCalculatingRubberband()) {
            this.this$0.getLogger().log(-1601830656, "RcsCalculatingRubberband#finishPrepareRubberbandAndStart#NotifyRubberbandPrepared() - not in rubberband state anymore!");
            this.getCommandList().commandFinished();
            return;
        }
        this.this$0.data.rgStartRubberbandManipulationResultOK = false;
        this.this$0.setRbbState(3);
        super.execute();
        this.getCommandList().commandFinished();
    }
}

