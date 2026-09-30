/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.browser;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.browser.Bookmark;
import org.dsi.ifc.browser.ImportReport;
import org.dsi.ifc.browser.PathInfo;

public interface DSIBrowserBookmarkListener
extends DSIListener {
    public void listBookmarksResult(String var1, Bookmark[] var2, int var3);

    public void bookmarkListInvalid();

    public void addBookmarkResult(Bookmark var1, int var2);

    public void editBookmarkResult(Bookmark var1, int var2);

    public void deleteBookmarkResult(Bookmark var1, int var2);

    public void createFolderResult(Bookmark var1, int var2);

    public void deleteFolderResult(String var1, int var2);

    public void renameFolderResult(String var1, int var2);

    public void exportBookmarksResult(PathInfo var1, int var2);

    public void updateExportBookmarksProgress(PathInfo var1, int var2, int var3);

    public void importBookmarksResult(PathInfo var1, ImportReport var2, int var3);

    public void updateImportBookmarksProgress(PathInfo var1, int var2, int var3);

    public void getQuotaInformationResult(int var1, int var2, int var3);
}

