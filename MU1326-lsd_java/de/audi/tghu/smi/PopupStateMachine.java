/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.statemachine.Popup;
import de.audi.tghu.smi.AbstractStateMachine;
import de.audi.tghu.smi.HapticPopupUIService;
import de.audi.tghu.smi.Logger;
import de.audi.tghu.smi.SDSPopupUIService;
import de.audi.tghu.smi.SMI;
import de.audi.tghu.smi.StateMachineData;

public class PopupStateMachine
extends AbstractStateMachine {
    private final Popup popup;

    public PopupStateMachine(Popup popup, StateMachineData stateMachineData, SMI sMI, Logger logger) {
        super(sMI, logger, new StringBuffer().append("p").append(popup.getPopupID()).toString(), stateMachineData);
        this.popup = popup;
        this.uiService = this.getTerminalID() == 6 ? new SDSPopupUIService() : new HapticPopupUIService();
        this.uiService.setStateMachine(this);
    }

    public Popup getPopup() {
        return this.popup;
    }

    public int getID() {
        return this.popup.getPopupID();
    }

    public int getPriority() {
        return this.popup.getPriority();
    }

    public int getLastScreen() {
        try {
            return ((HapticPopupUIService)this.uiService).getLastScreen();
        }
        catch (ClassCastException classCastException) {
            return -1;
        }
    }

    @Override
    protected int getTopLevelStateID() {
        return this.popup.getTopLevelState();
    }

    @Override
    protected void showPartialPopups(int n, int[] nArray) {
        this.getSMI().showPartialPopupsOnPopup(this.data.terminalID, this.popup, n, nArray);
    }

    @Override
    protected void hidePartialPopups(int n, int[] nArray) {
        this.getSMI().hidePartialPopupsOnPopup(this.data.terminalID, this.popup, n, nArray);
    }
}

