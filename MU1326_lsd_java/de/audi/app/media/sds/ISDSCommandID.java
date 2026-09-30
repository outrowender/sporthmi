/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

public interface ISDSCommandID {
    public static final int SDS_COMMAND_DATA_G2P_PLAY_TITLE = 10001;
    public static final int SDS_COMMAND_DATA_G2P_PLAY_ALBUM = 10002;
    public static final int SDS_COMMAND_DATA_G2P_PLAY_ARTIST = 10003;
    public static final int SDS_COMMAND_DATA_G2P_REQUEST_COVERART = 10004;
    public static final int SDS_COMMAND_DATA_G2P_PLAY_GENRE = 10005;
    public static final int SDS_COMMAND_DATA_G2P_PLAY_TITLE_OF_ALBUM = 10006;
    public static final int SDS_COMMAND_DATA_G2P_PLAY_TITLE_OF_ARTIST = 10007;
    public static final int SDS_COMMAND_DATA_G2P_PLAY_ALBUM_OF_ARTIST = 10008;
    public static final int SDS_COMMAND_DATA_G2P_PLAY_ALL_TRACKS = 10009;
    public static final int SDS_COMMAND_DATA_FOLDERUP = 20001;
    public static final int SDS_COMMAND_CDDA_SETTRACK = 20002;
    public static final int SDS_COMMAND_DATA_START_BROWSING = 20003;
    public static final int SDS_COMMAND_DATA_PLAY_MORELIKETHIS = 20005;
    public static final int SDS_COMMAND_REPEAT_TRACK = 20006;
    public static final int SDS_COMMAND_MIX = 20008;
    public static final int RET_FOLDERUP_FAILED_ROOT_LEVEL_REACHED = 21001;
    public static final int RET_FOLDERUP_FAILED_BROWSER_NOT_READY = 21002;
    public static final int RET_SUCCESSFUL = 11001;
    public static final int RET_ALREADY_SET = 11002;
    public static final int RET_FAILED = 11003;
    public static final int RET_NOT_SUPPORTED = 11004;
    public static final int RET_NOT_READY = 11005;
}

