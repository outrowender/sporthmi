/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.AbstractTel1EnqueuedBAPPropertyHandler;
import de.audi.app.phone.core.bap.BapPropertyTelSignalQualityUtil;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class BAPPropertyTelSignalQuality
extends AbstractTel1EnqueuedBAPPropertyHandler {
    private volatile int currentCombiSignalQuality = -1;

    public BAPPropertyTelSignalQuality(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    protected boolean doProcessGlobalTelephoneStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallLeadingDevice() != null;
    }

    protected void updateAsync() {
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState;
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiService();
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iTelDSIMobileEquipmentDeviceState = this.getTelephoneState() != null ? this.getTelephoneState().getCallLeadingDevice() : null;
        if (combiBAPServicePhone != null) {
            if (iTelDSIMobileEquipmentDeviceState != null) {
                int n = BapPropertyTelSignalQualityUtil.getCombiSignalQuality(iTelDSIMobileEquipmentDeviceState.getSignalQuality());
                if (n != this.currentCombiSignalQuality) {
                    this.log.log(1000000, "[BAPPropertyTelSignalQuality#update] combiSignalQuality=%1", (long)n);
                    combiBAPServicePhone.updateSignalQuality(n);
                    this.currentCombiSignalQuality = n;
                }
            } else {
                this.log.log(100000, "[BAPPropertyTelSignalQuality#update] state is null --> NOP!");
            }
        } else {
            this.log.log(100000, "[BAPPropertyTelSignalQuality#update] CombiBAPServicePhone is null --> NOP!");
        }
    }
}

