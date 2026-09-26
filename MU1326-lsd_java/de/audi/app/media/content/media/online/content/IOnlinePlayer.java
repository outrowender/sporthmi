/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.audio.IAudioManager;
import de.audi.app.media.content.media.online.content.OnlinePlayerState;
import de.audi.app.media.queue.Queue;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.global.ResourceLocator;

public interface IOnlinePlayer {
    default public OnlinePlayerState getState() {
    }

    default public Queue getPlayerQueue() {
    }

    default public IAudioManager getAudioManager() {
    }

    default public DispatcherBase getDispatcher() {
    }

    default public void setPlaybackURL(String string) {
    }

    default public void resume() {
    }

    default public void pause() {
    }

    default public boolean seek(boolean bl) {
    }

    default public boolean skip(int n) {
    }

    default public void setPlayposition(long l, int n) {
    }

    default public void stop() {
    }

    default public void updatePlayingTrack(long l, String string, String string2, String string3, ResourceLocator resourceLocator) {
    }

    default public void notifyAudioSettings() {
    }

    default public void setPlaybackMode(int n) {
    }

    default public void setHMIPlaybackMode() {
    }

    default public void playbackModeChanged(int n, boolean bl) {
    }

    default public void updateOnlineCoverArt(ResourceLocator resourceLocator) {
    }
}

