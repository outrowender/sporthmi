/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.AbstractTel1EnqueuedBAPPropertyHandler;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class BAPPropertyTelRingtoneMute
extends AbstractTel1EnqueuedBAPPropertyHandler {
    BAPPropertyTelRingtoneMute(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    protected boolean doProcessGlobalTelephoneStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return n == 262150 || n == 262149;
    }

    protected void updateAsync() {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(10000000, "[BAPPropertyTelRingtoneMute#updateAsync] telephoneState is null --> NOP!");
            return;
        }
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiService();
        boolean bl = iGlobalTelephoneStateStruct.isRingtoneMuteSettingOn();
        boolean bl2 = iGlobalTelephoneStateStruct.isRingtoneMuteActive();
        if (combiBAPServicePhone != null) {
            boolean bl3 = bl ? true : bl2;
            this.log.log(1000000, "[BAPPropertyTelRingtoneMute#update]  ringtoneMuteSettingActive=%1, ringtoneMuteActive=%2 --> ringToneMuted=%3", bl, bl2, bl3);
            combiBAPServicePhone.updateRingToneMuteState(bl3);
        }
    }
}

