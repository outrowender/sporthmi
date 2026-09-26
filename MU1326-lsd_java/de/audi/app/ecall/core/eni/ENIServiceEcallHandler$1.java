/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.eni;

import de.audi.app.ecall.core.eni.ENIServiceEcallHandler;
import de.audi.atip.hmi.model.DefaultButtonListener;

class ENIServiceEcallHandler$1
extends DefaultButtonListener {
    private final /* synthetic */ ENIServiceEcallHandler this$0;

    ENIServiceEcallHandler$1(ENIServiceEcallHandler eNIServiceEcallHandler) {
        this.this$0 = eNIServiceEcallHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == ENIServiceEcallHandler.access$100(this.this$0).getID()) {
            ENIServiceEcallHandler.access$200(this.this$0).log(1078071040, "ENIServiceEcallHandler.init().new DefaultButtonListener() {...}#keyTyped(): handling EXPIRE_NOTE_OK_BUTTON");
            ENIServiceEcallHandler.access$300(this.this$0).confirmExpirationWarning();
        } else if (n == ENIServiceEcallHandler.access$400(this.this$0).getID()) {
            ENIServiceEcallHandler.access$500(this.this$0).log(1078071040, "ENIServiceEcallHandler.init().new DefaultButtonListener() {...}#keyTyped(): handling EXPIRED_OK_BUTTON");
            ENIServiceEcallHandler.access$300(this.this$0).confirmEcallExpirated();
        }
        ENIServiceEcallHandler.access$602(this.this$0, 0);
        ENIServiceEcallHandler.access$700(this.this$0).onLicensePopupConfirmed();
        this.this$0.getButtonModel(n).fireEvent(0);
    }
}

