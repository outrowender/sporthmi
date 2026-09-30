/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.audio;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;

public class TelEvoAudioTransferPopupHandler
extends AbstractPhoneComponent {
    private volatile boolean popupShown;
    private volatile String nonCallLeadingDeviceBtAddress;
    private volatile String lastTransferedDeviceBTAddress;

    private static boolean isHandsfreeModePrivateHFP(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getHandsFreeMode() == 4;
    }

    private static boolean isHFP(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getTelMode() == 3;
    }

    private static String getBtMacAddress(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getPhoneInformation() != null ? iTelDSIMobileEquipmentDeviceState.getPhoneInformation().getMeBtAddress() : "";
    }

    private static boolean isCallPresent(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null ? !iTelDSIMobileEquipmentDeviceState.getCallState().isHasIncomingCall() && !iTelDSIMobileEquipmentDeviceState.getCallState().isIdle() && iTelDSIMobileEquipmentDeviceState.getCallState().getMpCallState() != 3 && iTelDSIMobileEquipmentDeviceState.getCallState().getMpCallState() != 32 : false;
    }

    public TelEvoAudioTransferPopupHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.addSubPhoneComponent(new TransferAudioToMUButtonListener(iTelApplication));
        this.addSubPhoneComponent(new KeepAudioOnMEButtonListener(iTelApplication));
    }

    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (n == 131080 || n == 65544 || n == 65550 || n == 131086) {
            this.checkShowPopup(iGlobalTelephoneStateStruct);
        }
    }

    private void checkShowPopup(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice() : null;
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getNonCallLeadingDevice() : null;
        String string = TelEvoAudioTransferPopupHandler.getBtMacAddress(iTelDSIMobileEquipmentDeviceState);
        boolean bl = this.nonCallLeadingDeviceBtAddress != null && !"".equals(this.nonCallLeadingDeviceBtAddress) && this.nonCallLeadingDeviceBtAddress.equals(string);
        String string2 = this.nonCallLeadingDeviceBtAddress = TelEvoAudioTransferPopupHandler.isHFP(iTelDSIMobileEquipmentDeviceState2) && TelEvoAudioTransferPopupHandler.isCallPresent(iTelDSIMobileEquipmentDeviceState2) && TelEvoAudioTransferPopupHandler.isHandsfreeModePrivateHFP(iTelDSIMobileEquipmentDeviceState2) ? TelEvoAudioTransferPopupHandler.getBtMacAddress(iTelDSIMobileEquipmentDeviceState2) : "";
        if (bl && TelEvoAudioTransferPopupHandler.isCallPresent(iTelDSIMobileEquipmentDeviceState) && TelEvoAudioTransferPopupHandler.isHandsfreeModePrivateHFP(iTelDSIMobileEquipmentDeviceState)) {
            this.lastTransferedDeviceBTAddress = string;
            if (!iGlobalTelephoneStateStruct.isAcceptIncomingCallOnNonCallLeadingDevicePending()) {
                this.log.log(1000000, "[TelEvoAudioTransferPopupHandler#checkShowPopup] showing TEL_POPUP_AUDIO for device %1", (Object)string);
                this.showTelPopupAudio();
            } else {
                this.log.log(1000000, "[TelEvoAudioTransferPopupHandler#checkShowPopup] accepting call on nonCallLeadingDevice is pending, not showing popup.");
            }
        }
        if (this.popupShown) {
            int n;
            int n2 = n = iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null ? iTelDSIMobileEquipmentDeviceState.getCallState().getMpCallState() : 0;
            if (n == 0 || n == 3) {
                this.log.log(1000000, "[TelEvoAudioTransferPopupHandler#checkShowPopup] call state is idle or disconnecting - removing popup!");
                this.removeTelPopupAudio();
            }
            if (this.lastTransferedDeviceBTAddress != null && this.lastTransferedDeviceBTAddress.equals(string) && TelEvoAudioTransferPopupHandler.isHFP(iTelDSIMobileEquipmentDeviceState) && !TelEvoAudioTransferPopupHandler.isHandsfreeModePrivateHFP(iTelDSIMobileEquipmentDeviceState)) {
                this.log.log(1000000, "[TelEvoAudioTransferPopupHandler#checkShowPopup] HandsfreeMode is no longer HANDSFREE_PRIVATE_HFP for device %1 - removing popup.", (Object)string);
                this.removeTelPopupAudio();
            }
        }
    }

    private void showTelPopupAudio() {
        this.log.log(1000000, "[TelEvoAudioTransferPopupHandler#showTelPopupAudio] showing TEL_POPUP_AUDIO");
        this.getApplication().getFrameworkAccess().getHMIService().showPartialPopup(0, 300329);
        this.popupShown = true;
    }

    private void removeTelPopupAudio() {
        this.log.log(1000000, "[TelEvoAudioTransferPopupHandler#removeTelPopupAudio] removing TEL_POPUP_AUDIO");
        this.getApplication().getFrameworkAccess().getHMIService().removePartialPopup(0, 300329);
        this.popupShown = false;
    }

    private class KeepAudioOnMEButtonListener
    extends TelDefaultButtonListener {
        public KeepAudioOnMEButtonListener(ITelApplication iTelApplication) {
            super(iTelApplication, 301045);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[TelEvoAudioTransferPopupHandler.KeepAudioOnMEButtonListener#keyTyped]");
            TelEvoAudioTransferPopupHandler.this.removeTelPopupAudio();
        }
    }

    private class TransferAudioToMUButtonListener
    extends TelDefaultButtonListener {
        public TransferAudioToMUButtonListener(ITelApplication iTelApplication) {
            super(iTelApplication, 301046);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[TelEvoAudioTransferPopupHandler.TransferAudioToMUButtonListener#keyTyped] setting handsfreemode to HANDSFREEMODE_HANDSFREE");
            this.getApplication().getTelephoneDSIAccess().requestSetHandsFreeModeCallLeadingDevice(0, n3);
            TelEvoAudioTransferPopupHandler.this.removeTelPopupAudio();
        }
    }
}

