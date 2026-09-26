/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.base;

public interface IAppSystem {
    default public void fireInitialEvent() {
    }

    default public void fireHKReturn(int n) {
    }

    default public void fireHKSelection(int n) {
    }

    default public void fireJoystickLeft(int n) {
    }

    default public void jumpToCustomerDownload(int n) {
    }

    default public void cancelCustomerDownload(int n) {
    }

    default public boolean isEventContextSensitive(int n) {
    }

    default public boolean isEventSubterminalSensitive(int n) {
    }

    default public void showNoPowerPopups(int n) {
    }

    default public void showBlackScreenLEDsOn(int n) {
    }

    default public void showBlackScreenLEDsOff(int n) {
    }

    default public void showQ21Warning(int n) {
    }

    default public void removeQ21Warning(int n) {
    }

    default public void showCritcalTemperature(int n) {
    }

    default public void removeCritcalTemperature(int n) {
    }

    default public void showTelMaxWarning(int n) {
    }

    default public void removeTelMaxWarning(int n) {
    }

    default public void showStandbyWarning(int n) {
    }

    default public void removeStandbyWarning(int n) {
    }

    default public void showLegalDisclaimer(int n) {
    }

    default public void removeLegalDisclaimer(int n) {
    }

    default public void switch2Tuner() {
    }

    default public void switch2Media() {
    }

    default public void showSdsStatusPopup(int n) {
    }

    default public void showDiagPopup(int n) {
    }

    default public void removeDiagPopup(int n) {
    }

    default public void showEngineOffPopup(int n) {
    }

    default public void removeEngineOffPopup(int n) {
    }
}

