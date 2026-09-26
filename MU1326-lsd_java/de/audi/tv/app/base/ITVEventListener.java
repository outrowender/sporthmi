/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.audio.IAudioListener;
import de.audi.tv.app.base.ITunerStatusListener;
import de.audi.tv.app.lists.IListFocusListener;
import de.audi.tv.app.settings.parental.IChildLockListener;
import org.dsi.ifc.tvtuner.ProgramInfo;

public interface ITVEventListener
extends IAudioListener,
IChildLockListener,
ITunerStatusListener,
IListFocusListener {
    default public void onSelectedServiceDebounced(ProgramInfo programInfo) {
    }

    default public void onPowerStateStandby() {
    }

    default public void onPowerStateOn() {
    }

    default public void onAppActivated(int n) {
    }

    default public void onAppDeactivated(int n) {
    }

    default public void onDSILocked() {
    }

    default public void onDSIUnlocked() {
    }

    default public void onFullscreenEntered(int n) {
    }

    default public void onFullscreenLeft(int n) {
    }

    default public void makeFactoryReset() {
    }

    default public void onEWSInfoVisibilityChange(boolean bl) {
    }

    default public void onMuGotTvAudioFocus() {
    }

    default public void onTerminalModeInputModeChange(int n) {
    }
}

