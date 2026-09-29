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
    private static final int CONTEXT_MMI;
    private static final int CONTEXT_RSE;
    private static final int CONTEXT_SYSTEM;
    private static final int CONTEXT_ETC;

    public SettingsEvoActionProxy(SettingsEnv settingsEnv) {
        if (settingsEnv == null) {
            throw new IllegalArgumentException("SettingsEvoActionProxy#Constructor() Environment must not be null");
        }
        this.env = settingsEnv;
    }

    public void abortProgress(int n) {
    }

    @Override
    public void enterLicenseBrowser(int n) {
        ILicenseBrowser iLicenseBrowser = this.env.getLicenseBrowser();
        iLicenseBrowser.browserEntered();
    }

    @Override
    public void enterMMISettings(int n) {
        this.env.getChoiceModel(-624357376).setValue(0);
    }

    @Override
    public void enterRSESettings(int n) {
        this.env.getChoiceModel(-624357376).setValue(1);
    }

    @Override
    public void enterSystemSettings(int n) {
        this.env.getChoiceModel(-624357376).setValue(2);
    }

    @Override
    public void enterETCSettings(int n) {
        ETCHandler eTCHandler;
        this.env.getChoiceModel(-624357376).setValue(4);
        if (this.env.isETCAvailable() && null != (eTCHandler = this.env.getEtcHandler())) {
            eTCHandler.enterETCSettings();
        }
    }

    @Override
    public void leaveSettings(int n) {
        this.env.getChoiceModel(298455040).setValue(0);
    }

    @Override
    public void enterInstructionBookUpdate(int n) {
        this.env.getChoiceModel(298455040).setValue(1);
    }

    @Override
    public void leaveFactoryReset(int n) {
        this.env.getFactoryResetHandler().deselectAll();
    }

    @Override
    public void enterETCDesktopHistory(int n) {
        ETCHandler eTCHandler;
        if (this.env.isETCAvailable() && null != (eTCHandler = this.env.getEtcHandler())) {
            eTCHandler.enterETCPaymentHistory();
        }
    }

    @Override
    public void leaveETCDesktopHistory(int n) {
        ETCHandler eTCHandler;
        if (this.env.isETCAvailable() && null != (eTCHandler = this.env.getEtcHandler())) {
            eTCHandler.leaveETCPaymentHistory();
        }
    }
}

