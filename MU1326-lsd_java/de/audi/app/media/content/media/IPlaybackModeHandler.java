/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.source.IActivationContext;
import org.dsi.ifc.media.PlaybackMode;

public interface IPlaybackModeHandler {
    public static final int SCOPE_ALREADY_SET;
    public static final int SCOPE_NOT_SUPPORTED;
    public static final int SCOPE_SET_SUCCESSFUL;

    default public void activate(IActivationContext iActivationContext) {
    }

    default public void deactivate() {
    }

    default public void updatePlaybackModeList(PlaybackMode[] playbackModeArray) {
    }

    default public void updatePlaymodesAvailable(boolean bl) {
    }

    default public boolean sendCurrentPlaybackMode() {
    }

    default public void updateActivePlaybackMode(int n) {
    }

    default public int getActiveRepeatScope() {
    }

    default public boolean isMix() {
    }

    default public int setRepeatScope(int n, boolean bl) {
    }

    default public int setRepeatTitle(boolean bl) {
    }

    default public void trackChanged() {
    }

    default public boolean isRepeatOff() {
    }

    default public void sendRepeatPlayview() {
    }

    default public boolean isRepeatMedium() {
    }

    default public boolean isRepeatDevice() {
    }

    default public boolean isRepeatSelection() {
    }

    default public boolean isRepeatTrack() {
    }

    default public void resetPlaybackMode() {
    }

    default public void toggleRepeatMode() {
    }

    default public void toggleMixMode() {
    }

    default public void setResetRepeatTitleOnTrackChange(boolean bl) {
    }
}

