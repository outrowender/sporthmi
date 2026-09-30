/*
 * Decompiled with CFR 0.152.
 */
package de.audi.swdiagnosis.media.dsi;

import de.audi.app.media.dsi.media.NullDSIMediaBrowser;
import de.audi.app.media.dsi.media.NullDSIMediaPlayer;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.interapp.IEjectHandler;
import de.audi.atip.util.MethodCall;
import de.audi.swdiagnosis.media.dsi.DummyDSIAlbumbrowser;
import de.audi.swdiagnosis.media.dsi.DummyDSIMediaOnline;
import de.audi.swdiagnosis.media.dsi.DummyDSIMediaRecorder;
import de.audi.swdiagnosis.media.dsi.DummySystemOutLogChannel;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;
import org.dsi.ifc.albumbrowser.DSIAlbumBrowserListener;
import org.dsi.ifc.media.AudioStream;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.DSIMediaBaseListener;
import org.dsi.ifc.media.DSIMediaBrowserListener;
import org.dsi.ifc.media.DSIMediaOnlineListener;
import org.dsi.ifc.media.DSIMediaPlayerListener;
import org.dsi.ifc.media.DSIMediaRecorderListener;
import org.dsi.ifc.media.DatabaseSpace;
import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.ListEntryExt;
import org.dsi.ifc.media.MediaCapabilities;
import org.dsi.ifc.media.MediaInfo;
import org.dsi.ifc.media.PlaybackMode;
import org.dsi.ifc.media.SearchListEntry;
import org.dsi.ifc.media.SearchListEntryExt;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class MediaDSISimulation
extends AbstractSwDiagnosis {
    private static final int VALID = 1;
    private static final String CMD_MEDIA_DSI_BASE_INIT = "dsi.base.init";
    private static final String CMD_MEDIA_DSI_BASE_UPDATE_MEDIA_LIST = "dsi.base.updateMediaList";
    private static final String CMD_MEDIA_DSI_BASE_UPDATE_DEVICE_LIST = "dsi.base.updateDeviceList";
    private static final String CMD_MEDIA_DSI_BASE_RESPONSE_RESET_FACTORY_SETTINGS = "dsi.base.responseResetFactorySettings";
    private static final String CMD_MEDIA_DSI_PLAYER_INIT = "dsi.player.init";
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_ACTIVE_MEDIA = "dsi.player.updateActiveMedia";
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_PLAYBACK_STATE = "dsi.player.updatePlaybackState";
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_PLAY_POSITION = "dsi.player.updatePlayPosition";
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_PLAYVIEW_SIZE = "dsi.player.updatePlayViewSize";
    private static final String CMD_MEDIA_DSI_PLAYER_RESPONSE_PLAY_VIEW = "dsi.player.responsePlayView";
    private static final String CMD_MEDIA_DSI_PLAYER_RESPONSE_DETAIL_INFO = "dsi.player.responseDetailInfo";
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_CAPABILITIES = "dsi.player.updateCapabilities";
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_PLAYBACK_FOLDER = "dsi.player.updatePlaybackFolder";
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_PLAYBACK_MODE = "dsi.player.updatePlaybackMode";
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_PLAYBACK_MODE_LIST = "dsi.player.updatePlaybackModeList";
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_CMD_BLOCK = "dsi.player.updateCmdBlockingMask";
    private static final String CMD_MEDIA_DSI_PLAYER_RESPONSE_CMD_BLOCKED = "dsi.player.responseCmdBlocked";
    private static final String CMD_MEDIA_DSI_PLAYER_ASYNC_EXCEPTION = "dsi.player.asyncException";
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_VIDEO_FORMAT = "dsi.player.updateVideoFormat";
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_VIDEO_NORM = "dsi.player.updateVideoNorm";
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_SUBTITLE_LIST = "dsi.player.updateSubtitleList";
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_ACTIVE_SUBTITLE = "dsi.player.updateActiveSubtitle";
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_AUDIOSTREAM_LIST = "dsi.player.updateAudioStreamList";
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_ACTIVE_AUDIOSTREAM = "dsi.player.updateActiveAudioStream";
    private static final String CMD_MEDIA_DSI_PLAYER_RESPONSE_PLAYSIMILAR = "dsi.player.responsePlaySimilarEntry";
    private static final String CMD_MEDIA_DSI_PLAYER_RESPONSE_PLAYBACKURL = "dsi.player.responsePlaybackUrl";
    private static final String CMD_MEDIA_DSI_PLAYER_TEMP_PML_REQUEST = "dsi.player.tempPMLRequest";
    private static final String CMD_MEDIA_DSI_BASE_SET_PARENTAL_ML = "dsi.base.setParentalML";
    private static final String CMD_MEDIA_DSI_BROWSER_INIT = "dsi.browser.init";
    private static final String CMD_MEDIA_DSI_BROWSER_ASYNC_EXCEPTION = "dsi.browser.asyncException";
    private static final String CMD_MEDIA_DSI_BROWSER_UPDATE_BROWSE_MEDIA = "dsi.browser.updateBrowseMedia";
    private static final String CMD_MEDIA_DSI_BROWSER_UPDATE_LIST_SIZE = "dsi.browser.updateListSize";
    private static final String CMD_MEDIA_DSI_BROWSER_RESPONSE_LIST = "dsi.browser.responseList";
    private static final String CMD_MEDIA_DSI_BROWSER_UPDATE_BROWSE_FOLDER = "dsi.browser.updateBrowseFolder";
    private static final String CMD_MEDIA_DSI_BROWSER_UPDATE_BROWSE_MODE = "dsi.browser.updateBrowseMode";
    private static final String CMD_MEDIA_DSI_BROWSER_SELECTION_RESULT = "dsi.browser.selectionResult";
    private static final String CMD_MEDIA_DSI_BROWSER_UPDATE_CONTENT_FILTER = "dsi.browser.updateContentFilter";
    private static final String CMD_MEDIA_DSI_COVERFLOW_INIT = "dsi.coverflow.init";
    private static final String CMD_MEDIA_DSI_COVERFLOW_UPDATE_BROWSER_STATE = "dsi.coverflow.updateBrowserState";
    private static final String CMD_MEDIA_DSI_COVERFLOW_ALBUM_IDX_FOR_FID = "dsi.coverflow.albumIdxForFID";
    private static final String CMD_MEDIA_DSI_RECORDER_INIT = "dsi.recorder.init";
    private static final String CMD_MEDIA_DSI_RECORDER_UPDATE_ACTIVE_MEDIA = "dsi.recorder.updateActiveMedia";
    private static final String CMD_MEDIA_DSI_RECORDER_UPDATE_IMPORT_PROGRESS = "dsi.recorder.updateImportProgress";
    private static final String CMD_MEDIA_DSI_RECORDER_UPDATE_IMPORT_STATUS = "dsi.recorder.updateImportStatus";
    private static final String CMD_MEDIA_DSI_RECORDER_UPDATE_DATABASE_SPACE = "dsi.recorder.updateDatabaseSpace";
    private static final String CMD_MEDIA_DSI_RECORDER_RESPONSE_SET_SELECTION = "dsi.recorder.responseSetSelection";
    private static final String CMD_MEDIA_DSI_RECORDER_UPDATE_IMPORT_SUMMARY = "dsi.recorder.updateImportSummary";
    private static final String CMD_MEDIA_DSI_RECORDER_UPDATE_DELETION_STATUS = "dsi.recorder.updateDeletionStatus";
    private static final String CMD_MEDIA_DSI_RECORDER_UPDATE_DELETION_PROGRESS = "dsi.recorder.updateDeletionProgress";
    private static final String CMD_MEDIA_DSI_RECORDER_RESPONSE_SET_ENCODING_QUALITY = "dsi.recorder.responseSetEncodingQuality";
    private static final String CMD_MEDIA_DSI_BROWSER_UPDATE_SEARCH_SPELLER_STATE = "dsi.browser.updateSearchSpellerState";
    private static final String CMD_MEDIA_DSI_BROWSER_RESPONSE_SET_SEARCH_CRITERIA = "dsi.browser.responseSetSearchCriteria";
    private static final String CMD_MEDIA_DSI_BROWSER_RESPONSE_SEARCH_LIST = "dsi.browser.responseSearchList";
    private static final String CMD_MEDIA_DSI_BROWSER_RESPONSE_SET_SEARCH_STRING = "dsi.browser.responseSetSearchString";
    private static final String CMD_MEDIA_DSI_BROWSER_UPDATE_SEARCH_SIZE = "dsi.browser.updateSearchSize";
    private static final String CMD_MEDIA_DSI_BROWSER_RESPONSE_SELECT_SEARCH_RESULT = "dsi.browser.responseSelectSearchResult";
    private static final String CMD_MEDIA_DSI_BROWSER_RESPONSE_SEARCH_LIST_EXT = "dsi.browser.responseSearchListExt";
    private static final String CMD_EJECTCD = "ejectCD";
    private static final String CMD_MEDIA_DSI_ONLINE_INIT = "dsi.online.init";
    private static final String CMD_MEDIA_DSI_ONLINE_UPDATE_BUFFER_STATE = "dsi.online.updateBufferState(state)";
    private static final String CMD_MEDIA_DSI_ONLINE_UPDATE_BUFFER_FILL_INFO = "dsi.online.updateBufferFillInfo(downloaded|total)";
    private static final String CMD_MEDIA_DSI_ONLINE_UPDATE_AUDIO_SETTINGS = "dsi.online.updateAudioSettings(audioType|value)";
    private static final String NO_TEXT = "NoText";
    private static final String[] mediaCmds = new String[]{"ejectCD", "dsi.base.init", "dsi.base.updateMediaList", "dsi.base.updateDeviceList", "dsi.base.responseResetFactorySettings", "dsi.base.setParentalML", "dsi.player.init", "dsi.player.updateCapabilities", "dsi.player.updateActiveMedia", "dsi.player.updatePlaybackState", "dsi.player.updatePlayPosition", "dsi.player.updatePlayViewSize", "dsi.player.responsePlayView", "dsi.player.responseDetailInfo", "dsi.player.updatePlaybackFolder", "dsi.player.updatePlaybackMode", "dsi.player.updatePlaybackModeList", "dsi.player.updateVideoFormat", "dsi.player.updateVideoNorm", "dsi.player.updateSubtitleList", "dsi.player.updateActiveSubtitle", "dsi.player.updateAudioStreamList", "dsi.player.updateActiveAudioStream", "dsi.player.responsePlaySimilarEntry", "dsi.player.updateCmdBlockingMask", "dsi.player.responseCmdBlocked", "dsi.player.asyncException", "dsi.player.tempPMLRequest", "dsi.player.responsePlaybackUrl", "dsi.browser.init", "dsi.browser.asyncException", "dsi.browser.updateBrowseMedia", "dsi.browser.updateListSize", "dsi.browser.responseList", "dsi.browser.updateBrowseFolder", "dsi.browser.selectionResult", "dsi.browser.updateBrowseMode", "dsi.browser.updateContentFilter", "dsi.coverflow.init", "dsi.coverflow.updateBrowserState", "dsi.coverflow.albumIdxForFID", "dsi.recorder.init", "dsi.recorder.updateActiveMedia", "dsi.recorder.updateImportProgress", "dsi.recorder.updateImportStatus", "dsi.recorder.updateDeletionStatus", "dsi.recorder.updateDeletionProgress", "dsi.recorder.updateDatabaseSpace", "dsi.recorder.responseSetEncodingQuality", "dsi.recorder.responseSetSelection", "dsi.recorder.updateImportSummary", "dsi.browser.updateSearchSpellerState", "dsi.browser.responseSetSearchCriteria", "dsi.browser.responseSearchList", "dsi.browser.responseSetSearchString", "dsi.browser.updateSearchSize", "dsi.browser.responseSelectSearchResult", "dsi.browser.responseSearchListExt", "dsi.online.init", "dsi.online.updateBufferState(state)", "dsi.online.updateBufferFillInfo(downloaded|total)", "dsi.online.updateAudioSettings(audioType|value)"};
    private final IServiceManager serviceManager;
    private volatile DSIMediaBaseListener hmiDSIMediaBaseListener;
    private volatile DSIMediaPlayerListener hmiDSIMediaPlayerListener;
    private final DSIMediaBrowserListener[] hmiDSIMediaBrowserListener = new DSIMediaBrowserListener[2];
    private volatile DSIAlbumBrowserListener hmiDSIAlbumbrowserListener;
    private volatile DSIMediaRecorderListener hmiDSIMediaRecorderListener;
    private volatile DSIMediaOnlineListener hmiDSIMediaOnlineListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaBaseListener;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaPlayerListener;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaPlayer;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaBrowserListener;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaBrowser;
    static /* synthetic */ Class class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser;
    static /* synthetic */ Class class$de$audi$atip$interapp$IEjectHandler;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaOnlineListener;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaOnline;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaRecorder;

    public MediaDSISimulation(IServiceManager iServiceManager) {
        this.serviceManager = iServiceManager;
    }

    public int getId() {
        return 21000;
    }

    public String getName() {
        return "AppMedia [DSI]";
    }

    public String[] getKeys() {
        return new String[0];
    }

    public Object getValue(String string) {
        return new String("");
    }

    public String[] getCommands() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < mediaCmds.length; ++i2) {
            arrayList.add(mediaCmds[i2]);
        }
        return (String[])arrayList.toArray(new String[arrayList.size()]);
    }

    public int processCommand(String string, Object object) {
        if (string.equals(CMD_MEDIA_DSI_BASE_INIT)) {
            this.serviceManager.createServiceTracker(class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = MediaDSISimulation.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener, new ServiceTrackerCustomizer(){

                public void removedService(ServiceReference serviceReference, Object object) {
                }

                public void modifiedService(ServiceReference serviceReference, Object object) {
                }

                public Object addingService(ServiceReference serviceReference) {
                    String string = (String)serviceReference.getProperty("DEVICE_NAME");
                    if (string == null) {
                        return null;
                    }
                    if (!(class$org$dsi$ifc$media$DSIMediaBaseListener == null ? (class$org$dsi$ifc$media$DSIMediaBaseListener = MediaDSISimulation.class$("org.dsi.ifc.media.DSIMediaBaseListener")) : class$org$dsi$ifc$media$DSIMediaBaseListener).getName().equals(string)) {
                        return null;
                    }
                    Object object = MediaDSISimulation.this.serviceManager.getService(serviceReference);
                    if (object instanceof DSIMediaBaseListener) {
                        MediaDSISimulation.this.hmiDSIMediaBaseListener = (DSIMediaBaseListener)object;
                        return MediaDSISimulation.this.hmiDSIMediaBaseListener;
                    }
                    return null;
                }
            }).open();
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_BASE_UPDATE_MEDIA_LIST)) {
            if (this.hmiDSIMediaBaseListener == null) {
                return -2;
            }
            String[] stringArray = this.parseArgs(object.toString(), ";");
            if (stringArray.length == 0) {
                return -3;
            }
            MediaInfo[] mediaInfoArray = new MediaInfo[stringArray.length];
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                MediaCapabilities mediaCapabilities;
                String[] stringArray2 = this.parseArgs(stringArray[i2], ",");
                if (stringArray2.length != 6 && stringArray2.length != 7) {
                    return -3;
                }
                int n = Integer.parseInt(stringArray2[0]);
                int n2 = Integer.parseInt(stringArray2[1]);
                int n3 = Integer.parseInt(stringArray2[2]);
                String string2 = stringArray2[3].equals(NO_TEXT) ? "" : stringArray2[3];
                int n4 = 0;
                try {
                    n4 = Integer.parseInt(stringArray2[4]);
                }
                catch (NumberFormatException numberFormatException) {
                    System.err.println(new StringBuffer().append("Index: ").append(i2).toString());
                    continue;
                }
                String string3 = stringArray2[5];
                if (stringArray2.length == 7) {
                    int n5 = Integer.parseInt(stringArray2[6]);
                    boolean bl = (n5 & 0x40) == 64;
                    boolean bl2 = (n5 & 0x20) == 32;
                    boolean bl3 = (n5 & 0x10) == 16;
                    boolean bl4 = (n5 & 8) == 8;
                    boolean bl5 = (n5 & 4) == 4;
                    boolean bl6 = (n5 & 2) == 2;
                    boolean bl7 = (n5 & 1) == 1;
                    mediaCapabilities = new MediaCapabilities(false, bl, bl, false, bl2, bl3, bl4, false, bl5, bl6, bl7, false);
                } else {
                    mediaCapabilities = new MediaCapabilities(false, false, false, false, false, false, false, false, false, false, false, false);
                }
                mediaInfoArray[i2] = new MediaInfo(n, n2, n3, "", string2, string3, n4, mediaCapabilities);
            }
            this.hmiDSIMediaBaseListener.updateMediaList(mediaInfoArray, 1);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_BASE_UPDATE_DEVICE_LIST)) {
            if (this.hmiDSIMediaBaseListener == null) {
                return -2;
            }
            String[] stringArray = this.parseArgs(object.toString(), ";");
            if (stringArray.length == 0) {
                return -3;
            }
            DeviceInfo[] deviceInfoArray = new DeviceInfo[stringArray.length];
            for (int i3 = 0; i3 < stringArray.length; ++i3) {
                String[] stringArray3 = this.parseArgs(stringArray[i3], ",");
                if (stringArray3.length != 4) {
                    return -3;
                }
                int n = Integer.parseInt(stringArray3[0]);
                int n6 = Integer.parseInt(stringArray3[1]);
                int n7 = Integer.parseInt(stringArray3[2]);
                int n8 = Integer.parseInt(stringArray3[3]);
                deviceInfoArray[i3] = new DeviceInfo(n, n6, n7, n8);
            }
            this.hmiDSIMediaBaseListener.updateDeviceList(deviceInfoArray, 1);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_BASE_RESPONSE_RESET_FACTORY_SETTINGS)) {
            if (this.hmiDSIMediaBaseListener == null) {
                return -2;
            }
            this.hmiDSIMediaBaseListener.responseResetFactorySettings(Integer.parseInt(object.toString()), true);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_PLAYER_INIT)) {
            final int n = Integer.parseInt(object.toString());
            this.serviceManager.createServiceTracker(class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = MediaDSISimulation.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener, new ServiceTrackerCustomizer(){

                public void removedService(ServiceReference serviceReference, Object object) {
                }

                public void modifiedService(ServiceReference serviceReference, Object object) {
                }

                public Object addingService(ServiceReference serviceReference) {
                    Integer n2 = (Integer)serviceReference.getProperty("DEVICE_INSTANCE");
                    if (n2 == null) {
                        return null;
                    }
                    if (n2 != n) {
                        return null;
                    }
                    String string = (String)serviceReference.getProperty("DEVICE_NAME");
                    if (string == null) {
                        return null;
                    }
                    if (!(class$org$dsi$ifc$media$DSIMediaPlayerListener == null ? (class$org$dsi$ifc$media$DSIMediaPlayerListener = MediaDSISimulation.class$("org.dsi.ifc.media.DSIMediaPlayerListener")) : class$org$dsi$ifc$media$DSIMediaPlayerListener).getName().equals(string)) {
                        return null;
                    }
                    Object object = MediaDSISimulation.this.serviceManager.getService(serviceReference);
                    if (object instanceof DSIMediaPlayerListener) {
                        MediaDSISimulation.this.hmiDSIMediaPlayerListener = (DSIMediaPlayerListener)object;
                        return MediaDSISimulation.this.hmiDSIMediaPlayerListener;
                    }
                    return null;
                }
            }).open();
            Hashtable hashtable = new Hashtable();
            hashtable.put("DEVICE_INSTANCE", new Integer(n));
            hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$media$DSIMediaPlayer == null ? (class$org$dsi$ifc$media$DSIMediaPlayer = MediaDSISimulation.class$("org.dsi.ifc.media.DSIMediaPlayer")) : class$org$dsi$ifc$media$DSIMediaPlayer).getName());
            this.serviceManager.registerService(class$org$dsi$ifc$media$DSIMediaPlayer == null ? (class$org$dsi$ifc$media$DSIMediaPlayer = MediaDSISimulation.class$("org.dsi.ifc.media.DSIMediaPlayer")) : class$org$dsi$ifc$media$DSIMediaPlayer, new NullDSIMediaPlayer(), hashtable);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_PLAYER_UPDATE_ACTIVE_MEDIA)) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            String[] stringArray = this.parseArgs(object.toString(), ",");
            if (stringArray.length != 2) {
                return -3;
            }
            int n = Integer.parseInt(stringArray[0]);
            int n9 = Integer.parseInt(stringArray[1]);
            this.hmiDSIMediaPlayerListener.updateActiveMedia(n, n9, 0, 0, 1);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_PLAYER_UPDATE_PLAYBACK_STATE)) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            this.hmiDSIMediaPlayerListener.updatePlaybackState(Integer.parseInt(object.toString()), 1);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_PLAYER_UPDATE_VIDEO_FORMAT)) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            this.hmiDSIMediaPlayerListener.updateVideoFormat(Integer.parseInt(object.toString()), 1);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_PLAYER_UPDATE_VIDEO_NORM)) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            this.hmiDSIMediaPlayerListener.updateVideoNorm(Integer.parseInt(object.toString()), 1);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_PLAYER_UPDATE_CMD_BLOCK)) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            this.hmiDSIMediaPlayerListener.updateCmdBlockingMask(Integer.parseInt(object.toString()), 1);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_PLAYER_RESPONSE_CMD_BLOCKED)) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            this.hmiDSIMediaPlayerListener.responseCmdBlocked(Integer.parseInt(object.toString()));
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_PLAYER_UPDATE_PLAY_POSITION)) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            String[] stringArray = this.parseArgs(object.toString(), ",");
            if (stringArray.length != 3) {
                return -3;
            }
            int n = Integer.parseInt(stringArray[0]);
            int n10 = Integer.parseInt(stringArray[1]);
            int n11 = Integer.parseInt(stringArray[2]);
            this.hmiDSIMediaPlayerListener.updatePlayPosition(n, n10 * 1000, n11 * 1000, 1);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_PLAYER_UPDATE_PLAYVIEW_SIZE)) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            String[] stringArray = this.parseArgs(object.toString(), ",");
            if (stringArray.length != 2) {
                return -3;
            }
            int n = Integer.parseInt(stringArray[0]);
            int n12 = Integer.parseInt(stringArray[1]);
            this.hmiDSIMediaPlayerListener.updatePlayViewSize(n, n12, 1);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_PLAYER_RESPONSE_PLAY_VIEW)) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            String[] stringArray = this.parseArgs(object.toString(), ";");
            if (stringArray.length < 2) {
                return -3;
            }
            int n = Integer.parseInt(stringArray[0]);
            ListEntry[] listEntryArray = new ListEntry[stringArray.length - 1];
            for (int i4 = 1; i4 < stringArray.length; ++i4) {
                String[] stringArray4 = this.parseArgs(stringArray[i4], ",");
                if (stringArray4.length != 6) {
                    return -3;
                }
                long l = Long.parseLong(stringArray4[0]);
                String string4 = stringArray4[1];
                String string5 = stringArray4[2];
                int n13 = Integer.parseInt(stringArray4[3]);
                int n14 = Integer.parseInt(stringArray4[4]);
                long l2 = Long.parseLong(stringArray4[5]);
                ListEntryExt listEntryExt = new ListEntryExt("Album xxx", l2, "Artist xxx", 0L, null, 0L, 0, 0, 0);
                listEntryArray[i4 - 1] = new ListEntry(l, string4, string5, n13, 0, n14, listEntryExt);
            }
            this.hmiDSIMediaPlayerListener.responsePlayView(listEntryArray, 3, n, 0);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_PLAYER_RESPONSE_DETAIL_INFO)) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            String[] stringArray = this.parseArgs(object.toString(), ",");
            if (stringArray.length < 6) {
                return -3;
            }
            long l = Long.parseLong(stringArray[0]);
            int n = Integer.parseInt(stringArray[1]);
            String string6 = stringArray[2].trim();
            String string7 = stringArray[3].trim();
            String string8 = stringArray[4].trim();
            int n15 = Integer.parseInt(stringArray[5]);
            EntryInfo entryInfo = new EntryInfo(l, "filename", n, string6, 0L, 0L, 0L, 0L, 0L, string7, string8, "genre", "", "", 0L, 0L, 0, n15, null);
            this.hmiDSIMediaPlayerListener.responseDetailInfo(entryInfo);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_PLAYER_UPDATE_CAPABILITIES)) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            String[] stringArray = this.parseArgs(object.toString(), ",");
            if (stringArray.length != 2 && stringArray.length != 5) {
                return -2;
            }
            Capabilities capabilities = new Capabilities();
            capabilities.playView = Boolean.valueOf(stringArray[0]);
            capabilities.detailInfos = Boolean.valueOf(stringArray[1]);
            capabilities.playSimilarEntries = true;
            capabilities.extendedPlayView = true;
            capabilities.playTime = true;
            capabilities.totalPlaytime = true;
            if (stringArray.length == 5) {
                capabilities.playbackModes = Boolean.valueOf(stringArray[2]);
                capabilities.skipBwd = Boolean.valueOf(stringArray[3]);
                capabilities.skipFwd = Boolean.valueOf(stringArray[3]);
                capabilities.fastBwd = Boolean.valueOf(stringArray[4]);
                capabilities.fastFwd = Boolean.valueOf(stringArray[4]);
            }
            this.hmiDSIMediaPlayerListener.updateCapabilities(capabilities, 1);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_PLAYER_UPDATE_PLAYBACK_FOLDER)) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            String[] stringArray = this.parseArgs(object.toString(), ";");
            if (stringArray.length < 1) {
                return -3;
            }
            ListEntry[] listEntryArray = new ListEntry[stringArray.length];
            for (int i5 = 0; i5 < stringArray.length; ++i5) {
                String[] stringArray5 = this.parseArgs(stringArray[i5], ",");
                if (stringArray5.length != 2) {
                    return -3;
                }
                long l = Long.parseLong(stringArray5[0]);
                int n = Integer.parseInt(stringArray5[1]);
                listEntryArray[i5] = new ListEntry(l, "", "", n, 0, 0, new ListEntryExt());
            }
            this.hmiDSIMediaPlayerListener.updatePlaybackFolder(listEntryArray, 1);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_BROWSER_ASYNC_EXCEPTION)) {
            String[] stringArray = this.parseArgs(object.toString(), ",");
            if (stringArray.length != 2) {
                return -3;
            }
            int n = Integer.parseInt(stringArray[0]);
            if (this.hmiDSIMediaBrowserListener[n] == null) {
                return -2;
            }
            int n16 = Integer.parseInt(stringArray[1]);
            this.hmiDSIMediaBrowserListener[n].asyncException(0, "Error", n16);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_BROWSER_INIT)) {
            final int n = Integer.parseInt(object.toString());
            this.serviceManager.createServiceTracker(class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = MediaDSISimulation.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener, new ServiceTrackerCustomizer(){

                public void removedService(ServiceReference serviceReference, Object object) {
                }

                public void modifiedService(ServiceReference serviceReference, Object object) {
                }

                public Object addingService(ServiceReference serviceReference) {
                    Integer n2 = (Integer)serviceReference.getProperty("DEVICE_INSTANCE");
                    if (n2 == null) {
                        return null;
                    }
                    if (n2 != n) {
                        return null;
                    }
                    String string = (String)serviceReference.getProperty("DEVICE_NAME");
                    if (string == null) {
                        return null;
                    }
                    if (!(class$org$dsi$ifc$media$DSIMediaBrowserListener == null ? (class$org$dsi$ifc$media$DSIMediaBrowserListener = MediaDSISimulation.class$("org.dsi.ifc.media.DSIMediaBrowserListener")) : class$org$dsi$ifc$media$DSIMediaBrowserListener).getName().equals(string)) {
                        return null;
                    }
                    Object object = MediaDSISimulation.this.serviceManager.getService(serviceReference);
                    if (object instanceof DSIMediaBrowserListener) {
                        ((MediaDSISimulation)MediaDSISimulation.this).hmiDSIMediaBrowserListener[n2.intValue()] = (DSIMediaBrowserListener)object;
                        return object;
                    }
                    return null;
                }
            }).open();
            Hashtable hashtable = new Hashtable();
            hashtable.put("DEVICE_INSTANCE", new Integer(n));
            hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$media$DSIMediaBrowser == null ? (class$org$dsi$ifc$media$DSIMediaBrowser = MediaDSISimulation.class$("org.dsi.ifc.media.DSIMediaBrowser")) : class$org$dsi$ifc$media$DSIMediaBrowser).getName());
            this.serviceManager.registerService(class$org$dsi$ifc$media$DSIMediaBrowser == null ? (class$org$dsi$ifc$media$DSIMediaBrowser = MediaDSISimulation.class$("org.dsi.ifc.media.DSIMediaBrowser")) : class$org$dsi$ifc$media$DSIMediaBrowser, new NullDSIMediaBrowser(new DummySystemOutLogChannel()), hashtable);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_BROWSER_UPDATE_BROWSE_MEDIA)) {
            String[] stringArray = this.parseArgs(object.toString(), ",");
            if (stringArray.length != 3) {
                return -3;
            }
            int n = Integer.parseInt(stringArray[0]);
            if (this.hmiDSIMediaBrowserListener[n] == null) {
                return -2;
            }
            int n17 = Integer.parseInt(stringArray[1]);
            int n18 = Integer.parseInt(stringArray[2]);
            this.hmiDSIMediaBrowserListener[n].updateBrowseMedia(n17, n18, 1);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_BROWSER_UPDATE_LIST_SIZE)) {
            String[] stringArray = this.parseArgs(object.toString(), ",");
            if (stringArray.length != 2) {
                return -2;
            }
            int n = Integer.parseInt(stringArray[0]);
            if (this.hmiDSIMediaBrowserListener[n] == null) {
                return -2;
            }
            int n19 = Integer.parseInt(stringArray[1]);
            this.hmiDSIMediaBrowserListener[n].updateListSize(n19, 0, 1);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_BROWSER_RESPONSE_LIST)) {
            String[] stringArray = this.parseArgs(object.toString(), ";");
            if (stringArray.length < 3) {
                return -3;
            }
            int n = Integer.parseInt(stringArray[0]);
            if (this.hmiDSIMediaBrowserListener[n] == null) {
                return -2;
            }
            int n20 = Integer.parseInt(stringArray[1]);
            ListEntry[] listEntryArray = new ListEntry[stringArray.length - 2];
            for (int i6 = 2; i6 < stringArray.length; ++i6) {
                String[] stringArray6 = this.parseArgs(stringArray[i6], ",");
                if (stringArray6.length != 5) {
                    return -3;
                }
                long l = Long.parseLong(stringArray6[0]);
                String string9 = stringArray6[1];
                String string10 = stringArray6[2];
                int n21 = Integer.parseInt(stringArray6[3]);
                int n22 = Integer.parseInt(stringArray6[4]);
                listEntryArray[i6 - 2] = new ListEntry(l, string9, string10, n21, 0, n22, new ListEntryExt());
            }
            this.hmiDSIMediaBrowserListener[n].responseList(listEntryArray, n20);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_BROWSER_UPDATE_BROWSE_FOLDER)) {
            String[] stringArray = this.parseArgs(object.toString(), ";");
            if (stringArray.length < 2) {
                return -3;
            }
            int n = Integer.parseInt(stringArray[0]);
            if (this.hmiDSIMediaBrowserListener[n] == null) {
                return -2;
            }
            ListEntry[] listEntryArray = new ListEntry[stringArray.length - 1];
            for (int i7 = 1; i7 < stringArray.length; ++i7) {
                String[] stringArray7 = this.parseArgs(stringArray[i7], ",");
                if (stringArray7.length != 5) {
                    return -3;
                }
                long l = Long.parseLong(stringArray7[0]);
                String string11 = stringArray7[1];
                String string12 = stringArray7[2];
                int n23 = Integer.parseInt(stringArray7[3]);
                int n24 = Integer.parseInt(stringArray7[4]);
                listEntryArray[i7 - 1] = new ListEntry(l, string11, string12, n23, 0, n24, new ListEntryExt());
            }
            this.hmiDSIMediaBrowserListener[n].updateBrowseFolder(listEntryArray, 1);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_BROWSER_UPDATE_BROWSE_MODE)) {
            String[] stringArray = this.parseArgs(object.toString(), ",");
            if (stringArray.length < 2) {
                return -3;
            }
            int n = Integer.parseInt(stringArray[0]);
            if (this.hmiDSIMediaBrowserListener[n] == null) {
                return -2;
            }
            this.hmiDSIMediaBrowserListener[n].updateBrowseMode(Integer.parseInt(stringArray[1]), 1);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_BROWSER_UPDATE_CONTENT_FILTER)) {
            return this.commandDSIBrowserUpdateContentFilter(object);
        }
        if (string.equals(CMD_MEDIA_DSI_BROWSER_SELECTION_RESULT)) {
            return this.commandDSIBrowserSelectionResult(object);
        }
        if (string.equals(CMD_MEDIA_DSI_PLAYER_UPDATE_PLAYBACK_MODE)) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            int n = Integer.parseInt((String)object);
            this.hmiDSIMediaPlayerListener.updatePlaybackMode(n, 1);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_PLAYER_UPDATE_PLAYBACK_MODE_LIST)) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            String[] stringArray = this.parseArgs(object.toString(), ";");
            PlaybackMode[] playbackModeArray = new PlaybackMode[stringArray.length];
            if (stringArray.length != 0) {
                for (int i8 = 0; i8 < stringArray.length; ++i8) {
                    PlaybackMode playbackMode;
                    String[] stringArray8 = this.parseArgs(stringArray[i8], ",");
                    if (stringArray8.length != 3) {
                        return -3;
                    }
                    int n = Integer.parseInt(stringArray8[0]);
                    int n25 = Integer.parseInt(stringArray8[1]);
                    int n26 = Integer.parseInt(stringArray8[2]);
                    playbackModeArray[i8] = playbackMode = new PlaybackMode(n, n25, n26);
                }
            }
            this.hmiDSIMediaPlayerListener.updatePlaybackModeList(playbackModeArray, 1);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_PLAYER_RESPONSE_PLAYSIMILAR)) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            int n = Integer.parseInt((String)object);
            this.hmiDSIMediaPlayerListener.responsePlaySimilarEntry(-1L, n == 1);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_PLAYER_RESPONSE_PLAYBACKURL)) {
            this.hmiDSIMediaPlayerListener.responseSetPlaybackURL((String)object);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_PLAYER_UPDATE_SUBTITLE_LIST)) {
            return this.commandDSIPlayerUpdateSubtitleList(object);
        }
        if (string.equals(CMD_MEDIA_DSI_PLAYER_UPDATE_ACTIVE_SUBTITLE)) {
            return this.commandDSIPlayerUpdateActiveSubtitle(object);
        }
        if (string.equals(CMD_MEDIA_DSI_PLAYER_UPDATE_AUDIOSTREAM_LIST)) {
            return this.commandDSIPlayerUpdateAudioStreamList(object);
        }
        if (string.equals(CMD_MEDIA_DSI_PLAYER_UPDATE_ACTIVE_AUDIOSTREAM)) {
            return this.commandDSIPlayerUpdateActiveAudioStream(object);
        }
        if (string.equals(CMD_MEDIA_DSI_PLAYER_TEMP_PML_REQUEST)) {
            return this.commandDSIPlayerTempPmlRequest(object);
        }
        if (string.equals(CMD_MEDIA_DSI_BASE_SET_PARENTAL_ML)) {
            return this.commandDSIBaseSetParentalML(object);
        }
        if (string.equals(CMD_MEDIA_DSI_PLAYER_ASYNC_EXCEPTION)) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            int n = Integer.parseInt((String)object);
            this.hmiDSIMediaPlayerListener.asyncException(0, "Error", n);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_COVERFLOW_INIT)) {
            this.serviceManager.createServiceTracker(class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = MediaDSISimulation.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener, new ServiceTrackerCustomizer(){

                public void removedService(ServiceReference serviceReference, Object object) {
                }

                public void modifiedService(ServiceReference serviceReference, Object object) {
                }

                public Object addingService(ServiceReference serviceReference) {
                    Object object = MediaDSISimulation.this.serviceManager.getService(serviceReference);
                    if (object instanceof DSIAlbumBrowserListener) {
                        MediaDSISimulation.this.hmiDSIAlbumbrowserListener = (DSIAlbumBrowserListener)object;
                        return MediaDSISimulation.this.hmiDSIAlbumbrowserListener;
                    }
                    return null;
                }
            }).open();
            Hashtable hashtable = new Hashtable();
            hashtable.put("DEVICE_INSTANCE", new Integer(0));
            hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser == null ? (class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser = MediaDSISimulation.class$("org.dsi.ifc.albumbrowser.DSIAlbumBrowser")) : class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser).getName());
            this.serviceManager.registerService(class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser == null ? (class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser = MediaDSISimulation.class$("org.dsi.ifc.albumbrowser.DSIAlbumBrowser")) : class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser, new DummyDSIAlbumbrowser(), hashtable);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_COVERFLOW_UPDATE_BROWSER_STATE)) {
            if (this.hmiDSIAlbumbrowserListener == null) {
                return -2;
            }
            int n = Integer.parseInt((String)object);
            this.hmiDSIAlbumbrowserListener.updateBrowserState(n, 1);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_COVERFLOW_ALBUM_IDX_FOR_FID)) {
            if (this.hmiDSIAlbumbrowserListener == null) {
                return -2;
            }
            int n = Integer.parseInt((String)object);
            this.hmiDSIAlbumbrowserListener.albumIdxForFID(1L, n);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_RECORDER_INIT)) {
            this.commandDSIRecorderInit();
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_RECORDER_UPDATE_ACTIVE_MEDIA)) {
            if (this.hmiDSIMediaRecorderListener == null) {
                return -2;
            }
            return this.commandDSIRecorderUpdateActiveMedia(object);
        }
        if (string.equals(CMD_MEDIA_DSI_RECORDER_UPDATE_IMPORT_PROGRESS)) {
            if (this.hmiDSIMediaRecorderListener == null) {
                return -2;
            }
            return this.commandDSIRecorderUpdateImportProgress(object);
        }
        if (string.equals(CMD_MEDIA_DSI_RECORDER_UPDATE_DELETION_PROGRESS)) {
            if (this.hmiDSIMediaRecorderListener == null) {
                return -2;
            }
            return this.commandDSIRecorderUpdateDeletionProgress(object);
        }
        if (string.equals(CMD_MEDIA_DSI_RECORDER_UPDATE_IMPORT_STATUS)) {
            if (this.hmiDSIMediaRecorderListener == null) {
                return -2;
            }
            return this.commandDSIRecorderUpdateImportStatus(object);
        }
        if (string.equals(CMD_MEDIA_DSI_RECORDER_UPDATE_DELETION_STATUS)) {
            if (this.hmiDSIMediaRecorderListener == null) {
                return -2;
            }
            return this.commandDSIRecorderUpdateDeletionStatus(object);
        }
        if (string.equals(CMD_MEDIA_DSI_RECORDER_UPDATE_DATABASE_SPACE)) {
            if (this.hmiDSIMediaRecorderListener == null) {
                return -2;
            }
            return this.commandDSIRecorderUpdateDatabaseSpace(object);
        }
        if (string.equals(CMD_MEDIA_DSI_RECORDER_RESPONSE_SET_ENCODING_QUALITY)) {
            if (this.hmiDSIMediaRecorderListener == null) {
                return -2;
            }
            return this.commandDSIRecorderResponseSetEncodingQuality(object);
        }
        if (string.equals(CMD_MEDIA_DSI_RECORDER_RESPONSE_SET_SELECTION)) {
            if (this.hmiDSIMediaRecorderListener == null) {
                return -2;
            }
            return this.commandDSIRecorderResponseSetSelection();
        }
        if (string.equals(CMD_MEDIA_DSI_RECORDER_UPDATE_IMPORT_SUMMARY)) {
            if (this.hmiDSIMediaRecorderListener == null) {
                return -2;
            }
            return this.commandDSIRecorderUpdateImportSummary(object);
        }
        if (string.equals(CMD_MEDIA_DSI_BROWSER_UPDATE_SEARCH_SPELLER_STATE)) {
            return this.commandDSIBrowserUpdateSearchSpellerState(object);
        }
        if (string.equals(CMD_MEDIA_DSI_BROWSER_RESPONSE_SET_SEARCH_CRITERIA)) {
            return this.commandDSIBrowserResponseSetSearchCriteria(object);
        }
        if (string.equals(CMD_MEDIA_DSI_BROWSER_RESPONSE_SEARCH_LIST)) {
            return this.commandDSIBrowserResponseSearchList(object);
        }
        if (string.equals(CMD_MEDIA_DSI_BROWSER_RESPONSE_SEARCH_LIST_EXT)) {
            return this.commandDSIBrowserResponseSearchListExt(object);
        }
        if (string.equals(CMD_MEDIA_DSI_BROWSER_RESPONSE_SET_SEARCH_STRING)) {
            return this.commandDSIBrowserResponseSetSearchString(object);
        }
        if (string.equals(CMD_MEDIA_DSI_BROWSER_UPDATE_SEARCH_SIZE)) {
            return this.commandDSIBrowserUpdateSearchSize(object);
        }
        if (string.equals(CMD_MEDIA_DSI_BROWSER_RESPONSE_SELECT_SEARCH_RESULT)) {
            return this.commandDSIBrowserResponseSelectSearchResult(object);
        }
        if (string.equals(CMD_EJECTCD)) {
            IServiceTracker iServiceTracker = this.serviceManager.createServiceTracker(class$de$audi$atip$interapp$IEjectHandler == null ? (class$de$audi$atip$interapp$IEjectHandler = MediaDSISimulation.class$("de.audi.atip.interapp.IEjectHandler")) : class$de$audi$atip$interapp$IEjectHandler, new ServiceTrackerCustomizer(){

                public void removedService(ServiceReference serviceReference, Object object) {
                }

                public void modifiedService(ServiceReference serviceReference, Object object) {
                }

                public Object addingService(ServiceReference serviceReference) {
                    IEjectHandler iEjectHandler = (IEjectHandler)MediaDSISimulation.this.serviceManager.getService(serviceReference);
                    iEjectHandler.ejectCD();
                    MediaDSISimulation.this.serviceManager.releaseService(serviceReference);
                    return null;
                }
            });
            iServiceTracker.open();
            iServiceTracker.close();
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_ONLINE_INIT)) {
            final int n = Integer.parseInt(object.toString());
            this.serviceManager.createServiceTracker(class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = MediaDSISimulation.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener, new ServiceTrackerCustomizer(){

                public void removedService(ServiceReference serviceReference, Object object) {
                }

                public void modifiedService(ServiceReference serviceReference, Object object) {
                }

                public Object addingService(ServiceReference serviceReference) {
                    Integer n2 = (Integer)serviceReference.getProperty("DEVICE_INSTANCE");
                    if (n2 == null) {
                        return null;
                    }
                    if (n2 != n) {
                        return null;
                    }
                    String string = (String)serviceReference.getProperty("DEVICE_NAME");
                    if (string == null) {
                        return null;
                    }
                    if (!(class$org$dsi$ifc$media$DSIMediaOnlineListener == null ? (class$org$dsi$ifc$media$DSIMediaOnlineListener = MediaDSISimulation.class$("org.dsi.ifc.media.DSIMediaOnlineListener")) : class$org$dsi$ifc$media$DSIMediaOnlineListener).getName().equals(string)) {
                        return null;
                    }
                    Object object = MediaDSISimulation.this.serviceManager.getService(serviceReference);
                    if (object instanceof DSIMediaOnlineListener) {
                        MediaDSISimulation.this.hmiDSIMediaOnlineListener = (DSIMediaOnlineListener)object;
                        return object;
                    }
                    return null;
                }
            }).open();
            Hashtable hashtable = new Hashtable();
            hashtable.put("DEVICE_INSTANCE", new Integer(n));
            hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$media$DSIMediaOnline == null ? (class$org$dsi$ifc$media$DSIMediaOnline = MediaDSISimulation.class$("org.dsi.ifc.media.DSIMediaOnline")) : class$org$dsi$ifc$media$DSIMediaOnline).getName());
            this.serviceManager.registerService(class$org$dsi$ifc$media$DSIMediaOnline == null ? (class$org$dsi$ifc$media$DSIMediaOnline = MediaDSISimulation.class$("org.dsi.ifc.media.DSIMediaOnline")) : class$org$dsi$ifc$media$DSIMediaOnline, new DummyDSIMediaOnline(), hashtable);
            return 0;
        }
        if (string.equals(CMD_MEDIA_DSI_ONLINE_UPDATE_BUFFER_STATE)) {
            return this.commandDSIOnlineUpdateBufferState(object);
        }
        if (string.equals(CMD_MEDIA_DSI_ONLINE_UPDATE_BUFFER_FILL_INFO)) {
            return this.commandDSIOnlineUpdateBufferFillInfo(object);
        }
        if (string.equals(CMD_MEDIA_DSI_ONLINE_UPDATE_AUDIO_SETTINGS)) {
            return this.commandDSIOnlineUpdateAudioSettings(object);
        }
        return -10;
    }

    private int commandDSIBrowserUpdateSearchSpellerState(Object object) {
        if (this.hmiDSIMediaBrowserListener == null) {
            return -2;
        }
        int[] nArray = this.parseIntArgs(object, 2);
        if (nArray == null) {
            return -3;
        }
        this.hmiDSIMediaBrowserListener[nArray[0]].updateSearchSpellerState(nArray[1], 1);
        return 0;
    }

    private int commandDSIBrowserResponseSetSearchCriteria(Object object) {
        if (this.hmiDSIMediaBrowserListener == null) {
            return -2;
        }
        int[] nArray = this.parseIntArgs(object, 2);
        if (nArray == null) {
            return -3;
        }
        this.hmiDSIMediaBrowserListener[nArray[0]].responseSetSearchCriteria(0, nArray[1] == 1);
        return 0;
    }

    private int commandDSIBrowserResponseSearchListExt(Object object) {
        if (this.hmiDSIMediaBrowserListener == null) {
            return -2;
        }
        String[] stringArray = this.parseArgs(object.toString(), ";");
        SearchListEntryExt[] searchListEntryExtArray = new SearchListEntryExt[stringArray.length - 2];
        if (stringArray.length < 3) {
            return -3;
        }
        int n = Integer.parseInt(stringArray[0]);
        int n2 = Integer.parseInt(stringArray[1]);
        for (int i2 = 2; i2 < stringArray.length; ++i2) {
            SearchListEntryExt searchListEntryExt;
            String[] stringArray2 = this.parseArgs(stringArray[i2], ",");
            if (stringArray2.length != 6) {
                return -3;
            }
            long l = Long.valueOf(stringArray2[0]);
            int n3 = Integer.parseInt(stringArray2[2]);
            String string = stringArray2[1];
            String string2 = stringArray2[3];
            String string3 = stringArray2[4];
            int n4 = Integer.parseInt(stringArray2[5]);
            searchListEntryExtArray[i2 - 2] = searchListEntryExt = new SearchListEntryExt(l, 0L, string, n3, 0L, string2, 0L, string3, n4, null);
        }
        this.hmiDSIMediaBrowserListener[n].responseSearchListExt(searchListEntryExtArray, n2);
        return 0;
    }

    private int commandDSIBrowserResponseSearchList(Object object) {
        if (this.hmiDSIMediaBrowserListener == null) {
            return -2;
        }
        String[] stringArray = this.parseArgs(object.toString(), ";");
        SearchListEntry[] searchListEntryArray = new SearchListEntry[stringArray.length - 2];
        if (stringArray.length < 3) {
            return -3;
        }
        int n = Integer.parseInt(stringArray[0]);
        int n2 = Integer.parseInt(stringArray[1]);
        for (int i2 = 2; i2 < stringArray.length; ++i2) {
            String[] stringArray2 = this.parseArgs(stringArray[i2], ",");
            if (stringArray2.length != 3) {
                return -3;
            }
            SearchListEntry searchListEntry = new SearchListEntry();
            searchListEntry.searchID = Long.valueOf(stringArray2[0]);
            searchListEntry.tagType = Integer.parseInt(stringArray2[2]);
            searchListEntry.description = stringArray2[1];
            searchListEntryArray[i2 - 2] = searchListEntry;
        }
        this.hmiDSIMediaBrowserListener[n].responseSearchList(searchListEntryArray, n2);
        return 0;
    }

    private int commandDSIBrowserResponseSetSearchString(Object object) {
        if (this.hmiDSIMediaBrowserListener == null) {
            return -2;
        }
        int[] nArray = this.parseIntArgs(object, 2);
        if (nArray == null) {
            return -3;
        }
        this.hmiDSIMediaBrowserListener[nArray[0]].responseSetSearchString("testing", nArray[1] == 1);
        return 0;
    }

    private int commandDSIBrowserUpdateSearchSize(Object object) {
        if (this.hmiDSIMediaBrowserListener == null) {
            return -2;
        }
        int[] nArray = this.parseIntArgs(object, 5);
        if (nArray == null) {
            return -3;
        }
        try {
            new MethodCall(this.hmiDSIMediaBrowserListener[nArray[0]], "updateSearchSize").arg(nArray[1]).arg(nArray[2]).arg(nArray[3]).arg(nArray[4]).arg(1).call();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return -1;
        }
        return 0;
    }

    private int commandDSIBrowserResponseSelectSearchResult(Object object) {
        if (this.hmiDSIMediaBrowserListener == null) {
            return -2;
        }
        return 0;
    }

    private int commandDSIBrowserUpdateContentFilter(Object object) {
        int[] nArray = this.parseIntArgs(object, 2);
        if (nArray == null) {
            return -3;
        }
        if (this.hmiDSIMediaBrowserListener[nArray[0]] == null) {
            return -2;
        }
        this.hmiDSIMediaBrowserListener[nArray[0]].updateContentFilter(nArray[1], 1);
        return 0;
    }

    private int commandDSIBrowserSelectionResult(Object object) {
        int[] nArray = this.parseIntArgs(object, 8);
        if (nArray == null) {
            return -3;
        }
        if (this.hmiDSIMediaBrowserListener[nArray[0]] == null) {
            return -2;
        }
        this.hmiDSIMediaBrowserListener[nArray[0]].selectionResult(nArray[1], nArray[2], nArray[3] != 0, nArray[4], nArray[5], nArray[6], nArray[7], 0L);
        return 0;
    }

    private int commandDSIRecorderUpdateActiveMedia(Object object) {
        int[] nArray = this.parseIntArgs(object, 2);
        if (nArray == null) {
            return -3;
        }
        this.hmiDSIMediaRecorderListener.updateActiveMedia(nArray[0], nArray[1], 1);
        return 0;
    }

    private int commandDSIRecorderUpdateImportProgress(Object object) {
        String[] stringArray = this.parseArgs(object.toString(), ",");
        if (stringArray == null) {
            return -3;
        }
        if (stringArray.length != 2) {
            return -3;
        }
        ListEntry listEntry = new ListEntry(0L, stringArray[1], stringArray[1], 1, 1, 0, new ListEntryExt());
        this.hmiDSIMediaRecorderListener.updateImportProgress(Long.valueOf(stringArray[0]), listEntry, 1);
        return 0;
    }

    private int commandDSIRecorderUpdateDeletionProgress(Object object) {
        long l = Long.valueOf((String)object);
        this.hmiDSIMediaRecorderListener.updateDeletionProgress(l, 1);
        return 0;
    }

    private int commandDSIRecorderUpdateImportStatus(Object object) {
        int n = Integer.parseInt((String)object);
        this.hmiDSIMediaRecorderListener.updateImportStatus(n, 1);
        return 0;
    }

    private int commandDSIRecorderUpdateDeletionStatus(Object object) {
        int n = Integer.parseInt((String)object);
        this.hmiDSIMediaRecorderListener.updateDeletionStatus(n, 1);
        return 0;
    }

    private int commandDSIRecorderUpdateDatabaseSpace(Object object) {
        int[] nArray = this.parseIntArgs(object, 4);
        if (nArray == null) {
            return -3;
        }
        this.hmiDSIMediaRecorderListener.updateDatabaseSpace(new DatabaseSpace(nArray[0], nArray[1], nArray[2], nArray[3]), 1);
        return 0;
    }

    private int commandDSIRecorderResponseSetEncodingQuality(Object object) {
        int[] nArray = this.parseIntArgs(object, 1);
        if (nArray == null) {
            return -3;
        }
        this.hmiDSIMediaRecorderListener.responseSetEncodingQuality(nArray[0]);
        return 0;
    }

    private int commandDSIRecorderUpdateImportSummary(Object object) {
        int[] nArray = this.parseIntArgs(object, 4);
        if (nArray == null) {
            return -3;
        }
        this.hmiDSIMediaRecorderListener.updateImportSummary(nArray[0], nArray[1], nArray[2], nArray[3], 0L, 0L, 1);
        return 0;
    }

    private int commandDSIRecorderResponseSetSelection() {
        this.hmiDSIMediaRecorderListener.responseSetSelection(7, true);
        return 0;
    }

    private void commandDSIRecorderInit() {
        this.serviceManager.createServiceTracker(class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = MediaDSISimulation.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener, new ServiceTrackerCustomizer(){

            public void removedService(ServiceReference serviceReference, Object object) {
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public Object addingService(ServiceReference serviceReference) {
                Object object = MediaDSISimulation.this.serviceManager.getService(serviceReference);
                if (object instanceof DSIMediaRecorderListener) {
                    MediaDSISimulation.this.hmiDSIMediaRecorderListener = (DSIMediaRecorderListener)object;
                    return MediaDSISimulation.this.hmiDSIMediaRecorderListener;
                }
                return null;
            }
        }).open();
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$media$DSIMediaRecorder == null ? (class$org$dsi$ifc$media$DSIMediaRecorder = MediaDSISimulation.class$("org.dsi.ifc.media.DSIMediaRecorder")) : class$org$dsi$ifc$media$DSIMediaRecorder).getName());
        this.serviceManager.registerService(class$org$dsi$ifc$media$DSIMediaRecorder == null ? (class$org$dsi$ifc$media$DSIMediaRecorder = MediaDSISimulation.class$("org.dsi.ifc.media.DSIMediaRecorder")) : class$org$dsi$ifc$media$DSIMediaRecorder, new DummyDSIMediaRecorder(), hashtable);
    }

    private int commandDSIPlayerTempPmlRequest(Object object) {
        if (this.hmiDSIMediaPlayerListener == null) {
            return -2;
        }
        int n = Integer.parseInt((String)object);
        this.hmiDSIMediaPlayerListener.tempPMLRequest(n);
        return 0;
    }

    private int commandDSIBaseSetParentalML(Object object) {
        if (this.hmiDSIMediaPlayerListener == null) {
            return -2;
        }
        int n = Integer.parseInt((String)object);
        this.hmiDSIMediaBaseListener.updateParentalML(n, 1);
        return 0;
    }

    private int commandDSIPlayerUpdateSubtitleList(Object object) {
        if (this.hmiDSIMediaPlayerListener == null) {
            return -2;
        }
        String[] stringArray = this.parseArgs(object.toString(), ",");
        if (stringArray.length == 0) {
            this.hmiDSIMediaPlayerListener.updateSubtitleList(new int[0], 1);
            return 0;
        }
        int[] nArray = new int[stringArray.length];
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            nArray[i2] = Integer.parseInt(stringArray[i2]);
        }
        this.hmiDSIMediaPlayerListener.updateSubtitleList(nArray, 1);
        return 0;
    }

    private int commandDSIPlayerUpdateActiveSubtitle(Object object) {
        if (this.hmiDSIMediaPlayerListener == null) {
            return -2;
        }
        int n = Integer.parseInt((String)object);
        this.hmiDSIMediaPlayerListener.updateActiveSubtitle(n, 1);
        return 0;
    }

    private int commandDSIPlayerUpdateAudioStreamList(Object object) {
        if (this.hmiDSIMediaPlayerListener == null) {
            return -2;
        }
        String[] stringArray = this.parseArgs(object.toString(), ";");
        if (stringArray.length == 0) {
            return -3;
        }
        AudioStream[] audioStreamArray = new AudioStream[stringArray.length];
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            AudioStream audioStream;
            String[] stringArray2 = this.parseArgs(stringArray[i2], ",");
            if (stringArray2.length != 5) {
                return -3;
            }
            int n = Integer.parseInt(stringArray2[0]);
            int n2 = Integer.parseInt(stringArray2[1]);
            int n3 = Integer.parseInt(stringArray2[2]);
            int n4 = Integer.parseInt(stringArray2[3]);
            int n5 = Integer.parseInt(stringArray2[4]);
            audioStreamArray[i2] = audioStream = new AudioStream(n, n2, n3, n4, n5);
        }
        this.hmiDSIMediaPlayerListener.updateAudioStreamList(audioStreamArray, 1);
        return 0;
    }

    private int commandDSIOnlineUpdateBufferState(Object object) {
        if (this.hmiDSIMediaOnlineListener == null) {
            return -2;
        }
        try {
            int n = Integer.parseInt((String)object);
            this.hmiDSIMediaOnlineListener.updateBufferState(n, 1);
        }
        catch (Exception exception) {
            return -1;
        }
        return 0;
    }

    private int commandDSIOnlineUpdateBufferFillInfo(Object object) {
        if (this.hmiDSIMediaOnlineListener == null) {
            return -2;
        }
        try {
            int[] nArray = this.parseIntArgs(object, 2);
            if (nArray == null) {
                return -3;
            }
            this.hmiDSIMediaOnlineListener.updateBufferFillInfo(nArray[0], nArray[1], 1);
        }
        catch (Exception exception) {
            return -1;
        }
        return 0;
    }

    private int commandDSIOnlineUpdateAudioSettings(Object object) {
        if (this.hmiDSIMediaOnlineListener == null) {
            return -2;
        }
        try {
            int[] nArray = this.parseIntArgs(object, 2);
            if (nArray == null) {
                return -3;
            }
            this.hmiDSIMediaOnlineListener.updateAudioSettings(nArray[0], nArray[1], 1);
        }
        catch (Exception exception) {
            return -1;
        }
        return 0;
    }

    private int commandDSIPlayerUpdateActiveAudioStream(Object object) {
        if (this.hmiDSIMediaPlayerListener == null) {
            return -2;
        }
        int n = Integer.parseInt((String)object);
        this.hmiDSIMediaPlayerListener.updateActiveAudioStream(n, 1);
        return 0;
    }

    private int[] parseIntArgs(Object object, int n) {
        int[] nArray = new int[n];
        String string = (String)object;
        String[] stringArray = this.parseArgs(string.toString(), ",");
        if (stringArray.length != n) {
            return null;
        }
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            nArray[i2] = Integer.parseInt(stringArray[i2]);
        }
        return nArray;
    }

    private String[] parseArgs(String string, String string2) {
        StringTokenizer stringTokenizer = new StringTokenizer(string, string2);
        ArrayList arrayList = new ArrayList(5);
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return (String[])arrayList.toArray(new String[arrayList.size()]);
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

