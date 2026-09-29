/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.AbstractMediaPlayerHMIHandler$1;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.atip.hmi.model.ButtonListener;
import org.dsi.ifc.media.Capabilities;

public class AbstractMediaPlayerHMIHandler
extends AbstractMediaTerminalComponent
implements ButtonListener {
    private static final String LOGCLASS;
    public static final int HMI_PLAYBACK_STATE_UNDEFINED;
    public static final int HMI_PLAYBACK_STATE_PAUSED;
    public static final int HMI_PLAYBACK_STATE_PLAYING;
    public static final int HMI_PLAYBACK_STATE_SEEK_FORWARD;
    public static final int HMI_PLAYBACK_STATE_SEEK_BACKWARD;
    public static final int HMI_PLAYBACK_STATE_STOPPED;
    public static final int HMI_PLAYBACK_STATE_STOPPED_WITH_ERROR;
    public static final int HMI_PLAYBACK_STATE_PLAYING_MENU;
    private final IPlayer player;

    public AbstractMediaPlayerHMIHandler(IMediaTerminal iMediaTerminal, IPlayer iPlayer) {
        super(iMediaTerminal);
        this.player = iPlayer;
    }

    public void activate() {
        this.logger.hmi().log(1078071040, "[%1.activate]", (Object)"AbstractMediaPlayerHMIHandler");
        this.getButtonModel(1108214528).setButtonListener(this);
        this.setHMIPlaybackState(-1);
        this.disableNPSTimer(false);
        this.getChoiceModel(-938474752).setStatus(1);
    }

    public void deactivate() {
        this.logger.hmi().log(1078071040, "[%1.deactivate]", (Object)"AbstractMediaPlayerHMIHandler");
        this.setHMIPlayerCapabilities(null);
        this.setHMIPlaybackState(-1);
        this.getButtonModel(1108214528).setButtonListener(null);
    }

    protected void setHMIPlayerCapabilities(Capabilities capabilities) {
        this.logger.hmi().log(1078071040, "[%1.setHMIPlayerCapabilities]", (Object)"AbstractMediaPlayerHMIHandler");
        if (capabilities == null) {
            this.getChoiceModel(672006912).setValue(0);
            this.getChoiceModel(739115776).setValue(0);
            this.getChoiceModel(688784128).setValue(0);
            this.getChoiceModel(823001856).setValue(0);
            this.getChoiceModel(873333504).setValue(0);
            this.getChoiceModel(755892992).setValue(0);
            this.getChoiceModel(789447424).setValue(0);
            this.getChoiceModel(0x300E0300).setValue(0);
            this.getChoiceModel(0x330E0300).setValue(0);
            this.getChoiceModel(839779072).setValue(0);
            this.getChoiceModel(722338560).setValue(0);
            this.getChoiceModel(1242497792).setValue(0);
            this.getChoiceModel(-1861156096).setValue(0);
            this.getChoiceModel(-1844378880).setValue(0);
            this.getChoiceModel(-1676606720).setValue(0);
            return;
        }
        this.getChoiceModel(672006912).setValue(capabilities.isDetailInfos() ? 1 : 0);
        this.getChoiceModel(739115776).setValue(capabilities.isPlaySimilarEntries() ? 1 : 0);
        this.getChoiceModel(688784128).setValue(capabilities.isExtendedPlayView() ? 1 : 0);
        this.getChoiceModel(823001856).setValue(capabilities.isSetTimePos() ? 1 : 0);
        this.getChoiceModel(873333504).setValue(capabilities.isTotalPlaytime() ? 1 : 0);
        this.getChoiceModel(755892992).setValue(capabilities.isPlayTime() ? 1 : 0);
        this.getChoiceModel(789447424).setValue(capabilities.isFastBwd() || capabilities.isSloMoBwd() ? 1 : 0);
        this.getChoiceModel(0x300E0300).setValue(capabilities.isFastFwd() || capabilities.isSloMoFwd() ? 1 : 0);
        this.getChoiceModel(0x330E0300).setValue(capabilities.isSkipFwd() ? 1 : 0);
        this.getChoiceModel(839779072).setValue(capabilities.isSkipBwd() ? 1 : 0);
        this.getChoiceModel(722338560).setValue(capabilities.isPause() && capabilities.isPlay() ? 1 : 0);
        this.getChoiceModel(1242497792).setValue(capabilities.isPlayView() ? 1 : 0);
        this.getChoiceModel(-1861156096).setValue(capabilities.isPlaybackModeTakeOver() ? 1 : 0);
        this.getChoiceModel(-1844378880).setValue(capabilities.isPlaybackModeToggle() ? 1 : 0);
        this.getChoiceModel(-1676606720).setValue(capabilities.isPlaybackModes() ? 1 : 0);
    }

    protected void setHMIPlaybackState(int n) {
        this.logger.hmi().log(1078071040, "[%1.setHMIPlaybackState] '%2'", (Object)"AbstractMediaPlayerHMIHandler", (long)n);
        this.getChoiceModel(1124991744).setValue(n);
    }

    protected void disableNPSTimer(boolean bl) {
        this.logger.hmi().log(1078071040, "[%1.disableNPSTimer] '%2'", (Object)"AbstractMediaPlayerHMIHandler", (Object)String.valueOf(bl));
        this.getChoiceModel(-1374682368).setValue(bl ? 1 : 0);
    }

    protected void setWaitForDetailInfos(boolean bl) {
        this.getChoiceModel(-938474752).setStatus(bl ? 0 : 1);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 200258: {
                this.logger.hmi().log(1078071040, "[%1.keyTyped] PLAY_PAUSE", (Object)"AbstractMediaPlayerHMIHandler");
                this.getTerminal().getDispatcher().execute(new AbstractMediaPlayerHMIHandler$1(this, "AbstractMediaPlayerHMIHandler.resumePause"));
                break;
            }
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    static /* synthetic */ IPlayer access$000(AbstractMediaPlayerHMIHandler abstractMediaPlayerHMIHandler) {
        return abstractMediaPlayerHMIHandler.player;
    }

    static /* synthetic */ IMediaLogger access$100(AbstractMediaPlayerHMIHandler abstractMediaPlayerHMIHandler) {
        return abstractMediaPlayerHMIHandler.logger;
    }

    static /* synthetic */ IMediaLogger access$200(AbstractMediaPlayerHMIHandler abstractMediaPlayerHMIHandler) {
        return abstractMediaPlayerHMIHandler.logger;
    }
}

