/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.connectivity.IDiagComponent
 */
package de.audi.app.data.core.esim;

import de.audi.app.data.core.esim.EsimHandler;
import de.mib.swdiagnosis.connectivity.IDiagComponent;

public class EsimHandler$EsimHandlerDiag
implements IDiagComponent {
    private final /* synthetic */ EsimHandler this$0;

    public EsimHandler$EsimHandlerDiag(EsimHandler esimHandler) {
        this.this$0 = esimHandler;
    }

    public void cmdUpdateESIMLicenseState(int n, boolean bl) {
        EsimHandler.access$302(this.this$0, bl);
        this.this$0.updateLicenseState(n);
    }

    public void cmdGetPersistedEsimLicenseState() {
        EsimHandler.access$600(this.this$0).log(1078071040, "EsimHandler#cmdGetPersistedEsimLicenseState(): %1", (Object)EsimHandler.access$400()[EsimHandler.access$500(this.this$0) - 1]);
    }
}

