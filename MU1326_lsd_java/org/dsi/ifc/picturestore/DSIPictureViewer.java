/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.picturestore;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIPictureViewer
extends DSIBase {
    public static final String VERSION = "2.11.11";
    public static final int ATTR_VIEWERSTATE = 1;
    public static final int ATTR_SCROLLMODE = 2;
    public static final int ATTR_LISTPOSITION = 3;
    public static final int ATTR_NUMENTRIES = 4;
    public static final int ATTR_NUMSELECTEDENTRIES = 5;
    public static final int PICTUREVIEWERRESULT_OK = 0;
    public static final int PICTUREVIEWERRESULT_ERROR = 1;
    public static final int VIEWERMODE_PICTURESTORE = 0;
    public static final int VIEWERMODE_FILEBROWSER = 1;
    public static final int SELECTIONMODE_OFF = 0;
    public static final int SELECTIONMODE_SINGLE = 1;
    public static final int SELECTIONMODE_MULTI = 2;
    public static final int FILETYPE_UNKNOWNFILE = 0;
    public static final int FILETYPE_FOLDER = 1;
    public static final int FILETYPE_IMAGE = 2;
    public static final int SCROLLMODE_SCROLLMODE_NORMAL = 0;
    public static final int SCROLLMODE_SCROLLMODE_FAST = 1;
    public static final int VIEWERSTATE_STATE_UNKNOWN = 0;
    public static final int VIEWERSTATE_STATE_INITIALIZED = 1;
    public static final int VIEWERSTATE_STATE_ACTIVE = 2;
    public static final int VIEWERSTATE_STATE_SCROLLING = 3;
    public static final int VIEWERSTATE_STATE_SELECTING = 4;
    public static final int VIEWERSTATE_STATE_ANIMATION_CENTERVIEW = 5;
    public static final int VIEWERSTATE_STATE_ANIMATION_SIDEVIEW = 6;
    public static final int ANIMATIONTYPE_CENTERVIEW = 0;
    public static final int ANIMATIONTYPE_SIDEVIEW = 1;
    public static final int ANIMATIONMODE_ANIMATIONMODE_STILL = 0;
    public static final int ANIMATIONMODE_ANIMATIONMODE_ANIMATE = 1;
    public static final int IMPORTFILTER_IMPORT_SOURCE_UNDEFINED = 1;
    public static final int IMPORTFILTER_IMPORT_SOURCE_USB = 2;
    public static final int IMPORTFILTER_IMPORT_SOURCE_SDCARD = 4;
    public static final int IMPORTFILTER_IMPORT_SOURCE_ONLINE = 8;
    public static final int VIEWFILTER_DATETYPE_IMPORTDATE = 0;
    public static final int VIEWFILTER_DATETYPE_CREATIONDATE = 1;
    public static final int SORTING_IMPORTDATE_ASCENDING = 0;
    public static final int SORTING_IMPORTDATE_DESCENDING = 1;
    public static final int RT_INITIALIZEVIEWER = 1001;
    public static final int RT_DEINITIALIZEVIEWER = 1002;
    public static final int RT_SETSELECTIONMODE = 1003;
    public static final int RT_STARTRENDERING = 1004;
    public static final int RT_STOPRENDERING = 1005;
    public static final int RT_SETSCROLLMODE = 1006;
    public static final int RT_SCROLLTICKS = 1007;
    public static final int RT_MOVEFOCUS = 1008;
    public static final int RT_GETPICTUREINFO = 1009;
    public static final int RT_CHANGEFOLDER = 1010;
    public static final int RT_TOGGLEPICTURESELECTION = 1011;
    public static final int RT_TOGGLEALLPICTURESSELECTION = 1012;
    public static final int RT_CLEARALLPICTURESSELECTION = 1013;
    public static final int RT_TRIGGERANIMATION = 1014;
    public static final int RT_SETFILTERSETID = 1015;
    public static final int RT_MOVEFOCUSBYRESOURCELOCATOR = 1026;
    public static final int RT_SETSORTINGDIRECTION = 1027;
    public static final int RP_GETPICTUREINFORESULT = 2000;
    public static final int RP_SELECTIONRESULT = 2001;
    public static final int RP_CREATEFILTERSETRESULT = 2002;
    public static final int RP_DELETEFILTERSETRESULT = 2003;
    public static final int RP_CHANGEDFILTERSETRESULT = 2004;
    public static final int RP_GETAVAILABLEYEARSRESULT = 2005;
    public static final int RP_GETAVAILABLEMONTHSRESULT = 2006;
    public static final int RP_LISTFORCONTEXTWITHFILTERRESULT = 2007;
    public static final int RP_DELETEPICTURESWITHFILTERSETRESULT = 2008;

    public void initializeViewer(int var1, int var2);

    public void deinitializeViewer();

    public void setSelectionMode(int var1);

    public void startRendering();

    public void stopRendering();

    public void setScrollMode(int var1);

    public void scrollTicks(long var1);

    public void moveFocus(long var1, int var3);

    public void getPictureInfo(long var1);

    public void changeFolder(long var1);

    public void togglePictureSelection(long var1);

    public void toggleAllPicturesSelection();

    public void clearAllPicturesSelection();

    public void triggerAnimation(int var1, long var2);

    public void setFilterSetId(int var1);

    public void moveFocusByResourceLocator(ResourceLocator var1, int var2);

    public void setSortingDirection(int var1);
}

