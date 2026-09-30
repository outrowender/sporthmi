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

public class WaitTimerMediator
extends AbstractEventMediator
implements TimerListener {
    private Timer waitTimer;
    private final long waitTime;

    public WaitTimerMediator(MediatorManager mediatorManager, int n) {
        this(-1L, mediatorManager, n);
    }

    public WaitTimerMediator(MediatorManager mediatorManager, int n, long l) {
        this(-1L, mediatorManager, n, l);
    }

    public WaitTimerMediator(long l, MediatorManager mediatorManager, int n) {
        this(l, mediatorManager, n, 3000L);
    }

    public WaitTimerMediator(long l, MediatorManager mediatorManager, int n, long l2) {
        super(l, mediatorManager, n);
        this.waitTime = l2;
    }

    public void start() {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[WaitTimerMediator#start] (MEDID#%1), delay=%2", (Object)Long.toString(this.getID()), (Object)Long.toString(this.getDelay()));
        }
        long l = this.getDelay();
        if (this.waitTimer == null) {
            this.waitTimer = new Timer("WaitTimerMediatorTimer", l, true, new TimerSyncer(this));
        } else if (l != this.waitTimer.getDelay()) {
            this.waitTimer.setDelay(l);
        }
        this.waitTimer.restart();
        this.resetPostponedAction();
        this.started = true;
    }

    public void stop() {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[WaitTimerMediator#stop] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        this.waitTimer.cancel();
        this.started = false;
    }

    public int activate(boolean bl) {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[WaitTimerMediator#activate] (MEDID#%1), enforce='%2'", (Object)Long.toString(this.getID()), (Object)Boolean.toString(bl));
        }
        this.start();
        return super.activate(bl);
    }

    public int reactivate(boolean bl) {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[WaitTimerMediator#reactivate] (MEDID#%1), enforce='%2'", (Object)Long.toString(this.getID()), (Object)Boolean.toString(bl));
        }
        if (!this.started) {
            this.start();
            return super.reactivate(bl);
        }
        if (!this.hasPostponedAction()) {
            this.waitTimer.restart();
        }
        return super.reactivate(bl);
    }

    public void processUpdate(ModelUpdateEvent modelUpdateEvent) {
    }

    public void fireTimer(Timer timer) {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[WaitTimerMediator#fireTimer] (MEDID#%1)", (Object)Long.toString(this.getID()));
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
        return 10;
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

