/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.evo.epm;

import de.audi.app.phone.evo.epm.TelEPMHandler;
import de.audi.app.phone.evo.epm.TelEPMHandler$1;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;

class TelEPMHandler$TelEPMDiag
implements IPhoneDiagComponent {
    private final /* synthetic */ TelEPMHandler this$0;

    private TelEPMHandler$TelEPMDiag(TelEPMHandler telEPMHandler) {
        this.this$0 = telEPMHandler;
    }

    public void cmdEPMOutgoingCallSwitchNavToTelephone(String string) {
        TelEPMHandler.access$1400(this.this$0).getTelephoneDSIAccess().dialNumber(string, 0);
        TelEPMHandler.access$1500(this.this$0).getFrameworkAccess().getHMIService().fireSMEvent(0, 1629160960);
    }

    /* synthetic */ TelEPMHandler$TelEPMDiag(TelEPMHandler telEPMHandler, TelEPMHandler$1 telEPMHandler$1) {
        this(telEPMHandler);
    }
}

