/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.AbstractTel1EnqueuedBAPPropertyHandler;
import de.audi.app.phone.core.bap.TelBapNetworkProviderStruct;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class BAPPropertyTelNetworkProvider
extends AbstractTel1EnqueuedBAPPropertyHandler {
    private volatile TelBapNetworkProviderStruct networkProviderStruct;

    public BAPPropertyTelNetworkProvider(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    @Override
    protected boolean doProcessGlobalTelephoneStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallLeadingDevice() != null;
    }

    @Override
    protected void updateAsync() {
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiService();
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = this.getCallLeadingDeviceState();
        if (combiBAPServicePhone != null) {
            if (iTelDSIMobileEquipmentDeviceState != null) {
                String string = iTelDSIMobileEquipmentDeviceState.getServiceProvider() != null ? iTelDSIMobileEquipmentDeviceState.getServiceProvider().getTelServiceProviderName() : null;
                int n = string != null && string.length() > 0 ? 1 : 0;
                String string2 = iTelDSIMobileEquipmentDeviceState.getDisplayNetworkName();
                int n2 = string2 != null && string2.length() > 0 ? 1 : 0;
                TelBapNetworkProviderStruct telBapNetworkProviderStruct = new TelBapNetworkProviderStruct(n2, string2, n, string);
                if (!telBapNetworkProviderStruct.equals(this.networkProviderStruct)) {
                    this.log.log(1078071040, "[BAPPropertyTelNetworkProvider#update] %1", (Object)telBapNetworkProviderStruct);
                    combiBAPServicePhone.updateNetworkProvider(telBapNetworkProviderStruct.getNetworkProviderState(), telBapNetworkProviderStruct.getNetworkProviderName(), telBapNetworkProviderStruct.getServiceProviderState(), telBapNetworkProviderStruct.getServiceProviderName());
                    this.networkProviderStruct = telBapNetworkProviderStruct;
                }
            } else {
                this.log.log(-1601830656, "[BAPPropertyTelNetworkProvider#update] state is null --> NOP!");
            }
        } else {
            this.log.log(-1601830656, "[BAPPropertyTelNetworkProvider#update] CombiBAPServicePhone is null --> NOP!");
        }
    }
}

