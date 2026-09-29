/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.settings.ServiceLinking$ChoiceListenerImpl;
import de.audi.tv.app.settings.SettingsStorage;

class ServiceLinking {
    static final boolean DEFAULT;
    private static final int LINKING_ENABLED;
    private static final int LINKING_DISABLED;
    private TVEnv env;
    private SettingsStorage storage;
    private DSITV dsi;

    ServiceLinking(TVEnv tVEnv, SettingsStorage settingsStorage, DSITV dSITV) {
        this.env = tVEnv;
        this.storage = settingsStorage;
        this.dsi = dSITV;
        ChoiceModelApp choiceModelApp = tVEnv.getChoiceModel(1236018944);
        choiceModelApp.setChoiceListener(new ServiceLinking$ChoiceListenerImpl(this, null));
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
        this.env.lcHMI.log(-2137614336, "[ServiceLinking.updateServiceLinking] %1 -> %2", bl, (long)n);
        this.env.getChoiceModel(1236018944).setValue(n);
        this.storage.saveServiceLinking(bl);
    }

    static /* synthetic */ TVEnv access$100(ServiceLinking serviceLinking) {
        return serviceLinking.env;
    }

    static /* synthetic */ DSITV access$200(ServiceLinking serviceLinking) {
        return serviceLinking.dsi;
    }
}

