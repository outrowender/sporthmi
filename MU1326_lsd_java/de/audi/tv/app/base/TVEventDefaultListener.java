/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.ITVEventListener;
import org.dsi.ifc.tvtuner.ProgramInfo;

public class TVEventDefaultListener
implements ITVEventListener {
    @Override
    public void onSelectedServiceDebounced(ProgramInfo programInfo) {
    }

    public void onAudioStateChanged(boolean bl) {
    }

    @Override
    public void onPowerStateStandby() {
    }

    @Override
    public void onPowerStateOn() {
    }

    @Override
    public void onHighTemperatureShutdown() {
    }

    public void onSettingsAppAvailable() {
    }

    @Override
    public void onAppActivated(int n) {
    }

    @Override
    public void onAppDeactivated(int n) {
    }

    @Override
    public void onDSILocked() {
    }

    @Override
    public void onDSIUnlocked() {
    }

    @Override
    public void onFullscreenEntered(int n) {
    }

    @Override
    public void onFullscreenLeft(int n) {
    }

    @Override
    public void onMuGotTvAudioFocus() {
    }

    @Override
    public void onMuGotTvAudioFocus(boolean bl) {
    }

    @Override
    public void onMuLostTvAudioFocus() {
    }

    @Override
    public void onSdisGotTvAudioFocus() {
    }

    @Override
    public void onSdisLostTvAudioFocus() {
    }

    @Override
    public void onChildLockEnabled() {
    }

    @Override
    public void onChildLockDisabled() {
    }

    @Override
    public void parentalLevelSettingChanged(int n) {
    }

    @Override
    public void makeFactoryReset() {
    }

    @Override
    public void onTunerAvailable() {
    }

    @Override
    public void onTunerUnavailable() {
    }

    @Override
    public void onFocusedListChanged(int n) {
    }

    @Override
    public void onEsmEntered() {
    }

    @Override
    public void onEsmLeft() {
    }

    @Override
    public void onDsiLockStateChanged(boolean bl) {
    }

    @Override
    public void onEWSInfoVisibilityChange(boolean bl) {
    }

    @Override
    public void onMuteChange(boolean bl) {
    }

    @Override
    public void onTerminalModeInputModeChange(int n) {
    }
}

