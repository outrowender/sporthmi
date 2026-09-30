/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.audio.AudioState;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.content.media.online.OnlinePlayerSession;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.PlaybackMode;

public class OnlinePlayerState {
    public static final int INVALID_PLAYMODE = -1;
    public static final short DEFAULT_INPUT_GAIN = 3;
    private static final int DEFAULT_AUDIO_TYPE = 0;
    private Capabilities capabilities;
    private int playbackState;
    private AudioState audioState;
    private OnlinePlayerSession activeSession;
    private int audioType;
    private short inputGain;
    private PlaybackMode[] playbackModeList;
    private int bufferState;
    private int bufferFillInfoPrecent;
    private long currentEntryID = -1L;
    private PlayTime currentPlayTime;
    private PlaybackMode currentPlayMode = null;

    public OnlinePlayerState() {
        this.reset();
    }

    public final void reset() {
        this.playbackState = 0;
        this.audioState = new AudioState(-1, 0);
        this.activeSession = null;
        this.capabilities = null;
        this.playbackModeList = null;
        this.bufferState = 0;
        this.bufferFillInfoPrecent = 0;
        this.currentEntryID = -1L;
        this.currentPlayTime = new PlayTime(0, 0);
        this.currentPlayMode = null;
        this.resetToneSettings();
    }

    public int getBufferState() {
        return this.bufferState;
    }

    public void setBufferState(int n) {
        this.bufferState = n;
    }

    public int getBufferFillInfoPrecent() {
        return this.bufferFillInfoPrecent;
    }

    public void setBufferFillInfoPrecent(int n) {
        this.bufferFillInfoPrecent = n;
    }

    public final void resetToneSettings() {
        this.inputGain = (short)3;
        this.audioType = 0;
    }

    public OnlinePlayerSession getActiveSession() {
        return this.activeSession;
    }

    public void setActiveSession(OnlinePlayerSession onlinePlayerSession) {
        this.activeSession = onlinePlayerSession;
    }

    public Capabilities getCapabilitites() {
        return this.capabilities;
    }

    public void setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
    }

    public void setPlaybackModes(PlaybackMode[] playbackModeArray) {
        this.playbackModeList = playbackModeArray;
    }

    public int getPlaybackState() {
        return this.playbackState;
    }

    public void setPlaybackState(int n) {
        this.playbackState = n;
    }

    public AudioState getAudioState() {
        return this.audioState;
    }

    public void setAudioState(AudioState audioState) {
        this.audioState = audioState;
    }

    public boolean isOnPlayback() {
        return this.getPlaybackState() == 1 || this.getPlaybackState() == 5 || this.getPlaybackState() == 3 || this.getPlaybackState() == 9 || this.getPlaybackState() == 8 || this.getPlaybackState() == 7 || this.getPlaybackState() == 6;
    }

    public boolean isOnSeeking() {
        return this.getPlaybackState() == 9 || this.getPlaybackState() == 8 || this.getPlaybackState() == 7 || this.getPlaybackState() == 6;
    }

    public boolean isSeekSupported() {
        return this.capabilities != null && (this.capabilities.isSloMoBwd() || this.capabilities.isSloMoFwd() || this.capabilities.isFastBwd() || this.capabilities.isFastFwd());
    }

    public boolean isSkipSupported() {
        return this.capabilities != null && (this.capabilities.isSkipFwd() || this.capabilities.isSkipBwd());
    }

    public boolean supportsPlaybackModes() {
        return this.capabilities.isPlaybackModes();
    }

    public long getCurrentEntryId() {
        return this.currentEntryID;
    }

    public void setCurrentEntryId(long l) {
        this.currentEntryID = l;
    }

    public void setCurrentPlayTime(PlayTime playTime) {
        this.currentPlayTime = playTime;
    }

    public PlayTime getCurrentPlayTime() {
        return this.currentPlayTime;
    }

    public void setPlaybackMode(int n) {
        this.currentPlayMode = null;
        if (n == -1) {
            return;
        }
        for (int i2 = 0; i2 < this.playbackModeList.length; ++i2) {
            if (this.playbackModeList[i2].getModeID() != n) continue;
            this.currentPlayMode = this.playbackModeList[i2];
            break;
        }
    }

    public int getCurrentPlaymode() {
        return this.currentPlayMode == null ? -1 : this.currentPlayMode.getModeID();
    }

    public int getPlayModeForRepeatMode(boolean bl) {
        int n;
        int n2 = n = bl ? 1 : 6;
        int n3 = this.currentPlayMode != null ? (bl ? 1 | this.currentPlayMode.getModeFlag() : 1 ^ this.currentPlayMode.getModeFlag()) : (bl ? 1 : 0);
        return this.getPlaybackMode(n, n3);
    }

    public int getPlayModeForShuffleMode(boolean bl) {
        int n;
        int n2;
        if (this.currentPlayMode != null) {
            n2 = this.currentPlayMode.getScope();
            n = bl ? 2 | this.currentPlayMode.getModeFlag() : 2 ^ this.currentPlayMode.getModeFlag();
        } else {
            n = bl ? 2 : 0;
            n2 = 6;
        }
        return this.getPlaybackMode(n2, n);
    }

    public boolean isRepeat() {
        return this.currentPlayMode != null && (this.currentPlayMode.scope & 1) == 1 && (this.currentPlayMode.modeFlag & 1) == 1;
    }

    public boolean isMix() {
        return this.currentPlayMode != null && (this.currentPlayMode.modeFlag & 2) == 2;
    }

    private int getPlaybackMode(int n, int n2) {
        for (int i2 = 0; i2 < this.playbackModeList.length; ++i2) {
            if (this.playbackModeList[i2].getScope() != n || (this.playbackModeList[i2].getModeFlag() & n2) != n2) continue;
            return this.playbackModeList[i2].getModeID();
        }
        return -1;
    }

    public int getAudioType() {
        return this.audioType;
    }

    public void setAudioType(int n) {
        this.audioType = n;
    }

    public short getInputGain() {
        return this.inputGain;
    }

    public void setInputGain(short s) {
        this.inputGain = s;
    }
}

