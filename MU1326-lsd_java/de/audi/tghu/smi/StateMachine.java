/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.hmi.KbdService;
import de.audi.atip.statemachine.ApplicationSMM;
import de.audi.atip.statemachine.Popup;
import de.audi.atip.statemachine.State;
import de.audi.atip.statemachine.SystemSMM;
import de.audi.tghu.smi.AbstractStateMachine;
import de.audi.tghu.smi.HapticUIService;
import de.audi.tghu.smi.Logger;
import de.audi.tghu.smi.PopupStateMachine;
import de.audi.tghu.smi.SDSUIService;
import de.audi.tghu.smi.SMI;
import de.audi.tghu.smi.StateMachineData;
import de.audi.tghu.smi.StateMachineTerminal;
import de.esolutions.fw.util.commons.Converter;

public class StateMachine
extends AbstractStateMachine {
    public StateMachine(StateMachineTerminal stateMachineTerminal, int n, SMI sMI, Logger logger) {
        super(sMI, logger, "main", new StateMachineData(stateMachineTerminal, n, logger));
        logger.createLogChannel(this);
        this.uiService = this.getTerminalID() == 6 ? new SDSUIService() : new HapticUIService();
        this.uiService.setStateMachine(this);
    }

    public boolean addSysSMM(SystemSMM systemSMM) {
        return this.data.addSysSMM(systemSMM);
    }

    public boolean removeSysSMM(SystemSMM systemSMM) {
        boolean bl = false;
        if (this.data.isSysSMM(systemSMM)) {
            this.stop();
            bl = this.data.removeSysSMM(systemSMM);
        }
        return bl;
    }

    public boolean addAppSMM(ApplicationSMM applicationSMM) {
        return this.data.addAppSMM(applicationSMM);
    }

    public boolean removeAppSMM(ApplicationSMM applicationSMM) {
        boolean bl = this.data.removeAppSMM(applicationSMM);
        if (bl) {
            this.reinitActiveStateStack();
        }
        return bl;
    }

    public void removeAllSMMs() {
        this.stop();
        this.data.removeAllSMMs();
    }

    @Override
    protected int getTopLevelStateID() {
        return this.data.getTopLevelState();
    }

    @Override
    protected void showPartialPopups(int n, int[] nArray) {
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isInfo()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1078071040, "[StateMachine#showPartialPopup] request partialPopups %1 for screen (VIEWID#%2) at HMIService", (Object)Converter.intArrayToString(nArray), (long)n);
        }
        this.getSMI().showPartialPopups(this.data.terminalID, n, nArray);
    }

    @Override
    protected void hidePartialPopups(int n, int[] nArray) {
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isInfo()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1078071040, "[StateMachine#hidePartialPopups] remove partialPopups %1 for screen (VIEWID#%2) at HMIService", (Object)Converter.intArrayToString(nArray), (long)n);
        }
        this.getSMI().hidePartialPopups(this.data.terminalID, n, nArray);
    }

    public boolean jumpToState(String string) {
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1078071040, "[StateMachine#jumpToState] [%1] start processing jump-event to state (label '%2').", (Object)this.tag, (Object)string);
        boolean bl = false;
        State state = this.data.getState(string);
        if (state != null) {
            if (state.isComposite()) {
                this.internalEvent = 1;
                State state2 = this.processInternalEvents(state);
                if (state2 != null) {
                    this.jumpToState(state2);
                }
            } else if (state != null) {
                this.jumpToState(state);
            }
            state.dispose();
        }
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1078071040, "[StateMachine#jumpToState] [%1] jump-event to state (label '%2') processed.", (Object)this.tag, (Object)string);
        return bl;
    }

    @Override
    public void enterJointUse(int n, int n2) {
        this.getSMI().enterJointUse(n, n2);
    }

    @Override
    public void leaveJointUse(int n, int n2) {
        this.getSMI().leaveJointUse(n, n2);
    }

    @Override
    public int getJointUseCount() {
        return this.getSMI().getJointUseCount();
    }

    public PopupStateMachine createPopup(int n) {
        Popup popup = this.data.getPopup(n);
        if (popup != null) {
            PopupStateMachine popupStateMachine = new PopupStateMachine(popup, this.data, this.getSMI(), this.logger);
            KbdService kbdService = this.getKeyboardService();
            if (kbdService != null) {
                popupStateMachine.setKeyboardService(kbdService.getKbdService());
            }
            this.getFramework().getErrorMgr().registerDumpInfoProvider(popupStateMachine.getErrorLog());
            return popupStateMachine;
        }
        return null;
    }
}

