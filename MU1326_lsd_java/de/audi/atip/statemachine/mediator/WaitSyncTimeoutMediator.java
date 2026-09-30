/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.mediator;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.TimerSyncer;
import de.audi.atip.statemachine.MediatorManager;
import de.audi.atip.statemachine.mediator.AbstractEventMediator;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public class WaitSyncTimeoutMediator
extends AbstractEventMediator
implements TimerListener {
    private final int syncAction;
    private final int timeoutAction;
    private final long waitTime;
    private Timer waitTimer;

    public WaitSyncTimeoutMediator(long l, MediatorManager mediatorManager, int n, int n2, int n3, long l2) {
        super(l, mediatorManager, -1, n3);
        this.syncAction = n;
        this.timeoutAction = n2;
        this.waitTime = l2;
    }

    public int activate(boolean bl) {
        this.stop();
        this.resetPostponedAction();
        return super.activate(bl);
    }

    public int reactivate(boolean bl) {
        return super.reactivate(bl);
    }

    public void deactivate() {
        super.deactivate();
        this.stop();
        if (this.listening && this.isWaiting()) {
            this.triggerAction(this.timeoutAction);
        }
    }

    public void start() {
        this.resetPostponedAction();
        if (this.waitTimer == null) {
            this.waitTimer = new Timer("WaitSyncTimeoutMediator", this.waitTime, true, new TimerSyncer(this));
        } else if (this.waitTime != this.waitTimer.getDelay()) {
            this.waitTimer.setDelay(this.waitTime);
        }
        if (this.errorOccured()) {
            this.manager.getLogChannel().log(1000000, "[WaitSyncTimeoutMediator#start] Starting mediator (MEDID#%1), status is ERROR! Mediator stopped again!", (Object)Long.toString(this.getID()));
            this.stop();
        } else if (this.isWaiting()) {
            this.manager.getLogChannel().log(1000000, "[WaitSyncTimeoutMediator#start] Starting mediator (MEDID#%1), status is waiting. Wait for status OK.", (Object)Long.toString(this.getID()));
            this.startListening();
            this.started = true;
            if (this.active) {
                this.manager.lockScreen();
            }
            this.waitTimer.start();
        } else {
            this.manager.getLogChannel().log(1000000, "[WaitSyncTimeoutMediator#start] Starting mediator (MEDID#%1), status is already OK, not waiting! Trigger Action immediately.", (Object)Long.toString(this.getID()));
            this.triggerAction(this.syncAction);
            this.stop();
        }
    }

    public void stop() {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[WaitSyncTimeoutMediator#stop] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        if (this.waitTimer != null) {
            this.waitTimer.cancel();
        }
        this.stopListening();
        this.started = false;
    }

    public boolean locksScreen() {
        return this.started && this.listening && this.isWaiting() && !this.errorOccured();
    }

    public void processUpdate(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getModelId();
        int n2 = modelUpdateEvent.getUpdateType();
        this.manager.getEventLogChannel().log(1000000, "[WaitSyncTimeoutMediator#processUpdate] mediator (MEDID#%2) received model-update event (MOID#%1).", (Object)Integer.toString(n), (Object)Long.toString(this.getID()));
        if (!this.listening) {
            this.manager.getEventLogChannel().log(1000000, "[WaitSyncTimeoutMediator#processUpdate] mediator (MEDID#%1) not listening to events.", (Object)Long.toString(this.getID()));
            return;
        }
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[WaitSyncTimeoutMediator#processUpdate] (MEDID#%1) modelUpdate for (MODELID#%2) received, model status='%3'", (Object)Long.toString(this.getID()), (Object)Integer.toString(n), (Object)Integer.toString(this.manager.getModel(n).getStatus()));
        }
        if (n2 == 2 || n2 == 12 || n2 == 6 || n2 == 16) {
            for (int i2 = 0; i2 < this.triggerModelIDList.length; ++i2) {
                if (this.triggerModelIDList[i2] != n) continue;
                if (this.errorOccured()) {
                    this.manager.getLogChannel().log(1000000, "[WaitSyncTimeoutMediator#processUpdate] Error Occured. Stopping mediator (MEDID#%1). No action triggered. Unlocking screen.", (Object)Long.toString(this.getID()));
                    this.stop();
                    this.manager.unlockScreen();
                    break;
                }
                if (this.isWaiting()) break;
                this.triggerAction(this.syncAction);
                this.manager.getEventLogChannel().log(1000000, "[WaitSyncTimeoutMediator#processUpdate] Mediator (MEDID#%2) processed model-update event (MOID#%1).", (Object)Integer.toString(n), (Object)Long.toString(this.getID()));
                this.stop();
                break;
            }
        }
    }

    protected boolean isWaiting() {
        boolean bl = false;
        for (int i2 = 0; i2 < this.triggerModelIDList.length; ++i2) {
            if (this.manager.getModel(this.triggerModelIDList[i2]).getStatus() != 0) continue;
            this.manager.getLogChannel().log(1000000, "[WaitSyncTimeoutMediator#isWaiting] Model (MOID# %1) has status WAITING.", (long)this.triggerModelIDList[i2]);
            bl = true;
            break;
        }
        return bl;
    }

    protected boolean errorOccured() {
        boolean bl = false;
        for (int i2 = 0; i2 < this.triggerModelIDList.length; ++i2) {
            if (this.manager.getModel(this.triggerModelIDList[i2]).getStatus() != 2) continue;
            this.manager.getLogChannel().log(1000000, "[WaitSyncTimeoutMediator] Model (MOID#%1) at Mediator (MEDID#%2) has status ERROR.", (Object)Integer.toString(this.triggerModelIDList[i2]), (Object)Long.toString(this.getID()));
            bl = true;
            break;
        }
        return bl;
    }

    public void kill() {
        if (!this.started) {
            return;
        }
        this.stopListening();
        this.started = false;
    }

    public int getType() {
        return 12;
    }

    public void fireTimer(Timer timer) {
        if (this.isWaiting()) {
            this.triggerAction(this.timeoutAction);
            this.manager.getEventLogChannel().log(1000000, "[WaitSyncTimeoutMediator#fireTimer] Mediator (MEDID#%1) processed timer event.", (Object)Long.toString(this.getID()));
            this.stop();
        }
    }

    public void cancelTimer(Timer timer) {
    }
}

