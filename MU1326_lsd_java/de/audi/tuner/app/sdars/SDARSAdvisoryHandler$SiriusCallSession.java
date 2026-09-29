/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.interapp.phone.ITelCallControl;
import de.audi.atip.interapp.phone.ITelCallInformation;
import de.audi.atip.interapp.phone.ITelCallSession;
import de.audi.tuner.app.sdars.SDARSAdvisoryHandler;

class SDARSAdvisoryHandler$SiriusCallSession
implements ITelCallSession {
    private final String siriusTelephoneNumber;
    private final /* synthetic */ SDARSAdvisoryHandler this$0;

    public SDARSAdvisoryHandler$SiriusCallSession(SDARSAdvisoryHandler sDARSAdvisoryHandler, String string) {
        this.this$0 = sDARSAdvisoryHandler;
        this.siriusTelephoneNumber = string;
    }

    @Override
    public int getCallType() {
        return 0;
    }

    @Override
    public String getTelephoneNumber() {
        return this.siriusTelephoneNumber;
    }

    @Override
    public void onActive(ITelCallControl iTelCallControl) {
    }

    @Override
    public void onClose() {
        SDARSAdvisoryHandler.access$200(this.this$0);
    }

    @Override
    public void updateCallInformation(ITelCallInformation iTelCallInformation, int n) {
    }
}

