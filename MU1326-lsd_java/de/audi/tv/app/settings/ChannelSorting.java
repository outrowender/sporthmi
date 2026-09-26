/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.settings.ChannelSorting$ChoiceListenerImpl;
import de.audi.tv.app.settings.ISettingListener;
import de.audi.tv.app.settings.SettingsStorage;

class ChannelSorting {
    static final int DEFAULT;
    private final TVEnv env;
    private final SettingsStorage storage;
    private final DSITV dsi;
    private final ISettingListener provider;

    ChannelSorting(TVEnv tVEnv, SettingsStorage settingsStorage, DSITV dSITV, ISettingListener iSettingListener) {
        this.env = tVEnv;
        this.storage = settingsStorage;
        this.dsi = dSITV;
        this.provider = iSettingListener;
        ChoiceModelApp choiceModelApp = tVEnv.getChoiceModel(1219241728);
        choiceModelApp.setChoiceListener(new ChannelSorting$ChoiceListenerImpl(this, null));
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
        this.env.lcHMI.log(-2137614336, "[ChannelSorting.updateChannelSorting] %1", (long)n);
        this.env.getChoiceModel(1219241728).setValue(n);
        this.provider.updateStationListSorting(n);
        this.storage.saveChannelSorting(n);
    }

    static /* synthetic */ TVEnv access$100(ChannelSorting channelSorting) {
        return channelSorting.env;
    }

    static /* synthetic */ ISettingListener access$200(ChannelSorting channelSorting) {
        return channelSorting.provider;
    }

    static /* synthetic */ DSITV access$300(ChannelSorting channelSorting) {
        return channelSorting.dsi;
    }
}

