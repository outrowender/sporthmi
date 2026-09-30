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
    public OnlinePlayerState getState();

    public Queue getPlayerQueue();

    public IAudioManager getAudioManager();

    public DispatcherBase getDispatcher();

    public void setPlaybackURL(String var1);

    public void resume();

    public void pause();

    public boolean seek(boolean var1);

    public boolean skip(int var1);

    public void setPlayposition(long var1, int var3);

    public void stop();

    public void updatePlayingTrack(long var1, String var3, String var4, String var5, ResourceLocator var6);

    public void notifyAudioSettings();

    public void setPlaybackMode(int var1);

    public void setHMIPlaybackMode();

    public void playbackModeChanged(int var1, boolean var2);

    public void updateOnlineCoverArt(ResourceLocator var1);
}

