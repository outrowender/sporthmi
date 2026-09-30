/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.AbstractMediaPlayer;
import de.audi.app.media.content.media.AbstractPlaybackModeHandler;

public class EmptyPlaybackModeHandler
extends AbstractPlaybackModeHandler {
    public EmptyPlaybackModeHandler(IMediaTerminal iMediaTerminal, AbstractMediaPlayer abstractMediaPlayer, boolean bl) {
        super(iMediaTerminal, abstractMediaPlayer);
    }

    public void deactivate() {
    }

    public boolean sendCurrentPlaybackMode() {
        return true;
    }

    public boolean isMixActive() {
        return false;
    }

    public void trackChanged() {
    }

    public void resetPlaybackMode() {
    }

    protected boolean restoreLastPlaymode() {
        return true;
    }

    protected void updateRepeatScope(int n) {
    }

    public int setRepeatTitle(boolean bl) {
        return 2;
    }

    protected void updateMixMode(boolean bl) {
    }

    protected void playbackModeChanged() {
    }

    public void setResetRepeatTitleOnTrackChange(boolean bl) {
    }
}

