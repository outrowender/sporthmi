/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager;

import de.audi.app.connectivity.manager.ConnectivityManager;
import de.audi.app.connectivity.manager.contents.CoMaDeviceSim;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.interapp.IConnectivityPhoneStateListener;
import de.audi.atip.interapp.phone.ITelMESlotState;
import de.audi.atip.log.LogChannel;

final class ComaPhoneStateListener
implements IConnectivityPhoneStateListener {
    private static final int VO = 3;
    private static final int TEL1 = 1;
    private static final int TEL2 = 2;
    private static final int DO = 4;
    private static final int VD = 7;
    private static final int NONE = 0;
    private final LogChannel log;
    private final IHMIServiceApp hmiService;
    private final ConnectivityManager coma;
    private final boolean isNadModeSwitch;
    private String simName;
    private String eSimName;
    private String identifier = "";
    private boolean simInserted = false;
    private boolean simUnlocked = false;
    private boolean isVoiceSim = false;
    private boolean isEsim = false;
    private boolean isPrimaryPhone = true;
    private boolean isCallActive = false;
    private boolean isCallActiveNad = false;
    private boolean isOtherPhoneConnected = false;
    private boolean isTerminalModelActive = false;
    private boolean isAnyEorBCallActive;

    private static int getSupport(boolean bl, boolean bl2, boolean bl3) {
        return bl ? 4 : (bl2 ? 7 : (bl3 ? 3 : 4));
    }

    private static int getConnected(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        return bl ? 4 : (bl2 ? 0 : (bl3 ? (bl4 ? 1 : 2) | 4 : 4));
    }

    private static int getChangeable(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, int n) {
        return bl || bl6 ? 0 : (bl2 && !bl3 ? (bl5 ? 3 : (n == 6 ? 3 : 1)) : 0);
    }

    private static boolean isBluetoothPhoneConnected(ITelMESlotState iTelMESlotState) {
        return iTelMESlotState != null && iTelMESlotState.isDevicePossiblyAvailable() && iTelMESlotState.isBluetoothPhone();
    }

    ComaPhoneStateListener(LogChannel logChannel, ConnectivityManager connectivityManager, IHMIServiceApp iHMIServiceApp, boolean bl) {
        this.log = logChannel;
        this.hmiService = iHMIServiceApp;
        this.coma = connectivityManager;
        this.isNadModeSwitch = bl;
        this.updateTextConstants();
    }

    void languageChanged() {
        this.updateTextConstants();
        this.updateSimDisplay();
    }

    private void updateTextConstants() {
        this.simName = this.hmiService.getText(2500594);
        this.eSimName = this.hmiService.getText(2500842);
    }

    private void updateSimDisplay() {
        int n = ComaPhoneStateListener.getSupport(this.isEsim, this.isNadModeSwitch, this.isVoiceSim);
        int n2 = ComaPhoneStateListener.getConnected(this.isEsim, !this.simUnlocked, this.isVoiceSim, this.isPrimaryPhone);
        int n3 = ComaPhoneStateListener.getChangeable(this.isEsim, this.simUnlocked, this.isCallActive || this.isAnyEorBCallActive, this.isPrimaryPhone, this.isOtherPhoneConnected, this.isTerminalModelActive, n2);
        this.coma.updateSim(this.simInserted ? new CoMaDeviceSim(n, n2, n3, this.identifier, this.isEsim ? this.eSimName : this.simName, this.isCallActiveNad, this.isEsim) : null);
    }

    public void updateTerminalModeState(boolean bl) {
        this.isTerminalModelActive = bl;
        this.updateSimDisplay();
    }

    public void updatePhoneState(int n, int n2) {
        this.log.log(10000000, "ComaPhoneStateListener#updatePhoneState(): NAD mode=%1, phone module state=%2", (long)n, (long)n2);
        boolean bl = this.isVoiceSim = n == 1;
        if (this.coma != null) {
            this.coma.updatePhoneModuleState(n2 == 2);
        }
        this.updateSimDisplay();
    }

    public void updateESIMInfo(String string, String string2, boolean bl, boolean bl2) {
        if (bl == this.isEsim) {
            return;
        }
        this.log.log(10000000, "ComaPhoneStateListener#updateESIMInfo(): active=%1", bl);
        this.isEsim = bl;
        this.updateSimDisplay();
    }

    public void updateMESlotInfo(ITelMESlotState iTelMESlotState, ITelMESlotState iTelMESlotState2, ITelMESlotState iTelMESlotState3) {
        boolean bl;
        this.log.log(10000000, "ComaPhoneStateListener#updateMESlotInfo(): PRD=%1 ASD=%2 DATA=%3", (Object)iTelMESlotState, (Object)iTelMESlotState2, (Object)iTelMESlotState3);
        boolean bl2 = bl = iTelMESlotState != null && iTelMESlotState.isInternalSim();
        this.identifier = bl ? iTelMESlotState.getSimCardID() : (iTelMESlotState3 != null ? iTelMESlotState3.getSimCardID() : "");
        this.isPrimaryPhone = bl;
        this.simInserted = ComaPhoneStateListener.isInternalSim(iTelMESlotState3) || ComaPhoneStateListener.isInternalSim(iTelMESlotState2) || ComaPhoneStateListener.isInternalSim(iTelMESlotState);
        this.simUnlocked = iTelMESlotState3 != null && iTelMESlotState3.isUnlocked();
        this.isCallActive = ComaPhoneStateListener.isCallActive(iTelMESlotState3) || ComaPhoneStateListener.isCallActive(iTelMESlotState) || ComaPhoneStateListener.isCallActive(iTelMESlotState2);
        ITelMESlotState iTelMESlotState4 = ComaPhoneStateListener.findNad(iTelMESlotState, iTelMESlotState2, iTelMESlotState3);
        this.isCallActiveNad = iTelMESlotState4 != null ? iTelMESlotState4.isCallActiveOrPhoneRinging() : false;
        this.isOtherPhoneConnected = ComaPhoneStateListener.isBluetoothPhoneConnected(iTelMESlotState) || ComaPhoneStateListener.isBluetoothPhoneConnected(iTelMESlotState2);
        this.updateSimDisplay();
        this.coma.updateCallActivity(ComaPhoneStateListener.isCallActive(iTelMESlotState) || ComaPhoneStateListener.isCallActive(iTelMESlotState2));
        this.coma.updateAssociatedNewDeviceEntryActivation(iTelMESlotState != null && iTelMESlotState.getActivationState() == 5 && iTelMESlotState.getLockState() == 2);
    }

    private static boolean isCallActive(ITelMESlotState iTelMESlotState) {
        return iTelMESlotState != null && iTelMESlotState.isCallActiveOrPhoneRinging();
    }

    private static boolean isInternalSim(ITelMESlotState iTelMESlotState) {
        return iTelMESlotState != null && iTelMESlotState.isInternalSim() && iTelMESlotState.isDevicePossiblyAvailable();
    }

    private static ITelMESlotState findNad(ITelMESlotState iTelMESlotState, ITelMESlotState iTelMESlotState2, ITelMESlotState iTelMESlotState3) {
        return ComaPhoneStateListener.isSim(iTelMESlotState) ? iTelMESlotState : (ComaPhoneStateListener.isSim(iTelMESlotState2) ? iTelMESlotState2 : (ComaPhoneStateListener.isSim(iTelMESlotState3) ? iTelMESlotState3 : null));
    }

    private static boolean isSim(ITelMESlotState iTelMESlotState) {
        return iTelMESlotState != null && iTelMESlotState.isSim();
    }

    public void telUnlockLeft() {
    }

    public void telUnlockEntered() {
    }

    public void telAppLeft() {
    }

    public void telAppEntered() {
    }

    public void updateConnectedGatewayState(boolean bl) {
        if (this.isAnyEorBCallActive != bl) {
            this.isAnyEorBCallActive = bl;
            this.coma.updateEorBCallActivity(bl);
            this.updateSimDisplay();
        }
    }
}

