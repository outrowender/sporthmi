/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.utils.generics.Consumer;
import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.settings.AVNorm;
import de.audi.tv.app.settings.AspectRatioAV;
import de.audi.tv.app.settings.AspectRatioTV;
import de.audi.tv.app.settings.ChannelSorting;
import de.audi.tv.app.settings.DisplaySettings;
import de.audi.tv.app.settings.EwsSetting;
import de.audi.tv.app.settings.ISettingHandler;
import de.audi.tv.app.settings.ISettingListener;
import de.audi.tv.app.settings.ServiceLinking;
import de.audi.tv.app.settings.SettingsStorage;
import de.audi.tv.app.settings.Subtitle;
import de.audi.tv.app.settings.TVNormList;
import de.audi.tv.app.settings.TVSettings$1;
import de.audi.tv.app.settings.TVSettings$DSICallListenerExt;
import de.audi.tv.app.settings.TVSettings$EventListener;
import de.audi.tv.app.settings.TVSettings$SettingHandler;
import de.audi.tv.app.settings.TVSettings$TVListenerExt;
import de.audi.tv.app.settings.TVSettings$UpdateProvider;
import de.audi.tv.app.settings.VisualAudio;
import de.audi.tv.app.settings.audio.AudioChannels;
import de.audi.tv.app.settings.parental.IChildLockListener;
import de.audi.tv.app.settings.parental.ParentalLevelList;
import de.audi.tv.app.settings.parental.PasswordController;
import java.util.ArrayList;
import java.util.List;

public class TVSettings {
    public final DSICallListener dsiCallListener = new TVSettings$DSICallListenerExt(this, null);
    public final DefaultTVListener tvListener = new TVSettings$TVListenerExt(this, null);
    public final ISettingHandler settingHandler = new TVSettings$SettingHandler(this, null);
    public final ITVEventListener eventListener;
    private final TVEnv env;
    private final AudioChannels audioChannels;
    private final AspectRatioTV aspectRatioTV;
    private final AspectRatioAV aspectRatioAV;
    private final DisplaySettings tvAvDisplaySettings;
    private final ServiceLinking serviceLinking;
    private final Subtitle subtitle;
    private final VisualAudio visualAudio;
    private final EwsSetting ews;
    private final ChannelSorting channelSorting;
    private final TVNormList tvNorm;
    private final AVNorm avNorm;
    private final PasswordController parentalPassword;
    private final ParentalLevelList parentalLevel;
    private final List settingListeners = new ArrayList(1);
    private final TVSettings$UpdateProvider provider = new TVSettings$UpdateProvider(this, null);
    private final SettingsStorage storage;

