/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.browser.Bookmark;
import org.dsi.ifc.browser.ImportReport;
import org.dsi.ifc.browser.PathInfo;

public interface DSIBrowserBookmarkReply {
    public static final String IPL_COMM_UUID = "86539966-2a35-53bb-8c25-e66e780f75eb";
    public static final String IPL_COMM_INTERFACE_KEY = "c2fe38b4-9c45-5465-b247-db69a6a5f0e2";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.18";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.18";

    public void listBookmarksResult(String var1, Bookmark[] var2, int var3) throws MethodException;

    public void bookmarkListInvalid() throws MethodException;

    public void addBookmarkResult(Bookmark var1, int var2) throws MethodException;

    public void editBookmarkResult(Bookmark var1, int var2) throws MethodException;

    public void deleteBookmarkResult(Bookmark var1, int var2) throws MethodException;

    public void createFolderResult(Bookmark var1, int var2) throws MethodException;

    public void deleteFolderResult(String var1, int var2) throws MethodException;

    public void renameFolderResult(String var1, int var2) throws MethodException;

    public void exportBookmarksResult(PathInfo var1, int var2) throws MethodException;

    public void updateExportBookmarksProgress(PathInfo var1, int var2, int var3) throws MethodException;

    public void importBookmarksResult(PathInfo var1, ImportReport var2, int var3) throws MethodException;

    public void updateImportBookmarksProgress(PathInfo var1, int var2, int var3) throws MethodException;

    public void getQuotaInformationResult(int var1, int var2, int var3) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

