/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.map.dsi.ZoomHandler;

class ZoomHandler$1
extends DefaultTimerListener {
    private final /* synthetic */ ZoomHandler this$0;

    ZoomHandler$1(ZoomHandler zoomHandler) {
        this.this$0 = zoomHandler;
    }

    @Override
    public void fireTimer(Timer timer) {
        int n = this.this$0.getZoomListIndex();
        this.this$0.getLogChannel().log(-2137614336, "ZoomHandler<GuiUpdateBlocker>#fireTimer() - last updated zoom index %1", (long)n);
        this.this$0.naviMap.getGuiInterface().setMagnification(n);
    }
}

