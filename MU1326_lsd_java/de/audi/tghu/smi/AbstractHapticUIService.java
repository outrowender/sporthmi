/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.hmi.model.AdditionalScreenData;
import de.audi.atip.statemachine.State;
import de.audi.tghu.smi.AbstractUIService;
import de.esolutions.fw.util.commons.Buffer;

public abstract class AbstractHapticUIService
extends AbstractUIService {
    @Override
    public void activateUI(State[] stateArray, int n, AdditionalScreenData additionalScreenData) {
        int n2;
        State state;
        if (this.logger.smi.isInfo()) {
            this.logger.smi.log(1078071040, "[AbstractHapticUIService#activateUI] [%1] metaInfos='%2'", (Object)this.data.terminal.getTerminalName(), (Object)additionalScreenData);
        }
        if ((state = stateArray[n - 1]).isComposite()) {
            this.logger.smi.log(1000, "[AbstractHapticUIService#activateUI] [%1] event processing terminated without activating a simple state (STATEID#%2).", (Object)this.data.terminal.getTerminalName(), (long)state.getStateID());
            this.getSMI().criticalError("critical error during SMI processing");
        }
        int n3 = 1;
        for (int i2 = 0; i2 < n; ++i2) {
            if (!stateArray[i2].isIncludeSlot()) continue;
            ++n3;
        }
        int[] nArray = new int[n3];
        nArray[0] = stateArray[n - 1].getScreenID();
        int n4 = 1;
        for (n2 = n - 2; n2 > -1; --n2) {
            if (!stateArray[n2].isIncludeSlot()) continue;
            nArray[n4] = stateArray[n2].getStateID();
            ++n4;
        }
        n2 = state.getScreenID();
        if (n2 == -1) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractHapticUIService#activateUI] [%1] no screen specified for simple state (STATEID#%2).", (Object)this.data.terminal.getTerminalName(), (long)state.getStateID());
            this.getSMI().criticalError("critical model error during SMI processing");
        }
        boolean bl = this.stateMachine.lockingScreen();
        boolean bl2 = this.stateMachine.isReinitScreen();
        boolean bl3 = this.stateMachine.isAnimateScreenChange();
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isInfo()) {
            Buffer buffer = new Buffer(50);
            buffer.append(bl2 ? " & reinit" : "");
            buffer.append(bl3 ? " & animate" : "");
            buffer.append("(VIEWID#").append(n2).append(") ");
            buffer.append(bl ? "locked" : "unlocked");
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1078071040, "[AbstractHapticUIService#activateUI] [%1] activate screen %2", (Object)this.data.terminal.getTerminalName(), (Object)buffer.toString());
        }
        try {
            this.showScreen(n2, nArray, bl2, bl, bl3, this.stateMachine.getPartialPopupShowList(), additionalScreenData);
        }
        catch (Exception exception) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractHapticUIService#activateUI] [%1] exception occured in HMIService#showScreen, tried to activate screen (VIEWID#%2).", (Object)this.data.terminal.getTerminalName(), (Object)Integer.toString(n2), (Object)exception);
            this.getSMI().criticalError("critical HMI error during SMI processing", exception);
        }
    }

    @Override
    public void reactivateUI(State[] stateArray, int n, AdditionalScreenData additionalScreenData) {
        int n2;
        State state = stateArray[n - 1];
        if (state.isComposite()) {
            this.logger.smi.log(1000, "[AbstractHapticUIService#reactivateUI] [%1] event processing terminated without activating a simple state (STATEID#%2).", (Object)this.data.terminal.getTerminalName(), (long)state.getStateID());
            this.getSMI().criticalError("critical error during SMI processing");
        }
        int n3 = 1;
        for (int i2 = 0; i2 < n; ++i2) {
            if (!stateArray[i2].isIncludeSlot()) continue;
            ++n3;
        }
        int[] nArray = new int[n3];
        nArray[0] = stateArray[n - 1].getScreenID();
        int n4 = 1;
        for (n2 = n - 2; n2 > -1; --n2) {
            if (!stateArray[n2].isIncludeSlot()) continue;
            nArray[n4] = stateArray[n2].getStateID();
            ++n4;
        }
        n2 = state.getScreenID();
        if (n2 == -1) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractHapticUIService#reactivateUI] [%1] no screen specified for simple state (STATEID#%2).", (Object)this.data.terminal.getTerminalName(), (long)state.getStateID());
            this.getSMI().criticalError("critical model error during SMI processing");
        }
        boolean bl = this.stateMachine.lockingScreen();
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1078071040, "[AbstractHapticUIService#reactivateUI] [%1] activate & reinit screen (VIEWID#%2).", (Object)this.data.terminal.getTerminalName(), (long)n2);
        try {
            this.showScreen(n2, nArray, true, bl, false, this.stateMachine.getPartialPopupShowList(), additionalScreenData);
        }
        catch (Exception exception) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractHapticUIService#reactivateUI] [%1] exception activating screen (VIEWID#%2).", (Object)this.data.terminal.getTerminalName(), (Object)Integer.toString(n2), (Object)exception);
            this.getSMI().criticalError("critical HMI error during SMI processing", exception);
        }
    }

    protected abstract void showScreen(int n, int[] nArray, boolean bl, boolean bl2, boolean bl3, int[] nArray2, AdditionalScreenData additionalScreenData) {
    }

    @Override
    protected void lockScreen(boolean bl) {
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(14808325, "[AbstractHapticUIService#lockScreen] [%1] lock='%2'", (Object)this.data.terminal.getTerminalName(), (Object)Boolean.toString(bl));
        }
        try {
            this.stateMachine.getSMI().lockCurrentScreen(this.data.terminalID, this.data.subterminalID, bl);
        }
        catch (Exception exception) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractHapticUIService#lockScreen] [%1] exception during %2 current screen", (Object)this.data.terminal.getTerminalName(), (Object)(bl ? "locking" : "unlocking"), (Object)exception);
            this.getSMI().criticalError("critical HMI error during SMI processing", exception);
        }
    }

    @Override
    protected void stopUI() {
    }

    @Override
    public void noStateChange() {
        try {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1078071040, "[AbstractHapticUIService#noStateChange] [%1] inform HMI service, that no screen/state has changed", (Object)this.data.terminal.getTerminalName());
            this.getSMI().noStateChange(this.data.terminalID);
        }
        catch (Exception exception) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#noStateChange] [%1] exception (%2) during noStateChanged", (Object)this.data.terminal.getTerminalName(), (Throwable)exception);
            this.getSMI().criticalError("critical HMI error during SMI processing (no state change)", exception);
        }
    }
}

