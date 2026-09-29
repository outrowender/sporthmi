/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent
 */
package de.audi.app.ecall.core.bap.sos;

import de.audi.app.ecall.core.bap.sos.EmergencyCallServiceHandler;
import de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent;

class EmergencyCallServiceHandler$1
implements IEcallDiagnosisComponent {
    private final /* synthetic */ EmergencyCallServiceHandler this$0;

    EmergencyCallServiceHandler$1(EmergencyCallServiceHandler emergencyCallServiceHandler) {
        this.this$0 = emergencyCallServiceHandler;
    }

    public void cmdSOSActivatePopupSession() {
        EmergencyCallServiceHandler.access$000(this.this$0);
    }

    public void cmdSOSDisactivatePopupSession() {
        EmergencyCallServiceHandler.access$100(this.this$0);
    }

    public void cmdSOSShowScreen(int n) {
        EmergencyCallServiceHandler.access$200(this.this$0, n);
    }
}

