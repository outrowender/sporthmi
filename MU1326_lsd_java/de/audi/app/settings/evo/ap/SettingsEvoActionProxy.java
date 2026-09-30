/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.evo.ap;

import de.audi.app.settings.SettingsEnv;
import de.audi.app.settings.etc.ETCHandler;
import de.audi.app.settings.licensebrowser.ILicenseBrowser;
import de.audi.atip.statemachine.ap.SettingsActionProxy;

public final class SettingsEvoActionProxy
implements SettingsActionProxy {
    private final SettingsEnv env;
    private static final int CONTEXT_MMI = 0;
    private static final int CONTEXT_RSE = 1;
    private static final int CONTEXT_SYSTEM = 2;
    private static final int CONTEXT_ETC = 4;

    public SettingsEvoActionProxy(SettingsEnv settingsEnv) {
        if (settingsEnv == null) {
            throw new IllegalArgumentException("SettingsEvoActionProxy#Constructor() Environment must not be null");
        }
        this.env = settingsEnv;
    }

    public void abortProgress(int n) {
    }

    public void enterLicenseBrowser(int n) {
        ILicenseBrowser iLicenseBrowser = this.env.getLicenseBrowser();
        iLicenseBrowser.browserEntered();
    }

    public void enterMMISettings(int n) {
        this.env.getChoiceModel(1100250).setValue(0);
    }

    public void enterRSESettings(int n) {
        this.env.getChoiceModel(1100250).setValue(1);
    }

    public void enterSystemSettings(int n) {
        this.env.getChoiceModel(1100250).setValue(2);
    }

    public void enterETCSettings(int n) {
        ETCHandler eTCHandler;
        this.env.getChoiceModel(1100250).setValue(4);
        if (this.env.isETCAvailable() && null != (eTCHandler = this.env.getEtcHandler())) {
            eTCHandler.enterETCSettings();
        }
    }

    public void leaveSettings(int n) {
        this.env.getChoiceModel(1100305).setValue(0);
    }

    public void enterInstructionBookUpdate(int n) {
        this.env.getChoiceModel(1100305).setValue(1);
    }

    public void leaveFactoryReset(int n) {
        this.env.getFactoryResetHandler().deselectAll();
    }

    public void enterETCDesktopHistory(int n) {
        ETCHandler eTCHandler;
        if (this.env.isETCAvailable() && null != (eTCHandler = this.env.getEtcHandler())) {
            eTCHandler.enterETCPaymentHistory();
        }
    }

    public void leaveETCDesktopHistory(int n) {
        ETCHandler eTCHandler;
        if (this.env.isETCAvailable() && null != (eTCHandler = this.env.getEtcHandler())) {
            eTCHandler.leaveETCPaymentHistory();
        }
    }
}

