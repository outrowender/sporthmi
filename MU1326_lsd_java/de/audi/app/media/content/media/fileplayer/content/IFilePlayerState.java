/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.audio.AudioState;
import de.audi.app.media.content.media.fileplayer.FilePlayerSession;
import de.audi.app.media.content.media.fileplayer.content.VideoScaling;
import de.audi.app.media.source.ISourceSlot;
import org.dsi.ifc.media.Capabilities;

public interface IFilePlayerState {
    public static final int PLAYMODE_INVALID = -1;

    public FilePlayerSession getActiveSession();

    public void setActiveSession(FilePlayerSession var1);

    public Capabilities getCapabilitites();

    public int getPlaybackState();

    public AudioState getAudioState();

    public int getNormalPlayMode();

    public int getRepeatPlayMode();

    public int getPlaybackMode();

    public int getPlayerID();

    public void setVideoScaling(VideoScaling var1);

    public VideoScaling getVideoScaling();

    public boolean isOnPlayback();

    public boolean isOnSeeking();

    public void setActiveSlot(ISourceSlot var1);

    public ISourceSlot getActiveSlot();
}

