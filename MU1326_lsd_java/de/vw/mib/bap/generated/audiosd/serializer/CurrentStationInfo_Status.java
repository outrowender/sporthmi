/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.generated.audiosd.serializer.CurrentStationInfo_Status$StationInfoSwitches;
import de.vw.mib.bap.generated.audiosd.serializer.CurrentStationInfo_Status$StationProperties;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentStationInfo_Status
implements StatusProperty {
    public final BAPString primaryInformation = new BAPString(73);
    private static final int MAX_PRIMARY_INFORMATION_LENGTH;
    public int pi_Type;
    private static final int PI_TYPE_BITSIZE;
    public static final int PI_TYPE_ANY_TYPE_UNKNOWN;
    public static final int PI_TYPE_FOLDER;
    public static final int PI_TYPE_TRACK;
    public static final int PI_TYPE_PLAYLIST;
    public static final int PI_TYPE_PLAYLIST_FOLDER;
    public static final int PI_TYPE_ANY_CATEGORY_UNKNOWN_CATEGORY;
    public static final int PI_TYPE_AUDIO_FILE;
    public static final int PI_TYPE_VIDEO_FILE;
    public static final int PI_TYPE_LEGACY_AUDIO_TRACK_CD;
    public static final int PI_TYPE_CD_AUDIO_TRACK_CD_TEXT;
    public static final int PI_TYPE_VOICEMEMO_FILE;
    public static final int PI_TYPE_IMAGE_FILE;
    public static final int PI_TYPE_AUDIO_FOLDER;
    public static final int PI_TYPE_VIDEO_FOLDER;
    public static final int PI_TYPE_IMAGE_FOLDER;
    public static final int PI_TYPE_VOICEMEMO_FOLDER;
    public static final int PI_TYPE_CATEGORY_GENRE;
    public static final int PI_TYPE_CATEGORY_GENRES;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_GENRE;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_GENRES;
    public static final int PI_TYPE_CATEGORY_ARTIST;
    public static final int PI_TYPE_CATEGORY_ARTISTS;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_ARTIST;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_ARTISTS;
    public static final int PI_TYPE_CATEGORY_COMPOSER;
    public static final int PI_TYPE_CATEGORY_COMPOSERS;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_COMPOSER;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_COMPOSERS;
    public static final int PI_TYPE_CATEGORY_YEAR;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_YEAR;
    public static final int PI_TYPE_CATEGORY_COMMENT;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_COMMENT;
    public static final int PI_TYPE_CATEGORY_ALBUM;
    public static final int PI_TYPE_CATEGORY_ALBUMS;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_ALBUM;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_ALBUMS;
    public static final int PI_TYPE_CATEGORY_SONG;
    public static final int PI_TYPE_CATEGORY_SONGS;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_SONG;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_SONGS;
    public static final int PI_TYPE_CATEGORY_AUDIOBOOK;
    public static final int PI_TYPE_CATEGORY_AUDIOBOOKS;
    public static final int PI_TYPE_CATEGORY_ALL;
    public static final int PI_TYPE_CATEGORY_PODCAST;
    public static final int PI_TYPE_CATEGORY_PODCASTS;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_NOT_RATED;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_1_STAR;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_2_STARS;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_3_STARS;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_4_STARS;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_5_STARS;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_MOST_PLAYED;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_LAST_PLAYED;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_ON_THE_GO;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLISTS;
    public static final int PI_TYPE_CATEGORY_MOVIES_DF4_1;
    public static final int PI_TYPE_CATEGORY_MUSIC_VIDEOS_DF4_1;
    public static final int PI_TYPE_CATEGORY_VIDEO_PODCASTS_GERMAN_SENDUNGEN_DF4_1;
    public static final int PI_TYPE_CATEGORY_BORROWED_VIDEOS_DF4_1;
    public static final int PI_TYPE_CATEGORY_LAST_COPIED_FILES_DF4_1;
    public static final int PI_TYPE_CATEGORY_FAVORITES_DF4_1;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_PODCAST_DF4_1;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_PODCASTS_DF4_1;
    public static final int PI_TYPE_CATEGORY_VARIOUS_ARTISTS_DF4_1;
    public static final int PI_TYPE_DVD_MAIN_MENUE;
    public static final int PI_TYPE_DVD_CHAPTER;
    public static final int PI_TYPE_DVD_TITLE;
    public static final int PI_TYPE_CHANNEL;
    public static final int PI_TYPE_RADIO_STATION_FM_AM_AM_SW_AM_LW;
    public static final int PI_TYPE_SDARS_STATION;
    public static final int PI_TYPE_DAB_SERVICE;
    public static final int PI_TYPE_DVB_SERVICE_TV_STATION;
    public static final int PI_TYPE_TITLE_FORBIDDEN_IN_CASE_OF_LEGACY_AUDIO_CD;
    public static final int PI_TYPE_ARTIST;
    public static final int PI_TYPE_ALBUM;
    public static final int PI_TYPE_DAB_ENSEMBLE_DF_4_1;
    public static final int PI_TYPE_DAB_SECONDARY_SERVICE_DF_4_1;
    public static final int PI_TYPE_MODERATOR_DF_4_1;
    public static final int PI_TYPE_CONDUCTOR_DF_4_1;
    public static final int PI_TYPE_COMPOSER_DF_4_1;
    public static final int PI_TYPE_PROGRAM_NOW_DF_4_1;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOK_DF4_1;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOKS_DF4_1;
    public static final int PI_TYPE_CATEGORY_MOOD_DF4_1;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_MOOD_DF4_1;
    public static final int PI_TYPE_ONLINE_RADIO_STATION_DF4_2;
    public int pi_Id;
    private static final int PI_ID_BITSIZE;
    public final BAPString secondaryInformation = new BAPString(73);
    private static final int MAX_SECONDARY_INFORMATION_LENGTH;
    public int si_Type;
    private static final int SI_TYPE_BITSIZE;
    public static final int SI_TYPE_ANY_TYPE_UNKNOWN;
    public static final int SI_TYPE_FOLDER;
    public static final int SI_TYPE_TRACK;
    public static final int SI_TYPE_PLAYLIST;
    public static final int SI_TYPE_PLAYLIST_FOLDER;
    public static final int SI_TYPE_ANY_CATEGORY_UNKNOWN_CATEGORY;
    public static final int SI_TYPE_AUDIO_FILE;
    public static final int SI_TYPE_VIDEO_FILE;
    public static final int SI_TYPE_LEGACY_AUDIO_TRACK_CD;
    public static final int SI_TYPE_CD_AUDIO_TRACK_CD_TEXT;
    public static final int SI_TYPE_VOICEMEMO_FILE;
    public static final int SI_TYPE_IMAGE_FILE;
    public static final int SI_TYPE_AUDIO_FOLDER;
    public static final int SI_TYPE_VIDEO_FOLDER;
    public static final int SI_TYPE_IMAGE_FOLDER;
    public static final int SI_TYPE_VOICEMEMO_FOLDER;
    public static final int SI_TYPE_CATEGORY_GENRE;
    public static final int SI_TYPE_CATEGORY_GENRES;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_GENRE;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_GENRES;
    public static final int SI_TYPE_CATEGORY_ARTIST;
    public static final int SI_TYPE_CATEGORY_ARTISTS;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_ARTIST;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_ARTISTS;
    public static final int SI_TYPE_CATEGORY_COMPOSER;
    public static final int SI_TYPE_CATEGORY_COMPOSERS;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_COMPOSER;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_COMPOSERS;
    public static final int SI_TYPE_CATEGORY_YEAR;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_YEAR;
    public static final int SI_TYPE_CATEGORY_COMMENT;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_COMMENT;
    public static final int SI_TYPE_CATEGORY_ALBUM;
    public static final int SI_TYPE_CATEGORY_ALBUMS;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_ALBUM;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_ALBUMS;
    public static final int SI_TYPE_CATEGORY_SONG;
    public static final int SI_TYPE_CATEGORY_SONGS;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_SONG;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_SONGS;
    public static final int SI_TYPE_CATEGORY_AUDIOBOOK;
    public static final int SI_TYPE_CATEGORY_AUDIOBOOKS;
    public static final int SI_TYPE_CATEGORY_ALL;
    public static final int SI_TYPE_CATEGORY_PODCAST;
    public static final int SI_TYPE_CATEGORY_PODCASTS;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_NOT_RATED;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_1_STAR;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_2_STARS;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_3_STARS;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_4_STARS;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_5_STARS;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_MOST_PLAYED;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_LAST_PLAYED;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_ON_THE_GO;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLISTS;
    public static final int SI_TYPE_CATEGORY_MOVIES_DF4_1;
    public static final int SI_TYPE_CATEGORY_MUSIC_VIDEOS_DF4_1;
    public static final int SI_TYPE_CATEGORY_VIDEO_PODCASTS_GERMAN_SENDUNGEN_DF4_1;
    public static final int SI_TYPE_CATEGORY_BORROWED_VIDEOS_DF4_1;
    public static final int SI_TYPE_CATEGORY_LAST_COPIED_FILES_DF4_1;
    public static final int SI_TYPE_CATEGORY_FAVORITES_DF4_1;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_PODCAST_DF4_1;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_PODCASTS_DF4_1;
    public static final int SI_TYPE_CATEGORY_VARIOUS_ARTISTS_DF4_1;
    public static final int SI_TYPE_DVD_MAIN_MENUE;
    public static final int SI_TYPE_DVD_CHAPTER;
    public static final int SI_TYPE_DVD_TITLE;
    public static final int SI_TYPE_CHANNEL;
    public static final int SI_TYPE_RADIO_STATION_FM_AM_AM_SW_AM_LW;
    public static final int SI_TYPE_SDARS_STATION;
    public static final int SI_TYPE_DAB_SERVICE;
    public static final int SI_TYPE_DVB_SERVICE_TV_STATION;
    public static final int SI_TYPE_TITLE_FORBIDDEN_IN_CASE_OF_LEGACY_AUDIO_CD;
    public static final int SI_TYPE_ARTIST;
    public static final int SI_TYPE_ALBUM;
    public static final int SI_TYPE_DAB_ENSEMBLE_DF_4_1;
    public static final int SI_TYPE_DAB_SECONDARY_SERVICE_DF_4_1;
    public static final int SI_TYPE_MODERATOR_DF_4_1;
    public static final int SI_TYPE_CONDUCTOR_DF_4_1;
    public static final int SI_TYPE_COMPOSER_DF_4_1;
    public static final int SI_TYPE_PROGRAM_NOW_DF_4_1;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOK_DF4_1;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOKS_DF4_1;
    public static final int SI_TYPE_CATEGORY_MOOD_DF4_1;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_MOOD_DF4_1;
    public static final int SI_TYPE_ONLINE_RADIO_STATION_DF4_2;
    public final BAPString tertiaryInformation = new BAPString(73);
    private static final int MAX_TERTIARY_INFORMATION_LENGTH;
    public int ti_Type;
    private static final int TI_TYPE_BITSIZE;
    public static final int TI_TYPE_ANY_TYPE_UNKNOWN;
    public static final int TI_TYPE_FOLDER;
    public static final int TI_TYPE_TRACK;
    public static final int TI_TYPE_PLAYLIST;
    public static final int TI_TYPE_PLAYLIST_FOLDER;
    public static final int TI_TYPE_ANY_CATEGORY_UNKNOWN_CATEGORY;
    public static final int TI_TYPE_AUDIO_FILE;
    public static final int TI_TYPE_VIDEO_FILE;
    public static final int TI_TYPE_LEGACY_AUDIO_TRACK_CD;
    public static final int TI_TYPE_CD_AUDIO_TRACK_CD_TEXT;
    public static final int TI_TYPE_VOICEMEMO_FILE;
    public static final int TI_TYPE_IMAGE_FILE;
    public static final int TI_TYPE_AUDIO_FOLDER;
    public static final int TI_TYPE_VIDEO_FOLDER;
    public static final int TI_TYPE_IMAGE_FOLDER;
    public static final int TI_TYPE_VOICEMEMO_FOLDER;
    public static final int TI_TYPE_CATEGORY_GENRE;
    public static final int TI_TYPE_CATEGORY_GENRES;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_GENRE;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_GENRES;
    public static final int TI_TYPE_CATEGORY_ARTIST;
    public static final int TI_TYPE_CATEGORY_ARTISTS;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_ARTIST;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_ARTISTS;
    public static final int TI_TYPE_CATEGORY_COMPOSER;
    public static final int TI_TYPE_CATEGORY_COMPOSERS;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_COMPOSER;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_COMPOSERS;
    public static final int TI_TYPE_CATEGORY_YEAR;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_YEAR;
    public static final int TI_TYPE_CATEGORY_COMMENT;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_COMMENT;
    public static final int TI_TYPE_CATEGORY_ALBUM;
    public static final int TI_TYPE_CATEGORY_ALBUMS;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_ALBUM;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_ALBUMS;
    public static final int TI_TYPE_CATEGORY_SONG;
    public static final int TI_TYPE_CATEGORY_SONGS;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_SONG;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_SONGS;
    public static final int TI_TYPE_CATEGORY_AUDIOBOOK;
    public static final int TI_TYPE_CATEGORY_AUDIOBOOKS;
    public static final int TI_TYPE_CATEGORY_ALL;
    public static final int TI_TYPE_CATEGORY_PODCAST;
    public static final int TI_TYPE_CATEGORY_PODCASTS;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_NOT_RATED;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_1_STAR;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_2_STARS;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_3_STARS;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_4_STARS;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_5_STARS;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_MOST_PLAYED;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_LAST_PLAYED;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_ON_THE_GO;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLISTS;
    public static final int TI_TYPE_CATEGORY_MOVIES_DF4_1;
    public static final int TI_TYPE_CATEGORY_MUSIC_VIDEOS_DF4_1;
    public static final int TI_TYPE_CATEGORY_VIDEO_PODCASTS_GERMAN_SENDUNGEN_DF4_1;
    public static final int TI_TYPE_CATEGORY_BORROWED_VIDEOS_DF4_1;
    public static final int TI_TYPE_CATEGORY_LAST_COPIED_FILES_DF4_1;
    public static final int TI_TYPE_CATEGORY_FAVORITES_DF4_1;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_PODCAST_DF4_1;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_PODCASTS_DF4_1;
    public static final int TI_TYPE_CATEGORY_VARIOUS_ARTISTS_DF4_1;
    public static final int TI_TYPE_DVD_MAIN_MENUE;
    public static final int TI_TYPE_DVD_CHAPTER;
    public static final int TI_TYPE_DVD_TITLE;
    public static final int TI_TYPE_CHANNEL;
    public static final int TI_TYPE_RADIO_STATION_FM_AM_AM_SW_AM_LW;
    public static final int TI_TYPE_SDARS_STATION;
    public static final int TI_TYPE_DAB_SERVICE;
    public static final int TI_TYPE_DVB_SERVICE_TV_STATION;
    public static final int TI_TYPE_TITLE_FORBIDDEN_IN_CASE_OF_LEGACY_AUDIO_CD;
    public static final int TI_TYPE_ARTIST;
    public static final int TI_TYPE_ALBUM;
    public static final int TI_TYPE_DAB_ENSEMBLE_DF_4_1;
    public static final int TI_TYPE_DAB_SECONDARY_SERVICE_DF_4_1;
    public static final int TI_TYPE_MODERATOR_DF_4_1;
    public static final int TI_TYPE_CONDUCTOR_DF_4_1;
    public static final int TI_TYPE_COMPOSER_DF_4_1;
    public static final int TI_TYPE_PROGRAM_NOW_DF_4_1;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOK_DF4_1;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOKS_DF4_1;
    public static final int TI_TYPE_CATEGORY_MOOD_DF4_1;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_MOOD_DF4_1;
    public static final int TI_TYPE_ONLINE_RADIO_STATION_DF4_2;
    public final BAPString quaternaryInformation = new BAPString(73);
    private static final int MAX_QUATERNARY_INFORMATION_LENGTH;
    public int qi_Type;
    private static final int QI_TYPE_BITSIZE;
    public static final int QI_TYPE_ANY_TYPE_UNKNOWN;
    public static final int QI_TYPE_FOLDER;
    public static final int QI_TYPE_TRACK;
    public static final int QI_TYPE_PLAYLIST;
    public static final int QI_TYPE_PLAYLIST_FOLDER;
    public static final int QI_TYPE_ANY_CATEGORY_UNKNOWN_CATEGORY;
    public static final int QI_TYPE_AUDIO_FILE;
    public static final int QI_TYPE_VIDEO_FILE;
    public static final int QI_TYPE_LEGACY_AUDIO_TRACK_CD;
    public static final int QI_TYPE_CD_AUDIO_TRACK_CD_TEXT;
    public static final int QI_TYPE_VOICEMEMO_FILE;
    public static final int QI_TYPE_IMAGE_FILE;
    public static final int QI_TYPE_AUDIO_FOLDER;
    public static final int QI_TYPE_VIDEO_FOLDER;
    public static final int QI_TYPE_IMAGE_FOLDER;
    public static final int QI_TYPE_VOICEMEMO_FOLDER;
    public static final int QI_TYPE_CATEGORY_GENRE;
    public static final int QI_TYPE_CATEGORY_GENRES;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_GENRE;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_GENRES;
    public static final int QI_TYPE_CATEGORY_ARTIST;
    public static final int QI_TYPE_CATEGORY_ARTISTS;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_ARTIST;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_ARTISTS;
    public static final int QI_TYPE_CATEGORY_COMPOSER;
    public static final int QI_TYPE_CATEGORY_COMPOSERS;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_COMPOSER;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_COMPOSERS;
    public static final int QI_TYPE_CATEGORY_YEAR;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_YEAR;
    public static final int QI_TYPE_CATEGORY_COMMENT;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_COMMENT;
    public static final int QI_TYPE_CATEGORY_ALBUM;
    public static final int QI_TYPE_CATEGORY_ALBUMS;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_ALBUM;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_ALBUMS;
    public static final int QI_TYPE_CATEGORY_SONG;
    public static final int QI_TYPE_CATEGORY_SONGS;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_SONG;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_SONGS;
    public static final int QI_TYPE_CATEGORY_AUDIOBOOK;
    public static final int QI_TYPE_CATEGORY_AUDIOBOOKS;
    public static final int QI_TYPE_CATEGORY_ALL;
    public static final int QI_TYPE_CATEGORY_PODCAST;
    public static final int QI_TYPE_CATEGORY_PODCASTS;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_NOT_RATED;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_1_STAR;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_2_STARS;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_3_STARS;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_4_STARS;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_5_STARS;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_MOST_PLAYED;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_LAST_PLAYED;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_ON_THE_GO;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLISTS;
    public static final int QI_TYPE_CATEGORY_MOVIES_DF4_1;
    public static final int QI_TYPE_CATEGORY_MUSIC_VIDEOS_DF4_1;
    public static final int QI_TYPE_CATEGORY_VIDEO_PODCASTS_GERMAN_SENDUNGEN_DF4_1;
    public static final int QI_TYPE_CATEGORY_BORROWED_VIDEOS_DF4_1;
    public static final int QI_TYPE_CATEGORY_LAST_COPIED_FILES_DF4_1;
    public static final int QI_TYPE_CATEGORY_FAVORITES_DF4_1;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_PODCAST_DF4_1;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_PODCASTS_DF4_1;
    public static final int QI_TYPE_CATEGORY_VARIOUS_ARTISTS_DF4_1;
    public static final int QI_TYPE_DVD_MAIN_MENUE;
    public static final int QI_TYPE_DVD_CHAPTER;
    public static final int QI_TYPE_DVD_TITLE;
    public static final int QI_TYPE_CHANNEL;
    public static final int QI_TYPE_RADIO_STATION_FM_AM_AM_SW_AM_LW;
    public static final int QI_TYPE_SDARS_STATION;
    public static final int QI_TYPE_DAB_SERVICE;
    public static final int QI_TYPE_DVB_SERVICE_TV_STATION;
    public static final int QI_TYPE_TITLE_FORBIDDEN_IN_CASE_OF_LEGACY_AUDIO_CD;
    public static final int QI_TYPE_ARTIST;
    public static final int QI_TYPE_ALBUM;
    public static final int QI_TYPE_DAB_ENSEMBLE_DF_4_1;
    public static final int QI_TYPE_DAB_SECONDARY_SERVICE_DF_4_1;
    public static final int QI_TYPE_MODERATOR_DF_4_1;
    public static final int QI_TYPE_CONDUCTOR_DF_4_1;
    public static final int QI_TYPE_COMPOSER_DF_4_1;
    public static final int QI_TYPE_PROGRAM_NOW_DF_4_1;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOK_DF4_1;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOKS_DF4_1;
    public static final int QI_TYPE_CATEGORY_MOOD_DF4_1;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_MOOD_DF4_1;
    public static final int QI_TYPE_ONLINE_RADIO_STATION_DF4_2;
    public final CurrentStationInfo_Status$StationInfoSwitches stationInfoSwitches = new CurrentStationInfo_Status$StationInfoSwitches();
    public final CurrentStationInfo_Status$StationProperties stationProperties = new CurrentStationInfo_Status$StationProperties();
    public int channel_Id;
    private static final int CHANNEL_ID_BITSIZE;

    public CurrentStationInfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentStationInfo_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pi_Type = 0;
        this.pi_Id = 0;
        this.si_Type = 0;
        this.ti_Type = 0;
        this.qi_Type = 0;
        this.channel_Id = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.primaryInformation.reset();
        this.secondaryInformation.reset();
        this.tertiaryInformation.reset();
        this.quaternaryInformation.reset();
        this.stationInfoSwitches.reset();
        this.stationProperties.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentStationInfo_Status currentStationInfo_Status = (CurrentStationInfo_Status)bAPEntity;
        return this.primaryInformation.equalTo(currentStationInfo_Status.primaryInformation) && this.pi_Type == currentStationInfo_Status.pi_Type && this.pi_Id == currentStationInfo_Status.pi_Id && this.secondaryInformation.equalTo(currentStationInfo_Status.secondaryInformation) && this.si_Type == currentStationInfo_Status.si_Type && this.tertiaryInformation.equalTo(currentStationInfo_Status.tertiaryInformation) && this.ti_Type == currentStationInfo_Status.ti_Type && this.quaternaryInformation.equalTo(currentStationInfo_Status.quaternaryInformation) && this.qi_Type == currentStationInfo_Status.qi_Type && this.stationInfoSwitches.equalTo(currentStationInfo_Status.stationInfoSwitches) && this.stationProperties.equalTo(currentStationInfo_Status.stationProperties) && this.channel_Id == currentStationInfo_Status.channel_Id;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CurrentStationInfo_Status:");
        stringBuffer.append("\n - PrimaryInformation - ");
        stringBuffer.append(this.primaryInformation.toString());
        stringBuffer.append("\n - PI_Type: ");
        switch (this.pi_Type) {
            case 0: {
                stringBuffer.append("0x00 (any type / unknown)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (folder)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (track)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (playlist)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (playlist folder)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (any category / unknown category)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (audio file)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (video file)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (legacy audio track (CD))");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (CD audio track - CD text)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (voicememo file)");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (image file)");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (audio folder)");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (video folder)");
                break;
            }
            case 14: {
                stringBuffer.append("0x0E (image folder)");
                break;
            }
            case 15: {
                stringBuffer.append("0x0F (voicememo folder)");
                break;
            }
            case 16: {
                stringBuffer.append("0x10 (category - genre)");
                break;
            }
            case 17: {
                stringBuffer.append("0x11 (category - genres)");
                break;
            }
            case 18: {
                stringBuffer.append("0x12 (category - unknown genre)");
                break;
            }
            case 19: {
                stringBuffer.append("0x13 (category - unknown genres)");
                break;
            }
            case 20: {
                stringBuffer.append("0x14 (category - artist)");
                break;
            }
            case 21: {
                stringBuffer.append("0x15 (category - artists)");
                break;
            }
            case 22: {
                stringBuffer.append("0x16 (category - unknown artist)");
                break;
            }
            case 23: {
                stringBuffer.append("0x17 (category - unknown artists)");
                break;
            }
            case 24: {
                stringBuffer.append("0x18 (category - composer)");
                break;
            }
            case 25: {
                stringBuffer.append("0x19 (category - composers)");
                break;
            }
            case 26: {
                stringBuffer.append("0x1A (category - unknown composer)");
                break;
            }
            case 27: {
                stringBuffer.append("0x1B (category - unknown composers)");
                break;
            }
            case 28: {
                stringBuffer.append("0x1C (category - year)");
                break;
            }
            case 29: {
                stringBuffer.append("0x1D (category - unknown year)");
                break;
            }
            case 30: {
                stringBuffer.append("0x1E (category - comment)");
                break;
            }
            case 31: {
                stringBuffer.append("0x1F (category - unknown comment)");
                break;
            }
            case 32: {
                stringBuffer.append("0x20 (category - album)");
                break;
            }
            case 33: {
                stringBuffer.append("0x21 (category - albums)");
                break;
            }
            case 34: {
                stringBuffer.append("0x22 (category - unknown album)");
                break;
            }
            case 35: {
                stringBuffer.append("0x23 (category - unknown albums)");
                break;
            }
            case 36: {
                stringBuffer.append("0x24 (category - song)");
                break;
            }
            case 37: {
                stringBuffer.append("0x25 (category - songs)");
                break;
            }
            case 38: {
                stringBuffer.append("0x26 (category - unknown song)");
                break;
            }
            case 39: {
                stringBuffer.append("0x27 (category - unknown songs)");
                break;
            }
            case 40: {
                stringBuffer.append("0x28 (category - audiobook)");
                break;
            }
            case 41: {
                stringBuffer.append("0x29 (category - audiobooks)");
                break;
            }
            case 42: {
                stringBuffer.append("0x2A (category - all)");
                break;
            }
            case 43: {
                stringBuffer.append("0x2B (category - podcast)");
                break;
            }
            case 44: {
                stringBuffer.append("0x2C (category - podcasts)");
                break;
            }
            case 45: {
                stringBuffer.append("0x2D (category - dynamic playlist not rated)");
                break;
            }
            case 46: {
                stringBuffer.append("0x2E (category - dynamic playlist 1 star)");
                break;
            }
            case 47: {
                stringBuffer.append("0x2F (category - dynamic playlist 2 stars)");
                break;
            }
            case 48: {
                stringBuffer.append("0x30 (category - dynamic playlist 3 stars)");
                break;
            }
            case 49: {
                stringBuffer.append("0x31 (category - dynamic playlist 4 stars)");
                break;
            }
            case 50: {
                stringBuffer.append("0x32 (category - dynamic playlist 5 stars)");
                break;
            }
            case 51: {
                stringBuffer.append("0x33 (category - dynamic playlist most played)");
                break;
            }
            case 52: {
                stringBuffer.append("0x34 (category - dynamic playlist last played)");
                break;
            }
            case 53: {
                stringBuffer.append("0x35 (category - dynamic playlist on-the-go)");
                break;
            }
            case 54: {
                stringBuffer.append("0x36 (category - dynamic playlists)");
                break;
            }
            case 55: {
                stringBuffer.append("0x37 (category - movies (DF4.1))");
                break;
            }
            case 56: {
                stringBuffer.append("0x38 (category - music videos (DF4.1))");
                break;
            }
            case 57: {
                stringBuffer.append("0x39 (category - video podcasts (german: Sendungen) (DF4.1))");
                break;
            }
            case 58: {
                stringBuffer.append("0x3A (category - borrowed videos (DF4.1))");
                break;
            }
            case 59: {
                stringBuffer.append("0x3B (category - last copied files (DF4.1))");
                break;
            }
            case 60: {
                stringBuffer.append("0x3C (category - favorites (DF4.1))");
                break;
            }
            case 61: {
                stringBuffer.append("0x3D (category - unknown podcast (DF4.1))");
                break;
            }
            case 62: {
                stringBuffer.append("0x3E (category - unknown podcasts (DF4.1))");
                break;
            }
            case 63: {
                stringBuffer.append("0x3F (category - various artists (DF4.1))");
                break;
            }
            case 64: {
                stringBuffer.append("0x40 (DVD main menue)");
                break;
            }
            case 65: {
                stringBuffer.append("0x41 (DVD chapter)");
                break;
            }
            case 66: {
                stringBuffer.append("0x42 (DVD title)");
                break;
            }
            case 67: {
                stringBuffer.append("0x43 (channel)");
                break;
            }
            case 68: {
                stringBuffer.append("0x44 (radio station (FM, AM, AM-SW; AM-LW))");
                break;
            }
            case 69: {
                stringBuffer.append("0x45 (SDARS station)");
                break;
            }
            case 70: {
                stringBuffer.append("0x46 (DAB service)");
                break;
            }
            case 71: {
                stringBuffer.append("0x47 (DVB service / TV station)");
                break;
            }
            case 72: {
                stringBuffer.append("0x48 (title (forbidden in case of legacy audio CD))");
                break;
            }
            case 73: {
                stringBuffer.append("0x49 (artist)");
                break;
            }
            case 74: {
                stringBuffer.append("0x4A (album)");
                break;
            }
            case 75: {
                stringBuffer.append("0x4B (DAB ensemble (DF 4.1))");
                break;
            }
            case 76: {
                stringBuffer.append("0x4C (DAB secondary service (DF 4.1))");
                break;
            }
            case 77: {
                stringBuffer.append("0x4D (moderator (DF 4.1))");
                break;
            }
            case 78: {
                stringBuffer.append("0x4E (conductor (DF 4.1))");
                break;
            }
            case 79: {
                stringBuffer.append("0x4F (composer (DF 4.1))");
                break;
            }
            case 80: {
                stringBuffer.append("0x50 (program now (DF 4.1))");
                break;
            }
            case 81: {
                stringBuffer.append("0x51 (category - unknown audiobook (DF4.1))");
                break;
            }
            case 82: {
                stringBuffer.append("0x52 (category - unknown audiobooks (DF4.1))");
                break;
            }
            case 83: {
                stringBuffer.append("0x53 (category - mood (DF4.1))");
                break;
            }
            case 84: {
                stringBuffer.append("0x54 (category - unknown mood (DF4.1))");
                break;
            }
            case 96: {
                stringBuffer.append("0x60 (online radio station (DF4.2))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - PI_ID - ");
        stringBuffer.append(this.pi_Id);
        stringBuffer.append("\n - SecondaryInformation - ");
        stringBuffer.append(this.secondaryInformation.toString());
        stringBuffer.append("\n - SI_Type: ");
        switch (this.si_Type) {
            case 0: {
                stringBuffer.append("0x00 (any type / unknown)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (folder)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (track)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (playlist)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (playlist folder)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (any category / unknown category)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (audio file)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (video file)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (legacy audio track (CD))");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (CD audio track - CD text)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (voicememo file)");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (image file)");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (audio folder)");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (video folder)");
                break;
            }
            case 14: {
                stringBuffer.append("0x0E (image folder)");
                break;
            }
            case 15: {
                stringBuffer.append("0x0F (voicememo folder)");
                break;
            }
            case 16: {
                stringBuffer.append("0x10 (category - genre)");
                break;
            }
            case 17: {
                stringBuffer.append("0x11 (category - genres)");
                break;
            }
            case 18: {
                stringBuffer.append("0x12 (category - unknown genre)");
                break;
            }
            case 19: {
                stringBuffer.append("0x13 (category - unknown genres)");
                break;
            }
            case 20: {
                stringBuffer.append("0x14 (category - artist)");
                break;
            }
            case 21: {
                stringBuffer.append("0x15 (category - artists)");
                break;
            }
            case 22: {
                stringBuffer.append("0x16 (category - unknown artist)");
                break;
            }
            case 23: {
                stringBuffer.append("0x17 (category - unknown artists)");
                break;
            }
            case 24: {
                stringBuffer.append("0x18 (category - composer)");
                break;
            }
            case 25: {
                stringBuffer.append("0x19 (category - composers)");
                break;
            }
            case 26: {
                stringBuffer.append("0x1A (category - unknown composer)");
                break;
            }
            case 27: {
                stringBuffer.append("0x1B (category - unknown composers)");
                break;
            }
            case 28: {
                stringBuffer.append("0x1C (category - year)");
                break;
            }
            case 29: {
                stringBuffer.append("0x1D (category - unknown year)");
                break;
            }
            case 30: {
                stringBuffer.append("0x1E (category - comment)");
                break;
            }
            case 31: {
                stringBuffer.append("0x1F (category - unknown comment)");
                break;
            }
            case 32: {
                stringBuffer.append("0x20 (category - album)");
                break;
            }
            case 33: {
                stringBuffer.append("0x21 (category - albums)");
                break;
            }
            case 34: {
                stringBuffer.append("0x22 (category - unknown album)");
                break;
            }
            case 35: {
                stringBuffer.append("0x23 (category - unknown albums)");
                break;
            }
            case 36: {
                stringBuffer.append("0x24 (category - song)");
                break;
            }
            case 37: {
                stringBuffer.append("0x25 (category - songs)");
                break;
            }
            case 38: {
                stringBuffer.append("0x26 (category - unknown song)");
                break;
            }
            case 39: {
                stringBuffer.append("0x27 (category - unknown songs)");
                break;
            }
            case 40: {
                stringBuffer.append("0x28 (category - audiobook)");
                break;
            }
            case 41: {
                stringBuffer.append("0x29 (category - audiobooks)");
                break;
            }
            case 42: {
                stringBuffer.append("0x2A (category - all)");
                break;
            }
            case 43: {
                stringBuffer.append("0x2B (category - podcast)");
                break;
            }
            case 44: {
                stringBuffer.append("0x2C (category - podcasts)");
                break;
            }
            case 45: {
                stringBuffer.append("0x2D (category - dynamic playlist not rated)");
                break;
            }
            case 46: {
                stringBuffer.append("0x2E (category - dynamic playlist 1 star)");
                break;
            }
            case 47: {
                stringBuffer.append("0x2F (category - dynamic playlist 2 stars)");
                break;
            }
            case 48: {
                stringBuffer.append("0x30 (category - dynamic playlist 3 stars)");
                break;
            }
            case 49: {
                stringBuffer.append("0x31 (category - dynamic playlist 4 stars)");
                break;
            }
            case 50: {
                stringBuffer.append("0x32 (category - dynamic playlist 5 stars)");
                break;
            }
            case 51: {
                stringBuffer.append("0x33 (category - dynamic playlist most played)");
                break;
            }
            case 52: {
                stringBuffer.append("0x34 (category - dynamic playlist last played)");
                break;
            }
            case 53: {
                stringBuffer.append("0x35 (category - dynamic playlist on-the-go)");
                break;
            }
            case 54: {
                stringBuffer.append("0x36 (category - dynamic playlists)");
                break;
            }
            case 55: {
                stringBuffer.append("0x37 (category - movies (DF4.1))");
                break;
            }
            case 56: {
                stringBuffer.append("0x38 (category - music videos (DF4.1))");
                break;
            }
            case 57: {
                stringBuffer.append("0x39 (category - video podcasts (german: Sendungen) (DF4.1))");
                break;
            }
            case 58: {
                stringBuffer.append("0x3A (category - borrowed videos (DF4.1))");
                break;
            }
            case 59: {
                stringBuffer.append("0x3B (category - last copied files (DF4.1))");
                break;
            }
            case 60: {
                stringBuffer.append("0x3C (category - favorites (DF4.1))");
                break;
            }
            case 61: {
                stringBuffer.append("0x3D (category - unknown podcast (DF4.1))");
                break;
            }
            case 62: {
                stringBuffer.append("0x3E (category - unknown podcasts (DF4.1))");
                break;
            }
            case 63: {
                stringBuffer.append("0x3F (category - various artists (DF4.1))");
                break;
            }
            case 64: {
                stringBuffer.append("0x40 (DVD main menue)");
                break;
            }
            case 65: {
                stringBuffer.append("0x41 (DVD chapter)");
                break;
            }
            case 66: {
                stringBuffer.append("0x42 (DVD title)");
                break;
            }
            case 67: {
                stringBuffer.append("0x43 (channel)");
                break;
            }
            case 68: {
                stringBuffer.append("0x44 (radio station (FM, AM, AM-SW; AM-LW))");
                break;
            }
            case 69: {
                stringBuffer.append("0x45 (SDARS station)");
                break;
            }
            case 70: {
                stringBuffer.append("0x46 (DAB service)");
                break;
            }
            case 71: {
                stringBuffer.append("0x47 (DVB service / TV station)");
                break;
            }
            case 72: {
                stringBuffer.append("0x48 (title (forbidden in case of legacy audio CD))");
                break;
            }
            case 73: {
                stringBuffer.append("0x49 (artist)");
                break;
            }
            case 74: {
                stringBuffer.append("0x4A (album)");
                break;
            }
            case 75: {
                stringBuffer.append("0x4B (DAB ensemble (DF 4.1))");
                break;
            }
            case 76: {
                stringBuffer.append("0x4C (DAB secondary service (DF 4.1))");
                break;
            }
            case 77: {
                stringBuffer.append("0x4D (moderator (DF 4.1))");
                break;
            }
            case 78: {
                stringBuffer.append("0x4E (conductor (DF 4.1))");
                break;
            }
            case 79: {
                stringBuffer.append("0x4F (composer (DF 4.1))");
                break;
            }
            case 80: {
                stringBuffer.append("0x50 (program now (DF 4.1))");
                break;
            }
            case 81: {
                stringBuffer.append("0x51 (category - unknown audiobook (DF4.1))");
                break;
            }
            case 82: {
                stringBuffer.append("0x52 (category - unknown audiobooks (DF4.1))");
                break;
            }
            case 83: {
                stringBuffer.append("0x53 (category - mood (DF4.1))");
                break;
            }
            case 84: {
                stringBuffer.append("0x54 (category - unknown mood (DF4.1))");
                break;
            }
            case 96: {
                stringBuffer.append("0x60 (online radio station (DF4.2))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - TertiaryInformation - ");
        stringBuffer.append(this.tertiaryInformation.toString());
        stringBuffer.append("\n - TI_Type: ");
        switch (this.ti_Type) {
            case 0: {
                stringBuffer.append("0x00 (any type / unknown)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (folder)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (track)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (playlist)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (playlist folder)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (any category / unknown category)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (audio file)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (video file)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (legacy audio track (CD))");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (CD audio track - CD text)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (voicememo file)");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (image file)");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (audio folder)");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (video folder)");
                break;
            }
            case 14: {
                stringBuffer.append("0x0E (image folder)");
                break;
            }
            case 15: {
                stringBuffer.append("0x0F (voicememo folder)");
                break;
            }
            case 16: {
                stringBuffer.append("0x10 (category - genre)");
                break;
            }
            case 17: {
                stringBuffer.append("0x11 (category - genres)");
                break;
            }
            case 18: {
                stringBuffer.append("0x12 (category - unknown genre)");
                break;
            }
            case 19: {
                stringBuffer.append("0x13 (category - unknown genres)");
                break;
            }
            case 20: {
                stringBuffer.append("0x14 (category - artist)");
                break;
            }
            case 21: {
                stringBuffer.append("0x15 (category - artists)");
                break;
            }
            case 22: {
                stringBuffer.append("0x16 (category - unknown artist)");
                break;
            }
            case 23: {
                stringBuffer.append("0x17 (category - unknown artists)");
                break;
            }
            case 24: {
                stringBuffer.append("0x18 (category - composer)");
                break;
            }
            case 25: {
                stringBuffer.append("0x19 (category - composers)");
                break;
            }
            case 26: {
                stringBuffer.append("0x1A (category - unknown composer)");
                break;
            }
            case 27: {
                stringBuffer.append("0x1B (category - unknown composers)");
                break;
            }
            case 28: {
                stringBuffer.append("0x1C (category - year)");
                break;
            }
            case 29: {
                stringBuffer.append("0x1D (category - unknown year)");
                break;
            }
            case 30: {
                stringBuffer.append("0x1E (category - comment)");
                break;
            }
            case 31: {
                stringBuffer.append("0x1F (category - unknown comment)");
                break;
            }
            case 32: {
                stringBuffer.append("0x20 (category - album)");
                break;
            }
            case 33: {
                stringBuffer.append("0x21 (category - albums)");
                break;
            }
            case 34: {
                stringBuffer.append("0x22 (category - unknown album)");
                break;
            }
            case 35: {
                stringBuffer.append("0x23 (category - unknown albums)");
                break;
            }
            case 36: {
                stringBuffer.append("0x24 (category - song)");
                break;
            }
            case 37: {
                stringBuffer.append("0x25 (category - songs)");
                break;
            }
            case 38: {
                stringBuffer.append("0x26 (category - unknown song)");
                break;
            }
            case 39: {
                stringBuffer.append("0x27 (category - unknown songs)");
                break;
            }
            case 40: {
                stringBuffer.append("0x28 (category - audiobook)");
                break;
            }
            case 41: {
                stringBuffer.append("0x29 (category - audiobooks)");
                break;
            }
            case 42: {
                stringBuffer.append("0x2A (category - all)");
                break;
            }
            case 43: {
                stringBuffer.append("0x2B (category - podcast)");
                break;
            }
            case 44: {
                stringBuffer.append("0x2C (category - podcasts)");
                break;
            }
            case 45: {
                stringBuffer.append("0x2D (category - dynamic playlist not rated)");
                break;
            }
            case 46: {
                stringBuffer.append("0x2E (category - dynamic playlist 1 star)");
                break;
            }
            case 47: {
                stringBuffer.append("0x2F (category - dynamic playlist 2 stars)");
                break;
            }
            case 48: {
                stringBuffer.append("0x30 (category - dynamic playlist 3 stars)");
                break;
            }
            case 49: {
                stringBuffer.append("0x31 (category - dynamic playlist 4 stars)");
                break;
            }
            case 50: {
                stringBuffer.append("0x32 (category - dynamic playlist 5 stars)");
                break;
            }
            case 51: {
                stringBuffer.append("0x33 (category - dynamic playlist most played)");
                break;
            }
            case 52: {
                stringBuffer.append("0x34 (category - dynamic playlist last played)");
                break;
            }
            case 53: {
                stringBuffer.append("0x35 (category - dynamic playlist on-the-go)");
                break;
            }
            case 54: {
                stringBuffer.append("0x36 (category - dynamic playlists)");
                break;
            }
            case 55: {
                stringBuffer.append("0x37 (category - movies (DF4.1))");
                break;
            }
            case 56: {
                stringBuffer.append("0x38 (category - music videos (DF4.1))");
                break;
            }
            case 57: {
                stringBuffer.append("0x39 (category - video podcasts (german: Sendungen) (DF4.1))");
                break;
            }
            case 58: {
                stringBuffer.append("0x3A (category - borrowed videos (DF4.1))");
                break;
            }
            case 59: {
                stringBuffer.append("0x3B (category - last copied files (DF4.1))");
                break;
            }
            case 60: {
                stringBuffer.append("0x3C (category - favorites (DF4.1))");
                break;
            }
            case 61: {
                stringBuffer.append("0x3D (category - unknown podcast (DF4.1))");
                break;
            }
            case 62: {
                stringBuffer.append("0x3E (category - unknown podcasts (DF4.1))");
                break;
            }
            case 63: {
                stringBuffer.append("0x3F (category - various artists (DF4.1))");
                break;
            }
            case 64: {
                stringBuffer.append("0x40 (DVD main menue)");
                break;
            }
            case 65: {
                stringBuffer.append("0x41 (DVD chapter)");
                break;
            }
            case 66: {
                stringBuffer.append("0x42 (DVD title)");
                break;
            }
            case 67: {
                stringBuffer.append("0x43 (channel)");
                break;
            }
            case 68: {
                stringBuffer.append("0x44 (radio station (FM, AM, AM-SW; AM-LW))");
                break;
            }
            case 69: {
                stringBuffer.append("0x45 (SDARS station)");
                break;
            }
            case 70: {
                stringBuffer.append("0x46 (DAB service)");
                break;
            }
            case 71: {
                stringBuffer.append("0x47 (DVB service / TV station)");
                break;
            }
            case 72: {
                stringBuffer.append("0x48 (title (forbidden in case of legacy audio CD))");
                break;
            }
            case 73: {
                stringBuffer.append("0x49 (artist)");
                break;
            }
            case 74: {
                stringBuffer.append("0x4A (album)");
                break;
            }
            case 75: {
                stringBuffer.append("0x4B (DAB ensemble (DF 4.1))");
                break;
            }
            case 76: {
                stringBuffer.append("0x4C (DAB secondary service (DF 4.1))");
                break;
            }
            case 77: {
                stringBuffer.append("0x4D (moderator (DF 4.1))");
                break;
            }
            case 78: {
                stringBuffer.append("0x4E (conductor (DF 4.1))");
                break;
            }
            case 79: {
                stringBuffer.append("0x4F (composer (DF 4.1))");
                break;
            }
            case 80: {
                stringBuffer.append("0x50 (program now (DF 4.1))");
                break;
            }
            case 81: {
                stringBuffer.append("0x51 (category - unknown audiobook (DF4.1))");
                break;
            }
            case 82: {
                stringBuffer.append("0x52 (category - unknown audiobooks (DF4.1))");
                break;
            }
            case 83: {
                stringBuffer.append("0x53 (category - mood (DF4.1))");
                break;
            }
            case 84: {
                stringBuffer.append("0x54 (category - unknown mood (DF4.1))");
                break;
            }
            case 96: {
                stringBuffer.append("0x60 (online radio station (DF4.2))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - QuaternaryInformation - ");
        stringBuffer.append(this.quaternaryInformation.toString());
        stringBuffer.append("\n - QI_Type: ");
        switch (this.qi_Type) {
            case 0: {
                stringBuffer.append("0x00 (any type / unknown)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (folder)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (track)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (playlist)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (playlist folder)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (any category / unknown category)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (audio file)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (video file)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (legacy audio track (CD))");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (CD audio track - CD text)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (voicememo file)");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (image file)");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (audio folder)");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (video folder)");
                break;
            }
            case 14: {
                stringBuffer.append("0x0E (image folder)");
                break;
            }
            case 15: {
                stringBuffer.append("0x0F (voicememo folder)");
                break;
            }
            case 16: {
                stringBuffer.append("0x10 (category - genre)");
                break;
            }
            case 17: {
                stringBuffer.append("0x11 (category - genres)");
                break;
            }
            case 18: {
                stringBuffer.append("0x12 (category - unknown genre)");
                break;
            }
            case 19: {
                stringBuffer.append("0x13 (category - unknown genres)");
                break;
            }
            case 20: {
                stringBuffer.append("0x14 (category - artist)");
                break;
            }
            case 21: {
                stringBuffer.append("0x15 (category - artists)");
                break;
            }
            case 22: {
                stringBuffer.append("0x16 (category - unknown artist)");
                break;
            }
            case 23: {
                stringBuffer.append("0x17 (category - unknown artists)");
                break;
            }
            case 24: {
                stringBuffer.append("0x18 (category - composer)");
                break;
            }
            case 25: {
                stringBuffer.append("0x19 (category - composers)");
                break;
            }
            case 26: {
                stringBuffer.append("0x1A (category - unknown composer)");
                break;
            }
            case 27: {
                stringBuffer.append("0x1B (category - unknown composers)");
                break;
            }
            case 28: {
                stringBuffer.append("0x1C (category - year)");
                break;
            }
            case 29: {
                stringBuffer.append("0x1D (category - unknown year)");
                break;
            }
            case 30: {
                stringBuffer.append("0x1E (category - comment)");
                break;
            }
            case 31: {
                stringBuffer.append("0x1F (category - unknown comment)");
                break;
            }
            case 32: {
                stringBuffer.append("0x20 (category - album)");
                break;
            }
            case 33: {
                stringBuffer.append("0x21 (category - albums)");
                break;
            }
            case 34: {
                stringBuffer.append("0x22 (category - unknown album)");
                break;
            }
            case 35: {
                stringBuffer.append("0x23 (category - unknown albums)");
                break;
            }
            case 36: {
                stringBuffer.append("0x24 (category - song)");
                break;
            }
            case 37: {
                stringBuffer.append("0x25 (category - songs)");
                break;
            }
            case 38: {
                stringBuffer.append("0x26 (category - unknown song)");
                break;
            }
            case 39: {
                stringBuffer.append("0x27 (category - unknown songs)");
                break;
            }
            case 40: {
                stringBuffer.append("0x28 (category - audiobook)");
                break;
            }
            case 41: {
                stringBuffer.append("0x29 (category - audiobooks)");
                break;
            }
            case 42: {
                stringBuffer.append("0x2A (category - all)");
                break;
            }
            case 43: {
                stringBuffer.append("0x2B (category - podcast)");
                break;
            }
            case 44: {
                stringBuffer.append("0x2C (category - podcasts)");
                break;
            }
            case 45: {
                stringBuffer.append("0x2D (category - dynamic playlist not rated)");
                break;
            }
            case 46: {
                stringBuffer.append("0x2E (category - dynamic playlist 1 star)");
                break;
            }
            case 47: {
                stringBuffer.append("0x2F (category - dynamic playlist 2 stars)");
                break;
            }
            case 48: {
                stringBuffer.append("0x30 (category - dynamic playlist 3 stars)");
                break;
            }
            case 49: {
                stringBuffer.append("0x31 (category - dynamic playlist 4 stars)");
                break;
            }
            case 50: {
                stringBuffer.append("0x32 (category - dynamic playlist 5 stars)");
                break;
            }
            case 51: {
                stringBuffer.append("0x33 (category - dynamic playlist most played)");
                break;
            }
            case 52: {
                stringBuffer.append("0x34 (category - dynamic playlist last played)");
                break;
            }
            case 53: {
                stringBuffer.append("0x35 (category - dynamic playlist on-the-go)");
                break;
            }
            case 54: {
                stringBuffer.append("0x36 (category - dynamic playlists)");
                break;
            }
            case 55: {
                stringBuffer.append("0x37 (category - movies (DF4.1))");
                break;
            }
            case 56: {
                stringBuffer.append("0x38 (category - music videos (DF4.1))");
                break;
            }
            case 57: {
                stringBuffer.append("0x39 (category - video podcasts (german: Sendungen) (DF4.1))");
                break;
            }
            case 58: {
                stringBuffer.append("0x3A (category - borrowed videos (DF4.1))");
                break;
            }
            case 59: {
                stringBuffer.append("0x3B (category - last copied files (DF4.1))");
                break;
            }
            case 60: {
                stringBuffer.append("0x3C (category - favorites (DF4.1))");
                break;
            }
            case 61: {
                stringBuffer.append("0x3D (category - unknown podcast (DF4.1))");
                break;
            }
            case 62: {
                stringBuffer.append("0x3E (category - unknown podcasts (DF4.1))");
                break;
            }
            case 63: {
                stringBuffer.append("0x3F (category - various artists (DF4.1))");
                break;
            }
            case 64: {
                stringBuffer.append("0x40 (DVD main menue)");
                break;
            }
            case 65: {
                stringBuffer.append("0x41 (DVD chapter)");
                break;
            }
            case 66: {
                stringBuffer.append("0x42 (DVD title)");
                break;
            }
            case 67: {
                stringBuffer.append("0x43 (channel)");
                break;
            }
            case 68: {
                stringBuffer.append("0x44 (radio station (FM, AM, AM-SW; AM-LW))");
                break;
            }
            case 69: {
                stringBuffer.append("0x45 (SDARS station)");
                break;
            }
            case 70: {
                stringBuffer.append("0x46 (DAB service)");
                break;
            }
            case 71: {
                stringBuffer.append("0x47 (DVB service / TV station)");
                break;
            }
            case 72: {
                stringBuffer.append("0x48 (title (forbidden in case of legacy audio CD))");
                break;
            }
            case 73: {
                stringBuffer.append("0x49 (artist)");
                break;
            }
            case 74: {
                stringBuffer.append("0x4A (album)");
                break;
            }
            case 75: {
                stringBuffer.append("0x4B (DAB ensemble (DF 4.1))");
                break;
            }
            case 76: {
                stringBuffer.append("0x4C (DAB secondary service (DF 4.1))");
                break;
            }
            case 77: {
                stringBuffer.append("0x4D (moderator (DF 4.1))");
                break;
            }
            case 78: {
                stringBuffer.append("0x4E (conductor (DF 4.1))");
                break;
            }
            case 79: {
                stringBuffer.append("0x4F (composer (DF 4.1))");
                break;
            }
            case 80: {
                stringBuffer.append("0x50 (program now (DF 4.1))");
                break;
            }
            case 81: {
                stringBuffer.append("0x51 (category - unknown audiobook (DF4.1))");
                break;
            }
            case 82: {
                stringBuffer.append("0x52 (category - unknown audiobooks (DF4.1))");
                break;
            }
            case 83: {
                stringBuffer.append("0x53 (category - mood (DF4.1))");
                break;
            }
            case 84: {
                stringBuffer.append("0x54 (category - unknown mood (DF4.1))");
                break;
            }
            case 96: {
                stringBuffer.append("0x60 (online radio station (DF4.2))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - StationInfoSwitches - ");
        stringBuffer.append(this.stationInfoSwitches.toString());
        stringBuffer.append("\n - StationProperties - ");
        stringBuffer.append(this.stationProperties.toString());
        stringBuffer.append("\n - Channel_ID - ");
        stringBuffer.append(this.channel_Id);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += this.primaryInformation.bitSize();
        n += 8;
        n += 16;
        n += this.secondaryInformation.bitSize();
        n += 8;
        n += this.tertiaryInformation.bitSize();
        n += 8;
        n += this.quaternaryInformation.bitSize();
        n += 8;
        n += this.stationInfoSwitches.bitSize();
        n += this.stationProperties.bitSize();
        return n += 16;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.primaryInformation.serialize(bitStream);
        bitStream.pushByte((byte)this.pi_Type);
        bitStream.pushShort((short)this.pi_Id);
        this.secondaryInformation.serialize(bitStream);
        bitStream.pushByte((byte)this.si_Type);
        this.tertiaryInformation.serialize(bitStream);
        bitStream.pushByte((byte)this.ti_Type);
        this.quaternaryInformation.serialize(bitStream);
        bitStream.pushByte((byte)this.qi_Type);
        this.stationInfoSwitches.serialize(bitStream);
        this.stationProperties.serialize(bitStream);
        bitStream.pushShort((short)this.channel_Id);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.primaryInformation.deserialize(bitStream);
        this.pi_Type = bitStream.popFrontByte();
        this.pi_Id = bitStream.popFrontShort();
        this.secondaryInformation.deserialize(bitStream);
        this.si_Type = bitStream.popFrontByte();
        this.tertiaryInformation.deserialize(bitStream);
        this.ti_Type = bitStream.popFrontByte();
        this.quaternaryInformation.deserialize(bitStream);
        this.qi_Type = bitStream.popFrontByte();
        this.stationInfoSwitches.deserialize(bitStream);
        this.stationProperties.deserialize(bitStream);
        this.channel_Id = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 21;
    }

    @Override
    public int getFunctionId() {
        return CurrentStationInfo_Status.functionId();
    }
}

