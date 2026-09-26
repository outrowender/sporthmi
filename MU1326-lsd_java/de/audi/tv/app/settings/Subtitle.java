/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.settings.SettingsStorage;
import de.audi.tv.app.settings.Subtitle$ChoiceListenerImpl;

class Subtitle {
    private static final int SUBTITLE_ENABLED;
    private static final int SUBTITLE_DISABLED;
    static final boolean DEFAULT;
    private TVEnv env;
    private SettingsStorage storage;
    private DSITV dsi;

    Subtitle(TVEnv tVEnv, SettingsStorage settingsStorage, DSITV dSITV) {
        this.env = tVEnv;
        this.storage = settingsStorage;
        this.dsi = dSITV;
        ChoiceModelApp choiceModelApp = tVEnv.getChoiceModel(1252796160);
        choiceModelApp.setChoiceListener(new Subtitle$ChoiceListenerImpl(this, null));
        choiceModelApp.setValue(0);
    }

    protected void restore() {
        this.dsi.enableSubtitle(this.storage.loadSubtitle());
    }

    protected void resetToDefault() {
        this.dsi.enableSubtitle(false);
    }

    void update(boolean bl) {
        int n = bl ? 1 : 0;
        this.env.lcHMI.log(-2137614336, "[Subtitle.updateSubtitle] %1 -> %2", bl, (long)n);
        this.env.getChoiceModel(1252796160).setValue(n);
        this.storage.saveSubtitle(bl);
    }

    static /* synthetic */ TVEnv access$100(Subtitle subtitle) {
        return subtitle.env;
    }

    static /* synthetic */ DSITV access$200(Subtitle subtitle) {
        return subtitle.dsi;
    }
}

