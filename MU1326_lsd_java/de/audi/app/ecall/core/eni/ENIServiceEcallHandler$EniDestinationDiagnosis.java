/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent
 */
package de.audi.app.ecall.core.eni;

import de.audi.app.ecall.core.eni.ENIServiceEcallHandler;
import de.audi.app.ecall.core.eni.ENIServiceEcallHandler$1;
import de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent;

class ENIServiceEcallHandler$EniDestinationDiagnosis
implements IEcallDiagnosisComponent {
    private final /* synthetic */ ENIServiceEcallHandler this$0;

    private ENIServiceEcallHandler$EniDestinationDiagnosis(ENIServiceEcallHandler eNIServiceEcallHandler) {
        this.this$0 = eNIServiceEcallHandler;
    }

    public void cmdShowDestinationPopup() {
        ENIServiceEcallHandler.access$900(this.this$0).getHMIService().showPopup(ENIServiceEcallHandler.access$800(this.this$0));
    }

    public void cmdOnExpirationWarning(boolean bl, int n) {
        this.this$0.onExpirationWarning(bl, n, false);
    }

    public void cmdOnLicenseExpired() {
        this.this$0.onLicenceExpired();
    }

    public void cmdConfirmExpired() {
        ENIServiceEcallHandler.access$300(this.this$0).confirmEcallExpirated();
    }

    /* synthetic */ ENIServiceEcallHandler$EniDestinationDiagnosis(ENIServiceEcallHandler eNIServiceEcallHandler, ENIServiceEcallHandler$1 eNIServiceEcallHandler$1) {
        this(eNIServiceEcallHandler);
    }
}

