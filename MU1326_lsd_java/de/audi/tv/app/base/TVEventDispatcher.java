/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.log.LogChannel;
import de.audi.atip.power.PowerEventListener;
import de.audi.atip.sysapp.SpeedThresholdListener;
import de.audi.atip.utils.reactive.properties.Property;
import de.audi.atip.utils.reactive.properties.PropertyFactory;
import de.audi.atip.utils.reactive.properties.ReadOnlyProperty;
import de.audi.tv.app.IEWSListener;
import de.audi.tv.app.audio.IAudioListener;
import de.audi.tv.app.base.DefaultMessageListener;
import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.ITunerStatusListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.lists.IListFocusListener;
import de.audi.tv.app.settings.parental.IChildLockListener;
import java.util.ArrayList;
import org.dsi.ifc.tvtuner.ProgramInfo;

public class TVEventDispatcher {
    public final PowerEventListener powerEventDispatcher = new PowerEventDispatcher();
    public final SpeedThresholdListener speedThresholdListener = new SpeedThresholdListenerImpl();
    public final DefaultMessageListener messageListener = new DvdStateListener();
    private final ArrayList listeners;
    final IAudioListener audioListener = new AudioListener();
    final IChildLockListener childLockListener = new ChildLockListener();
    final ITunerStatusListener tunerStatusListener = new TunerStatusListener();
    final IListFocusListener listFocusListener = new ListFocusListener();
    final IEWSListener ewsListener = new EWSListener();
    private final LogChannel log;
    private final Properties myProperties;

    public TVEventDispatcher(TVEnv tVEnv, LogChannel logChannel, int n) {
        this.log = logChannel;
        this.listeners = new ArrayList(n);
        this.myProperties = tVEnv.properties.eventDispatcher;
    }

    void addListener(ITVEventListener iTVEventListener) {
        this.listeners.add(iTVEventListener);
    }

