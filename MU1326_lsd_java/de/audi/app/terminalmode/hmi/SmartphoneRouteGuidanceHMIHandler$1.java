/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.hmi;

import de.audi.app.terminalmode.hmi.SmartphoneRouteGuidanceHMIHandler;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.audi.atip.utils.generics.Function;

class SmartphoneRouteGuidanceHMIHandler$1
implements Function {
    private final /* synthetic */ SmartphoneRouteGuidanceHMIHandler this$0;

    SmartphoneRouteGuidanceHMIHandler$1(SmartphoneRouteGuidanceHMIHandler smartphoneRouteGuidanceHMIHandler) {
        this.this$0 = smartphoneRouteGuidanceHMIHandler;
    }

    public Integer apply(ApplicationOwner applicationOwner) {
        return new Integer(ApplicationOwner.DEVICE.is(applicationOwner) ? 1 : 0);
    }

    @Override
    public /* synthetic */ Object apply(Object object) {
        return this.apply((ApplicationOwner)object);
    }
}

