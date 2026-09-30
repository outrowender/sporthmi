/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.mediator;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.statemachine.MediatorManager;
import de.audi.atip.statemachine.mediator.AbstractEventMediator;
import java.util.NoSuchElementException;

public class JumpBackMediator
extends AbstractEventMediator {
    private int[] changeCounter;
    private int defaultTargetStateID;
    private int transitionID;

    public JumpBackMediator(MediatorManager mediatorManager, int n, int[] nArray, int n2, int n3) {
        this(-1L, mediatorManager, n, nArray, n2, n3);
    }

    public JumpBackMediator(long l, MediatorManager mediatorManager, int n, int[] nArray, int n2, int n3) {
        super(l, mediatorManager, n, nArray);
        this.changeCounter = new int[nArray.length];
        this.defaultTargetStateID = n2;
        this.transitionID = n3;
    }

    public void start() {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[JumpBackMediator#start] (MEDID#%1)", (Object)Long.toString(this.getID()));
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
                this.manager.getLogChannel().log(10000, "[JumpBackMediator#start] unable to retrieve model m%1 when starting ChangeMediator (MEDID#%1)", (Object)Integer.toString(n), (Object)Long.toString(this.getID()), (Object)noSuchElementException);
                this.stopListening();
                this.createErrorLog("unable to retrieve model m" + n + " when starting ChangeMediator", noSuchElementException);
                return;
            }
        }
        this.started = true;
    }

    public void stop() {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[JumpBackMediator#stop] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        this.started = false;
    }

    public void deactivate() {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[JumpBackMediator#deactivate] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        super.deactivate();
        this.manager.resetJumpBackPoint(this.transitionID, this.defaultTargetStateID);
    }

    public int activate(boolean bl) {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[JumpBackMediator#activate] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        this.resetPostponedAction();
        if (!this.started) {
            this.start();
        }
        super.activate(bl);
        return this.getPostponedAction();
    }

    public int reactivate(boolean bl) {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[JumpBackMediator#reactivate] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        if (!this.started) {
            this.start();
        }
        return super.reactivate(bl);
    }

    public void processUpdate(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getModelId();
        int n2 = modelUpdateEvent.getModelType();
        int n3 = modelUpdateEvent.getUpdateType();
        this.manager.getEventLogChannel().log(1000000, "[JumpBackMediator#processUpdate] mediator (MEDID#%2) received model-update event (m%1) ", (Object)Integer.toString(n), (Object)Long.toString(this.getID()));
        if (!this.listening) {
            return;
        }
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[WaitScreenMediator#processUpdate] (MEDID#%1) modelUpdate for (MODELID#%2) received", (Object)Long.toString(this.getID()), (Object)Integer.toString(n));
        }
        block3: for (int i2 = 0; i2 < this.triggerModelIDList.length; ++i2) {
            if (this.triggerModelIDList[i2] != n) continue;
            switch (n2) {
                case 4: 
                case 10: 
                case 12: {
                    if (n3 != 1 && n3 != 7 && n3 != 8 && n3 != 9 && n3 != 10 && n3 != 12 && n3 != 6 && n3 != 16) break block3;
                    this.triggerAction(this.action);
                    this.manager.getEventLogChannel().log(1000000, "[JumpBackMediator#processUpdate] mediator (MEDID#%2) processed model-update event (m%1) ", (Object)Integer.toString(n), (Object)Long.toString(this.getID()));
                    break;
                }
                default: {
                    if (n3 != 1 || !this.valueChanged(i2, modelUpdateEvent)) break block3;
                    this.triggerAction(this.action);
                    this.manager.getEventLogChannel().log(1000000, "[JumpBackMediator#processUpdate] mediator (MEDID#%2) processed model-update event (m%1) ", (Object)Integer.toString(n), (Object)Long.toString(this.getID()));
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

    public int getEventId() {
        return this.action;
    }

    public int getType() {
        return 7;
    }

    public void kill() {
        if (!this.started) {
            return;
        }
        this.stopListening();
        this.started = false;
    }
}

