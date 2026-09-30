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
import de.audi.tghu.online.app.operatorcall.services.AbstractPoiCallModelHandler;

public class PoiCallModelHandlerEvo
extends AbstractPoiCallModelHandler {
    public PoiCallModelHandlerEvo(HMIService hMIService, AbstractOperatorCall abstractOperatorCall) {
        super(hMIService, abstractOperatorCall);
    }

    public void showPopup(int n) {
    }

    protected AbstractHistoryCallListRow getHistoryCallListRow(EvoListRow evoListRow) {
        return (HistoryCallListRowEvo)evoListRow;
    }

    protected PoiResultListRow getPoiResultListRow(EvoListRow evoListRow) {
        return (PoiResultListRowEvo)evoListRow;
    }

    protected boolean isPhoneReadyForJokerkey() {
        return true;
    }
}

