/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.hmi.model.AdditionalScreenData;
import de.audi.atip.statemachine.State;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.tghu.smi.AbstractSDSUIService;
import de.audi.tghu.smi.AbstractStateMachine;

public class SDSPopupUIService
extends AbstractSDSUIService {
    private boolean PARALLEL_PROMPT_SPEAKING_AND_GRAMMAR_LOADING_ENABLED = true;
    private State[] currentPopupStateStack;

    @Override
    public void setStateMachine(AbstractStateMachine abstractStateMachine) {
        super.setStateMachine(abstractStateMachine);
        this.getUIHandler().setSDSPopupUIService(this);
    }

    protected void reTriggerActivateUI() {
        this.logger.smi.log(1078071040, "[SDSPopupUIService#triggerActivateUI] [%1] entered.", (Object)this.data.terminal.getTerminalName());
        this.activateUI(this.currentPopupStateStack, this.currentPopupStateStack.length, true);
    }

    @Override
    public void activateUI(State[] stateArray, int n, AdditionalScreenData additionalScreenData) {
        this.logger.smi.log(1078071040, "[SDSPopupUIService#activateUI(2P)] [%1] entered.", (Object)this.data.terminal.getTerminalName());
        if (this.stateMachine.getSDSService() == null) {
            this.logger.smi.log(1000, "[SDSUIService#activateUI] [%1] no SDS-SMIConnector for SD-Components available (null).", (Object)this.data.terminal.getTerminalName());
            return;
        }
        State state = stateArray[n - 1];
        this.stateMachine.errLog.uiActivated(state.getStateID(), true);
        this.activateUI(stateArray, n, false);
    }

    private void activateUI(State[] stateArray, int n, boolean bl) {
        this.logger.smi.log(1078071040, "[SDSPopupUIService#activateUI] [%1] entered.", (Object)this.data.terminal.getTerminalName());
        this.currentPopupStateStack = new State[n];
        System.arraycopy((Object)stateArray, 0, (Object)this.currentPopupStateStack, 0, n);
        if (this.stateMachine.getSDSService() == null) {
            this.logger.smi.log(1000, "[SDSPopupUIService#activateUI] [%1] no SDS-SMIConnector for SD-Components available (null). Aborting.", (Object)this.data.terminal.getTerminalName());
            return;
        }
        State state = stateArray[n - 1];
        ITTSASRContext iTTSASRContext = this.stateMachine.getSDSService().createGrammarContext();
        if (state.hasSDPrompt()) {
            this.stateMachine.getErrorLog().startExecutingSDForState(state.getStateID());
            if (!bl) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1078071040, "[SDSPopupUIService#activateUI] [%1] current state (STATEID#%2) has PROMPT, activate SD component.", (Object)this.data.terminal.getTerminalName(), (long)state.getStateID());
                this.stateMachine.getSDSService().startPrompt();
                this.data.getSMM4ID(state.getStateID()).execSDForState(this.stateMachine.getSDSService(), iTTSASRContext, state.getStateID());
                this.stateMachine.getSDSService().stopPrompt();
            } else {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1078071040, "[SDSPopupUIService#activateUI] current state has prompt, but activation was retriggered by lower SDS context statemachine. So prompt is already spoken, it will be ignored.", (Object)this.data.terminal.getTerminalName());
            }
            if (this.PARALLEL_PROMPT_SPEAKING_AND_GRAMMAR_LOADING_ENABLED) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1078071040, "[SDSPopupUIService#activateUI] [%1] parallel prompt speaking and load grammars: Checking all states beneath the prompt-state for SD components...", (Object)this.data.terminal.getTerminalName());
                this.loadGrammars(iTTSASRContext, stateArray, n, true);
            }
            this.stateMachine.getErrorLog().finishedExecutingSDForState();
        } else {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1078071040, "[SDSPopupUIService#activateUI] [%1] checking, if state in active state stack has commands as SD components...", (Object)this.data.terminal.getTerminalName());
            this.stateMachine.getErrorLog().startExecutingSDForState(state.getStateID());
            this.loadGrammars(iTTSASRContext, stateArray, n, false);
            this.stateMachine.getErrorLog().finishedExecutingSDForState();
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1078071040, "[SDSPopupUIService#activateUI] [%1] checking finished.", (Object)this.data.terminal.getTerminalName());
        }
    }

    private void loadGrammars(ITTSASRContext iTTSASRContext, State[] stateArray, int n, boolean bl) {
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1078071040, "[SDSPopupUIService#loadGrammars] [%1] checking state stack of popup-sm...", (Object)this.data.terminal.getTerminalName());
        boolean bl2 = this.executeSDComponents(iTTSASRContext, stateArray, n, bl);
        if (!bl2) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1078071040, "[SDSPopupUIService#loadGrammars] [%1] checking state stack of normal sm...", (Object)this.data.terminal.getTerminalName());
            this.executeSDComponents(iTTSASRContext, this.getUIHandler().getMainStateStack(), this.getUIHandler().getMainStateStackSize(), false);
        }
        this.stateMachine.getSDSService().setGrammarContext(iTTSASRContext);
    }

    @Override
    public void reactivateUI(State[] stateArray, int n, AdditionalScreenData additionalScreenData) {
        this.activateUI(stateArray, n, additionalScreenData);
    }

    @Override
    protected void lockScreen(boolean bl) {
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1078071040, "[SDSPopupUIService#lockScreen] [%1] lock = '%1'. ignoring for SDS!", (Object)this.data.terminal.getTerminalName(), (Object)Boolean.toString(bl));
    }

    @Override
    protected void stopUI() {
        this.getUIHandler().sdsPopupRemoved(this);
    }

    TTSASR getSDSService() {
        return this.stateMachine.getSDSService();
    }
}

