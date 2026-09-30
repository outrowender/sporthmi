/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.hmi.model.AdditionalScreenData;
import de.audi.tghu.smi.AbstractHapticUIService;

public class HapticUIService
extends AbstractHapticUIService {
    protected void showScreen(int n, int[] nArray, boolean bl, boolean bl2, boolean bl3, int[] nArray2, AdditionalScreenData additionalScreenData) {
        this.stateMachine.errLog.startActivatingScreen(this.stateMachine.getActiveScreenState(), n);
        long[] lArray = this.stateMachine.getContexts();
        this.stateMachine.getSMI().showScreen(this.data.terminalID, this.data.subterminalID, n, nArray, bl, bl2, bl3, nArray2, lArray, this.stateMachine.getDrawerIDs(), this.stateMachine.getScreenAnimations(), this.stateMachine.getColor(), this.stateMachine.getScreenMode(), additionalScreenData);
        this.stateMachine.resetScreenAnimations();
        this.stateMachine.errLog.finishedActivatingScreen();
    }
}

