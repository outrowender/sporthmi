/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.IPlayer;
import de.audi.atip.hmi.model.ButtonListener;
import org.dsi.ifc.media.Capabilities;

public class AbstractMediaPlayerHMIHandler
extends AbstractMediaTerminalComponent
implements ButtonListener {
    private static final String LOGCLASS = "AbstractMediaPlayerHMIHandler";
    public static final int HMI_PLAYBACK_STATE_UNDEFINED = -1;
    public static final int HMI_PLAYBACK_STATE_PAUSED = 0;
    public static final int HMI_PLAYBACK_STATE_PLAYING = 1;
    public static final int HMI_PLAYBACK_STATE_SEEK_FORWARD = 2;
    public static final int HMI_PLAYBACK_STATE_SEEK_BACKWARD = 3;
    public static final int HMI_PLAYBACK_STATE_STOPPED = 4;
    public static final int HMI_PLAYBACK_STATE_STOPPED_WITH_ERROR = 5;
    public static final int HMI_PLAYBACK_STATE_PLAYING_MENU = 6;
    private final IPlayer player;

    public AbstractMediaPlayerHMIHandler(IMediaTerminal iMediaTerminal, IPlayer iPlayer) {
        super(iMediaTerminal);
        this.player = iPlayer;
    }

    public void activate() {
        this.logger.hmi().log(1000000, "[%1.activate]", (Object)LOGCLASS);
        this.getButtonModel(200258).setButtonListener(this);
        this.setHMIPlaybackState(-1);
        this.disableNPSTimer(false);
        this.getChoiceModel(200904).setStatus(1);
    }

    public void deactivate() {
        this.logger.hmi().log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        this.setHMIPlayerCapabilities(null);
        this.setHMIPlaybackState(-1);
        this.getButtonModel(200258).setButtonListener(null);
    }

    protected void setHMIPlayerCapabilities(Capabilities capabilities) {
        this.logger.hmi().log(1000000, "[%1.setHMIPlayerCapabilities]", (Object)LOGCLASS);
        if (capabilities == null) {
            this.getChoiceModel(200232).setValue(0);
            this.getChoiceModel(200236).setValue(0);
            this.getChoiceModel(200233).setValue(0);
            this.getChoiceModel(200241).setValue(0);
            this.getChoiceModel(200244).setValue(0);
            this.getChoiceModel(200237).setValue(0);
            this.getChoiceModel(200239).setValue(0);
            this.getChoiceModel(200240).setValue(0);
            this.getChoiceModel(200243).setValue(0);
            this.getChoiceModel(200242).setValue(0);
            this.getChoiceModel(200235).setValue(0);
            this.getChoiceModel(200522).setValue(0);
            this.getChoiceModel(201105).setValue(0);
            this.getChoiceModel(201106).setValue(0);
            this.getChoiceModel(201116).setValue(0);
            return;
        }
        this.getChoiceModel(200232).setValue(capabilities.isDetailInfos() ? 1 : 0);
        this.getChoiceModel(200236).setValue(capabilities.isPlaySimilarEntries() ? 1 : 0);
        this.getChoiceModel(200233).setValue(capabilities.isExtendedPlayView() ? 1 : 0);
        this.getChoiceModel(200241).setValue(capabilities.isSetTimePos() ? 1 : 0);
        this.getChoiceModel(200244).setValue(capabilities.isTotalPlaytime() ? 1 : 0);
        this.getChoiceModel(200237).setValue(capabilities.isPlayTime() ? 1 : 0);
        this.getChoiceModel(200239).setValue(capabilities.isFastBwd() || capabilities.isSloMoBwd() ? 1 : 0);
        this.getChoiceModel(200240).setValue(capabilities.isFastFwd() || capabilities.isSloMoFwd() ? 1 : 0);
        this.getChoiceModel(200243).setValue(capabilities.isSkipFwd() ? 1 : 0);
        this.getChoiceModel(200242).setValue(capabilities.isSkipBwd() ? 1 : 0);
        this.getChoiceModel(200235).setValue(capabilities.isPause() && capabilities.isPlay() ? 1 : 0);
        this.getChoiceModel(200522).setValue(capabilities.isPlayView() ? 1 : 0);
        this.getChoiceModel(201105).setValue(capabilities.isPlaybackModeTakeOver() ? 1 : 0);
        this.getChoiceModel(201106).setValue(capabilities.isPlaybackModeToggle() ? 1 : 0);
        this.getChoiceModel(201116).setValue(capabilities.isPlaybackModes() ? 1 : 0);
    }

    protected void setHMIPlaybackState(int n) {
        this.logger.hmi().log(1000000, "[%1.setHMIPlaybackState] '%2'", (Object)LOGCLASS, (long)n);
        this.getChoiceModel(200259).setValue(n);
    }

    protected void disableNPSTimer(boolean bl) {
        this.logger.hmi().log(1000000, "[%1.disableNPSTimer] '%2'", (Object)LOGCLASS, (Object)String.valueOf(bl));
        this.getChoiceModel(200878).setValue(bl ? 1 : 0);
    }

    protected void setWaitForDetailInfos(boolean bl) {
        this.getChoiceModel(200904).setStatus(bl ? 0 : 1);
    }

    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 200258: {
                this.logger.hmi().log(1000000, "[%1.keyTyped] PLAY_PAUSE", (Object)LOGCLASS);
                this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("AbstractMediaPlayerHMIHandler.resumePause"){

                    public void run() {
                        if (AbstractMediaPlayerHMIHandler.this.player.isPlaying() || AbstractMediaPlayerHMIHandler.this.player.isSeeking()) {
                            AbstractMediaPlayerHMIHandler.this.logger.hmi().log(10000000, "[%1.keyTyped] Player not paused. Mute it.", (Object)AbstractMediaPlayerHMIHandler.LOGCLASS);
                            AbstractMediaPlayerHMIHandler.this.getTerminal().getAudioManager().mute();
                        } else {
                            AbstractMediaPlayerHMIHandler.this.logger.hmi().log(10000000, "[%1.keyTyped] Player paused.", (Object)AbstractMediaPlayerHMIHandler.LOGCLASS);
                            AbstractMediaPlayerHMIHandler.this.player.resume();
                        }
                    }
                });
                break;
            }
        }
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }
}

