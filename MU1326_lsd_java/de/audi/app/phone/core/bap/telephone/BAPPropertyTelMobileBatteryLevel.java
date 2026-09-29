/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.AbstractTel1EnqueuedBAPPropertyHandler;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPhoneMobileBatteryLevel;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPhoneMobileBatteryLevel$ChargeLevel;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class BAPPropertyTelMobileBatteryLevel
extends AbstractTel1EnqueuedBAPPropertyHandler {
    public BAPPropertyTelMobileBatteryLevel(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    @Override
    protected boolean doProcessGlobalTelephoneStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null && (n == 0x6000100 || n == 0x3000100 || n == 0xF000100);
    }

    private boolean isChargeLevelCritical(int n) {
        return n == 0 || n == 1;
    }

    private int getClusterBatteryLevel(int n) {
        int n2 = 254;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 19;
                break;
            }
            case 2: {
                n2 = 39;
                break;
            }
            case 3: {
                n2 = 59;
                break;
            }
            case 4: {
                n2 = 79;
                break;
            }
            case 5: {
                n2 = 100;
                break;
            }
            default: {
                n2 = 254;
            }
        }
        return n2;
    }

    @Override
    protected void updateAsync() {
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiService();
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        if (combiBAPServicePhone != null) {
            if (iGlobalTelephoneStateStruct != null) {
                boolean bl = this.isChargeLevelCritical(iGlobalTelephoneStateStruct.getBatteryChargeLevel());
                int n = iGlobalTelephoneStateStruct.isPhoneReady() ? this.getClusterBatteryLevel(iGlobalTelephoneStateStruct.getBatteryChargeLevel()) : 255;
                this.log.log(1078071040, "[BAPPropertyTelMobileBatteryLevel#update] mobile1ChargeLevel=%1 mobile1ChargeLevelCritical=%2", (Object)String.valueOf(n), (Object)String.valueOf(bl));
                CombiBAPhoneMobileBatteryLevel$ChargeLevel combiBAPhoneMobileBatteryLevel$ChargeLevel = new CombiBAPhoneMobileBatteryLevel$ChargeLevel(n, bl);
                CombiBAPhoneMobileBatteryLevel combiBAPhoneMobileBatteryLevel = CombiBAPhoneMobileBatteryLevel.createOnlyMobileChargeLevel1(combiBAPhoneMobileBatteryLevel$ChargeLevel);
                combiBAPServicePhone.updateMobileBatteryLevel(combiBAPhoneMobileBatteryLevel);
            } else {
                this.log.log(-1601830656, "[BAPPropertyTelMobileBatteryLevel#update] state or activationState is null --> NOP!");
            }
        } else {
            this.log.log(-1601830656, "[BAPPropertyTelMobileBatteryLevel#update] CombiBAPServicePhone is null --> NOP!");
        }
    }
}

