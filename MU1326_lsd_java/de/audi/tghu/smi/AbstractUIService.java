/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.hmi.model.AdditionalScreenData;
import de.audi.atip.statemachine.State;
import de.audi.tghu.smi.AbstractStateMachine;
import de.audi.tghu.smi.Logger;
import de.audi.tghu.smi.SMI;
import de.audi.tghu.smi.StateMachineData;
import de.audi.tghu.smi.StateMachineTerminal;

public abstract class AbstractUIService {
    protected AbstractStateMachine stateMachine;
    protected Logger logger;
    protected StateMachineData data;

    public void setStateMachine(AbstractStateMachine abstractStateMachine) {
        this.stateMachine = abstractStateMachine;
        this.logger = this.stateMachine.logger;
        this.data = this.stateMachine.data;
    }

    protected SMI getSMI() {
        return this.stateMachine.getSMI();
    }

    public abstract void activateUI(State[] var1, int var2, AdditionalScreenData var3);

    public abstract void reactivateUI(State[] var1, int var2, AdditionalScreenData var3);

    public abstract void noStateChange();

    protected abstract void lockScreen(boolean var1);

    protected abstract void stopUI();

    protected StateMachineTerminal getTerminal() {
        return this.stateMachine.getTerminal();
    }
}

