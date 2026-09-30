/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.operatorcall;

import de.audi.atip.hmi.HMIService;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.services.AbstractBreakdownCallModelHandler;

public class BreakdownCallModelHandlerEvo
extends AbstractBreakdownCallModelHandler {
    public BreakdownCallModelHandlerEvo(HMIService hMIService, AbstractOperatorCall abstractOperatorCall) {
        super(hMIService, abstractOperatorCall);
    }

    protected boolean isPhoneReadyForJokerkey() {
        return true;
    }
}

