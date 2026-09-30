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
import java.util.NoSuchElementException;

public class DataUpdateMediator
extends AbstractEventMediator
implements TimerListener {
    private static final int PROCESSING_DATA = 0;
    private static final int DATA_UNAVAILABLE = 1;
    private static final int DATA_AVAILABLE = 2;
    private static final int DATA_CORRUPTED = 3;
    protected int dataStatus;
    private Timer waitTimer;
    private final long waitTime;
    protected final int availableAction;
    protected final int processingAction;
    protected final int unavailableAction;
    protected final int errorAction;
    private int mediatorState = 0;

    public DataUpdateMediator(MediatorManager mediatorManager, int n, int n2, int n3, int n4, int n5, long l) {
        this(-1L, mediatorManager, n, n2, n3, n4, n5, l);
    }

    public DataUpdateMediator(MediatorManager mediatorManager, int n, int n2, int n3, int n4, int n5) {
        this(-1L, mediatorManager, n, n2, n3, n4, n5);
    }

    public DataUpdateMediator(MediatorManager mediatorManager, int n, int n2, int n3, int n4) {
        this(-1L, mediatorManager, n, n2, n3, n4);
    }

    public DataUpdateMediator(MediatorManager mediatorManager, int n, int n2, int n3) {
        this(-1L, mediatorManager, n, n2, n3);
    }

    public DataUpdateMediator(long l, MediatorManager mediatorManager, int n, int n2, int n3, int n4, int n5, long l2) {
        super(l, mediatorManager, -1, n5);
        this.availableAction = n;
        this.processingAction = n2;
        this.unavailableAction = n3;
        this.errorAction = n4;
        this.waitTime = l2;
    }

    public DataUpdateMediator(long l, MediatorManager mediatorManager, int n, int n2, int n3, int n4, int n5) {
        this(l, mediatorManager, n, n2, n3, n4, n5, 3000L);
    }

    public DataUpdateMediator(long l, MediatorManager mediatorManager, int n, int n2, int n3, int n4) {
        this(l, mediatorManager, n, n2, n3, -1, n4);
    }

    public DataUpdateMediator(long l, MediatorManager mediatorManager, int n, int n2, int n3) {
        this(l, mediatorManager, n, n2, -1, -1, n3);
    }

    public void start() {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[DataUpdateMediator#start] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        long l = this.getDelay();
        if (this.waitTimer == null) {
            this.waitTimer = new Timer("DataUpdateMediatorTimer", l, true, new TimerSyncer(this));
        } else if (l != this.waitTimer.getDelay()) {
            this.waitTimer.setDelay(l);
        }
        this.updateStatus();
        if (this.isStatusProcessing()) {
            this.mediatorState = 0;
            this.triggerAction(this.processingAction);
            this.waitTimer.restart();
        } else if (this.isStatusError()) {
            this.mediatorState = 3;
            this.triggerAction(this.errorAction);
        } else if (this.isDataAvailable()) {
            this.mediatorState = 2;
            this.triggerAction(this.availableAction);
        } else {
            this.mediatorState = 1;
            this.triggerAction(this.unavailableAction);
        }
        this.startListening();
        this.started = true;
    }

    public void stop() {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[DataUpdateMediator#stop] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        this.waitTimer.cancel();
        this.stopListening();
        this.started = false;
    }

    public int activate(boolean bl) {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[DataUpdateMediator#activate] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        this.active = false;
        this.start();
        super.activate(false);
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[DataUpdateMediator#activate] (MEDID#%1), postponedAction=(EVENTID#%2)", (Object)Long.toString(this.getID()), (long)this.getPostponedActionWithoutReset());
        }
        return this.getPostponedAction();
    }

    public int reactivate(boolean bl) {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[DataUpdateMediator#reactivate] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        if (!this.started || bl) {
            this.start();
            this.waitTimer.cancel();
        }
        return super.reactivate(false);
    }

    public void deactivate() {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[DataUpdateMediator#deactivate] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        super.deactivate();
        if (this.waitTimer.isRunning()) {
            this.waitTimer.cancel();
            this.fireTimer(this.waitTimer);
        } else {
            this.waitTimer.cancel();
        }
    }

    public void processUpdate(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getModelId();
        int n2 = modelUpdateEvent.getUpdateType();
        this.manager.getEventLogChannel().log(1000000, "[DataUpdateMediator#processUpdate] (MEDID#%3) mediator received model-update event (MODELID#%1), Type %2) ", (Object)Integer.toString(n), (Object)Integer.toString(n2), (Object)Long.toString(this.getID()));
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[DataUpdateMediator#processUpdate] (MEDID#%1) modelUpdate for (MODELID#%2) received", (Object)Long.toString(this.getID()), (Object)Integer.toString(n));
        }
        if (this.triggerModelIDList[0] == n) {
            if (n2 == 2 || n2 == 6 || n2 == 12 || n2 == 16) {
                int n3 = this.updateStatus();
                if (this.isStatusProcessing()) {
                    if (this.mediatorState != 0) {
                        this.mediatorState = 0;
                        this.triggerAction(this.processingAction);
                        if (this.active) {
                            long l = this.getDelay();
                            if (l != this.waitTimer.getDelay()) {
                                this.waitTimer.setDelay(l);
                            }
                            this.waitTimer.restart();
                        }
                    }
                    this.manager.getEventLogChannel().log(1000000, "[DataUpdateMediator#processUpdate] (MEDID#%2) mediator processed model-update event (MODELID#%1) ", (Object)Integer.toString(n), (Object)Long.toString(this.getID()));
                    return;
                }
                if (this.isStatusError()) {
                    if (!(this.mediatorState == 3 && n3 == this.dataStatus || this.waitTimer.isRunning())) {
                        this.mediatorState = 3;
                        this.triggerAction(this.errorAction);
                    }
                    this.manager.getEventLogChannel().log(1000000, "[DataUpdateMediator#processUpdate] (MEDID#%2) mediator processed model-update event (MODELID#%1) ", (Object)Integer.toString(n), (Object)Long.toString(this.getID()));
                    return;
                }
            }
            if (this.isStatusOK() && !this.waitTimer.isRunning()) {
                if (this.isDataAvailable()) {
                    if (this.mediatorState != 2) {
                        this.mediatorState = 2;
                        this.triggerAction(this.availableAction);
                    }
                } else if (this.mediatorState != 1) {
                    this.mediatorState = 1;
                    this.triggerAction(this.unavailableAction);
                }
            }
            this.manager.getEventLogChannel().log(1000000, "[DataUpdateMediator#processUpdate] (MEDID#%2) mediator processed model-update event (MODELID#%1) ", (Object)Integer.toString(n), (Object)Long.toString(this.getID()));
        }
    }

    public void fireTimer(Timer timer) {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[DataUpdateMediator#fireTimer] (MEDID#%1), medState='%2', dataState='%3'", (Object)Long.toString(this.getID()), (Object)Integer.toString(this.mediatorState), (Object)Integer.toString(this.dataStatus));
        }
        if (!this.isStatusProcessing()) {
            if (this.isStatusError()) {
                this.mediatorState = 3;
                this.triggerAction(this.errorAction);
            } else if (this.isDataAvailable()) {
                this.mediatorState = 2;
                this.triggerAction(this.availableAction);
            } else {
                this.mediatorState = 1;
                this.triggerAction(this.unavailableAction);
            }
        }
    }

    public void cancelTimer(Timer timer) {
    }

    protected int updateStatus() {
        int n = this.dataStatus;
        try {
            this.dataStatus = this.manager.getModel(this.triggerModelIDList[0]).getStatus();
        }
        catch (NoSuchElementException noSuchElementException) {
            this.manager.getEventLogChannel().log(10000, "[DataUpdateMediator#updateStatus] (MEDID#%2) mediator unable to retrieve model %1 ", (Object)Integer.toString(this.triggerModelIDList[0]), (Object)Long.toString(this.getID()), (Object)noSuchElementException);
            this.dataStatus = 0;
        }
        return n;
    }

    protected boolean isStatusProcessing() {
        return this.dataStatus == 0;
    }

    protected boolean isStatusOK() {
        return this.dataStatus == 1 || this.errorAction == -1 && this.dataStatus >= 2;
    }

    protected boolean isStatusError() {
        return this.errorAction != -1 && this.dataStatus >= 2;
    }

    protected boolean isDataAvailable() {
        if (this.unavailableAction == -1) {
            return true;
        }
        try {
            return !this.manager.getModel(this.triggerModelIDList[0]).isEmpty();
        }
        catch (NoSuchElementException noSuchElementException) {
            this.manager.getLogChannel().log(10000, "[DataUpdateMediator#isDataAvailable] (MEDID#%2) mediator unable to retrieve model (MODELID#%1)", (Object)Integer.toString(this.triggerModelIDList[0]), (Object)Long.toString(this.getID()), (Object)noSuchElementException);
            return false;
        }
    }

    private long getDelay() {
        return this.waitTime;
    }

    public int getType() {
        return 2;
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

