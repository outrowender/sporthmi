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

public class WaitScreenMediator
extends AbstractEventMediator
implements TimerListener {
    protected volatile boolean waiting;
    private Timer waitTimer;
    private long waitTime;

    public WaitScreenMediator(MediatorManager mediatorManager, int n, int n2) {
        this(-1L, mediatorManager, n, n2);
    }

    public WaitScreenMediator(MediatorManager mediatorManager, int n, int n2, long l) {
        this(-1L, mediatorManager, n, n2, l);
    }

    public WaitScreenMediator(long l, MediatorManager mediatorManager, int n, int n2) {
        this(l, mediatorManager, n, n2, 3000L);
    }

    public WaitScreenMediator(long l, MediatorManager mediatorManager, int n, int n2, long l2) {
        super(l, mediatorManager, n, n2);
        this.waitTime = l2;
    }

    public void start() {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[WaitScreenMediator#start] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        long l = this.getDelay();
        if (this.waitTimer == null) {
            this.waitTimer = new Timer("WaitScreenMediatorTimer", l, true, new TimerSyncer(this));
        } else if (l != this.waitTimer.getDelay()) {
            this.waitTimer.setDelay(l);
        }
        this.resetPostponedAction();
        this.waitTimer.restart();
        this.waiting = this.isWaiting();
        if (this.waiting) {
            this.startListening();
        } else {
            this.triggerAction(this.action);
        }
        this.started = true;
    }

    public void stop() {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[WaitScreenMediator#stop] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        this.waitTimer.cancel();
        this.stopListening();
        this.waiting = false;
        this.started = false;
    }

    public int activate(boolean bl) {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[WaitScreenMediator#activate] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        this.start();
        return super.activate(bl);
    }

    public int reactivate(boolean bl) {
        int n;
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[WaitScreenMediator#reactivate] (MEDID#%1), postponedAction=(EVENTID#%2)", (Object)Long.toString(this.getID()), (long)this.getPostponedActionWithoutReset());
        }
        if ((n = this.getPostponedAction()) == -1 && !this.isStarted()) {
            this.start();
            n = this.getPostponedAction();
        }
        this.active = true;
        return n;
    }

    public void processUpdate(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getModelId();
        int n2 = modelUpdateEvent.getUpdateType();
        this.manager.getEventLogChannel().log(1000000, "[WaitScreenMediator#processUpdate] mediator (MEDID#%2) received model-update event (MODELID#%1)", (Object)Integer.toString(n), (Object)Long.toString(this.getID()));
        if (!this.listening) {
            this.manager.getEventLogChannel().log(1000000, "[WaitScreenMediator#processUpdate] mediator (MEDID#%2) not listening to events", (Object)Integer.toString(n), (Object)Long.toString(this.getID()));
            return;
        }
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[WaitScreenMediator#processUpdate] (MEDID#%1) modelUpdate for (MODELID#%2) received, model status='%3'", (Object)Long.toString(this.getID()), (Object)Integer.toString(n), (Object)Integer.toString(this.manager.getModel(n).getStatus()));
        }
        if (this.triggerModelIDList[0] == n && (n2 == 2 || n2 == 6 || n2 == 12 || n2 == 16)) {
            this.waiting = this.isWaiting();
            if (!(this.waiting || this.waitTimer.isRunning() && this.active)) {
                this.triggerAction(this.action);
                this.manager.getEventLogChannel().log(1000000, "[WaitScreenMediator#processUpdate] mediator (MEDID#%2) processed model-update event (MODELID#%1)", (Object)Integer.toString(n), (Object)Long.toString(this.getID()));
                this.stop();
            }
        }
    }

    public void cancelTimer(Timer timer) {
    }

    public void fireTimer(Timer timer) {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[WaitScreenMediator#fireTimer] (MEDIT#%2) called, waiting='%1'", (Object)Boolean.toString(this.isWaiting()), (Object)Long.toString(this.getID()));
        }
        this.waiting = this.isWaiting();
        if (!this.waiting) {
            this.triggerAction(this.action);
            this.stop();
        }
    }

    protected boolean isWaiting() {
        return this.manager.getModel(this.triggerModelIDList[0]).getStatus() == 0;
    }

    private long getDelay() {
        return this.waitTime;
    }

    public int getType() {
        return 8;
    }

    public void kill() {
        if (this.waitTimer != null) {
            this.waitTimer.cancel();
        }
        if (!this.started) {
            return;
        }
        this.stopListening();
        this.started = false;
    }
}

