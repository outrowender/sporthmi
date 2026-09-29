/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.content.IContent;
import de.audi.app.media.content.media.AbstractMediaPlayer;
import de.audi.app.media.content.media.AbstractVideoFormatSetting;
import de.audi.app.media.content.media.IPlayerTrackListener;
import de.audi.app.media.content.media.ManualSeekHandler;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.content.media.VideoNormSetting;
import de.audi.app.media.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.dsi.media.MediaVideoFormatInternal;
import de.audi.app.media.evo.content.PlaybackModeHandler;
import de.audi.app.media.evo.content.VideoFormatSettingEvo;
import de.audi.app.media.evo.content.data.DataPlayer$1;
import de.audi.app.media.evo.content.data.DataPlayerHMIHandler;
import de.audi.app.media.evo.content.data.DataPlayerPlayViewList;
import de.audi.app.media.evo.content.data.DataPlayerSelectionOnStartup;
import de.audi.app.media.evo.content.data.SDSDataPlayerCommandHandler;
import de.audi.app.media.i18n.I18NString;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.selection.DataSelectionByCategorySeamlessJob;
import de.audi.app.media.selection.DataSelectionContainer;
import de.audi.app.media.selection.IDataSelectionContext;
import de.audi.app.media.selection.IFavoritePlayerSelectionListener;
import de.audi.app.media.selection.ISelectionListener;
import de.audi.app.media.selection.SelectionBrowser;
import de.audi.app.media.source.IActivationContext;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.interapp.phone.ITelServiceMedia;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.Capabilities;

