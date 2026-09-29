/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.browser.app;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.browser.app.AbstractBrowserHandler;

class AbstractBrowserHandler$2
implements TimerListener {
    private final /* synthetic */ AbstractBrowserHandler this$0;

    AbstractBrowserHandler$2(AbstractBrowserHandler abstractBrowserHandler) {
        this.this$0 = abstractBrowserHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        this.this$0.logChannel.log(1078071040, new StringBuffer().append(AbstractBrowserHandler.access$000()).append("#fireTimer: IDLE timer activated").toString());
        this.this$0.handleIdleTimeout();
        Object object = AbstractBrowserHandler.access$100(this.this$0);
        synchronized (object) {
            AbstractBrowserHandler.access$202(this.this$0, null);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void cancelTimer(Timer timer) {
        this.this$0.logChannel.log(1078071040, new StringBuffer().append(AbstractBrowserHandler.access$000()).append("#cancelTimer: cancelling IDLE timer").toString());
        Object object = AbstractBrowserHandler.access$100(this.this$0);
        synchronized (object) {
            AbstractBrowserHandler.access$202(this.this$0, null);
        }
    }
}

