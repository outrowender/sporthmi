/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.base;

public interface IAppSystem {
    public void fireInitialEvent();

    public void fireHKReturn(int var1);

    public void fireHKSelection(int var1);

    public void fireJoystickLeft(int var1);

    public void jumpToCustomerDownload(int var1);

    public void cancelCustomerDownload(int var1);

    public boolean isEventContextSensitive(int var1);

    public boolean isEventSubterminalSensitive(int var1);

    public void showNoPowerPopups(int var1);

    public void showBlackScreenLEDsOn(int var1);

    public void showBlackScreenLEDsOff(int var1);

    public void showQ21Warning(int var1);

    public void removeQ21Warning(int var1);

    public void showCritcalTemperature(int var1);

    public void removeCritcalTemperature(int var1);

    public void showTelMaxWarning(int var1);

    public void removeTelMaxWarning(int var1);

    public void showStandbyWarning(int var1);

    public void removeStandbyWarning(int var1);

    public void showLegalDisclaimer(int var1);

    public void removeLegalDisclaimer(int var1);

    public void switch2Tuner();

    public void switch2Media();

    public void showSdsStatusPopup(int var1);

    public void showDiagPopup(int var1);

    public void removeDiagPopup(int var1);

    public void showEngineOffPopup(int var1);

    public void removeEngineOffPopup(int var1);
}

