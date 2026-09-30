/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.AbstractTel1EnqueuedBAPPropertyHandler;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class BAPPropertyTelMicroMuteOnOff
extends AbstractTel1EnqueuedBAPPropertyHandler {
    private volatile boolean firstUpdateSent;
    private volatile boolean currentCombiMicMuteState;

    public BAPPropertyTelMicroMuteOnOff(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    protected boolean doProcessGlobalTelephoneStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallLeadingDevice() != null;
    }

    protected void updateAsync() {
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiService();
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = this.getCallLeadingDeviceState();
        if (combiBAPServicePhone != null) {
            if (iTelDSIMobileEquipmentDeviceState != null) {
                boolean bl;
                boolean bl2 = bl = iTelDSIMobileEquipmentDeviceState.getmICMuteState() == 0;
                if (bl != this.currentCombiMicMuteState || !this.firstUpdateSent) {
                    this.firstUpdateSent = true;
                    this.log.log(1000000, "[BAPPropertyTelMicroMuteOnOff#update] micMuteState=%1", bl);
                    combiBAPServicePhone.updateMicMuteState(bl);
                    this.currentCombiMicMuteState = bl;
                }
            } else {
                this.log.log(100000, "[BAPPropertyTelMicroMuteOnOff#update] state is null --> NOP!");
            }
        } else {
            this.log.log(100000, "[BAPPropertyTelMicroMuteOnOff#update] CombiBAPServicePhone is null --> NOP!");
        }
    }
}

