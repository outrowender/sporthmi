/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.combi.bap.CombiBAPController;
import de.audi.app.media.combi.bap.CombiBAPUtils;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCurrentStationInfo;
import de.esolutions.fw.util.commons.Buffer;

class CombiBAPController$CombiBapState {
    private static final String LOGCLASS;
    private volatile int sourceType = -1;
    private volatile int slotNumber = -1;
    private volatile int partitionNumber = -1;
    private volatile int infoState = -1;
    private volatile CombiBAPAudioSource[][] audioSources = new CombiBAPAudioSource[0][0];
    private volatile CombiBAPCurrentStationInfo station = new CombiBAPCurrentStationInfo("", 0, 0);
    private volatile boolean listAvailable = false;
    private volatile int listState = 4;
    private volatile int listSize = 0;
    private volatile boolean isPlaybackFolder = false;
    private final /* synthetic */ CombiBAPController this$0;

    CombiBAPController$CombiBapState(CombiBAPController combiBAPController) {
        this.this$0 = combiBAPController;
    }

    void updateActiveSource(int n, int n2, int n3, boolean bl, boolean bl2, int n4) {
        this.sourceType = n;
        this.slotNumber = n2;
        this.partitionNumber = n3;
        this.listAvailable = bl;
        this.listState = n4;
        this.this$0.logCombi.log(14808325, "[%1.updateActiveSource] sourceType=%2", (Object)"CombiBapState", (Object)this.getSourceTypeString(this.sourceType));
        this.this$0.getCombiBAPService().updateActiveSource(n, this.slotNumber, this.partitionNumber, bl, bl2, n4);
        if (n == 15 || n == 19) {
            this.updateActiveInfoState(this.infoState);
            this.updateCurrentStationInfo(this.station);
        }
    }

    void updateActiveInfoState(int n) {
        this.infoState = n;
        this.this$0.logCombi.log(14808325, "[%1.updateActiveInfoState] infoStatee=%2", (Object)"CombiBapState", (Object)CombiBAPUtils.getInfoStateString(this.infoState));
        this.this$0.getCombiBAPService().updateActiveInfoState(this.infoState);
    }

    void updateCurrentStationInfo(CombiBAPCurrentStationInfo combiBAPCurrentStationInfo) {
        this.this$0.logCombi.log(14808325, "[%1.updateCurrentStationInfo]", (Object)"CombiBapState");
        this.station = combiBAPCurrentStationInfo;
        this.this$0.getCombiBAPService().updateCurrentStation(combiBAPCurrentStationInfo);
    }

    void updateSourceList(int[] nArray, CombiBAPAudioSource[][] combiBAPAudioSourceArray) {
        this.this$0.logCombi.log(1078071040, "[%1.updateSourceList]", (Object)"CombiBapState");
        this.audioSources = combiBAPAudioSourceArray;
        try {
            int n;
            for (n = 0; n < combiBAPAudioSourceArray.length; ++n) {
                int n2 = nArray[n];
                for (int i2 = 0; i2 < combiBAPAudioSourceArray[n].length; ++i2) {
                    Buffer buffer = new Buffer(200);
                    buffer.append(this.getSourceTypeString(n2));
                    CombiBAPAudioSource combiBAPAudioSource = combiBAPAudioSourceArray[n][i2];
                    buffer.append("(").append(this.getMediaTypeString(combiBAPAudioSource.getMediaType()));
                    buffer.append(",").append(combiBAPAudioSource.getName());
                    buffer.append(",").append(combiBAPAudioSource.getSlotNumber());
                    buffer.append(",").append(combiBAPAudioSource.getPartitionNumber()).append(")");
                    this.this$0.logCombi.log(1078071040, "[%1.updateSourceList] %2", (Object)"CombiBapState", (Object)buffer);
                }
            }
            for (n = 0; n < nArray.length; ++n) {
                if (nArray[n] != 11 || combiBAPAudioSourceArray[n].length != 1) continue;
                this.this$0.logCombi.log(1078071040, "[%1.updateSourceList] setSlotNumber(-1) for SD-Card.", (Object)"CombiBapState");
                combiBAPAudioSourceArray[n][0].setSlotNumber(-1);
            }
            this.this$0.getCombiBAPService().updateSourceListMedia(nArray, this.audioSources);
        }
        catch (Exception exception) {
            this.this$0.logCombi.log(10000, "[%1.updateSourceList] ", (Object)"CombiBapState", (Throwable)exception);
        }
    }

    public void resetMedia() {
        this.this$0.logCombi.log(1078071040, "[%1.resetMedia]", (Object)"CombiBapState");
        this.updateActiveSource(0, 0, 0, false, false, 0);
        this.updateActiveInfoState(9);
        this.updateCurrentStationInfo(new CombiBAPCurrentStationInfo("", 0, 0));
    }

    void updateListSize(int n) {
        this.listSize = n;
        try {
            this.this$0.getCombiBAPService().updateBrowserListSize(this.listSize);
        }
        catch (Exception exception) {
            this.this$0.logCombi.log(10000, "[%1.updateListSize] %2", (Object)"CombiBapState", (Throwable)exception);
        }
    }

