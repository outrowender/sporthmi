/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentStationInfo_Status
implements StatusProperty {
    public final BAPString primaryInformation = new BAPString(73);
    private static final int MAX_PRIMARY_INFORMATION_LENGTH = 73;
    public int pi_Type;
    private static final int PI_TYPE_BITSIZE = 8;
    public static final int PI_TYPE_ANY_TYPE_UNKNOWN = 0;
    public static final int PI_TYPE_FOLDER = 1;
    public static final int PI_TYPE_TRACK = 2;
    public static final int PI_TYPE_PLAYLIST = 3;
    public static final int PI_TYPE_PLAYLIST_FOLDER = 4;
    public static final int PI_TYPE_ANY_CATEGORY_UNKNOWN_CATEGORY = 5;
    public static final int PI_TYPE_AUDIO_FILE = 6;
    public static final int PI_TYPE_VIDEO_FILE = 7;
    public static final int PI_TYPE_LEGACY_AUDIO_TRACK_CD = 8;
    public static final int PI_TYPE_CD_AUDIO_TRACK_CD_TEXT = 9;
    public static final int PI_TYPE_VOICEMEMO_FILE = 10;
    public static final int PI_TYPE_IMAGE_FILE = 11;
    public static final int PI_TYPE_AUDIO_FOLDER = 12;
    public static final int PI_TYPE_VIDEO_FOLDER = 13;
    public static final int PI_TYPE_IMAGE_FOLDER = 14;
    public static final int PI_TYPE_VOICEMEMO_FOLDER = 15;
    public static final int PI_TYPE_CATEGORY_GENRE = 16;
    public static final int PI_TYPE_CATEGORY_GENRES = 17;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_GENRE = 18;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_GENRES = 19;
    public static final int PI_TYPE_CATEGORY_ARTIST = 20;
    public static final int PI_TYPE_CATEGORY_ARTISTS = 21;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_ARTIST = 22;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_ARTISTS = 23;
    public static final int PI_TYPE_CATEGORY_COMPOSER = 24;
    public static final int PI_TYPE_CATEGORY_COMPOSERS = 25;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_COMPOSER = 26;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_COMPOSERS = 27;
    public static final int PI_TYPE_CATEGORY_YEAR = 28;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_YEAR = 29;
    public static final int PI_TYPE_CATEGORY_COMMENT = 30;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_COMMENT = 31;
    public static final int PI_TYPE_CATEGORY_ALBUM = 32;
    public static final int PI_TYPE_CATEGORY_ALBUMS = 33;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_ALBUM = 34;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_ALBUMS = 35;
    public static final int PI_TYPE_CATEGORY_SONG = 36;
    public static final int PI_TYPE_CATEGORY_SONGS = 37;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_SONG = 38;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_SONGS = 39;
    public static final int PI_TYPE_CATEGORY_AUDIOBOOK = 40;
    public static final int PI_TYPE_CATEGORY_AUDIOBOOKS = 41;
    public static final int PI_TYPE_CATEGORY_ALL = 42;
    public static final int PI_TYPE_CATEGORY_PODCAST = 43;
    public static final int PI_TYPE_CATEGORY_PODCASTS = 44;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_NOT_RATED = 45;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_1_STAR = 46;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_2_STARS = 47;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_3_STARS = 48;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_4_STARS = 49;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_5_STARS = 50;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_MOST_PLAYED = 51;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_LAST_PLAYED = 52;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_ON_THE_GO = 53;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLISTS = 54;
    public static final int PI_TYPE_CATEGORY_MOVIES_DF4_1 = 55;
    public static final int PI_TYPE_CATEGORY_MUSIC_VIDEOS_DF4_1 = 56;
    public static final int PI_TYPE_CATEGORY_VIDEO_PODCASTS_GERMAN_SENDUNGEN_DF4_1 = 57;
    public static final int PI_TYPE_CATEGORY_BORROWED_VIDEOS_DF4_1 = 58;
    public static final int PI_TYPE_CATEGORY_LAST_COPIED_FILES_DF4_1 = 59;
    public static final int PI_TYPE_CATEGORY_FAVORITES_DF4_1 = 60;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_PODCAST_DF4_1 = 61;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_PODCASTS_DF4_1 = 62;
    public static final int PI_TYPE_CATEGORY_VARIOUS_ARTISTS_DF4_1 = 63;
    public static final int PI_TYPE_DVD_MAIN_MENUE = 64;
    public static final int PI_TYPE_DVD_CHAPTER = 65;
    public static final int PI_TYPE_DVD_TITLE = 66;
    public static final int PI_TYPE_CHANNEL = 67;
    public static final int PI_TYPE_RADIO_STATION_FM_AM_AM_SW_AM_LW = 68;
    public static final int PI_TYPE_SDARS_STATION = 69;
    public static final int PI_TYPE_DAB_SERVICE = 70;
    public static final int PI_TYPE_DVB_SERVICE_TV_STATION = 71;
    public static final int PI_TYPE_TITLE_FORBIDDEN_IN_CASE_OF_LEGACY_AUDIO_CD = 72;
    public static final int PI_TYPE_ARTIST = 73;
    public static final int PI_TYPE_ALBUM = 74;
    public static final int PI_TYPE_DAB_ENSEMBLE_DF_4_1 = 75;
    public static final int PI_TYPE_DAB_SECONDARY_SERVICE_DF_4_1 = 76;
    public static final int PI_TYPE_MODERATOR_DF_4_1 = 77;
    public static final int PI_TYPE_CONDUCTOR_DF_4_1 = 78;
    public static final int PI_TYPE_COMPOSER_DF_4_1 = 79;
    public static final int PI_TYPE_PROGRAM_NOW_DF_4_1 = 80;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOK_DF4_1 = 81;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOKS_DF4_1 = 82;
    public static final int PI_TYPE_CATEGORY_MOOD_DF4_1 = 83;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_MOOD_DF4_1 = 84;
    public static final int PI_TYPE_ONLINE_RADIO_STATION_DF4_2 = 96;
    public int pi_Id;
    private static final int PI_ID_BITSIZE = 16;
    public final BAPString secondaryInformation = new BAPString(73);
    private static final int MAX_SECONDARY_INFORMATION_LENGTH = 73;
    public int si_Type;
    private static final int SI_TYPE_BITSIZE = 8;
    public static final int SI_TYPE_ANY_TYPE_UNKNOWN = 0;
    public static final int SI_TYPE_FOLDER = 1;
    public static final int SI_TYPE_TRACK = 2;
    public static final int SI_TYPE_PLAYLIST = 3;
    public static final int SI_TYPE_PLAYLIST_FOLDER = 4;
    public static final int SI_TYPE_ANY_CATEGORY_UNKNOWN_CATEGORY = 5;
    public static final int SI_TYPE_AUDIO_FILE = 6;
    public static final int SI_TYPE_VIDEO_FILE = 7;
    public static final int SI_TYPE_LEGACY_AUDIO_TRACK_CD = 8;
    public static final int SI_TYPE_CD_AUDIO_TRACK_CD_TEXT = 9;
    public static final int SI_TYPE_VOICEMEMO_FILE = 10;
    public static final int SI_TYPE_IMAGE_FILE = 11;
    public static final int SI_TYPE_AUDIO_FOLDER = 12;
    public static final int SI_TYPE_VIDEO_FOLDER = 13;
    public static final int SI_TYPE_IMAGE_FOLDER = 14;
    public static final int SI_TYPE_VOICEMEMO_FOLDER = 15;
    public static final int SI_TYPE_CATEGORY_GENRE = 16;
    public static final int SI_TYPE_CATEGORY_GENRES = 17;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_GENRE = 18;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_GENRES = 19;
    public static final int SI_TYPE_CATEGORY_ARTIST = 20;
    public static final int SI_TYPE_CATEGORY_ARTISTS = 21;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_ARTIST = 22;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_ARTISTS = 23;
    public static final int SI_TYPE_CATEGORY_COMPOSER = 24;
    public static final int SI_TYPE_CATEGORY_COMPOSERS = 25;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_COMPOSER = 26;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_COMPOSERS = 27;
    public static final int SI_TYPE_CATEGORY_YEAR = 28;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_YEAR = 29;
    public static final int SI_TYPE_CATEGORY_COMMENT = 30;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_COMMENT = 31;
    public static final int SI_TYPE_CATEGORY_ALBUM = 32;
    public static final int SI_TYPE_CATEGORY_ALBUMS = 33;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_ALBUM = 34;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_ALBUMS = 35;
    public static final int SI_TYPE_CATEGORY_SONG = 36;
    public static final int SI_TYPE_CATEGORY_SONGS = 37;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_SONG = 38;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_SONGS = 39;
    public static final int SI_TYPE_CATEGORY_AUDIOBOOK = 40;
    public static final int SI_TYPE_CATEGORY_AUDIOBOOKS = 41;
    public static final int SI_TYPE_CATEGORY_ALL = 42;
    public static final int SI_TYPE_CATEGORY_PODCAST = 43;
    public static final int SI_TYPE_CATEGORY_PODCASTS = 44;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_NOT_RATED = 45;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_1_STAR = 46;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_2_STARS = 47;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_3_STARS = 48;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_4_STARS = 49;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_5_STARS = 50;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_MOST_PLAYED = 51;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_LAST_PLAYED = 52;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_ON_THE_GO = 53;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLISTS = 54;
    public static final int SI_TYPE_CATEGORY_MOVIES_DF4_1 = 55;
    public static final int SI_TYPE_CATEGORY_MUSIC_VIDEOS_DF4_1 = 56;
    public static final int SI_TYPE_CATEGORY_VIDEO_PODCASTS_GERMAN_SENDUNGEN_DF4_1 = 57;
    public static final int SI_TYPE_CATEGORY_BORROWED_VIDEOS_DF4_1 = 58;
    public static final int SI_TYPE_CATEGORY_LAST_COPIED_FILES_DF4_1 = 59;
    public static final int SI_TYPE_CATEGORY_FAVORITES_DF4_1 = 60;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_PODCAST_DF4_1 = 61;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_PODCASTS_DF4_1 = 62;
    public static final int SI_TYPE_CATEGORY_VARIOUS_ARTISTS_DF4_1 = 63;
    public static final int SI_TYPE_DVD_MAIN_MENUE = 64;
    public static final int SI_TYPE_DVD_CHAPTER = 65;
    public static final int SI_TYPE_DVD_TITLE = 66;
    public static final int SI_TYPE_CHANNEL = 67;
    public static final int SI_TYPE_RADIO_STATION_FM_AM_AM_SW_AM_LW = 68;
    public static final int SI_TYPE_SDARS_STATION = 69;
    public static final int SI_TYPE_DAB_SERVICE = 70;
    public static final int SI_TYPE_DVB_SERVICE_TV_STATION = 71;
    public static final int SI_TYPE_TITLE_FORBIDDEN_IN_CASE_OF_LEGACY_AUDIO_CD = 72;
    public static final int SI_TYPE_ARTIST = 73;
    public static final int SI_TYPE_ALBUM = 74;
    public static final int SI_TYPE_DAB_ENSEMBLE_DF_4_1 = 75;
    public static final int SI_TYPE_DAB_SECONDARY_SERVICE_DF_4_1 = 76;
    public static final int SI_TYPE_MODERATOR_DF_4_1 = 77;
    public static final int SI_TYPE_CONDUCTOR_DF_4_1 = 78;
    public static final int SI_TYPE_COMPOSER_DF_4_1 = 79;
    public static final int SI_TYPE_PROGRAM_NOW_DF_4_1 = 80;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOK_DF4_1 = 81;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOKS_DF4_1 = 82;
    public static final int SI_TYPE_CATEGORY_MOOD_DF4_1 = 83;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_MOOD_DF4_1 = 84;
    public static final int SI_TYPE_ONLINE_RADIO_STATION_DF4_2 = 96;
    public final BAPString tertiaryInformation = new BAPString(73);
    private static final int MAX_TERTIARY_INFORMATION_LENGTH = 73;
    public int ti_Type;
    private static final int TI_TYPE_BITSIZE = 8;
    public static final int TI_TYPE_ANY_TYPE_UNKNOWN = 0;
    public static final int TI_TYPE_FOLDER = 1;
    public static final int TI_TYPE_TRACK = 2;
    public static final int TI_TYPE_PLAYLIST = 3;
    public static final int TI_TYPE_PLAYLIST_FOLDER = 4;
    public static final int TI_TYPE_ANY_CATEGORY_UNKNOWN_CATEGORY = 5;
    public static final int TI_TYPE_AUDIO_FILE = 6;
    public static final int TI_TYPE_VIDEO_FILE = 7;
    public static final int TI_TYPE_LEGACY_AUDIO_TRACK_CD = 8;
    public static final int TI_TYPE_CD_AUDIO_TRACK_CD_TEXT = 9;
    public static final int TI_TYPE_VOICEMEMO_FILE = 10;
    public static final int TI_TYPE_IMAGE_FILE = 11;
    public static final int TI_TYPE_AUDIO_FOLDER = 12;
    public static final int TI_TYPE_VIDEO_FOLDER = 13;
    public static final int TI_TYPE_IMAGE_FOLDER = 14;
    public static final int TI_TYPE_VOICEMEMO_FOLDER = 15;
    public static final int TI_TYPE_CATEGORY_GENRE = 16;
    public static final int TI_TYPE_CATEGORY_GENRES = 17;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_GENRE = 18;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_GENRES = 19;
    public static final int TI_TYPE_CATEGORY_ARTIST = 20;
    public static final int TI_TYPE_CATEGORY_ARTISTS = 21;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_ARTIST = 22;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_ARTISTS = 23;
    public static final int TI_TYPE_CATEGORY_COMPOSER = 24;
    public static final int TI_TYPE_CATEGORY_COMPOSERS = 25;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_COMPOSER = 26;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_COMPOSERS = 27;
    public static final int TI_TYPE_CATEGORY_YEAR = 28;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_YEAR = 29;
    public static final int TI_TYPE_CATEGORY_COMMENT = 30;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_COMMENT = 31;
    public static final int TI_TYPE_CATEGORY_ALBUM = 32;
    public static final int TI_TYPE_CATEGORY_ALBUMS = 33;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_ALBUM = 34;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_ALBUMS = 35;
    public static final int TI_TYPE_CATEGORY_SONG = 36;
    public static final int TI_TYPE_CATEGORY_SONGS = 37;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_SONG = 38;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_SONGS = 39;
    public static final int TI_TYPE_CATEGORY_AUDIOBOOK = 40;
    public static final int TI_TYPE_CATEGORY_AUDIOBOOKS = 41;
    public static final int TI_TYPE_CATEGORY_ALL = 42;
    public static final int TI_TYPE_CATEGORY_PODCAST = 43;
    public static final int TI_TYPE_CATEGORY_PODCASTS = 44;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_NOT_RATED = 45;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_1_STAR = 46;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_2_STARS = 47;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_3_STARS = 48;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_4_STARS = 49;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_5_STARS = 50;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_MOST_PLAYED = 51;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_LAST_PLAYED = 52;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_ON_THE_GO = 53;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLISTS = 54;
    public static final int TI_TYPE_CATEGORY_MOVIES_DF4_1 = 55;
    public static final int TI_TYPE_CATEGORY_MUSIC_VIDEOS_DF4_1 = 56;
    public static final int TI_TYPE_CATEGORY_VIDEO_PODCASTS_GERMAN_SENDUNGEN_DF4_1 = 57;
    public static final int TI_TYPE_CATEGORY_BORROWED_VIDEOS_DF4_1 = 58;
    public static final int TI_TYPE_CATEGORY_LAST_COPIED_FILES_DF4_1 = 59;
    public static final int TI_TYPE_CATEGORY_FAVORITES_DF4_1 = 60;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_PODCAST_DF4_1 = 61;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_PODCASTS_DF4_1 = 62;
    public static final int TI_TYPE_CATEGORY_VARIOUS_ARTISTS_DF4_1 = 63;
    public static final int TI_TYPE_DVD_MAIN_MENUE = 64;
    public static final int TI_TYPE_DVD_CHAPTER = 65;
    public static final int TI_TYPE_DVD_TITLE = 66;
    public static final int TI_TYPE_CHANNEL = 67;
    public static final int TI_TYPE_RADIO_STATION_FM_AM_AM_SW_AM_LW = 68;
    public static final int TI_TYPE_SDARS_STATION = 69;
    public static final int TI_TYPE_DAB_SERVICE = 70;
    public static final int TI_TYPE_DVB_SERVICE_TV_STATION = 71;
    public static final int TI_TYPE_TITLE_FORBIDDEN_IN_CASE_OF_LEGACY_AUDIO_CD = 72;
    public static final int TI_TYPE_ARTIST = 73;
    public static final int TI_TYPE_ALBUM = 74;
    public static final int TI_TYPE_DAB_ENSEMBLE_DF_4_1 = 75;
    public static final int TI_TYPE_DAB_SECONDARY_SERVICE_DF_4_1 = 76;
    public static final int TI_TYPE_MODERATOR_DF_4_1 = 77;
    public static final int TI_TYPE_CONDUCTOR_DF_4_1 = 78;
    public static final int TI_TYPE_COMPOSER_DF_4_1 = 79;
    public static final int TI_TYPE_PROGRAM_NOW_DF_4_1 = 80;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOK_DF4_1 = 81;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOKS_DF4_1 = 82;
    public static final int TI_TYPE_CATEGORY_MOOD_DF4_1 = 83;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_MOOD_DF4_1 = 84;
    public static final int TI_TYPE_ONLINE_RADIO_STATION_DF4_2 = 96;
    public final BAPString quaternaryInformation = new BAPString(73);
    private static final int MAX_QUATERNARY_INFORMATION_LENGTH = 73;
    public int qi_Type;
    private static final int QI_TYPE_BITSIZE = 8;
    public static final int QI_TYPE_ANY_TYPE_UNKNOWN = 0;
    public static final int QI_TYPE_FOLDER = 1;
    public static final int QI_TYPE_TRACK = 2;
    public static final int QI_TYPE_PLAYLIST = 3;
    public static final int QI_TYPE_PLAYLIST_FOLDER = 4;
    public static final int QI_TYPE_ANY_CATEGORY_UNKNOWN_CATEGORY = 5;
    public static final int QI_TYPE_AUDIO_FILE = 6;
    public static final int QI_TYPE_VIDEO_FILE = 7;
    public static final int QI_TYPE_LEGACY_AUDIO_TRACK_CD = 8;
    public static final int QI_TYPE_CD_AUDIO_TRACK_CD_TEXT = 9;
    public static final int QI_TYPE_VOICEMEMO_FILE = 10;
    public static final int QI_TYPE_IMAGE_FILE = 11;
    public static final int QI_TYPE_AUDIO_FOLDER = 12;
    public static final int QI_TYPE_VIDEO_FOLDER = 13;
    public static final int QI_TYPE_IMAGE_FOLDER = 14;
    public static final int QI_TYPE_VOICEMEMO_FOLDER = 15;
    public static final int QI_TYPE_CATEGORY_GENRE = 16;
    public static final int QI_TYPE_CATEGORY_GENRES = 17;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_GENRE = 18;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_GENRES = 19;
    public static final int QI_TYPE_CATEGORY_ARTIST = 20;
    public static final int QI_TYPE_CATEGORY_ARTISTS = 21;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_ARTIST = 22;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_ARTISTS = 23;
    public static final int QI_TYPE_CATEGORY_COMPOSER = 24;
    public static final int QI_TYPE_CATEGORY_COMPOSERS = 25;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_COMPOSER = 26;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_COMPOSERS = 27;
    public static final int QI_TYPE_CATEGORY_YEAR = 28;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_YEAR = 29;
    public static final int QI_TYPE_CATEGORY_COMMENT = 30;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_COMMENT = 31;
    public static final int QI_TYPE_CATEGORY_ALBUM = 32;
    public static final int QI_TYPE_CATEGORY_ALBUMS = 33;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_ALBUM = 34;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_ALBUMS = 35;
    public static final int QI_TYPE_CATEGORY_SONG = 36;
    public static final int QI_TYPE_CATEGORY_SONGS = 37;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_SONG = 38;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_SONGS = 39;
    public static final int QI_TYPE_CATEGORY_AUDIOBOOK = 40;
    public static final int QI_TYPE_CATEGORY_AUDIOBOOKS = 41;
    public static final int QI_TYPE_CATEGORY_ALL = 42;
    public static final int QI_TYPE_CATEGORY_PODCAST = 43;
    public static final int QI_TYPE_CATEGORY_PODCASTS = 44;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_NOT_RATED = 45;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_1_STAR = 46;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_2_STARS = 47;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_3_STARS = 48;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_4_STARS = 49;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_5_STARS = 50;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_MOST_PLAYED = 51;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_LAST_PLAYED = 52;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_ON_THE_GO = 53;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLISTS = 54;
    public static final int QI_TYPE_CATEGORY_MOVIES_DF4_1 = 55;
    public static final int QI_TYPE_CATEGORY_MUSIC_VIDEOS_DF4_1 = 56;
    public static final int QI_TYPE_CATEGORY_VIDEO_PODCASTS_GERMAN_SENDUNGEN_DF4_1 = 57;
    public static final int QI_TYPE_CATEGORY_BORROWED_VIDEOS_DF4_1 = 58;
    public static final int QI_TYPE_CATEGORY_LAST_COPIED_FILES_DF4_1 = 59;
    public static final int QI_TYPE_CATEGORY_FAVORITES_DF4_1 = 60;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_PODCAST_DF4_1 = 61;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_PODCASTS_DF4_1 = 62;
    public static final int QI_TYPE_CATEGORY_VARIOUS_ARTISTS_DF4_1 = 63;
    public static final int QI_TYPE_DVD_MAIN_MENUE = 64;
    public static final int QI_TYPE_DVD_CHAPTER = 65;
    public static final int QI_TYPE_DVD_TITLE = 66;
    public static final int QI_TYPE_CHANNEL = 67;
    public static final int QI_TYPE_RADIO_STATION_FM_AM_AM_SW_AM_LW = 68;
    public static final int QI_TYPE_SDARS_STATION = 69;
    public static final int QI_TYPE_DAB_SERVICE = 70;
    public static final int QI_TYPE_DVB_SERVICE_TV_STATION = 71;
    public static final int QI_TYPE_TITLE_FORBIDDEN_IN_CASE_OF_LEGACY_AUDIO_CD = 72;
    public static final int QI_TYPE_ARTIST = 73;
    public static final int QI_TYPE_ALBUM = 74;
    public static final int QI_TYPE_DAB_ENSEMBLE_DF_4_1 = 75;
    public static final int QI_TYPE_DAB_SECONDARY_SERVICE_DF_4_1 = 76;
    public static final int QI_TYPE_MODERATOR_DF_4_1 = 77;
    public static final int QI_TYPE_CONDUCTOR_DF_4_1 = 78;
    public static final int QI_TYPE_COMPOSER_DF_4_1 = 79;
    public static final int QI_TYPE_PROGRAM_NOW_DF_4_1 = 80;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOK_DF4_1 = 81;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOKS_DF4_1 = 82;
    public static final int QI_TYPE_CATEGORY_MOOD_DF4_1 = 83;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_MOOD_DF4_1 = 84;
    public static final int QI_TYPE_ONLINE_RADIO_STATION_DF4_2 = 96;
    public final StationInfoSwitches stationInfoSwitches = new StationInfoSwitches();
    public final StationProperties stationProperties = new StationProperties();
    public int channel_Id;
    private static final int CHANNEL_ID_BITSIZE = 16;

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

    public void reset() {
        this.internalReset();
        this.primaryInformation.reset();
        this.secondaryInformation.reset();
        this.tertiaryInformation.reset();
        this.quaternaryInformation.reset();
        this.stationInfoSwitches.reset();
        this.stationProperties.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentStationInfo_Status currentStationInfo_Status = (CurrentStationInfo_Status)bAPEntity;
        return this.primaryInformation.equalTo(currentStationInfo_Status.primaryInformation) && this.pi_Type == currentStationInfo_Status.pi_Type && this.pi_Id == currentStationInfo_Status.pi_Id && this.secondaryInformation.equalTo(currentStationInfo_Status.secondaryInformation) && this.si_Type == currentStationInfo_Status.si_Type && this.tertiaryInformation.equalTo(currentStationInfo_Status.tertiaryInformation) && this.ti_Type == currentStationInfo_Status.ti_Type && this.quaternaryInformation.equalTo(currentStationInfo_Status.quaternaryInformation) && this.qi_Type == currentStationInfo_Status.qi_Type && this.stationInfoSwitches.equalTo(currentStationInfo_Status.stationInfoSwitches) && this.stationProperties.equalTo(currentStationInfo_Status.stationProperties) && this.channel_Id == currentStationInfo_Status.channel_Id;
    }

    private void customInitialization() {
    }

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

    public int getFunctionId() {
        return CurrentStationInfo_Status.functionId();
    }

    public static final class StationProperties
    implements BAPEntity {
        private static final int RESERVED_BIT_4__7_BITSIZE = 4;
        public boolean stationLinkedToOnlineRadio;
        public boolean dabServiceDoesNotContainAnyAudioSignal;
        public boolean ibocLiveTransmissionActive;
        public boolean dabServiceLinkedToFm;
        private static final int STATION_PROPERTIES_BITSIZE = 8;

        public StationProperties() {
            this.internalReset();
            this.customInitialization();
        }

        public StationProperties(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.stationLinkedToOnlineRadio = false;
            this.dabServiceDoesNotContainAnyAudioSignal = false;
            this.ibocLiveTransmissionActive = false;
            this.dabServiceLinkedToFm = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            StationProperties stationProperties = (StationProperties)bAPEntity;
            return this.stationLinkedToOnlineRadio == stationProperties.stationLinkedToOnlineRadio && this.dabServiceDoesNotContainAnyAudioSignal == stationProperties.dabServiceDoesNotContainAnyAudioSignal && this.ibocLiveTransmissionActive == stationProperties.ibocLiveTransmissionActive && this.dabServiceLinkedToFm == stationProperties.dabServiceLinkedToFm;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("StationProperties:");
            stringBuffer.append("\n - Bit 3: ");
            if (this.stationLinkedToOnlineRadio) {
                stringBuffer.append("true  (station linked to online radio (DF 4.1)");
            } else {
                stringBuffer.append("false  (station not linked to online radio (DF 4.1)");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.dabServiceDoesNotContainAnyAudioSignal) {
                stringBuffer.append("true  (DAB service does not contain any audio signal (DF 4.1)");
            } else {
                stringBuffer.append("false  (no DAB service or DAB service contains audio signal (DF 4.1)");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.ibocLiveTransmissionActive) {
                stringBuffer.append("true  (IBOC live transmission active (HD live mode)");
            } else {
                stringBuffer.append("false  (no IBOC live transmission or not applicable");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.dabServiceLinkedToFm) {
                stringBuffer.append("true  (DAB service linked to FM");
            } else {
                stringBuffer.append("false  (DAB service not linked to FM or not applicable");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(4);
            bitStream.pushBoolean(this.stationLinkedToOnlineRadio);
            bitStream.pushBoolean(this.dabServiceDoesNotContainAnyAudioSignal);
            bitStream.pushBoolean(this.ibocLiveTransmissionActive);
            bitStream.pushBoolean(this.dabServiceLinkedToFm);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(4);
            this.stationLinkedToOnlineRadio = bitStream.popFrontBoolean();
            this.dabServiceDoesNotContainAnyAudioSignal = bitStream.popFrontBoolean();
            this.ibocLiveTransmissionActive = bitStream.popFrontBoolean();
            this.dabServiceLinkedToFm = bitStream.popFrontBoolean();
        }
    }

    public static final class StationInfoSwitches
    implements BAPEntity {
        private static final int RESERVED_BIT_4__7_BITSIZE = 4;
        public boolean ibocHdRadioAvailable;
        public boolean vicsAvailable;
        public boolean tmcAvailable;
        public boolean taTpAvailable;
        private static final int STATION_INFO_SWITCHES_BITSIZE = 8;

        public StationInfoSwitches() {
            this.internalReset();
            this.customInitialization();
        }

        public StationInfoSwitches(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.ibocHdRadioAvailable = false;
            this.vicsAvailable = false;
            this.tmcAvailable = false;
            this.taTpAvailable = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            StationInfoSwitches stationInfoSwitches = (StationInfoSwitches)bAPEntity;
            return this.ibocHdRadioAvailable == stationInfoSwitches.ibocHdRadioAvailable && this.vicsAvailable == stationInfoSwitches.vicsAvailable && this.tmcAvailable == stationInfoSwitches.tmcAvailable && this.taTpAvailable == stationInfoSwitches.taTpAvailable;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("StationInfoSwitches:");
            stringBuffer.append("\n - Bit 3: ");
            if (this.ibocHdRadioAvailable) {
                stringBuffer.append("true  (IBOC/HD-radio available");
            } else {
                stringBuffer.append("false  (IBOC/HD-radio not available");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.vicsAvailable) {
                stringBuffer.append("true  (VICS available (JAPAN market only)");
            } else {
                stringBuffer.append("false  (VICS not available");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.tmcAvailable) {
                stringBuffer.append("true  (TMC available");
            } else {
                stringBuffer.append("false  (TMC not available");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.taTpAvailable) {
                stringBuffer.append("true  (TA / TP available");
            } else {
                stringBuffer.append("false  (TA / TP not available");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(4);
            bitStream.pushBoolean(this.ibocHdRadioAvailable);
            bitStream.pushBoolean(this.vicsAvailable);
            bitStream.pushBoolean(this.tmcAvailable);
            bitStream.pushBoolean(this.taTpAvailable);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(4);
            this.ibocHdRadioAvailable = bitStream.popFrontBoolean();
            this.vicsAvailable = bitStream.popFrontBoolean();
            this.tmcAvailable = bitStream.popFrontBoolean();
            this.taTpAvailable = bitStream.popFrontBoolean();
        }
    }
}

