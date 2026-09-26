/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.dsi;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.swdl.app.dsi.SwdlDSIManager;

class SwdlDSIManager$1
implements TimerListener {
    private final /* synthetic */ SwdlDSIManager this$0;

    SwdlDSIManager$1(SwdlDSIManager swdlDSIManager) {
        this.this$0 = swdlDSIManager;
    }

    @Override
    public void fireTimer(Timer timer) {
        SwdlDSIManager.access$100(this.this$0, SwdlDSIManager.access$000(this.this$0));
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

