/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.tv.app.base.TVEventDispatcher$Properties
 */
package de.audi.tv.app.base;

import de.audi.atip.log.LogChannel;
import de.audi.atip.power.PowerEventListener;
import de.audi.atip.sysapp.SpeedThresholdListener;
import de.audi.tv.app.IEWSListener;
import de.audi.tv.app.audio.IAudioListener;
import de.audi.tv.app.base.DefaultMessageListener;
import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.ITunerStatusListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDispatcher;
import de.audi.tv.app.base.TVEventDispatcher$AudioListener;
import de.audi.tv.app.base.TVEventDispatcher$ChildLockListener;
import de.audi.tv.app.base.TVEventDispatcher$DvdStateListener;
import de.audi.tv.app.base.TVEventDispatcher$EWSListener;
import de.audi.tv.app.base.TVEventDispatcher$ListFocusListener;
import de.audi.tv.app.base.TVEventDispatcher$PowerEventDispatcher;
import de.audi.tv.app.base.TVEventDispatcher$SpeedThresholdListenerImpl;
import de.audi.tv.app.base.TVEventDispatcher$TunerStatusListener;
import de.audi.tv.app.lists.IListFocusListener;
import de.audi.tv.app.settings.parental.IChildLockListener;
import java.util.ArrayList;
import org.dsi.ifc.tvtuner.ProgramInfo;

public class TVEventDispatcher {
    public final PowerEventListener powerEventDispatcher = new TVEventDispatcher$PowerEventDispatcher(this, null);
    public final SpeedThresholdListener speedThresholdListener = new TVEventDispatcher$SpeedThresholdListenerImpl(this, null);
    public final DefaultMessageListener messageListener = new TVEventDispatcher$DvdStateListener(this, null);
    private final ArrayList listeners;
    final IAudioListener audioListener = new TVEventDispatcher$AudioListener(this, null);
    final IChildLockListener childLockListener = new TVEventDispatcher$ChildLockListener(this, null);
    final ITunerStatusListener tunerStatusListener = new TVEventDispatcher$TunerStatusListener(this, null);
    final IListFocusListener listFocusListener = new TVEventDispatcher$ListFocusListener(this, null);
    final IEWSListener ewsListener = new TVEventDispatcher$EWSListener(this, null);
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
        this.log.log(-2137614336, "[TVEventDispatcher.makeFactoryReset]");
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ITVEventListener iTVEventListener = (ITVEventListener)this.listeners.get(i2);
            iTVEventListener.makeFactoryReset();
        }
    }

    void updateAppActivated(int n) {
        this.log.log(-2137614336, "[TVEventDispatcher.updateAppActivated] sourceType: %1", (long)n);
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ITVEventListener iTVEventListener = (ITVEventListener)this.listeners.get(i2);
            iTVEventListener.onAppActivated(n);
        }
    }

    void updateAppDeactivated(int n) {
        this.log.log(-2137614336, "[TVEventDispatcher.updateAppDeactivated] sourceType: %1", (long)n);
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ITVEventListener iTVEventListener = (ITVEventListener)this.listeners.get(i2);
            iTVEventListener.onAppDeactivated(n);
        }
    }

    public void updateDSILocked() {
        this.log.log(-2137614336, "[TVEventDispatcher.updateDSILocked]");
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ITVEventListener iTVEventListener = (ITVEventListener)this.listeners.get(i2);
            iTVEventListener.onDSILocked();
        }
    }

    public void updateDSIUnlocked() {
        this.log.log(-2137614336, "[TVEventDispatcher.updateDSIUnlocked]");
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ITVEventListener iTVEventListener = (ITVEventListener)this.listeners.get(i2);
            iTVEventListener.onDSIUnlocked();
        }
    }

    public void updateSelectedServiceDebounced(ProgramInfo programInfo) {
        this.log.log(-2137614336, "[TVEventDispatcher.updateSelectedServiceDebounced] program: %1", (Object)programInfo);
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ITVEventListener iTVEventListener = (ITVEventListener)this.listeners.get(i2);
            iTVEventListener.onSelectedServiceDebounced(programInfo);
        }
    }

    void enteredFullscreen(int n) {
        this.log.log(-2137614336, "[TVEventDispatcher.enteredFullscreen]");
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ITVEventListener iTVEventListener = (ITVEventListener)this.listeners.get(i2);
            iTVEventListener.onFullscreenEntered(n);
        }
    }

    void leftFullscreen(int n) {
        this.log.log(-2137614336, "[TVEventDispatcher.leftFullscreen]");
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ITVEventListener iTVEventListener = (ITVEventListener)this.listeners.get(i2);
            iTVEventListener.onFullscreenLeft(n);
        }
    }

    public void updateTerminalModeInputMode(int n) {
        this.log.log(-2137614336, "[TVEventDispatcher.updateTerminalModeInputMode] %1", (long)n);
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ((ITVEventListener)this.listeners.get(i2)).onTerminalModeInputModeChange(n);
        }
    }

    private void updateEWSVisibility(boolean bl) {
        this.log.log(-2137614336, "[TVEventDispatcher.updateEWSVisibility] %1", bl);
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ((ITVEventListener)this.listeners.get(i2)).onEWSInfoVisibilityChange(bl);
        }
    }

    static /* synthetic */ void access$800(TVEventDispatcher tVEventDispatcher, boolean bl) {
        tVEventDispatcher.updateEWSVisibility(bl);
    }

    static /* synthetic */ LogChannel access$900(TVEventDispatcher tVEventDispatcher) {
        return tVEventDispatcher.log;
    }

    static /* synthetic */ ArrayList access$1000(TVEventDispatcher tVEventDispatcher) {
        return tVEventDispatcher.listeners;
    }

    static /* synthetic */ Properties access$1100(TVEventDispatcher tVEventDispatcher) {
        return tVEventDispatcher.myProperties;
    }
}

