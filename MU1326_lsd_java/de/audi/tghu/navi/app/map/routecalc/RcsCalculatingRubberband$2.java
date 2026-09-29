/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.command.via.RgPrepareRubberbandCommand;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingRubberband;

class RcsCalculatingRubberband$2
extends RgPrepareRubberbandCommand {
    private final /* synthetic */ RcsCalculatingRubberband this$0;

    RcsCalculatingRubberband$2(RcsCalculatingRubberband rcsCalculatingRubberband, boolean bl) {
        this.this$0 = rcsCalculatingRubberband;
        super(bl);
    }

    @Override
    public void execute() {
        if (!this.this$0.getStateMachine().isCalculatingRubberband()) {
            this.this$0.getLogger().log(-1601830656, "RcsCalculatingRubberband#finishPrepareRubberbandAndStart#NotifyRubberbandPrepared() - not in rubberband state anymore!");
            this.getCommandList().commandFinished();
            return;
        }
        this.this$0.getLogger().log(-2137614336, "RcsCalculatingRubberband#prepareRubberband() - call rgPrepareRubberbandManipulation");
        if (this.this$0.getData().rbbPoint != null) {
            RcsCalculatingRubberband.access$002(this.this$0, this.this$0.getData().rbbPoint);
            this.this$0.getData().rbbPoint = null;
            this.this$0.getLogger().log(-2137614336, "RcsCalculatingRubberband#prepareRubberband() - restore last rbPoint : %1", (Object)RcsCalculatingRubberband.access$000(this.this$0));
        }
        super.execute();
        this.getCommandList().commandFinished();
    }
}

