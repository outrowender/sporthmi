/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone2;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.TelBapNetworkProviderStruct;
import de.audi.app.phone.core.bap.telephone2.AbstractTel2EnqueuedBAPPropertyHandler;
import de.audi.app.phone.core.bap.telephone2.TelBAPManagerTel2Utils;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone2;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class BAPPropertyTel2NetworkProvider
extends AbstractTel2EnqueuedBAPPropertyHandler {
    private volatile TelBapNetworkProviderStruct networkProviderStruct;

    private static String getServiceProviderName(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getNadInstanceState() != null) {
            return iGlobalTelephoneStateStruct.getNadInstanceState().getServiceProvider() != null ? iGlobalTelephoneStateStruct.getNadInstanceState().getServiceProvider().getTelServiceProviderName() : "";
        }
        return "";
    }

    private static String getNetworkProviderName(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getNadInstanceState() != null) {
            return iGlobalTelephoneStateStruct.getNadInstanceState() != null ? iGlobalTelephoneStateStruct.getNadInstanceState().getDisplayNetworkName() : "";
        }
        return "";
    }

    BAPPropertyTel2NetworkProvider(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    @Override
    protected boolean doProcessGlobalTelephoneStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null;
    }

    @Override
    protected void updateAsync() {
        int n;
        CombiBAPServicePhone2 combiBAPServicePhone2 = this.getCombiService();
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        if (combiBAPServicePhone2 == null) {
            this.log.log(-1601830656, "[BAPPropertyTel2NetworkProvider#update] CombiBAPServicePhone is null --> NOP!");
            return;
        }
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(-1601830656, "[BAPPropertyTel2NetworkProvider#update] state is null --> NOP!");
            return;
        }
        String string = BAPPropertyTel2NetworkProvider.getServiceProviderName(iGlobalTelephoneStateStruct);
        String string2 = BAPPropertyTel2NetworkProvider.getNetworkProviderName(iGlobalTelephoneStateStruct);
        int n2 = string2 != null && string2.length() > 0 ? 1 : 0;
        TelBapNetworkProviderStruct telBapNetworkProviderStruct = new TelBapNetworkProviderStruct(n2, string2, n = string != null && string.length() > 0 ? 1 : 0, string);
        if (!telBapNetworkProviderStruct.equals(this.networkProviderStruct)) {
            if (iGlobalTelephoneStateStruct.getNadInstanceState() == null || !iGlobalTelephoneStateStruct.getNadInstanceState().isPhoneReady()) {
                this.log.log(1078071040, "[BAPPropertyTel2NetworkProvider#update] %1", (Object)telBapNetworkProviderStruct);
                combiBAPServicePhone2.updateNetworkProvider(0, "", 0, "");
            } else if (TelBAPManagerTel2Utils.telModeSupportsData(iGlobalTelephoneStateStruct.getNadInstanceState().getTelMode())) {
                this.log.log(1078071040, "[BAPPropertyTel2NetworkProvider#update] %1", (Object)telBapNetworkProviderStruct);
                combiBAPServicePhone2.updateNetworkProvider(telBapNetworkProviderStruct.getNetworkProviderState(), telBapNetworkProviderStruct.getNetworkProviderName(), telBapNetworkProviderStruct.getServiceProviderState(), telBapNetworkProviderStruct.getServiceProviderName());
                this.networkProviderStruct = telBapNetworkProviderStruct;
            } else {
                this.log.log(-1601830656, "[BAPPropertyTel2NetworkProvider#update] NadInstance with HPF Mode! --> NOP!");
            }
        }
    }
}

