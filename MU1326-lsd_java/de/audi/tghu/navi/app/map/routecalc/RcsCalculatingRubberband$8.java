/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingRubberband;

class RcsCalculatingRubberband$8
extends NavCommand {
    private final /* synthetic */ RcsCalculatingRubberband this$0;

    RcsCalculatingRubberband$8(RcsCalculatingRubberband rcsCalculatingRubberband, String string) {
        this.this$0 = rcsCalculatingRubberband;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.getLogger().log(-2137614336, "RcsCalculatingRubberband#cancelRubberband() - NotifyRubberbandCanceled");
        this.this$0.getStateMachine().naviMap.onEvent(207);
        this.this$0.getStateMachine().naviMap.getMVRequest().setDragRouteMarker(0);
        this.getCommandList().commandFinished();
    }
}

