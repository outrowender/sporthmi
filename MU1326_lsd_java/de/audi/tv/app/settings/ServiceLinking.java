/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.settings.SettingsStorage;

class ServiceLinking {
    static final boolean DEFAULT = true;
    private static final int LINKING_ENABLED = 1;
    private static final int LINKING_DISABLED = 0;
    private TVEnv env;
    private SettingsStorage storage;
    private DSITV dsi;

    ServiceLinking(TVEnv tVEnv, SettingsStorage settingsStorage, DSITV dSITV) {
        this.env = tVEnv;
        this.storage = settingsStorage;
        this.dsi = dSITV;
        ChoiceModelApp choiceModelApp = tVEnv.getChoiceModel(2600009);
        choiceModelApp.setChoiceListener(new ChoiceListenerImpl());
        choiceModelApp.setValue(1);
    }

    protected void restore() {
        this.dsi.enableServiceLinking(this.storage.loadServiceLinking());
    }

    protected void resetToDefault() {
        this.dsi.enableServiceLinking(true);
    }

    void update(boolean bl) {
        int n = bl ? 1 : 0;
        this.env.lcHMI.log(10000000, "[ServiceLinking.updateServiceLinking] %1 -> %2", bl, (long)n);
        this.env.getChoiceModel(2600009).setValue(n);
        this.storage.saveServiceLinking(bl);
    }

    private class ChoiceListenerImpl
    extends DefaultChoiceListener {
        private ChoiceListenerImpl() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            boolean bl = n2 == 1;
            ((ServiceLinking)ServiceLinking.this).env.lcHMI.log(10000000, "[ServiceLinking.itemSelected] %2 -> %1", bl, (long)n2);
            ServiceLinking.this.dsi.enableServiceLinking(bl);
        }
    }
}

