/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.map.dsi.MVRequestControl;

class MVRequestControl$1
extends DefaultTimerListener {
    private final /* synthetic */ MVRequestControl this$0;

    MVRequestControl$1(MVRequestControl mVRequestControl) {
        this.this$0 = mVRequestControl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        MVRequestControl mVRequestControl = this.this$0;
        synchronized (mVRequestControl) {
            if (this.this$0.getInfoForPositionIsActive()) {
                this.this$0.getLogger().log(-1601830656, "MVRequestControl#GetInfoForPosition#fireTimer() - force clear mGetInfoForPositionActive");
                MVRequestControl.access$002(this.this$0, false);
            }
        }
    }
}

