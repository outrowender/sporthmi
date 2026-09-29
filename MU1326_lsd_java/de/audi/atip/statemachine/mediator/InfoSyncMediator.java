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

public class InfoSyncMediator
extends AbstractEventMediator
implements TimerListener {
    protected boolean waiting;
    private Timer waitTimer;
    private final int showInfoAction;
    private final int hideInfoAction;
    private final long waitTime;

    public InfoSyncMediator(MediatorManager mediatorManager, int n, int n2, int n3) {
        this(-1L, mediatorManager, n, n2, n3);
    }

    public InfoSyncMediator(MediatorManager mediatorManager, int n, int n2, int n3, long l) {
        this(-1L, mediatorManager, n, n2, n3, l);
    }

    public InfoSyncMediator(long l, MediatorManager mediatorManager, int n, int n2, int n3) {
        this(l, mediatorManager, n, n2, n3, 0);
    }

    public InfoSyncMediator(long l, MediatorManager mediatorManager, int n, int n2, int n3, long l2) {
        super(l, mediatorManager, -1, n3);
        this.showInfoAction = n;
        this.hideInfoAction = n2;
        this.waitTime = l2;
    }

    @Override
    public void start() {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(14808325, "[InfoSyncMediator#start] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        long l = this.getDelay();
        if (this.waitTimer == null) {
            this.waitTimer = new Timer("InfoSyncMediatorTimer", l, true, new TimerSyncer(this));
        } else if (l != this.waitTimer.getDelay()) {
            this.waitTimer.setDelay(l);
        }
        this.resetPostponedAction();
        this.waitTimer.restart();
        this.waiting = this.isWaiting();
        this.started = true;
        if (this.waiting) {
            this.startListening();
        } else {
            this.triggerAction(this.hideInfoAction);
            this.stop();
        }
    }

    @Override
    public void stop() {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(14808325, "[InfoSyncMediator#stop] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        this.waitTimer.cancel();
        this.stopListening();
        this.waiting = false;
        this.started = false;
    }

    @Override
    public int activate(boolean bl) {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(14808325, "[InfoSyncMediator#activate] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        this.resetPostponedAction();
        if (this.isStarted()) {
            if (this.isWaiting()) {
                this.triggerAction(this.showInfoAction);
            } else {
                this.stop();
            }
        }
        int n = this.getPostponedAction();
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(14808325, "[InfoSyncMediator#activate] (MEDID#%1) postponedAction=(EVENTID#%2)", (Object)Long.toString(this.getID()), (long)n);
        }
        this.active = true;
        return n;
    }

    @Override
    public int reactivate(boolean bl) {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(14808325, "[InfoSyncMediator#reactivate] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        if (this.isStarted()) {
            if (this.isWaiting()) {
                this.triggerAction(this.showInfoAction);
            } else {
                this.stop();
                this.triggerAction(this.hideInfoAction);
            }
        }
        int n = this.getPostponedAction();
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(14808325, "[InfoSyncMediator#reactivate] (MEDID#%1) postponedAction=(EVENTID#%2)", (Object)Long.toString(this.getID()), (long)n);
        }
        this.active = true;
        return n;
    }

    @Override
    public void processUpdate(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getModelId();
        int n2 = modelUpdateEvent.getUpdateType();
        this.manager.getEventLogChannel().log(1078071040, "[InfoSyncMediator#processUpdate] (MEDID#%2) mediator received model-update event (MODELID#%1) ", (Object)Integer.toString(n), (Object)Long.toString(this.getID()));
        if (!this.listening) {
            this.manager.getEventLogChannel().log(1078071040, "[InfoSyncMediator#processUpdate] (MEDID#%2) mediator not listening to events ", (Object)Integer.toString(n), (Object)Long.toString(this.getID()));
            return;
        }
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(14808325, "[InfoSyncMediator#processUpdate] (MEDID#%1) modelUpdate for (MODELID#%2) received", (Object)Long.toString(this.getID()), (Object)Integer.toString(n));
        }
        if (this.triggerModelIDList[0] == n && (n2 == 2 || n2 == 6 || n2 == 12 || n2 == 16)) {
            this.waiting = this.isWaiting();
            if (!(this.waiting || this.waitTimer.isRunning() && this.active)) {
                this.triggerAction(this.hideInfoAction);
                this.manager.getEventLogChannel().log(1078071040, "[InfoSyncMediator#processUpdate] (MEDID#%2) mediator processed model-update event (MODELID#%1) ", (Object)Integer.toString(n), (Object)Long.toString(this.getID()));
                this.stop();
            }
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    @Override
    public void fireTimer(Timer timer) {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(14808325, "[InfoSyncMediator#fireTimer] (MEDID#%1), waiting='%2'", (Object)Long.toString(this.getID()), (Object)Boolean.toString(this.waiting));
        }
        if (!this.waiting) {
            this.triggerAction(this.hideInfoAction);
            this.stop();
        }
    }

    protected boolean isWaiting() {
        return this.manager.getModel(this.triggerModelIDList[0]).getStatus() == 0;
    }

    private long getDelay() {
        return this.waitTime;
    }

    @Override
    public int getType() {
        return 5;
    }

    @Override
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

