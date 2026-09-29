/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent
 */
package de.audi.app.ecall.core.bap.opr;

import de.audi.app.ecall.core.bap.opr.BreakdownCallServiceHandler;
import de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent;

class BreakdownCallServiceHandler$1
implements IEcallDiagnosisComponent {
    private final /* synthetic */ BreakdownCallServiceHandler this$0;

    BreakdownCallServiceHandler$1(BreakdownCallServiceHandler breakdownCallServiceHandler) {
        this.this$0 = breakdownCallServiceHandler;
    }

    public void cmdOPRActivatePopupSession(boolean bl) {
        BreakdownCallServiceHandler.access$000(this.this$0).getOPRPopupHandler().activateEcallSession();
    }

    public void cmdOPRDisactivatePopupSession() {
        BreakdownCallServiceHandler.access$100(this.this$0).getOPRPopupHandler().disactivateEcallSession();
    }

    public void cmdOPRShowScreen(int n) {
        BreakdownCallServiceHandler.access$200(this.this$0, n);
    }
}

