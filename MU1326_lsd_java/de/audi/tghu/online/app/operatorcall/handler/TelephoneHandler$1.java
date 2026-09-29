/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.handler;

import de.audi.atip.interapp.phone.ITelCallControl;
import de.audi.tghu.online.app.operatorcall.handler.TelephoneHandler;

class TelephoneHandler$1
implements ITelCallControl {
    private final /* synthetic */ TelephoneHandler this$0;

    TelephoneHandler$1(TelephoneHandler telephoneHandler) {
        this.this$0 = telephoneHandler;
    }

    @Override
    public void hangupCall() {
        TelephoneHandler.access$000(this.this$0).log(-1601830656, "TelephoneHandler#createDummyTelControl#hangupCall: TelSimulation is running!");
    }

    @Override
    public void muteMicrophone(boolean bl) {
        TelephoneHandler.access$000(this.this$0).log(-1601830656, "TelephoneHandler#createDummyTelControl#muteMicrophone: TelSimulation is running!");
    }
}

