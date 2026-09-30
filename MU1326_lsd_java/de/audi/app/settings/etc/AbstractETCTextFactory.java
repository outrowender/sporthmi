/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.etc;

import de.audi.app.settings.SettingsEnv;

public abstract class AbstractETCTextFactory {
    protected SettingsEnv env;

    public SettingsEnv getSettingsEnvironment() {
        return this.env;
    }

    public void setSettingsEnvironment(SettingsEnv settingsEnv) {
        this.env = settingsEnv;
    }

    protected String getI18nText(int n) {
        return this.getSettingsEnvironment().getFw().getHmiServiceApp().getText(n);
    }

    public abstract String getYenSymbol();

    public abstract String getErrorMessageText(int var1);

    public abstract String getWarningMessageCardInsertedText(boolean var1);

    public abstract String getTollInfoText(boolean var1, boolean var2);
}