    void makeFactoryReset() {
        this.log.log(10000000, "[TVEventDispatcher.makeFactoryReset]");
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ITVEventListener iTVEventListener = (ITVEventListener)this.listeners.get(i2);
            iTVEventListener.makeFactoryReset();
        }
    }

    void updateAppActivated(int n) {
        this.log.log(10000000, "[TVEventDispatcher.updateAppActivated] sourceType: %1", (long)n);
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ITVEventListener iTVEventListener = (ITVEventListener)this.listeners.get(i2);
            iTVEventListener.onAppActivated(n);
        }
    }

    void updateAppDeactivated(int n) {
        this.log.log(10000000, "[TVEventDispatcher.updateAppDeactivated] sourceType: %1", (long)n);
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ITVEventListener iTVEventListener = (ITVEventListener)this.listeners.get(i2);
            iTVEventListener.onAppDeactivated(n);
        }
    }

    public void updateDSILocked() {
        this.log.log(10000000, "[TVEventDispatcher.updateDSILocked]");
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ITVEventListener iTVEventListener = (ITVEventListener)this.listeners.get(i2);
            iTVEventListener.onDSILocked();
        }
    }

    public void updateDSIUnlocked() {
        this.log.log(10000000, "[TVEventDispatcher.updateDSIUnlocked]");
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ITVEventListener iTVEventListener = (ITVEventListener)this.listeners.get(i2);
            iTVEventListener.onDSIUnlocked();
        }
    }

    public void updateSelectedServiceDebounced(ProgramInfo programInfo) {
        this.log.log(10000000, "[TVEventDispatcher.updateSelectedServiceDebounced] program: %1", (Object)programInfo);
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ITVEventListener iTVEventListener = (ITVEventListener)this.listeners.get(i2);
            iTVEventListener.onSelectedServiceDebounced(programInfo);
        }
    }

    void enteredFullscreen(int n) {
        this.log.log(10000000, "[TVEventDispatcher.enteredFullscreen]");
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ITVEventListener iTVEventListener = (ITVEventListener)this.listeners.get(i2);
            iTVEventListener.onFullscreenEntered(n);
        }
    }

    void leftFullscreen(int n) {
        this.log.log(10000000, "[TVEventDispatcher.leftFullscreen]");
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ITVEventListener iTVEventListener = (ITVEventListener)this.listeners.get(i2);
            iTVEventListener.onFullscreenLeft(n);
        }
    }

    public void updateTerminalModeInputMode(int n) {
        this.log.log(10000000, "[TVEventDispatcher.updateTerminalModeInputMode] %1", (long)n);
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ((ITVEventListener)this.listeners.get(i2)).onTerminalModeInputModeChange(n);
        }
    }

    private void updateEWSVisibility(boolean bl) {
        this.log.log(10000000, "[TVEventDispatcher.updateEWSVisibility] %1", bl);
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ((ITVEventListener)this.listeners.get(i2)).onEWSInfoVisibilityChange(bl);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class Properties {
        public final ReadOnlyProperty<Boolean> powerstateOn;
        public final ReadOnlyProperty<Boolean> tunerEsmReady;
        public final ReadOnlyProperty<Boolean> mostUnused;
        public final ReadOnlyProperty<Boolean> clamp15Activated;
        public final ReadOnlyProperty<Boolean> vehicleMoving;

        public Properties(PropertyFactory propertyFactory) {
            this.powerstateOn = propertyFactory.createProperty("TVEventDispatcher.powerstateOn", new Boolean(false));
            this.tunerEsmReady = propertyFactory.createProperty("TVEventDispatcher.tunerEsmReady", new Boolean(true));
            this.mostUnused = propertyFactory.createProperty("TVEventDispatcher.mostUnused", new Boolean(true));
            this.clamp15Activated = propertyFactory.createProperty("TVEventDispatcher.clamp15Activated", new Boolean(false));
            this.vehicleMoving = propertyFactory.createProperty("TVSpeedDisclaimer.vehicleMoving", new Boolean(false));
        }

        private Property<Boolean> writeablePowerstateOn() {
            return (Property)this.powerstateOn;
        }

        private Property<Boolean> writeableTunerEsmReady() {
            return (Property)this.tunerEsmReady;
        }

        private Property<Boolean> writeableMostUnused() {
            return (Property)this.mostUnused;
        }

        private Property<Boolean> writeableClamp15Activated() {
            return (Property)this.clamp15Activated;
        }

        private Property<Boolean> writeableVehicleMoving() {
            return (Property)this.vehicleMoving;
        }
    }

    private class EWSListener
    implements IEWSListener {
        private EWSListener() {
        }

        public void onEWSInfosActivated() {
            TVEventDispatcher.this.updateEWSVisibility(true);
        }

        public void onEWSInfosDeactivated() {
            TVEventDispatcher.this.updateEWSVisibility(false);
        }
    }

    private class AudioListener
    implements IAudioListener {
        private AudioListener() {
        }

        public void onMuGotTvAudioFocus(boolean bl) {
            TVEventDispatcher.this.log.log(10000000, "[TVEventDispatcher.onMuGotTvAudioFocus]");
            for (int i2 = 0; i2 < TVEventDispatcher.this.listeners.size(); ++i2) {
                ((ITVEventListener)TVEventDispatcher.this.listeners.get(i2)).onMuGotTvAudioFocus();
            }
        }

        public void onMuLostTvAudioFocus() {
            TVEventDispatcher.this.log.log(10000000, "[TVEventDispatcher.onMuLostTvAudioFocus]");
            for (int i2 = 0; i2 < TVEventDispatcher.this.listeners.size(); ++i2) {
                ((ITVEventListener)TVEventDispatcher.this.listeners.get(i2)).onMuLostTvAudioFocus();
            }
        }

        public void onSdisGotTvAudioFocus() {
            TVEventDispatcher.this.log.log(10000000, "[TVEventDispatcher.onSdisGotTvAudioFocus]");
            for (int i2 = 0; i2 < TVEventDispatcher.this.listeners.size(); ++i2) {
                ((ITVEventListener)TVEventDispatcher.this.listeners.get(i2)).onSdisGotTvAudioFocus();
            }
        }

        public void onSdisLostTvAudioFocus() {
            TVEventDispatcher.this.log.log(10000000, "[TVEventDispatcher.onSdisLostTvAudioFocus]");
            for (int i2 = 0; i2 < TVEventDispatcher.this.listeners.size(); ++i2) {
                ((ITVEventListener)TVEventDispatcher.this.listeners.get(i2)).onSdisLostTvAudioFocus();
            }
        }

        public void onMuteChange(boolean bl) {
            TVEventDispatcher.this.log.log(10000000, "[TVEventDispatcher.onMuteChange] muted: %1", bl);
            for (int i2 = 0; i2 < TVEventDispatcher.this.listeners.size(); ++i2) {
                ((ITVEventListener)TVEventDispatcher.this.listeners.get(i2)).onMuteChange(bl);
            }
        }
    }

    private class DvdStateListener
    extends DefaultMessageListener {
        private DvdStateListener() {
        }

        public void sourceDvdActivated() {
            TVEventDispatcher.this.myProperties.writeableMostUnused().accept(new Boolean(false));
        }

        public void sourceMediaDeactivated() {
            TVEventDispatcher.this.myProperties.writeableMostUnused().accept(new Boolean(true));
        }
    }

    private class ChildLockListener
    implements IChildLockListener {
        private ChildLockListener() {
        }

        public void onChildLockEnabled() {
            TVEventDispatcher.this.log.log(10000000, "[TVEventDispatcher.onChildLockEnabled]");
            for (int i2 = 0; i2 < TVEventDispatcher.this.listeners.size(); ++i2) {
                ((ITVEventListener)TVEventDispatcher.this.listeners.get(i2)).onChildLockEnabled();
            }
        }

        public void onChildLockDisabled() {
            TVEventDispatcher.this.log.log(10000000, "[TVEventDispatcher.onChildLockDisabled]");
            for (int i2 = 0; i2 < TVEventDispatcher.this.listeners.size(); ++i2) {
                ((ITVEventListener)TVEventDispatcher.this.listeners.get(i2)).onChildLockDisabled();
            }
        }

        public void parentalLevelSettingChanged(int n) {
            TVEventDispatcher.this.log.log(10000000, "[TVEventDispatcher.parentalLevelSettingChanged]");
            for (int i2 = 0; i2 < TVEventDispatcher.this.listeners.size(); ++i2) {
                ((ITVEventListener)TVEventDispatcher.this.listeners.get(i2)).parentalLevelSettingChanged(n);
            }
        }
    }

    private class ListFocusListener
    implements IListFocusListener {
        private ListFocusListener() {
        }

        public void onFocusedListChanged(int n) {
            TVEventDispatcher.this.log.log(10000000, "[TVEventDispatcher.onFocusedListChanged] %1", (long)n);
            for (int i2 = 0; i2 < TVEventDispatcher.this.listeners.size(); ++i2) {
                ((ITVEventListener)TVEventDispatcher.this.listeners.get(i2)).onFocusedListChanged(n);
            }
        }
    }

    private class TunerStatusListener
    implements ITunerStatusListener {
        private TunerStatusListener() {
        }

        public void onTunerAvailable() {
            TVEventDispatcher.this.log.log(10000000, "[TVEventDispatcher.onTunerAvailable]");
            for (int i2 = 0; i2 < TVEventDispatcher.this.listeners.size(); ++i2) {
                ((ITVEventListener)TVEventDispatcher.this.listeners.get(i2)).onTunerAvailable();
            }
        }

        public void onTunerUnavailable() {
            TVEventDispatcher.this.log.log(10000000, "[TVEventDispatcher.onTunerUnavailable]");
            TVEventDispatcher.this.myProperties.writeableTunerEsmReady().accept(new Boolean(true));
            for (int i2 = 0; i2 < TVEventDispatcher.this.listeners.size(); ++i2) {
                ((ITVEventListener)TVEventDispatcher.this.listeners.get(i2)).onTunerUnavailable();
            }
        }

        public void onEsmEntered() {
            TVEventDispatcher.this.log.log(10000000, "[TVEventDispatcher.onEsmEntered]");
            TVEventDispatcher.this.myProperties.writeableTunerEsmReady().accept(new Boolean(true));
            for (int i2 = 0; i2 < TVEventDispatcher.this.listeners.size(); ++i2) {
                ((ITVEventListener)TVEventDispatcher.this.listeners.get(i2)).onEsmEntered();
            }
        }

        public void onEsmLeft() {
            TVEventDispatcher.this.log.log(10000000, "[TVEventDispatcher.onEsmLeft]");
            TVEventDispatcher.this.myProperties.writeableTunerEsmReady().accept(new Boolean(false));
            for (int i2 = 0; i2 < TVEventDispatcher.this.listeners.size(); ++i2) {
                ((ITVEventListener)TVEventDispatcher.this.listeners.get(i2)).onEsmLeft();
            }
        }

        public void onDsiLockStateChanged(boolean bl) {
            TVEventDispatcher.this.log.log(10000000, "[TVEventDispatcher.dsiLockStateChanged] is DSI locked: %1", bl);
            for (int i2 = 0; i2 < TVEventDispatcher.this.listeners.size(); ++i2) {
                ((ITVEventListener)TVEventDispatcher.this.listeners.get(i2)).onDsiLockStateChanged(bl);
            }
        }

        public void onHighTemperatureShutdown() {
            TVEventDispatcher.this.log.log(10000000, "[TVEventDispatcher.onHighTemperatureShutdown]");
            for (int i2 = 0; i2 < TVEventDispatcher.this.listeners.size(); ++i2) {
                ((ITVEventListener)TVEventDispatcher.this.listeners.get(i2)).onHighTemperatureShutdown();
            }
        }
    }

    private class PowerEventDispatcher
    implements PowerEventListener {
        private PowerEventDispatcher() {
        }

        public void notifyPowerListenerOnEnterState(int n, int n2) {
            TVEventDispatcher.this.log.log(10000000, "[TVEventDispatcher.notifyPowerListenerOnEnterState]");
        }

        public void notifyPowerListenerOnExitState(int n, int n2) {
            TVEventDispatcher.this.log.log(10000000, "[TVEventDispatcher.notifyPowerListenerOnExitState]");
        }

        public void notifyPowerTriggerAction(int n, int n2) {
            TVEventDispatcher.this.log.log(10000000, "[TVEventDispatcher.notifyPowerTriggerAction] trigger: %1", (long)n);
            if (n2 != 0) {
                return;
            }
            switch (n) {
                case 2: {
                    for (int i2 = 0; i2 < TVEventDispatcher.this.listeners.size(); ++i2) {
                        TVEventDispatcher.this.myProperties.writeablePowerstateOn().accept(new Boolean(false));
                        ITVEventListener iTVEventListener = (ITVEventListener)TVEventDispatcher.this.listeners.get(i2);
                        iTVEventListener.onPowerStateStandby();
                    }
                    break;
                }
                case 1: {
                    for (int i3 = 0; i3 < TVEventDispatcher.this.listeners.size(); ++i3) {
                        TVEventDispatcher.this.myProperties.writeablePowerstateOn().accept(new Boolean(true));
                        ITVEventListener iTVEventListener = (ITVEventListener)TVEventDispatcher.this.listeners.get(i3);
                        iTVEventListener.onPowerStateOn();
                    }
                    break;
                }
            }
        }

        public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
            TVEventDispatcher.this.log.log(10000000, "[TVEventDispatcher.updateClampState] clampS %1, clamp15 %2", bl, bl2);
            TVEventDispatcher.this.myProperties.writeableClamp15Activated().accept(new Boolean(bl2));
        }
    }

    private class SpeedThresholdListenerImpl
    implements SpeedThresholdListener {
        private SpeedThresholdListenerImpl() {
        }

        public void exceedsUpperThreshold(int n) {
            TVEventDispatcher.this.log.log(10000000, "[TVEventDispatcher.exceedsUpperThreshold]");
            TVEventDispatcher.this.myProperties.writeableVehicleMoving().accept(new Boolean(true));
        }

        public void belowLowerThreshold(int n) {
            TVEventDispatcher.this.log.log(10000000, "[TVEventDispatcher.belowLowerThreshold]");
            TVEventDispatcher.this.myProperties.writeableVehicleMoving().accept(new Boolean(false));
        }
    }
}

