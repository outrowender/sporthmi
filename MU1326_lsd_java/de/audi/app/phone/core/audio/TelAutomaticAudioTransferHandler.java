/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;

public class TelAutomaticAudioTransferHandler
extends AbstractPhoneComponent {
    public TelAutomaticAudioTransferHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Audio");
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (n == 0x8000200 || n == 0x8000100 || n == 0xE000100 || n == 0xE000200) {
            this.checkChangeHFModeToPrivate(iGlobalTelephoneStateStruct);
        }
    }

    private void checkChangeHFModeToPrivate(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        CallStateStruct callStateStruct;
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(10000, "TelAutomaticAudioTransferHandler#checkChangeHFModeToPrivate stateStruct is null");
            return;
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getNonCallLeadingDevice();
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iGlobalTelephoneStateStruct.getCallLeadingDevice();
        CallStateStruct callStateStruct2 = iTelDSIMobileEquipmentDeviceState2 != null ? iTelDSIMobileEquipmentDeviceState2.getCallState() : null;
        CallStateStruct callStateStruct3 = callStateStruct = iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.getCallState() : null;
        if (callStateStruct2 != null && callStateStruct != null) {
            boolean bl;
            boolean bl2 = callStateStruct2.getMpCallState() == 3 || callStateStruct2.getMpCallState() == 32;
            boolean bl3 = callStateStruct.getMpCallState() == 3 || callStateStruct.getMpCallState() == 32;
            boolean bl4 = !callStateStruct2.isIdle() && !callStateStruct.isIdle();
            boolean bl5 = bl = !bl2 && !bl3;
            if (bl4 && bl && iTelDSIMobileEquipmentDeviceState.getTelMode() == 3 && iTelDSIMobileEquipmentDeviceState.getHandsFreeMode() == 0 && !iGlobalTelephoneStateStruct.isAcceptIncomingCallOnNonCallLeadingDevicePending()) {
                this.log.log(1078071040, "[TelAutomaticAudioTransferHandler#checkChangeHFModeToPrivate] switching handsfree mode for non call leading device to private");
                this.getApplication().getTelephoneDSIAccess().requestSetHandsFreeModeNonCallLeadingDevice(4, 0);
            }
        }
    }
}

