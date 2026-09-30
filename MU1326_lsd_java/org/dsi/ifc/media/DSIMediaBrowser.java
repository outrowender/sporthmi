/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.media.ListEntry;

public interface DSIMediaBrowser
extends DSIBase {
    public static final String VERSION = "2.11.52";
    public static final int ATTR_BROWSEMODE = 1;
    public static final int ATTR_CONTENTFILTER = 2;
    public static final int ATTR_BROWSEMEDIA = 3;
    public static final int ATTR_BROWSEFOLDER = 4;
    public static final int ATTR_LISTSIZE = 5;
    public static final int ATTR_SEARCHSPELLERSTATE = 6;
    public static final int ATTR_SEARCHSIZE = 7;
    public static final int ATTR_ALPHABETICALINDEX = 8;
    public static final int RT_ENABLERECURSESUBDIRECTORIES = 1000;
    public static final int RT_ADDSELECTION = 1001;
    public static final int RT_UNDOLASTSELECTION = 1002;
    public static final int RT_RESETSELECTION = 1003;
    public static final int RT_SETCONTENTFILTER = 1004;
    public static final int RT_SETBROWSEMODE = 1005;
    public static final int RT_SETBROWSEMEDIA = 1006;
    public static final int RT_CHANGEFOLDER = 1007;
    public static final int RT_REQUESTLIST = 1008;
    public static final int RT_REQUESTPICKLIST = 1009;
    public static final int RT_ACTIVATESEARCHSPELLER = 1010;
    public static final int RT_DEACTIVATESEARCHSPELLER = 1011;
    public static final int RT_REQUESTSEARCHLIST = 1012;
    public static final int RT_SETSEARCHSTRING = 1013;
    public static final int RT_RESETSEARCHSTRING = 1014;
    public static final int RT_SELECTSEARCHRESULT = 1015;
    public static final int RT_SETSEARCHCRITERIA = 1016;
    public static final int RT_REQUESTSEARCHLISTEXT = 1017;
    public static final int RT_REQUESTFULLYQUALIFIEDNAME = 1018;
    public static final int RP_RESPONSELIST = 2000;
    public static final int RP_SELECTIONRESULT = 2001;
    public static final int RP_RESPONSEPICKLIST = 2002;
    public static final int RP_RESPONSESEARCHLIST = 2003;
    public static final int RP_RESPONSESETSEARCHSTRING = 2004;
    public static final int RP_RESPONSESELECTSEARCHRESULT = 2005;
    public static final int RP_RESPONSESETSEARCHCRITERIA = 2006;
    public static final int RP_RESPONSESEARCHLISTEXT = 2007;
    public static final int RP_RESPONSEFULLYQUALIFIEDNAME = 2008;
    public static final int BROWSERID_1 = 0;
    public static final int BROWSERID_2 = 1;
    public static final int BROWSERID_3 = 2;
    public static final int BROWSERID_4 = 3;
    public static final int BROWSERID_5 = 4;
    public static final int BROWSERID_6 = 5;
    public static final int BROWSERID_7 = 6;
    public static final int BROWSERID_RECORDER = 7;
    public static final int MEDIATAGTYPE_ALBUM = 1;
    public static final int MEDIATAGTYPE_GENRE = 2;
    public static final int MEDIATAGTYPE_ARTIST = 3;
    public static final int MEDIATAGTYPE_TITLE = 4;
    public static final int MEDIATAGTYPE_VIDEO = 5;
    public static final int MEDIATAGTYPE_FILENAME = 6;
    public static final int MEDIATAGTYPE_FOLDER = 7;
    public static final int LISTSIZEFLAG_NONE = 0;
    public static final int ENTRYFLAG_NOENTRIES = 1;
    public static final int ENTRYFLAG_DRM = 2;
    public static final int ENTRYFLAG_CORRUPT = 4;
    public static final int ENTRYFLAG_DEADLINK = 8;
    public static final int ENTRYFLAG_INTERNATIONALIZABLE = 16;
    public static final int ENTRYFLAG_SELECTED = 32;
    public static final int ENTRYFLAG_PARTLY_SELECTED = 64;
    public static final int ENTRYFLAG_IMPORT_RUNNING = 128;
    public static final int ENTRYFLAG_IMPORT_PENDING = 256;
    public static final int ENTRYFLAG_IMPORT_NOT_PLAYABLE = 512;
    public static final int ENTRYFLAG_ALREADY_IMPORTED = 1024;
    public static final int ENTRYFLAG_PARTLY_IMPORTED = 2048;
    public static final int ENTRYFLAG_FAVORITE = 4096;
    public static final int ENTRYFLAG_ONLINE = 8192;
    public static final int BROWSEMODE_RAW = 0;
    public static final int BROWSEMODE_CONTENT = 1;
    public static final int CONTENTTYPE_UNKNOWN = 0;
    public static final int CONTENTTYPE_AUDIO = 1;
    public static final int CONTENTTYPE_VIDEO = 2;
    public static final int CONTENTTYPE_IMAGE = 3;
    public static final int CONTENTTYPE_FOLDER = 4;
    public static final int CONTENTTYPE_PLAYLIST = 5;
    public static final int CONTENTTYPE_PLAYLIST_FOLDER = 6;
    public static final int CONTENTTYPE_AUDIO_FOLDER = 7;
    public static final int CONTENTTYPE_VIDEO_FOLDER = 8;
    public static final int CONTENTTYPE_IMAGE_FOLDER = 9;
    public static final int CONTENTTYPE_DYNAMIC_PLAYLIST = 10;
    public static final int CONTENTTYPE_PODCAST_FOLDER = 11;
    public static final int CONTENTTYPE_SELECTCONTROL = 12;
    public static final int CONTENTTYPE_ARTIST_FOLDER = 13;
    public static final int CONTENTTYPE_ALBUM_FOLDER = 14;
    public static final int CONTENTTYPE_TITLE_FOLDER = 15;
    public static final int CONTENTTYPE_GENRE_FOLDER = 16;
    public static final int CONTENTTYPE_COMPOSER_FOLDER = 17;
    public static final int CONTENTTYPE_AUDIOBOOK_FOLDER = 18;
    public static final int CONTENTTYPE_NOTPLAYABLE_FOLDER = 19;
    public static final int CONTENTTYPE_FAVORITE_FOLDER = 20;
    public static final int SELECTIONSTATE_NONE = 0;
    public static final int SELECTIONSTATE_ALL = 1;
    public static final int SELECTIONSTATE_PARTIAL = 2;
    public static final int SELECTIONRANGE_INDEX = 0;
    public static final int SELECTIONRANGE_ALL = 1;
    public static final int SELECTIONRESULT_OK = 0;
    public static final int SELECTIONRESULT_JUKEBOX_FULL = 1;
    public static final int SELECTIONRESULT_LIBRARY_DB_FULL = 2;
    public static final int SELECTIONRESULT_NOK = 3;
    public static final int SEARCHSPELLERCRITERIA_ALBUM = 1;
    public static final int SEARCHSPELLERCRITERIA_ARTIST = 2;
    public static final int SEARCHSPELLERCRITERIA_TITLE = 4;
    public static final int SEARCHSPELLERCRITERIA_FILENAME = 8;
    public static final int SEARCHSPELLERCRITERIA_FOLDER = 16;
    public static final int SEARCHSPELLERSTATE_UNKNOWN = 0;
    public static final int SEARCHSPELLERSTATE_SEARCHING = 1;
    public static final int SEARCHSPELLERSTATE_WAITING = 2;
    public static final int SEARCHSPELLERSTATE_SEARCHNOTPOSSIBLE = 3;
    public static final int CONTENTFILTER_AUDIO = 1;
    public static final int CONTENTFILTER_VIDEO = 2;
    public static final int CONTENTFILTER_PLAYLIST = 4;
    public static final int CONTENTFILTER_PICTURE = 8;

    public void setContentFilter(int var1);

    public void setBrowseMode(int var1);

    public void setBrowseMedia(long var1, long var3);

    public void changeFolder(ListEntry[] var1);

    public void requestList(long var1, int var3, int var4, int var5);

    public void requestPickList(long[] var1);

    public void enableRecurseSubdirectories(boolean var1);

    public void addSelection(boolean var1, int var2, long var3, int var5, boolean var6);

    public void undoLastSelection();

    public void resetSelection();

    public void setSearchString(String var1);

    public void setSearchCriteria(int var1);

    public void activateSearchSpeller();

    public void deactivateSearchSpeller();

    public void selectSearchResult(long var1);

    public void requestSearchList(long var1, int var3, int var4);

    public void resetSearchString();

    public void requestSearchListExt(long var1, int var3, int var4);

    public void requestFullyQualifiedName(long var1);
}

