/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.IPlaybackModeHandler;
import de.audi.app.media.content.media.NullPlayer;
import de.audi.app.media.source.IActivationContext;
import org.dsi.ifc.media.PlaybackMode;

class NullPlayer$1
implements IPlaybackModeHandler {
    private final /* synthetic */ NullPlayer this$0;

    NullPlayer$1(NullPlayer nullPlayer) {
        this.this$0 = nullPlayer;
    }

    @Override
    public void updatePlaymodesAvailable(boolean bl) {
    }

    @Override
    public void updatePlaybackModeList(PlaybackMode[] playbackModeArray) {
    }

    @Override
    public void updateActivePlaybackMode(int n) {
    }

    @Override
    public void trackChanged() {
    }

    @Override
    public int setRepeatTitle(boolean bl) {
        return 0;
    }

    @Override
    public int setRepeatScope(int n, boolean bl) {
        return 0;
    }

    @Override
    public boolean sendCurrentPlaybackMode() {
        return false;
    }

    @Override
    public void resetPlaybackMode() {
    }

    @Override
    public boolean isRepeatTrack() {
        return false;
    }

    @Override
    public boolean isRepeatSelection() {
        return false;
    }

    @Override
    public boolean isRepeatMedium() {
        return false;
    }

    @Override
    public boolean isRepeatDevice() {
        return false;
    }

    @Override
    public boolean isMix() {
        return false;
    }

    @Override
    public int getActiveRepeatScope() {
        return 0;
    }

    @Override
    public void deactivate() {
    }

    @Override
    public void activate(IActivationContext iActivationContext) {
    }

    @Override
    public boolean isRepeatOff() {
        return false;
    }

    @Override
    public void sendRepeatPlayview() {
    }

    @Override
    public void toggleRepeatMode() {
    }

    @Override
    public void toggleMixMode() {
    }

    @Override
    public void setResetRepeatTitleOnTrackChange(boolean bl) {
    }
}

