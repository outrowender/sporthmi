/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.proxy;

import de.audi.app.phone.core.ap.AbstractPhoneActionProxyImpl;
import de.audi.app.phone.core.ap.IActionProxyDispatcher;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.statemachine.ap.PhoneActionProxy;
import org.osgi.framework.BundleContext;

public class PhoneActionProxyImpl
extends AbstractPhoneActionProxyImpl
implements PhoneActionProxy {
    static /* synthetic */ Class class$de$audi$atip$statemachine$ActionProxy;

    public PhoneActionProxyImpl(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext, IActionProxyDispatcher iActionProxyDispatcher) {
        super(iFrameworkAccess, bundleContext, iActionProxyDispatcher);
    }

    public void cancelRingingTone(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#cancelRingingTone] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(3, null);
    }

    public void numberSpellerEntered(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#numberSpellerEntered] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(1, null);
    }

    public void numberSpellerLeft(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#numberSpellerLeft] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(14, null);
    }

    public String getActionProxyInterfaceName() {
        return (class$de$audi$atip$statemachine$ActionProxy == null ? (class$de$audi$atip$statemachine$ActionProxy = PhoneActionProxyImpl.class$("de.audi.atip.statemachine.ActionProxy")) : class$de$audi$atip$statemachine$ActionProxy).getName();
    }

    public int getActionProxyInterfaceID() {
        return 12;
    }

    public void updateLockState(int n, int n2) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#updateLockState] terminalID=%1, newLockState=%2", (long)n, (long)n2);
    }

    public void phoneToneSetupEntered(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#phoneToneSetupEntered] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(2, null);
    }

    public void intellicallFullViewEntered(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#intellicallFullViewEntered] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(4, null);
    }

    public void intellicallFullViewLeft(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#intellicallFullViewLeft] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(18, null);
    }

    public void intellicallReducedViewEntered(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#intellicallReducedViewEntered] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(15, null);
    }

    public void intellicallReducedViewLeft(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#intellicallReducedViewLeft] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(17, null);
    }

    public void telIntelliCallEntered(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#telIntellicallEntered] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(5, null);
    }

    public void telIntelliCallLeft(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#telIntellicallLeft] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(6, null);
    }

    public void TelAppEntered(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#TelAppEntered] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(7, null);
    }

    public void TelAppLeft(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#TelAppLeft] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(8, null);
    }

    public void HKTelPressed(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#HKTelPressed] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(9, null);
    }

    public void favoritesEntered(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#favoritesEntered] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(10, null);
    }

    public void favoritesLeft(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#favoritesEntered] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(19, null);
    }

    public void adbEntered(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#adbEntered] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(11, null);
    }

    public void audiServiceEntered(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#audiServiceEntered] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(12, null);
    }

    public void audiConnectNavigatorEntered(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#audiConnectNavigatorEntered] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(36, null);
    }

    public void smsEntered(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#smsEntered] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(13, null);
    }

    public void callDivertActivateLeft(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#callDivertActivateLeft] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(16, null);
    }

    public void callDivertActivateEntered(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#callDivertActivateLeft] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(20, null);
    }

    public void resetSearchResult(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#resetSearchResult] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(21, null);
    }

    public void resetFavoriteSearchResult(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#resetFavoriteSearchResult] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(25, null);
    }

    public void switchToTelIncomingCallAccepted(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#switchToTelIncomingCallAccepted] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(22, null);
    }

    public void switchToTelOutgoingCall(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#switchToTelOutgoingCall] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(24, null);
    }

    public void epmSwitchToPreviousContext(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#epmSwitchToPreviousContext] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(23, null);
    }

    public void hkReturnPinSave(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#hkReturnPinSave] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(26, null);
    }

    public void hkBackNetworkSearch(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#hkBackNetworkSearch] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(31, null);
    }

    public void hkBackNetworkRegistration(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#hkBackNetworkRegistration] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(32, null);
    }

    public void popupTelephoneOptionsEntered(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#popupTelephoneOptionsEntered] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(27, null);
    }

    public void popupTelephoneOptionsLeft(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#popupTelephoneOptionsLeft] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(28, null);
    }

    public void telUnlockEntered(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#telUnlockEntered] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(29, null);
    }

    public void telUnlockLeft(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#telUnlockLeft] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(30, null);
    }

    public void clearNumberSpeller(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#clearNumberSpeller] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(33, null);
    }

    public void telOptSetupNetMainEntered(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#telOptSetupNetMainEntered] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(34, null);
    }

    public void telOptSetupNetMainLeft(int n) {
        this.getLogChannel().log(1000000, "[PhoneActionProxyImpl#telOptSetupNetMainEntered] terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(35, null);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

