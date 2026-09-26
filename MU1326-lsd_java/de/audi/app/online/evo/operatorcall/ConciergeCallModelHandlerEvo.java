/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.operatorcall;

import de.audi.app.online.evo.operatorcall.HistoryCallListRowEvo;
import de.audi.app.online.evo.operatorcall.PoiResultListRowEvo;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.data.AbstractHistoryCallListRow;
import de.audi.tghu.online.app.operatorcall.data.PoiResultListRow;
import de.audi.tghu.online.app.operatorcall.services.AbstractConciergeCallModelHandler;

public class ConciergeCallModelHandlerEvo
extends AbstractConciergeCallModelHandler {
    public ConciergeCallModelHandlerEvo(HMIService hMIService, AbstractOperatorCall abstractOperatorCall) {
        super(hMIService, abstractOperatorCall);
    }

    @Override
    public void showPopup(int n) {
        if (n == 1) {
            this.hmiService.showPopup(42);
        } else {
            this.logChannel.log(-1601830656, "ConciergeCallModelHandlerEvo#showPopup: no such popup defined (%1)", (long)n);
        }
    }

    @Override
    protected AbstractHistoryCallListRow getHistoryCallListRow(EvoListRow evoListRow) {
        return (HistoryCallListRowEvo)evoListRow;
    }

    @Override
    protected PoiResultListRow getPoiResultListRow(EvoListRow evoListRow) {
        return (PoiResultListRowEvo)evoListRow;
    }

    @Override
    protected boolean isPhoneReadyForJokerkey() {
        if (this.isAnyCallRunning()) {
            this.logChannel.log(-1601830656, "ConciergeCallModelHandlerEvo#isPhoneReadyForJokerkey: a call is running!");
            this.logChannel.log(1078071040, "ConciergeCallModelHandlerEvo#isPhoneReadyForJokerkey: if it is the own call, guide will show the current state of the call. If another call is running, guide should show call-in-use screen");
            return true;
        }
        int n = this.getPhoneReadyChoiceValue();
        if (n != 1) {
            this.logChannel.log(-1601830656, "ConciergeCallModelHandlerEvo#isPhoneReadyForJokerkey: no other call is running, but phone is not ready to use.");
            return false;
        }
        return true;
    }
}

