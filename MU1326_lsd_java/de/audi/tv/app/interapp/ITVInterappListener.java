/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.interapp;

public interface ITVInterappListener {
    public static final int TV_STATION_FLAG_UNAVAILABLE = 0;
    public static final int TV_STATION_FLAG_LOADING = 1;
    public static final int TV_STATION_FLAG_AVAILABLE = 2;
    public static final int TV_STATE_MUTE_OK = 0;
    public static final int TV_STATE_MUTE_DROP_OUT = 1;
    public static final int TV_STATE_MUTE_NO_RECEPTION = 2;
    public static final int TV_STATE_MUTE_NO_AUDIO_SERVICE = 3;
    public static final byte TV_TM_UNAVAILABLE = 0;
    public static final byte TV_TM_OFF = 1;
    public static final byte TV_TM_TV = 2;
    public static final byte TV_TM_EPG = 3;
    public static final byte TV_TM_TELETEXT = 4;
    public static final byte TV_TM_SEARCH = 5;
    public static final byte TV_TM_DATABROADCAST_DVB = 6;
    public static final byte TV_TM_DATABROADCAST_ISDB = 7;
    public static final byte TV_TM_DATABROADCAST_DTMB_CMMB = 8;
    public static final byte TV_TM_DATABROADCAST_DMB = 9;
    public static final byte TV_TM_DATABROADCAST_ATSC = 10;
    public static final byte TV_TM_DATABROADCAST_1 = 11;
    public static final byte TV_TM_DATABROADCAST_2 = 12;
    public static final byte TV_TM_BWS = 13;
    public static final byte TV_TM_SLS_DLS = 14;
    public static final byte TV_TM_TXT = 15;
    public static final byte TV_TM_CAS = 16;
    public static final byte TV_TM_VISUAL_AUDIO = 17;
    public static final byte TV_TM_ENGINEERING = 18;
    public static final byte TV_TM_AV = 19;
    public static final byte TV_TM_INITIALIZING_TV = 20;
    public static final byte TV_TM_INITIALIZING_AV = 21;
    public static final byte TV_TM_OTHER = 127;

    public void updateActiveStation(ActiveStationInfo var1);

    public void updateSeekStatus(boolean var1);

    public void updateTVStationList(ServiceInfo[] var1);

    public void enforceTV();

    public void updateTerminalMode(byte var1);

    public void updatePanelKeySet(short[] var1);

    public void updateParentalSettings(boolean var1, int var2);

    public void updateTvTunerConfig(TvTunerConfig var1);

    public void updateTvState(TvState var1);

    public static class TvState {
        public int muteState;

        public TvState(int n) {
            this.muteState = n;
        }
    }

    public static class ProgramInfo {
        public String name;
        public int startHour;
        public int startMinute;
        public int startSecond;
        public int endHour;
        public int endMinute;
        public int endSecond;

        public ProgramInfo(String string, int n, int n2, int n3, int n4, int n5, int n6) {
            this.name = string;
            this.startHour = n;
            this.startMinute = n2;
            this.startSecond = n3;
            this.endHour = n4;
            this.endMinute = n5;
            this.endSecond = n6;
        }
    }

    public static class ServiceInfo {
        public long id;
        public String name;
        public int serviceType;
        public int contentGroup;

        public ServiceInfo(long l, String string, int n, int n2) {
            this.id = l;
            this.name = string;
            this.serviceType = n;
            this.contentGroup = n2;
        }
    }

    public static class AudioChannel {
        public int id;
        public String language;
        public int format;
        public int description;

        public AudioChannel(int n, String string, int n2, int n3) {
            this.id = n;
            this.language = string;
            this.format = n2;
            this.description = n3;
        }
    }

