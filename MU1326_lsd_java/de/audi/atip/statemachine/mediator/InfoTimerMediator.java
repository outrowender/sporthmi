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

public class InfoTimerMediator
extends AbstractEventMediator
implements TimerListener {
    private Timer waitTimer;
    private long waitTime;

    public InfoTimerMediator(MediatorManager mediatorManager, int n) {
        this(-1L, mediatorManager, n);
    }

    public InfoTimerMediator(MediatorManager mediatorManager, int n, long l) {
        this(-1L, mediatorManager, n, l);
    }

    public InfoTimerMediator(long l, MediatorManager mediatorManager, int n) {
        this(l, mediatorManager, n, 3000L);
    }

    public InfoTimerMediator(long l, MediatorManager mediatorManager, int n, long l2) {
        super(l, mediatorManager, n);
        this.waitTime = l2;
    }

    public void start() {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[InfoTimerMediator#start] (MEDID#%1), active='%2', delay='%3'", (Object)Long.toString(this.getID()), (Object)Boolean.toString(this.active), (Object)Long.toString(this.getDelay()));
        }
        if (this.active) {
            long l = this.getDelay();
            if (this.waitTimer == null) {
                this.waitTimer = new Timer("WaitTimer", l, true, new TimerSyncer(this));
            } else if (l != this.waitTimer.getDelay()) {
                this.waitTimer.setDelay(l);
            }
            this.waitTimer.restart();
            this.resetPostponedAction();
            this.started = true;
        } else {
            this.triggerAction(this.action);
            this.stop();
        }
    }

    public void stop() {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[InfoTimerMediator#stop] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        if (this.waitTimer != null) {
            this.waitTimer.cancel();
        }
        this.started = false;
    }

    public void deactivate() {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[InfoTimerMediator#deactivate] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        super.deactivate();
        if (this.started) {
            this.triggerAction(this.action);
            this.stop();
        }
    }

    public void processUpdate(ModelUpdateEvent modelUpdateEvent) {
    }

    public void fireTimer(Timer timer) {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[InfoTimerMediator#fireTimer] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        this.triggerAction(this.action);
        this.stop();
    }

    public void cancelTimer(Timer timer) {
    }

    private long getDelay() {
        return this.waitTime;
    }

    public int getType() {
        return 6;
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

