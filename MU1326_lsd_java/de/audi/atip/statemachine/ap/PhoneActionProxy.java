/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface PhoneActionProxy
extends ActionProxy {
    public void callDivertActivateLeft(int var1);

    public void hkBackNetworkSearch(int var1);

    public void hkBackNetworkRegistration(int var1);

    public void numberSpellerEntered(int var1);

    public void intellicallFullViewEntered(int var1);

    public void telIntelliCallLeft(int var1);

    public void telIntelliCallEntered(int var1);

    public void HKTelPressed(int var1);

    public void TelAppEntered(int var1);

    public void TelAppLeft(int var1);

    public void favoritesEntered(int var1);

    public void adbEntered(int var1);

    public void audiServiceEntered(int var1);

    public void smsEntered(int var1);

    public void numberSpellerLeft(int var1);

    public void intellicallReducedViewEntered(int var1);

    public void intellicallReducedViewLeft(int var1);

    public void intellicallFullViewLeft(int var1);

    public void favoritesLeft(int var1);

    public void callDivertActivateEntered(int var1);

    public void resetSearchResult(int var1);

    public void switchToTelIncomingCallAccepted(int var1);

    public void resetFavoriteSearchResult(int var1);

    public void popupTelephoneOptionsEntered(int var1);

    public void popupTelephoneOptionsLeft(int var1);

    public void telUnlockEntered(int var1);

    public void telUnlockLeft(int var1);

    public void clearNumberSpeller(int var1);

    public void telOptSetupNetMainEntered(int var1);

    public void telOptSetupNetMainLeft(int var1);

    public void audiConnectNavigatorEntered(int var1);

    public void phoneToneSetupEntered(int var1);

    public void cancelRingingTone(int var1);

    public void epmSwitchToPreviousContext(int var1);

    public void switchToTelOutgoingCall(int var1);
}

