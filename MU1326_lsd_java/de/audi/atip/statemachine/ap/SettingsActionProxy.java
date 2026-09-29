/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface SettingsActionProxy
extends ActionProxy {
    default public void enterETCDesktopHistory(int n) {
    }

    default public void leaveETCDesktopHistory(int n) {
    }

    default public void enterLicenseBrowser(int n) {
    }

    default public void enterMMISettings(int n) {
    }

    default public void enterSystemSettings(int n) {
    }

    default public void enterRSESettings(int n) {
    }

    default public void enterETCSettings(int n) {
    }

    default public void leaveSettings(int n) {
    }

    default public void enterInstructionBookUpdate(int n) {
    }

    default public void leaveFactoryReset(int n) {
    }
}

