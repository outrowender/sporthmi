/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.dvdvideo;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.content.IContent;
import de.audi.app.media.content.media.AbstractMediaPlayer;
import de.audi.app.media.content.media.AbstractVideoFormatSetting;
import de.audi.app.media.content.media.EmptyPlaybackModeHandler;
import de.audi.app.media.content.media.IPlayerTrackListener;
import de.audi.app.media.content.media.ManualSeekHandler;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.content.media.dvdvideo.DVDVideoSettingsAudioStream;
import de.audi.app.media.content.media.dvdvideo.DVDVideoSettingsSubtitle;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.dsi.media.IMediaVideoFormat;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.content.VideoFormatSettingEvo;
import de.audi.app.media.evo.content.dvdvideo.BlockingMaskHandler;
import de.audi.app.media.evo.content.dvdvideo.DVDVideoPlayerViewList;
import de.audi.app.media.evo.content.dvdvideo.PMBlockingHandler;
import de.audi.app.media.source.IActivationContext;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.ISourceSlotListener;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.VirtualButtonListener;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.AudioStream;

public class DVDVideoPlayer
extends AbstractMediaPlayer
implements IPlayerTrackListener,
VirtualButtonListener,
ISourceSlotListener,
IActionProxyListener,
TimerListener {
    private static final String LOGCLASS;
    private final DVDVideoPlayerViewList dvdPlayerList;
    private final DVDVideoSettingsAudioStream settingsAudioStream;
    private final DVDVideoSettingsSubtitle settingsSubtitle;
    private final AbstractVideoFormatSetting settingsVideoFormat;
    private final BlockingMaskHandler blockingMaskHandler;
    private final PMBlockingHandler pmBlockingHandler;
    private final ModelGroup trackTimeModelGroup;
    private final ManualSeekHandler manualSeekHandler;
    private final Timer autoPlayTimer;
    private volatile int hmiDisplayContext;
    private volatile boolean moving;
    private volatile boolean dvdMenuEntered;
    private volatile int previousActiveSlotError;

    public DVDVideoPlayer(IMediaTerminal iMediaTerminal, IContent iContent, IMediaDSIPlayerController iMediaDSIPlayerController) {
        super(iMediaTerminal, iContent, iMediaDSIPlayerController, true);
        this.pmBlockingHandler = new PMBlockingHandler(this, iMediaTerminal.getLogger(), iMediaTerminal.getDSIBaseController());
        this.manualSeekHandler = new ManualSeekHandler(iMediaTerminal, this, false);
        this.settingsAudioStream = new DVDVideoSettingsAudioStream(iMediaTerminal, iMediaDSIPlayerController, this.getBaseListModel(1360069376), this.getChoiceModel(-217120000), this.getChoiceModel(1628439296), this.getChoiceModel(1645216512), this.getChoiceModel(957350656));
        this.settingsSubtitle = new DVDVideoSettingsSubtitle(iMediaTerminal, iMediaDSIPlayerController, this.getBaseListModel(1393623808), this.getChoiceModel(1376846592), this.getLabelModel(1343292160));
        this.settingsVideoFormat = new VideoFormatSettingEvo(iMediaTerminal, iMediaDSIPlayerController, 1259209472, new int[]{0, 1, 2, 3, 4, 5}, 170);
        this.dvdPlayerList = new DVDVideoPlayerViewList(iMediaTerminal, this);
        this.blockingMaskHandler = new BlockingMaskHandler(iMediaTerminal);
        this.trackTimeModelGroup = new ModelGroup();
        this.autoPlayTimer = new Timer("DVDVideoPlayerAutoPlayTimer", 0, false, this);
    }

    @Override
    public void init() {
        this.logger.main().log(1078071040, "[%1.init]", (Object)"DVDVideoPlayer");
        super.init();
        this.dvdPlayerList.init();
        this.getVirtualButtonModelModel(-468778240).setVirtualButtonListener(this);
        this.getButtonModel(-535887104).setButtonListener(this);
        this.getVirtualButtonModelModel(-1341127936).setVirtualButtonListener(this);
        RangeModelApp rangeModelApp = this.getRangeModel(-284228864);
        rangeModelApp.setLimits(0, 100, 1);
        rangeModelApp.setValue(0);
        this.trackTimeModelGroup.add(this.getModel(-301006080));
        this.trackTimeModelGroup.add(this.getModel(-250674432));
        this.trackTimeModelGroup.add(rangeModelApp);
    }

    @Override
    public void deinit() {
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"DVDVideoPlayer");
        super.deinit();
        this.dvdPlayerList.deinit();
        this.getVirtualButtonModelModel(-468778240).setVirtualButtonListener(null);
        this.getButtonModel(-535887104).setButtonListener(null);
        this.getVirtualButtonModelModel(-1341127936).setVirtualButtonListener(null);
        this.trackTimeModelGroup.removeAll();
    }

    @Override
    public void resetSettings() {
        this.settingsVideoFormat.resetSetting(this.getActiveSlot() != null);
    }

    public void activate(IActivationContext iActivationContext) {
        this.logger.main().log(1078071040, "[%1.activate]", (Object)"DVDVideoPlayer");
        EmptyPlaybackModeHandler emptyPlaybackModeHandler = new EmptyPlaybackModeHandler(this.getTerminal(), this, true);
        super.activate(iActivationContext, emptyPlaybackModeHandler);
        this.getChoiceModel(1997538048).setValue(0);
        this.manualSeekHandler.activate();
        this.getTerminal().addActionProxyListener(new int[]{31, 30}, (IActionProxyListener)this);
        this.addTrackListener(this);
        int n = (Integer)this.getActivationContext().getParameter("PHYSICAL_PLAYER_ID");
        if (this.getActivationContext().getSlot().getSource().getType() == 3) {
            this.hmiDisplayContext = 7;
        } else {
            switch (n) {
                case 1: {
                    this.hmiDisplayContext = 25;
                    break;
                }
                case 3: {
                    this.hmiDisplayContext = 7;
                    break;
                }
                default: {
                    this.hmiDisplayContext = 26;
                }
            }
        }
        this.settingsVideoFormat.activate((IMediaVideoFormat)iActivationContext.getParameter("VIDEO_FORMAT_HANDLER"));
        this.settingsVideoFormat.restoreSetting();
        this.pmBlockingHandler.activate();
        this.previousActiveSlotError = 0;
        this.getActiveSlot().getSource().addSlotListener(this, true);
    }

    @Override
    public void deactivate() {
        this.logger.main().log(1078071040, "[%1.deactivate]", (Object)"DVDVideoPlayer");
        this.manualSeekHandler.deactivate();
        this.getTerminal().removeActionProxyListener(this);
        this.settingsVideoFormat.deactivate();
        this.blockingMaskHandler.resetSeekToTimeBlocking();
        this.pmBlockingHandler.deactivate();
        this.enableDisplayable(false);
        if (null != this.getActiveSlot()) {
            this.getActiveSlot().getSource().removeSlotListener(this);
        }
        super.deactivate();
        this.clearDetailInfo();
        this.getChoiceModel(1997538048).setValue(0);
        this.dvdPlayerList.deactivate();
    }

    private void clearDetailInfo() {
        this.logger.main().log(1078071040, "[%1.clearDetailInfo]", (Object)"DVDVideoPlayer");
        this.getLabelModel(-368114944).setText("");
        this.getChoiceModel(-351337728).setValue(0);
    }

    public void vehicleMoving(boolean bl) {
        this.logger.main().log(1078071040, "[%2.vehicleMoving] '%1'.", bl, (Object)"DVDVideoPlayer");
        this.moving = bl;
        this.enableDisplayable(!bl);
        this.checkForAutoPlay();
    }

    private void enableDisplayable(boolean bl) {
        this.logger.hmi().log(1078071040, "[%2.enableDisplayable] '%1'.", bl, (Object)"DVDVideoPlayer");
        if (bl) {
            this.getChoiceModel(-670104832).setValue(this.hmiDisplayContext);
        } else {
            this.getChoiceModel(-670104832).setValue(0);
        }
    }

    @Override
    public void touchEvent(int n, int n2, int n3) {
        if (this.logger.main().isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append("'").append(n).append("','(").append(n2).append(",").append(n3).append("'");
            this.logger.main().log(1078071040, "[%1.touchEvent] %2", (Object)"DVDVideoPlayer", (Object)buffer);
        }
        this.getDSIPlayer().touchEvent(n == 0 ? 0 : 1, n2, n3);
    }

    @Override
    public void executeMenuCommand(int n) {
        this.logger.main().log(1078071040, "[%1.executeDVDCommand] command=%2", (Object)"DVDVideoPlayer", (long)n);
        this.getDSIPlayer().executeMenuCmd(n);
        if (n == 1) {
            if (this.getTerminal().getAudioManager().hasFrontAudioFocus()) {
                this.getTerminal().getAudioManager().resumeAudio(true);
            } else {
                this.resume();
            }
        }
    }

    @Override
    protected void playerStartupComplete() {
        this.logger.main().log(1078071040, "[%1.playerStartupComplete]", (Object)"DVDVideoPlayer");
        super.playerStartupComplete();
        this.logger.main().log(1078071040, "[%1.playerStartupComplete] Activate play view", (Object)"DVDVideoPlayer");
        this.dvdPlayerList.activate();
    }

    @Override
    protected final boolean supportsPlaymodes() {
        return this.capabilities.playbackModes;
    }

    @Override
    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        this.getLabelModel(-368114944).setText(mediaDetailInfo.getTitle().getI18NString());
        this.getChoiceModel(-351337728).setValue(mediaDetailInfo.getTitle().getI18NKey());
    }

    @Override
    public void trackChanged(boolean bl, boolean bl2, PlayingTrack playingTrack, PlayTime playTime) {
        this.getLabelModel(-301006080).setText(playTime.getRestrictedPlayTimeStr());
        this.getLabelModel(-250674432).setText(playTime.getRemainTimeStr());
        this.getRangeModel(-284228864).setValue(playTime.getProgress());
        this.trackTimeModelGroup.flush();
    }

    @Override
    public void coverArtChanged(ResourceLocator resourceLocator) {
    }

    @Override
    public void updateSubtitleList(int[] nArray) {
        this.logger.dsi().log(1078071040, "[%1.updateSubtitleList]", (Object)"DVDVideoPlayer");
        this.settingsSubtitle.updateSubtitleList(nArray);
    }

    @Override
    public void updateActiveSubtitle(int n) {
        this.logger.dsi().log(1078071040, "[%1.updateAudioSubtitle] '%2'", (Object)"DVDVideoPlayer", (long)n);
        this.settingsSubtitle.updateActiveSubtitle(n);
    }

    public void setSubtitleLanguage(int n) {
        this.getDSIPlayer().setSubtitleLanguage(n);
    }

    @Override
    public void updateAudioStreamList(AudioStream[] audioStreamArray) {
        this.logger.dsi().log(1078071040, "[%1.updateAudioStreamList]", (Object)"DVDVideoPlayer");
        this.settingsAudioStream.updateAudioStreamList(audioStreamArray);
    }

    @Override
    public void updateActiveAudioStream(int n) {
        this.logger.dsi().log(1078071040, "[%1.updateActiveAudioStream] '%2'", (Object)"DVDVideoPlayer", (long)n);
        this.settingsAudioStream.updateActiveAudioStream(n);
    }

    public void setAudioStream(int n) {
        this.getDSIPlayer().setAudioStream(n);
    }

    @Override
    public void updateVideoFormat(int n) {
        this.logger.main().log(1078071040, "[%1.updateVideoFormat] '%2'", (Object)"DVDVideoPlayer", (long)n);
        this.settingsVideoFormat.setActiveVideoFormat(n);
    }

    @Override
    public void responseTempPMLRequest(int n) {
        this.logger.main().log(1078071040, "[%1.responseTempPMLRequest] '%2'", (Object)"DVDVideoPlayer", (long)n);
        super.responseTempPMLRequest(n);
        this.pmBlockingHandler.setBlockedByTempPM(n);
    }

    public void denyTempPMLRequest() {
        this.logger.main().log(1078071040, "[%1.denyTempPMLRequest]", (Object)"DVDVideoPlayer");
        this.getDSIPlayer().denyTempPMLRequest();
    }

    public void updatePMLBlock(boolean bl) {
        this.logger.main().log(1078071040, "[%1.updatePMLBlock] '%2'", (Object)"DVDVideoPlayer", (Object)bl);
        this.pmBlockingHandler.setBlockedByMediumPM(bl);
    }

    @Override
    public void indicationDvdEvent(int n) {
        super.indicationDvdEvent(n);
        if (n == 1) {
            this.dvdMenuEntered = true;
            this.logger.main().log(-2137614336, "[%1.indicationDvdEvent] DVDEVENT_MENU_SELECTION.", (Object)"DVDVideoPlayer");
        } else {
            this.logger.main().log(-2137614336, "[%1.indicationDvdEvent] DVDEVENT_MENU_SELECTION leaved.", (Object)"DVDVideoPlayer");
            this.dvdMenuEntered = false;
        }
        this.logger.main().log(-2137614336, "[%1.indicationDvdEvent] DVD_EVENT: %2", (Object)"DVDVideoPlayer", (long)n);
        this.checkForAutoPlay();
    }

    @Override
    public void error(int n) {
        this.logger.main().log(-1601830656, "[%1.error] requestType='%2'", (Object)"DVDVideoPlayer", (long)n);
        if (n == 1005) {
            this.dvdPlayerList.unblockAfterSelection();
        }
        super.error(n);
    }

    @Override
    public void rearSeatAudioFocusChanged(boolean bl) {
        super.rearSeatAudioFocusChanged(bl);
        this.checkForAutoPlay();
    }

    @Override
    public void audioFocusChanged(boolean bl) {
        this.logger.main().log(1078071040, "[%1.audioFocusChanged] hasAudioFocus: '%2'", (Object)"DVDVideoPlayer", (Object)bl);
        super.audioFocusChanged(bl);
        this.checkForAutoPlay();
    }

    @Override
    public boolean startSeek(boolean bl) {
        if (this.dvdMenuEntered) {
            this.logger.main().log(1078071040, "[%1.startSeek] dvdMenuEntered -> Block seeking.", (Object)"DVDVideoPlayer");
            this.blockingMaskHandler.showBlockedIcon();
            return false;
        }
        return super.startSeek(bl);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 200676: {
                this.logger.main().log(1078071040, "[%1.keyTyped] DVD_VIDEO_JOYSTICK_VIRTUAL_BUTTON", (Object)"DVDVideoPlayer", (long)n);
                this.getDSIPlayer().executeMenuCmd(2);
                this.getTerminal().getAudioManager().resumeAudio(true);
                break;
            }
            case 200672: {
                this.logger.main().log(1078071040, "[%1.keyTyped] VIDEO_FW_MENU_BUTTON.", (Object)"DVDVideoPlayer", (long)n);
                if (this.blockingMaskHandler.isMenuBlocked()) {
                    return;
                }
                this.getDSIPlayer().executeMenuCmd(1);
                this.getTerminal().getAudioManager().resumeAudio(true);
                this.getModel(-535887104).fireEvent(n3);
                break;
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        this.logger.main().log(1078071040, "[%1.decrement] menu UP on dds turn.", (Object)"DVDVideoPlayer");
        this.executeMenuCommand(3);
    }

    @Override
    public void increment(int n, int n2, int n3) {
        this.logger.main().log(1078071040, "[%1.increment] menu DOWN on dds turn.", (Object)"DVDVideoPlayer");
        this.executeMenuCommand(4);
    }

    @Override
    public void touchPadPositionMoved(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    @Override
    public void touchPadReleased(int n, int n2, int n3) {
    }

    @Override
    public void touchPadPressed(int n, int n2, int n3) {
    }

    @Override
    public void stickN(int n, int n2) {
        this.logger.main().log(1078071040, "[%1.stickN] joystick up pressed.", (Object)"DVDVideoPlayer");
        this.getDSIPlayer().executeMenuCmd(3);
    }

    @Override
    public void stickNW(int n, int n2) {
    }

    @Override
    public void stickW(int n, int n2) {
        this.logger.main().log(1078071040, "[%1.stickW] joystick left pressed.", (Object)"DVDVideoPlayer");
        this.getDSIPlayer().executeMenuCmd(6);
    }

    @Override
    public void stickSW(int n, int n2) {
    }

    @Override
    public void stickS(int n, int n2) {
        this.logger.main().log(1078071040, "[%1.stickS] joystick down pressed.", (Object)"DVDVideoPlayer");
        this.getDSIPlayer().executeMenuCmd(4);
    }

    @Override
    public void stickSE(int n, int n2) {
    }

    @Override
    public void stickE(int n, int n2) {
        this.logger.main().log(1078071040, "[%1.stickE] joystick right pressed.", (Object)"DVDVideoPlayer");
        this.getDSIPlayer().executeMenuCmd(5);
    }

    @Override
    public void stickNE(int n, int n2) {
    }

    @Override
    public void stickIdle(int n, int n2) {
    }

    @Override
    public void touchScreenMoved(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    @Override
    public void touchScreenPressed(int n, int n2, int n3, int n4) {
    }

    @Override
    public void touchScreenLongPressed(int n, int n2, int n3, int n4) {
    }

    @Override
    public void touchScreenReleased(int n, int n2, int n3, int n4) {
    }

    @Override
    public void touchScreenDoubleClick(int n, int n2, int n3, int n4) {
    }

    @Override
    public void touchScreenPinch(int n, float f2, int n2, int n3, int n4) {
    }

    @Override
    public void touchScreenRotate(int n, short s, int n2) {
    }

    @Override
    public void responseCmdBlocked(int n) {
        this.logger.main().log(1078071040, "[%1.responseCmdBlocked] '%2'", (Object)"DVDVideoPlayer", (long)n);
        this.blockingMaskHandler.showBlockedIcon();
        this.notifyPlayerCommandIsBlocked();
    }

    @Override
    public void updateCmdBlockingMask(int n) {
        this.blockingMaskHandler.setBlockingMask(n);
    }

    @Override
    public void slotsChanged(ISource iSource) {
        this.logger.main().log(1078071040, "[%1.slotsChanged]", (Object)"DVDVideoPlayer");
        if (null == this.getActiveSlot()) {
            return;
        }
        ISourceSlot iSourceSlot = iSource.getSlot(this.getActiveSlot());
        if (iSourceSlot == null) {
            return;
        }
        int n = iSourceSlot.getError();
        if (n == 3 && this.previousActiveSlotError != 3) {
            this.pmBlockingHandler.setBlockedByMediumPM(true);
        } else if (n != 3 && this.previousActiveSlotError == 3) {
            this.pmBlockingHandler.setBlockedByMediumPM(false);
        }
        this.previousActiveSlotError = n;
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 30: {
                this.logger.main().log(1078071040, "[%1.actionProxyCallPerformed] AP_METHOD_PLAYER_SEEKTOTIME_ENTER", (Object)"DVDVideoPlayer");
                this.manualSeekHandler.manualSeekModeEnter();
                break;
            }
            case 31: {
                this.logger.main().log(1078071040, "[%1.actionProxyCallPerformed] AP_METHOD_PLAYER_SEEKTOTIME_LEFT", (Object)"DVDVideoPlayer");
                this.manualSeekHandler.manualSeekModeLeave(false);
                break;
            }
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("DVDVideoPlayer").append("@").append(this.hashCode());
        return buffer.toString();
    }

    @Override
    public void playbackFolderChanged(MediaListEntry[] mediaListEntryArray) {
    }

    private void checkForAutoPlay() {
        this.logger.main().log(-2137614336, "[%1.checkForAutoPlay] rearSeatAudioFocus: %2 vehicleMoving: %3 dvdMenuEntered: %4", (Object)"DVDVideoPlayer", (Object)this.rearSeatAudioFocus, (Object)this.moving, (Object)this.dvdMenuEntered);
        if (!this.getTerminal().getAudioManager().hasFrontAudioFocus()) {
            this.logger.main().log(-2137614336, "[%1.checkForAutoPlay] No auto play because of no audio focus.", (Object)"DVDVideoPlayer");
            return;
        }
        if (!this.rearSeatAudioFocus && this.moving && this.dvdMenuEntered) {
            this.logger.main().log(-2137614336, "[%1.checkForAutoPlay] Vehicle moving. Auto play.", (Object)"DVDVideoPlayer");
            if (!this.autoPlayTimer.isRunning()) {
                this.autoPlayTimer.run();
                this.logger.main().log(-2137614336, "[%1.checkForAutoPlay] DVDVideoPlayerAutoPlayTimer: Started.", (Object)"DVDVideoPlayer");
                this.autoPlayTimer.start();
            }
        }
    }

    @Override
    public void fireTimer(Timer timer) {
        this.logger.main().log(-2137614336, "[%1.fireTimer] DVDVideoPlayerAutoPlayTimer: Fired. dvdMenuEntered: %2, vehicleMoving: %3", (Object)"DVDVideoPlayer", (Object)this.dvdMenuEntered, (Object)this.moving);
        if (!this.rearSeatAudioFocus && this.moving && this.dvdMenuEntered && this.isPlaying()) {
            this.logger.main().log(-2137614336, "[%1.fireTimer] DVDVideoPlayerAutoPlayTimer: Execute MENUCMD_MENU_ENTER Command", (Object)"DVDVideoPlayer");
            this.getDSIPlayer().executeMenuCmd(2);
        } else {
            timer.cancel();
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
        this.logger.main().log(-2137614336, "[%1.cancelTimer] DVDVideoPlayerAutoPlayTimer cancelled.", (Object)"DVDVideoPlayer");
    }
}

