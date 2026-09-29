/*
 * Decompiled with CFR 0.152.
 */
package de.audi.swdiagnosis.media.dsi;

import de.audi.app.media.dsi.media.NullDSIMediaBrowser;
import de.audi.app.media.dsi.media.NullDSIMediaPlayer;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.util.MethodCall;
import de.audi.swdiagnosis.media.dsi.DummyDSIAlbumbrowser;
import de.audi.swdiagnosis.media.dsi.DummyDSIMediaOnline;
import de.audi.swdiagnosis.media.dsi.DummyDSIMediaRecorder;
import de.audi.swdiagnosis.media.dsi.DummySystemOutLogChannel;
import de.audi.swdiagnosis.media.dsi.MediaDSISimulation$1;
import de.audi.swdiagnosis.media.dsi.MediaDSISimulation$2;
import de.audi.swdiagnosis.media.dsi.MediaDSISimulation$3;
import de.audi.swdiagnosis.media.dsi.MediaDSISimulation$4;
import de.audi.swdiagnosis.media.dsi.MediaDSISimulation$5;
import de.audi.swdiagnosis.media.dsi.MediaDSISimulation$6;
import de.audi.swdiagnosis.media.dsi.MediaDSISimulation$7;
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

public class MediaDSISimulation
extends AbstractSwDiagnosis {
    private static final int VALID;
    private static final String CMD_MEDIA_DSI_BASE_INIT;
    private static final String CMD_MEDIA_DSI_BASE_UPDATE_MEDIA_LIST;
    private static final String CMD_MEDIA_DSI_BASE_UPDATE_DEVICE_LIST;
    private static final String CMD_MEDIA_DSI_BASE_RESPONSE_RESET_FACTORY_SETTINGS;
    private static final String CMD_MEDIA_DSI_PLAYER_INIT;
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_ACTIVE_MEDIA;
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_PLAYBACK_STATE;
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_PLAY_POSITION;
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_PLAYVIEW_SIZE;
    private static final String CMD_MEDIA_DSI_PLAYER_RESPONSE_PLAY_VIEW;
    private static final String CMD_MEDIA_DSI_PLAYER_RESPONSE_DETAIL_INFO;
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_CAPABILITIES;
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_PLAYBACK_FOLDER;
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_PLAYBACK_MODE;
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_PLAYBACK_MODE_LIST;
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_CMD_BLOCK;
    private static final String CMD_MEDIA_DSI_PLAYER_RESPONSE_CMD_BLOCKED;
    private static final String CMD_MEDIA_DSI_PLAYER_ASYNC_EXCEPTION;
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_VIDEO_FORMAT;
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_VIDEO_NORM;
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_SUBTITLE_LIST;
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_ACTIVE_SUBTITLE;
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_AUDIOSTREAM_LIST;
    private static final String CMD_MEDIA_DSI_PLAYER_UPDATE_ACTIVE_AUDIOSTREAM;
    private static final String CMD_MEDIA_DSI_PLAYER_RESPONSE_PLAYSIMILAR;
    private static final String CMD_MEDIA_DSI_PLAYER_RESPONSE_PLAYBACKURL;
    private static final String CMD_MEDIA_DSI_PLAYER_TEMP_PML_REQUEST;
    private static final String CMD_MEDIA_DSI_BASE_SET_PARENTAL_ML;
    private static final String CMD_MEDIA_DSI_BROWSER_INIT;
    private static final String CMD_MEDIA_DSI_BROWSER_ASYNC_EXCEPTION;
    private static final String CMD_MEDIA_DSI_BROWSER_UPDATE_BROWSE_MEDIA;
    private static final String CMD_MEDIA_DSI_BROWSER_UPDATE_LIST_SIZE;
    private static final String CMD_MEDIA_DSI_BROWSER_RESPONSE_LIST;
    private static final String CMD_MEDIA_DSI_BROWSER_UPDATE_BROWSE_FOLDER;
    private static final String CMD_MEDIA_DSI_BROWSER_UPDATE_BROWSE_MODE;
    private static final String CMD_MEDIA_DSI_BROWSER_SELECTION_RESULT;
    private static final String CMD_MEDIA_DSI_BROWSER_UPDATE_CONTENT_FILTER;
    private static final String CMD_MEDIA_DSI_COVERFLOW_INIT;
    private static final String CMD_MEDIA_DSI_COVERFLOW_UPDATE_BROWSER_STATE;
    private static final String CMD_MEDIA_DSI_COVERFLOW_ALBUM_IDX_FOR_FID;
    private static final String CMD_MEDIA_DSI_RECORDER_INIT;
    private static final String CMD_MEDIA_DSI_RECORDER_UPDATE_ACTIVE_MEDIA;
    private static final String CMD_MEDIA_DSI_RECORDER_UPDATE_IMPORT_PROGRESS;
    private static final String CMD_MEDIA_DSI_RECORDER_UPDATE_IMPORT_STATUS;
    private static final String CMD_MEDIA_DSI_RECORDER_UPDATE_DATABASE_SPACE;
    private static final String CMD_MEDIA_DSI_RECORDER_RESPONSE_SET_SELECTION;
    private static final String CMD_MEDIA_DSI_RECORDER_UPDATE_IMPORT_SUMMARY;
    private static final String CMD_MEDIA_DSI_RECORDER_UPDATE_DELETION_STATUS;
    private static final String CMD_MEDIA_DSI_RECORDER_UPDATE_DELETION_PROGRESS;
    private static final String CMD_MEDIA_DSI_RECORDER_RESPONSE_SET_ENCODING_QUALITY;
    private static final String CMD_MEDIA_DSI_BROWSER_UPDATE_SEARCH_SPELLER_STATE;
    private static final String CMD_MEDIA_DSI_BROWSER_RESPONSE_SET_SEARCH_CRITERIA;
    private static final String CMD_MEDIA_DSI_BROWSER_RESPONSE_SEARCH_LIST;
    private static final String CMD_MEDIA_DSI_BROWSER_RESPONSE_SET_SEARCH_STRING;
    private static final String CMD_MEDIA_DSI_BROWSER_UPDATE_SEARCH_SIZE;
    private static final String CMD_MEDIA_DSI_BROWSER_RESPONSE_SELECT_SEARCH_RESULT;
    private static final String CMD_MEDIA_DSI_BROWSER_RESPONSE_SEARCH_LIST_EXT;
    private static final String CMD_EJECTCD;
    private static final String CMD_MEDIA_DSI_ONLINE_INIT;
    private static final String CMD_MEDIA_DSI_ONLINE_UPDATE_BUFFER_STATE;
    private static final String CMD_MEDIA_DSI_ONLINE_UPDATE_BUFFER_FILL_INFO;
    private static final String CMD_MEDIA_DSI_ONLINE_UPDATE_AUDIO_SETTINGS;
    private static final String NO_TEXT;
    private static final String[] mediaCmds;
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

    @Override
    public int getId() {
        return 21000;
    }

    @Override
    public String getName() {
        return "AppMedia [DSI]";
    }

    @Override
    public String[] getKeys() {
        return new String[0];
    }

    @Override
    public Object getValue(String string) {
        return new String("");
    }

    @Override
    public String[] getCommands() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < mediaCmds.length; ++i2) {
            arrayList.add(mediaCmds[i2]);
        }
        return (String[])arrayList.toArray(new String[arrayList.size()]);
    }

    @Override
    public int processCommand(String string, Object object) {
        if (string.equals("dsi.base.init")) {
            this.serviceManager.createServiceTracker(class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = MediaDSISimulation.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener, new MediaDSISimulation$1(this)).open();
            return 0;
        }
        if (string.equals("dsi.base.updateMediaList")) {
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
                String string2 = stringArray2[3].equals("NoText") ? "" : stringArray2[3];
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
        if (string.equals("dsi.base.updateDeviceList")) {
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
        if (string.equals("dsi.base.responseResetFactorySettings")) {
            if (this.hmiDSIMediaBaseListener == null) {
                return -2;
            }
            this.hmiDSIMediaBaseListener.responseResetFactorySettings(Integer.parseInt(object.toString()), true);
            return 0;
        }
        if (string.equals("dsi.player.init")) {
            int n = Integer.parseInt(object.toString());
            this.serviceManager.createServiceTracker(class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = MediaDSISimulation.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener, new MediaDSISimulation$2(this, n)).open();
            Hashtable hashtable = new Hashtable();
            hashtable.put("DEVICE_INSTANCE", new Integer(n));
            hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$media$DSIMediaPlayer == null ? (class$org$dsi$ifc$media$DSIMediaPlayer = MediaDSISimulation.class$("org.dsi.ifc.media.DSIMediaPlayer")) : class$org$dsi$ifc$media$DSIMediaPlayer).getName());
            this.serviceManager.registerService(class$org$dsi$ifc$media$DSIMediaPlayer == null ? (class$org$dsi$ifc$media$DSIMediaPlayer = MediaDSISimulation.class$("org.dsi.ifc.media.DSIMediaPlayer")) : class$org$dsi$ifc$media$DSIMediaPlayer, new NullDSIMediaPlayer(), hashtable);
            return 0;
        }
        if (string.equals("dsi.player.updateActiveMedia")) {
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
        if (string.equals("dsi.player.updatePlaybackState")) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            this.hmiDSIMediaPlayerListener.updatePlaybackState(Integer.parseInt(object.toString()), 1);
            return 0;
        }
        if (string.equals("dsi.player.updateVideoFormat")) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            this.hmiDSIMediaPlayerListener.updateVideoFormat(Integer.parseInt(object.toString()), 1);
            return 0;
        }
        if (string.equals("dsi.player.updateVideoNorm")) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            this.hmiDSIMediaPlayerListener.updateVideoNorm(Integer.parseInt(object.toString()), 1);
            return 0;
        }
        if (string.equals("dsi.player.updateCmdBlockingMask")) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            this.hmiDSIMediaPlayerListener.updateCmdBlockingMask(Integer.parseInt(object.toString()), 1);
            return 0;
        }
        if (string.equals("dsi.player.responseCmdBlocked")) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            this.hmiDSIMediaPlayerListener.responseCmdBlocked(Integer.parseInt(object.toString()));
            return 0;
        }
        if (string.equals("dsi.player.updatePlayPosition")) {
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
        if (string.equals("dsi.player.updatePlayViewSize")) {
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
        if (string.equals("dsi.player.responsePlayView")) {
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
        if (string.equals("dsi.player.responseDetailInfo")) {
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
        if (string.equals("dsi.player.updateCapabilities")) {
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
        if (string.equals("dsi.player.updatePlaybackFolder")) {
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
        if (string.equals("dsi.browser.asyncException")) {
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
        if (string.equals("dsi.browser.init")) {
            int n = Integer.parseInt(object.toString());
            this.serviceManager.createServiceTracker(class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = MediaDSISimulation.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener, new MediaDSISimulation$3(this, n)).open();
            Hashtable hashtable = new Hashtable();
            hashtable.put("DEVICE_INSTANCE", new Integer(n));
            hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$media$DSIMediaBrowser == null ? (class$org$dsi$ifc$media$DSIMediaBrowser = MediaDSISimulation.class$("org.dsi.ifc.media.DSIMediaBrowser")) : class$org$dsi$ifc$media$DSIMediaBrowser).getName());
            this.serviceManager.registerService(class$org$dsi$ifc$media$DSIMediaBrowser == null ? (class$org$dsi$ifc$media$DSIMediaBrowser = MediaDSISimulation.class$("org.dsi.ifc.media.DSIMediaBrowser")) : class$org$dsi$ifc$media$DSIMediaBrowser, new NullDSIMediaBrowser(new DummySystemOutLogChannel()), hashtable);
            return 0;
        }
        if (string.equals("dsi.browser.updateBrowseMedia")) {
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
        if (string.equals("dsi.browser.updateListSize")) {
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
        if (string.equals("dsi.browser.responseList")) {
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
        if (string.equals("dsi.browser.updateBrowseFolder")) {
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
        if (string.equals("dsi.browser.updateBrowseMode")) {
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
        if (string.equals("dsi.browser.updateContentFilter")) {
            return this.commandDSIBrowserUpdateContentFilter(object);
        }
        if (string.equals("dsi.browser.selectionResult")) {
            return this.commandDSIBrowserSelectionResult(object);
        }
        if (string.equals("dsi.player.updatePlaybackMode")) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            int n = Integer.parseInt((String)object);
            this.hmiDSIMediaPlayerListener.updatePlaybackMode(n, 1);
            return 0;
        }
        if (string.equals("dsi.player.updatePlaybackModeList")) {
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
        if (string.equals("dsi.player.responsePlaySimilarEntry")) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            int n = Integer.parseInt((String)object);
            this.hmiDSIMediaPlayerListener.responsePlaySimilarEntry(-1L, n == 1);
            return 0;
        }
        if (string.equals("dsi.player.responsePlaybackUrl")) {
            this.hmiDSIMediaPlayerListener.responseSetPlaybackURL((String)object);
            return 0;
        }
        if (string.equals("dsi.player.updateSubtitleList")) {
            return this.commandDSIPlayerUpdateSubtitleList(object);
        }
        if (string.equals("dsi.player.updateActiveSubtitle")) {
            return this.commandDSIPlayerUpdateActiveSubtitle(object);
        }
        if (string.equals("dsi.player.updateAudioStreamList")) {
            return this.commandDSIPlayerUpdateAudioStreamList(object);
        }
        if (string.equals("dsi.player.updateActiveAudioStream")) {
            return this.commandDSIPlayerUpdateActiveAudioStream(object);
        }
        if (string.equals("dsi.player.tempPMLRequest")) {
            return this.commandDSIPlayerTempPmlRequest(object);
        }
        if (string.equals("dsi.base.setParentalML")) {
            return this.commandDSIBaseSetParentalML(object);
        }
        if (string.equals("dsi.player.asyncException")) {
            if (this.hmiDSIMediaPlayerListener == null) {
                return -2;
            }
            int n = Integer.parseInt((String)object);
            this.hmiDSIMediaPlayerListener.asyncException(0, "Error", n);
            return 0;
        }
        if (string.equals("dsi.coverflow.init")) {
            this.serviceManager.createServiceTracker(class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = MediaDSISimulation.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener, new MediaDSISimulation$4(this)).open();
            Hashtable hashtable = new Hashtable();
            hashtable.put("DEVICE_INSTANCE", new Integer(0));
            hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser == null ? (class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser = MediaDSISimulation.class$("org.dsi.ifc.albumbrowser.DSIAlbumBrowser")) : class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser).getName());
            this.serviceManager.registerService(class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser == null ? (class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser = MediaDSISimulation.class$("org.dsi.ifc.albumbrowser.DSIAlbumBrowser")) : class$org$dsi$ifc$albumbrowser$DSIAlbumBrowser, new DummyDSIAlbumbrowser(), hashtable);
            return 0;
        }
        if (string.equals("dsi.coverflow.updateBrowserState")) {
            if (this.hmiDSIAlbumbrowserListener == null) {
                return -2;
            }
            int n = Integer.parseInt((String)object);
            this.hmiDSIAlbumbrowserListener.updateBrowserState(n, 1);
            return 0;
        }
        if (string.equals("dsi.coverflow.albumIdxForFID")) {
            if (this.hmiDSIAlbumbrowserListener == null) {
                return -2;
            }
            int n = Integer.parseInt((String)object);
            this.hmiDSIAlbumbrowserListener.albumIdxForFID(1L, n);
            return 0;
        }
        if (string.equals("dsi.recorder.init")) {
            this.commandDSIRecorderInit();
            return 0;
        }
        if (string.equals("dsi.recorder.updateActiveMedia")) {
            if (this.hmiDSIMediaRecorderListener == null) {
                return -2;
            }
            return this.commandDSIRecorderUpdateActiveMedia(object);
        }
        if (string.equals("dsi.recorder.updateImportProgress")) {
            if (this.hmiDSIMediaRecorderListener == null) {
                return -2;
            }
            return this.commandDSIRecorderUpdateImportProgress(object);
        }
        if (string.equals("dsi.recorder.updateDeletionProgress")) {
            if (this.hmiDSIMediaRecorderListener == null) {
                return -2;
            }
            return this.commandDSIRecorderUpdateDeletionProgress(object);
        }
        if (string.equals("dsi.recorder.updateImportStatus")) {
            if (this.hmiDSIMediaRecorderListener == null) {
                return -2;
            }
            return this.commandDSIRecorderUpdateImportStatus(object);
        }
        if (string.equals("dsi.recorder.updateDeletionStatus")) {
            if (this.hmiDSIMediaRecorderListener == null) {
                return -2;
            }
            return this.commandDSIRecorderUpdateDeletionStatus(object);
        }
        if (string.equals("dsi.recorder.updateDatabaseSpace")) {
            if (this.hmiDSIMediaRecorderListener == null) {
                return -2;
            }
            return this.commandDSIRecorderUpdateDatabaseSpace(object);
        }
        if (string.equals("dsi.recorder.responseSetEncodingQuality")) {
            if (this.hmiDSIMediaRecorderListener == null) {
                return -2;
            }
            return this.commandDSIRecorderResponseSetEncodingQuality(object);
        }
        if (string.equals("dsi.recorder.responseSetSelection")) {
            if (this.hmiDSIMediaRecorderListener == null) {
                return -2;
            }
            return this.commandDSIRecorderResponseSetSelection();
        }
        if (string.equals("dsi.recorder.updateImportSummary")) {
            if (this.hmiDSIMediaRecorderListener == null) {
                return -2;
            }
            return this.commandDSIRecorderUpdateImportSummary(object);
        }
        if (string.equals("dsi.browser.updateSearchSpellerState")) {
            return this.commandDSIBrowserUpdateSearchSpellerState(object);
        }
        if (string.equals("dsi.browser.responseSetSearchCriteria")) {
            return this.commandDSIBrowserResponseSetSearchCriteria(object);
        }
        if (string.equals("dsi.browser.responseSearchList")) {
            return this.commandDSIBrowserResponseSearchList(object);
        }
        if (string.equals("dsi.browser.responseSearchListExt")) {
            return this.commandDSIBrowserResponseSearchListExt(object);
        }
        if (string.equals("dsi.browser.responseSetSearchString")) {
            return this.commandDSIBrowserResponseSetSearchString(object);
        }
        if (string.equals("dsi.browser.updateSearchSize")) {
            return this.commandDSIBrowserUpdateSearchSize(object);
        }
        if (string.equals("dsi.browser.responseSelectSearchResult")) {
            return this.commandDSIBrowserResponseSelectSearchResult(object);
        }
        if (string.equals("ejectCD")) {
            IServiceTracker iServiceTracker = this.serviceManager.createServiceTracker(class$de$audi$atip$interapp$IEjectHandler == null ? (class$de$audi$atip$interapp$IEjectHandler = MediaDSISimulation.class$("de.audi.atip.interapp.IEjectHandler")) : class$de$audi$atip$interapp$IEjectHandler, new MediaDSISimulation$5(this));
            iServiceTracker.open();
            iServiceTracker.close();
            return 0;
        }
        if (string.equals("dsi.online.init")) {
            int n = Integer.parseInt(object.toString());
            this.serviceManager.createServiceTracker(class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = MediaDSISimulation.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener, new MediaDSISimulation$6(this, n)).open();
            Hashtable hashtable = new Hashtable();
            hashtable.put("DEVICE_INSTANCE", new Integer(n));
            hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$media$DSIMediaOnline == null ? (class$org$dsi$ifc$media$DSIMediaOnline = MediaDSISimulation.class$("org.dsi.ifc.media.DSIMediaOnline")) : class$org$dsi$ifc$media$DSIMediaOnline).getName());
            this.serviceManager.registerService(class$org$dsi$ifc$media$DSIMediaOnline == null ? (class$org$dsi$ifc$media$DSIMediaOnline = MediaDSISimulation.class$("org.dsi.ifc.media.DSIMediaOnline")) : class$org$dsi$ifc$media$DSIMediaOnline, new DummyDSIMediaOnline(), hashtable);
            return 0;
        }
        if (string.equals("dsi.online.updateBufferState(state)")) {
            return this.commandDSIOnlineUpdateBufferState(object);
        }
        if (string.equals("dsi.online.updateBufferFillInfo(downloaded|total)")) {
            return this.commandDSIOnlineUpdateBufferFillInfo(object);
        }
        if (string.equals("dsi.online.updateAudioSettings(audioType|value)")) {
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
        this.serviceManager.createServiceTracker(class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = MediaDSISimulation.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener, new MediaDSISimulation$7(this)).open();
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

    static /* synthetic */ IServiceManager access$000(MediaDSISimulation mediaDSISimulation) {
        return mediaDSISimulation.serviceManager;
    }

    static /* synthetic */ DSIMediaBaseListener access$102(MediaDSISimulation mediaDSISimulation, DSIMediaBaseListener dSIMediaBaseListener) {
        mediaDSISimulation.hmiDSIMediaBaseListener = dSIMediaBaseListener;
        return mediaDSISimulation.hmiDSIMediaBaseListener;
    }

    static /* synthetic */ DSIMediaBaseListener access$100(MediaDSISimulation mediaDSISimulation) {
        return mediaDSISimulation.hmiDSIMediaBaseListener;
    }

    static /* synthetic */ DSIMediaPlayerListener access$202(MediaDSISimulation mediaDSISimulation, DSIMediaPlayerListener dSIMediaPlayerListener) {
        mediaDSISimulation.hmiDSIMediaPlayerListener = dSIMediaPlayerListener;
        return mediaDSISimulation.hmiDSIMediaPlayerListener;
    }

    static /* synthetic */ DSIMediaPlayerListener access$200(MediaDSISimulation mediaDSISimulation) {
        return mediaDSISimulation.hmiDSIMediaPlayerListener;
    }

    static /* synthetic */ DSIMediaBrowserListener[] access$300(MediaDSISimulation mediaDSISimulation) {
        return mediaDSISimulation.hmiDSIMediaBrowserListener;
    }

    static /* synthetic */ DSIAlbumBrowserListener access$402(MediaDSISimulation mediaDSISimulation, DSIAlbumBrowserListener dSIAlbumBrowserListener) {
        mediaDSISimulation.hmiDSIAlbumbrowserListener = dSIAlbumBrowserListener;
        return mediaDSISimulation.hmiDSIAlbumbrowserListener;
    }

    static /* synthetic */ DSIAlbumBrowserListener access$400(MediaDSISimulation mediaDSISimulation) {
        return mediaDSISimulation.hmiDSIAlbumbrowserListener;
    }

    static /* synthetic */ DSIMediaOnlineListener access$502(MediaDSISimulation mediaDSISimulation, DSIMediaOnlineListener dSIMediaOnlineListener) {
        mediaDSISimulation.hmiDSIMediaOnlineListener = dSIMediaOnlineListener;
        return mediaDSISimulation.hmiDSIMediaOnlineListener;
    }

    static /* synthetic */ DSIMediaRecorderListener access$602(MediaDSISimulation mediaDSISimulation, DSIMediaRecorderListener dSIMediaRecorderListener) {
        mediaDSISimulation.hmiDSIMediaRecorderListener = dSIMediaRecorderListener;
        return mediaDSISimulation.hmiDSIMediaRecorderListener;
    }

    static /* synthetic */ DSIMediaRecorderListener access$600(MediaDSISimulation mediaDSISimulation) {
        return mediaDSISimulation.hmiDSIMediaRecorderListener;
    }

    static {
        mediaCmds = new String[]{"ejectCD", "dsi.base.init", "dsi.base.updateMediaList", "dsi.base.updateDeviceList", "dsi.base.responseResetFactorySettings", "dsi.base.setParentalML", "dsi.player.init", "dsi.player.updateCapabilities", "dsi.player.updateActiveMedia", "dsi.player.updatePlaybackState", "dsi.player.updatePlayPosition", "dsi.player.updatePlayViewSize", "dsi.player.responsePlayView", "dsi.player.responseDetailInfo", "dsi.player.updatePlaybackFolder", "dsi.player.updatePlaybackMode", "dsi.player.updatePlaybackModeList", "dsi.player.updateVideoFormat", "dsi.player.updateVideoNorm", "dsi.player.updateSubtitleList", "dsi.player.updateActiveSubtitle", "dsi.player.updateAudioStreamList", "dsi.player.updateActiveAudioStream", "dsi.player.responsePlaySimilarEntry", "dsi.player.updateCmdBlockingMask", "dsi.player.responseCmdBlocked", "dsi.player.asyncException", "dsi.player.tempPMLRequest", "dsi.player.responsePlaybackUrl", "dsi.browser.init", "dsi.browser.asyncException", "dsi.browser.updateBrowseMedia", "dsi.browser.updateListSize", "dsi.browser.responseList", "dsi.browser.updateBrowseFolder", "dsi.browser.selectionResult", "dsi.browser.updateBrowseMode", "dsi.browser.updateContentFilter", "dsi.coverflow.init", "dsi.coverflow.updateBrowserState", "dsi.coverflow.albumIdxForFID", "dsi.recorder.init", "dsi.recorder.updateActiveMedia", "dsi.recorder.updateImportProgress", "dsi.recorder.updateImportStatus", "dsi.recorder.updateDeletionStatus", "dsi.recorder.updateDeletionProgress", "dsi.recorder.updateDatabaseSpace", "dsi.recorder.responseSetEncodingQuality", "dsi.recorder.responseSetSelection", "dsi.recorder.updateImportSummary", "dsi.browser.updateSearchSpellerState", "dsi.browser.responseSetSearchCriteria", "dsi.browser.responseSearchList", "dsi.browser.responseSetSearchString", "dsi.browser.updateSearchSize", "dsi.browser.responseSelectSearchResult", "dsi.browser.responseSearchListExt", "dsi.online.init", "dsi.online.updateBufferState(state)", "dsi.online.updateBufferFillInfo(downloaded|total)", "dsi.online.updateAudioSettings(audioType|value)"};
    }
}

