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
import de.audi.app.media.evo.content.data.DataPlayerHMIHandler;
import de.audi.app.media.evo.content.data.DataPlayerPlayViewList;
import de.audi.app.media.evo.content.data.DataPlayerSelectionOnStartup;
import de.audi.app.media.evo.content.data.SDSDataPlayerCommandHandler;
import de.audi.app.media.i18n.I18NString;
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
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class DataPlayer
extends AbstractMediaPlayer
implements IPlayerTrackListener,
IActionProxyListener,
IDiagnosisCommandProvider,
ISelectionListener {
    private static final String LOGCLASS = "DataPlayer";
    private static final byte PLAYING_FILE_TYPE_AUDIO = 0;
    private static final byte PLAYING_FILE_TYPE_VIDEO = 1;
    private static final int MORELIKETHIS_STATE_PROCESSING = 1;
    private static final int MORELIKETHIS_STATE_FINISHED = 2;
    private static final int MORELIKETHIS_STATE_ERROR = 3;
    public static final int MORELIKETHIS_SUCCESSFUL = 1;
    public static final int MORELIKETHIS_NOT_READY = 2;
    public static final int MORELIKETHIS_FAILED = 3;
    private static final String KEY_SELECTIONLISTENER = "SELECTION_LISTENER";
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
        this.videoFormatSetting = new VideoFormatSettingEvo(iMediaTerminal, iMediaDSIPlayerController, 200267, new int[]{0, 1, 2, 3, 4, 5}, 90);
        this.videoNormSetting = new VideoNormSetting(iMediaTerminal, iMediaDSIPlayerController, 200230, 100);
        this.videoFormatInternal = new MediaVideoFormatInternal(this.logger.main(), iMediaDSIPlayerController);
        this.newPlayViewList = new DataPlayerPlayViewList(iMediaTerminal, this);
        this.hmiHandler = new DataPlayerHMIHandler(iMediaTerminal, this);
        this.commandHandler = new SDSDataPlayerCommandHandler(this.getTerminal(), this);
        this.hmiHandler.setPlaybackStopped(false);
        this.phoneServiceTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$interapp$phone$ITelServiceMedia == null ? (class$de$audi$atip$interapp$phone$ITelServiceMedia = DataPlayer.class$("de.audi.atip.interapp.phone.ITelServiceMedia")) : class$de$audi$atip$interapp$phone$ITelServiceMedia, new ServiceTrackerCustomizer(){

            public void removedService(ServiceReference serviceReference, Object object) {
                DataPlayer.this.phoneService = null;
                ChoiceModelApp choiceModelApp = DataPlayer.this.getChoiceModel(200652);
                if (choiceModelApp != null) {
                    choiceModelApp.setValue(0);
                } else {
                    DataPlayer.this.logger.main().log(100000, "[%1.removedService] Failed to reset choice model: 'DATA_PLAYER_RINGTONE_AVAILABLE_CHOICE'.", (Object)DataPlayer.LOGCLASS);
                }
                DataPlayer.this.getTerminal().getServiceManager().releaseService(serviceReference);
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public Object addingService(ServiceReference serviceReference) {
                DataPlayer.this.logger.main().log(1000000, "[%1.addingService] Phone service found.", (Object)DataPlayer.LOGCLASS);
                DataPlayer.this.phoneService = (ITelServiceMedia)DataPlayer.this.getTerminal().getServiceManager().getService(serviceReference);
                DataPlayer.this.getChoiceModel(200652).setValue(1);
                return DataPlayer.this.phoneService;
            }
        });
    }

    public void init() {
        this.logger.main().log(1000000, "[%1.init]", (Object)LOGCLASS);
        super.init();
        this.newPlayViewList.init();
        this.hmiHandler.init();
        this.phoneServiceTracker.open();
        this.getTerminal().getDiagnosisManager().addCommandProvider(this.getTerminal().getTerminalID(), this);
        this.getTerminal().getSelectionBrowser().addSelectionListener(this);
    }

    public void deinit() {
        this.logger.main().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.getTerminal().getSelectionBrowser().removeSelectionListener(this);
        super.deinit();
        this.newPlayViewList.deinit();
        this.hmiHandler.deinit();
        this.phoneServiceTracker.close();
    }

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
        this.logger.main().log(1000000, "[%1.activate]", (Object)LOGCLASS);
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

    public void deactivate() {
        this.logger.main().log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
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
            this.logger.main().log(10000000, "[%1.enableVideoDisplayable] Not active.", (Object)LOGCLASS);
            return;
        }
        if (bl) {
            int n = iSourceSlot.getMediaType() == 24 ? 6 : this.filebasedVideoContext;
            this.logger.main().log(10000000, "[%1.enableVideoDisplayable] Enable video context '%2'.", (Object)LOGCLASS, (long)n);
            this.getChoiceModel(200663).setValue(n);
        } else {
            this.logger.main().log(10000000, "[%1.enableVideoDisplayable] Disable video context.", (Object)LOGCLASS);
            this.getChoiceModel(200663).setValue(0);
        }
    }

    private void setPlayingTrackType(int n) {
        this.logger.main().log(1000000, "[%1.setPlayingTrackType] '%2'", (Object)LOGCLASS, (Object)(n == 0 ? "AUDIO" : "VIDEO"));
        this.getChoiceModel(200638).setValue(n);
    }

    private boolean isPlayingVideo() {
        return this.getChoiceModel(200638).getValue() == 1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void vehicleMoving(boolean bl) {
        this.logger.hmi().log(1000000, "[%2.vehicleMoving] '%1'", bl, (Object)LOGCLASS);
        Object object = this.videoMutex;
        synchronized (object) {
            this.isVehicleMoving = bl;
            if (this.isPlayingVideo()) {
                this.enableVideoDisplayable(!this.isVehicleMoving);
            }
        }
    }

    protected void onStartupReadyForPlayback() {
        IActivationContext iActivationContext = this.getActivationContext();
        if (iActivationContext == null) {
            this.logger.main().log(1000000, "[%1.onStartupReadyForPlayback] Not active.", (Object)LOGCLASS);
            return;
        }
        Integer n = (Integer)iActivationContext.getParameter("SETPLAYSELECTION_BROWSERID");
        if (n == null) {
            super.onStartupReadyForPlayback();
            return;
        }
        this.logger.main().log(1000000, "[%1.onStartupReadyForPlayback] Use browser instance '%2' for startup.", (Object)LOGCLASS, (Object)n);
        Long l = (Long)iActivationContext.getParameter("SETPLAYSELECTION_TRACKID");
        IFavoritePlayerSelectionListener iFavoritePlayerSelectionListener = (IFavoritePlayerSelectionListener)iActivationContext.getParameter("PLAYER_SELECTION_CALLBACK_HANDLER");
        this.setBrowserPlayerSelection(new DataPlayerSelectionOnStartup(n, l != null ? l : 0L, iFavoritePlayerSelectionListener));
        super.onStartupReadyForPlayback();
    }

    protected void playerStartupComplete() {
        this.logger.main().log(1000000, "[%1.playerStartupComplete]", (Object)LOGCLASS);
        super.playerStartupComplete();
        if (!this.supportsPlayListHandling()) {
            this.logger.main().log(1000000, "[%1.playerStartupComplete] No play view supported", (Object)LOGCLASS);
            this.getContent().notifyContentActivationFinished();
            return;
        }
        this.logger.main().log(1000000, "[%1.playerStartupComplete] Activate play view", (Object)LOGCLASS);
        this.tryToActivatePlayView();
        this.getTerminal().getSDSDispatcher().addCommandListener(this.getTerminal().getTerminalID(), this.commandHandler);
    }

    private void invalidateCoverArt() {
        this.logger.hmi().log(1000000, "[%1.invalidateCoverArt]", (Object)LOGCLASS);
        this.getChoiceModel(200870).setStatus(0);
        this.getResourceLocatorModel(200637).setStatus(0);
        this.getResourceLocatorModel(200637).setResourceLocator(-1, ResourceLocatorModelApp.UNDEFINED_URI, 1);
        this.newPlayViewList.invalidateCoverArt();
    }

    public int playMoreLikeThis() {
        long l = this.getCurrentPlayingTrack().getEntryID();
        this.logger.main().log(1000000, "[%1.playMoreLikeThis] '%2'", (Object)LOGCLASS, l);
        if (l == -1L) {
            this.logger.main().log(1000000, "[%1.playMoreLikeThis] No valid entry ID.", (Object)LOGCLASS);
            this.setMoreLikeThisState(3);
            return 3;
        }
        if (this.getMoreLikeThisState() == 1) {
            this.logger.main().log(1000000, "[%1.playMoreLikeThis] Currently running.", (Object)LOGCLASS);
            return 1;
        }
        this.setMoreLikeThisState(1);
        if (this.getDSIPlayer().playSimilarEntries(l, 20)) {
            return 1;
        }
        this.logger.main().log(1000000, "[%1.playMoreLikeThis] Failed.", (Object)LOGCLASS);
        this.setMoreLikeThisState(3);
        return 3;
    }

    public void responsePlaySimilarEntry(long l, boolean bl) {
        this.logger.main().log(1000000, "[%2.responsePlaySimilarEntry] result='%1' (entryID='%3')", bl, (Object)LOGCLASS, (Object)String.valueOf(l));
        if (!bl) {
            this.logger.main().log(1000000, "[%1.responsePlaySimilarEntry] Not successful.", (Object)LOGCLASS);
            this.setMoreLikeThisState(3);
            return;
        }
        if (this.isPaused()) {
            this.getTerminal().getAudioManager().resumeAudio(true);
        }
        this.setMoreLikeThisState(2);
    }

    private void setMoreLikeThisState(int n) {
        ChoiceModelApp choiceModelApp = this.getChoiceModel(200646);
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
        ChoiceModelApp choiceModelApp = this.getChoiceModel(200646);
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
        this.logger.main().log(1000000, "[%1.setTitleAsRingtone]", (Object)LOGCLASS);
        ISourceSlot iSourceSlot = this.getTerminal().getSourceController().getSelectedSlot();
        if (iSourceSlot == null || !iSourceSlot.getFlags().isMetaDataSyncComplete()) {
            this.logger.main().log(1000000, "[%1.setTitleAsRingtone] Source not active or Sync not complete.", (Object)LOGCLASS);
            return false;
        }
        Object object = this.ringtoneMutex;
        synchronized (object) {
            this.ringtoneEntryID = l;
            this.ringtoneTitle = i18NString;
        }
        if (this.getDSIPlayer().requestFullQualifiedName(l)) {
            this.getChoiceModel(200653).setValue(0);
            this.getChoiceModel(200653).setStatus(0);
            return true;
        }
        this.getChoiceModel(200653).setValue(2);
        this.getChoiceModel(200653).setStatus(2);
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void responseFullyQualifiedName(long l, String string) {
        this.logger.main().log(1000000, "[%1.responseFullyQualifiedName] entryID='%3', path='%2'", (Object)LOGCLASS, (Object)string, l);
        ITelServiceMedia iTelServiceMedia = this.phoneService;
        if (iTelServiceMedia == null) {
            this.logger.main().log(1000000, "[%1.responseFullyQualifiedName] Phone service not available.", (Object)LOGCLASS);
            this.getChoiceModel(200653).setValue(2);
            this.getChoiceModel(200653).setStatus(2);
            return;
        }
        Object object = this.ringtoneMutex;
        synchronized (object) {
            if (this.ringtoneEntryID != l) {
                this.logger.main().log(1000000, "[%1.responseFullyQualifiedName] Belongs not to the ringtone entryID.", (Object)LOGCLASS);
                this.getChoiceModel(200653).setValue(2);
                this.getChoiceModel(200653).setStatus(2);
                return;
            }
            iTelServiceMedia.setUserDefinedRingtone(string, this.ringtoneTitle.getI18NString());
        }
        this.getChoiceModel(200653).setValue(1);
        this.getChoiceModel(200653).setStatus(1);
    }

    public void updateVideoFormat(int n) {
        this.videoFormatSetting.setActiveVideoFormat(n);
    }

    public void updateVideoNorm(int n) {
        this.videoNormSetting.setActiveVideoNorm(n);
    }

    public void updateCapabilities(Capabilities capabilities) {
        ISourceSlot iSourceSlot = this.getActiveSlot();
        if (iSourceSlot == null) {
            return;
        }
        super.updateCapabilities(capabilities);
        if (this.supportsVideoPlayback()) {
            this.logger.main().log(1000000, "[%1.updateCapabilities] Video playback supported.", (Object)LOGCLASS);
            this.videoFormatSetting.restoreSetting();
            if (iSourceSlot.getMediaType() == 24) {
                this.videoNormSetting.restoreSetting();
            }
        }
        if (this.supportsPlaySimilar()) {
            this.logger.main().log(1000000, "[%1.updateCapabilities] MoreLikeThis supported.", (Object)LOGCLASS);
            this.getTerminal().addActionProxyListener(21, (IActionProxyListener)this);
        }
        this.tryToActivatePlayView();
    }

    public void updatePlayViewSize(int n, int n2) {
        this.logger.main().log(1000000, "[%1.updatePlayViewSize]", (Object)LOGCLASS);
        super.updatePlayViewSize(n, n2);
        if (this.activatePlayViewOnValidSizeUpdate) {
            this.tryToActivatePlayView();
        }
    }

    private void tryToActivatePlayView() {
        if (this.isOnStartup()) {
            this.logger.main().log(1000000, "[%1.tryToActivatePlayView] On startup - ignore.", (Object)LOGCLASS);
            return;
        }
        if (this.supportsPlayListHandling()) {
            if (this.isPlayViewSizeValid()) {
                this.logger.main().log(1000000, "[%1.tryToActivatePlayView] playview supported and size is valid. Activate playviewlist.", (Object)LOGCLASS);
                this.activatePlayViewOnValidSizeUpdate = false;
                this.newPlayViewList.activate();
            } else {
                this.logger.main().log(1000000, "[%1.tryToActivatePlayView] playview is supported but size is invalid. Delay the activation.", (Object)LOGCLASS);
                this.activatePlayViewOnValidSizeUpdate = true;
            }
        } else {
            this.logger.main().log(1000000, "[%1.tryToActivatePlayView] playview is not supported. Deactivate playview.", (Object)LOGCLASS);
            this.newPlayViewList.deactivate();
            this.activatePlayViewOnValidSizeUpdate = false;
        }
    }

    public void updatePlaybackState(int n) {
        this.logger.main().log(1000000, "[%1.updatePlaybackState]", (Object)LOGCLASS);
        super.updatePlaybackState(n);
        if (this.iPodWithIAP2) {
            if (4 == n) {
                this.logger.main().log(1000000, "[%1.updatePlaybackState] PlaybackState: STOPPED", (Object)LOGCLASS);
                this.hmiHandler.setPlaybackStopped(true);
                return;
            }
            this.logger.main().log(1000000, "[%1.updatePlaybackState] PlaybackState: NOT STOPPED", (Object)LOGCLASS);
            this.hmiHandler.setPlaybackStopped(false);
        }
    }

    public void playPositionInvalidated() {
        ISourceSlot iSourceSlot = this.getActiveSlot();
        if (iSourceSlot != null && (iSourceSlot.getMediaType() == 24 || iSourceSlot.getSource().getType() == 11)) {
            super.playPositionInvalidated();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        this.logger.main().log(1000000, "[%1.detailInfoChanged]", (Object)LOGCLASS);
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

    public void trackChanged(boolean bl, boolean bl2, PlayingTrack playingTrack, PlayTime playTime) {
        if (this.setPlaytimeInModel()) {
            this.hmiHandler.setPlayTime(playTime.getRestrictedPlayTimeStr(), playTime.getRemainTimeStr(), playTime.getProgress());
            if (bl && this.supportsCoverart()) {
                this.invalidateCoverArt();
            }
        }
    }

    public void coverArtChanged(ResourceLocator resourceLocator) {
        this.logger.hmi().log(1000000, "[%1.coverArtChanged] '%2'", (Object)LOGCLASS, (Object)resourceLocator);
        int n = resourceLocator == null ? -1 : resourceLocator.getId();
        String string = resourceLocator == null ? ResourceLocatorModelApp.UNDEFINED_URI : resourceLocator.getUrl();
        this.getResourceLocatorModel(200637).setResourceLocator(n, string, 0);
        this.getChoiceModel(200870).setStatus(1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void playEntry(long l, I18NString i18NString, boolean bl) {
        this.logger.main().log(1000000, "[%1.playEntry] entryID='%2',title='%3'", (Object)LOGCLASS, (Object)String.valueOf(l), (Object)i18NString);
        PlayingTrack playingTrack = this.getCurrentPlayingTrack();
        this.playEntry(l);
        if (playingTrack.getEntryID() != l) {
            this.logger.hmi().log(10000000, "[%1.playEntry] Change track.", (Object)LOGCLASS);
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

    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 21: {
                this.logger.main().log(1000000, "[%1.actionProxyCallPerformed] AP_METHOD_PLAYER_MORELIKETHIS_ERROR_LEAVED", (Object)LOGCLASS);
                this.setMoreLikeThisState(2);
                break;
            }
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

    public void playMoreOf(long l, int n, ISelectionListener iSelectionListener) {
        if (l != this.currentDetailInfo.getEntryID()) {
            this.logger.main().log(100000, "[%1.playMoreOf] currentEntryId is not currentPlaying track", (Object)LOGCLASS);
            if (null != iSelectionListener) {
                iSelectionListener.notifySelectionChanged(null, false);
            }
            return;
        }
        this.logger.main().log(1000000, "[%1.playMoreOf]", (Object)LOGCLASS);
        MediaListEntry mediaListEntry = new MediaListEntry(l, this.currentDetailInfo.getContentType(), this.currentDetailInfo.getFilename().getOriginalString());
        DataSelectionContainer dataSelectionContainer = new DataSelectionContainer(this.getActiveSlot(), mediaListEntry, n, this.currentDetailInfo);
        SelectionBrowser selectionBrowser = this.getTerminal().getSelectionBrowser();
        if (iSelectionListener != null) {
            dataSelectionContainer.addParameter(KEY_SELECTIONLISTENER, iSelectionListener);
        }
        DataSelectionByCategorySeamlessJob dataSelectionByCategorySeamlessJob = new DataSelectionByCategorySeamlessJob(this.logger.main(), selectionBrowser, dataSelectionContainer, this);
        selectionBrowser.enqueueSelectionJob(dataSelectionByCategorySeamlessJob);
    }

    public boolean supportsPlayMoreOf() {
        return this.getActiveSlot().getMediaType() == 24 || this.getActiveSlot().getCapabilities().isContentBrowsing() && this.getActiveSlot().getFlags().isMetaDataSyncComplete();
    }

    public void notifySelectionChanged(IDataSelectionContext iDataSelectionContext, boolean bl) {
        if (null == iDataSelectionContext) {
            return;
        }
        ISelectionListener iSelectionListener = (ISelectionListener)iDataSelectionContext.getParameter(KEY_SELECTIONLISTENER, null);
        if (iSelectionListener != null) {
            this.logger.main().log(1000000, "[%1.notifySelectionChanged]", (Object)LOGCLASS);
            iSelectionListener.notifySelectionChanged(iDataSelectionContext, bl);
        }
    }

    public String[] getDiagKeys() {
        return new String[]{"DataPlayer.setPlayPosition(int)", "DataPlayer.startSeek(boolean)", "DataPlayer.stopSeek"};
    }

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
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }

    public void playbackFolderChanged(MediaListEntry[] mediaListEntryArray) {
    }

    protected void setNoPlayableFiles() {
        this.logger.main().log(1000000, "[%1.setNoPlayableFiles]", (Object)LOGCLASS);
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
}