public class DataPlayer
extends AbstractMediaPlayer
implements IPlayerTrackListener,
IActionProxyListener,
IDiagnosisCommandProvider,
ISelectionListener {
    private static final String LOGCLASS;
    private static final byte PLAYING_FILE_TYPE_AUDIO;
    private static final byte PLAYING_FILE_TYPE_VIDEO;
    private static final int MORELIKETHIS_STATE_PROCESSING;
    private static final int MORELIKETHIS_STATE_FINISHED;
    private static final int MORELIKETHIS_STATE_ERROR;
    public static final int MORELIKETHIS_SUCCESSFUL;
    public static final int MORELIKETHIS_NOT_READY;
    public static final int MORELIKETHIS_FAILED;
    private static final String KEY_SELECTIONLISTENER;
    private final AbstractVideoFormatSetting videoFormatSetting;
    private final VideoNormSetting videoNormSetting;
    private final MediaVideoFormatInternal videoFormatInternal;
    private final DataPlayerPlayViewList newPlayViewList;
    private final Object videoMutex = new Object();
    private final DataPlayerHMIHandler hmiHandler;
    private final SDSDataPlayerCommandHandler commandHandler;
    private final IServiceTracker phoneServiceTracker;
    private final ManualSeekHandler manualSeekHandler;
    private boolean isVehicleMoving;
    private volatile ITelServiceMedia phoneService;
    private long ringtoneEntryID;
    private I18NString ringtoneTitle;
    private final Object ringtoneMutex = new Object();
    private volatile int filebasedVideoContext;
    private volatile MediaDetailInfo currentDetailInfo;
    private volatile boolean activatePlayViewOnValidSizeUpdate;
    private volatile boolean iPodWithIAP2;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelServiceMedia;

    public DataPlayer(IMediaTerminal iMediaTerminal, IContent iContent, IMediaDSIPlayerController iMediaDSIPlayerController) {
        super(iMediaTerminal, iContent, iMediaDSIPlayerController, false);
        this.manualSeekHandler = new ManualSeekHandler(iMediaTerminal, this, true);
        this.videoFormatSetting = new VideoFormatSettingEvo(iMediaTerminal, iMediaDSIPlayerController, 1259209472, new int[]{0, 1, 2, 3, 4, 5}, 90);
        this.videoNormSetting = new VideoNormSetting(iMediaTerminal, iMediaDSIPlayerController, 638452480, 100);
        this.videoFormatInternal = new MediaVideoFormatInternal(this.logger.main(), iMediaDSIPlayerController);
        this.newPlayViewList = new DataPlayerPlayViewList(iMediaTerminal, this);
        this.hmiHandler = new DataPlayerHMIHandler(iMediaTerminal, this);
        this.commandHandler = new SDSDataPlayerCommandHandler(this.getTerminal(), this);
        this.hmiHandler.setPlaybackStopped(false);
        this.phoneServiceTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$interapp$phone$ITelServiceMedia == null ? (class$de$audi$atip$interapp$phone$ITelServiceMedia = DataPlayer.class$("de.audi.atip.interapp.phone.ITelServiceMedia")) : class$de$audi$atip$interapp$phone$ITelServiceMedia, new DataPlayer$1(this));
    }

    @Override
    public void init() {
        this.logger.main().log(1078071040, "[%1.init]", (Object)"DataPlayer");
        super.init();
        this.newPlayViewList.init();
        this.hmiHandler.init();
        this.phoneServiceTracker.open();
        this.getTerminal().getDiagnosisManager().addCommandProvider(this.getTerminal().getTerminalID(), this);
        this.getTerminal().getSelectionBrowser().addSelectionListener(this);
    }

    @Override
    public void deinit() {
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"DataPlayer");
        this.getTerminal().getSelectionBrowser().removeSelectionListener(this);
        super.deinit();
        this.newPlayViewList.deinit();
        this.hmiHandler.deinit();
        this.phoneServiceTracker.close();
    }

    @Override
    public void resetSettings() {
        super.resetSettings();
        ISourceSlot iSourceSlot = this.getActiveSlot();
        this.videoFormatSetting.resetSetting(iSourceSlot != null);
        this.videoNormSetting.resetSetting(iSourceSlot != null && iSourceSlot.getMediaType() == 24);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void activate(IActivationContext iActivationContext) {
        this.logger.main().log(1078071040, "[%1.activate]", (Object)"DataPlayer");
        PlaybackModeHandler playbackModeHandler = new PlaybackModeHandler(this.getTerminal(), this, true);
        this.playbackModeHandler = playbackModeHandler;
        this.activatePlayViewOnValidSizeUpdate = false;
        super.activate(iActivationContext, playbackModeHandler);
        int n = (Integer)iActivationContext.getParameter("PHYSICAL_PLAYER_ID");
        switch (n) {
            case 1: {
                this.filebasedVideoContext = 25;
                break;
            }
            default: {
                this.filebasedVideoContext = 26;
            }
        }
        this.setPlayingTrackType(0);
        this.enableVideoDisplayable(false);
        this.setMoreLikeThisState(2);
        this.videoFormatSetting.activate(this.videoFormatInternal);
        this.videoNormSetting.activate();
        Object object = this.videoMutex;
        synchronized (object) {
            this.isVehicleMoving = false;
        }
        this.manualSeekHandler.activate();
        this.getTerminal().addActionProxyListener(new int[]{30, 31}, (IActionProxyListener)this);
        this.addTrackListener(this);
        this.hmiHandler.setPlaybackStopped(false);
        this.iPodWithIAP2 = this.getTerminal().getConfiguration().isIAP2Supported() && iActivationContext.getSlot().getMediaType() == 24;
        this.playbackModeHandler.setResetRepeatTitleOnTrackChange(!this.iPodWithIAP2);
    }

    @Override
    public void deactivate() {
        this.logger.main().log(1078071040, "[%1.deactivate]", (Object)"DataPlayer");
        this.hmiHandler.setPlaybackStopped(false);
        this.manualSeekHandler.deactivate();
        this.getTerminal().removeActionProxyListener(this);
        this.videoFormatSetting.deactivate();
        this.videoNormSetting.deactivate();
        this.enableVideoDisplayable(false);
        this.getTerminal().removeActionProxyListener(this);
        super.deactivate();
        this.hmiHandler.clearTitleData();
        this.invalidateCoverArt();
        this.newPlayViewList.deactivate();
        this.getTerminal().getSDSDispatcher().removeCommandListener(this.getTerminal().getTerminalID(), this.commandHandler);
    }

    protected DataPlayerHMIHandler getHMIHandler() {
        return this.hmiHandler;
    }

    private void enableVideoDisplayable(boolean bl) {
        ISourceSlot iSourceSlot = this.getActiveSlot();
        if (iSourceSlot == null) {
            this.logger.main().log(-2137614336, "[%1.enableVideoDisplayable] Not active.", (Object)"DataPlayer");
            return;
        }
        if (bl) {
            int n = iSourceSlot.getMediaType() == 24 ? 6 : this.filebasedVideoContext;
            this.logger.main().log(-2137614336, "[%1.enableVideoDisplayable] Enable video context '%2'.", (Object)"DataPlayer", (long)n);
            this.getChoiceModel(-686882048).setValue(n);
        } else {
            this.logger.main().log(-2137614336, "[%1.enableVideoDisplayable] Disable video context.", (Object)"DataPlayer");
            this.getChoiceModel(-686882048).setValue(0);
        }
    }

    private void setPlayingTrackType(int n) {
        this.logger.main().log(1078071040, "[%1.setPlayingTrackType] '%2'", (Object)"DataPlayer", (Object)(n == 0 ? "AUDIO" : "VIDEO"));
        this.getChoiceModel(-1106312448).setValue(n);
    }

    private boolean isPlayingVideo() {
        return this.getChoiceModel(-1106312448).getValue() == 1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void vehicleMoving(boolean bl) {
        this.logger.hmi().log(1078071040, "[%2.vehicleMoving] '%1'", bl, (Object)"DataPlayer");
        Object object = this.videoMutex;
        synchronized (object) {
            this.isVehicleMoving = bl;
            if (this.isPlayingVideo()) {
                this.enableVideoDisplayable(!this.isVehicleMoving);
            }
        }
    }

    @Override
    protected void onStartupReadyForPlayback() {
        IActivationContext iActivationContext = this.getActivationContext();
        if (iActivationContext == null) {
            this.logger.main().log(1078071040, "[%1.onStartupReadyForPlayback] Not active.", (Object)"DataPlayer");
            return;
        }
        Integer n = (Integer)iActivationContext.getParameter("SETPLAYSELECTION_BROWSERID");
        if (n == null) {
            super.onStartupReadyForPlayback();
            return;
        }
        this.logger.main().log(1078071040, "[%1.onStartupReadyForPlayback] Use browser instance '%2' for startup.", (Object)"DataPlayer", (Object)n);
        Long l = (Long)iActivationContext.getParameter("SETPLAYSELECTION_TRACKID");
        IFavoritePlayerSelectionListener iFavoritePlayerSelectionListener = (IFavoritePlayerSelectionListener)iActivationContext.getParameter("PLAYER_SELECTION_CALLBACK_HANDLER");
        this.setBrowserPlayerSelection(new DataPlayerSelectionOnStartup(n, l != null ? l : 0L, iFavoritePlayerSelectionListener));
        super.onStartupReadyForPlayback();
    }

    @Override
    protected void playerStartupComplete() {
        this.logger.main().log(1078071040, "[%1.playerStartupComplete]", (Object)"DataPlayer");
        super.playerStartupComplete();
        if (!this.supportsPlayListHandling()) {
            this.logger.main().log(1078071040, "[%1.playerStartupComplete] No play view supported", (Object)"DataPlayer");
            this.getContent().notifyContentActivationFinished();
            return;
        }
        this.logger.main().log(1078071040, "[%1.playerStartupComplete] Activate play view", (Object)"DataPlayer");
        this.tryToActivatePlayView();
        this.getTerminal().getSDSDispatcher().addCommandListener(this.getTerminal().getTerminalID(), this.commandHandler);
    }

    private void invalidateCoverArt() {
        this.logger.hmi().log(1078071040, "[%1.invalidateCoverArt]", (Object)"DataPlayer");
        this.getChoiceModel(-1508900096).setStatus(0);
        this.getResourceLocatorModel(-1123089664).setStatus(0);
        this.getResourceLocatorModel(-1123089664).setResourceLocator(-1, ResourceLocatorModelApp.UNDEFINED_URI, 1);
        this.newPlayViewList.invalidateCoverArt();
    }

    public int playMoreLikeThis() {
        long l = this.getCurrentPlayingTrack().getEntryID();
        this.logger.main().log(1078071040, "[%1.playMoreLikeThis] '%2'", (Object)"DataPlayer", l);
        if (l == -1L) {
            this.logger.main().log(1078071040, "[%1.playMoreLikeThis] No valid entry ID.", (Object)"DataPlayer");
            this.setMoreLikeThisState(3);
            return 3;
        }
        if (this.getMoreLikeThisState() == 1) {
            this.logger.main().log(1078071040, "[%1.playMoreLikeThis] Currently running.", (Object)"DataPlayer");
            return 1;
        }
        this.setMoreLikeThisState(1);
        if (this.getDSIPlayer().playSimilarEntries(l, 20)) {
            return 1;
        }
        this.logger.main().log(1078071040, "[%1.playMoreLikeThis] Failed.", (Object)"DataPlayer");
        this.setMoreLikeThisState(3);
        return 3;
    }

    @Override
    public void responsePlaySimilarEntry(long l, boolean bl) {
        this.logger.main().log(1078071040, "[%2.responsePlaySimilarEntry] result='%1' (entryID='%3')", bl, (Object)"DataPlayer", (Object)String.valueOf(l));
        if (!bl) {
            this.logger.main().log(1078071040, "[%1.responsePlaySimilarEntry] Not successful.", (Object)"DataPlayer");
            this.setMoreLikeThisState(3);
            return;
        }
        if (this.isPaused()) {
            this.getTerminal().getAudioManager().resumeAudio(true);
        }
        this.setMoreLikeThisState(2);
    }

    private void setMoreLikeThisState(int n) {
        ChoiceModelApp choiceModelApp = this.getChoiceModel(-972094720);
        switch (n) {
            case 3: {
                choiceModelApp.setStatus(1);
                choiceModelApp.setValue(-1);
                break;
            }
            case 2: {
                choiceModelApp.setStatus(1);
                choiceModelApp.setValue(1);
                break;
            }
            default: {
                choiceModelApp.setStatus(0);
                choiceModelApp.setValue(0);
            }
        }
    }

    private int getMoreLikeThisState() {
        ChoiceModelApp choiceModelApp = this.getChoiceModel(-972094720);
        if (choiceModelApp.getStatus() == 0) {
            return 1;
        }
        if (choiceModelApp.getValue() > 0) {
            return 2;
        }
        return 3;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean setTitleAsRingtone(long l, I18NString i18NString) {
        this.logger.main().log(1078071040, "[%1.setTitleAsRingtone]", (Object)"DataPlayer");
        ISourceSlot iSourceSlot = this.getTerminal().getSourceController().getSelectedSlot();
        if (iSourceSlot == null || !iSourceSlot.getFlags().isMetaDataSyncComplete()) {
            this.logger.main().log(1078071040, "[%1.setTitleAsRingtone] Source not active or Sync not complete.", (Object)"DataPlayer");
            return false;
        }
        Object object = this.ringtoneMutex;
        synchronized (object) {
            this.ringtoneEntryID = l;
            this.ringtoneTitle = i18NString;
        }
        if (this.getDSIPlayer().requestFullQualifiedName(l)) {
            this.getChoiceModel(-854654208).setValue(0);
            this.getChoiceModel(-854654208).setStatus(0);
            return true;
        }
        this.getChoiceModel(-854654208).setValue(2);
        this.getChoiceModel(-854654208).setStatus(2);
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void responseFullyQualifiedName(long l, String string) {
        this.logger.main().log(1078071040, "[%1.responseFullyQualifiedName] entryID='%3', path='%2'", (Object)"DataPlayer", (Object)string, l);
        ITelServiceMedia iTelServiceMedia = this.phoneService;
        if (iTelServiceMedia == null) {
            this.logger.main().log(1078071040, "[%1.responseFullyQualifiedName] Phone service not available.", (Object)"DataPlayer");
            this.getChoiceModel(-854654208).setValue(2);
            this.getChoiceModel(-854654208).setStatus(2);
            return;
        }
        Object object = this.ringtoneMutex;
        synchronized (object) {
            if (this.ringtoneEntryID != l) {
                this.logger.main().log(1078071040, "[%1.responseFullyQualifiedName] Belongs not to the ringtone entryID.", (Object)"DataPlayer");
                this.getChoiceModel(-854654208).setValue(2);
                this.getChoiceModel(-854654208).setStatus(2);
                return;
            }
            iTelServiceMedia.setUserDefinedRingtone(string, this.ringtoneTitle.getI18NString());
        }
        this.getChoiceModel(-854654208).setValue(1);
        this.getChoiceModel(-854654208).setStatus(1);
    }

    @Override
    public void updateVideoFormat(int n) {
        this.videoFormatSetting.setActiveVideoFormat(n);
    }

    @Override
    public void updateVideoNorm(int n) {
        this.videoNormSetting.setActiveVideoNorm(n);
    }

    @Override
    public void updateCapabilities(Capabilities capabilities) {
        ISourceSlot iSourceSlot = this.getActiveSlot();
        if (iSourceSlot == null) {
            return;
        }
        super.updateCapabilities(capabilities);
        if (this.supportsVideoPlayback()) {
            this.logger.main().log(1078071040, "[%1.updateCapabilities] Video playback supported.", (Object)"DataPlayer");
            this.videoFormatSetting.restoreSetting();
            if (iSourceSlot.getMediaType() == 24) {
                this.videoNormSetting.restoreSetting();
            }
        }
        if (this.supportsPlaySimilar()) {
            this.logger.main().log(1078071040, "[%1.updateCapabilities] MoreLikeThis supported.", (Object)"DataPlayer");
            this.getTerminal().addActionProxyListener(21, (IActionProxyListener)this);
        }
        this.tryToActivatePlayView();
    }

    @Override
    public void updatePlayViewSize(int n, int n2) {
        this.logger.main().log(1078071040, "[%1.updatePlayViewSize]", (Object)"DataPlayer");
        super.updatePlayViewSize(n, n2);
        if (this.activatePlayViewOnValidSizeUpdate) {
            this.tryToActivatePlayView();
        }
    }

    private void tryToActivatePlayView() {
        if (this.isOnStartup()) {
            this.logger.main().log(1078071040, "[%1.tryToActivatePlayView] On startup - ignore.", (Object)"DataPlayer");
            return;
        }
        if (this.supportsPlayListHandling()) {
            if (this.isPlayViewSizeValid()) {
                this.logger.main().log(1078071040, "[%1.tryToActivatePlayView] playview supported and size is valid. Activate playviewlist.", (Object)"DataPlayer");
                this.activatePlayViewOnValidSizeUpdate = false;
                this.newPlayViewList.activate();
            } else {
                this.logger.main().log(1078071040, "[%1.tryToActivatePlayView] playview is supported but size is invalid. Delay the activation.", (Object)"DataPlayer");
                this.activatePlayViewOnValidSizeUpdate = true;
            }
        } else {
            this.logger.main().log(1078071040, "[%1.tryToActivatePlayView] playview is not supported. Deactivate playview.", (Object)"DataPlayer");
            this.newPlayViewList.deactivate();
            this.activatePlayViewOnValidSizeUpdate = false;
        }
    }

    @Override
    public void updatePlaybackState(int n) {
        this.logger.main().log(1078071040, "[%1.updatePlaybackState]", (Object)"DataPlayer");
        super.updatePlaybackState(n);
        if (this.iPodWithIAP2) {
            if (4 == n) {
                this.logger.main().log(1078071040, "[%1.updatePlaybackState] PlaybackState: STOPPED", (Object)"DataPlayer");
                this.hmiHandler.setPlaybackStopped(true);
                return;
            }
            this.logger.main().log(1078071040, "[%1.updatePlaybackState] PlaybackState: NOT STOPPED", (Object)"DataPlayer");
            this.hmiHandler.setPlaybackStopped(false);
        }
    }

    @Override
    public void playPositionInvalidated() {
        ISourceSlot iSourceSlot = this.getActiveSlot();
        if (iSourceSlot != null && (iSourceSlot.getMediaType() == 24 || iSourceSlot.getSource().getType() == 11)) {
            super.playPositionInvalidated();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        this.logger.main().log(1078071040, "[%1.detailInfoChanged]", (Object)"DataPlayer");
        this.currentDetailInfo = mediaDetailInfo;
        if (this.supportsVideoPlayback() && mediaDetailInfo.getContentType() == 2 && !mediaDetailInfo.isCorrupt()) {
            Object object = this.videoMutex;
            synchronized (object) {
                this.setPlayingTrackType(1);
                this.enableVideoDisplayable(!this.isVehicleMoving);
            }
            this.hmiHandler.setTitleData(mediaDetailInfo.getTitle(), mediaDetailInfo.getFilename(), mediaDetailInfo.getAlbum(), mediaDetailInfo.getArtist(), mediaDetailInfo.isChapterAvailable(), mediaDetailInfo.getActiveChapter(), mediaDetailInfo.getNumChapters());
        } else {
            this.hmiHandler.setTitleData(mediaDetailInfo.getTitle(), mediaDetailInfo.getFilename(), mediaDetailInfo.getAlbum(), mediaDetailInfo.getArtist(), mediaDetailInfo.isChapterAvailable(), mediaDetailInfo.getActiveChapter(), mediaDetailInfo.getNumChapters());
            Object object = this.videoMutex;
            synchronized (object) {
                this.setPlayingTrackType(0);
                this.enableVideoDisplayable(false);
            }
        }
        if (this.getActiveSlot().getSource().getType() == 0 || this.getActiveSlot().getSource().getType() == 1 || this.getActiveSlot().getSource().getType() == 2 || this.getActiveSlot().getSource().getType() == 3) {
            this.logNewTrackTitleToSerialPort(mediaDetailInfo.getTitle());
        }
    }

    @Override
    public void trackChanged(boolean bl, boolean bl2, PlayingTrack playingTrack, PlayTime playTime) {
        if (this.setPlaytimeInModel()) {
            this.hmiHandler.setPlayTime(playTime.getRestrictedPlayTimeStr(), playTime.getRemainTimeStr(), playTime.getProgress());
            if (bl && this.supportsCoverart()) {
                this.invalidateCoverArt();
            }
        }
    }

    @Override
    public void coverArtChanged(ResourceLocator resourceLocator) {
        this.logger.hmi().log(1078071040, "[%1.coverArtChanged] '%2'", (Object)"DataPlayer", (Object)resourceLocator);
        int n = resourceLocator == null ? -1 : resourceLocator.getId();
        String string = resourceLocator == null ? ResourceLocatorModelApp.UNDEFINED_URI : resourceLocator.getUrl();
        this.getResourceLocatorModel(-1123089664).setResourceLocator(n, string, 0);
        this.getChoiceModel(-1508900096).setStatus(1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void playEntry(long l, I18NString i18NString, boolean bl) {
        this.logger.main().log(1078071040, "[%1.playEntry] entryID='%2',title='%3'", (Object)"DataPlayer", (Object)String.valueOf(l), (Object)i18NString);
        PlayingTrack playingTrack = this.getCurrentPlayingTrack();
        this.playEntry(l);
        if (playingTrack.getEntryID() != l) {
            this.logger.hmi().log(-2137614336, "[%1.playEntry] Change track.", (Object)"DataPlayer");
            Object object = this.videoMutex;
            synchronized (object) {
                this.enableVideoDisplayable(false);
                this.setPlayingTrackType(bl ? 1 : 0);
            }
            this.hmiHandler.setTitleData(i18NString, i18NString, new I18NString("", false), new I18NString("", false), false, 0, 0);
            this.hmiHandler.setPlayTime("-:-", "-:-", 0);
            this.invalidateCoverArt();
        }
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 21: {
                this.logger.main().log(1078071040, "[%1.actionProxyCallPerformed] AP_METHOD_PLAYER_MORELIKETHIS_ERROR_LEAVED", (Object)"DataPlayer");
                this.setMoreLikeThisState(2);
                break;
            }
            case 30: {
                this.logger.main().log(1078071040, "[%1.actionProxyCallPerformed] AP_METHOD_PLAYER_SEEKTOTIME_ENTER", (Object)"DataPlayer");
                this.manualSeekHandler.manualSeekModeEnter();
                break;
            }
            case 31: {
                this.logger.main().log(1078071040, "[%1.actionProxyCallPerformed] AP_METHOD_PLAYER_SEEKTOTIME_LEFT", (Object)"DataPlayer");
                this.manualSeekHandler.manualSeekModeLeave(false);
                break;
            }
        }
    }

    @Override
    public void playMoreOf(long l, int n, ISelectionListener iSelectionListener) {
        if (l != this.currentDetailInfo.getEntryID()) {
            this.logger.main().log(-1601830656, "[%1.playMoreOf] currentEntryId is not currentPlaying track", (Object)"DataPlayer");
            if (null != iSelectionListener) {
                iSelectionListener.notifySelectionChanged(null, false);
            }
            return;
        }
        this.logger.main().log(1078071040, "[%1.playMoreOf]", (Object)"DataPlayer");
        MediaListEntry mediaListEntry = new MediaListEntry(l, this.currentDetailInfo.getContentType(), this.currentDetailInfo.getFilename().getOriginalString());
        DataSelectionContainer dataSelectionContainer = new DataSelectionContainer(this.getActiveSlot(), mediaListEntry, n, this.currentDetailInfo);
        SelectionBrowser selectionBrowser = this.getTerminal().getSelectionBrowser();
        if (iSelectionListener != null) {
            dataSelectionContainer.addParameter("SELECTION_LISTENER", iSelectionListener);
        }
        DataSelectionByCategorySeamlessJob dataSelectionByCategorySeamlessJob = new DataSelectionByCategorySeamlessJob(this.logger.main(), selectionBrowser, dataSelectionContainer, this);
        selectionBrowser.enqueueSelectionJob(dataSelectionByCategorySeamlessJob);
    }

    @Override
    public boolean supportsPlayMoreOf() {
        return this.getActiveSlot().getMediaType() == 24 || this.getActiveSlot().getCapabilities().isContentBrowsing() && this.getActiveSlot().getFlags().isMetaDataSyncComplete();
    }

    @Override
    public void notifySelectionChanged(IDataSelectionContext iDataSelectionContext, boolean bl) {
        if (null == iDataSelectionContext) {
            return;
        }
        ISelectionListener iSelectionListener = (ISelectionListener)iDataSelectionContext.getParameter("SELECTION_LISTENER", null);
        if (iSelectionListener != null) {
            this.logger.main().log(1078071040, "[%1.notifySelectionChanged]", (Object)"DataPlayer");
            iSelectionListener.notifySelectionChanged(iDataSelectionContext, bl);
        }
    }

    @Override
    public String[] getDiagKeys() {
        return new String[]{"DataPlayer.setPlayPosition(int)", "DataPlayer.startSeek(boolean)", "DataPlayer.stopSeek"};
    }

    @Override
    public void executeDiagCommand(String string, String[] stringArray) {
        if ("DataPlayer.startSeek(boolean)".equals(string)) {
            if (stringArray.length != 1) {
                return;
            }
            this.startSeek(Boolean.valueOf(stringArray[0]));
        } else if ("DataPlayer.stopSeek".equals(string)) {
            this.stopSeek(true);
        } else if ("DataPlayer.setPlayPosition(int)".equals(string)) {
            if (stringArray.length != 1) {
                return;
            }
            this.setPlayPosition(new Integer(stringArray[0]));
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("DataPlayer").append("@").append(this.hashCode());
        return buffer.toString();
    }

    @Override
    public void playbackFolderChanged(MediaListEntry[] mediaListEntryArray) {
    }

    @Override
    protected void setNoPlayableFiles() {
        this.logger.main().log(1078071040, "[%1.setNoPlayableFiles]", (Object)"DataPlayer");
        this.newPlayViewList.getPlayableFilesAvailableModel().setValue(0);
        this.getContent().notifyContentActivationFinished();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ ITelServiceMedia access$002(DataPlayer dataPlayer, ITelServiceMedia iTelServiceMedia) {
        dataPlayer.phoneService = iTelServiceMedia;
        return dataPlayer.phoneService;
    }

    static /* synthetic */ IMediaLogger access$100(DataPlayer dataPlayer) {
        return dataPlayer.logger;
    }

    static /* synthetic */ IMediaLogger access$200(DataPlayer dataPlayer) {
        return dataPlayer.logger;
    }

    static /* synthetic */ ITelServiceMedia access$000(DataPlayer dataPlayer) {
        return dataPlayer.phoneService;
    }
}

