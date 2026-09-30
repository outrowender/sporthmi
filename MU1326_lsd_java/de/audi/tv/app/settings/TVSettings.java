/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.reactive.properties.Property;
import de.audi.atip.utils.reactive.properties.PropertyFactory;
import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDefaultListener;
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
import de.audi.tv.app.settings.VisualAudio;
import de.audi.tv.app.settings.audio.AudioChannels;
import de.audi.tv.app.settings.parental.IChildLockListener;
import de.audi.tv.app.settings.parental.ParentalLevelList;
import de.audi.tv.app.settings.parental.PasswordController;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class TVSettings {
    public final DSICallListener dsiCallListener = new DSICallListenerExt();
    public final DefaultTVListener tvListener = new TVListenerExt();
    public final ISettingHandler settingHandler = new SettingHandler();
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
    private final UpdateProvider provider = new UpdateProvider();
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
        this.eventListener = new EventListener();
        this.parentalPassword = new PasswordController(tVEnv, this.storage, this.provider);
        this.parentalLevel = new ParentalLevelList(tVEnv, this.storage, iChildLockListener);
        tVEnv.properties.dmComponent.currentDisplayableId.async(this.env.dispatch).subscribe(new Consumer<Integer>(){

            @Override
            public void accept(Integer n) {
                if (n == 26) {
                    TVSettings.this.tvAvDisplaySettings.enterSelectedTvAvMode();
                    TVSettings.this.aspectRatioTV.enterTVMode();
                } else {
                    TVSettings.this.tvAvDisplaySettings.enterTerminalMode();
                    TVSettings.this.aspectRatioTV.enterTerminalMode();
                }
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((Integer)object);
            }
        });
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
        this.env.lcMain.log(1000000, "[TVSettings.restoreSettings] sourceType:%1", (long)n);
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
        this.env.lcMain.log(1000000, "[TVSettings.resetSettings] sys %1, pers %2", bl, bl2);
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

    public static class Properties {
        public final Property<Boolean> visualAudioActive;

        public Properties(PropertyFactory propertyFactory) {
            this.visualAudioActive = propertyFactory.createProperty("TVSettings.visualAudioActive", new Boolean(true));
        }
    }

    private class EventListener
    extends TVEventDefaultListener {
        private volatile boolean isTvOnSdisActive = false;
        private volatile boolean isInStandby = true;

        private EventListener() {
        }

        public void onPowerStateStandby() {
            this.isInStandby = true;
            this.resetOnStandby();
        }

        public void onPowerStateOn() {
            this.isInStandby = false;
        }

        public void onDsiLockStateChanged(boolean bl) {
            TVSettings.this.tvNorm.dsiLockStateChanged(bl);
        }

        public void onSdisGotTvAudioFocus() {
            this.isTvOnSdisActive = true;
        }

        public void onSdisLostTvAudioFocus() {
            this.isTvOnSdisActive = false;
            this.resetOnStandby();
        }

        private void resetOnStandby() {
            if (!this.isTvOnSdisActive && this.isInStandby) {
                TVSettings.this.aspectRatioTV.onPowerStateStandby();
                TVSettings.this.tvAvDisplaySettings.onPowerStateStandby();
            }
        }
    }

    private class TVListenerExt
    extends DefaultTVListener {
        private TVListenerExt() {
        }

        public void updateSelectedService(ProgramInfo programInfo) {
            TVSettings.this.audioChannels.update(programInfo.availableAudioChannels);
            TVSettings.this.audioChannels.updateActiveAudioChannel(programInfo.selectedAudioChannel);
            TVSettings.this.aspectRatioTV.update(programInfo.videoFormat);
            TVSettings.this.parentalLevel.updateRequiredAge(programInfo.parentalRating);
        }

        public void updateServiceLinking(boolean bl) {
            TVSettings.this.serviceLinking.update(bl);
        }

        public void updateSubtitle(boolean bl) {
            TVSettings.this.subtitle.update(bl);
        }

        public void updateTVNormArea(int n) {
            TVSettings.this.tvNorm.updateTVNormArea(n);
        }

        public void updateTVNormList(int[] nArray) {
            TVSettings.this.tvNorm.updateTVNormList(nArray);
        }

        public void updateBrowserListSort(int n) {
            TVSettings.this.channelSorting.update(n);
        }
    }

    private class SettingHandler
    implements ISettingHandler {
        private SettingHandler() {
        }

        public void setAudioToggleButtonAvailability(boolean bl) {
            TVSettings.this.audioChannels.setAudioToggleButtonAvailability(bl);
        }

        public void resetPasswordConfirmation() {
            TVSettings.this.parentalPassword.resetPasswordConfirmation();
        }

        public void parentalRatingLeft() {
        }
    }

    private class UpdateProvider
    implements ISettingListener {
        boolean visualAudioUpdate;
        boolean ewsUpdate;
        int stationListSorting = -1;

        private UpdateProvider() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateVisualAudio(boolean bl) {
            List list = TVSettings.this.settingListeners;
            synchronized (list) {
                this.visualAudioUpdate = bl;
                for (int i2 = 0; i2 < TVSettings.this.settingListeners.size(); ++i2) {
                    ((ISettingListener)TVSettings.this.settingListeners.get(i2)).updateVisualAudio(bl);
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateEWS(boolean bl) {
            List list = TVSettings.this.settingListeners;
            synchronized (list) {
                this.ewsUpdate = bl;
                for (int i2 = 0; i2 < TVSettings.this.settingListeners.size(); ++i2) {
                    ((ISettingListener)TVSettings.this.settingListeners.get(i2)).updateEWS(bl);
                }
            }
        }

        public void passwordChanged() {
            for (int i2 = 0; i2 < TVSettings.this.settingListeners.size(); ++i2) {
                ((ISettingListener)TVSettings.this.settingListeners.get(i2)).passwordChanged();
            }
        }

        public void passwordNeedsToBeEnteredAgain() {
            for (int i2 = 0; i2 < TVSettings.this.settingListeners.size(); ++i2) {
                ((ISettingListener)TVSettings.this.settingListeners.get(i2)).passwordNeedsToBeEnteredAgain();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateStationListSorting(int n) {
            List list = TVSettings.this.settingListeners;
            synchronized (list) {
                if (n != this.stationListSorting) {
                    this.stationListSorting = n;
                    for (int i2 = 0; i2 < TVSettings.this.settingListeners.size(); ++i2) {
                        ((ISettingListener)TVSettings.this.settingListeners.get(i2)).updateStationListSorting(n);
                    }
                }
            }
        }
    }

    private class DSICallListenerExt
    extends DSICallListener {
        private DSICallListenerExt() {
        }

        public void switchSource(int n, boolean bl) {
            TVSettings.this.aspectRatioAV.setSelectedSource(n);
            TVSettings.this.aspectRatioTV.setSelectedSource(n);
            TVSettings.this.tvAvDisplaySettings.setSelectedSource(n);
        }

        public void enableServiceLinking(boolean bl) {
            TVSettings.this.serviceLinking.update(bl);
        }

        public void enableSubtitle(boolean bl) {
            TVSettings.this.subtitle.update(bl);
        }

        public void setBrowserListSort(int n) {
            TVSettings.this.channelSorting.update(n);
        }

        public void setNormArea(int n) {
            TVSettings.this.tvNorm.updateTVNormArea(n);
        }

        public void selectService(ServiceInfo serviceInfo, boolean bl) {
            ((TVSettings)TVSettings.this).parentalLevel.callListener.selectService(serviceInfo, bl);
        }

        public void selectNextService(int n) {
            ((TVSettings)TVSettings.this).parentalLevel.callListener.selectNextService(n);
        }
    }
}

