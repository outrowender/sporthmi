/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.settings.EwsSetting$ChoiceListener;
import de.audi.tv.app.settings.ISettingListener;
import de.audi.tv.app.settings.SettingsStorage;

public class EwsSetting {
    public static final boolean DEFAULT;
    private static final int EWS_ENABLED;
    private static final int EWS_DISABLED;
    private final TVEnv env;
    private final SettingsStorage storage;
    private final ISettingListener listener;
    private final ChoiceModelApp ewsChoice;

    EwsSetting(TVEnv tVEnv, SettingsStorage settingsStorage, ISettingListener iSettingListener) {
        this.env = tVEnv;
        this.storage = settingsStorage;
        this.listener = iSettingListener;
        this.ewsChoice = tVEnv.getChoiceModel(-508811520);
        this.ewsChoice.setChoiceListener(new EwsSetting$ChoiceListener(this, null));
        this.ewsChoice.setValue(1);
        iSettingListener.updateEWS(true);
    }

    void resetToDefault() {
        this.update(true);
    }

    void restore() {
        boolean bl = this.storage.loadEWS();
        int n = bl ? 1 : 0;
        this.ewsChoice.setValue(n);
        this.listener.updateEWS(bl);
    }

    private void update(boolean bl) {
        int n = bl ? 1 : 0;
        this.ewsChoice.setValue(n);
        this.listener.updateEWS(bl);
        this.storage.saveEWS(bl);
    }

    static /* synthetic */ TVEnv access$100(EwsSetting ewsSetting) {
        return ewsSetting.env;
    }

    static /* synthetic */ void access$200(EwsSetting ewsSetting, boolean bl) {
        ewsSetting.update(bl);
    }
}

