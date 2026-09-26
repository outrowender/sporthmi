/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.event.AbstractTelInterappEvent;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl;
import de.audi.atip.interapp.phone.ITelCallSession;

class AbstractPhoneServiceImpl$3
extends AbstractTelInterappEvent {
    private final /* synthetic */ ITelCallSession val$callSession;
    private final /* synthetic */ boolean val$jumpToPhone;
    private final /* synthetic */ AbstractPhoneServiceImpl this$0;

    AbstractPhoneServiceImpl$3(AbstractPhoneServiceImpl abstractPhoneServiceImpl, String string, ITelCallSession iTelCallSession, boolean bl) {
        this.this$0 = abstractPhoneServiceImpl;
        this.val$callSession = iTelCallSession;
        this.val$jumpToPhone = bl;
        super(string);
    }

    @Override
    public void run() {
        if (this.val$callSession != null) {
            String string = this.val$callSession.getTelephoneNumber();
            int n = this.val$callSession.getCallType();
            AbstractPhoneServiceImpl.access$2100(this.this$0).log(1078071040, "[AbstractPhoneServiceImpl#dialNumber] number=%1, type=%2", (Object)string, (long)n);
            if (n == 0) {
                AbstractPhoneServiceImpl.access$2200(this.this$0).addSession(this.val$callSession);
                this.this$0.dialNumber(string, null, this.val$jumpToPhone);
            } else if (n == 1 || n == 768 || n == 512 || n == 256) {
                AbstractPhoneServiceImpl.access$2200(this.this$0).addSession(this.val$callSession);
                AbstractPhoneServiceImpl.access$2300(this.this$0).getTelephoneDSIAccess().dialOperator(string, n, 0);
            } else {
                AbstractPhoneServiceImpl.access$2400(this.this$0).log(-1601830656, "[AbstractPhoneServiceImpl#dialNumber] callType=%1 --> NOP!", (long)n);
            }
        } else {
            AbstractPhoneServiceImpl.access$2500(this.this$0).log(-1601830656, "[AbstractPhoneServiceImpl#dialNumber] callSession is null --> NOP!");
        }
    }
}

