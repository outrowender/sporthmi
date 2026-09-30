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
    public void onSelectedServiceDebounced(ProgramInfo var1);

    public void onPowerStateStandby();

    public void onPowerStateOn();

    public void onAppActivated(int var1);

    public void onAppDeactivated(int var1);

    public void onDSILocked();

    public void onDSIUnlocked();

    public void onFullscreenEntered(int var1);

    public void onFullscreenLeft(int var1);

    public void makeFactoryReset();

    public void onEWSInfoVisibilityChange(boolean var1);

    public void onMuGotTvAudioFocus();

    public void onTerminalModeInputModeChange(int var1);
}

