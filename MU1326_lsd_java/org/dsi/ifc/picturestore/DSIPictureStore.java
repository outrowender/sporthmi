/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.picturestore;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIPictureStore
extends DSIBase {
    public static final String VERSION = "2.11.11";
    public static final int IN_INVALIDDATA = 3000;
    public static final int RP_IMPORTPICTURERESULT = 2000;
    public static final int RP_PICTUREEXISTS = 2001;
    public static final int RP_FREESLOTS = 2002;
    public static final int RP_GETREFERENCESRESULT = 2003;
    public static final int RP_DELETEDPICTURES = 2004;
    public static final int RP_RESPONSELRUPICTURES = 2005;
    public static final int RP_LISTRESULT = 2006;
    public static final int RP_LISTFORCONTEXTRESULT = 2007;
    public static final int RP_GETPICTUREATTRIBUTESRESULT = 2008;
    public static final int RP_LISTFORCONTEXTWITHFILTERRESULT = 2009;
    public static final int RP_IMPORTPICTUREFROMSOURCERESULT = 2010;
    public static final int RP_GETRECTANGLEPICTURESGRIDRESULT = 2011;
    public static final int RP_GETAVAILABLEYEARSRESULT = 2012;
    public static final int RP_GETAVAILABLEMONTHSRESULT = 2013;
    public static final int RP_CREATEFILTERSETRESULT = 2014;
    public static final int RP_CLONEFILTERSETRESULT = 2015;
    public static final int RP_RESETTOFACTORYSETTINGSRESULT = 2016;
    public static final int RP_GETAVAILABLEFOLDERSRESULT = 2017;
    public static final int RP_COUNTPICTURESINCONTEXTRESULT = 2018;
    public static final int RP_LISTFORCONTEXTWITHFILTERSORTDISTRESULT = 2019;
    public static final int RT_IMPORTPICTURE = 1000;
    public static final int RT_PICTUREEXISTS = 1001;
    public static final int RT_INCREASEREFCOUNTER = 1002;
    public static final int RT_DECREASEREFCOUNTER = 1003;
    public static final int RT_SETCONFIG = 1004;
    public static final int RT_GETFREESLOTS = 1005;
    public static final int RT_GETREFERENCES = 1006;
    public static final int RT_DELETEALLPICTURES = 1007;
    public static final int RT_DELETEPICTURESFROMCONTEXT = 1008;
    public static final int RT_DELETEPICTURES = 1009;
    public static final int RT_GETLRUPICTURES = 1010;
    public static final int RT_LISTINALLCONTEXTS = 1011;
    public static final int RT_LISTINCONTEXT = 1012;
    public static final int RT_GETPICTUREATTRIBUTES = 1013;
    public static final int RT_CLONEFILTERSET = 1014;
    public static final int RT_CREATEFILTERSET = 1015;
    public static final int RT_DELETEFILTERSET = 1016;
    public static final int RT_DELETEPICTURESWITHFILTERSET = 1017;
    public static final int RT_GETAVAILABLEMONTHS = 1018;
    public static final int RT_GETAVAILABLEYEARS = 1019;
    public static final int RT_GETRECTANGLEPICTURESGRID = 1020;
    public static final int RT_IMPORTPICTUREFROMSOURCE = 1021;
    public static final int RT_LISTINCONTEXTWITHFILTER = 1022;
    public static final int RT_SETCONFIGWITHFILETYPE = 1023;
    public static final int RT_SETFILTERGEOAREA = 1024;
    public static final int RT_SETFILTERIMPORTSOURCE = 1025;
    public static final int RT_SETFILTERTIMEINTERVAL = 1026;
    public static final int RT_RESETTOFACTORYSETTINGS = 1027;
    public static final int RT_GETAVAILABLEFOLDERS = 1028;
    public static final int RT_SETFILTERFOLDERNAME = 1029;
    public static final int RT_COUNTPICTURESINCONTEXT = 1030;
    public static final int RT_LISTINCONTEXTWITHFILTERSORTDIST = 1031;
    public static final int IMPORTRESULT_SUCCESS = 0;
    public static final int IMPORTRESULT_NOSLOTAVAILABLE = 1;
    public static final int IMPORTRESULT_IOERROR = 2;
    public static final int IMPORTRESULT_PICTURENOTFOUND = 3;
    public static final int IMPORTRESULT_INTERNALERROR = 4;
    public static final int IMPORTRESULT_WRONG_PARAMETER = 5;
    public static final int IMPORTSOURCE_UNDEFINED = 1;
    public static final int IMPORTSOURCE_USB = 2;
    public static final int IMPORTSOURCE_SDCARD = 4;
    public static final int IMPORTSOURCE_ONLINE = 8;
    public static final int IMPORTSOURCE_STREETVIEW = 16;
    public static final int IMPORTSOURCE_CD = 32;
    public static final int IMPORTSOURCE_DVD = 64;
    public static final int TIMEINTERVALFILTERTYPE_CREATED_ON = 1;
    public static final int TIMEINTERVALFILTERTYPE_IMPORTED_ON = 2;
    public static final int FILETYPE_DEFAULT = 0;
    public static final int FILETYPE_PNG = 1;
    public static final int FILETYPE_JPEG = 2;
    public static final int FILTERSETID_EMPTY = -1;
    public static final int INVALIDDATATYPE_UNSPECIFIC = 0;
    public static final int INVALIDDATATYPE_STARTED = 1;
    public static final int INVALIDDATATYPE_RESET = 2;
    public static final int INVALIDDATATYPE_PICS_CHANGED = 3;

    public void setConfig(int var1, int var2, int var3, int var4);

    public void importPicture(int var1, ResourceLocator var2, boolean var3);

    public void pictureExists(ResourceLocator var1);

    public void increaseRefCounter(ResourceLocator var1, int var2);

    public void decreaseRefCounter(ResourceLocator var1, int var2);

    public void getFreeSlots(int var1);

    public void getReferences(ResourceLocator var1);

    public void deleteAllPictures(int var1, boolean var2);

    public void deletePicturesFromContext(int var1, ResourceLocator[] var2, boolean var3);

    public void deletePictures(ResourceLocator[] var1, boolean var2);

    public void getLRUPictures(int var1, boolean var2, int var3);

    public void listInAllContexts(int var1, int var2);

    public void listInContext(int var1, int var2, int var3);

    public void getPictureAttributes(ResourceLocator var1);

    public void setConfigWithFileType(int var1, int var2, int var3, int var4, int var5);

    public void importPictureFromSource(int var1, ResourceLocator var2, boolean var3, int var4, String var5);

    public void deletePicturesWithFilterSet(int var1, int var2, boolean var3);

    public void listInContextWithFilter(int var1, int var2, int var3, int var4);

    public void listInContextWithFilterSortDist(int var1, int var2, int var3, int var4, float var5, float var6);

    public void getRectanglePicturesGrid(int var1, int var2, float var3, float var4, float var5, float var6, int var7, int var8, int var9);

    public void getAvailableYears(int var1, int var2);

    public void getAvailableMonths(int var1, int var2, int var3);

    public void createFilterSet();

    public void cloneFilterSet(int var1);

    public void deleteFilterSet(int var1);

    public void setFilterImportSource(int var1, int var2);

    public void setFilterTimeInterval(int var1, int var2, long var3, long var5);

    public void setFilterGeoArea(int var1, float var2, float var3, float var4, float var5);

    public void resetToFactorySettings();

    public void getAvailableFolders(int var1);

    public void setFilterFolderName(int var1, String var2);

    public void countPicturesInContext(int var1, int var2);
}

