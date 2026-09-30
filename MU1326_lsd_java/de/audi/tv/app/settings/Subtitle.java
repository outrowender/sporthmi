/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.settings.SettingsStorage;

class Subtitle {
    private static final int SUBTITLE_ENABLED = 1;
    private static final int SUBTITLE_DISABLED = 0;
    static final boolean DEFAULT = false;
    private TVEnv env;
    private SettingsStorage storage;
    private DSITV dsi;

    Subtitle(TVEnv tVEnv, SettingsStorage settingsStorage, DSITV dSITV) {
        this.env = tVEnv;
        this.storage = settingsStorage;
        this.dsi = dSITV;
        ChoiceModelApp choiceModelApp = tVEnv.getChoiceModel(2600010);
        choiceModelApp.setChoiceListener(new ChoiceListenerImpl());
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
        this.env.lcHMI.log(10000000, "[Subtitle.updateSubtitle] %1 -> %2", bl, (long)n);
        this.env.getChoiceModel(2600010).setValue(n);
        this.storage.saveSubtitle(bl);
    }

    private class ChoiceListenerImpl
    extends DefaultChoiceListener {
        private ChoiceListenerImpl() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            boolean bl = n2 == 1;
            ((Subtitle)Subtitle.this).env.lcHMI.log(10000000, "[Subtitle.itemSelected] %2 -> %1", bl, (long)n2);
            Subtitle.this.dsi.enableSubtitle(bl);
        }
    }
}

