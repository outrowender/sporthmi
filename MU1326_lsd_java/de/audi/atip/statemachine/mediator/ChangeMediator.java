/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.mediator;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.statemachine.MediatorManager;
import de.audi.atip.statemachine.mediator.AbstractEventMediator;
import java.util.NoSuchElementException;

public class ChangeMediator
extends AbstractEventMediator {
    private int[] changeCounter;
    private final boolean triggersOnStart;

    public ChangeMediator(MediatorManager mediatorManager, int n, int[] nArray) {
        this(-1L, mediatorManager, n, nArray);
    }

    public ChangeMediator(MediatorManager mediatorManager, int n, boolean bl, int[] nArray) {
        this(-1L, mediatorManager, n, bl, nArray);
    }

    public ChangeMediator(long l, MediatorManager mediatorManager, int n, int[] nArray) {
        this(l, mediatorManager, n, false, nArray);
    }

    public ChangeMediator(long l, MediatorManager mediatorManager, int n, boolean bl, int[] nArray) {
        super(l, mediatorManager, n, nArray);
        this.triggersOnStart = bl;
        this.changeCounter = new int[nArray.length];
    }

    @Override
    public void start() {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(14808325, "[ChangeMediator#start] (MEDID#%1)", (Object)Long.toString(this.getID()));
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
                this.manager.getLogChannel().log(10000, "[ChangeMediator#start] (MEDID#%2) unable to retrieve model (MODELID#%1) when starting ChangeMediator", (Object)Integer.toString(n), (Object)Long.toString(this.getID()), (Object)noSuchElementException);
                this.stopListening();
                this.createErrorLog(new StringBuffer().append("unable to retrieve model m").append(n).append(" when starting ChangeMediator with ID ").append(this.getID()).toString(), noSuchElementException);
                return;
            }
        }
        if (this.triggersOnStart) {
            this.triggerAction(this.action);
        }
        this.started = true;
    }

    @Override
    public void stop() {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(14808325, "[ChangeMediator#stop] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
    }

    @Override
    public int activate(boolean bl) {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(14808325, "[ChangeMediator#activate] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        this.resetPostponedAction();
        if (!this.started) {
            this.start();
        }
        super.activate(bl);
        return this.getPostponedAction();
    }

    @Override
    public int reactivate(boolean bl) {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(14808325, "[ChangeMediator#reactivate] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        if (!this.started) {
            this.start();
        }
        return super.reactivate(bl);
    }

    @Override
    public void processUpdate(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getModelId();
        int n2 = modelUpdateEvent.getModelType();
        int n3 = modelUpdateEvent.getUpdateType();
        this.manager.getEventLogChannel().log(1078071040, "[ChangeMediator#processUpdate] (MEDID#%2) mediator received model-update event (MODELID#%1) ", (Object)Integer.toString(n), (Object)Long.toString(this.getID()));
        if (!this.listening) {
            return;
        }
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(14808325, "[ChangeMediator#processUpdate] (MEDID#%1) modelUpdate for (MODELID#%2) received", (Object)Long.toString(this.getID()), (Object)Integer.toString(n));
        }
        block3: for (int i2 = 0; i2 < this.triggerModelIDList.length; ++i2) {
            if (this.triggerModelIDList[i2] != n) continue;
            switch (n2) {
                case 4: 
                case 10: 
                case 12: 
                case 25: 
                case 26: {
                    if (n3 != 1 && n3 != 7 && n3 != 8 && n3 != 9 && n3 != 10 && n3 != 12 && n3 != 6 && n3 != 16) break block3;
                    this.triggerAction(this.action);
                    this.manager.getEventLogChannel().log(1078071040, "[ChangeMediator#processUpdate] (MEDID#%2) mediator processed model-update event (MODELID#%1) ", (Object)Integer.toString(n), (Object)Long.toString(this.getID()));
                    break;
                }
                default: {
                    if (n3 != 1 || !this.valueChanged(i2, modelUpdateEvent)) break block3;
                    this.triggerAction(this.action);
                    this.manager.getEventLogChannel().log(1078071040, "[ChangeMediator#processUpdate] (MEDID#%2) mediator processed model-update event (MODELID#%1) ", (Object)Integer.toString(n), (Object)Long.toString(this.getID()));
                    break;
                }
            }
            break;
        }
    }

    private boolean valueChanged(int n, ModelUpdateEvent modelUpdateEvent) {
        int n2 = modelUpdateEvent.getModelId();
        HMIModel hMIModel = this.manager.getModel(n2);
        boolean bl = this.changeCounter[n] != hMIModel.getChangeState();
        this.changeCounter[n] = hMIModel.getChangeState();
        return bl;
    }

    @Override
    public int getType() {
        return 1;
    }

    @Override
    public void kill() {
        if (!this.started) {
            return;
        }
        this.stopListening();
        this.started = false;
    }
}

