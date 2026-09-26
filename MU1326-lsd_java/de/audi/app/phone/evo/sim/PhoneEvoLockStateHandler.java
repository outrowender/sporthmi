/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.IActionProxyListener;
import de.audi.app.phone.core.sim.PhoneLockStateHandler;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.screen.TelEvoPopupHandler;
import de.audi.app.phone.evo.sim.PhoneEvoLockStateHandler$TelUnlockPinBlockedScreenListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Map;
import org.dsi.ifc.telephoneng.LockStateStruct;

public class PhoneEvoLockStateHandler
extends PhoneLockStateHandler
implements IActionProxyListener {
    private static final int TEL_UNLOCK_LEFT;
    private static final int TEL_UNLOCK_ENTERED;
    private volatile boolean telUnlockEntered;
    private volatile boolean telAppEntered;
    private volatile int lockStateValue;
    private final TelEvoPopupHandler unlockPopupAssociatedHandler;

    public PhoneEvoLockStateHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.unlockPopupAssociatedHandler = new TelEvoPopupHandler(iTelApplication, -258800640);
        this.addSubPhoneComponent(this.unlockPopupAssociatedHandler);
        this.addSubPhoneComponent(new PhoneEvoLockStateHandler$TelUnlockPinBlockedScreenListener(this, iTelApplication));
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(7, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(8, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(29, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(30, this);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(7, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(8, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(29, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(30, this);
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        super.updateGlobalTelephoneStateProperty(n, iGlobalTelephoneStateStruct);
        if (n == 0xF000200 || n == 0x3000200) {
            this.checkShowUnlockPopupForAssociatedPhone();
        }
    }

    @Override
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
            this.log.log(1078071040, "[PhoneEvoLockStateHandler#checkPreventConnectivityOnlineCheckUnlockPopup] %1", (Object)buffer);
        }
        if ((this.lockStateValue == 3 || this.lockStateValue == 5 || this.lockStateValue == 7 || this.lockStateValue == 11) && this.telAppEntered && !this.telUnlockEntered && n == 1) {
            this.log.log(1078071040, "[PhoneEvoLockStateHandler#checkPreventConnectivityOnlineCheckUnlockPopup] TEL_UNLOCK not entered but will be shortly, , setting TEL_UNLOCK_ENTERED_CHOICE to 1");
            this.getChoiceModel(4025).setValue(1);
        } else if (this.telUnlockEntered) {
            this.log.log(1078071040, "[PhoneEvoLockStateHandler#checkPreventConnectivityOnlineCheckUnlockPopup] TEL_UNLOCK is really entered, setting TEL_UNLOCK_ENTERED_CHOICE to 1");
            this.getChoiceModel(4025).setValue(1);
        } else {
            this.log.log(1078071040, "[PhoneEvoLockStateHandler#checkPreventConnectivityOnlineCheckUnlockPopup] TEL_UNLOCK is left, setting TEL_UNLOCK_ENTERED_CHOICE to 0");
            this.getChoiceModel(4025).setValue(0);
        }
    }

    @Override
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
                this.log.log(-1601830656, "[PhoneEvoLockStateHandler#actionProxyCallPerformed] unhandled action proxy id %1", (long)n);
            }
        }
    }

    static /* synthetic */ void access$000(PhoneEvoLockStateHandler phoneEvoLockStateHandler) {
        phoneEvoLockStateHandler.resetPukConditionChoice();
    }
}

