/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.filebrowser;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.filebrowser.BrowsedFile;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIFileBrowser
extends DSIBase {
    public static final String VERSION = "2.11.9";
    public static final int FILETYPE_UNKNOWNFILE = 2;
    public static final int FILETYPE_FOLDER = 3;
    public static final int FILETYPE_AUDIO = 4;
    public static final int FILETYPE_VIDEO = 5;
    public static final int FILETYPE_IMAGE = 6;
    public static final int FILETYPE_VCARD = 7;
    public static final int FILETYPE_PLAYLIST = 8;
    public static final int SELECTIONTYPE_ALL = 0;
    public static final int SELECTIONTYPE_NONE = 1;
    public static final int SELECTIONTYPE_INVERT = 2;
    public static final int RESULTTYPE_OK = 0;
    public static final int RESULTTYPE_ERROR = 1;
    public static final int RESULTTYPE_ERROR_TOO_MANY_SELECTED_FILES = 2;
    public static final int FILETYPEFILTER_ALLFILES = 1;
    public static final int FILETYPEFILTER_FOLDER = 2;
    public static final int FILETYPEFILTER_AUDIO = 4;
    public static final int FILETYPEFILTER_VIDEO = 8;
    public static final int FILETYPEFILTER_IMAGE = 16;
    public static final int FILETYPEFILTER_VCARD = 32;
    public static final int FILETYPEFILTER_PLAYLIST = 64;
    public static final int RT_START = 1000;
    public static final int RT_STOP = 1001;
    public static final int RT_GETVIEWWINDOW = 1002;
    public static final int RT_GETSELECTEDFILES = 1003;
    public static final int RT_SETSELECTIONSINGLE = 1004;
    public static final int RT_SETSELECTION = 1005;
    public static final int RT_CHANGEFOLDER = 1006;
    public static final int RT_SETFILEEXTENSIONFILTER = 1007;
    public static final int RT_SETFILETYPEFILTER = 1008;
    public static final int RT_SETLANGUAGE = 1009;
    public static final int RT_ADDSPELLERCHARS = 1010;
    public static final int RT_STARTSPELLER = 1011;
    public static final int RT_REMOVESPELLERCHAR = 1012;
    public static final int RT_STOPSPELLER = 1013;
    public static final int RT_GETRESOURCELOCATORS = 1014;
    public static final int RT_GETFILECOUNT = 1015;
    public static final int RT_GETRESOURCELOCATORWINDOW = 1016;
    public static final int RT_SETFILETYPEACTIVE = 1017;
    public static final int RT_GETVIEWWINDOWFROMFILE = 1018;
    public static final int RT_GETFILECOUNTWITHFILETYPEFILTER = 1019;
    public static final int RT_VALIDATESPELLERCHARS = 1020;
    public static final int RT_GETVIEWWINDOWWITHPREVIEWS = 1021;
    public static final int RT_DELETEALLPREVIEWFILES = 1022;
    public static final int RT_CREATEPREVIEWIMAGE = 1023;
    public static final int RT_CANCELPREVIEWCREATION = 1024;
    public static final int RP_STARTRESULT = 2000;
    public static final int RP_GETVIEWWINDOWRESULT = 2001;
    public static final int RP_GETSELECTEDFILESRESULT = 2002;
    public static final int RP_CHANGEFOLDERRESULT = 2003;
    public static final int RP_SPELLERRESULT = 2004;
    public static final int RP_GETRESOURCELOCATORSRESULT = 2005;
    public static final int RP_GETFILECOUNTRESULT = 2006;
    public static final int RP_SETFILEEXTENSIONFILTERRESULT = 2007;
    public static final int RP_SETFILETYPEFILTERRESULT = 2008;
    public static final int RP_GETRESOURCELOCATORWINDOWRESULT = 2009;
    public static final int RP_SETLANGUAGERESULT = 2010;
    public static final int RP_SETFILETYPEACTIVERESULT = 2011;
    public static final int RP_GETFILECOUNTWITHFILETYPEFILTERRESULT = 2012;
    public static final int RP_VALIDATESPELLERCHARSRESULT = 2013;
    public static final int RP_GETVIEWWINDOWWITHPREVIEWSRESULT = 2014;
    public static final int RP_CREATEPREVIEWIMAGERESULT = 2015;
    public static final int RP_CANCELPREVIEWCREATIONRESULT = 2016;
    public static final int IN_INDICATESELECTIONRESULT = 3000;

    public void start(Path var1);

    public void setFileExtensionFilter(int var1, String[] var2);

    public void setFileTypeFilter(int var1, int var2);

    public void stop(int var1);

    public void getViewWindow(int var1, int var2, int var3);

    public void getViewWindowWithPreviews(int var1, int var2, int var3);

    public void getViewWindowFromFile(int var1, int var2, BrowsedFile var3, int var4);

    public void getResourceLocatorWindow(int var1, int var2, int var3);

    public void getSelectedFiles(int var1);

    public void getResourceLocators(int var1, BrowsedFileSet var2);

    public void getFileCount(int var1);

    public void getFileCountWithFileTypeFilter(int var1, int var2);

    public void setSelectionSingle(int var1, BrowsedFile var2, boolean var3);

    public void setSelection(int var1, int var2);

    public void changeFolder(int var1, Path var2);

    public void setLanguage(String var1);

    public void startSpeller(int var1, int var2);

    public void addSpellerChars(int var1, String var2);

    public void removeSpellerChar(int var1);

    public void stopSpeller(int var1);

    public void setFileTypeActive(boolean var1);

    public void validateSpellerChars(int var1, String var2);

    public void deleteAllPreviewFiles();

    public void createPreviewImage(ResourceLocator var1, int var2, int var3);

    public void cancelPreviewCreation();
}

