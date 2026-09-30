/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.settings.ISettingListener;
import de.audi.tv.app.settings.SettingsStorage;

public class EwsSetting {
    public static final boolean DEFAULT = true;
    private static final int EWS_ENABLED = 1;
    private static final int EWS_DISABLED = 0;
    private final TVEnv env;
    private final SettingsStorage storage;
    private final ISettingListener listener;
    private final ChoiceModelApp ewsChoice;

    EwsSetting(TVEnv tVEnv, SettingsStorage settingsStorage, ISettingListener iSettingListener) {
        this.env = tVEnv;
        this.storage = settingsStorage;
        this.listener = iSettingListener;
        this.ewsChoice = tVEnv.getChoiceModel(2600161);
        this.ewsChoice.setChoiceListener(new ChoiceListener());
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

    private class ChoiceListener
    extends DefaultChoiceListener {
        private ChoiceListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            boolean bl = n2 == 1;
            ((EwsSetting)EwsSetting.this).env.lcHMI.log(10000000, "[EwsSetting.itemSelected] %2 -> %1", bl, (long)n2);
            EwsSetting.this.update(bl);
        }
    }
}

