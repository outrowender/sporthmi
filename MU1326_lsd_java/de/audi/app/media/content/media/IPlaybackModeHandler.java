/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.source.IActivationContext;
import org.dsi.ifc.media.PlaybackMode;

public interface IPlaybackModeHandler {
    public static final int SCOPE_ALREADY_SET = 1;
    public static final int SCOPE_NOT_SUPPORTED = 2;
    public static final int SCOPE_SET_SUCCESSFUL = 3;

    public void activate(IActivationContext var1);

    public void deactivate();

    public void updatePlaybackModeList(PlaybackMode[] var1);

    public void updatePlaymodesAvailable(boolean var1);

    public boolean sendCurrentPlaybackMode();

    public void updateActivePlaybackMode(int var1);

    public int getActiveRepeatScope();

    public boolean isMix();

    public int setRepeatScope(int var1, boolean var2);

    public int setRepeatTitle(boolean var1);

    public void trackChanged();

    public boolean isRepeatOff();

    public void sendRepeatPlayview();

    public boolean isRepeatMedium();

    public boolean isRepeatDevice();

    public boolean isRepeatSelection();

    public boolean isRepeatTrack();

    public void resetPlaybackMode();

    public void toggleRepeatMode();

    public void toggleMixMode();

    public void setResetRepeatTitleOnTrackChange(boolean var1);
}