    public TVSettings(TVEnv tVEnv, DSITV dSITV, IChildLockListener iChildLockListener) {
        this.env = tVEnv;
        this.storage = new SettingsStorage(tVEnv);
        this.audioChannels = new AudioChannels(tVEnv, dSITV);
        this.serviceLinking = new ServiceLinking(tVEnv, this.storage, dSITV);
        this.subtitle = new Subtitle(tVEnv, this.storage, dSITV);
        this.visualAudio = new VisualAudio(tVEnv, this.storage, this.provider);
        this.ews = new EwsSetting(tVEnv, this.storage, this.provider);
        this.channelSorting = new ChannelSorting(tVEnv, this.storage, dSITV, this.provider);
        this.tvNorm = new TVNormList(tVEnv, this.storage, dSITV);
        this.avNorm = new AVNorm(tVEnv, this.storage, dSITV);
        this.aspectRatioTV = new AspectRatioTV(tVEnv, this.storage, dSITV);
        this.aspectRatioAV = new AspectRatioAV(tVEnv, this.storage, dSITV);
        this.tvAvDisplaySettings = new DisplaySettings(tVEnv, dSITV, this.storage);
        this.eventListener = new TVSettings$EventListener(this, null);
        this.parentalPassword = new PasswordController(tVEnv, this.storage, this.provider);
        this.parentalLevel = new ParentalLevelList(tVEnv, this.storage, iChildLockListener);
        tVEnv.properties.dmComponent.currentDisplayableId.async(this.env.dispatch).subscribe((Consumer)new TVSettings$1(this));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addListener(ISettingListener iSettingListener) {
        List list = this.settingListeners;
        synchronized (list) {
            this.settingListeners.add(iSettingListener);
            iSettingListener.updateVisualAudio(this.provider.visualAudioUpdate);
            iSettingListener.updateEWS(this.provider.ewsUpdate);
            iSettingListener.updateStationListSorting(this.provider.stationListSorting);
        }
    }

    public SettingsStorage getStorage() {
        return this.storage;
    }

    public AspectRatioTV getAspectRatioTV() {
        return this.aspectRatioTV;
    }

    public void restoreSettings(int n) {
        this.env.lcMain.log(1078071040, "[TVSettings.restoreSettings] sourceType:%1", (long)n);
        this.tvAvDisplaySettings.setSelectedSource(n);
        switch (n) {
            case 0: {
                this.aspectRatioTV.setSelectedSource(n);
                this.aspectRatioTV.restore();
                this.tvAvDisplaySettings.enterSelectedTvAvMode();
                this.tvNorm.restore();
                break;
            }
            case 1: {
                this.aspectRatioAV.setSelectedSource(n);
                this.aspectRatioAV.restore();
                this.tvAvDisplaySettings.enterSelectedTvAvMode();
                this.avNorm.restore();
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid source ").append(n).toString());
            }
        }
        this.serviceLinking.restore();
        this.subtitle.restore();
        this.visualAudio.restore();
        this.channelSorting.restore();
        this.parentalLevel.restore();
        this.ews.restore();
    }

    public void resetToDefault(boolean bl, boolean bl2) {
        boolean bl3 = this.env.getConfiguration().hasAV();
        this.env.lcMain.log(1078071040, "[TVSettings.resetSettings] sys %1, pers %2", bl, bl2);
        if (bl) {
            if (bl3) {
                this.aspectRatioAV.resetToDefault();
            }
            this.aspectRatioTV.resetToDefault();
            this.serviceLinking.resetToDefault();
            this.subtitle.resetToDefault();
            this.visualAudio.resetToDefault();
            this.channelSorting.resetToDefault();
            this.ews.resetToDefault();
        }
        if (bl2) {
            if (bl3) {
                this.tvAvDisplaySettings.resetSettings(1);
                this.avNorm.resetToDefault();
                this.tvAvDisplaySettings.enterSelectedTvAvMode();
            }
            this.tvAvDisplaySettings.resetSettings(0);
            this.tvNorm.resetToDefault();
            this.audioChannels.resetToDefault();
        }
        this.tvAvDisplaySettings.enterSelectedTvAvMode();
    }

    public void deinit() {
        this.parentalPassword.deinit();
    }

    static /* synthetic */ DisplaySettings access$500(TVSettings tVSettings) {
        return tVSettings.tvAvDisplaySettings;
    }

    static /* synthetic */ AspectRatioTV access$600(TVSettings tVSettings) {
        return tVSettings.aspectRatioTV;
    }

    static /* synthetic */ AudioChannels access$700(TVSettings tVSettings) {
        return tVSettings.audioChannels;
    }

    static /* synthetic */ PasswordController access$800(TVSettings tVSettings) {
        return tVSettings.parentalPassword;
    }

    static /* synthetic */ AspectRatioAV access$900(TVSettings tVSettings) {
        return tVSettings.aspectRatioAV;
    }

    static /* synthetic */ ServiceLinking access$1000(TVSettings tVSettings) {
        return tVSettings.serviceLinking;
    }

    static /* synthetic */ Subtitle access$1100(TVSettings tVSettings) {
        return tVSettings.subtitle;
    }

    static /* synthetic */ ChannelSorting access$1200(TVSettings tVSettings) {
        return tVSettings.channelSorting;
    }

    static /* synthetic */ TVNormList access$1300(TVSettings tVSettings) {
        return tVSettings.tvNorm;
    }

    static /* synthetic */ ParentalLevelList access$1400(TVSettings tVSettings) {
        return tVSettings.parentalLevel;
    }

    static /* synthetic */ List access$1500(TVSettings tVSettings) {
        return tVSettings.settingListeners;
    }
}

