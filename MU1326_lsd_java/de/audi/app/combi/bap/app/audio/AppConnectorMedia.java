/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio;

import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.functionsync.IFunctionSynchronizationHandler;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.combi.bap.app.audio.AbstractAppConnectorAudio;
import de.audi.app.combi.bap.app.audio.CombiBAPAudioListStates;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.app.combi.bap.app.audio.list.MediaBrowserListHandler;
import de.audi.app.combi.bap.app.audio.list.SourceListHandler;
import de.audi.app.combi.bap.app.kombipictures.IPictureProvider;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.interapp.bap.BAPServiceListener;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceMedia;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceMediaListener;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCurrentStationInfo;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPMediaBrowserListEntry;
import de.audi.atip.interapp.combi.bap.audio.data.PlayPosition;
import de.vw.mib.bap.generated.audiosd.serializer.ActiveSource_Status;
import de.vw.mib.bap.generated.audiosd.serializer.MediaBrowserControl_Result;
import de.vw.mib.bap.generated.audiosd.serializer.MediaBrowser_FolderLevel_Status;
import de.vw.mib.bap.generated.audiosd.serializer.MediaImportState_Status;
import de.vw.mib.bap.generated.audiosd.serializer.MediaPath_Status;
import de.vw.mib.bap.generated.audiosd.serializer.PlayPosition_Status;
import edu.emory.mathcs.backport.java.util.concurrent.Callable;
import edu.emory.mathcs.backport.java.util.concurrent.Executors;
import edu.emory.mathcs.backport.java.util.concurrent.ScheduledExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;

