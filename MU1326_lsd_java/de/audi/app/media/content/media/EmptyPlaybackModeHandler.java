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

    @Override
    public void deactivate() {
    }

    @Override
    public boolean sendCurrentPlaybackMode() {
        return true;
    }

    public boolean isMixActive() {
        return false;
    }

    @Override
    public void trackChanged() {
    }

    @Override
    public void resetPlaybackMode() {
    }

    @Override
    protected boolean restoreLastPlaymode() {
        return true;
    }

    protected void updateRepeatScope(int n) {
    }

    @Override
    public int setRepeatTitle(boolean bl) {
        return 2;
    }

    protected void updateMixMode(boolean bl) {
    }

    @Override
    protected void playbackModeChanged() {
    }

    @Override
    public void setResetRepeatTitleOnTrackChange(boolean bl) {
    }
}

