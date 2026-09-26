/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl$PhoneServiceDiag;
import de.audi.atip.interapp.phone.ITelCallControl;
import de.audi.atip.interapp.phone.ITelCallInformation;
import de.audi.atip.interapp.phone.ITelCallSession;

class AbstractPhoneServiceImpl$PhoneServiceDiag$1
implements ITelCallSession {
    private final /* synthetic */ String val$telephoneNumber;
    private final /* synthetic */ int val$callType;
    private final /* synthetic */ AbstractPhoneServiceImpl$PhoneServiceDiag this$1;

    AbstractPhoneServiceImpl$PhoneServiceDiag$1(AbstractPhoneServiceImpl$PhoneServiceDiag abstractPhoneServiceImpl$PhoneServiceDiag, String string, int n) {
        this.this$1 = abstractPhoneServiceImpl$PhoneServiceDiag;
        this.val$telephoneNumber = string;
        this.val$callType = n;
    }

    @Override
    public void updateCallInformation(ITelCallInformation iTelCallInformation, int n) {
        AbstractPhoneServiceImpl.access$3700(AbstractPhoneServiceImpl$PhoneServiceDiag.access$3600(this.this$1)).log(-2137614336, "[AbstractPhoneServiceImpl.PhoneServiceDiag.cmdPhoneServiceDialNumberSession(...).new ITelCallSession() {...}#updateCallInformation] callInformation=%1", (Object)iTelCallInformation);
    }

    @Override
    public void onClose() {
        AbstractPhoneServiceImpl.access$3800(AbstractPhoneServiceImpl$PhoneServiceDiag.access$3600(this.this$1)).log(-2137614336, "[AbstractPhoneServiceImpl.PhoneServiceDiag.cmdPhoneServiceDialNumberSession(...).new ITelCallSession() {...}#onClose]");
    }

    @Override
    public void onActive(ITelCallControl iTelCallControl) {
        AbstractPhoneServiceImpl.access$3900(AbstractPhoneServiceImpl$PhoneServiceDiag.access$3600(this.this$1)).log(-2137614336, "[AbstractPhoneServiceImpl.PhoneServiceDiag.cmdPhoneServiceDialNumberSession(...).new ITelCallSession() {...}#onActive] callControl=%1", (Object)iTelCallControl);
        AbstractPhoneServiceImpl$PhoneServiceDiag.access$4002(this.this$1, iTelCallControl);
    }

    @Override
    public String getTelephoneNumber() {
        return this.val$telephoneNumber;
    }

    @Override
    public int getCallType() {
        return this.val$callType;
    }
}

