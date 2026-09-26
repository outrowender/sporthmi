/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.mediator;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.TimerSyncer;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.statemachine.MediatorManager;
import de.audi.atip.statemachine.mediator.AbstractEventMediator;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import java.util.NoSuchElementException;

public class WaitOnChangeMediator
extends AbstractEventMediator
implements TimerListener {
    private Timer waitTimer;
    private final long waitTime;
    private int[] changeCounter;
    private volatile boolean valueUpdatedInMeantime = false;

    public WaitOnChangeMediator(MediatorManager mediatorManager, int n, int[] nArray) {
        this(-1L, mediatorManager, n, nArray);
    }

    public WaitOnChangeMediator(MediatorManager mediatorManager, int n, int[] nArray, long l) {
        this(-1L, mediatorManager, n, nArray, l);
    }

    public WaitOnChangeMediator(long l, MediatorManager mediatorManager, int n, int[] nArray) {
        this(l, mediatorManager, n, nArray, -1L);
    }

    public WaitOnChangeMediator(long l, MediatorManager mediatorManager, int n, int[] nArray, long l2) {
        super(l, mediatorManager, n, nArray);
        this.waitTime = l2;
        this.changeCounter = new int[nArray.length];
    }

    @Override
    public void start() {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(14808325, "[WaitOnChangeMediator#start] (MEDID#%1) ", (Object)Long.toString(this.getID()));
        }
        long l = this.getDelay();
        if (this.waitTimer == null) {
            this.waitTimer = new Timer("WaitOnChangeMediatorTimer", l, true, new TimerSyncer(this));
        } else if (l != this.waitTimer.getDelay()) {
            this.waitTimer.setDelay(l);
        }
        this.startListening();
        for (int i2 = 0; i2 < this.triggerModelIDList.length; ++i2) {
            int n = this.triggerModelIDList[i2];
            try {
                HMIModel hMIModel = this.manager.getModel(n);
                this.changeCounter[i2] = hMIModel.getChangeState();
                continue;
            }
            catch (NoSuchElementException noSuchElementException) {
                this.manager.getLogChannel().log(10000, "[WaitOnChangeMediator#start] unable to retrieve model (MODELID#%1) when starting WaitOnChangeMediator (MEDID#%2)", (Object)Integer.toString(n), (Object)Long.toString(this.getID()), (Object)noSuchElementException);
                this.stopListening();
                this.createErrorLog(new StringBuffer().append("unable to retrieve model m").append(n).append(" when starting WaitOnChangeMediator").toString(), noSuchElementException);
                return;
            }
        }
        this.valueUpdatedInMeantime = false;
        this.started = true;
    }

    @Override
    public void stop() {
    }

    @Override
    public int activate(boolean bl) {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(14808325, "[WaitOnChangeMediator#activate] (MEDID#%1) ", (Object)Long.toString(this.getID()));
        }
        if (!this.started) {
            this.start();
        }
        this.resetPostponedAction();
        super.activate(bl);
        return this.getPostponedAction();
    }

    @Override
    public int reactivate(boolean bl) {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(14808325, "[WaitOnChangeMediator#reactivate] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        if (!this.started) {
            this.start();
        }
        int n = super.reactivate(bl);
        return n;
    }

    @Override
    public void deactivate() {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(14808325, "[WaitOnChangeMediator#deactivate] (MEDID#%1) ", (Object)Long.toString(this.getID()));
        }
        super.deactivate();
    }

    @Override
    public void processUpdate(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getModelId();
        int n2 = modelUpdateEvent.getUpdateType();
        this.manager.getEventLogChannel().log(1078071040, "[WaitOnChangeMediator#processUpdate] (MEDID#%2) mediator received model-update event (MODELID#%1)", (Object)Integer.toString(n), (Object)Long.toString(this.getID()));
        if (!this.listening) {
            return;
        }
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(14808325, "[WaitOnChangeMediator#processUpdate] (MEDID#%1) modelUpdate for (MODELID#%2) received", (Object)Long.toString(this.getID()), (Object)Integer.toString(n));
        }
        boolean bl = false;
        for (int i2 = 0; i2 < this.triggerModelIDList.length; ++i2) {
            if (this.triggerModelIDList[i2] != n || n2 != 1 || !this.valueChanged(i2, modelUpdateEvent)) continue;
            bl = true;
        }
        if (bl) {
            if (this.active) {
                if (this.waitTimer.isRunning()) {
                    this.manager.getEventLogChannel().log(1078071040, "[WaitOnChangeMediator#processUpdate] (MEDID#%1) mediator has detected value change, since last check, but timer already running", (Object)Long.toString(this.getID()));
                } else {
                    this.triggerAction(this.action);
                    this.waitTimer.restart();
                }
            } else {
                this.triggerAction(this.action);
            }
        }
    }

    @Override
    public void fireTimer(Timer timer) {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(14808325, "[WaitOnChangeMediator#fireTimer] (MEDID#%3) called, started=%1, valueUpdatedInMeantime=%2", (Object)Boolean.toString(this.started), (Object)Boolean.toString(this.valueUpdatedInMeantime), (Object)Long.toString(this.getID()));
        }
        if (this.started && this.valueUpdatedInMeantime) {
            this.valueUpdatedInMeantime = false;
            this.triggerAction(this.action);
            this.waitTimer.restart();
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    @Override
    public int getType() {
        return 13;
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

    private boolean valueChanged(int n, ModelUpdateEvent modelUpdateEvent) {
        int n2 = modelUpdateEvent.getModelId();
        HMIModel hMIModel = this.manager.getModel(n2);
        boolean bl = this.changeCounter[n] != hMIModel.getChangeState();
        this.changeCounter[n] = hMIModel.getChangeState();
        return bl;
    }

    private long getDelay() {
        return this.waitTime;
    }
}

