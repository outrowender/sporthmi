/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.hmi.model.AdditionalScreenData;
import de.audi.atip.statemachine.Popup;
import de.audi.tghu.smi.AbstractHapticUIService;
import de.audi.tghu.smi.AbstractStateMachine;
import de.audi.tghu.smi.PopupStateMachine;

public class HapticPopupUIService
extends AbstractHapticUIService {
    private Popup popup;
    private int lastScrID = -1;

    @Override
    public void setStateMachine(AbstractStateMachine abstractStateMachine) {
        super.setStateMachine(abstractStateMachine);
        this.popup = ((PopupStateMachine)abstractStateMachine).getPopup();
    }

    public int getLastScreen() {
        return this.lastScrID;
    }

    @Override
    protected void showScreen(int n, int[] nArray, boolean bl, boolean bl2, boolean bl3, int[] nArray2, AdditionalScreenData additionalScreenData) {
        this.stateMachine.errLog.startActivatingScreen(this.stateMachine.getActiveScreenState(), n);
        long[] lArray = this.stateMachine.getContexts();
        this.stateMachine.getSMI().showPopupScreen(this.data.terminalID, this.popup, this.lastScrID, n, nArray, bl, bl2, bl3, nArray2, lArray, this.stateMachine.getDrawerIDs(), this.stateMachine.getScreenAnimations(), this.stateMachine.getColor(), this.stateMachine.getScreenMode(), additionalScreenData);
        this.lastScrID = n;
        this.stateMachine.resetScreenAnimations();
        this.stateMachine.errLog.finishedActivatingScreen();
    }
}

