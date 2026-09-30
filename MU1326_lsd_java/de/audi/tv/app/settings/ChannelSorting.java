/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.settings.ISettingListener;
import de.audi.tv.app.settings.SettingsStorage;

class ChannelSorting {
    static final int DEFAULT = 0;
    private final TVEnv env;
    private final SettingsStorage storage;
    private final DSITV dsi;
    private final ISettingListener provider;

    ChannelSorting(TVEnv tVEnv, SettingsStorage settingsStorage, DSITV dSITV, ISettingListener iSettingListener) {
        this.env = tVEnv;
        this.storage = settingsStorage;
        this.dsi = dSITV;
        this.provider = iSettingListener;
        ChoiceModelApp choiceModelApp = tVEnv.getChoiceModel(2600008);
        choiceModelApp.setChoiceListener(new ChoiceListenerImpl());
        choiceModelApp.setValue(0);
    }

    protected void restore() {
        this.provider.updateStationListSorting(this.storage.loadChannelSorting());
        this.dsi.setBrowserListSort(this.storage.loadChannelSorting());
    }

    protected void resetToDefault() {
        this.provider.updateStationListSorting(0);
        this.dsi.setBrowserListSort(0);
    }

    void update(int n) {
        this.env.lcHMI.log(10000000, "[ChannelSorting.updateChannelSorting] %1", (long)n);
        this.env.getChoiceModel(2600008).setValue(n);
        this.provider.updateStationListSorting(n);
        this.storage.saveChannelSorting(n);
    }

    private class ChoiceListenerImpl
    extends DefaultChoiceListener {
        private ChoiceListenerImpl() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            ((ChannelSorting)ChannelSorting.this).env.lcHMI.log(10000000, "[ChannelSorting.itemSelected] %1", (long)n2);
            ChannelSorting.this.provider.updateStationListSorting(n2);
            ChannelSorting.this.dsi.setBrowserListSort(n2);
        }
    }
}