public class AppConnectorMedia
extends AbstractAppConnectorAudio
implements CombiBAPServiceMedia {
    private static final int TRACK_CHANGE_TO_NEW_FOLDER_TIME_WINDOW_MS = 50;
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private final CoverArtProvider pictureProvider = new CoverArtProvider();

    protected AppConnectorMedia(CombiModuleAudio combiModuleAudio) {
        super(combiModuleAudio);
        combiModuleAudio.getPictureManager().registerPictureProvider(0, this.pictureProvider);
    }

    public void setAppServiceListener(BAPServiceListener bAPServiceListener) {
        super.setAppServiceListener(bAPServiceListener);
        if (bAPServiceListener == null && this.moduleFsg.getAppServiceListener("Tuner") == null) {
            this.moduleFsg.getInitializationManager().notifyAppServiceChanged(false);
        } else {
            this.moduleFsg.getInitializationManager().notifyAppServiceChanged(true);
        }
    }

    protected int getAudioApplication() {
        return 1;
    }

    protected String getAudioApplicationName() {
        return "Media";
    }

    protected boolean isAudioApplicationInFocus() {
        return ((CombiModuleAudio)this.moduleFsg).getAudioApplicationFocusHandler().isMediaInFocus();
    }

    public void updateActiveSource(int n, int n2, int n3, boolean bl, boolean bl2, int n4) {
        CombiBAPAudioSource combiBAPAudioSource = new CombiBAPAudioSource();
        combiBAPAudioSource.setSourceType(n);
        combiBAPAudioSource.setSlotNumber(n2);
        combiBAPAudioSource.setPartitionNumber(n3);
        CombiBAPAudioListStates combiBAPAudioListStates = new CombiBAPAudioListStates();
        combiBAPAudioListStates.setMediaBrowserListAvailable(bl);
        combiBAPAudioListStates.setPresetListAvailable(bl2);
        combiBAPAudioListStates.setListState(n4);
        this.updateActiveSource(combiBAPAudioSource, combiBAPAudioListStates);
    }

    protected void sendSourceChangeRelatedProperties() {
        super.sendSourceChangeRelatedProperties();
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(37);
        bAPFunctionPropertyFSG.sendStatusIfChanged(bAPFunctionPropertyFSG.getLastStatus());
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG2 = this.moduleFsg.getBAPFunctionPropertyFSG(35);
        bAPFunctionPropertyFSG2.sendStatusIfChanged(bAPFunctionPropertyFSG2.getLastStatus());
    }

    public void updateCurrentStation(CombiBAPCurrentStationInfo combiBAPCurrentStationInfo) {
        this.logChannel.log(10000000, "[AppConnectorMedia#updateCurrentStation] called");
        ActiveSource_Status activeSource_Status = (ActiveSource_Status)this.moduleFsg.getBAPFunctionPropertyFSG(16).getLastStatus();
        int n = activeSource_Status.sourceType;
        ResourceLocator resourceLocator = new ResourceLocator(combiBAPCurrentStationInfo.getPictureID(), combiBAPCurrentStationInfo.getPictureURL());
        this.pictureProvider.clearMapping();
        this.pictureProvider.addToMapping(combiBAPCurrentStationInfo.getListRef(), resourceLocator);
        ((AbstractCombiModule)this.moduleFsg).getPictureManager().responseCoverArt(combiBAPCurrentStationInfo.getListRef(), n, resourceLocator, true);
        super.updateCurrentStation(combiBAPCurrentStationInfo);
    }

    public void updateSourceListMedia(int[] nArray, CombiBAPAudioSource[][] combiBAPAudioSourceArray) {
        this.logChannel.log(1000000, "[AppConnectorMedia#updateSourceListMedia] called (specified sourceTypes)");
        BAPFunctionArrayFSG bAPFunctionArrayFSG = this.moduleFsg.getBAPFunctionArrayFSG(32);
        ((SourceListHandler)bAPFunctionArrayFSG.getArrayHandler()).updateSources(1, nArray, combiBAPAudioSourceArray);
    }

    public void goToResult(int n, int n2) {
        this.logChannel.log(1000000, "[AppConnectorMedia#goToResult] called (result=%1)", (long)n2);
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(38);
        MediaBrowserControl_Result mediaBrowserControl_Result = (MediaBrowserControl_Result)this.moduleFsg.createResultSerializer(38);
        mediaBrowserControl_Result.browserControlResult = n2;
        bAPFunctionMethodFSG.resultREQ(mediaBrowserControl_Result);
    }

    public void trackChangeIsComing() {
        this.logChannel.log(1000000, "[AppConnectorMedia#trackChangeIsComing] called");
        IFunctionSynchronizationHandler iFunctionSynchronizationHandler = this.moduleFsg.getFunctionSynchronizationHandler();
        iFunctionSynchronizationHandler.startSync(6);
    }

    public void updateBrowserListSize(final int n) {
        this.executor.schedule(new Callable(){

            public Object call() {
                AppConnectorMedia.this.logChannel.log(1000000, "[AppConnectorMedia#updateBrowserListSize] called (listSize=%1)", (long)n);
                MediaBrowserListHandler mediaBrowserListHandler = (MediaBrowserListHandler)AppConnectorMedia.this.moduleFsg.getBAPFunctionArrayFSG(36).getArrayHandler();
                mediaBrowserListHandler.notifyListSizeChanged(n);
                return null;
            }
        }, 50L, TimeUnit.MILLISECONDS);
    }

    public void updateCurrentBrowseFolder(int n, String string, int n2, int n3, int n4) {
        this.logChannel.log(1000000, "[AppConnectorMedia#updateCurrentBrowseFolder] called (folderType=%2, folderPath=%1, ...", (Object)string, (long)n);
        this.logChannel.log(1000000, "[AppConnectorMedia#updateCurrentBrowseFolder] ... folderLevel=%1, subfolderEntryID=%2, subfolderAbsolutePosition=%3)", (long)n2, (long)n3, (long)n4);
        MediaPath_Status mediaPath_Status = new MediaPath_Status();
        mediaPath_Status.folder_Type = n;
        mediaPath_Status.path.setContent(string);
        this.moduleFsg.getBAPFunctionPropertyFSG(37).sendStatusIfChanged(mediaPath_Status);
        MediaBrowser_FolderLevel_Status mediaBrowser_FolderLevel_Status = new MediaBrowser_FolderLevel_Status();
        mediaBrowser_FolderLevel_Status.folderLevel = n2;
        mediaBrowser_FolderLevel_Status.ref_MediaBrowser = n3;
        mediaBrowser_FolderLevel_Status.ref_MediaBrowser_absolutePosition = n4;
        this.moduleFsg.getBAPFunctionPropertyFSG(35).sendStatusIfChanged(mediaBrowser_FolderLevel_Status);
    }

    public void responseMediaBrowserList(int n, CombiBAPMediaBrowserListEntry[] combiBAPMediaBrowserListEntryArray) {
        this.logChannel.log(1000000, "[AppConnectorMedia#responseMediaBrowserList] taID=%1, noOfListEntries=%2", (long)n, (long)combiBAPMediaBrowserListEntryArray.length);
        ArrayHandler arrayHandler = this.moduleFsg.getBAPFunctionArrayFSG(36).getArrayHandler();
        arrayHandler.responseListElements(n, combiBAPMediaBrowserListEntryArray);
    }

    public void updatePlaybackFolder(boolean bl) {
        this.logChannel.log(1000000, "[AppConnectorMedia#updatePlaybackFolder] isPlaybackFolder=%1", bl);
        BAPFunctionArrayFSG bAPFunctionArrayFSG = this.moduleFsg.getBAPFunctionArrayFSG(36);
        ((MediaBrowserListHandler)bAPFunctionArrayFSG.getArrayHandler()).setPlaybackFolder(bl);
    }

    public void updateMediaImportState(int n, int n2, boolean bl, int n3) {
        this.logChannel.log(1000000, "[AppConnectorMedia#updateMediaImportState] sourceType=%1, instanceID=%2", (long)n, (long)n2);
        this.logChannel.log(1000000, "[AppConnectorMedia#updateMediaImportState] importActive=%1, progress=%2", bl, (long)n3);
        MediaImportState_Status mediaImportState_Status = new MediaImportState_Status();
        mediaImportState_Status.sourceType = n;
        mediaImportState_Status.instance_Id = n2;
        mediaImportState_Status.state = bl ? 1 : 0;
        mediaImportState_Status.progress = n3;
        this.moduleFsg.getBAPFunctionPropertyFSG(46).sendStatusIfChanged(mediaImportState_Status);
    }

    public void responseCoverArt(long l, int n, String string, int n2) {
        ((AbstractCombiModule)this.moduleFsg).getPictureManager().responseCoverArt(l, n, new ResourceLocator(n2, string), false);
    }

    public void updatePlayPosition(PlayPosition playPosition) {
        this.logChannel.log(10000000, "[AppConnectorMedia#updatePlayPosition] %1", (Object)playPosition);
        if (this.isAudioApplicationInFocus()) {
            PlayPosition_Status playPosition_Status = new PlayPosition_Status();
            playPosition_Status.timePosition = playPosition.getTimePosition().getTimeInSeconds();
            playPosition_Status.totalPlayTime = playPosition.getTotalPlayTime().getTimeInSeconds();
            playPosition_Status.attributes.variableBitRateActive = playPosition.isVariableBitRate();
            this.moduleFsg.getBAPFunctionPropertyFSG(52).sendStatusIfChanged(playPosition_Status);
        } else {
            this.logChannel.log(10000000, "[AppConnectorMedia#updatePlayPosition] application not in focus; don't send playPosition");
        }
    }

    private class CoverArtProvider
    implements IPictureProvider {
        private final Map id2pictureURL = new HashMap();

        private CoverArtProvider() {
        }

        public void requestPicture(long l) {
            this.requestPicture(l, 255);
        }

        public void requestPicture(long l, int n) {
            Long l2 = new Long(l);
            if (this.id2pictureURL.containsKey(l2)) {
                ((AbstractCombiModule)AppConnectorMedia.this.moduleFsg).getPictureManager().responseCoverArt(l, n, (ResourceLocator)this.id2pictureURL.get(l2), false);
            } else if (AppConnectorMedia.this.appServiceListener instanceof CombiBAPServiceMediaListener) {
                AppConnectorMedia.this.logChannel.log(10000000, "[AppConnectorMedia.CoverArtProvider#requestPicture] call media service 'requestCoverArt(bapEntryID=%1)'", l);
                ((AbstractCombiModule)AppConnectorMedia.this.moduleFsg).getPictureManager().responseCoverArt(l, n, null, false);
            }
        }

        public void addToMapping(long l, ResourceLocator resourceLocator) {
            this.id2pictureURL.put(new Long(l), resourceLocator);
        }

        public void clearMapping() {
            this.id2pictureURL.clear();
        }
    }
}

