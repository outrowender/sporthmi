/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface SettingsActionProxy
extends ActionProxy {
    public void enterETCDesktopHistory(int var1);

    public void leaveETCDesktopHistory(int var1);

    public void enterLicenseBrowser(int var1);

    public void enterMMISettings(int var1);

    public void enterSystemSettings(int var1);

    public void enterRSESettings(int var1);

    public void enterETCSettings(int var1);

    public void leaveSettings(int var1);

    public void enterInstructionBookUpdate(int var1);

    public void leaveFactoryReset(int var1);
}

