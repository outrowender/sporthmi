/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.base;

import de.audi.atip.base.Framework;
import de.audi.atip.base.FrameworkAccess;
import de.audi.atip.hmi.IRootWindow;
import de.audi.atip.hmi.event.VRAMEvent;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class Framework$1
implements TimerListener {
    private final /* synthetic */ FrameworkAccess val$access;
    private final /* synthetic */ Framework this$0;

    Framework$1(Framework framework, FrameworkAccess frameworkAccess) {
        this.this$0 = framework;
        this.val$access = frameworkAccess;
    }

    @Override
    public void fireTimer(Timer timer) {
        Framework.access$000(this.this$0).log(-1601830656, "free j9 Heap: %1", Runtime.getRuntime().freeMemory());
        IRootWindow iRootWindow = this.val$access.getHMIService().getRootWindow(0);
        this.val$access.getHMIService().getEventDispatcher().postEvent(new VRAMEvent(iRootWindow));
        Framework.access$100(this.this$0);
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

