/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.event.TimerEvent;
import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractIdleTimerController;
import de.esolutions.hmi.widgets.audi.evo.LockingManager;

public class LockingManager$LockingTimer
extends AbstractIdleTimerController {
    private final /* synthetic */ LockingManager this$0;

    public LockingManager$LockingTimer(LockingManager lockingManager, LogChannel logChannel) {
        this.this$0 = lockingManager;
        super(logChannel);
        this.fireWhenOptionDrawerOpen = true;
        this.fireWhenSelectionDrawerOpen = true;
        this.deactivateOnKeyReleased = false;
        this.idleTime = lockingManager.timerDelay;
    }

    @Override
    protected void timerFired() {
        LockingManager.access$000();
    }

    @Override
    public void restartTimer() {
        if (!this.isEnabled()) {
            logChannel.log(-2137614336, "%1#restartTimer: don't restart, because timer is disabled", (Object)this.logPrefix);
            return;
        }
        if (!this.active) {
            logChannel.log(-2137614336, "%1#restartTimer: timer is not active", (Object)this.logPrefix);
            return;
        }
        this.cancelTimer();
        if (this.idleTime > 0) {
            if (this.timerEvent == null) {
                this.timerEvent = new TimerEvent(this);
            }
            logChannel.log(-2137614336, "%1#restartTimer with timeout: %2", (Object)this.logPrefix, (long)this.idleTime);
            this.timerJob = hmiService.getEventDispatcher().postEvent(this.timerEvent, this.idleTime);
        } else {
            logChannel.log(-2137614336, "%1#restartTimer - idleTime: %2 < 0, no timer is started", (Object)this.logPrefix, (long)this.idleTime);
        }
    }

    @Override
    protected boolean shouldExecuteAction() {
        if (!this.isEnabled()) {
            this.lc.log(-2137614336, "%1#shouldExecuteAction: timer is disabled.", (Object)this.logPrefix);
            return false;
        }
        if (!this.active) {
            this.lc.log(-2137614336, "%1#shouldExecuteAction: timer is not active.", (Object)this.logPrefix);
            return false;
        }
        if (!this.fireWhenOptionDrawerOpen && this.isOptionDrawerOpen() && !this.isInOptionDrawer()) {
            this.lc.log(-2137614336, "%1#shouldExecuteAction: option drawer is open.", (Object)this.logPrefix);
            this.restartTimer();
            return false;
        }
        if (!this.fireWhenSelectionDrawerOpen && this.isSelectionDrawerOpen()) {
            this.lc.log(-2137614336, "%1#shouldExecuteAction: selection drawer is open.", (Object)this.logPrefix);
            this.restartTimer();
            return false;
        }
        return true;
    }
}