    void updatePlaybackFolder(boolean bl) {
        this.this$0.logCombi.log(1078071040, "[%2.updatePlaybackFolder] '%1'", this.isPlaybackFolder, (Object)"CombiBapState");
        this.isPlaybackFolder = bl;
        try {
            this.this$0.getCombiBAPService().updatePlaybackFolder(this.isPlaybackFolder);
        }
        catch (Exception exception) {
            this.this$0.logCombi.log(10000, "[%1.updatePlaybackFolder] %2", (Object)"CombiBapState", (Throwable)exception);
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(200);
        buffer.append("sourceType=").append(this.getSourceTypeString(this.sourceType));
        buffer.append("(").append(this.sourceType).append(")");
        buffer.append(" ,slotNumber=").append(this.slotNumber);
        buffer.append(" ,partitionNumber=").append(this.partitionNumber).append("\n");
        buffer.append("infoState=").append(CombiBAPUtils.getInfoStateString(this.infoState));
        buffer.append("(").append(this.infoState).append(")\n");
        buffer.append("station: ");
        if (this.station == null) {
            buffer.append("noStation");
        } else {
            buffer.append("'").append(this.station.getPrimaryInformation()).append("'\n");
        }
        buffer.append(" ,listAvailable=").append(this.listAvailable).append("\n");
        buffer.append(" ,listState=").append(this.getListStateString()).append("\n");
        buffer.append(" ,listSize=").append(this.listSize).append("\n");
        buffer.append(" ,isPlaybackFolder=").append(this.isPlaybackFolder).append("\n");
        buffer.append("SourceList: ").append(this.audioSources.length).append("\n");
        for (int i2 = 0; i2 < this.audioSources.length; ++i2) {
            for (int i3 = 0; i3 < this.audioSources[i2].length; ++i3) {
                buffer.append(this.audioSources[i2][i3]).append("\n");
            }
        }
        return buffer.toString();
    }

    String getSourceTypeString(int n) {
        String string;
        switch (n) {
            case 13: {
                string = "SOURCE_TYPE_AUX_IN_AUDIO";
                break;
            }
            case 9: {
                string = "SOURCE_TYPE_AUX_IN_AUDIO";
                break;
            }
            case 21: {
                string = "SOURCE_TYPE_BLUETOOTH_CONNECTION_BT_STREAM";
                break;
            }
            case 22: {
                string = "SOURCE_TYPE_BLUETOOTH_CONNECTION_REMOTE_CONTROL_PROTOCOL";
                break;
            }
            case 7: {
                string = "SOURCE_TYPE_CD_CHANGER";
                break;
            }
            case 6: {
                string = "SOURCE_TYPE_CD";
                break;
            }
            case 18: {
                string = "SOURCE_TYPE_DVD_CHANGER";
                break;
            }
            case 8: {
                string = "SOURCE_TYPE_DVD";
                break;
            }
            case 20: {
                string = "SOURCE_TYPE_JUKEBOX";
                break;
            }
            case 11: {
                string = "SOURCE_TYPE_SD";
                break;
            }
            case 19: {
                string = "SOURCE_TYPE_USB";
                break;
            }
            case 27: {
                string = "SOURCE_TYPE_WLAN_CONNECTION_MASS_STORAGE";
                break;
            }
            case 34: {
                string = "SOURCE_TYPE_ONLINE_MASS_STORAGE_DF4_1";
                break;
            }
            case 15: {
                string = "SOURCE_TYPE_PORTABLE_DEVICE_MDI_AMI";
                break;
            }
            default: {
                string = "SOURCE_TYPE_NO_SOURCE";
            }
        }
        return string;
    }

    String getListStateString() {
        String string;
        switch (this.listState) {
            case 0: {
                string = "LIST_STATE_UNKNOW";
                break;
            }
            case 1: {
                string = "LIST_STATE_LOADING";
                break;
            }
            case 3: {
                string = "LIST_STATE_COMPLETELY_LOADED";
                break;
            }
            case 2: {
                string = "LIST_STATE_INCOMPLETE_LOADED";
                break;
            }
            default: {
                string = "Unknown list State";
            }
        }
        return string;
    }

    String getMediaTypeString(int n) {
        String string;
        switch (n) {
            case 0: {
                string = "MEDIA_TYPE_MEDIA_TYPE_NOT_AVAIALBLE_NOT_APPLICABLE";
                break;
            }
            case 1: {
                string = "MEDIA_TYPE_CD_AUDIO";
                break;
            }
            case 2: {
                string = "MEDIA_TYPE_DVD_AUDIO";
                break;
            }
            case 3: {
                string = "MEDIA_TYPE_DVD_VIDEO";
                break;
            }
            case 4: {
                string = "MEDIA_TYPE_CD_VIDEO";
                break;
            }
            case 5: {
                string = "MEDIA_TYPE_CD_ROM";
                break;
            }
            case 6: {
                string = "MEDIA_TYPE_DVD_ROM";
                break;
            }
            case 7: {
                string = "MEDIA_TYPE_FILE_SYSTEM";
                break;
            }
            case 8: {
                string = "MEDIA_TYPE_RAW";
                break;
            }
            case 9: {
                string = "MEDIA_TYPE_RCP_REMOTE_CONTROL_PROTOCOL";
                break;
            }
            case 10: {
                string = "MEDIA_TYPE_AUDIO_BROADCASTING_RADIO";
                break;
            }
            case 11: {
                string = "MEDIA_TYPE_VIDEO_BROADCASTING_TV_DVB";
                break;
            }
            case 12: {
                string = "MEDIA_TYPE_I_POD";
                break;
            }
            case 13: {
                string = "MEDIA_TYPE_BLUE_RAY";
                break;
            }
            case 255: {
                string = "MEDIA_TYPE_UNKNOWN_MEDIA_TYPE";
                break;
            }
            default: {
                string = "UNKNOWN";
            }
        }
        return string;
    }
}

