/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface ConnectivityActionProxy
extends ActionProxy {
    public void connectivityDataHkTelPressed(int var1);

    public void connectivityWlanAbortInquiry(int var1);

    public void connectivityBluetoothBondingExitAction(int var1);

    public void connectivityBluetoothBondingEntryAction(int var1);

    public void connectivityDataOnlineAppEntered(int var1);

    public void connectivityDataOnlineCheckEntered(int var1);

    public void connectivityDataOnlineCheckLeft(int var1);

    public void connectivityDataOnlinePopupLeft(int var1);

    public void connectivityDataOnlinePopupEntered(int var1);

    public void connectivityDataOnlineSetupLeft(int var1);

    public void connectivityDataOnlineSetupPhone(int var1);

    public void connectivityDataOnlineSetupCoMa(int var1);

    public void connectivityDataOnlineSetupOnlineError(int var1);

    public void connectivityDataApplicationContext(int var1, int var2);

    public void connectivityCoMaEntered(int var1);

    public void connectivityCoMaApplicationContext(int var1, int var2);

    public void connectivityBluetoothBondingSpeedDisclaimerEntered(int var1);

    public void connectivityBluetoothInstanceEntered(int var1, int var2);

    public void connectivityWlanInstanceEntered(int var1, int var2);

    public void connectivityDataOnlineRequestEntered(int var1, int var2);

    public void connectivityCoMaInstanceEnteredSetApplicationId(int var1, int var2, int var3);

    public void connectivitySetApplicationId(int var1, int var2);

    public void connectivityOpenSelectionDrawerByHKReturn(int var1, int var2);

    public void btBondingEntryPoint(int var1, int var2);

    public void connectivityDataOnlineAppLeft(int var1);

    public void connectivityBlueAbortInquiry(int var1);

    public void connectivityDataInstanceEntered(int var1, int var2);

    public void connectivityBlueOfficeSetupExit(int var1);

    public void connectivityBlueApplicationContext(int var1, int var2);
}

