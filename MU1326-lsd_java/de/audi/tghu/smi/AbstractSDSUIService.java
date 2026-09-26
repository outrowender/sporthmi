/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.hmi.model.AdditionalScreenData;
import de.audi.atip.statemachine.State;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.tghu.smi.AbstractUIService;
import de.audi.tghu.smi.SDSUIHandler;

public abstract class AbstractSDSUIService
extends AbstractUIService {
    @Override
    public abstract void activateUI(State[] stateArray, int n, AdditionalScreenData additionalScreenData) {
    }

    @Override
    public abstract void reactivateUI(State[] stateArray, int n, AdditionalScreenData additionalScreenData) {
    }

    @Override
    protected abstract void lockScreen(boolean bl) {
    }

    protected boolean executeSDComponents(ITTSASRContext iTTSASRContext, State[] stateArray, int n, boolean bl) {
        int n2;
        for (int i2 = n2 = bl ? n - 2 : n - 1; i2 >= 0; --i2) {
            State state = stateArray[i2];
            if (state == null || !state.hasSDCommand()) continue;
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1078071040, "[AbstractSDSUIService#executeSDComponents] [%1] state (STATEID#%2), position '%3' in active state stack, has sd commands. Executing SD components.", (Object)this.data.terminal.getTerminalName(), (long)state.getStateID(), (long)i2);
            this.data.getSMM4ID(state.getStateID()).execSDForState(this.stateMachine.getSDSService(), iTTSASRContext, state.getStateID());
            if (!state.hasSDCommandWithoutInheritance()) continue;
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1078071040, "[AbstractSDSUIService#executeSDComponents] [%1] inheritance of commands of parent-states deactivated for state (STATEID#%1), finished.", (Object)this.data.terminal.getTerminalName(), (long)state.getStateID());
            return true;
        }
        return false;
    }

    protected SDSUIHandler getUIHandler() {
        return this.getTerminal().getSDSUIHandler();
    }

    @Override
    public void noStateChange() {
    }
}

