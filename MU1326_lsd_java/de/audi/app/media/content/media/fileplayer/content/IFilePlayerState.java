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
    public static final int PLAYMODE_INVALID;

    default public FilePlayerSession getActiveSession() {
    }

    default public void setActiveSession(FilePlayerSession filePlayerSession) {
    }

    default public Capabilities getCapabilitites() {
    }

    default public int getPlaybackState() {
    }

    default public AudioState getAudioState() {
    }

    default public int getNormalPlayMode() {
    }

    default public int getRepeatPlayMode() {
    }

    default public int getPlaybackMode() {
    }

    default public int getPlayerID() {
    }

    default public void setVideoScaling(VideoScaling videoScaling) {
    }

    default public VideoScaling getVideoScaling() {
    }

    default public boolean isOnPlayback() {
    }

    default public boolean isOnSeeking() {
    }

    default public void setActiveSlot(ISourceSlot iSourceSlot) {
    }

    default public ISourceSlot getActiveSlot() {
    }
}

