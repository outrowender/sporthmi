/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.command.via.RgGetRouteBoundingRect;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingRubberband;
import org.dsi.ifc.global.NavRectangle;

class RcsCalculatingRubberband$3
extends RgGetRouteBoundingRect {
    private final /* synthetic */ RcsCalculatingRubberband this$0;

    RcsCalculatingRubberband$3(RcsCalculatingRubberband rcsCalculatingRubberband, boolean bl, int n) {
        this.this$0 = rcsCalculatingRubberband;
        super(bl, n);
    }

    @Override
    public void rgGetRouteBoundingRectangleResult(NavRectangle navRectangle) {
        if (!this.this$0.getStateMachine().isCalculatingRubberband()) {
            this.this$0.getLogger().log(-1601830656, "RcsCalculatingRubberband#finishPrepareRubberbandAndStart#NotifyRubberbandPrepared() - not in rubberband state anymore!");
            this.getCommandList().commandFinished();
            return;
        }
        this.this$0.getLogger().log(-2137614336, "RcsCalculatingRubberband#finishPrepareRubberbandAndStart#rgGetRouteBoundingRectangleResult( %1 )", (Object)navRectangle);
        this.this$0.getStateMachine().naviMap.getMapDataContainer().rubberbandViewPort = navRectangle;
        this.getCommandList().commandFinished();
    }
}

