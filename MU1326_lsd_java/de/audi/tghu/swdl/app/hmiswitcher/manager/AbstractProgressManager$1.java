/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractProgressManager;

class AbstractProgressManager$1
implements TimerListener {
    String text = "";
    private final /* synthetic */ AbstractProgressManager this$0;

    AbstractProgressManager$1(AbstractProgressManager abstractProgressManager) {
        this.this$0 = abstractProgressManager;
    }

    @Override
    public void cancelTimer(Timer timer) {
        this.this$0.getSwdlModels().getRebootCountdown().setText("");
    }

    @Override
    public void fireTimer(Timer timer) {
        this.text = new StringBuffer().append(this.text).append(".").toString();
        this.this$0.getSwdlModels().getRebootCountdown().setText(this.text);
    }
}