    public static class TvTunerConfig {
        public boolean serviceLinking = false;
        public boolean avSource = false;
        public boolean tvNorm = false;
        public boolean audioChannels = false;
        public boolean videoFormat = false;
        public boolean avNorm = false;
        public boolean avFormat = false;
        public boolean subtitle = false;
        public boolean ews = false;
        public boolean logoList = false;
        public boolean cas = false;
        public boolean skip = false;
        public boolean visualAudio = false;
        public boolean sorting = false;
        public boolean parentalControl = false;
        public boolean tmTeletext = false;
        public boolean tmDvb = false;
        public boolean tmIsdb = false;
        public boolean tmDtmb = false;
        public boolean tmDmb = false;
        public boolean tmAtsc = false;
        public boolean tmDb1 = false;
        public boolean tmDb2 = false;
        public boolean tmBws = false;
        public boolean tmSls = false;
        public boolean tmTxt = false;
        public boolean tmCas = false;
        public boolean tmEpg = false;
        public boolean tmVisualAudio = false;

        public TvTunerConfig(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14, boolean bl15, boolean bl16, boolean bl17, boolean bl18, boolean bl19, boolean bl20, boolean bl21, boolean bl22, boolean bl23, boolean bl24, boolean bl25, boolean bl26, boolean bl27, boolean bl28, boolean bl29) {
            this.serviceLinking = bl;
            this.avSource = bl2;
            this.tvNorm = bl3;
            this.audioChannels = bl4;
            this.videoFormat = bl5;
            this.avNorm = bl6;
            this.avFormat = bl7;
            this.subtitle = bl8;
            this.ews = bl9;
            this.logoList = bl10;
            this.cas = bl11;
            this.skip = bl12;
            this.visualAudio = bl13;
            this.sorting = bl14;
            this.parentalControl = bl15;
            this.tmTeletext = bl16;
            this.tmDvb = bl17;
            this.tmIsdb = bl18;
            this.tmDtmb = bl19;
            this.tmDmb = bl20;
            this.tmAtsc = bl21;
            this.tmDb1 = bl22;
            this.tmDb2 = bl23;
            this.tmBws = bl24;
            this.tmSls = bl25;
            this.tmTxt = bl26;
            this.tmCas = bl27;
            this.tmEpg = bl28;
            this.tmVisualAudio = bl29;
        }

        public TvTunerConfig() {
        }
    }

    public static class ActiveStationInfo {
        public long id;
        public String stationName;
        public String channelName;
        public int normArea;
        public int videoFormat;
        public int selectedAudioChannel;
        public int caDescriptor;
        public int casStatus;
        public int parentalRating;
        public int epgFlag;
        public int teletextFlag;
        public int dataBroadcastFlag;
        public int dataBroadcast1Flag;
        public int dataBroadcast2Flag;
        public int bwsFlag;
        public int slsFlag;
        public int txtFlag;
        public int casFlag;
        public int visualAudioFlag;
        public int ewsFlag;
        public int subtitleFlag;
        public ProgramInfo currentProgram;
        public ProgramInfo nextProgram;
        public AudioChannel[] audioChannels;

        public ActiveStationInfo(long l, String string, String string2, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17, int n18, ProgramInfo programInfo, ProgramInfo programInfo2, AudioChannel[] audioChannelArray) {
            this.id = l;
            this.stationName = string;
            this.channelName = string2;
            this.normArea = n;
            this.videoFormat = n2;
            this.selectedAudioChannel = n3;
            this.caDescriptor = n4;
            this.casStatus = n5;
            this.parentalRating = n6;
            this.epgFlag = n7;
            this.teletextFlag = n8;
            this.dataBroadcastFlag = n9;
            this.dataBroadcast1Flag = n10;
            this.dataBroadcast2Flag = n11;
            this.bwsFlag = n12;
            this.slsFlag = n13;
            this.txtFlag = n14;
            this.casFlag = n15;
            this.visualAudioFlag = n16;
            this.ewsFlag = n17;
            this.subtitleFlag = n18;
            this.currentProgram = programInfo;
            this.nextProgram = programInfo2;
            this.audioChannels = audioChannelArray;
        }
    }
}

