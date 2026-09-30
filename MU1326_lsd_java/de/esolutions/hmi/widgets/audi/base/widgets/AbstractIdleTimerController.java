/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.widgets;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.TimerEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.IIdleTimerWidget;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public abstract class AbstractIdleTimerController
extends AbstractWidgetController
implements ATIPEventListener,
IIdleTimerWidget {
    protected Job timerJob = null;
    protected TimerEvent timerEvent = null;
    protected int idleTime = 0;
    protected boolean startTimerAutomatically = true;
    protected boolean fireWhenOptionDrawerOpen = true;
    protected boolean fireWhenSelectionDrawerOpen = true;
    protected boolean deactivateOnKeyReleased = false;
    protected boolean active = true;
    protected final LogChannel lc;
    protected String logPrefix;

    public AbstractIdleTimerController(LogChannel logChannel) {
        this.lc = logChannel;
        this.logPrefix = this.getClassName();
    }

    public AbstractIdleTimerController(LogChannel logChannel, String string) {
        this.lc = logChannel;
        this.logPrefix = string;
    }

    protected void initializeWidget() {
        super.initializeWidget();
        if (this.shouldStartTimerAutomatically()) {
            this.restartTimer();
        }
    }

    public void predisconnecting() {
        super.predisconnecting();
        this.cancelTimer();
    }

    public void disconnecting() {
        super.disconnecting();
        this.cancelTimer();
        this.timerJob = null;
        this.timerEvent = null;
    }

    public void keyPressed(KeyEvent keyEvent) {
        if (this.shouldStopTimerAutomatically()) {
            this.lc.log(10000000, "%1#keyPressed - stop timer. KeyEvent: %2", (Object)this.logPrefix, (Object)keyEvent);
            this.cancelTimer();
        }
        super.keyPressed(keyEvent);
        if (keyEvent.getKeyCode() == 19 && this.shouldStartTimerAutomatically()) {
            this.lc.log(10000000, "%1#keyPressed - start timer. KeyEvent: %2", (Object)this.logPrefix, (Object)keyEvent);
            this.restartTimer();
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        super.keyReleased(keyEvent);
        if (this.deactivateOnKeyReleased && this.active) {
            this.cancelTimer();
            this.active = false;
        }
        if (this.shouldStartTimerAutomatically()) {
            this.lc.log(10000000, "%1#keyReleased - start timer. KeyEvent: %2", (Object)this.logPrefix, (Object)keyEvent);
            this.restartTimer();
        }
    }

    public void keyMoved(JoystickEvent joystickEvent) {
        super.keyMoved(joystickEvent);
        if (this.deactivateOnKeyReleased && this.active) {
            this.cancelTimer();
            this.active = false;
        }
        if (this.shouldStartTimerAutomatically()) {
            this.lc.log(10000000, "%1#keyMoved - start timer. KeyEvent: %2", (Object)this.logPrefix, (Object)joystickEvent);
            this.restartTimer();
        }
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        super.keyTurned(wheelButtonEvent);
        if (this.shouldStartTimerAutomatically()) {
            this.lc.log(10000000, "%1#keyTurned - start timer. KeyEvent: %2", (Object)this.logPrefix, (Object)wheelButtonEvent);
            this.restartTimer();
        }
    }

    public void touchPadPressed(TouchEvent touchEvent) {
        if (this.shouldStopTimerAutomatically()) {
            this.lc.log(10000000, "%1#touchPadPressed - stop timer. TouchEvent: %2", (Object)this.logPrefix, (Object)touchEvent);
            this.cancelTimer();
        }
        super.touchPadPressed(touchEvent);
    }

    public void touchPadReleased(TouchEvent touchEvent) {
        super.touchPadReleased(touchEvent);
        if (this.shouldStartTimerAutomatically()) {
            this.lc.log(10000000, "%1#touchPadReleased - start timer. TouchEvent: %2", (Object)this.logPrefix, (Object)touchEvent);
            this.restartTimer();
        }
    }

    protected boolean shouldStartTimerAutomatically() {
        return this.startTimerAutomatically && this.isEnabled();
    }

    public void setStartTimerAutomatically(boolean bl) {
        this.startTimerAutomatically = bl;
    }

    protected boolean shouldStopTimerAutomatically() {
        return this.startTimerAutomatically && this.isTimerRunning();
    }

    protected boolean isOptionDrawerOpen() {
        return this.terminal.getDrawerFocusManager().getDrawerState() == 8;
    }

    protected boolean isSelectionDrawerOpen() {
        return this.terminal.getDrawerFocusManager().getDrawerState() == 4;
    }

    protected boolean shouldExecuteAction() {
        if (!this.isConnected()) {
            this.lc.log(100000, "%1#shouldExecuteAction: timer is not connected.", (Object)this.logPrefix);
            return false;
        }
        if (!this.isEnabled()) {
            this.lc.log(10000000, "%1#shouldExecuteAction: timer is disabled.", (Object)this.logPrefix);
            return false;
        }
        if (!this.active) {
            this.lc.log(10000000, "%1#shouldExecuteAction: timer is not active.", (Object)this.logPrefix);
            return false;
        }
        if (!this.fireWhenOptionDrawerOpen && this.isOptionDrawerOpen() && !this.isInOptionDrawer()) {
            this.lc.log(10000000, "%1#shouldExecuteAction: option drawer is open.", (Object)this.logPrefix);
            this.restartTimer();
            return false;
        }
        if (!this.fireWhenSelectionDrawerOpen && this.isSelectionDrawerOpen()) {
            this.lc.log(10000000, "%1#shouldExecuteAction: selection drawer is open.", (Object)this.logPrefix);
            this.restartTimer();
            return false;
        }
        return true;
    }

    public void processEvent(ATIPEvent aTIPEvent) {
        if (aTIPEvent.equals(this.timerEvent)) {
            this.timerJob = null;
            if (this.shouldExecuteAction()) {
                this.lc.log(10000000, "%1#processEvent is called, execute action. timer: %2", (Object)this.logPrefix, (Object)aTIPEvent);
                this.timerFired();
            } else {
                this.lc.log(10000000, "%1#processEvent is called, but don't execute action. timer: %2", (Object)this.logPrefix, (Object)aTIPEvent);
            }
        } else {
            this.lc.log(10000000, "%1#processEvent is called with unexpected timer: %2, expected timer: %3", (Object)this.logPrefix, (Object)aTIPEvent, (Object)this.timerEvent);
        }
    }

    protected abstract void timerFired();

    public void restartTimer() {
        if (!this.isEnabled()) {
            this.lc.log(10000000, "%1#restartTimer: don't restart, because timer is disabled", (Object)this.logPrefix);
            return;
        }
        if (!this.active) {
            this.lc.log(10000000, "%1#restartTimer: timer is not active", (Object)this.logPrefix);
            return;
        }
        this.cancelTimer();
        if (this.idleTime > 0) {
            if (!this.isConnected()) {
                this.lc.log(10000, "%1#restartTimer: timer is not connected.", (Object)this.logPrefix);
                return;
            }
            if (this.timerEvent == null) {
                this.timerEvent = new TimerEvent(this);
            }
            this.lc.log(10000000, "%1#restartTimer with timeout: %2", (Object)this.logPrefix, (long)this.idleTime);
            this.timerJob = hmiService.getEventDispatcher().postEvent(this.timerEvent, this.idleTime);
        } else {
            this.lc.log(10000000, "%1#restartTimer - idleTime: %2 < 0, no timer is started", (Object)this.logPrefix, (long)this.idleTime);
        }
    }

    public void cancelTimer() {
        if (this.isTimerRunning()) {
            this.lc.log(10000000, "%1#cancelTimer", (Object)this.logPrefix);
            this.timerJob.cancel();
            this.timerJob = null;
        }
    }

    public boolean isTimerRunning() {
        return this.timerJob != null && !this.timerJob.isCanceled();
    }

    public void setEnabled(boolean bl) {
        boolean bl2 = this.isEnabled();
        super.setEnabled(bl);
        if (!bl2 && bl && this.isConnected()) {
            this.lc.log(10000000, "%2#setEnabled: Widget is enabled, start timer. already running: %1", this.isTimerRunning(), (Object)this.logPrefix);
            this.restartTimer();
        } else if (bl2 && !bl && this.isTimerRunning()) {
            this.lc.log(10000000, "%1#setEnabled: Widget is disabled, stop timer: %2", (Object)this.logPrefix, (Object)this.timerJob);
            this.cancelTimer();
        }
    }

    public IRenderer getRenderer() {
        return null;
    }

    public int getIdleTime() {
        return this.idleTime;
    }

    public void setIdleTime(int n) {
        int n2 = this.idleTime;
        this.idleTime = n;
        if (n2 != n && this.isEnabled() && this.isConnected()) {
            this.lc.log(10000000, "%1#setIdleTime: idleTime changed, start timer. old idleTime: %2, new idleTime: %3", (Object)this.logPrefix, (long)n2, (long)n);
            this.restartTimer();
        }
    }

    public boolean isFireWhenOptionDrawerOpen() {
        return this.fireWhenOptionDrawerOpen;
    }

    public void setFireWhenOptionDrawerOpen(boolean bl) {
        this.fireWhenOptionDrawerOpen = bl;
    }

    public boolean isFireWhenSelectionDrawerOpen() {
        return this.fireWhenSelectionDrawerOpen;
    }

    public void setFireWhenSelectionDrawerOpen(boolean bl) {
        this.fireWhenSelectionDrawerOpen = bl;
    }

    public void setDeactivateOnKeyReleased(boolean bl) {
        this.deactivateOnKeyReleased = bl;
    }

    public void setActive(boolean bl) {
        this.active = bl;
    }
}

