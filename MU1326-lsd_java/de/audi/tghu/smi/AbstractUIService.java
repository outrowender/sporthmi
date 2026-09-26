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

    public abstract void activateUI(State[] stateArray, int n, AdditionalScreenData additionalScreenData) {
    }

    public abstract void reactivateUI(State[] stateArray, int n, AdditionalScreenData additionalScreenData) {
    }

    public abstract void noStateChange() {
    }

    protected abstract void lockScreen(boolean bl) {
    }

    protected abstract void stopUI() {
    }

    protected StateMachineTerminal getTerminal() {
        return this.stateMachine.getTerminal();
    }
}

