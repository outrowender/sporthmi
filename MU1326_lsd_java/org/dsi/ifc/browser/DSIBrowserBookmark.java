/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.browser;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.browser.Bookmark;
import org.dsi.ifc.browser.PathInfo;

public interface DSIBrowserBookmark
extends DSIBase {
    public static final String VERSION = "2.11.18";
    public static final int RT_LISTBOOKMARKS = 1000;
    public static final int RT_ADDBOOKMARK = 1001;
    public static final int RT_EDITBOOKMARK = 1002;
    public static final int RT_DELETEBOOKMARK = 1003;
    public static final int RT_CREATEFOLDER = 1004;
    public static final int RT_DELETEFOLDER = 1005;
    public static final int RT_RENAMEFOLDER = 1006;
    public static final int RT_EXPORTBOOKMARKS = 1007;
    public static final int RT_IMPORTBOOKMARKS = 1008;
    public static final int RT_GETQUOTAINFORMATION = 1009;
    public static final int ATTR_IMPORTBOOKMARKSPROGRESS = 1;
    public static final int ATTR_EXPORTBOOKMARKSPROGRESS = 2;
    public static final int RP_LISTBOOKMARKSRESULT = 2000;
    public static final int RP_ADDBOOKMARKRESULT = 2001;
    public static final int RP_EDITBOOKMARKRESULT = 2002;
    public static final int RP_DELETEBOOKMARKRESULT = 2003;
    public static final int RP_CREATEFOLDERRESULT = 2004;
    public static final int RP_DELETEFOLDERRESULT = 2005;
    public static final int RP_RENAMEFOLDERRESULT = 2006;
    public static final int RP_EXPORTBOOKMARKSRESULT = 2007;
    public static final int RP_IMPORTBOOKMARKSRESULT = 2008;
    public static final int RP_GETQUOTAINFORMATIONRESULT = 2009;
    public static final int IN_BOOKMARKLISTINVALID = 3000;

    public void listBookmarks(String var1);

    public void addBookmark(Bookmark var1);

    public void editBookmark(Bookmark var1, Bookmark var2);

    public void deleteBookmark(Bookmark var1);

    public void createFolder(Bookmark var1);

    public void deleteFolder(String var1);

    public void renameFolder(String var1, String var2);

    public void exportBookmarks(PathInfo var1);

    public void importBookmarks(PathInfo var1, boolean var2, boolean var3);

    public void getQuotaInformation();
}

