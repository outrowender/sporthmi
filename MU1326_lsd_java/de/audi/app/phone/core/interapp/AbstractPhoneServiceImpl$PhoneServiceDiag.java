/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl$1;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl$PhoneServiceDiag$1;
import de.audi.atip.interapp.phone.ITelCallControl;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;

class AbstractPhoneServiceImpl$PhoneServiceDiag
implements IPhoneDiagComponent {
    private ITelCallControl sessionControl;
    private final /* synthetic */ AbstractPhoneServiceImpl this$0;

    private AbstractPhoneServiceImpl$PhoneServiceDiag(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        this.this$0 = abstractPhoneServiceImpl;
    }

    public void cmdPhoneServiceDialNumberSession(String string, int n, boolean bl) {
        this.this$0.dialNumber(new AbstractPhoneServiceImpl$PhoneServiceDiag$1(this, string, n), bl);
    }

    public void cmdPhoneServiceHangupSession() {
        ITelCallControl iTelCallControl = this.sessionControl;
        if (iTelCallControl != null) {
            iTelCallControl.hangupCall();
        }
    }

    /* synthetic */ AbstractPhoneServiceImpl$PhoneServiceDiag(AbstractPhoneServiceImpl abstractPhoneServiceImpl, AbstractPhoneServiceImpl$1 abstractPhoneServiceImpl$1) {
        this(abstractPhoneServiceImpl);
    }

    static /* synthetic */ AbstractPhoneServiceImpl access$3600(AbstractPhoneServiceImpl$PhoneServiceDiag abstractPhoneServiceImpl$PhoneServiceDiag) {
        return abstractPhoneServiceImpl$PhoneServiceDiag.this$0;
    }

    static /* synthetic */ ITelCallControl access$4002(AbstractPhoneServiceImpl$PhoneServiceDiag abstractPhoneServiceImpl$PhoneServiceDiag, ITelCallControl iTelCallControl) {
        abstractPhoneServiceImpl$PhoneServiceDiag.sessionControl = iTelCallControl;
        return abstractPhoneServiceImpl$PhoneServiceDiag.sessionControl;
    }
}

