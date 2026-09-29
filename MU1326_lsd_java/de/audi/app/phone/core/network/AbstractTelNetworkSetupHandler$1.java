/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.network;

import de.audi.app.phone.core.network.AbstractTelNetworkSetupHandler;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;

class AbstractTelNetworkSetupHandler$1
implements IPhoneDiagComponent {
    private final /* synthetic */ AbstractTelNetworkSetupHandler this$0;

    AbstractTelNetworkSetupHandler$1(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        this.this$0 = abstractTelNetworkSetupHandler;
    }

    public void cmdShowNetworkNotAvailablePopup() {
        AbstractTelNetworkSetupHandler.access$000(this.this$0).log(-1601830656, "AbstractTelNetworkSetupHandler.AbstractTelNetworkSetupHandler(...).new IPhoneDiagComponent() {...}#cmdShowNetworkNotAvailablePopup(): start");
        AbstractTelNetworkSetupHandler.access$300(this.this$0).setValue(AbstractTelNetworkSetupHandler.access$200(this.this$0, AbstractTelNetworkSetupHandler.access$100(this.this$0)));
        AbstractTelNetworkSetupHandler.access$400(this.this$0).setError(-1);
        AbstractTelNetworkSetupHandler.access$500(this.this$0).log(-1601830656, "AbstractTelNetworkSetupHandler.AbstractTelNetworkSetupHandler(...).new IPhoneDiagComponent() {...}#cmdShowNetworkNotAvailablePopup(): end");
    }

    public void cmdShowNetworkUpdatePopup() {
        AbstractTelNetworkSetupHandler.access$600(this.this$0).log(-1601830656, "AbstractTelNetworkSetupHandler.AbstractTelNetworkSetupHandler(...).new IPhoneDiagComponent() {...}#cmdShowNetworkUpdatePopup(): start");
        AbstractTelNetworkSetupHandler.access$400(this.this$0).setUpdate();
        AbstractTelNetworkSetupHandler.access$700(this.this$0, this.this$0.modelIDNetworkSelectionButton()).fireEvent(0);
        AbstractTelNetworkSetupHandler.access$800(this.this$0).log(-1601830656, "AbstractTelNetworkSetupHandler.AbstractTelNetworkSetupHandler(...).new IPhoneDiagComponent() {...}#cmdShowNetworkUpdatePopup(): end");
    }
}

