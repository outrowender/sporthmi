/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.audio.AudioState;
import de.audi.app.media.content.media.fileplayer.FilePlayerSession;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayerState;
import de.audi.app.media.content.media.fileplayer.content.VideoScaling;
import de.audi.app.media.source.ISourceSlot;
import org.dsi.ifc.media.Capabilities;

public class FilePlayerStateImpl
implements IFilePlayerState {
    private Capabilities capabilities;
    private int playbackState = 0;
    private AudioState audioState = new AudioState(-1, 0);
    private int normalPlayMode = -1;
    private int repeatPlayMode = -1;
    private int playmode = -1;
    private FilePlayerSession activeSession = null;
    private int playerID = 0;
    private VideoScaling videoScaling = null;
    private ISourceSlot activeSlot = null;

    public void reset() {
        this.playbackState = 0;
        this.audioState = new AudioState(-1, 0);
        this.normalPlayMode = -1;
        this.repeatPlayMode = -1;
        this.playmode = -1;
        this.activeSession = null;
        this.playerID = 0;
        this.videoScaling = null;
        this.activeSlot = null;
    }

    @Override
    public FilePlayerSession getActiveSession() {
        return this.activeSession;
    }

    @Override
    public void setActiveSession(FilePlayerSession filePlayerSession) {
        this.activeSession = filePlayerSession;
    }

    @Override
    public Capabilities getCapabilitites() {
        return this.capabilities;
    }

    public void setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
    }

    @Override
    public int getPlaybackState() {
        return this.playbackState;
    }

    public void setPlaybackState(int n) {
        this.playbackState = n;
    }

    @Override
    public AudioState getAudioState() {
        return this.audioState;
    }

    public void setAudioState(AudioState audioState) {
        this.audioState = audioState;
    }

    public void setPlaymodes(int n, int n2) {
        this.normalPlayMode = n;
        this.repeatPlayMode = n2;
    }

    @Override
    public int getNormalPlayMode() {
        return this.normalPlayMode;
    }

    @Override
    public int getRepeatPlayMode() {
        return this.repeatPlayMode;
    }

    public void setPlaybackMode(int n) {
        this.playmode = n;
    }

    @Override
    public int getPlaybackMode() {
        return this.playmode;
    }

    @Override
    public int getPlayerID() {
        return this.playerID;
    }

    public void setPlayerID(int n) {
        this.playerID = n;
    }

    @Override
    public void setVideoScaling(VideoScaling videoScaling) {
        this.videoScaling = videoScaling;
    }

    @Override
    public VideoScaling getVideoScaling() {
        return this.videoScaling;
    }

    @Override
    public boolean isOnPlayback() {
        return this.getPlaybackState() == 1 || this.getPlaybackState() == 5 || this.getPlaybackState() == 3 || this.getPlaybackState() == 9 || this.getPlaybackState() == 8 || this.getPlaybackState() == 7 || this.getPlaybackState() == 6;
    }

    @Override
    public boolean isOnSeeking() {
        return this.getPlaybackState() == 9 || this.getPlaybackState() == 8 || this.getPlaybackState() == 7 || this.getPlaybackState() == 6;
    }

    @Override
    public void setActiveSlot(ISourceSlot iSourceSlot) {
        this.activeSlot = iSourceSlot;
    }

    @Override
    public ISourceSlot getActiveSlot() {
        return this.activeSlot;
    }
}

