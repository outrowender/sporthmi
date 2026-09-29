/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.audi.atip.hmi.event.RunnableEvent;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;

class EALManager$IdleRendering
implements Runnable {
    private final boolean asyncLoading;
    private int asyncLoadingCounter;
    private final /* synthetic */ EALManager this$0;

    public EALManager$IdleRendering(EALManager eALManager) {
        this.this$0 = eALManager;
        this.asyncLoading = false;
    }

    public EALManager$IdleRendering(EALManager eALManager, boolean bl) {
        this.this$0 = eALManager;
        this.asyncLoading = bl;
        if (bl) {
            this.asyncLoadingCounter = EALManager.access$000();
        }
    }

    @Override
    public void run() {
        if (this.asyncLoading) {
            EALManager.access$100(this.this$0);
        } else {
            this.this$0.draw();
        }
        if (this.this$0.isPermanentRenderingEnabled() || this.asyncLoading && this.asyncLoadingCounter > 0 && this.this$0.isOpsKzbMergeStarted() && !this.this$0.isOpsKzbMerged()) {
            boolean bl;
            boolean bl2 = bl = !this.this$0.isPermanentRenderingEnabled() && this.asyncLoading;
            if (bl) {
                --this.asyncLoadingCounter;
                if (IWidgetLogChannel.logChannel3DEngine.isDebug() && this.asyncLoadingCounter % 5 == 0) {
                    IWidgetLogChannel.logChannel3DEngine.log(-2137614336, "EALManage.IdleRendering#run asyncLoadingCounter = %1", (long)this.asyncLoadingCounter);
                }
                long l = EALManager.access$200();
                this.this$0.hmiService.getEventDispatcher().postEvent(new RunnableEvent(true, this), l);
            } else {
                this.this$0.hmiService.getEventDispatcher().postEvent(new RunnableEvent(false, this));
            }
        }
    }
}

