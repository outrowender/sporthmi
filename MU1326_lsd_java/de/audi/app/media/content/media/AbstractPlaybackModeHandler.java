/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.AbstractMediaPlayer;
import de.audi.app.media.content.media.IPlaybackModeHandler;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.source.IActivationContext;
import org.dsi.ifc.media.PlaybackMode;

public abstract class AbstractPlaybackModeHandler
extends AbstractMediaTerminalComponent
implements IPlaybackModeHandler {
    private static final String LOGCLASS = "AbstractPlaybackModeHandler";
    private static final int PLAYBACK_MODE_NOT_SUPPORTED = -1;
    protected final AbstractMediaPlayer mediaPlayer;
    protected final IMediaLogger logger;
    private volatile PlaybackMode[] playbackModeList;
    private volatile PlaybackMode activePlaybackMode;

    public AbstractPlaybackModeHandler(IMediaTerminal iMediaTerminal, AbstractMediaPlayer abstractMediaPlayer) {
        super(iMediaTerminal);
        this.mediaPlayer = abstractMediaPlayer;
        this.logger = iMediaTerminal.getLogger();
    }

    public void activate(IActivationContext iActivationContext) {
        this.logger.main().log(1000000, "[%1.activate]", (Object)LOGCLASS);
        this.playbackModeList = new PlaybackMode[0];
        this.activePlaybackMode = null;
    }

    public void updatePlaybackModeList(PlaybackMode[] playbackModeArray) {
        this.logger.hmi().log(1000000, "[%1.setPlaybackModeList]", (Object)LOGCLASS);
        boolean bl = this.playbackModeList == null || this.playbackModeList.length == 0;
        this.playbackModeList = playbackModeArray;
        if (bl && this.mediaPlayer.isReadyToPlay()) {
            this.restoreLastPlaymode();
        }
    }

    public void updatePlaymodesAvailable(boolean bl) {
        this.logger.main().log(1000000, "[%1.updatePlaymodesAvailable] '%2'", (Object)LOGCLASS, (Object)bl);
        if (!bl) {
            this.updatePlaybackModeList(new PlaybackMode[0]);
        } else if (this.mediaPlayer.isReadyToPlay() && this.playbackModeList != null && this.playbackModeList.length > 0) {
            this.restoreLastPlaymode();
        }
    }

    public void updateActivePlaybackMode(int n) {
        this.logger.main().log(1000000, "[%1.updateActivePlaybackMode] '%2'", (Object)LOGCLASS, (long)n);
        this.activePlaybackMode = this.getPlaybackModeByModeID(n);
        if (this.activePlaybackMode == null) {
            this.logger.main().log(100000, "[%1.updateActivePlaybackMode] Mode '%2' not found.", (Object)LOGCLASS, (long)n);
            return;
        }
        int n2 = AbstractPlaybackModeHandler.convertScopeHMI2DSI(this.activePlaybackMode.getScope());
        this.playbackModeChanged();
        this.logger.main().log(1000000, "[%1.updateActivePlaybackMode] scope='%2',mix='%3'.", (Object)LOGCLASS, (Object)AbstractPlaybackModeHandler.getRepeatScopeStr(n2), (Object)String.valueOf(this.isMix()));
        this.mediaPlayer.notifyPlayerRepeatScopeChanged(n2, this.isMix());
        if (this.mediaPlayer.supportsPlaybackModeToggle()) {
            int n3;
            if (this.isRepeatOff()) {
                this.logger.main().log(1000000, "[%1.updateActivePlaybackMode] Repeat OFF.", (Object)LOGCLASS);
                n3 = 0;
            } else if (this.isRepeatTrack()) {
                this.logger.main().log(1000000, "[%1.updateActivePlaybackMode] Repeat TITLE.", (Object)LOGCLASS);
                n3 = 1;
            } else if (this.isRepeatSelection()) {
                this.logger.main().log(1000000, "[%1.updateActivePlaybackMode] Repeat LIST.", (Object)LOGCLASS);
                n3 = 2;
            } else {
                this.logger.main().log(100000, "[%1.updateActivePlaybackMode] Repeat UNKNOWN -> Default: OFF", (Object)LOGCLASS);
                n3 = 0;
            }
            this.mediaPlayer.notifyPlayerRepeatModeChanged(n3);
        }
    }

    public int getActiveRepeatScope() {
        PlaybackMode playbackMode = this.activePlaybackMode;
        if (playbackMode == null) {
            return -1;
        }
        return AbstractPlaybackModeHandler.convertScopeHMI2DSI(playbackMode.getScope());
    }

    public boolean isMix() {
        return this.activePlaybackMode == null ? false : (this.activePlaybackMode.modeFlag & 2) == 2;
    }

    public boolean isRepeatMedium() {
        return this.activePlaybackMode != null && this.activePlaybackMode.getScope() == 3 && (this.activePlaybackMode.getModeFlag() & 1) == 1;
    }

    public boolean isRepeatDevice() {
        return this.activePlaybackMode != null && this.activePlaybackMode.getScope() == 2 && (this.activePlaybackMode.getModeFlag() & 1) == 1;
    }

    public boolean isRepeatSelection() {
        return this.activePlaybackMode != null && this.activePlaybackMode.getScope() == 6 && (this.activePlaybackMode.getModeFlag() & 1) == 1;
    }

    public boolean isRepeatOff() {
        if (this.activePlaybackMode == null) {
            return true;
        }
        return (this.activePlaybackMode.getModeFlag() & 1) != 1;
    }

    public void sendRepeatPlayview() {
        this.logger.main().log(1000000, "[%1.sendRepeatPlayview] ", (Object)LOGCLASS);
        this.setRepeatScope(4, this.isMix());
    }

    public boolean isRepeatTrack() {
        return this.activePlaybackMode != null && this.activePlaybackMode.getScope() == 1 && (this.activePlaybackMode.getModeFlag() & 1) == 1;
    }

    public int setRepeatScope(int n, boolean bl) {
        this.logger.main().log(1000000, "[%2.setRepeatScope] '%3' (mix='%1')", bl, (Object)LOGCLASS, (Object)AbstractPlaybackModeHandler.getRepeatScopeStr(n));
        if (this.mediaPlayer.supportsPlaybackModeToggle()) {
            this.logger.main().log(100000, "[%1.setRepeatScope] Only playback mode toggle supported.", (Object)LOGCLASS);
            return 2;
        }
        if (this.getActiveRepeatScope() == n && this.isMix() == bl && !this.isRepeatOff()) {
            this.logger.hmi().log(1000000, "[%1.setRepeatScope] Scope already active.", (Object)LOGCLASS);
            return 1;
        }
        int n2 = this.getPlaybackModeForScope(n, bl);
        if (n2 == -1) {
            this.logger.hmi().log(1000000, "[%1.setRepeatScope] No playback modeID found.", (Object)LOGCLASS);
            n2 = this.getPlaybackModeForScope(n, false);
            if (n2 == -1) {
                return 2;
            }
        }
        this.mediaPlayer.setPlaybackMode(n2);
        return 3;
    }

    public void toggleRepeatMode() {
        if (!this.mediaPlayer.supportsPlaybackModeToggle()) {
            this.logger.hmi().log(100000, "[%1.toggleRepeatMode] No playback mode toggle supported. Nothing to do.", (Object)LOGCLASS);
            return;
        }
        this.logger.main().log(1000000, "[%1.toggleRepeatMode].", (Object)LOGCLASS);
        this.mediaPlayer.setPlaybackMode(-2);
    }

    public void toggleMixMode() {
        if (!this.mediaPlayer.supportsPlaybackModeToggle()) {
            this.logger.hmi().log(100000, "[%1.toggleMixMode] No playback mode toggle supported. Nothing to do.", (Object)LOGCLASS);
            return;
        }
        this.logger.main().log(1000000, "[%1.toggleMixMode].", (Object)LOGCLASS);
        this.mediaPlayer.setPlaybackMode(-3);
    }

    public boolean supportsPlaybackModeToggle() {
        return this.mediaPlayer.supportsPlaybackModeToggle();
    }

    protected void usePlaybackModeOfPlayer() {
        this.mediaPlayer.setPlaybackMode(-1);
    }

    protected boolean isMixAvailable(int n) {
        return this.getPlaybackModeForScope(n, true) != -1;
    }

    protected boolean isRepeatScopeAvailable(int n) {
        return this.getPlaybackModeForScope(n, false) != -1;
    }

    protected abstract boolean restoreLastPlaymode();

    protected abstract void playbackModeChanged();

    private PlaybackMode getPlaybackModeByModeID(int n) {
        PlaybackMode[] playbackModeArray = this.playbackModeList;
        for (int i2 = 0; i2 < playbackModeArray.length; ++i2) {
            if (playbackModeArray[i2].getModeID() != n) continue;
            return playbackModeArray[i2];
        }
        return null;
    }

    private int getPlaybackModeForScope(int n, boolean bl) {
        PlaybackMode[] playbackModeArray = this.playbackModeList;
        int n2 = AbstractPlaybackModeHandler.convertScopeDSI2HMI(n);
        this.logger.main().log(1000000, "[%1.getPlaybackModeForScope] '%2'", (Object)LOGCLASS, (long)n2);
        for (int i2 = 0; i2 < playbackModeArray.length; ++i2) {
            boolean bl2;
            boolean bl3 = (playbackModeArray[i2].getModeFlag() & 2) == 2;
            boolean bl4 = bl2 = (playbackModeArray[i2].getModeFlag() & 1) == 1 || 2 == n2;
            if (playbackModeArray[i2].getScope() != n2 || bl != bl3 || !bl2) continue;
            return playbackModeArray[i2].getModeID();
        }
        this.logger.main().log(1000000, "[%1.getPlaybackModeForScope] No playback mode (scope='%2',mix='%3') found.", (Object)LOGCLASS, (Object)AbstractPlaybackModeHandler.getRepeatScopeStr(n), (Object)String.valueOf(bl));
        return -1;
    }

    private static int convertScopeHMI2DSI(int n) {
        switch (n) {
            case 2: {
                return 0;
            }
            case 3: {
                return 1;
            }
            case 6: {
                return 4;
            }
            case 1: {
                return 3;
            }
        }
        return -1;
    }

    private static int convertScopeDSI2HMI(int n) {
        switch (n) {
            case 0: {
                return 2;
            }
            case 1: {
                return 3;
            }
            case 4: {
                return 6;
            }
            case 3: {
                return 1;
            }
        }
        return 2;
    }

    protected static String getRepeatScopeStr(int n) {
        switch (n) {
            case 0: {
                return "SCOPE_DEVICE";
            }
            case 1: {
                return "SCOPE_MEDIA";
            }
            case 2: {
                return "SCOPE_FOLDER";
            }
            case 4: {
                return "SCOPE_SELECTION";
            }
            case 3: {
                return "SCOPE_TRACK";
            }
        }
        return "UNKNOWN";
    }

    PlaybackMode[] getPlaybackModeList() {
        return this.playbackModeList;
    }

    PlaybackMode getActivePlaybackMode() {
        return this.activePlaybackMode;
    }
}

