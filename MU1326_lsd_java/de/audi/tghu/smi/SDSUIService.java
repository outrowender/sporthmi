/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.hmi.model.AdditionalScreenData;
import de.audi.atip.statemachine.State;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.tghu.smi.AbstractSDSUIService;
import de.audi.tghu.smi.AbstractStateMachine;

public class SDSUIService
extends AbstractSDSUIService {
    @Override
    public void setStateMachine(AbstractStateMachine abstractStateMachine) {
        super.setStateMachine(abstractStateMachine);
        this.getUIHandler().setLogger(this.logger.sm[this.data.terminalID][this.data.subterminalID]);
        this.getUIHandler().setSDSUIService(this);
    }

    @Override
    public void activateUI(State[] stateArray, int n, AdditionalScreenData additionalScreenData) {
        this.logger.smi.log(1078071040, "[SDSUIService#activateUI] [%1] entered.", (Object)this.data.terminal.getTerminalName());
        if (this.stateMachine.getSDSService() == null) {
            this.logger.smi.log(1000, "[SDSUIService#activateUI] [%1] no SDS-SMIConnector for SD-Components available (null).", (Object)this.data.terminal.getTerminalName());
            return;
        }
        this.getUIHandler().updateMainStateStack(stateArray, n);
        if (this.stateMachine.getTerminal().isPopupActive()) {
            this.logger.smi.log(1078071040, "[SDSUIService#activateUI] [%1] Popup is active. A synchronization must have triggered the state-change. The send grammars may be inconsistent now. Triggering activateUI at SDSPopup-UI.", (Object)this.data.terminal.getTerminalName());
            this.getUIHandler().retriggerActivateSDSPopupUIService();
            return;
        }
        State state = stateArray[n - 1];
        this.stateMachine.errLog.uiActivated(state.getStateID(), false);
        this.activateUISDS(stateArray, n);
    }

    protected void activateUISDS(State[] stateArray, int n) {
        this.logger.smi.log(1078071040, "[SDSUIService#activateUISDS] entered.");
        if (this.stateMachine.getSDSService() == null) {
            this.logger.smi.log(1000, "[SDSUIService#activateUI] [%1] no SDS-SMIConnector for SD-Components available (null).", (Object)this.data.terminal.getTerminalName());
            return;
        }
        State state = stateArray[n - 1];
        if (state.hasSDPrompt()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[SDSUIService#activateUISDS] [%1] WARNING! States in normal SDS-Statemachine are not allowed to have prompts! State with prompt is (STATEID#%2).", (Object)this.data.terminal.getTerminalName(), (long)state.getStateID());
            return;
        }
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1078071040, "[SDSUIService#activateUISDS] [%1] checking, if state (STATEID#%2) in active state stack has commands as SD components...", (Object)this.data.terminal.getTerminalName(), (long)state.getStateID());
        this.stateMachine.getErrorLog().startExecutingSDForState(state.getStateID());
        ITTSASRContext iTTSASRContext = this.stateMachine.getSDSService().createGrammarContext();
        this.executeSDComponents(iTTSASRContext, stateArray, n, false);
        this.stateMachine.getSDSService().setGrammarContext(iTTSASRContext);
        this.stateMachine.getErrorLog().finishedExecutingSDForState();
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1078071040, "[SDSUIService#activateUISDS] [%1] checking finished.", (Object)this.data.terminal.getTerminalName());
    }

    @Override
    public void reactivateUI(State[] stateArray, int n, AdditionalScreenData additionalScreenData) {
        this.activateUI(stateArray, n, additionalScreenData);
    }

    @Override
    protected void lockScreen(boolean bl) {
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1078071040, "[SDSUIService#lockScreen] [%1] lock = '%2'. ignoring for SDS!", (Object)this.data.terminal.getTerminalName(), (Object)Boolean.toString(bl));
    }

    @Override
    protected void stopUI() {
    }
}

