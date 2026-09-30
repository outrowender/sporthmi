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
    private static final String LOGCLASS = "DVDVideoPlayer";
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
        this.settingsAudioStream = new DVDVideoSettingsAudioStream(iMediaTerminal, iMediaDSIPlayerController, this.getBaseListModel(201041), this.getChoiceModel(200691), this.getChoiceModel(200801), this.getChoiceModel(200802), this.getChoiceModel(200761));
        this.settingsSubtitle = new DVDVideoSettingsSubtitle(iMediaTerminal, iMediaDSIPlayerController, this.getBaseListModel(201043), this.getChoiceModel(201042), this.getLabelModel(201040));
        this.settingsVideoFormat = new VideoFormatSettingEvo(iMediaTerminal, iMediaDSIPlayerController, 200267, new int[]{0, 1, 2, 3, 4, 5}, 170);
        this.dvdPlayerList = new DVDVideoPlayerViewList(iMediaTerminal, this);
        this.blockingMaskHandler = new BlockingMaskHandler(iMediaTerminal);
        this.trackTimeModelGroup = new ModelGroup();
        this.autoPlayTimer = new Timer("DVDVideoPlayerAutoPlayTimer", 3000L, false, this);
    }

    public void init() {
        this.logger.main().log(1000000, "[%1.init]", (Object)LOGCLASS);
        super.init();
        this.dvdPlayerList.init();
        this.getVirtualButtonModelModel(200676).setVirtualButtonListener(this);
        this.getButtonModel(200672).setButtonListener(this);
        this.getVirtualButtonModelModel(200880).setVirtualButtonListener(this);
        RangeModelApp rangeModelApp = this.getRangeModel(200687);
        rangeModelApp.setLimits(0, 100, 1);
        rangeModelApp.setValue(0);
        this.trackTimeModelGroup.add(this.getModel(200686));
        this.trackTimeModelGroup.add(this.getModel(200689));
        this.trackTimeModelGroup.add(rangeModelApp);
    }

    public void deinit() {
        this.logger.main().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        super.deinit();
        this.dvdPlayerList.deinit();
        this.getVirtualButtonModelModel(200676).setVirtualButtonListener(null);
        this.getButtonModel(200672).setButtonListener(null);
        this.getVirtualButtonModelModel(200880).setVirtualButtonListener(null);
        this.trackTimeModelGroup.removeAll();
    }

    public void resetSettings() {
        this.settingsVideoFormat.resetSetting(this.getActiveSlot() != null);
    }

    public void activate(IActivationContext iActivationContext) {
        this.logger.main().log(1000000, "[%1.activate]", (Object)LOGCLASS);
        EmptyPlaybackModeHandler emptyPlaybackModeHandler = new EmptyPlaybackModeHandler(this.getTerminal(), this, true);
        super.activate(iActivationContext, emptyPlaybackModeHandler);
        this.getChoiceModel(200823).setValue(0);
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

    public void deactivate() {
        this.logger.main().log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
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
        this.getChoiceModel(200823).setValue(0);
        this.dvdPlayerList.deactivate();
    }

    private void clearDetailInfo() {
        this.logger.main().log(1000000, "[%1.clearDetailInfo]", (Object)LOGCLASS);
        this.getLabelModel(200682).setText("");
        this.getChoiceModel(200683).setValue(0);
    }

    public void vehicleMoving(boolean bl) {
        this.logger.main().log(1000000, "[%2.vehicleMoving] '%1'.", bl, (Object)LOGCLASS);
        this.moving = bl;
        this.enableDisplayable(!bl);
        this.checkForAutoPlay();
    }

    private void enableDisplayable(boolean bl) {
        this.logger.hmi().log(1000000, "[%2.enableDisplayable] '%1'.", bl, (Object)LOGCLASS);
        if (bl) {
            this.getChoiceModel(200664).setValue(this.hmiDisplayContext);
        } else {
            this.getChoiceModel(200664).setValue(0);
        }
    }

    public void touchEvent(int n, int n2, int n3) {
        if (this.logger.main().isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append("'").append(n).append("','(").append(n2).append(",").append(n3).append("'");
            this.logger.main().log(1000000, "[%1.touchEvent] %2", (Object)LOGCLASS, (Object)buffer);
        }
        this.getDSIPlayer().touchEvent(n == 0 ? 0 : 1, n2, n3);
    }

    public void executeMenuCommand(int n) {
        this.logger.main().log(1000000, "[%1.executeDVDCommand] command=%2", (Object)LOGCLASS, (long)n);
        this.getDSIPlayer().executeMenuCmd(n);
        if (n == 1) {
            if (this.getTerminal().getAudioManager().hasFrontAudioFocus()) {
                this.getTerminal().getAudioManager().resumeAudio(true);
            } else {
                this.resume();
            }
        }
    }

    protected void playerStartupComplete() {
        this.logger.main().log(1000000, "[%1.playerStartupComplete]", (Object)LOGCLASS);
        super.playerStartupComplete();
        this.logger.main().log(1000000, "[%1.playerStartupComplete] Activate play view", (Object)LOGCLASS);
        this.dvdPlayerList.activate();
    }

    protected final boolean supportsPlaymodes() {
        return this.capabilities.playbackModes;
    }

    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        this.getLabelModel(200682).setText(mediaDetailInfo.getTitle().getI18NString());
        this.getChoiceModel(200683).setValue(mediaDetailInfo.getTitle().getI18NKey());
    }

    public void trackChanged(boolean bl, boolean bl2, PlayingTrack playingTrack, PlayTime playTime) {
        this.getLabelModel(200686).setText(playTime.getRestrictedPlayTimeStr());
        this.getLabelModel(200689).setText(playTime.getRemainTimeStr());
        this.getRangeModel(200687).setValue(playTime.getProgress());
        this.trackTimeModelGroup.flush();
    }

    public void coverArtChanged(ResourceLocator resourceLocator) {
    }

    public void updateSubtitleList(int[] nArray) {
        this.logger.dsi().log(1000000, "[%1.updateSubtitleList]", (Object)LOGCLASS);
        this.settingsSubtitle.updateSubtitleList(nArray);
    }

    public void updateActiveSubtitle(int n) {
        this.logger.dsi().log(1000000, "[%1.updateAudioSubtitle] '%2'", (Object)LOGCLASS, (long)n);
        this.settingsSubtitle.updateActiveSubtitle(n);
    }

    public void setSubtitleLanguage(int n) {
        this.getDSIPlayer().setSubtitleLanguage(n);
    }

    public void updateAudioStreamList(AudioStream[] audioStreamArray) {
        this.logger.dsi().log(1000000, "[%1.updateAudioStreamList]", (Object)LOGCLASS);
        this.settingsAudioStream.updateAudioStreamList(audioStreamArray);
    }

    public void updateActiveAudioStream(int n) {
        this.logger.dsi().log(1000000, "[%1.updateActiveAudioStream] '%2'", (Object)LOGCLASS, (long)n);
        this.settingsAudioStream.updateActiveAudioStream(n);
    }

    public void setAudioStream(int n) {
        this.getDSIPlayer().setAudioStream(n);
    }

    public void updateVideoFormat(int n) {
        this.logger.main().log(1000000, "[%1.updateVideoFormat] '%2'", (Object)LOGCLASS, (long)n);
        this.settingsVideoFormat.setActiveVideoFormat(n);
    }

    public void responseTempPMLRequest(int n) {
        this.logger.main().log(1000000, "[%1.responseTempPMLRequest] '%2'", (Object)LOGCLASS, (long)n);
        super.responseTempPMLRequest(n);
        this.pmBlockingHandler.setBlockedByTempPM(n);
    }

    public void denyTempPMLRequest() {
        this.logger.main().log(1000000, "[%1.denyTempPMLRequest]", (Object)LOGCLASS);
        this.getDSIPlayer().denyTempPMLRequest();
    }

    public void updatePMLBlock(boolean bl) {
        this.logger.main().log(1000000, "[%1.updatePMLBlock] '%2'", (Object)LOGCLASS, (Object)bl);
        this.pmBlockingHandler.setBlockedByMediumPM(bl);
    }

    public void indicationDvdEvent(int n) {
        super.indicationDvdEvent(n);
        if (n == 1) {
            this.dvdMenuEntered = true;
            this.logger.main().log(10000000, "[%1.indicationDvdEvent] DVDEVENT_MENU_SELECTION.", (Object)LOGCLASS);
        } else {
            this.logger.main().log(10000000, "[%1.indicationDvdEvent] DVDEVENT_MENU_SELECTION leaved.", (Object)LOGCLASS);
            this.dvdMenuEntered = false;
        }
        this.logger.main().log(10000000, "[%1.indicationDvdEvent] DVD_EVENT: %2", (Object)LOGCLASS, (long)n);
        this.checkForAutoPlay();
    }

    public void error(int n) {
        this.logger.main().log(100000, "[%1.error] requestType='%2'", (Object)LOGCLASS, (long)n);
        if (n == 1005) {
            this.dvdPlayerList.unblockAfterSelection();
        }
        super.error(n);
    }

    public void rearSeatAudioFocusChanged(boolean bl) {
        super.rearSeatAudioFocusChanged(bl);
        this.checkForAutoPlay();
    }

    public void audioFocusChanged(boolean bl) {
        this.logger.main().log(1000000, "[%1.audioFocusChanged] hasAudioFocus: '%2'", (Object)LOGCLASS, (Object)bl);
        super.audioFocusChanged(bl);
        this.checkForAutoPlay();
    }

    public boolean startSeek(boolean bl) {
        if (this.dvdMenuEntered) {
            this.logger.main().log(1000000, "[%1.startSeek] dvdMenuEntered -> Block seeking.", (Object)LOGCLASS);
            this.blockingMaskHandler.showBlockedIcon();
            return false;
        }
        return super.startSeek(bl);
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 200676: {
                this.logger.main().log(1000000, "[%1.keyTyped] DVD_VIDEO_JOYSTICK_VIRTUAL_BUTTON", (Object)LOGCLASS, (long)n);
                this.getDSIPlayer().executeMenuCmd(2);
                this.getTerminal().getAudioManager().resumeAudio(true);
                break;
            }
            case 200672: {
                this.logger.main().log(1000000, "[%1.keyTyped] VIDEO_FW_MENU_BUTTON.", (Object)LOGCLASS, (long)n);
                if (this.blockingMaskHandler.isMenuBlocked()) {
                    return;
                }
                this.getDSIPlayer().executeMenuCmd(1);
                this.getTerminal().getAudioManager().resumeAudio(true);
                this.getModel(200672).fireEvent(n3);
                break;
            }
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void decrement(int n, int n2, int n3) {
        this.logger.main().log(1000000, "[%1.decrement] menu UP on dds turn.", (Object)LOGCLASS);
        this.executeMenuCommand(3);
    }

    public void increment(int n, int n2, int n3) {
        this.logger.main().log(1000000, "[%1.increment] menu DOWN on dds turn.", (Object)LOGCLASS);
        this.executeMenuCommand(4);
    }

    public void touchPadPositionMoved(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    public void touchPadReleased(int n, int n2, int n3) {
    }

    public void touchPadPressed(int n, int n2, int n3) {
    }

    public void stickN(int n, int n2) {
        this.logger.main().log(1000000, "[%1.stickN] joystick up pressed.", (Object)LOGCLASS);
        this.getDSIPlayer().executeMenuCmd(3);
    }

    public void stickNW(int n, int n2) {
    }

    public void stickW(int n, int n2) {
        this.logger.main().log(1000000, "[%1.stickW] joystick left pressed.", (Object)LOGCLASS);
        this.getDSIPlayer().executeMenuCmd(6);
    }

    public void stickSW(int n, int n2) {
    }

    public void stickS(int n, int n2) {
        this.logger.main().log(1000000, "[%1.stickS] joystick down pressed.", (Object)LOGCLASS);
        this.getDSIPlayer().executeMenuCmd(4);
    }

    public void stickSE(int n, int n2) {
    }

    public void stickE(int n, int n2) {
        this.logger.main().log(1000000, "[%1.stickE] joystick right pressed.", (Object)LOGCLASS);
        this.getDSIPlayer().executeMenuCmd(5);
    }

    public void stickNE(int n, int n2) {
    }

    public void stickIdle(int n, int n2) {
    }

    public void touchScreenMoved(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    public void touchScreenPressed(int n, int n2, int n3, int n4) {
    }

    public void touchScreenLongPressed(int n, int n2, int n3, int n4) {
    }

    public void touchScreenReleased(int n, int n2, int n3, int n4) {
    }

    public void touchScreenDoubleClick(int n, int n2, int n3, int n4) {
    }

    public void touchScreenPinch(int n, float f2, int n2, int n3, int n4) {
    }

    public void touchScreenRotate(int n, short s, int n2) {
    }

    public void responseCmdBlocked(int n) {
        this.logger.main().log(1000000, "[%1.responseCmdBlocked] '%2'", (Object)LOGCLASS, (long)n);
        this.blockingMaskHandler.showBlockedIcon();
        this.notifyPlayerCommandIsBlocked();
    }

    public void updateCmdBlockingMask(int n) {
        this.blockingMaskHandler.setBlockingMask(n);
    }

    public void slotsChanged(ISource iSource) {
        this.logger.main().log(1000000, "[%1.slotsChanged]", (Object)LOGCLASS);
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

    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 30: {
                this.logger.main().log(1000000, "[%1.actionProxyCallPerformed] AP_METHOD_PLAYER_SEEKTOTIME_ENTER", (Object)LOGCLASS);
                this.manualSeekHandler.manualSeekModeEnter();
                break;
            }
            case 31: {
                this.logger.main().log(1000000, "[%1.actionProxyCallPerformed] AP_METHOD_PLAYER_SEEKTOTIME_LEFT", (Object)LOGCLASS);
                this.manualSeekHandler.manualSeekModeLeave(false);
                break;
            }
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }

    public void playbackFolderChanged(MediaListEntry[] mediaListEntryArray) {
    }

    private void checkForAutoPlay() {
        this.logger.main().log(10000000, "[%1.checkForAutoPlay] rearSeatAudioFocus: %2 vehicleMoving: %3 dvdMenuEntered: %4", (Object)LOGCLASS, (Object)this.rearSeatAudioFocus, (Object)this.moving, (Object)this.dvdMenuEntered);
        if (!this.getTerminal().getAudioManager().hasFrontAudioFocus()) {
            this.logger.main().log(10000000, "[%1.checkForAutoPlay] No auto play because of no audio focus.", (Object)LOGCLASS);
            return;
        }
        if (!this.rearSeatAudioFocus && this.moving && this.dvdMenuEntered) {
            this.logger.main().log(10000000, "[%1.checkForAutoPlay] Vehicle moving. Auto play.", (Object)LOGCLASS);
            if (!this.autoPlayTimer.isRunning()) {
                this.autoPlayTimer.run();
                this.logger.main().log(10000000, "[%1.checkForAutoPlay] DVDVideoPlayerAutoPlayTimer: Started.", (Object)LOGCLASS);
                this.autoPlayTimer.start();
            }
        }
    }

    public void fireTimer(Timer timer) {
        this.logger.main().log(10000000, "[%1.fireTimer] DVDVideoPlayerAutoPlayTimer: Fired. dvdMenuEntered: %2, vehicleMoving: %3", (Object)LOGCLASS, (Object)this.dvdMenuEntered, (Object)this.moving);
        if (!this.rearSeatAudioFocus && this.moving && this.dvdMenuEntered && this.isPlaying()) {
            this.logger.main().log(10000000, "[%1.fireTimer] DVDVideoPlayerAutoPlayTimer: Execute MENUCMD_MENU_ENTER Command", (Object)LOGCLASS);
            this.getDSIPlayer().executeMenuCmd(2);
        } else {
            timer.cancel();
        }
    }

    public void cancelTimer(Timer timer) {
        this.logger.main().log(10000000, "[%1.cancelTimer] DVDVideoPlayerAutoPlayTimer cancelled.", (Object)LOGCLASS);
    }
}

