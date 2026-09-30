/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.IActionProxyListener;
import de.audi.app.phone.core.screen.AbstractTelDefaultScreenStateListener;
import de.audi.app.phone.core.sim.PhoneLockStateHandler;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.screen.TelEvoPopupHandler;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Map;
import org.dsi.ifc.telephoneng.LockStateStruct;

public class PhoneEvoLockStateHandler
extends PhoneLockStateHandler
implements IActionProxyListener {
    private static final int TEL_UNLOCK_LEFT = 0;
    private static final int TEL_UNLOCK_ENTERED = 1;
    private volatile boolean telUnlockEntered;
    private volatile boolean telAppEntered;
    private volatile int lockStateValue;
    private final TelEvoPopupHandler unlockPopupAssociatedHandler;

    public PhoneEvoLockStateHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.unlockPopupAssociatedHandler = new TelEvoPopupHandler(iTelApplication, 300016);
        this.addSubPhoneComponent(this.unlockPopupAssociatedHandler);
        this.addSubPhoneComponent(new TelUnlockPinBlockedScreenListener(iTelApplication));
    }

    public void init() {
        super.init();
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(7, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(8, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(29, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(30, this);
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(7, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(8, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(29, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(30, this);
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        super.updateGlobalTelephoneStateProperty(n, iGlobalTelephoneStateStruct);
        if (n == 131087 || n == 131075) {
            this.checkShowUnlockPopupForAssociatedPhone();
        }
    }

    public void updateLockState(ChoiceModelApp choiceModelApp, LockStateStruct lockStateStruct) {
        this.lockStateValue = lockStateStruct != null ? lockStateStruct.getTelLockState() : 0;
        this.checkPreventConnectivityOnlineCheckUnlockPopup();
        super.updateLockState(choiceModelApp, lockStateStruct);
    }

    private void checkShowUnlockPopupForAssociatedPhone() {
        int n;
        int n2 = this.telephoneState.getLockStateAssociated() != null ? this.telephoneState.getLockStateAssociated().getTelLockState() : 0;
        int n3 = n = this.telephoneState.getActivationStateAssociated() != null ? this.telephoneState.getActivationStateAssociated().getTelActivationState() : 0;
        if (n == 5 && n2 != 2 && n2 != 0) {
            this.unlockPopupAssociatedHandler.requestShowPopup(0);
        }
    }

    private void checkPreventConnectivityOnlineCheckUnlockPopup() {
        int n;
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telephoneState;
        int n2 = n = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getNadMode() : 1;
        if (this.log.isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append("lockStateValue=");
            buffer.append(this.lockStateValue);
            buffer.append(", ");
            buffer.append("telAppEntered=");
            buffer.append(this.telAppEntered);
            buffer.append(", ");
            buffer.append("telUnlockEntered=");
            buffer.append(this.telUnlockEntered);
            buffer.append(", ");
            buffer.append("nadMode=");
            buffer.append(n);
            this.log.log(1000000, "[PhoneEvoLockStateHandler#checkPreventConnectivityOnlineCheckUnlockPopup] %1", (Object)buffer);
        }
        if ((this.lockStateValue == 3 || this.lockStateValue == 5 || this.lockStateValue == 7 || this.lockStateValue == 11) && this.telAppEntered && !this.telUnlockEntered && n == 1) {
            this.log.log(1000000, "[PhoneEvoLockStateHandler#checkPreventConnectivityOnlineCheckUnlockPopup] TEL_UNLOCK not entered but will be shortly, , setting TEL_UNLOCK_ENTERED_CHOICE to 1");
            this.getChoiceModel(4025).setValue(1);
        } else if (this.telUnlockEntered) {
            this.log.log(1000000, "[PhoneEvoLockStateHandler#checkPreventConnectivityOnlineCheckUnlockPopup] TEL_UNLOCK is really entered, setting TEL_UNLOCK_ENTERED_CHOICE to 1");
            this.getChoiceModel(4025).setValue(1);
        } else {
            this.log.log(1000000, "[PhoneEvoLockStateHandler#checkPreventConnectivityOnlineCheckUnlockPopup] TEL_UNLOCK is left, setting TEL_UNLOCK_ENTERED_CHOICE to 0");
            this.getChoiceModel(4025).setValue(0);
        }
    }

    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 7: {
                this.telAppEntered = true;
                this.checkPreventConnectivityOnlineCheckUnlockPopup();
                break;
            }
            case 8: {
                this.telAppEntered = false;
                this.checkPreventConnectivityOnlineCheckUnlockPopup();
                break;
            }
            case 29: {
                this.telUnlockEntered = true;
                this.checkPreventConnectivityOnlineCheckUnlockPopup();
                break;
            }
            case 30: {
                this.telUnlockEntered = false;
                this.checkPreventConnectivityOnlineCheckUnlockPopup();
                break;
            }
            default: {
                this.log.log(100000, "[PhoneEvoLockStateHandler#actionProxyCallPerformed] unhandled action proxy id %1", (long)n);
            }
        }
    }

    private class TelUnlockPinBlockedScreenListener
    extends AbstractTelDefaultScreenStateListener {
        public TelUnlockPinBlockedScreenListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Main", 300036);
        }

        public void notifyScreenConnected(int n) {
            this.log.log(1000000, "[PhoneEvoLockStateHandler.TelUnlockPinBlockedScreenListener#notifyScreenConnected]");
        }

        public void notifyScreenFadedOut(int n) {
            this.log.log(1000000, "[PhoneEvoLockStateHandler.TelUnlockPinBlockedScreenListener#notifyScreenFadedOut]");
            PhoneEvoLockStateHandler.this.resetPukConditionChoice();
        }
    }
}

